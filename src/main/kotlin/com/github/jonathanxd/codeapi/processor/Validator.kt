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
import java.util.Collections

/**
 * Validation and Validation manager. Validates and manage custom validators.
 */
interface CodeValidator {

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
inline fun <reified P> CodeValidator.registerValidator(validator: Validator<P>) =
        this.registerValidator(validator, P::class.java)

/**
 * Validates [part] of type [P].
 */
inline fun <reified P> CodeValidator.validatePart(part: P, data: TypedData) =
        this.validate(P::class.java, part, data)

/**
 * Custom validator
 */
interface Validator<in P> {

    /**
     * Validates [part] and return a list of messages.
     */
    fun validate(part: P, data: TypedData, codeValidator: CodeValidator, environment: ValidationEnvironment)

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
     * Immutable view list of current context (LIFO stack)
     *
     * ATM we will not use IUtils context...
     */
    val context: List<Any>

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

        private val inspectionContext = mutableListOf<Any>()
        private val backingList = mutableListOf<ContextedValidationMessage>()
        override val context: List<Any> = Collections.unmodifiableList(this.inspectionContext)
        override val validationMessages: List<ContextedValidationMessage> = Collections.unmodifiableList(this.backingList)

        override fun addMessage(message: ValidationMessage) {
            this.backingList += ContextedValidationMessage(message, this.context.toList())
        }

        override fun enterInspectionOf(part: Any) {
            this.inspectionContext.add(part)
        }

        override fun exitInspectionOf(part: Any) {

            if(this.inspectionContext.isEmpty())
                fail(part, {"Empty inspection context"})

            this.inspectionContext.last().let { last ->
                if (last != part)
                fail(part, { "Mismatch context. Expected last element: $part. Found: $last, in context: ${this.inspectionContext}" })
            }

            check(this.inspectionContext.removeAt(this.inspectionContext.lastIndex) == part)

        }

        private inline fun fail(part: Any, message: () -> String): Nothing = throw UnexpectedInspectionContext("Failed to exit inspection of element $part: ${message()}.")

    }
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
data class ContextedValidationMessage(val message: ValidationMessage, val context: List<Any>)

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
 * **Only a void implementation**, this class does not validate, does not register validators,
 * this class does nothing, literally.
 */
object VoidValidator : CodeValidator {

    override fun <P> validate(type: Class<out P>, part: P, data: TypedData, environment: ValidationEnvironment?): ValidationEnvironment {
        val ext = data
        return object : ValidationEnvironment {
            override val data: TypedData
                get() = ext

            override val context: List<Any> = emptyList()
            override val validationMessages: List<ContextedValidationMessage> = emptyList()

            override fun enterInspectionOf(part: Any) {
            }

            override fun exitInspectionOf(part: Any) {
            }

            override fun addMessage(message: ValidationMessage) {
            }

        }
    }

    override fun <P> registerValidator(validator: Validator<P>, type: Class<P>) {
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