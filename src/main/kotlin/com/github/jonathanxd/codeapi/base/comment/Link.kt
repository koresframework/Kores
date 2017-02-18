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

import com.github.jonathanxd.codeapi.builder.LinkBuilder
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Link comment: comment linking to an element or a url
 */
interface Link : Comment {

    /**
     * Name of the link.
     */
    val name: String?

    /**
     * Link target.
     */
    val target: LinkTarget

    override fun builder(): Builder<Link, *> = LinkBuilder()

    /**
     * Target of the link
     */
    interface LinkTarget {

        /**
         * A link to an element
         */
        interface Element : LinkTarget {

            /**
             * A link to a class
             *
             * @param canonicalName Canonical name of the class
             */
            data class Class(val canonicalName: String) : Element

            /**
             * A link to a method
             *
             * @param spec Method specification
             */
            data class Method(val spec: MethodTypeSpec) : Element

            /**
             * A link to a field
             *
             * @param declaringClass Canonical name of declaring class of the field.
             * @param name Field name.
             * @param type Field type.
             */
            data class Field(val declaringClass: String, val name: String, val type: CodeType) : Element

        }

        /**
         * A link to a website url.
         *
         * @param url Website url
         */
        data class URL(val url: String) : LinkTarget
    }

    interface Builder<out T : Link, S : Builder<T, S>> : com.github.jonathanxd.codeapi.builder.Builder<T, S> {

        /**
         * See [T.name]
         */
        fun withName(value: String?): S

        /**
         * See [T.target]
         */
        fun withTarget(value: LinkTarget): S
    }
}