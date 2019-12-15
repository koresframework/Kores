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
 * Base field (access and definition common class)
 */
interface FieldBase : Named, Typed {

    /**
     * Field localization.
     */
    val localization: Type

    /**
     * Target of the access
     */
    val target: Instruction

    /**
     * Creates access to the field that this instance represents.
     */
    fun access(): FieldAccess =
        FieldAccess(this.localization, this.target, this.type, this.name)

    /**
     * Creates a definition of the value of the field that this instance represents.
     */
    fun set(value: Instruction): FieldDefinition =
        FieldDefinition(this.localization, this.target, this.type, this.name, value)

    override val type: Type

    override fun builder(): Builder<FieldBase, *>

    interface Builder<out T : FieldBase, S : Builder<T, S>> :
        Named.Builder<T, S>,
        Typed.Builder<T, S> {

        /**
         * See [T.localization]
         */
        fun localization(value: Type): S

        /**
         * See [T.target]
         */
        fun target(value: Instruction): S

        /**
         * Base this builder on [variableRef].
         */
        fun base(variableRef: VariableRef): S =
            this.name(variableRef.name).type(variableRef.type)

        /**
         * Base this builder on [fieldRef].
         */
        fun base(fieldRef: FieldRef): S =
            this.localization(fieldRef.localization)
                .target(fieldRef.target)
                .name(fieldRef.name)
                .type(fieldRef.type)
    }
}