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
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Catch block
 */
@Concrete
interface CatchStatement : BodyHolder, Typed {
    /**
     * Exception types to handle
     */
    val exceptionTypes: List<Type>

    /**
     * Variable to store exception
     */
    val variable: VariableDeclaration

    override val type: Type
        get() = this.variable.type


    override fun builder(): Builder<CatchStatement, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : CatchStatement, S : Builder<T, S>> :
            BodyHolder.Builder<T, S>,
            Typed.Builder<T, S> {

        @Suppress("UNCHECKED_CAST")
        override fun withType(value: Type): S = self()

        /**
         * See [T.exceptionTypes]
         */
        fun withExceptionTypes(value: List<Type>): S

        /**
         * See [T.variable]
         */
        fun withExceptionTypes(vararg values: Type): S = withExceptionTypes(values.toList())

        /**
         * See [T.variable]
         */
        fun withVariable(value: VariableDeclaration): S

        companion object {
            fun builder(): Builder<CatchStatement, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: CatchStatement): Builder<CatchStatement, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }
}