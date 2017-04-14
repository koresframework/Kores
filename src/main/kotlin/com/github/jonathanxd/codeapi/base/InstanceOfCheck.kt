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
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.type.CodeType
import java.lang.reflect.Type

/**
 * Instance of check
 */
@Concrete
interface InstanceOfCheck : Typed {

    override val type: Type
        get() = Types.BOOLEAN

    /**
     * Part to check
     */
    val part: CodePart

    /**
     * Type to check
     */
    val checkType: Type

    override fun builder(): Builder<InstanceOfCheck, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : InstanceOfCheck, S : Builder<T, S>> : Typed.Builder<T, S> {

        @Suppress("UNCHECKED_CAST")
        override fun withType(value: Type): S = this as S

        /**
         * See [T.part]
         */
        fun withPart(value: CodePart): S

        /**
         * See [T.checkType]
         */
        fun withCheckType(value: Type): S

        companion object {
            fun builder(): Builder<InstanceOfCheck, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: InstanceOfCheck): Builder<InstanceOfCheck, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }
}