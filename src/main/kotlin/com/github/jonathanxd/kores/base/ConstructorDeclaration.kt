/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.generic.GenericSignature
import java.lang.reflect.Type


/**
 * Instance constructor declaration.
 */
data class ConstructorDeclaration(
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val genericSignature: GenericSignature,
    override val parameters: List<KoresParameter>,
    override val innerTypes: List<TypeDeclaration>,
    override val throwsClause: List<Type>,
    override val body: Instructions
) : MethodDeclarationBase {

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
        var modifiers: Set<KoresModifier> = emptySet()
        var genericSignature: GenericSignature = GenericSignature.empty()
        var parameters: List<KoresParameter> = emptyList()
        var innerTypes: List<TypeDeclaration> = emptyList()
        var throws: List<Type> = emptyList()
        var body: Instructions = Instructions.empty()

        constructor(defaults: ConstructorDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.parameters = defaults.parameters
            this.innerTypes = defaults.innerTypes
            this.throws = defaults.throwsClause
            this.body = defaults.body
        }

        override fun name(value: String): Builder = self()

        override fun comments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun annotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun modifiers(value: Set<KoresModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun returnType(value: Type): Builder = self()

        override fun parameters(value: List<KoresParameter>): Builder {
            this.parameters = value
            return this
        }

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun throwsClause(value: List<Type>): Builder {
            this.throws = value
            return this
        }

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun genericSignature(value: GenericSignature): Builder {
            this.genericSignature = value
            return this
        }


        override fun build(): ConstructorDeclaration = ConstructorDeclaration(
            this.comments,
            this.annotations,
            this.modifiers,
            this.genericSignature,
            this.parameters,
            this.innerTypes,
            this.throws,
            this.body
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ConstructorDeclaration): Builder = Builder(defaults)
        }

    }

}

