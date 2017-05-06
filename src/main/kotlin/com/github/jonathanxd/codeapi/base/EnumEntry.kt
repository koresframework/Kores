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
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Enumeration entry.
 *
 * @property constructorSpec Enum constructor specification. Null for default enum constructor.
 * @property arguments Enum constructor arguments
 */
data class EnumEntry(override val name: String,
                     val constructorSpec: TypeSpec?,
                     override val arguments: List<CodePart>,
                     override val body: CodeSource) : ArgumentHolder, Named, BodyHolder {
    init {
        BodyHolder.checkBody(this)
    }

    override val types: List<Type>
        get() = this.constructorSpec?.parameterTypes ?: emptyList()

    override val array: Boolean
        get() = false

    override fun builder(): Builder = Builder(this)

    class Builder() :
            ArgumentHolder.Builder<EnumEntry, Builder>,
            Named.Builder<EnumEntry, Builder>,
            BodyHolder.Builder<EnumEntry, Builder> {

        lateinit var name: String
        var constructorSpec: TypeSpec? = null
        var arguments: List<CodePart> = emptyList()
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: EnumEntry) : this() {
            this.name = defaults.name
            this.constructorSpec = defaults.constructorSpec
            this.arguments = defaults.arguments
            this.body = defaults.body
        }

        override fun withArray(value: Boolean): Builder = self()

        /**
         * See [EnumEntry.constructorSpec]
         */
        fun withConstructorSpec(value: TypeSpec?): Builder {
            this.constructorSpec = value
            return this
        }

        override fun withName(value: String): Builder {
            this.name = value
            return this
        }

        override fun withArguments(value: List<CodePart>): Builder {
            this.arguments = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }


        override fun build(): EnumEntry = EnumEntry(this.name, this.constructorSpec, this.arguments, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: EnumEntry): Builder = Builder(defaults)
        }

    }
}
