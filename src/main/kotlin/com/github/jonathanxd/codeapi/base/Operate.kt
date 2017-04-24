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

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.operator.Operator
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.CodePartUtil
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Operate a value and return result of operation.
 *
 * @property target Target part to operate.
 * @property operation Operation.
 */
data class Operate(val target: CodePart,
                   val operation: Operator.Math,
                   override val value: CodePart?) : ValueHolder, Typed {

    override val type: CodeType
        get() = CodePartUtil.getType(this.target)

    override fun builder(): Builder = CodeAPI.getBuilderProvider()(this)

    interface Builder :
            ValueHolder.Builder<Operate, Builder>,
            Typed.Builder<Operate, Builder> {

        override fun withType(value: Type): Builder = self()

        /**
         * See [Operate.target]
         */
        fun withTarget(value: CodePart?): Builder

        /**
         * See [Operate.operation]
         */
        fun withOperation(value: Operator.Math): Builder

        companion object {
            fun builder(): Builder = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: Operate): Builder = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }

}
