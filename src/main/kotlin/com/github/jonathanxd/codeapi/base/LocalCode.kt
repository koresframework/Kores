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

import com.github.jonathanxd.codeapi.*
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.*
import com.github.jonathanxd.codeapi.util.codeType
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * A local code execution. This code may be inlined or declared as method of current
 * type and invoked in call site or by a lambda.
 *
 * @property declaration Method declaration of the code.
 * @property scope Code scope.
 * @property declaringType Declaring type of the local method.
 * @property arguments Arguments to pass to code.
 */
data class LocalCode(val declaringType: Type,
                     val scope: Scope,
                     val declaration: MethodDeclarationBase,
                     override val arguments: List<CodePart>) : MethodInvocationBase, CodeElement {

    override val invokeType: InvokeType
        get() = if (this.scope == Scope.STATIC) InvokeType.INVOKE_STATIC else InvokeType.get(this.declaringType.codeType)

    override val localization: Type
        get() = this.declaringType

    override val target: CodePart
        get() = if(this.scope == Scope.STATIC) this.declaringType.codeType else Defaults.ACCESS_THIS

    override val spec: MethodTypeSpec
        get() = MethodTypeSpec(this.declaringType, this.declaration.name, this.declaration.typeSpec)

    /**
     * Parameters
     */
    val parameters: List<CodeParameter>
        get() = this.declaration.parameters

    /**
     * Method description
     */
    val description: TypeSpec
        get() = this.spec.typeSpec

    /**
     * Method body
     */
    val body: CodeSource
        get() = this.declaration.body

    override fun builder(): Builder = CodeAPI.getBuilderProvider()(this)

    interface Builder :
            MethodInvocationBase.Builder<LocalCode, Builder> {

        /**
         * See [LocalCode.declaration]
         */
        fun withDeclaration(value: MethodDeclarationBase): Builder

        /**
         * See [LocalCode.scope]
         */
        fun withScope(value: Scope): Builder

        /**
         * See [LocalCode.declaringType]
         */
        fun withDeclaringType(value: Type): Builder

        companion object {
            fun builder(): Builder = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: LocalCode): Builder = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }
}
