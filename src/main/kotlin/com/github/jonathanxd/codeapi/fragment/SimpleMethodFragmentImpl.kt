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
import com.github.jonathanxd.codeapi.Defaults
import com.github.jonathanxd.codeapi.base.MethodDeclaration
import com.github.jonathanxd.codeapi.base.MethodFragment
import com.github.jonathanxd.codeapi.base.MethodSpecification
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.base.impl.MethodDeclarationImpl
import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl
import com.github.jonathanxd.codeapi.builder.MethodFragmentBuilder
import com.github.jonathanxd.codeapi.common.*
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.type.CodeType
import java.util.concurrent.ThreadLocalRandom

/**
 * Fragment utility class.
 */
data class SimpleMethodFragmentImpl(override val declaringType: TypeDeclaration, override val scope: Scope, override val arguments: List<CodePart>, override val description: TypeSpec, override val parameters: List<CodeParameter>, override val body: CodeSource) : MethodFragment {

    override val spec: MethodSpecification = MethodSpecificationImpl(
            description = description,
            methodName = randomName(),
            methodType = MethodType.METHOD
    )

    override val declaration: MethodDeclaration = MethodDeclarationImpl(
            modifiers = setOf(CodeModifier.PRIVATE, if (scope == Scope.STATIC) CodeModifier.STATIC else CodeModifier.FINAL),
            parameters = parameters,
            annotations = emptyList(),
            genericSignature = GenericSignature.empty(),
            name = spec.methodName,
            returnType = spec.description.returnType,
            body = body,
            comments = Comments.Absent
    )

    override val invokeType: InvokeType = if (scope == Scope.STATIC) InvokeType.INVOKE_STATIC else InvokeType.INVOKE_VIRTUAL
    override val localization: CodeType = declaringType
    override val target: CodePart = if (scope == Scope.STATIC) Defaults.ACCESS_STATIC else Defaults.ACCESS_THIS
    override val invokeDynamic: InvokeDynamic? = null

    override fun builder(): MethodFragment.Builder<MethodFragment, *> = MethodFragmentBuilder(this)

    private companion object {

        val RANDOM = ThreadLocalRandom.current()

        fun randomName() = "fragment\$\$${RANDOM.nextInt().toString().replace("-", "_")}"
    }
}