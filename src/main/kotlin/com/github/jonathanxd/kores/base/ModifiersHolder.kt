/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.kores.KoresPart

/**
 * A element that have modifiers.
 */
interface ModifiersHolder : KoresPart {

    /**
     * Modifiers. Empty modifier set is the same as public. For package private, an explicit
     * [KoresModifier.PACKAGE_PRIVATE] is required.
     */
    val modifiers: Set<KoresModifier>

    /**
     * Returns true if this part is public.
     */
    val isPublic: Boolean
        get() = this.modifiers.isEmpty() || this.modifiers.contains(KoresModifier.PUBLIC)

    override fun builder(): Builder<ModifiersHolder, *>

    interface Builder<out T : ModifiersHolder, S : Builder<T, S>> :
        com.github.jonathanxd.kores.builder.Builder<T, S> {

        /**
         * See [ModifiersHolder.modifiers]
         */
        fun modifiers(value: Set<KoresModifier>): S

        /**
         * See [ModifiersHolder.modifiers]
         */
        fun modifiers(vararg values: KoresModifier): S = modifiers(values.toSet())

        /**
         * Sets modifiers to [KoresModifier.PUBLIC]. Public modifier is optional, all
         * [ModifiersHolder] which does not provide a modifier is public by default.
         */
        fun publicModifier(): S = this.modifiers(KoresModifier.PUBLIC)
    }
}