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
package com.koresframework.kores.common

import com.koresframework.kores.Instruction
import com.koresframework.kores.annotation.Spec
import com.koresframework.kores.base.FieldBase
import com.koresframework.kores.data.KoresData
import java.lang.reflect.Type

/**
 * Field reference
 */
@Spec
data class FieldRef(
    override val localization: Type,
    override val target: Instruction,
    override val type: Type,
    override val name: String
) : FieldBase {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : FieldBase.Builder<FieldRef, Builder> {

        override var data: KoresData = KoresData()

        override lateinit var name: String
        override lateinit var type: Type
        override lateinit var localization: Type
        override lateinit var target: Instruction

        constructor(defaults: FieldRef) : this() {
            this.name = defaults.name
            this.type = defaults.type
            this.localization = defaults.localization
            this.target = defaults.target

            this.fromData(defaults.data)
        }

        override fun buildBasic(): FieldRef = FieldRef(localization, target, type, name)

        companion object {
            @JvmStatic
            fun builder() = Builder()
        }

    }
}