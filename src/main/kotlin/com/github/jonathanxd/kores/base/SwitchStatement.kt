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
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.type
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Switch statement, this switch can switch numeric values and object values (like Enum, String or other
 * objects).
 *
 * You could switch objects, but make sure that the object implements [Any.hashCode]
 * and [Any.equals] methods.
 *
 * @property value Value to switch
 * @property switchType Type of the switch
 * @property cases Cases statements.
 */
@Serializable
data class SwitchStatement(
    override val value: Instruction,
    val switchType: SwitchType,
    val cases: List<Case>
) : ValueHolder, TypedInstruction {

    override val type: Type
        get() = this.value.type

    override fun builder(): Builder = Builder(this)

    class Builder() :
        ValueHolder.Builder<SwitchStatement, Builder>,
        Typed.Builder<SwitchStatement, Builder> {

        lateinit var value: Instruction
        lateinit var switchType: SwitchType
        var cases: List<Case> = emptyList()

        constructor(defaults: SwitchStatement) : this() {
            this.value = defaults.value
            this.switchType = defaults.switchType
            this.cases = defaults.cases
        }

        override fun type(value: Type): Builder = self()

        /**
         * See [SwitchStatement.value]
         */
        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        /**
         * See [SwitchStatement.switchType]
         */
        fun switchType(value: SwitchType): Builder {
            this.switchType = value
            return this
        }

        /**
         * See [SwitchStatement.cases]
         */
        fun cases(value: List<Case>): Builder {
            this.cases = value
            return this
        }

        /**
         * See [SwitchStatement.cases]
         */
        fun cases(vararg values: Case): Builder = cases(values.toList())

        override fun build(): SwitchStatement =
            SwitchStatement(this.value, this.switchType, this.cases)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: SwitchStatement): Builder = Builder(defaults)
        }

    }

}

/**
 * Switch types
 */
@Serializable
enum class SwitchType {
    NUMERIC,
    STRING,
    ENUM
}