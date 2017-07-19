/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.jonathanxd.codeapi.processor

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.iutils.data.TypedData
import com.github.jonathanxd.iutils.processing.Context
import java.util.*

/**
 * Manages all [Validators][Validator] used to validate [part][Any].
 */
interface ValidatorManager {

    /**
     * Validates [part] and return environment used to validate.
     */
    fun validate(part: Any, data: TypedData, environment: ValidationEnvironment? = null): ValidationEnvironment
            = this.validate(part::class.java, part, data, environment)

    /**
     * Validates [part] of type [type] and return environment used to validate.
     */
    fun <P> validate(type: Class<out P>, part: P, data: TypedData, environment: ValidationEnvironment? = null): ValidationEnvironment

    /**
     * Registers a custom [validator] of [CodePart] of [type].
     */
    fun <P> registerValidator(validator: Validator<P>, type: Class<P>)

    /**
     * Creates default [TypedData] instance.
     */
    fun createData(): TypedData = TypedData()

    /**
     * Creates default [ValidationEnvironment]
     */
    fun createEnvironment(data: TypedData): ValidationEnvironment = ValidationEnvironment.Impl(data)
}

/**
 * Registers a custom [validator] of [CodePart] of type [P].
 */
inline fun <reified P> ValidatorManager.registerValidator(validator: Validator<P>) =
        this.registerValidator(validator, P::class.java)

/**
 * Validates [part] of type [P].
 */
inline fun <reified P> ValidatorManager.validatePart(part: P, data: TypedData) =
        this.validate(P::class.java, part, data)

/**
 * Custom validator
 */
interface Validator<in P> {

    /**
     * Validates [part] and return a list of messages.
     */
    fun validate(part: P, data: TypedData, codeValidator: ValidatorManager, environment: ValidationEnvironment)

}

/**
 * Validation environment to index [ValidationMessages][ValidationMessage].
 */
interface ValidationEnvironment {

    /**
     * Data
     */
    val data: TypedData

    /**
     * Immutable view list of indexed contexted validation messages.
     */
    val validationMessages: List<ContextedValidationMessage>

    /**
     * Current context.
     */
    val context: Context

    /**
     * Enters a session, a session is used to keep track about all messages
     * added after [enterSession] invocation.
     *
     * This is used to analyze messages of other validation processes without needing to rely
     * on list size and sub-list, a new session keeps track of messages
     * added after the invocation of this method and before the invocation of [exitSession],
     * but the list of messages does not have any relation with the list holden by [ValidationEnvironment],
     * values are added simultaneously to session and [ValidationEnvironment].
     *
     * The list provided by session is mutable.
     *
     * Returns new session.
     */
    fun enterSession(): Session

    /**
     * Exists current session.
     *
     * Returns exited session.
     */
    fun exitSession(): Session

    /**
     * Adds a [ValidationMessage] to index.
     */
    fun addMessage(message: ValidationMessage)

    /**
     * Adds [part] to inspection context
     */
    fun enterInspectionOf(part: Any)

    /**
     * Exits the inspection of [part]. This method may throw [UnexpectedInspectionContext], if
     * the last value of inspection context is not [Any.equals] to [part].
     */
    fun exitInspectionOf(part: Any)

    /**
     * Common implementation of [ValidationEnvironment]
     */
    class Impl(override val data: TypedData) : ValidationEnvironment {

        private val backingList = mutableListOf<ContextedValidationMessage>()
        override val context: Context = Context.create()
        override val validationMessages: List<ContextedValidationMessage> = Collections.unmodifiableList(this.backingList)
        private var currentSession: Session? = null

        override fun addMessage(message: ValidationMessage) {
            val msg = ContextedValidationMessage(message, this.context.current())
            this.backingList += msg
            this.currentSession?.addMessage(msg)
        }

        override fun enterSession(): Session {
            val sec = Session(this.currentSession, this.context.current())

            this.currentSession = sec
            return sec
        }

        override fun exitSession(): Session {
            val sc = this.currentSession ?: throw IllegalStateException("Current section is null")

            this.currentSession = sc.parent

            return sc
        }

        override fun enterInspectionOf(part: Any) {
            context.enterContext(part)
        }

        override fun exitInspectionOf(part: Any) {
            context.exitContext(part)
        }

        override fun toString(): String = "[messages={${validationMessages.joinToString()},context=$context]"
    }

    /**
     * A session, used to keep track of a fragment of messages added by other validations.
     *
     * @see [enterSession]
     */
    class Session(internal val parent: Session?,
                  val context: Context) {
        private val messageList: MutableList<ContextedValidationMessage> = mutableListOf()
        val messages: List<ContextedValidationMessage> get() = messageList

        fun addMessage(message: ContextedValidationMessage) {
            this.parent?.addMessage(message)
            this.messageList.add(message)
        }

        fun anyError() = messages.hasContextedError()
    }
}

/**
 * Creates session to be used only within [context], this session is exited immediately after [context] invocation.
 */
inline fun <R> ValidationEnvironment.sessionInContext(context: (session: ValidationEnvironment.Session) -> R) =
        this.enterSession().let(context).also {
            this.exitSession()
        }

/**
 * Immediately enters the inspection of [part], calls [context] and then immediately exits the inspection of [part].
 */
inline fun <P, R> ValidationEnvironment.inspectionInContext(part: P, context: (part: P) -> R) =
        this.enterInspectionOf(part as Any).let {
            context(part).also { this.exitInspectionOf(part) }
        }

