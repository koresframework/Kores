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
import com.github.jonathanxd.codeapi.builder.FieldDeclarationBuilder
import com.github.jonathanxd.codeapi.common.CodeModifier
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.Alias
import com.github.jonathanxd.codeapi.util.self

/**
 * Field declaration
 */
interface FieldDeclaration : CodeElement, FieldBase, Named, Typed, ValueHolder, ModifiersHolder, Annotable {

    override val localization: CodeType
        get() = Alias.THIS

    override val target: CodePart
        get() = if (this.modifiers.contains(CodeModifier.STATIC)) CodeAPI.accessStatic() else CodeAPI.accessThis()


    override fun builder(): Builder<FieldDeclaration, *> = FieldDeclarationBuilder(this)

    interface Builder<out T : FieldDeclaration, S : Builder<T, S>> :
            FieldBase.Builder<T, S>,
            Named.Builder<T, S>,
            Typed.Builder<T, S>,
            ValueHolder.Builder<T, S>,
            ModifiersHolder.Builder<T, S>,
            Annotable.Builder<T, S> {

        override fun withLocalization(value: CodeType): S = self()
        override fun withTarget(value: CodePart): S = self()

    }
}