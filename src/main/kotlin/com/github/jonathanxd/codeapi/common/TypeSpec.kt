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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.type.CodeType
import java.util.*

data class TypeSpec @JvmOverloads constructor(val returnType: CodeType, val parameterTypes: List<CodeType> = emptyList()) : Typed, Comparable<TypeSpec> {
    override val type: CodeType
        get() = this.returnType

    override fun hashCode(): Int {
        return Objects.hash(returnType, parameterTypes)
    }

    /**
     * Human readable type specification string.
     */
    fun toTypeString() =
            "(${this.parameterTypes.map { it.canonicalName }.joinToString()})${this.returnType.canonicalName}"


    override fun builder(): Builder = Builder(this)

    override fun equals(other: Any?): Boolean {

        if (other !is TypeSpec)
            return false

        return this.returnType.`is`(other.returnType) && this.parameterTypes == other.parameterTypes;
    }

    override fun compareTo(other: TypeSpec): Int {
        return if (this.returnType.`is`(other.returnType) && this.parameterTypes == other.parameterTypes) 0 else 1
    }

    class Builder() : Typed.Builder<TypeSpec, Builder> {

        var returnType: CodeType = Types.VOID
        var parameterTypes: List<CodeType> = emptyList()

        constructor(defaults: TypeSpec) : this() {
            this.returnType = defaults.returnType
            this.parameterTypes = defaults.parameterTypes
        }

        override fun withType(value: CodeType): Builder {
            this.returnType = value
            return this
        }

        fun withReturnType(value: CodeType): Builder {
            this.returnType = value
            return this
        }

        fun withParameterTypes(value: List<CodeType>): Builder {
            this.parameterTypes = value
            return this
        }

        fun withParameterTypes(vararg values: CodeType): Builder {
            this.parameterTypes = values.toList()
            return this
        }

        override fun build(): TypeSpec = TypeSpec(returnType, parameterTypes)

    }

}