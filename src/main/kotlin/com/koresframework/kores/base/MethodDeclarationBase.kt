/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.base

import com.koresframework.kores.KoresElement
import com.koresframework.kores.Instructions
import com.koresframework.kores.Types
import com.koresframework.kores.base.comment.CommentHolder
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Method declaration
 */
@Serializable
data class MethodDeclaration(
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val genericSignature: GenericSignature,
    @Serializable(with = TypeSerializer::class) override val returnType: Type,
    override val name: String,
    override val parameters: List<KoresParameter>,
    override val innerTypes: List<TypeDeclaration>,
    override val throwsClause: List<@Serializable(with = TypeSerializer::class) Type>,
    override val body: Instructions
) : MethodDeclarationBase {

    override val data: KoresData = KoresData()

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() : MethodDeclarationBase.Builder<MethodDeclaration, Builder> {

        // vars

        override var data: KoresData = KoresData()
        override var comments: Comments = Comments.Absent
        override var annotations: List<Annotation> = emptyList()
        override var modifiers: Set<KoresModifier> = emptySet()
        override var genericSignature: GenericSignature = GenericSignature.empty()
        override var returnType: Type = Types.VOID
        override lateinit var name: String
        override var parameters: List<KoresParameter> = emptyList()
        override var innerTypes: List<TypeDeclaration> = emptyList()
        override var throwsClause: List<Type> = emptyList()
        override var body: Instructions = Instructions.empty()

        constructor(defaults: MethodDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.returnType = defaults.returnType
            this.name = defaults.name
            this.parameters = defaults.parameters
            this.innerTypes = defaults.innerTypes
            this.throwsClause = defaults.throwsClause
            this.body = defaults.body

            this.from(defaults)
        }

        override fun buildBasic(): MethodDeclaration = MethodDeclaration(
            this.comments, this.annotations, this.modifiers, this.genericSignature,
            this.returnType, this.name, this.parameters, this.innerTypes, this.throwsClause, this.body
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: MethodDeclaration): Builder = Builder(defaults)
        }

    }

}

/**
 * Method declaration
 */
interface MethodDeclarationBase : KoresElement, ModifiersHolder, ReturnTypeHolder, ParametersHolder,
    GenericSignatureHolder, Annotable, Named, Typed, CommentHolder, BodyHolder, InnerTypesHolder,
    ThrowsHolder {

    override val type: Type
        get() = this.returnType

    override val returnType: Type

    val typeSpec: TypeSpec
        get() = TypeSpec(this.returnType, this.parameters.map(KoresParameter::type))

    override fun builder(): Builder<MethodDeclarationBase, *>

    interface Builder<out T : MethodDeclarationBase, S : Builder<T, S>> :
        BodyHolder.Builder<T, S>,
        ModifiersHolder.Builder<T, S>,
        ReturnTypeHolder.Builder<T, S>,
        ParametersHolder.Builder<T, S>,
        GenericSignatureHolder.Builder<T, S>,
        Annotable.Builder<T, S>,
        Named.Builder<T, S>,
        Typed.Builder<T, S>,
        CommentHolder.Builder<T, S>,
        InnerTypesHolder.Builder<T, S>,
        ThrowsHolder.Builder<T, S> {

        override var returnType: Type

        override var type: Type
            get() = this.returnType
            set(value) { this.returnType = value }

        override fun type(value: Type): S = this.returnType(value)

    }
}