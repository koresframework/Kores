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
package com.github.jonathanxd.kores.type

import java.lang.reflect.Type

/**
 * Plain string code type.
 */
open class PlainKoresType @JvmOverloads constructor(
    override val type: String,
    override val isInterface: Boolean = false,
    val superclass_: () -> Type? = { throw IllegalStateException("No super class provider") },
    val superinterfaces_: () -> List<Type> = { throw IllegalStateException("No super interfaces provider") }
) : UnknownKoresType, InheritanceProvider {

    override val canonicalName: String get() = this.type

    override val superclass: Type?
        get() = superclass_()

    override val superinterfaces: List<Type>
        get() = superinterfaces_()

    override fun equals(other: Any?): Boolean {
        return this.eq(other)
    }

    override fun hashCode(): Int {
        return this.hash()
    }

    override fun toString(): String {
        return "Plain[" + this.canonicalName + "]"
    }

}
