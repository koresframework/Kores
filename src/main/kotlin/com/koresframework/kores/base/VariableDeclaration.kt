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
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Declares a variable of type [variableType] and name [name] with default value [value] (null does not
 * mean that you declared a variable with null value, it means that you declared a variable without a default value,
 * for null values use `Literals.NULL`).
 */
@Serializable
data class VariableDeclaration(
    override val modifiers: Set<KoresModifier>,
    @Serializable(with = TypeSerializer::class) override val variableType: Type,
    override val name: String,
    override val value: Instruction
) : VariableBase, ValueHolder, TypedInstruction, ModifiersHolder {
    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() :
        VariableBase.Builder<VariableDeclaration, Builder>,
        ValueHolder.Builder<VariableDeclaration, Builder>,
        ModifiersHolder.Builder<VariableDeclaration, Builder> {

        override var data: KoresData = KoresData()
        override lateinit var name: String
        override lateinit var variableType: Type
        override var value: Instruction = KoresNothing
        override var modifiers: Set<KoresModifier> = emptySet()

        constructor(defaults: VariableDeclaration) : this() {
            this.name = defaults.name
            this.variableType = defaults.variableType
            this.value = defaults.value
            this.modifiers = defaults.modifiers

            this.fromData(defaults.data)
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun variableType(value: Type): Builder {
            this.variableType = value
            return this
        }

        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        override fun modifiers(value: Set<KoresModifier>): Builder {
            this.modifiers = value
            return this
        }

        /**
         * Removes value definition.
         */
        fun withoutValue(): Builder = this.value(KoresNothing)

        override fun buildBasic(): VariableDeclaration =
            VariableDeclaration(this.modifiers, this.variableType, this.name, this.value)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: VariableDeclaration): Builder = Builder(defaults)
        }

    }
}
