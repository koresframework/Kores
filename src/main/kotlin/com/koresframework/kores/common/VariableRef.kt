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

import com.koresframework.kores.annotation.Spec
import com.koresframework.kores.base.VariableBase
import com.koresframework.kores.data.KoresData
import java.lang.reflect.Type

/**
 * Reference to a Variable.
 */
@Spec
data class VariableRef(override val variableType: Type, override val name: String) : VariableBase {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : VariableBase.Builder<VariableRef, Builder> {

        override var data: KoresData = KoresData()
        override lateinit var name: String
        override lateinit var type: Type

        override var variableType: Type
            get() = this.type
            set(value) { this.type = value }

        constructor(defaults: VariableRef) : this() {
            this.name = defaults.name
            this.type = defaults.variableType

            this.from(defaults)
        }

        override fun buildBasic(): VariableRef = VariableRef(this.type, this.name)

        companion object {
            @JvmStatic
            fun builder() = Builder()
        }

    }

}