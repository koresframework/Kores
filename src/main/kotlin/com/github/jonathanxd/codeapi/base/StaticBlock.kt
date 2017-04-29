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
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.common.CodeModifier
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Static block (aka class constructors/class initializers).
 */
data class StaticBlock(override val comments: Comments, override val body: CodeSource) : MethodDeclarationBase {
    init {
        BodyHolder.checkBody(this)
    }

    override val name: String
        get() = Constants.NAME

    override val annotations: List<Annotation>
        get() = emptyList()

    override val parameters: List<CodeParameter>
        get() = emptyList()

    override val returnType: Type
        get() = Constants.RETURN_TYPE

    override val genericSignature: GenericSignature
        get() = GenericSignature.empty()

    override val modifiers: Set<CodeModifier>
        get() = Constants.MODIFIERS

    override fun builder(): Builder = Builder(this)

    class Builder() : MethodDeclarationBase.Builder<StaticBlock, Builder> {

        var comments: Comments = Comments.Absent
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: StaticBlock) : this() {
            this.comments = defaults.comments
            this.body = defaults.body
        }

        override fun withName(value: String): Builder = self()

        override fun withComments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun withAnnotations(value: List<Annotation>): Builder = self()
        override fun withModifiers(value: Set<CodeModifier>): Builder = self()

        override fun withReturnType(value: Type): Builder = self()

        override fun withParameters(value: List<CodeParameter>): Builder = self()

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun withGenericSignature(value: GenericSignature): Builder = self()

        override fun build(): StaticBlock = StaticBlock(this.comments, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: StaticBlock): Builder = Builder(defaults)
        }

    }

    companion object Constants {
        val NAME = "<clinit>"
        val MODIFIERS = setOf(CodeModifier.STATIC)
        val RETURN_TYPE = Types.VOID
    }
}
