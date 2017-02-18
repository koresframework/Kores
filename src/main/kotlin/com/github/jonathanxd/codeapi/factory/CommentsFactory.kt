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
import com.github.jonathanxd.codeapi.base.comment.Code
import com.github.jonathanxd.codeapi.base.comment.Comment
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.base.comment.Link
import com.github.jonathanxd.codeapi.base.impl.comment.CodeImpl
import com.github.jonathanxd.codeapi.base.impl.comment.CommentsImpl
import com.github.jonathanxd.codeapi.base.impl.comment.LinkImpl
import com.github.jonathanxd.codeapi.base.impl.comment.PlainImpl
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.type.CodeType

@JvmOverloads fun comments(type: Comments.Type = Comments.Type.COMMENT, vararg comments: Comment): Comments = CommentsImpl(comments.toList(), type)
fun documentation(vararg comments: Comment): Comments = CommentsImpl(comments.toList(), Comments.Type.DOCUMENTATION)

fun plain(text: String): Comment = PlainImpl(text)

fun code(plain: String): Comment = CodeImpl(Code.CodeNode.Plain(plain))
fun code(part: CodePart): Comment = CodeImpl(Code.CodeNode.CodeRepresentation(part))

@JvmOverloads fun link(name: String? = null, url: String): Comment = LinkImpl(name, Link.LinkTarget.URL(url))
@JvmOverloads fun link(name: String? = null, element: Link.LinkTarget.Element): Comment = LinkImpl(name, element)

@JvmOverloads fun linkClass(name: String? = null, canonicalName: String): Comment = LinkImpl(name, Link.LinkTarget.Element.Class(canonicalName))

@JvmOverloads fun linkField(name: String? = null, declaringClass: String, fieldName: String, fieldType: CodeType): Comment = LinkImpl(name, Link.LinkTarget.Element.Field(declaringClass, fieldName, fieldType))

@JvmOverloads fun linkMethod(name: String? = null, methodSpec: MethodTypeSpec): Comment = LinkImpl(name, Link.LinkTarget.Element.Method(methodSpec))
