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

import com.koresframework.kores.Instructions
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.builder.self
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.dataFrom
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.type.isConcreteIdEq
import com.koresframework.kores.util.eq
import com.koresframework.kores.util.hash
import com.koresframework.kores.util.resolveQualifiedName
import com.koresframework.kores.util.resolveTypeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import java.lang.reflect.Type
import kotlin.reflect.KMutableProperty

/**
 * Annotation declaration.
 *
 * @property properties Properties of annotation declaration.
 * @see TypeDeclaration
 */
@Serializable
data class AnnotationDeclaration(
    override val comments: Comments,
    override val outerType: Type?,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val specifiedName: String,
    override val genericSignature: GenericSignature,
    val properties: List<AnnotationProperty>,
    override val fields: List<FieldDeclaration>,
    override val innerTypes: List<TypeDeclaration>
) : TypeDeclaration {

    override val data: KoresData = KoresData()
    override val methods: List<MethodDeclaration> = emptyList()
    override val staticBlock: StaticBlock =
        StaticBlock(Comments.Absent, emptyList(), Instructions.empty())

    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerType)

    @SerialName("annotationDeclarationType")
    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerType)

    override val isInterface: Boolean = true

    override fun builder(): Builder = Builder(this)

    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    class Builder() : TypeDeclaration.Builder<AnnotationDeclaration, Builder> {

        override var data: KoresData = KoresData()
        override var outerType: Type? = null
        override lateinit var specifiedName: String
        override var comments: Comments = Comments.Absent
        override var annotations: List<Annotation> = emptyList()
        override var fields: List<FieldDeclaration> = emptyList()
        override var innerTypes: List<TypeDeclaration> = emptyList()

        override var modifiers: Set<KoresModifier> = emptySet()
        override var genericSignature: GenericSignature = GenericSignature.empty()
        var properties: List<AnnotationProperty> = emptyList()

        override var methods: List<MethodDeclaration>
            get() = emptyList()
            set(value) {}

        override var staticBlock: StaticBlock
            get() = StaticBlock.Builder.builder().build()
            set(value) {}

        constructor(defaults: AnnotationDeclaration) : this() {
            this.outerType = defaults.outerType
            this.specifiedName = defaults.specifiedName
            this.comments = defaults.comments
            this.annotations = defaults.annotations

            this.fields = defaults.fields
            this.innerTypes = defaults.innerTypes

            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.properties = defaults.properties

            this.from(defaults)
        }

        override fun staticBlock(value: StaticBlock): Builder = self()
        override fun methods(value: List<MethodDeclaration>): Builder = self()

        /**
         * See [AnnotationDeclaration.properties]
         */
        fun properties(value: List<AnnotationProperty>): Builder {
            this.properties = value
            return this
        }

        /**
         * See [AnnotationDeclaration.properties]
         */
        fun properties(vararg values: AnnotationProperty): Builder = properties(values.toList())

        private fun addAnnotation(annotation: Annotation): Builder =
            ((this.annotations as? MutableList) ?: this.annotations.toMutableList()).let {
                annotations(it.filter { it.type.isConcreteIdEq(annotation.type) } + annotation)
            }

        /**
         * Adds retention annotation to annotation declaration (remove old retention annotation if it is already defined)
         */
        fun retention(retention: RetentionPolicy): Builder =
            addAnnotation(
                Annotation.Builder.builder()
                    .type(java.lang.annotation.Retention::class.java)
                    .values(mapOf("value" to EnumValue.Builder.builder().base(retention).build()))
                    .build()
            )

        /**
         * Adds target annotation to annotation declaration (remove old target annotation if it is already defined)
         */
        fun target(targets: Array<ElementType>): Builder =
            addAnnotation(
                Annotation.Builder.builder()
                    .type(java.lang.annotation.Target::class.java)
                    .values(
                        mapOf(
                            "value" to
                                    targets.map {
                                        EnumValue.Builder.builder().base(it).build()
                                    }.toTypedArray()
                        )
                    )
                    .build()
            )

        override fun buildBasic(): AnnotationDeclaration = AnnotationDeclaration(
            this.comments, this.outerType, this.annotations, this.modifiers,
            this.specifiedName, this.genericSignature, this.properties, this.fields, this.innerTypes
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: AnnotationDeclaration): Builder = Builder(defaults)
        }

    }

}
