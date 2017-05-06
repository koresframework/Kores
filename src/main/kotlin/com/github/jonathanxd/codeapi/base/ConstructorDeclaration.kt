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

import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type


/**
 * Instance constructor declaration.
 */
data class ConstructorDeclaration(override val comments: Comments,
                                  override val annotations: List<Annotation>,
                                  override val modifiers: Set<CodeModifier>,
                                  override val genericSignature: GenericSignature,
                                  override val parameters: List<CodeParameter>,
                                  override val body: CodeSource) : MethodDeclarationBase {

    init {
        BodyHolder.checkBody(this)
    }

    override val name: String
        get() = "<init>"

    override val returnType: Type
        get() = Types.VOID

    override fun builder(): Builder = Builder(this)

    class Builder() : MethodDeclarationBase.Builder<ConstructorDeclaration, Builder> {

        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()
        var modifiers: Set<CodeModifier> = emptySet()
        var genericSignature: GenericSignature = GenericSignature.empty()
        var parameters: List<CodeParameter> = emptyList()
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: ConstructorDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.parameters = defaults.parameters
            this.body = defaults.body
        }

        override fun withName(value: String): Builder = self()

        override fun withComments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun withAnnotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun withModifiers(value: Set<CodeModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun withReturnType(value: Type): Builder = self()

        override fun withParameters(value: List<CodeParameter>): Builder {
            this.parameters = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun withGenericSignature(value: GenericSignature): Builder {
            this.genericSignature = value
            return this
        }

        override fun build(): ConstructorDeclaration = ConstructorDeclaration(this.comments, this.annotations, this.modifiers, this.genericSignature, this.parameters, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ConstructorDeclaration): Builder = Builder(defaults)
        }

    }

}

