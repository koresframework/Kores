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

import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.type.CodeType

data class MethodTypeSpec(val localization: CodeType, val methodName: String, val typeSpec: TypeSpec) : Typed, Comparable<MethodTypeSpec> {
    override val type: CodeType?
        get() = this.typeSpec.type

    override fun builder(): Builder = Builder(this)

    /**
     * This method will not compare the method localization.
     */
    override operator fun compareTo(other: MethodTypeSpec): Int {
        return if (this.methodName == other.methodName && this.typeSpec == other.typeSpec) 0 else 1
    }


    class Builder() : Typed.Builder<MethodTypeSpec, Builder> {
        lateinit var localization: CodeType
        lateinit var methodName: String
        lateinit var typeSpec: TypeSpec

        constructor(defaults: MethodTypeSpec) : this() {
            this.localization = defaults.localization
            this.methodName = defaults.methodName
            this.typeSpec = defaults.typeSpec
        }

        override fun withType(value: CodeType?): Builder {
            this.typeSpec = this.typeSpec.copy(returnType = value!!)
            return this
        }

        fun withLocalization(value: CodeType): Builder {
            this.localization = value
            return this
        }

        fun withMethodName(value: String): Builder {
            this.methodName = value
            return this
        }

        fun withTypeSpec(value: TypeSpec): Builder {
            this.typeSpec = value
            return this
        }

        override fun build(): MethodTypeSpec = MethodTypeSpec(localization, methodName, typeSpec)


    }
}