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
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Represents the construction of type, used to invoke constructor methods. (not `super` constructor or `this` constructor).
 */
@Serializable
data class New(@Serializable(with = TypeSerializer::class) val localization: Type) : KoresPart, Instruction {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : com.koresframework.kores.builder.Builder<New, Builder>, KoresPart.PartBuilder<New, Builder> {
        override var data: KoresData = KoresData()
        lateinit var localization: Type

        constructor(defaults: New) : this() {
            this.localization = defaults.localization

            this.fromData(defaults.data)
        }

        /**
         * See [New.localization]
         */
        fun localization(value: Type): Builder {
            this.localization = value
            return this
        }

        override fun buildBasic(): New = New(this.localization)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: New): Builder = Builder(defaults)
        }
    }
}