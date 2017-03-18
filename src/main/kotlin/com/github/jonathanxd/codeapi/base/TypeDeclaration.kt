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

import com.github.jonathanxd.codeapi.CodeRoot
import com.github.jonathanxd.codeapi.base.comment.CommentHolder
import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Base class of all [TypeDeclaration]s like classes, interfaces and enums, and inner classes.
 *
 * The [qualifiedName] MUST return a qualifiedName even for the inner classes, the [qualifiedName] of
 * inner classes must be: '[outerClass qualifiedName][qualifiedName] + simpleInnerName'.
 */
interface TypeDeclaration : CodeRoot, ModifiersHolder, CodeType, QualifiedNamed, GenericSignatureHolder, BodyHolder, Annotable, CommentHolder {

    /**
     * Outer class (null if this type is not a inner class).
     */
    val outerClass: CodeType?

    /**
     * The specified name (for inner classes this property is set to simple name of inner class)
     */
    val specifiedName: String
        get() = this.qualifiedName

    /**
     * Defined qualified name
     */
    override val qualifiedName: String

    override val type: String
        get() = this.qualifiedName

    override val canonicalName: String
        get() = this.qualifiedName

    override fun builder(): Builder<TypeDeclaration, *>

    interface Builder<out T : TypeDeclaration, S : Builder<T, S>> :
            ModifiersHolder.Builder<T, S>,
            QualifiedNamed.Builder<T, S>,
            GenericSignatureHolder.Builder<T, S>,
            BodyHolder.Builder<T, S>,
            Annotable.Builder<T, S>,
            CommentHolder.Builder<T, S> {

        override fun withQualifiedName(value: String): S

        fun withOuterClass(value: CodeType?): S
    }
}