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
import com.github.jonathanxd.codeapi.util.CodeTypeUtil
import com.github.jonathanxd.codeapi.util.eq
import com.github.jonathanxd.codeapi.util.hash
import com.github.jonathanxd.codeapi.util.toStr

/**
 * Common implementation of [CodeType] arrays.
 */
@GenerateTo(CodeType::class)
internal open class CodeTypeArray(val component: CodeType, override val arrayDimension: Int) : CodeType {

    override val type: String
        get() {
            val name = this.component.type

            val sb = StringBuilder()

            for (x in 0..this.arrayDimension - 1)
                sb.append("[]")

            return name + sb.toString()
        }

    override val isVirtual: Boolean
        get() = component.isVirtual

    override val isInterface: Boolean
        get() = component.isInterface

    override val isPrimitive: Boolean
        get() = component.isPrimitive

    override val arrayBaseComponent: CodeType
        get() = this.component

    override val arrayComponent: CodeType
        get() {
            if(this.isArray) {
                if (this.arrayDimension - 1 == 0) {
                    return this.component
                } else {
                    return this.component.toArray(this.arrayDimension - 1)
                }
            }

            return this
        }

    override val canonicalName: String
        get() {
            val name = component.canonicalName

            val sb = StringBuilder()

            for (x in 0..arrayDimension - 1)
                sb.append("[]")

            return name + sb.toString()
        }

    override val isArray: Boolean
        get() = true

    override fun equals(other: Any?): Boolean = this.eq(other)
    override fun hashCode(): Int = this.hash()
    override fun toString(): String = this.toStr()

}
