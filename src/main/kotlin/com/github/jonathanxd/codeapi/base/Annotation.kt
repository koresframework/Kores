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

import java.lang.reflect.Type

typealias CodeAnnotation = Annotation

/**
 * An annotation, an annotation is composed by a pair of property name and property value.
 *
 * @property visible True if this annotation is visible at runtime (may not affect all generators).
 * @property type Type of annotation.
 * @property values Map of annotation values (key is the property of annotation),
 * the Annotation value must be: [Byte], [Boolean], [Char], [Short],
 * [Int], [Long], [Float], [Double], [String], [Type], OBJECT, ARRAY,
 * [EnumValue] or other [Annotation].
 */
data class Annotation(override val type: Type, val values: Map<String, Any>, val visible: Boolean) : Typed {
    override fun builder(): Builder = Builder(this)

    class Builder() : Typed.Builder<Annotation, Builder> {

        lateinit var type: Type
        var values: Map<String, Any> = emptyMap()
        var visible: Boolean = false

        constructor(defaults: Annotation) : this() {
            this.type = defaults.type
            this.values = defaults.values
            this.visible = defaults.visible
        }

        /**
         * See [Annotation.type]
         */
        override fun type(value: Type): Builder {
            this.type = value
            return this
        }

        /**
         * See [Annotation.values]
         */
        fun values(value: Map<String, Any>): Builder {
            this.values = value
            return this
        }

        /**
         * See [Annotation.visible]
         */
        fun visible(value: Boolean): Builder {
            this.visible = value
            return this
        }

        override fun build(): Annotation = Annotation(type, values, visible)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Annotation): Builder = Builder(defaults)
        }

    }
}
