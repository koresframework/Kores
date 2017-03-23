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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import java.lang.reflect.Type

/**
 * Store a value in array.
 */
@Concrete
interface ArrayStore : ArrayAccess, ValueHolder {

    /**
     * Index in array to store the value
     */
    val index: CodePart

    override val value: CodePart?
        get() = this.valueToStore

    /**
     * Type of the value
     */
    val valueType: Type

    /**
     * Value to store in array
     */
    val valueToStore: CodePart

    override fun builder(): Builder<ArrayStore, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : ArrayStore, S : Builder<T, S>> :
            ArrayAccess.Builder<T, S>,
            ValueHolder.Builder<T, S> {

        override fun withValue(value: CodePart?): S = this.withValueToStore(value!!)

        /**
         * See [T.index]
         */
        fun withIndex(value: CodePart): S

        /**
         * See [T.valueType]
         */
        fun withValueType(value: Type): S

        /**
         * See [T.valueToStore]
         */
        fun withValueToStore(value: CodePart): S

        companion object {
            fun builder(): Builder<ArrayStore, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: ArrayStore): Builder<ArrayStore, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }
}