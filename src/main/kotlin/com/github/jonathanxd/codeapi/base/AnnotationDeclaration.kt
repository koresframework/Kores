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
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.eq
import com.github.jonathanxd.codeapi.util.hash
import com.github.jonathanxd.codeapi.util.resolveQualifiedName
import com.github.jonathanxd.codeapi.util.resolveTypeName
import java.lang.reflect.Type

/**
 * Annotation declaration.
 *
 * @property properties Properties of annotation declaration.
 */
data class AnnotationDeclaration(override val comments: Comments,
                                 override val outerClass: Type?,
                                 override val annotations: List<Annotation>,
                                 override val modifiers: Set<CodeModifier>,
                                 override val specifiedName: String,
                                 override val genericSignature: GenericSignature,
                                 val properties: List<AnnotationProperty>,
                                 override val body: CodeSource) : TypeDeclaration {

    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerClass)

    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerClass)

    override val isInterface: Boolean
        get() = true

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    class Builder() : TypeDeclaration.Builder<AnnotationDeclaration, Builder> {

        var outerClass: Type? = null
        lateinit var specifiedName: String
        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()
        var body: CodeSource = CodeSource.empty()
        var modifiers: Set<CodeModifier> = emptySet()
        var genericSignature: GenericSignature = GenericSignature.empty()
        var properties: List<AnnotationProperty> = emptyList()

        constructor(defaults: AnnotationDeclaration) : this() {
            this.outerClass = defaults.outerClass
            this.specifiedName = defaults.specifiedName
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.body = defaults.body
            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.properties = defaults.properties
        }

        override fun withComments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun withAnnotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun withModifiers(value: Set<CodeModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun withGenericSignature(value: GenericSignature): Builder {
            this.genericSignature = value
            return this
        }

        override fun withSpecifiedName(value: String): Builder {
            this.specifiedName = value
            return this
        }

        override fun withOuterClass(value: Type?): Builder {
            this.outerClass = value
            return this
        }

        /**
         * See [AnnotationDeclaration.properties]
         */
        fun withProperties(value: List<AnnotationProperty>): Builder {
            this.properties = value
            return this
        }

        /**
         * See [AnnotationDeclaration.properties]
         */
        fun withProperties(vararg values: AnnotationProperty): Builder = withProperties(values.toList())


        override fun build() = AnnotationDeclaration(this.comments, this.outerClass, this.annotations, this.modifiers,
                this.specifiedName, this.genericSignature, this.properties, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: AnnotationDeclaration): Builder = Builder(defaults)
        }

    }

}
