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
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 *
 * Loads a value of type [valueType] at [index] from array [target] of type [arrayType].
 *
 * @property index Index to access
 * @property valueType Type of value
 */
data class ArrayLoad(override val arrayType: Type,
                     override val target: CodePart,
                     val index: CodePart,
                     val valueType: Type) : ArrayAccess, Typed {

    override val type: Type
        get() = this.valueType

    override fun builder(): Builder = Builder(this)


    class Builder() :
            ArrayAccess.Builder<ArrayLoad, Builder>,
            Typed.Builder<ArrayLoad, Builder> {

        lateinit var arrayType: Type
        lateinit var target: CodePart
        lateinit var index: CodePart
        lateinit var valueType: Type

        constructor(defaults: ArrayLoad) : this() {
            this.arrayType = defaults.arrayType
            this.target = defaults.target
            this.index = defaults.index
            this.valueType = defaults.valueType
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

        /**
         * See [ArrayLoad.index]
         */
        fun withIndex(value: CodePart): Builder {
            this.index = value
            return this
        }

        /**
         * See [ArrayLoad.valueType]
         */
        fun withValueType(value: Type): Builder {
            this.valueType = value
            return this
        }

        override fun build(): ArrayLoad = ArrayLoad(this.arrayType, this.target, this.index, this.valueType)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ArrayLoad): Builder = Builder(defaults)
        }

    }
}
