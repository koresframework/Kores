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
import com.github.jonathanxd.kores.common.FieldRef
import com.github.jonathanxd.kores.common.VariableRef
import java.lang.reflect.Type

/**
 * Base variable manipulation.
 */
interface VariableBase : Named, Typed {

    /**
     * Variable name
     */
    override val name: String

    /**
     * Variable type
     */
    val variableType: Type

    /**
     * Creates access to the variable that this instance represents.
     */
    fun access(): VariableAccess =
        VariableAccess(this.variableType, this.name)

    /**
     * Creates a definition of the value of the variable that this instance represents.
     */
    fun set(value: Instruction): VariableDefinition =
        VariableDefinition(this.type, this.name, value)

    override val type: Type
        get() = this.variableType

    override fun builder(): Builder<VariableBase, *>

    interface Builder<out T : VariableBase, S : Builder<T, S>> :
        Named.Builder<T, S>,
        Typed.Builder<T, S> {

        override fun type(value: Type): S = this.variableType(value)

        /**
         * See [VariableBase.variableType]
         */
        fun variableType(value: Type): S

        /**
         * Base this builder on [variableRef].
         */
        fun base(variableRef: VariableRef): S =
            this.name(variableRef.name).type(variableRef.type)

        /**
         * Base this builder on [fieldRef] (only [name] and [type]).
         */
        fun base(fieldRef: FieldRef): S =
            this.name(fieldRef.name).type(fieldRef.type)

    }
}