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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl
import com.github.jonathanxd.codeapi.base.MethodSpecification

// Generated by BuilderGen
class MethodSpecificationBuilder(): Builder<MethodSpecification, MethodSpecificationBuilder>() {
    lateinit var methodType: com.github.jonathanxd.codeapi.common.MethodType
    lateinit var methodName: kotlin.String
    lateinit var description: com.github.jonathanxd.codeapi.common.TypeSpec

    constructor(defaults: MethodSpecification) : this() {
        this.methodType = defaults.methodType
        this.methodName = defaults.methodName
        this.description = defaults.description
    }

    fun withMethodType(value: com.github.jonathanxd.codeapi.common.MethodType): MethodSpecificationBuilder {
        this.methodType = value
        return this
    }

    fun withMethodName(value: kotlin.String): MethodSpecificationBuilder {
        this.methodName = value
        return this
    }

    fun withDescription(value: com.github.jonathanxd.codeapi.common.TypeSpec): MethodSpecificationBuilder {
        this.description = value
        return this
    }

    override fun build(): MethodSpecification = MethodSpecificationImpl(
        methodType = this.methodType,
        methodName = this.methodName,
        description = this.description
    )
}