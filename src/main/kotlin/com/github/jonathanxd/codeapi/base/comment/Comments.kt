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
package com.github.jonathanxd.codeapi.base.comment

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.builder.invoke

/**
 * Hold a list of comments.
 */
interface Comments : CodePart {

    /**
     * Comments
     */
    val comments: List<Comment>

    /**
     * Type of this comments node.
     */
    val type: Type

    /**
     * Returns true if this [Comments] instance is [Absent]. Absent comment is not the same as
     * empty comment.
     */
    fun isAbsent() = this === Absent

    /**
     * Returns true if this [Comments] instance is not [Absent]. Absent comment is not the same as
     * empty comment.
     */
    fun isNotAbsent() = this !== Absent

    override fun builder(): Builder<Comments, *> = CodeAPI.getBuilderProvider()(this)

    /**
     * Comment type
     */
    enum class Type {
        /**
         * A simple comment.
         */
        COMMENT,

        /**
         * Documentation comment.
         */
        DOCUMENTATION
    }

    interface Builder<out T : Comments, S : Builder<T, S>> : com.github.jonathanxd.codeapi.builder.Builder<T, S> {

        /**
         * See [T.comments]
         */
        fun withComments(value: List<Comment>): S

        /**
         * See [T.comments]
         */
        fun withComments(vararg values: Comment): S = withComments(values.toList())

        /**
         * See [T.type]
         */
        fun withType(value: Type): S

        companion object {
            fun builder(): Builder<Comments, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: Comments): Builder<Comments, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }

    /**
     * Absent comments. Absent comment should not be generated.
     */
    object Absent : Comments {
        override val comments: List<Comment> = emptyList()
        override val type: Type = Type.COMMENT
    }
}

