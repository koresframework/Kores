/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.koresframework.kores.Instructions
import com.koresframework.kores.Types
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.builder.self
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.generic.GenericSignature
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Static block (aka class constructors/class initializers).
 */
@Serializable
data class StaticBlock(
    override val comments: Comments,
    override val innerTypes: List<TypeDeclaration>,
    override val body: Instructions
) : MethodDeclarationBase {
    override val data: KoresData = KoresData()

    init {
        BodyHolder.checkBody(this)
    }

    override val name: String
        get() = Constants.NAME

    override val annotations: List<Annotation>
        get() = emptyList()

    override val parameters: List<KoresParameter>
        get() = emptyList()

    override val returnType: Type
        get() = Constants.RETURN_TYPE

    override val genericSignature: GenericSignature
        get() = GenericSignature.empty()

    override val modifiers: Set<KoresModifier>
        get() = Constants.MODIFIERS

    override val throwsClause: List<Type>
        get() = emptyList()

    override fun builder(): Builder = Builder(this)

    class Builder() : MethodDeclarationBase.Builder<StaticBlock, Builder> {

        override var data: KoresData = KoresData()
        override var comments: Comments = Comments.Absent
        override var innerTypes: List<TypeDeclaration> = emptyList()
        override var body: Instructions = Instructions.empty()

        override var returnType: Type
            get() = RETURN_TYPE
            set(value) {}

        override var parameters: List<KoresParameter>
            get() = emptyList()
            set(value) {}

        override var throwsClause: List<Type>
            get() = emptyList()
            set(value) {}

        override var annotations: List<Annotation>
            get() = emptyList()
            set(value) {}

        override var genericSignature: GenericSignature
            get() = GenericSignature.empty()
            set(value) {}

        override var name: String
            get() = NAME
            set(value) {}

        override var modifiers: Set<KoresModifier>
            get() = MODIFIERS
            set(value) {}


        constructor(defaults: StaticBlock) : this() {
            this.comments = defaults.comments
            this.innerTypes = defaults.innerTypes
            this.body = defaults.body

            this.fromData(defaults.data)
        }

        override fun name(value: String): Builder = self()

        override fun comments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun throwsClause(value: List<Type>): Builder = self()
        override fun annotations(value: List<Annotation>): Builder = self()
        override fun modifiers(value: Set<KoresModifier>): Builder = self()

        override fun returnType(value: Type): Builder = self()

        override fun parameters(value: List<KoresParameter>): Builder = self()

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun genericSignature(value: GenericSignature): Builder = self()

        override fun buildBasic(): StaticBlock = StaticBlock(this.comments, this.innerTypes, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: StaticBlock): Builder = Builder(defaults)
        }

    }

    companion object Constants {
        val NAME = "<clinit>"
        val MODIFIERS = setOf(KoresModifier.STATIC)
        val RETURN_TYPE = Types.VOID
    }
}
