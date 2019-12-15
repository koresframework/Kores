/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import java.lang.reflect.Type


/**
 * Value cast. Cast [instruction] of type [originalType] (null if unknown) to [targetType]. Official
 * BytecodeGenerator uses the [originalType] to auto-box and auto-unbox the value.
 *
 * @property originalType Origin type
 * @property targetType Target type
 * @property instruction Instruction to cast
 */
data class Cast(val originalType: Type?, val targetType: Type, val instruction: Instruction) :
    Typed, Instruction {

    override val type: Type
        get() = this.targetType

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Typed.Builder<Cast, Builder> {

        var originalType: Type? = null
        lateinit var targetType: Type
        lateinit var castedPart: Instruction

        constructor(defaults: Cast) : this() {
            this.originalType = defaults.originalType
            this.targetType = defaults.targetType
            this.castedPart = defaults.instruction
        }

        override fun type(value: Type): Builder = this.targetType(value)

        /**
         * See [Cast.originalType]
         */
        fun originalType(value: Type?): Builder {
            this.originalType = value
            return this
        }

        /**
         * See [Cast.targetType]
         */
        fun targetType(value: Type): Builder {
            this.targetType = value
            return this
        }

        /**
         * See [Cast.instruction]
         */
        fun instruction(value: Instruction): Builder {
            this.castedPart = value
            return this
        }

        override fun build(): Cast = Cast(this.originalType, this.targetType, this.castedPart)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Cast): Builder = Builder(defaults)
        }

    }

}