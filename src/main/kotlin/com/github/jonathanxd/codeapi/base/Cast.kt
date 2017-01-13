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
import com.github.jonathanxd.codeapi.builder.CastBuilder
import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Part casting
 */
interface Cast : Typed {

    /**
     * Original type
     */
    val originalType: CodeType?

    /**
     * Target type
     */
    val targetType: CodeType

    /**
     * Part to cast
     */
    val castedPart: CodePart

    override val type: CodeType
        get() = this.targetType

    override fun builder(): Builder<Cast, *> = CastBuilder(this)

    interface Builder<out T: Cast, S: Builder<T, S>> : Typed.Builder<T, S> {

        override fun withType(value: CodeType): S = this.withTargetType(value)

        /**
         * See [T.originalType]
         */
        fun withOriginalType(value: CodeType?): S

        /**
         * See [T.targetType]
         */
        fun withTargetType(value: CodeType): S

        /**
         * See [T.castedPart]
         */
        fun withCastedPart(value: CodePart): S
    }

}