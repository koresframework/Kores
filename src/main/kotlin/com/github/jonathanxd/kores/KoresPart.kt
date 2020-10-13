/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores

import com.github.jonathanxd.kores.base.Access
import com.github.jonathanxd.kores.base.Alias
import com.github.jonathanxd.kores.base.InstructionWrapper
import com.github.jonathanxd.kores.base.Typed
import com.github.jonathanxd.kores.builder.Builder
import com.github.jonathanxd.kores.type.NullType
import com.github.jonathanxd.kores.type.`is`
import com.github.jonathanxd.kores.type.isPrimitive
import com.github.jonathanxd.kores.type.koresType
import java.lang.reflect.Type

/**
 * A KoresPart is the heart of Kores, all elements that can appear in the code must extend KoresPart.
 *
 * All interfaces that have a concrete implementation and extends [KoresPart] must provide a
 * `builder` method that return a builder instance with defined default values.
 *
 */
interface KoresPart {

    /**
     * This builder may or may not accept null values, it depends on implementation.
     */
    fun builder(): Builder<KoresPart, *> = SelfBuilder(this)

    class SelfBuilder(val self: KoresPart) : Builder<KoresPart, SelfBuilder> {
        override fun build(): KoresPart = self
    }
}

/**
 * Returns true if the type of this [KoresPart] is primitive
 */
val KoresPart.isPrimitive: Boolean
    get() = this.type.isPrimitive

/**
 * Gets the type of [KoresPart]
 */
val KoresPart.type: Type
    get() = this.typeOrNull ?: throw IllegalArgumentException("Cannot infer type of part '$this'!")


/**
 * Gets the type of [KoresPart] or null if receiver is not a [Typed] instance.
 */
val KoresPart.typeOrNull: Type?
    get() = (this as? Typed)?.type?.let {
        if (it.`is`(NullType))
            Types.OBJECT
        else it
    } ?: (this as? InstructionWrapper)?.wrappedInstruction?.also {
        if (it == this)
            throw IllegalStateException("InstructionWrapper wrapping itself.")
    }?.typeOrNull ?: (this as? Access)?.let {
        when (it) {
            Access.THIS, Access.LOCAL, Access.STATIC -> Alias.THIS.koresType
            Access.SUPER -> Alias.SUPER.koresType
        }
    } ?: (this as? Instruction)?.getLeaveType() ?: (this as? Instructions)?.getLeaveType()

