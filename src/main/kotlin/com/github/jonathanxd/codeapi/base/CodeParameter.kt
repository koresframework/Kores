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

/**
 * Parameter part.
 */
data class CodeParameter(override val annotations: List<Annotation>, override val modifiers: Set<CodeModifier>, override val type: Type, override val name: String) : Typed, Named, Annotable, ModifiersHolder {
    override fun builder(): Builder = Builder(this)

    class Builder() :
            Named.Builder<CodeParameter, Builder>,
            Typed.Builder<CodeParameter, Builder>,
            Annotable.Builder<CodeParameter, Builder>,
            ModifiersHolder.Builder<CodeParameter, Builder> {

        var modifiers: Set<CodeModifier> = emptySet()
        var annotations: List<Annotation> = emptyList()
        lateinit var name: String
        lateinit var type: Type

        constructor(defaults: CodeParameter) : this() {
            this.modifiers = defaults.modifiers
            this.annotations = defaults.annotations
            this.name = defaults.name
            this.type = defaults.type
        }

        override fun modifiers(value: Set<CodeModifier>): Builder {
            this.modifiers = modifiers
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun type(value: Type): Builder {
            this.type = value
            return this
        }

        override fun annotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun annotations(vararg values: Annotation): Builder {
            this.annotations = values.toList()
            return this
        }

        override fun build(): CodeParameter = CodeParameter(this.annotations, this.modifiers, this.type, this.name)

    }
}