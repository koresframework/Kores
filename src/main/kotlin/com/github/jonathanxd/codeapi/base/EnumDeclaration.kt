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
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.CodeModifier
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.eq
import com.github.jonathanxd.codeapi.util.hash
import com.github.jonathanxd.codeapi.util.resolveQualifiedName
import com.github.jonathanxd.codeapi.util.resolveTypeName
import java.lang.reflect.Type


/**
 * Enum declaration.
 */
data class EnumDeclaration(override val outerClass: Type?,
                           override val comments: Comments,
                           override val annotations: List<Annotation>,
                           override val modifiers: Set<CodeModifier>,
                           override val specifiedName: String,
                           override val genericSignature: GenericSignature,
                           override val implementations: List<Type>,
                           override val entries: List<EnumEntry>,
                           override val body: CodeSource) : TypeDeclaration, ImplementationHolder, EntryHolder {


    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerClass)

    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerClass)

    init {
        BodyHolder.checkBody(this)
    }

    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    override fun builder(): Builder = CodeAPI.getBuilderProvider()(this)

    interface Builder :
            TypeDeclaration.Builder<EnumDeclaration, Builder>,
            ImplementationHolder.Builder<EnumDeclaration, Builder>,
            EntryHolder.Builder<EnumDeclaration, Builder> {

        companion object {
            fun builder(): Builder = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: EnumDeclaration): Builder = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }

}