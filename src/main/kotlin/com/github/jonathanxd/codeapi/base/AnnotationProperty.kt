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

import com.github.jonathanxd.codeapi.base.comment.CommentHolder
import com.github.jonathanxd.codeapi.base.comment.Comments
import java.lang.reflect.Type

/**
 * Annotation property, this is part of [AnnotationDeclaration].
 *
 * @property defaultValue Annotation default value, must be: [Byte], [Boolean], [Char], [Short],
 * [Int], [Long], [Float], [Double], [String], [Type], [EnumValue], other [Annotation] or an ARRAY
 * of one of types cited above (with or without elements).
 */
data class AnnotationProperty(override val comments: Comments,
                              override val annotations: List<Annotation>,
                              override val type: Type,
                              override val name: String,
                              val defaultValue: Any?) : Named, Typed, Annotable, ReturnTypeHolder, CommentHolder {
    override val returnType: Type
        get() = this.type

    override fun builder(): Builder = Builder(this)

    class Builder() :
            Named.Builder<AnnotationProperty, Builder>,
            Typed.Builder<AnnotationProperty, Builder>,
            Annotable.Builder<AnnotationProperty, Builder>,
            ReturnTypeHolder.Builder<AnnotationProperty, Builder>,
            CommentHolder.Builder<AnnotationProperty, Builder> {

        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()
        lateinit var name: String
        lateinit var type: Type
        var defaultValue: Any? = null

        constructor(defaults: AnnotationProperty) : this() {
            this.annotations = defaults.annotations
            this.name = defaults.name
            this.type = defaults.type
            this.defaultValue = defaults.defaultValue
        }

        override fun comments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun type(value: Type): Builder {
            this.type = value
            return this
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

        override fun build(): AnnotationProperty = AnnotationProperty(this.comments, this.annotations,
                this.type, this.name, this.defaultValue)


        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: AnnotationProperty): Builder = Builder(defaults)
        }

    }
}