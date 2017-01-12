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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeElement
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.builder.MethodFragmentBuilder
import com.github.jonathanxd.codeapi.fragment.SimpleMethodFragmentBuilder
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.common.Scope
import com.github.jonathanxd.codeapi.common.TypeSpec

/**
 * A fragment of a method declaration. This method may be inlined or declared as method of current
 * type.
 */
interface MethodFragment : MethodInvocation, CodeElement {

    /**
     * Fragment method declaration
     */
    val declaration: MethodDeclaration

    /**
     * Fragment scope
     */
    val scope: Scope

    /**
     * Declaring type of the fragment.
     */
    val declaringType: TypeDeclaration

    /**
     * Parameters
     */
    val parameters: List<CodeParameter>
        get() = this.declaration.parameters

    /**
     * Method description
     */
    val description: TypeSpec
        get() = this.spec.description

    /**
     * Method body
     */
    val body: CodeSource
        get() = this.declaration.body!!

    override fun builder(): Builder<MethodFragment, *> = MethodFragmentBuilder(this)

    interface Builder<out T : MethodFragment, S : Builder<T, S>> :
            MethodInvocation.Builder<T, S> {

        /**
         * See [T.declaration]
         */
        fun withDeclaration(value: MethodDeclaration): S

        /**
         * See [T.scope]
         */
        fun withScope(value: Scope): S

        /**
         * See [T.declaringType]
         */
        fun withDeclaringType(value: TypeDeclaration): S

    }

}