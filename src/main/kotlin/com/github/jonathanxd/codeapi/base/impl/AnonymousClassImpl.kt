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
package com.github.jonathanxd.codeapi.base.impl

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.AnonymousClass
import com.github.jonathanxd.codeapi.base.BodyHolder
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.common.TypeSpec
import com.github.jonathanxd.codeapi.util.eq
import com.github.jonathanxd.codeapi.util.hash
import com.github.jonathanxd.codeapi.util.resolveQualifiedName
import com.github.jonathanxd.codeapi.util.resolveTypeName
import com.github.jonathanxd.iutils.string.ToStringHelper
import java.lang.reflect.Type

class AnonymousClassImpl(qualifiedName: String, override val constructorSpec: TypeSpec, override val arguments: List<CodePart>, override val constructorBody: CodeSource, override val annotations: List<Annotation>, override val body: CodeSource, override val comments: Comments, override val superClass: Type, override val outerClass: Type?) : AnonymousClass {

    override val specifiedName: String = qualifiedName

    override val qualifiedName: String = qualifiedName
        get() = resolveQualifiedName(field, this.outerClass)

    override val type: String = qualifiedName
        get() = resolveTypeName(field, this.outerClass)

    init {
        BodyHolder.checkBody(this)
    }

    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)
    override fun toString(): String =
            ToStringHelper.defaultHelper("AnonymousClassImpl")
                    .add("outerClass", this.outerClass)
                    .add("annotations", this.annotations)
                    .add("modifiers", this.modifiers)
                    .add("qualifiedName", this.qualifiedName)
                    .add("genericSignature", this.genericSignature)
                    .add("constructorSpec", this.constructorSpec)
                    .add("superClass", this.superClass)
                    .add("constructorBody", this.constructorSpec)
                    .add("body", this.body)
                    .toString()

}