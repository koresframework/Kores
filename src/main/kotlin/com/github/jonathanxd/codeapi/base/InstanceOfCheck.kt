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

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Checks if [part] is `instanceof` [checkType].
 *
 * @property part Casted part
 * @property checkType Type to check if part value is instance.
 */
data class InstanceOfCheck(val part: CodeInstruction, val checkType: Type) : Typed, CodeInstruction {

    override val type: Type
        get() = Types.BOOLEAN

    override fun builder(): Builder = Builder(this)

    class Builder() :
            Typed.Builder<InstanceOfCheck, Builder> {

        lateinit var part: CodeInstruction
        lateinit var checkType: Type

        constructor(defaults: InstanceOfCheck) : this() {
            this.part = defaults.part
            this.checkType = defaults.checkType
        }

        override fun type(value: Type): Builder = self()

        /**
         * See [InstanceOfCheck.part]
         */
        fun part(value: CodeInstruction): Builder {
            this.part = value
            return this
        }

        /**
         * See [InstanceOfCheck.checkType]
         */
        fun checkType(value: Type): Builder {
            this.checkType = value
            return this
        }

        override fun build(): InstanceOfCheck = InstanceOfCheck(this.part, this.checkType)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: InstanceOfCheck): Builder = Builder(defaults)
        }

    }

}