/**
 * Occurs when a unexpected inspection context is found.
 */
class UnexpectedInspectionContext : IllegalStateException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
    constructor(message: String, cause: Throwable) : super(message, cause)
}

/**
 * Validation message with a [context].
 *
 * @property message Validation message
 * @property context Message context.
 */
data class ContextedValidationMessage(val message: ValidationMessage, val context: Context)

/**
 * Validation message.
 *
 * @property message Message.
 * @property type Type of the message.
 */
data class ValidationMessage(val message: String, val type: Type) {

    enum class Type {

        /**
         * Errors in part.
         */
        ERROR,

        /**
         * Warnings: things that can be improved, things that may fail, etc...
         */
        WARNING,

        /**
         * Performance issues found in the part.
         */
        PERFORMANCE,

        /**
         * Information
         */
        INFO,

        /**
         * Other type
         */
        OTHER
    }
}

/**
 * Returns true if receiver has any [ValidationMessage] of [type][ValidationMessage.type] [ValidationMessage.Type.ERROR].
 */
fun List<ValidationMessage>.hasError() = this.any { it.type == ValidationMessage.Type.ERROR }

/**
 * Returns true if receiver has any [ValidationMessage] of [type][ValidationMessage.type] [ValidationMessage.Type.ERROR].
 */
fun List<ContextedValidationMessage>.hasContextedError() = this.any { it.message.type == ValidationMessage.Type.ERROR }

/**
 * Creates a string representation of the [ValidationMessage]
 */
fun ValidationMessage.toMessage(): String =
        "ValidationMessage[${this.type.name}]: ${this.message}"

/**
 * Creates a string representation of the [ContextedValidationMessage]
 */
fun ContextedValidationMessage.toMessage(): String =
        "ContextedValidationMessage[${this.message.type.name}]: ${this.message.message}. Context: ${this.context}"

/**
 * Prints messages registered in [ValidationEnvironment].
 */
fun ValidationEnvironment.printMessages(printer: (String) -> Unit, includeStack: Boolean = false) {
    this.validationMessages.forEach { (message, context) ->
        printer(message.toMessage())
        printer("Contexts:{")
        context.printContext(printer, false, true, includeStack)
        printer("}")
    }
}

/**
 * **Only a void implementation**, this class does nothing, literally.
 */
object VoidValidatorManager : ValidatorManager {

    override fun <P> validate(type: Class<out P>, part: P, data: TypedData, environment: ValidationEnvironment?): ValidationEnvironment {
        val ext = data
        return object : ValidationEnvironment {

            override val data: TypedData
                get() = ext

            override fun enterSession(): ValidationEnvironment.Session =
                    ValidationEnvironment.Session(null, this.context.current())

            override fun exitSession(): ValidationEnvironment.Session =
                    ValidationEnvironment.Session(null, this.context.current())

            override val context: Context = Context.create()
            override val validationMessages: List<ContextedValidationMessage> = emptyList()

            override fun enterInspectionOf(@Suppress("NAME_SHADOWING") part: Any) {
            }

            override fun exitInspectionOf(@Suppress("NAME_SHADOWING") part: Any) {
            }

            override fun addMessage(message: ValidationMessage) {
            }

        }
    }

    override fun <P> registerValidator(validator: Validator<P>, type: Class<P>) {
    }

}

/**
 * Validator manager backed by an [MutableMap].
 */
abstract class AbstractValidatorManager : ValidatorManager {
    private val map = mutableMapOf<Class<*>, Validator<*>>()

    override fun <P> registerValidator(validator: Validator<P>, type: Class<P>) {
        this.map[type] = validator
    }

    override fun <P> validate(type: Class<out P>, part: P, data: TypedData, environment: ValidationEnvironment?): ValidationEnvironment {
        val env = environment ?: createEnvironment(data)
        this.getValidatorOf(type, part, data, env)
                .validate(part, data, this, env)
        return env
    }

    /**
     * Gets processor of [type].
     */
    fun <P> getValidatorOf(type: Class<*>, part: P, data: TypedData, environment: ValidationEnvironment): Validator<P> {
        val searchType = if (this.map.containsKey(type))
            type
        else if (type.superclass != Any::class.java && type.interfaces.isEmpty())
            type.superclass
        else if (type.interfaces.size == 1)
            type.interfaces.single()
        else type

        @Suppress("UNCHECKED_CAST")
        return this.map[searchType] as? Validator<P>
                ?: throw IllegalArgumentException("Cannot find validator of type '$type' (searchType: '$searchType') and part '$part'. Data: {$data}. Environment: {$environment}")
    }

}

/**
 * Creates a error validation message.
 */
inline fun error(message: () -> String) = ValidationMessage(message(), ValidationMessage.Type.ERROR)

/**
 * Creates a warning validation message.
 */
inline fun warning(message: () -> String) = ValidationMessage(message(), ValidationMessage.Type.WARNING)

/**
 * Creates a info validation message.
 */
inline fun info(message: () -> String) = ValidationMessage(message(), ValidationMessage.Type.INFO)

/**
 * Creates a other validation message.
 */
inline fun other(message: () -> String) = ValidationMessage(message(), ValidationMessage.Type.OTHER)

/**
 * Creates a performance validation message.
 */
inline fun performance(message: () -> String) = ValidationMessage(message(), ValidationMessage.Type.PERFORMANCE)