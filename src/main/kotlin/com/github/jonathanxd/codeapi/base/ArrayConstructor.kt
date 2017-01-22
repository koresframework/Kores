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

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.builder.ArrayConstructorBuilder
import com.github.jonathanxd.codeapi.builder.ArrayStoreBuilder
import com.github.jonathanxd.codeapi.builder.build
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.CodePartUtil
import com.github.jonathanxd.codeapi.util.Stack

/**
 * Constructor of array type.
 */
interface ArrayConstructor : ArgumentHolder, Typed {

    override val types: List<CodeType>
        get() = ArrayList<CodeType>(this.arguments.size).apply {
            (0..arguments.size).forEach {
                add(arrayType.arrayComponent)
            }
        }

    /**
     * Type of the array.
     */
    val arrayType: CodeType

    /**
     * Array dimensions
     */
    val dimensions: List<CodePart>

    /**
     * Array values
     */
    val arrayValues: List<ArrayStore>
        get() {
            val arguments = this.arguments
            val arrayStores = mutableListOf<ArrayStore>()

            for (i in arguments.indices) {
                val argument = arguments[i]

                arrayStores.add(
                        ArrayStoreBuilder().build {
                            this.arrayType = this@ArrayConstructor.arrayType//this@ArrayConstructor.arrayType.toArray(this@ArrayConstructor.dimensions.size)
                            this.target = Stack
                            this.index = Literals.INT(i)
                            this.valueType = CodePartUtil.getType(argument)
                            this.valueToStore = argument
                        }
                )
            }

            return arrayStores
        }

    override val type: CodeType
        get() = this.arrayType

    override val array: Boolean
        get() = true

    override fun builder(): Builder<ArrayConstructor, *> = ArrayConstructorBuilder(this)

    interface Builder<out T: ArrayConstructor, S: Builder<T, S>> :
            ArgumentHolder.Builder<T, S>,
            Typed.Builder<T, S> {

        override fun withType(value: CodeType): S = this.withArrayType(value)

        @Suppress("UNCHECKED_CAST")
        override fun withArray(value: Boolean): S {
            return this as S
        }

        /**
         * See [T.arrayType]
         */
        fun withArrayType(value: CodeType): S

        /**
         * See [T.dimensions]
         */
        fun withDimensions(value: List<CodePart>): S

        /**
         * See [T.dimensions]
         */
        fun withDimensions(vararg values: CodePart): S

    }
}