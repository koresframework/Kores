/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.type.isArray
import java.lang.reflect.Type

/**
 *
 * Loads a value of type [valueType] at [index] from array [target] of type [arrayType].
 *
 * @property index Index to access
 * @property valueType Type of value
 */
data class ArrayLoad(
    override val arrayType: Type,
    override val target: Instruction,
    val index: Instruction,
    val valueType: Type
) : ArrayAccess, Typed, Instruction {

    init {
        check(arrayType.isArray) { "arrayType is not an array type!" }
    }

    override val type: Type
        get() = this.valueType

    override fun builder(): Builder = Builder(this)


    class Builder() :
        ArrayAccess.Builder<ArrayLoad, Builder>,
        Typed.Builder<ArrayLoad, Builder> {

        lateinit var arrayType: Type
        lateinit var target: Instruction
        lateinit var index: Instruction
        lateinit var valueType: Type

        constructor(defaults: ArrayLoad) : this() {
            this.arrayType = defaults.arrayType
            this.target = defaults.target
            this.index = defaults.index
            this.valueType = defaults.valueType
        }

        override fun type(value: Type): Builder = self()

        override fun arrayType(value: Type): Builder {
            this.arrayType = value
            return this
        }

        override fun target(value: Instruction): Builder {
            this.target = value
            return this
        }

        /**
         * See [ArrayLoad.index]
         */
        fun index(value: Instruction): Builder {
            this.index = value
            return this
        }

        /**
         * See [ArrayLoad.valueType]
         */
        fun valueType(value: Type): Builder {
            this.valueType = value
            return this
        }

        override fun build(): ArrayLoad =
            ArrayLoad(this.arrayType, this.target, this.index, this.valueType)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ArrayLoad): Builder = Builder(defaults)
        }

    }
}
