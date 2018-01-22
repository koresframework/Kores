/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.literal

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.base.Named
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.type.CodeType
import java.util.*

/**
 * A JVM Literal.
 *
 * Example of literals: Strings, Ints, Doubles, Longs, Types, etc.
 */
abstract class Literal protected constructor(
    val value: Any,
    override val name: String,
    override val type: CodeType
) : CodeInstruction, Named, Typed {

    // Compatibility
    constructor(name: String, type: CodeType) : this(name, name, type)

    override fun builder() = throw IllegalStateException("Cannot create a builder of a Literal.")

    override fun hashCode(): Int =
        Objects.hash(this.value, this.name, this.type)

    override fun equals(other: Any?): Boolean =
        other is Literal && this.value == other.value && this.name == other.name && this.type == other.type

    override fun toString(): String {
        return "${this::class.java.simpleName}[name=$name, type=$type]"
    }
}
