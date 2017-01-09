/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.type

import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Java class [CodeType].
 */
@GenerateTo(CodeType::class)
open class JavaType<T> constructor(override val loadedType: Class<T>) : LoadedCodeType<T> {

    override fun equals(other: Any?): Boolean {

        if (other == null)
            return false

        if (other is Class<*>) {
            return this.loadedType == other
        }

        if (other is LoadedCodeType<*>) {
            return this.loadedType == other.loadedType
        }

        if (other is CodeType) {
            return this.javaSpecName == other.javaSpecName
        }

        return CodeType.eq(this, other)
    }

    override val type: String
        get() = this.loadedType.typeName.let {
            when(it) {
                "byte" -> "B"
                "short" -> "S"
                "int" -> "I"
                "char" -> "C"
                "double" -> "D"
                "float" -> "F"
                "long" -> "J"
                "boolean" -> "Z"
                "void" -> "V"
                else -> it
            }
        }

    override val canonicalName: String
        get() = this.loadedType.canonicalName

    override fun hashCode(): Int {
        return CodeType.hash(this)
    }

    override val isInterface: Boolean
        get() = loadedType.isInterface

    override val isPrimitive: Boolean
        get() = loadedType.isPrimitive

    override val isVirtual: Boolean
        get() = false

    override fun toString(): String {
        return this.javaSpecName
    }

    override val isExpression: Boolean
        get() = false

}
