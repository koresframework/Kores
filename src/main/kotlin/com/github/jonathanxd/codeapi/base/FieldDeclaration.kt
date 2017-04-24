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

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodeElement
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.base.comment.CommentHolder
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.CodeModifier
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
                            override val value: CodePart?) : CodeElement, FieldBase, Named, Typed, ValueHolder, ModifiersHolder, Annotable, CommentHolder {

    override val localization: Type
        get() = Alias.THIS

    override val target: CodePart
        get() = if (this.modifiers.contains(CodeModifier.STATIC)) CodeAPI.accessStatic() else CodeAPI.accessThis()


    override fun builder(): Builder = CodeAPI.getBuilderProvider()(this)

    interface Builder :
            FieldBase.Builder<FieldDeclaration, Builder>,
            Named.Builder<FieldDeclaration, Builder>,
            Typed.Builder<FieldDeclaration, Builder>,
            ValueHolder.Builder<FieldDeclaration, Builder>,
            ModifiersHolder.Builder<FieldDeclaration, Builder>,
            Annotable.Builder<FieldDeclaration, Builder>,
            CommentHolder.Builder<FieldDeclaration, Builder> {

        override fun withLocalization(value: Type): Builder = self()
        override fun withTarget(value: CodePart): Builder = self()

        companion object {
            fun builder(): Builder = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: FieldDeclaration): Builder = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }
}