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

import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.util.eq
import com.github.jonathanxd.codeapi.util.hash
import com.github.jonathanxd.codeapi.util.toStr

class GenericTypeImpl(name: String?, codeType: CodeType?, override val bounds: Array<GenericType.Bound>) : GenericType {

    override val name: String
    override val codeType: CodeType

    /**
     * Is type defined
     */
    private val isType_: Boolean

    /**
     * Defined type.
     */
    private val definedCodeType: CodeType?

    init {
        this.isType_ = codeType != null

        if (name != null) {
            this.name = name
        } else {
            if (codeType == null) {
                throw NullPointerException("codeType is null and name is null")
            }

            var specName = codeType.javaSpecName

            specName = specName.substring(0, specName.length - 1)

            this.name = specName
        }

        if (codeType != null) {
            this.codeType = codeType
            this.definedCodeType = codeType
        } else {
            if (this.bounds.isEmpty()) {
                this.definedCodeType = null
                this.codeType = Types.OBJECT
            } else {
                this.codeType = bounds[0].type
                this.definedCodeType = this.codeType
            }
        }
    }

    override val isType: Boolean
        get() = !this.isWildcard && this.isType_

    override fun toArray(dimensions: Int): GenericType = GenericTypeImpl(this.name, this.codeType.toArray(dimensions), this.bounds)

    override fun equals(other: Any?): Boolean = this.eq(other)
    override fun hashCode(): Int = this.hash()
    override fun toString(): String = this.toStr()

}