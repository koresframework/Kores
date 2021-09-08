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

import com.koresframework.kores.Instruction
import com.koresframework.kores.common.FieldRef
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Access a field of type [type], name [name] in type [localization] using [target] as instance (Use a [Access.Type.STATIC] to
 * static accesses).
 */
@Serializable
data class FieldAccess(
    @Serializable(with = TypeSerializer::class) override val localization: Type,
    override val target: Instruction,
    @Serializable(with = TypeSerializer::class) override val type: Type,
    override val name: String
) : Accessor, TypedInstruction, Named {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Accessor.Builder<FieldAccess, Builder>,
        Typed.Builder<FieldAccess, Builder>,
        Named.Builder<FieldAccess, Builder> {

        override var data: KoresData = KoresData()
        override lateinit var localization: Type
        override lateinit var target: Instruction
        override lateinit var type: Type
        override lateinit var name: String

        constructor(defaults: FieldAccess) : this() {
            this.localization = defaults.localization
            this.target = defaults.target
            this.type = defaults.type
            this.name = defaults.name
        }

        /**
         * Base this builder in [ref]
         */
        fun base(ref: FieldRef) = this.apply {
            localization(ref.localization)
            target(ref.target)
            type(ref.type)
            name(ref.name)
        }

        override fun buildBasic(): FieldAccess =
            FieldAccess(this.localization, this.target, this.type, this.name)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: FieldAccess): Builder = Builder(defaults)
        }

    }
}