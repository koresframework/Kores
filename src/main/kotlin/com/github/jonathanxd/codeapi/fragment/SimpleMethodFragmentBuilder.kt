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
package com.github.jonathanxd.codeapi.fragment

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.MethodFragment
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.builder.Builder
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.common.Scope
import com.github.jonathanxd.codeapi.common.TypeSpec

open class SimpleMethodFragmentBuilder() : Builder<SimpleMethodFragmentImpl, SimpleMethodFragmentBuilder> {

    /**
     * See [MethodFragment.declaringType]
     */
    lateinit var declaringType: TypeDeclaration

    /**
     * See [MethodFragment.scope]
     */
    lateinit var scope: Scope

    /**
     * See [MethodFragment.arguments]
     */
    var arguments: List<CodePart> = emptyList()

    /**
     * See [MethodFragment.description]
     */
    lateinit var description: TypeSpec

    /**
     * See [MethodFragment.parameters]
     */
    var parameters: List<CodeParameter> = emptyList()

    /**
     * See [MethodFragment.body]
     */
    var body: CodeSource = CodeSource.empty()

    constructor(defaults: MethodFragment) : this() {
        this.declaringType = defaults.declaringType
        this.scope = defaults.scope
        this.arguments = defaults.arguments
        this.description = defaults.description
        this.parameters = defaults.parameters
        this.body = defaults.body
    }


    /**
     * See [MethodFragment.declaringType]
     */
    fun withDeclaringType(value: TypeDeclaration): SimpleMethodFragmentBuilder {
        this.declaringType = value
        return this
    }


    /**
     * See [MethodFragment.scope]
     */
    fun withScope(value: Scope): SimpleMethodFragmentBuilder {
        this.scope = value
        return this
    }


    /**
     * See [MethodFragment.arguments]
     */
    fun withArguments(value: List<CodePart>): SimpleMethodFragmentBuilder {
        this.arguments = value
        return this
    }


    /**
     * See [MethodFragment.arguments]
     */
    fun withArguments(vararg values: CodePart): SimpleMethodFragmentBuilder {
        this.arguments = values.toList()
        return this
    }


    /**
     * See [MethodFragment.description]
     */
    fun withDescription(value: TypeSpec): SimpleMethodFragmentBuilder {
        this.description = value
        return this
    }


    /**
     * See [MethodFragment.parameters]
     */
    fun withParameters(value: List<CodeParameter>): SimpleMethodFragmentBuilder {
        this.parameters = value
        return this
    }


    /**
     * See [MethodFragment.parameters]
     */
    fun withParameters(vararg values: CodeParameter): SimpleMethodFragmentBuilder {
        this.parameters = values.toList()
        return this
    }


    /**
     * See [MethodFragment.body]
     */
    fun withBody(value: CodeSource): SimpleMethodFragmentBuilder {
        this.body = value
        return this
    }

    override fun build(): SimpleMethodFragmentImpl = SimpleMethodFragmentImpl(
            declaringType = this.declaringType,
            scope = this.scope,
            arguments = this.arguments,
            description = this.description,
            parameters = this.parameters,
            body = this.body
    )


    companion object {
        @JvmStatic
        fun builder() = SimpleMethodFragmentBuilder()
    }
}