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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.base.impl.EnumEntryImpl
import com.github.jonathanxd.codeapi.base.EnumEntry

// Generated by BuilderGen
open class EnumEntryBuilder(): EnumEntry.Builder<EnumEntry, EnumEntryBuilder> {

    /**
     * See [EnumEntry.constructorSpec]
     */
    var constructorSpec: com.github.jonathanxd.codeapi.common.TypeSpec? = null

    /**
     * See [EnumEntry.arguments]
     */
    var arguments: kotlin.collections.List<com.github.jonathanxd.codeapi.common.CodeArgument> = emptyList()

    /**
     * See [EnumEntry.name]
     */
    lateinit var name: kotlin.String

    /**
     * See [EnumEntry.body]
     */
    var body: com.github.jonathanxd.codeapi.CodeSource? = null

    constructor(defaults: EnumEntry) : this() {
        this.constructorSpec = defaults.constructorSpec
        this.arguments = defaults.arguments
        this.name = defaults.name
        this.body = defaults.body
    }


    /**
     * See [EnumEntry.constructorSpec]
     */
    override fun withConstructorSpec(value: com.github.jonathanxd.codeapi.common.TypeSpec?): EnumEntryBuilder {
        this.constructorSpec = value
        return this
    }


    /**
     * See [EnumEntry.arguments]
     */
    override fun withArguments(value: kotlin.collections.List<com.github.jonathanxd.codeapi.common.CodeArgument>): EnumEntryBuilder {
        this.arguments = value
        return this
    }


    /**
     * See [EnumEntry.arguments]
     */
    override fun withArguments(vararg values: com.github.jonathanxd.codeapi.common.CodeArgument): EnumEntryBuilder {
        this.arguments = values.toList()
        return this
    }


    /**
     * See [EnumEntry.name]
     */
    override fun withName(value: kotlin.String): EnumEntryBuilder {
        this.name = value
        return this
    }


    /**
     * See [EnumEntry.body]
     */
    override fun withBody(value: com.github.jonathanxd.codeapi.CodeSource?): EnumEntryBuilder {
        this.body = value
        return this
    }

    override fun build(): EnumEntry = EnumEntryImpl(
            constructorSpec = this.constructorSpec,
            arguments = this.arguments,
            name = this.name,
            body = this.body
    )


    companion object {
        @JvmStatic
        fun builder() = EnumEntryBuilder()
    }
}