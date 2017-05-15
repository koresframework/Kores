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

/**
 * Validation and Validation manager. Validates and manage custom validators.
 */
interface CodeValidator {

    /**
     * Validates [part] of and return a list of messages.
     */
    fun validate(part: Any, data: TypedData): List<ValidationMessage> = this.validate(part::class.java, part, data)

    /**
     * Validates [part] of type [type] and return a list of messages.
     */
    fun <P> validate(type: Class<out P>, part: P, data: TypedData): List<ValidationMessage>

    /**
     * Registers a custom [validator] of [CodePart] of [type].
     */
    fun <P> registerValidator(validator: Validator<P>, type: Class<P>)

    /**
     * Creates default [TypedData] instance.
     */
    fun createData(): TypedData = TypedData()
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
    fun validate(part: P, codeValidator: CodeValidator, data: TypedData): List<ValidationMessage>

}

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
 * **Only a void implementation**, this class does not validate, does not register validators,
 * this class does nothing, literally.
 */
object VoidValidator : CodeValidator {

    override fun <P> validate(type: Class<out P>, part: P, data: TypedData): List<ValidationMessage> {
        return emptyList()
    }

    override fun <P> registerValidator(validator: Validator<P>, type: Class<P>) {
    }

}