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
@file:JvmName("CommentsFactory")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.comment.*
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.type.PlainCodeType
import java.lang.reflect.Type

/**
 * @see Comments
 */
@JvmOverloads fun comments(type: Comments.Type = Comments.Type.COMMENT, vararg comments: Comment): Comments =
        Comments(comments.toList(), type)

/**
 * @see Comments
 */
fun documentation(vararg comments: Comment): Comments =
        Comments(comments.toList(), Comments.Type.DOCUMENTATION)

/**
 * @see Plain
 */
fun plain(text: String): Comment =
        Plain(text)

/**
 * @see Code
 */
fun code(plain: String): Comment =
        Code(Code.CodeNode.Plain(plain))

/**
 * @see Code
 */
fun code(part: CodePart): Comment =
        Code(Code.CodeNode.CodeRepresentation(part))

/**
 * @see Link
 */
@JvmOverloads fun link(name: String? = null, url: String): Comment =
        Link(name, Link.LinkTarget.URL(url))

/**
 * @see Link
 */
@JvmOverloads fun link(name: String? = null, element: Link.LinkTarget.Element): Comment =
        Link(name, element)

/**
 * @see Link
 */
@JvmOverloads fun linkClass(name: String? = null, type: Type): Comment =
        Link(name, Link.LinkTarget.Element.Class(type))

/**
 * @see Link
 */
@JvmOverloads fun linkClass(name: String? = null, canonicalName: String): Comment =
        Link(name, Link.LinkTarget.Element.Class(PlainCodeType(canonicalName, false)))

/**
 * @see Link
 */
@JvmOverloads fun linkField(name: String? = null, declaringClass: Type, fieldName: String, fieldType: Type): Comment =
        Link(name, Link.LinkTarget.Element.Field(declaringClass, fieldName, fieldType))

/**
 * @see Link
 */
@JvmOverloads fun linkField(name: String? = null, declaringClass: String, fieldName: String, fieldType: Type): Comment =
        Link(name, Link.LinkTarget.Element.Field(PlainCodeType(declaringClass, false), fieldName, fieldType))

/**
 * @see Link
 */
@JvmOverloads fun linkMethod(name: String? = null, methodSpec: MethodTypeSpec): Comment =
        Link(name, Link.LinkTarget.Element.Method(methodSpec))
