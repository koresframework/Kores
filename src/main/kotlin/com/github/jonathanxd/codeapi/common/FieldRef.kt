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

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.FieldBase
import com.github.jonathanxd.codeapi.type.CodeType
import java.lang.reflect.Type

/**
 * Field reference, this class must never appear in CodeSource.
 */
data class FieldRef(override val localization: Type, override val target: CodeInstruction, override val type: Type, override val name: String) : FieldBase {

    override fun builder(): Builder = Builder(this)

    class Builder() : FieldBase.Builder<FieldRef, Builder> {

        lateinit var name: String
        lateinit var type: Type
        lateinit var localization: Type
        lateinit var target: CodeInstruction

        constructor(defaults: FieldRef) : this() {
            this.name = defaults.name
            this.type = defaults.type
            this.localization = defaults.localization
            this.target = defaults.target
        }

        override fun withName(value: String): Builder {
            this.name = value
            return this
        }

        override fun withType(value: Type): Builder {
            this.type = value
            return this
        }

        override fun withLocalization(value: Type): Builder {
            this.localization = value
            return this
        }

        override fun withTarget(value: CodeInstruction): Builder {
            this.target = value
            return this
        }

        override fun build(): FieldRef = FieldRef(localization, target, type, name)

        companion object {
            @JvmStatic
            fun builder() = Builder()
        }

    }
}