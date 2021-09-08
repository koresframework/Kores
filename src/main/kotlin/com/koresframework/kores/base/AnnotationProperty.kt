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

import com.koresframework.kores.base.comment.CommentHolder
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.dataFrom
import com.koresframework.kores.serialization.AnnotationAnySerializer
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Annotation property, this is part of [AnnotationDeclaration].
 *
 * @property defaultValue Annotation default value, must be: [Byte], [Boolean], [Char], [Short],
 * [Int], [Long], [Float], [Double], [String], [Type], [EnumValue], other [Annotation] or a List
 * of one of types cited above (with or without elements).
 */
@Serializable
data class AnnotationProperty(
    override val comments: Comments,
    override val annotations: List<Annotation>,
    @Serializable(with = TypeSerializer::class) override val type: Type,
    override val name: String,
    @Serializable(with = AnnotationAnySerializer::class) val defaultValue: Any?
) : Named, Typed, Annotable, ReturnTypeHolder, CommentHolder {
    override val data: KoresData = KoresData()
    override val returnType: Type
        get() = this.type

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Named.Builder<AnnotationProperty, Builder>,
        Typed.Builder<AnnotationProperty, Builder>,
        Annotable.Builder<AnnotationProperty, Builder>,
        ReturnTypeHolder.Builder<AnnotationProperty, Builder>,
        CommentHolder.Builder<AnnotationProperty, Builder> {

        override var data = KoresData()
        override var comments: Comments = Comments.Absent
        override var annotations: List<Annotation> = emptyList()
        override lateinit var name: String
        override lateinit var type: Type
        var defaultValue: Any? = null

        override var returnType: Type
            get() = this.type
            set(value) { this.type = value }

        constructor(defaults: AnnotationProperty) : this() {
            this.annotations = defaults.annotations
            this.name = defaults.name
            this.type = defaults.type
            this.defaultValue = defaults.defaultValue

            this.fromData(defaults.data)
        }

        override fun annotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun returnType(value: Type): Builder = this.type(value)

        /**
         * See [AnnotationProperty.defaultValue]
         */
        fun defaultValue(value: Any?): Builder {
            this.defaultValue = value
            return this
        }

        override fun buildBasic(): AnnotationProperty = AnnotationProperty(
            this.comments, this.annotations,
            this.type, this.name, this.defaultValue
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: AnnotationProperty): Builder = Builder(defaults)
        }

    }
}