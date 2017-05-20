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

import com.github.jonathanxd.codeapi.CodeElement
import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.comment.CommentHolder
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.factory.accessStatic
import com.github.jonathanxd.codeapi.factory.accessThis
import com.github.jonathanxd.codeapi.util.Alias
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Declaration of a field.
 */
data class FieldDeclaration(override val comments: Comments,
                            override val annotations: List<Annotation>,
                            override val modifiers: Set<CodeModifier>,
                            override val type: Type,
                            override val name: String,
                            override val innerTypes: List<TypeDeclaration>,
                            override val value: CodePart?) :
        CodeElement, FieldBase, Named, Typed,
        ValueHolder, ModifiersHolder, Annotable, CommentHolder, CodeInstruction,
        InnerTypesHolder {

    override val localization: Type
        get() = Alias.THIS

    override val target: CodePart
        get() = if (this.modifiers.contains(CodeModifier.STATIC)) accessStatic() else accessThis()


    override fun builder(): Builder = Builder(this)

    class Builder() :
            FieldBase.Builder<FieldDeclaration, Builder>,
            Named.Builder<FieldDeclaration, Builder>,
            Typed.Builder<FieldDeclaration, Builder>,
            ValueHolder.Builder<FieldDeclaration, Builder>,
            ModifiersHolder.Builder<FieldDeclaration, Builder>,
            Annotable.Builder<FieldDeclaration, Builder>,
            CommentHolder.Builder<FieldDeclaration, Builder>,
            InnerTypesHolder.Builder<FieldDeclaration, Builder>{

        var comments: Comments = Comments.Absent
        var annotations: List<Annotation> = emptyList()
        var modifiers: Set<CodeModifier> = emptySet()
        lateinit var type: Type
        lateinit var name: String
        var innerTypes: List<TypeDeclaration> = emptyList()
        var value: CodePart? = null

        constructor(defaults: FieldDeclaration) : this() {
            this.comments = defaults.comments
            this.annotations = defaults.annotations
            this.modifiers = defaults.modifiers
            this.type = defaults.type
            this.name = defaults.name
            this.innerTypes = defaults.innerTypes
            this.value = defaults.value
        }

        override fun withLocalization(value: Type): Builder = self()
        override fun withTarget(value: CodePart): Builder = self()

        override fun withComments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun withAnnotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun withModifiers(value: Set<CodeModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun withType(value: Type): Builder {
            this.type = value
            return this
        }

        override fun withName(value: String): Builder {
            this.name = value
            return this
        }

        override fun withValue(value: CodePart?): Builder {
            this.value = value
            return this
        }

        override fun withInnerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun build(): FieldDeclaration = FieldDeclaration(this.comments, this.annotations,
                this.modifiers, this.type, this.name, this.innerTypes, this.value)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: FieldDeclaration): Builder = Builder(defaults)
        }

    }
}