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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.serialization.TypeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Defines the value of variable of type [type] and name [name] to [value].
 */
@Serializable
data class VariableDefinition(
    @SerialName("variableDefinitionType")
    @Serializable(with = TypeSerializer::class) override val type: Type,
    override val name: String,
    override val value: Instruction
) : Named, TypedInstruction, ValueHolder {

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Named.Builder<VariableDefinition, Builder>,
        Typed.Builder<VariableDefinition, Builder>,
        ValueHolder.Builder<VariableDefinition, Builder> {

        lateinit var name: String
        lateinit var type: Type
        lateinit var value: Instruction

        constructor(defaults: VariableDefinition) : this() {
            this.name = defaults.name
            this.type = defaults.type
            this.value = defaults.value
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun type(value: Type): Builder {
            this.type = value
            return this
        }

        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        override fun build(): VariableDefinition =
            VariableDefinition(this.type, this.name, this.value)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: VariableDefinition): Builder = Builder(defaults)
        }

    }
}
