/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.base

import com.koresframework.kores.Instructions
import com.koresframework.kores.Types
import com.koresframework.kores.builder.self
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.getLeaveType
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Catch statement of a try block. Catch [exceptionTypes] and store caught exception in [variable].
 *
 * @property exceptionTypes Exception types to catch.
 * @property variable Variable to store exception.
 * @property body Body of exception handler.
 */
@Serializable
data class CatchStatement(
    val exceptionTypes: List<@Serializable(with = TypeSerializer::class) Type>,
    val variable: VariableDeclaration,
    override val body: Instructions
) : BodyHolder, Typed {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.variable.type

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
        BodyHolder.Builder<CatchStatement, Builder>,
        Typed.Builder<CatchStatement, Builder> {

        override var data: KoresData = KoresData()
        var exceptionTypes: List<Type> = emptyList()
        lateinit var variable: VariableDeclaration
        override var body: Instructions = Instructions.empty()

        override var type: Type
            get() = body.getLeaveType() ?: Types.VOID
            set(value) {}

        constructor(defaults: CatchStatement) : this() {
            this.exceptionTypes = defaults.exceptionTypes
            this.variable = defaults.variable
            this.body = defaults.body
        }

        @Suppress("UNCHECKED_CAST")
        override fun type(value: Type): Builder = self()

        /**
         * See [CatchStatement.exceptionTypes]
         */
        fun exceptionTypes(value: List<Type>): Builder {
            this.exceptionTypes = value
            return this
        }

        /**
         * See [CatchStatement.variable]
         */
        fun exceptionTypes(vararg values: Type): Builder = this.exceptionTypes(values.toList())

        /**
         * See [CatchStatement.variable]
         */
        fun variable(value: VariableDeclaration): Builder {
            this.variable = value
            return this
        }

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun buildBasic(): CatchStatement =
            CatchStatement(this.exceptionTypes, this.variable, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: CatchStatement): Builder = Builder(defaults)
        }

    }
}

