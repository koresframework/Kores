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

import com.github.jonathanxd.kores.KoresElement
import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.base.comment.CommentHolder
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.common.KoresNothing
import com.github.jonathanxd.kores.factory.accessStatic
import com.github.jonathanxd.kores.factory.accessThis
import java.lang.reflect.Type

/**
 * Declaration of a field.
 */
data class FieldDeclaration(
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val type: Type,
    override val name: String,
    override val innerTypes: List<TypeDeclaration>,
    override val value: Instruction
) :
    KoresElement, FieldBase, Named, Typed,
    ValueHolder, ModifiersHolder, Annotable, CommentHolder,
    InnerTypesHolder {

    override val localization: Type
        get() = Alias.THIS

    override val target: Instruction
        get() = if (this.modifiers.contains(KoresModifier.STATIC)) accessStatic() else accessThis()


    override fun builder(): Builder = Builder(this)

    class Builder() :
        FieldBase.Builder<FieldDeclaration, Builder>,
        Named.Builder<FieldDeclaration, Builder>,
        Typed.Builder<FieldDeclaration, Builder>,
        ValueHolder.Builder<FieldDeclaration, Builder>,
        ModifiersHolder.Builder<FieldDeclaration, Builder>,
        Annotable.Builder<FieldDeclaration, Builder>,
        CommentHolder.Builder<FieldDeclaration, Builder>,
        InnerTypesHolder.Builder<FieldDeclaration, Builder> {

        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()
        var modifiers: Set<KoresModifier> = emptySet()
        lateinit var type: Type
        lateinit var name: String
        var innerTypes: List<TypeDeclaration> = emptyList()
        var value: Instruction = KoresNothing

        constructor(defaults: FieldDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.type = defaults.type
            this.name = defaults.name
            this.innerTypes = defaults.innerTypes
            this.value = defaults.value
        }

        override fun localization(value: Type): Builder = self()
        override fun target(value: Instruction): Builder = self()

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

        override fun type(value: Type): Builder {
            this.type = value
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        /**
         * Removes value definition
         */
        fun withoutValue(): Builder = this.value(KoresNothing)

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun build(): FieldDeclaration = FieldDeclaration(
            this.comments, this.annotations,
            this.modifiers, this.type, this.name, this.innerTypes, this.value
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: FieldDeclaration): Builder = Builder(defaults)
        }

    }
}