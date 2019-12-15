/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.kores.base.comment.Comments
import com.github.jonathanxd.kores.builder.self
import com.github.jonathanxd.kores.generic.GenericSignature
import com.github.jonathanxd.kores.util.eq
import com.github.jonathanxd.kores.util.hash
import com.github.jonathanxd.kores.util.resolveQualifiedName
import com.github.jonathanxd.kores.util.resolveTypeName
import java.lang.reflect.Type

/**
 * Interface declaration.
 */
data class InterfaceDeclaration(
    override val outerType: Type?,
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val specifiedName: String,
    override val genericSignature: GenericSignature,
    override val implementations: List<Type>,
    override val fields: List<FieldDeclaration>,
    override val methods: List<MethodDeclaration>,
    override val innerTypes: List<TypeDeclaration>
) : TypeDeclaration, ImplementationHolder {

    override val staticBlock: StaticBlock =
        StaticBlock(Comments.Absent, emptyList(), Instructions.empty())

    override val isInterface: Boolean
        get() = true

    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerType)

    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerType)


    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    override fun builder(): Builder = Builder(this)

    class Builder() : TypeDeclaration.Builder<InterfaceDeclaration, Builder>,
        ImplementationHolder.Builder<InterfaceDeclaration, Builder> {

        var outerClass: Type? = null
        lateinit var specifiedName: String
        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()

        var fields: List<FieldDeclaration> = emptyList()
        var methods: List<MethodDeclaration> = emptyList()
        var innerTypes: List<TypeDeclaration> = emptyList()

        var modifiers: Set<KoresModifier> = emptySet()
        var genericSignature: GenericSignature = GenericSignature.empty()
        var implementations: List<Type> = emptyList()

        constructor(defaults: InterfaceDeclaration) : this() {
            this.outerClass = defaults.outerType
            this.specifiedName = defaults.specifiedName
            this.comments = defaults.comments
            this.annotations = defaults.annotations

            this.fields = defaults.fields
            this.methods = defaults.methods
            this.innerTypes = defaults.innerTypes

            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.implementations = defaults.implementations
        }

        override fun comments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun annotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }


        override fun staticBlock(value: StaticBlock): Builder = self()

        override fun fields(value: List<FieldDeclaration>): Builder {
            this.fields = value
            return this
        }

        override fun methods(value: List<MethodDeclaration>): Builder {
            this.methods = value
            return this
        }

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun modifiers(value: Set<KoresModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun genericSignature(value: GenericSignature): Builder {
            this.genericSignature = value
            return this
        }

        override fun specifiedName(value: String): Builder {
            this.specifiedName = value
            return this
        }

        override fun outerType(value: Type?): Builder {
            this.outerClass = value
            return this
        }

        override fun implementations(value: List<Type>): Builder {
            this.implementations = value
            return this
        }

        override fun build() = InterfaceDeclaration(
            this.outerClass, this.comments, this.annotations, this.modifiers,
            this.specifiedName, this.genericSignature, this.implementations,
            this.fields, this.methods, this.innerTypes
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: InterfaceDeclaration): Builder = Builder(defaults)
        }

    }
}
