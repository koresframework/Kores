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

import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import java.lang.reflect.Type

/**
 * Link comment: comment linking to an element or a url
 *
 * @property name Title/name of link (null to default)
 * @property target Link target.
 */
data class Link(val name: String?, val target: LinkTarget) : Comment {

    override fun builder(): Builder = Builder(this)

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
             * @param type Class type.
             */
            data class Class(val type: Type) : Element

            /**
             * A link to a method
             *
             * @param spec Method specification
             */
            data class Method(val spec: MethodTypeSpec) : Element

            /**
             * A link to a field
             *
             * @param declaringClass Declaring class of the field.
             * @param name Field name.
             * @param type Field type.
             */
            data class Field(val declaringClass: Type, val name: String, val type: Type) : Element

        }

        /**
         * A link to a website url.
         *
         * @param url Website url
         */
        data class URL(val url: String) : LinkTarget
    }

    class Builder() : com.github.jonathanxd.codeapi.builder.Builder<Link, Builder> {

        var name: String? = null
        lateinit var target: LinkTarget

        constructor(defaults: Link) : this() {
            this.name = defaults.name
            this.target = defaults.target
        }

        /**
         * See [Link.name]
         */
        fun withName(value: String?): Builder {
            this.name = value
            return this
        }

        /**
         * See [Link.target]
         */
        fun withTarget(value: LinkTarget): Builder {
            this.target = value
            return this
        }

        override fun build(): Link = Link(this.name, this.target)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Link): Builder = Builder(defaults)
        }

    }
}
