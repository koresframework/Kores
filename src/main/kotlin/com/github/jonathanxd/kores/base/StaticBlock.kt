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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.generic.GenericSignature
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

        var comments: Comments = Comments.Absent
        var innerTypes: List<TypeDeclaration> = emptyList()
        var body: Instructions = Instructions.empty()

        constructor(defaults: StaticBlock) : this() {
            this.comments = defaults.comments
            this.innerTypes = defaults.innerTypes
            this.body = defaults.body
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

        override fun build(): StaticBlock = StaticBlock(this.comments, this.innerTypes, this.body)

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
