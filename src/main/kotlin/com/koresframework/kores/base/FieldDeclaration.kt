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

import com.koresframework.kores.KoresElement
import com.koresframework.kores.Instruction
import com.koresframework.kores.base.comment.CommentHolder
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.builder.self
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.factory.accessStatic
import com.koresframework.kores.factory.accessThis
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Declaration of a field.
 */
@Serializable
data class FieldDeclaration(
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    @Serializable(with = TypeSerializer::class) override val type: Type,
    override val name: String,
    override val innerTypes: List<TypeDeclaration>,
    override val value: Instruction
) :
    KoresElement, FieldBase, Named, Typed,
    ValueHolder, ModifiersHolder, Annotable, CommentHolder,
    InnerTypesHolder {

    override val data: KoresData = KoresData()

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

        override var data: KoresData = KoresData()
        override var comments: Comments = Comments.Absent
        override var annotations: List<Annotation> = emptyList()
        override var modifiers: Set<KoresModifier> = emptySet()
        override lateinit var type: Type
        override lateinit var name: String
        override var innerTypes: List<TypeDeclaration> = emptyList()
        override var value: Instruction = KoresNothing

        override var localization: Type
            get() = Alias.THIS
            set(value) {}

        override var target: Instruction
            get() = if (this.modifiers.contains(KoresModifier.STATIC)) accessStatic() else accessThis()
            set(value) {}

        constructor(defaults: FieldDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.type = defaults.type
            this.name = defaults.name
            this.innerTypes = defaults.innerTypes
            this.value = defaults.value

            this.fromData(defaults.data)
        }

        /**
         * Removes value definition
         */
        fun withoutValue(): Builder = this.value(KoresNothing)

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun buildBasic(): FieldDeclaration = FieldDeclaration(
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