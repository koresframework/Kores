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
import java.lang.reflect.Type


/**
 * Value cast. Cast [castedPart] of type [originalType] (null if unknown) to [targetType]. Official
 * BytecodeGenerator uses the [originalType] to auto-box and auto-unbox the value.
 *
 * @property originalType Origin type
 * @property targetType Target type
 * @property castedPart Part to cast
 */
data class Cast(val originalType: Type?, val targetType: Type, val castedPart: CodePart) : Typed {

    override val type: Type
        get() = this.targetType

    override fun builder(): Builder = Builder(this)

    class Builder() :
            Typed.Builder<Cast, Builder> {

        var originalType: Type? = null
        lateinit var targetType: Type
        lateinit var castedPart: CodePart

        constructor(defaults: Cast) : this() {
            this.originalType = defaults.originalType
            this.targetType = defaults.targetType
            this.castedPart = defaults.castedPart
        }

        override fun withType(value: Type): Builder = this.withTargetType(value)

        /**
         * See [Cast.originalType]
         */
        fun withOriginalType(value: Type?): Builder {
            this.originalType = value
            return this
        }

        /**
         * See [Cast.targetType]
         */
        fun withTargetType(value: Type): Builder {
            this.targetType = value
            return this
        }

        /**
         * See [Cast.castedPart]
         */
        fun withCastedPart(value: CodePart): Builder {
            this.castedPart = value
            return this
        }

        override fun build(): Cast = Cast(this.originalType, this.targetType, this.castedPart)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Cast): Builder = Builder(defaults)
        }

    }

}