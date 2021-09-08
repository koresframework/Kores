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

import com.koresframework.kores.*
import com.koresframework.kores.builder.self
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Case statement of [SwitchStatement].
 *
 * @property value Value to check if operating element matches, null for `default` case.
 * @property body Body of case statement.
 */
@Serializable
data class Case(override val value: Instruction, override val body: Instructions) : ValueHolder,
    Typed, BodyHolder {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.value.safeForComparison.let { if (it == KoresNothing) Types.INT else it.type }

    /**
     * Is case default
     */
    val isDefault get() = this.value.safeForComparison == KoresNothing

    /**
     * Is not case default
     */
    val isNotDefault get() = !this.isDefault

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
        ValueHolder.Builder<Case, Builder>,
        Typed.Builder<Case, Builder>,
        BodyHolder.Builder<Case, Builder> {

        override var data: KoresData = KoresData()
        override var value: Instruction = KoresNothing
        override var body: Instructions = Instructions.empty()

        override var type: Type
            get() = body.getLeaveType() ?: Types.VOID
            set(value) {}

        constructor(defaults: Case) : this() {
            this.value = defaults.value
            this.body = defaults.body
        }

        override fun type(value: Type): Builder = self()

        /**
         * Sets the case statement as `default` case (same as `withValue(Void)`).
         */
        fun defaultCase(): Builder {
            this.value = KoresNothing
            return this
        }

        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun buildBasic(): Case = Case(this.value, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Case): Builder = Builder(defaults)
        }

    }
}