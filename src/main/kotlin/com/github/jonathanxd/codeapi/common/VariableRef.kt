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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.base.VariableBase
import java.lang.reflect.Type

/**
 * Reference to a Variable, this class must never appear in CodeSource.
 */
data class VariableRef(override val variableType: Type, override val name: String) : VariableBase {

    override fun builder(): Builder = Builder(this)

    class Builder() : VariableBase.Builder<VariableRef, Builder> {

        lateinit var name: String
        lateinit var type: Type

        constructor(defaults: VariableRef) : this() {
            this.name = defaults.name
            this.type = defaults.variableType
        }

        override fun withType(value: Type): Builder {
            return this.withVariableType(value)
        }

        override fun withName(value: String): Builder {
            this.name = name
            return this
        }

        override fun withVariableType(value: Type): Builder {
            this.type = type
            return this
        }

        override fun build(): VariableRef = VariableRef(this.type, this.name)

        companion object {
            @JvmStatic
            fun builder() = Builder()
        }

    }

}