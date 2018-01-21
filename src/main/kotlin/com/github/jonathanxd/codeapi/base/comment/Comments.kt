/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart

/**
 * Hold a list of comments.
 *
 * @property comments Comment list
 * @property type Type of comments entry.
 */
data class Comments(val comments: List<Comment>, val type: Type) : CodePart, CodeInstruction {

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

    override fun builder(): Builder = Builder(this)

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

    class Builder() : com.github.jonathanxd.codeapi.builder.Builder<Comments, Builder> {

        var comments: List<Comment> = emptyList()
        lateinit var type: Type

        constructor(defaults: Comments) : this() {
            this.comments = defaults.comments
            this.type = defaults.type
        }

        /**
         * See [Comments.comments]
         */
        fun comments(value: List<Comment>): Builder {
            this.comments = value
            return this
        }

        /**
         * See [Comments.comments]
         */
        fun comments(vararg values: Comment): Builder = this.comments(values.toList())

        /**
         * See [Comments.type]
         */
        fun type(value: Type): Builder {
            this.type = value
            return this
        }

        override fun build(): Comments = Comments(this.comments, this.type)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Comments): Builder = Builder(defaults)
        }

    }


    companion object {
        /**
         * Absent comments. Absent comment should not be generated.
         */
        @JvmField
        val Absent = Comments(emptyList(), Type.COMMENT)
    }
}
