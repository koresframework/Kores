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
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.util.getPartType
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Case statement of [SwitchStatement].
 *
 * @property value Value to check if operating element matches, null for `default` case.
 * @property body Body of case statement.
 */
data class Case(override val value: CodePart?, override val body: CodeSource) : ValueHolder, Typed, BodyHolder {

    override val type: Type
        get() = this.value?.getPartType() ?: Types.INT

    /**
     * Is case default
     */
    val isDefault get() = this.value == null

    /**
     * Is not case default
     */
    val isNotDefault get() = !this.isDefault

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
            ValueHolder.Builder<Case, Builder>,
            Typed.Builder<Case, Builder>,
            BodyHolder.Builder<Case, Builder> {

        var value: CodePart? = null
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: Case) : this() {
            this.value = defaults.value
            this.body = defaults.body
        }

        override fun withType(value: Type): Builder = self()

        /**
         * Sets the case statement as `default` case (same as `withValue(null)`).
         */
        fun setDefault(): Builder {
            this.value = null
            return this
        }

        override fun withValue(value: CodePart?): Builder {
            this.value = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun build(): Case = Case(this.value, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Case): Builder = Builder(defaults)
        }

    }
}