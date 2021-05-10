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
@file:JvmName("Alias")

package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.type.KoresType
import com.github.jonathanxd.kores.type.koresType
import java.lang.reflect.Type

/**
 * Type alias. They are only supported in specific contexts, which depends on the generator.
 *
 * This commonly is used when you want to invoke methods, access fields, etc... of current class,
 * super class or super interface, but you don't have access to this information.
 *
 * # In Java
 *
 * Type alias does not exists in Java language (because you always have access to this information),
 * but would be something like: `this.class`, `super.class`.
 */
sealed class Alias : Instruction {

    /**
     * Called with current type declaration (the class that contains the alias) to resolve the real type.
     */
    abstract fun resolve(declaration: TypeDeclaration): Type

    /**
     * Current class localization.
     *
     * **Must be manually handled.**
     */
    object THIS : Alias(), KoresType by THIS::class.koresType {
        override fun resolve(declaration: TypeDeclaration): Type = declaration
        override fun hashCode(): Int = super.hashCode()
        override fun equals(other: Any?): Boolean = other === THIS
    }

    /**
     * Super class localization
     *
     * **Must be manually handled.**
     */
    object SUPER : Alias(), KoresType by SUPER::class.koresType {
        override fun resolve(declaration: TypeDeclaration): Type =
            (declaration as? SuperClassHolder)?.superClass
                    ?: throw IllegalStateException(
                        "Alias.SUPER found in a declaration that" +
                                " does not have super type. Declaration: $declaration"
                    )

        override fun hashCode(): Int = super.hashCode()
        override fun equals(other: Any?): Boolean = other === SUPER
    }

    /**
     * Interface extension localization.
     *
     * **Must be manually handled.**
     *
     * @param n Index of implementation interfaces
     */
    data class INTERFACE(val n: Int) : Alias(), KoresType by INTERFACE::class.koresType {
        override fun resolve(declaration: TypeDeclaration): Type =
            (declaration as? ImplementationHolder)?.implementations?.let {
                it.getOrNull(n) ?: throw IllegalStateException(
                    "Interface number '$n' not found" +
                            " in interfaces of declaration '$declaration'"
                )

            } ?: throw IllegalStateException(
                "Alias.SUPER found in a declaration that" +
                        " does not have super type. Declaration: $declaration"
            )

        override val type: String = "${INTERFACE::class.java.canonicalName}($n)"
        override val canonicalName: String = type

        override fun hashCode(): Int {
            var result = 1

            result = 31 * result + super.hashCode()
            result = 31 * result + n

            return result
        }

        override fun equals(other: Any?): Boolean {
            if (other !is INTERFACE)
                return false

            return this.n == other.n
        }
    }

}