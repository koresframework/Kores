/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.type.isArray
import java.lang.reflect.Type


/**
 * Stores [value][valueToStore] of type [valueType] in array [target] of type [arrayType] at [index].
 *
 * @property index Index to access
 * @property valueType Type of value to store
 * @property valueToStore Value to store
 */
data class ArrayStore(
    override val arrayType: Type,
    override val target: CodeInstruction,
    val index: CodeInstruction,
    val valueType: Type,
    val valueToStore: CodeInstruction
) : ArrayAccess, ValueHolder, CodeInstruction {

    init {
        check(arrayType.isArray) { "arrayType is not an array type!" }
    }

    override val value: CodeInstruction
        get() = this.valueToStore


    override fun builder(): Builder = Builder(this)

    class Builder() :
        ArrayAccess.Builder<ArrayStore, Builder>,
        ValueHolder.Builder<ArrayStore, Builder> {

        lateinit var arrayType: Type
        lateinit var target: CodeInstruction
        lateinit var index: CodeInstruction
        lateinit var valueType: Type
        lateinit var valueToStore: CodeInstruction

        constructor(defaults: ArrayStore) : this() {
            this.arrayType = defaults.arrayType
            this.target = defaults.target
            this.index = defaults.index
            this.valueType = defaults.valueType
            this.valueToStore = defaults.valueToStore
        }

        override fun value(value: CodeInstruction): Builder = this.valueToStore(value)

        override fun arrayType(value: Type): Builder {
            this.arrayType = value
            return this
        }

        override fun target(value: CodeInstruction): Builder {
            this.target = value
            return this
        }

        /**
         * See [ArrayStore.index]
         */
        fun index(value: CodeInstruction): Builder {
            this.index = value
            return this
        }

        /**
         * See [ArrayStore.valueType]
         */
        fun valueType(value: Type): Builder {
            this.valueType = value
            return this
        }

        /**
         * See [ArrayStore.valueToStore]
         */
        fun valueToStore(value: CodeInstruction): Builder {
            this.valueToStore = value
            return this
        }


        override fun build(): ArrayStore =
            ArrayStore(this.arrayType, this.target, this.index, this.valueType, this.valueToStore)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ArrayStore): Builder = Builder(defaults)
        }

    }

}
