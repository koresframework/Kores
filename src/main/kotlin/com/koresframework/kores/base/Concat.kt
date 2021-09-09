/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.base

import com.koresframework.kores.Instruction
import com.koresframework.kores.KoresPart
import com.koresframework.kores.Types
import com.koresframework.kores.builder.self
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder] will be
 * used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official
 * JavaSourceGenerator this will be translated into string concatenation.
 */
@Serializable
data class Concat(val concatenations: List<Instruction>) : KoresPart, TypedInstruction {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = Types.STRING

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Typed.Builder<Concat, Builder> {

        override var data: KoresData = KoresData()
        var concatenations: List<Instruction> = emptyList()

        override var type: Type
            get() = Types.STRING
            set(value) {}

        constructor(defaults: Concat) : this() {
            this.concatenations = defaults.concatenations

            this.from(defaults)
        }

        override fun type(value: Type): Builder = self()

        /**
         * See [Concat.concatenations]
         */
        fun concatenations(value: List<Instruction>): Builder {
            this.concatenations = value
            return this
        }

        /**
         * See [Concat.concatenations]
         */
        fun concatenations(vararg values: Instruction): Builder =
            this.concatenations(values.toList())

        override fun buildBasic(): Concat = Concat(this.concatenations)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Concat): Builder = Builder(defaults)
        }

    }
}
