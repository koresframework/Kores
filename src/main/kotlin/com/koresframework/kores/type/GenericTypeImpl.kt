/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.type

import com.koresframework.kores.Types
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.util.toStr

/**
 * Generic type implementation.
 */
class GenericTypeImpl(
    name: String?,
    codeType: KoresType?,
    override val bounds: Array<GenericType.Bound>
) : GenericType {

    override val data: KoresData = KoresData()

    override val name: String
    override val resolvedType: KoresType

    /**
     * Is type defined
     */
    private val isType_: Boolean = codeType != null

    /**
     * Defined type.
     */
    private val definedKoresType: KoresType?

    init {

        if (name != null) {
            this.name = name
        } else {
            if (codeType == null) {
                throw NullPointerException("codeType is null and name is null")
            }

            this.name = codeType.javaSpecName.let { it.substring(0, it.length - 1) }
        }

        if (codeType != null) {
            this.resolvedType = codeType
            this.definedKoresType = codeType
        } else {
            if (this.bounds.isEmpty()) {
                this.definedKoresType = null
                this.resolvedType = Types.OBJECT
            } else {
                this.resolvedType = bounds[0].type
                this.definedKoresType = this.resolvedType
            }
        }
    }

    override val isType: Boolean
        get() = !this.isWildcard && this.isType_

    override fun toArray(dimensions: Int): GenericType =
        GenericTypeImpl(this.name, this.resolvedType.toArray(dimensions), this.bounds)

    override fun equals(other: Any?): Boolean = this.eq(other)
    override fun hashCode(): Int = this.hash()
    override fun toString(): String = this.toStr()

}