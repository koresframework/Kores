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
import com.github.jonathanxd.codeapi.exception.ValidationException
import com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor
import com.github.jonathanxd.codeapi.util.typedKeyOf
import com.github.jonathanxd.iutils.data.TypedData
import com.github.jonathanxd.iutils.option.Option
import com.github.jonathanxd.iutils.option.Options

/**
 * ProcessorManager manages all processors required to transform [Any] into [R].
 *
 * Supported types depends on implementation.
 */
interface ProcessorManager<out R> {

    /**
     * Options of generator
     */
    val options: Options

    /**
     * Validator.
     */
    val validatorManager: ValidatorManager

    /**
     * Process [part] and returns a value of type [R].
     */
    fun process(part: Any) = this.process(part, createData())

    /**
     * Process [part] and returns a value of type [R].
     */
    fun <T> process(type: Class<T>, part: T) = this.process(type, part, createData())

    /**
     * Process [part] with [data] and returns a value of type [R].
     */
    fun process(part: Any, data: TypedData) = this.process(part::class.java, part, data)

    /**
     * Process [part] of type [type] with [data] and returns a value of type [R].
     */
    fun <T> process(type: Class<out T>, part: T, data: TypedData): R

    /**
     * Creates [TypedData] object.
     */
    fun createData(): TypedData

    /**
     * Registers [processor] of [CodePart] of type: [type].
     *
     * **Obs: registering a processor for a type that already have one does not means that the default
     * processor will be replaced.**
     */
    fun <T> registerProcessor(processor: Processor<T>, type: Class<T>)

    /**
     * Registers a [sugarSyntaxProcessor] of [CodePart] of type: [type].
     */
    fun <T> registerSugarSyntaxProcessor(sugarSyntaxProcessor: SugarSyntaxProcessor<T>, type: Class<T>)
}

/**
 * Process [part][P] and do required things.
 */
interface Processor<in P> {

    /**
     * Process the [part].
     */
    fun process(part: P, data: TypedData, codeProcessor: ProcessorManager<*>)

    /**
     * Called when the process to [part] finishes.
     */
    fun endProcess(part: P, data: TypedData, codeProcessor: ProcessorManager<*>) {

    }
}

/**
 * True to validate part before processing.
 */
@JvmField
val VALIDATE = Option(false)

/**
 * Stores call state
 */
@JvmField
val FIRST_CALL = typedKeyOf<Boolean>("FIRS_CALL")

/**
 * An abstract manager backed by a [MutableMap].
 *
 * You can enable validation via [VALIDATE] option.
 */
abstract class AbstractProcessorManager<out R> : ProcessorManager<R> {

    protected val map = mutableMapOf<Class<*>, Processor<*>>()

    inline fun <reified T> registerProcessorOfTypes(processor: Processor<T>, types: Array<Class<out T>>) {
        types.forEach {
            registerProcessor(processor, it)
        }
    }

    override fun <T> registerProcessor(processor: Processor<T>, type: Class<T>) {
        this.map[type] = processor
    }

    override fun <T> registerSugarSyntaxProcessor(sugarSyntaxProcessor: SugarSyntaxProcessor<T>, type: Class<T>) {
        this.map[type] = object : Processor<T> {
            override fun process(part: T, data: TypedData, codeProcessor: ProcessorManager<*>) {
                val result = sugarSyntaxProcessor.process(part, codeProcessor)
                codeProcessor.process(result, data)
            }
        }
    }

    override fun <T> process(type: Class<out T>, part: T, data: TypedData): R {

        if(options[VALIDATE] && !FIRST_CALL.getOrSet(data, false)) {
            val validationEnvironment = this.validatorManager.validate(type, part,
                    this.validatorManager.createData(), null)

            val validate = validationEnvironment.validationMessages

            if (validate.hasContextedError()) {
                var e: ValidationException? = null

                for (validationMessage in validate) {
                    val ex = ValidationException(validationMessage)

                    if (e == null)
                        e = ex
                    else
                        e.addSuppressed(ex)
                }

                if (e != null) {
                    this.printFailMessage("Validation failed, context:")
                    validationEnvironment.printMessages(this::printFailMessage, true)
                    this.printFailMessage("Validation failed, exception:")
                    throw ValidationException("Validation failed!", e)
                }
            }
        }

        FIRST_CALL.set(data, true)

        val processor = getProcessorOf(type, part, data)

        try {
            processor.process(part, data, this)
        } catch (t: Throwable) {
            t.addSuppressed(IllegalStateException("Failed to process part '$part' with type '${type.simpleName}' during 'process' phase. Data map: '${data.typedDataMap}'"))
            throw t
        }

        try {
            processor.endProcess(part, data, this)
        } catch (t: Throwable) {
            t.addSuppressed(IllegalStateException("Failed to process part '$part' with type '${type.simpleName}' during 'endProcess' phase. Data map: '${data.typedDataMap}'"))
            throw t
        }

        return this.getFinalValue(data)
    }

    /**
     * Print fail message to output.
     */
    protected abstract fun printFailMessage(message: String)

    /**
     * Gets the resulting value.
     */
    protected abstract fun getFinalValue(data: TypedData): R

    /**
     * Gets processor of [type].
     */
    fun <P> getProcessorOf(type: Class<*>, part: P, data: TypedData): Processor<P> {
        val searchType = if (this.map.containsKey(type))
            type
        else if (type.superclass != Any::class.java && type.interfaces.isEmpty())
            type.superclass
        else if (type.interfaces.size == 1)
            type.interfaces.single()
        else type

        @Suppress("UNCHECKED_CAST")
        return this.map[searchType] as? Processor<P>
                ?: throw IllegalArgumentException("Cannot find processor of type '$type' (searchType: '$searchType') and part '$part'. Data: {$data}")
    }
}

/**
 * Registers a [sugarSyntaxProcessor] of [Any] of type: [T].
 */
inline fun <R, reified T : Any> ProcessorManager<R>.registerSugarSyntaxProcessor(sugarSyntaxProcessor: SugarSyntaxProcessor<T>) =
        this.registerSugarSyntaxProcessor(sugarSyntaxProcessor, T::class.java)

/**
 * Registers [processor] of [Any] of type: [T].
 */
inline fun <R, reified T : Any> ProcessorManager<R>.registerProcessor(processor: Processor<T>) =
        this.registerProcessor(processor, T::class.java)

/**
 * Process [part] as of reified type [T]. This function is inlined, this means that type passed to [ProcessorManager.process]
 * will be the inferred type and not the the [part] type. This is useful when you want to call a specific processor
 * instead of exact processor.
 */
inline fun <reified T> ProcessorManager<*>.processAs(part: T, data: TypedData) = this.process(T::class.java, part, data)