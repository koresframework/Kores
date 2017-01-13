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

data class MethodInvokeSpec(val invokeType: InvokeType, val methodTypeSpec: MethodTypeSpec) : Typed, Comparable<MethodInvokeSpec> {

    override val type: CodeType
        get() = this.methodTypeSpec.type

    override fun builder(): Builder = Builder(this)

    override fun compareTo(other: MethodInvokeSpec): Int {
        return this.methodTypeSpec.compareTo(other.methodTypeSpec)
    }

    class Builder() : Typed.Builder<MethodInvokeSpec, Builder> {

        lateinit var invokeType: InvokeType
        lateinit var methodTypeSpec: MethodTypeSpec

        constructor(defaults: MethodInvokeSpec) : this() {
            this.invokeType = defaults.invokeType
            this.methodTypeSpec = defaults.methodTypeSpec
        }

        override fun withType(value: CodeType): Builder {
            this.methodTypeSpec = methodTypeSpec.copy(typeSpec = methodTypeSpec.typeSpec.copy(returnType = value))
            return this
        }

        fun withInvokeType(value: InvokeType): Builder {
            this.invokeType = value
            return this
        }

        fun withMethodTypeSpec(value: MethodTypeSpec) : Builder {
            this.methodTypeSpec = value
            return this
        }

        override fun build(): MethodInvokeSpec = MethodInvokeSpec(this.invokeType, this.methodTypeSpec)
    }
}