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
import com.koresframework.kores.base.ControlFlow.Type
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable

/**
 * Control the flow of a statement.
 *
 * @property type Type of the flow control
 * @property at Label to control flow (Note: [Type.CONTINUE] goes to Start of label and [Type.BREAK] goes to end of label).
 * **Note**: [Type.CONTINUE] to a label is dangerous.
 */
@Serializable
data class ControlFlow(val type: Type, val at: Label?) : KoresPart, Instruction {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : com.koresframework.kores.builder.Builder<ControlFlow, Builder>, KoresPart.PartBuilder<ControlFlow, Builder> {

        override var data: KoresData = KoresData()
        lateinit var type: Type
        var at: Label? = null

        constructor(defaults: ControlFlow) : this() {
            this.type = defaults.type
            this.at = defaults.at
        }

        /**
         * See [ControlFlow.type]
         */
        fun type(value: Type): Builder {
            this.type = value
            return this
        }

        /**
         * See [ControlFlow.at]
         */
        fun at(value: Label?): Builder {
            this.at = value
            return this
        }

        override fun buildBasic(): ControlFlow = ControlFlow(this.type, this.at)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ControlFlow): Builder = Builder(defaults)
        }

    }

    enum class Type {
        /**
         * Breaks to end of the flow
         */
        BREAK,

        /**
         * Continue at start of the flow
         */
        CONTINUE
    }

}

