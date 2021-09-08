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
@file:JvmName("Line")

package com.koresframework.kores.base

import com.koresframework.kores.Instruction
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Base class of line mapping. Line mapping behaves differently for different
 * generators.
 */
@Serializable
sealed class Line : Instruction, ValueHolder, InstructionWrapper {

    override val data: KoresData = KoresData()

    /**
     * Line index
     */
    abstract val line: Int

    override val wrappedInstruction: Instruction
        get() = this.value

    /**
     * Instruction mapped to line
     */
    abstract override val value: Instruction

    abstract override fun builder(): Builder<Line, *>

    interface Builder<out T : Line, S : Builder<T, S>> : ValueHolder.Builder<T, S> {

        /**
         * See [Line.line]
         */
        fun line(value: Int): S

    }

    /**
     * A [Line] which extends [Typed].
     */
    @Serializable
    data class TypedLine(
        override val line: Int,
        override val value: Instruction,
        @SerialName("lineInstructionType")
        override val type: Type
    ) : Line(), Typed {

        override fun builder() = Builder(this)

        class Builder() : Line.Builder<TypedLine, Builder>,
            Typed.Builder<TypedLine, Builder> {

            override var data: KoresData = KoresData()
            override lateinit var type: Type
            var line: Int = -1
            override lateinit var value: Instruction

            constructor(defaults: TypedLine) : this() {
                this.type = defaults.type
                this.line = defaults.line
                this.value = defaults.value
            }

            override fun type(value: Type): Builder {
                this.type = value
                return this
            }

            override fun line(value: Int): Builder {
                this.line = value
                return this
            }

            override fun value(value: Instruction): Builder {
                value.type
                this.value = value
                return this
            }

            override fun buildBasic(): TypedLine = TypedLine(this.line, this.value, this.type)
        }

    }

    /**
     * A Line which does extends [Line]
     */
    @Serializable
    data class NormalLine(override val line: Int, override val value: Instruction) : Line() {
        override fun builder() = Builder(this)

        class Builder() : Line.Builder<NormalLine, Builder> {

            override var data: KoresData = KoresData()
            var line: Int = -1
            override lateinit var value: Instruction

            constructor(defaults: NormalLine) : this() {
                this.line = defaults.line
                this.value = defaults.value
            }

            override fun line(value: Int): Builder {
                this.line = value
                return this
            }

            override fun value(value: Instruction): Builder {
                this.value = value
                return this
            }

            override fun buildBasic(): NormalLine = NormalLine(this.line, this.value)
        }
    }
}