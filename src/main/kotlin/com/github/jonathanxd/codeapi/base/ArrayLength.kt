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
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Access length of array [target] of type [arrayType].
 */
data class ArrayLength(override val arrayType: Type, override val target: CodePart) : ArrayAccess, Typed {

    override val type: Type
        get() = Types.INT

    override fun builder(): Builder = Builder(this)

    class Builder() :
            ArrayAccess.Builder<ArrayLength, Builder>,
            Typed.Builder<ArrayLength, Builder> {

        lateinit var arrayType: Type
        lateinit var target: CodePart

        constructor(defaults: ArrayLength) : this() {
            this.arrayType = defaults.arrayType
            this.target = defaults.target
        }

        override fun withType(value: Type): Builder = self()

        override fun withArrayType(value: Type): Builder {
            this.arrayType = value
            return this
        }

        override fun withTarget(value: CodePart): Builder {
            this.target = value
            return this
        }

        override fun build(): ArrayLength = ArrayLength(this.arrayType, this.target)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ArrayLength): Builder = Builder(defaults)
        }

    }
}