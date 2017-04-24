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

import com.github.jonathanxd.codeapi.CodePart
import java.lang.reflect.Type as ReflectType


/**
 * Access to a scope of a type. Example, access to static scope of [String].
 *
 * @property type Type of the access
 * @property localization Localization of access.
 */
data class Access(val type: Type, val localization: ReflectType?) : CodePart {
    override fun builder(): Builder = Builder(this)

    class Builder() : com.github.jonathanxd.codeapi.builder.Builder<Access, Builder> {

        lateinit var type: Type
        var localization: ReflectType? = null

        constructor(defaults: Access) : this() {
            this.type = defaults.type
            this.localization = defaults.localization
        }

        /**
         * See [Access.type]
         */
        fun withType(type: Type): Builder {
            this.type = type
            return this
        }

        /**
         * See [Access.localization]
         */
        fun withLocalization(localization: ReflectType?): Builder {
            this.localization = localization;
            return this
        }

        override fun build() = Access(this.type, this.localization)

        companion object {
            @JvmStatic
            fun builder() = Builder()

            @JvmStatic
            fun builder(defaults: Access) = Builder(defaults)
        }
    }

    enum class Type {

        /**
         * Access to local scope
         */
        LOCAL,

        /**
         * Access to static scope
         */
        STATIC,

        /**
         * Access to this scope
         */
        THIS,

        /**
         * Access to outer class scope
         */
        OUTER,

        /**
         * Access to super class scope
         */
        SUPER
    }
}

