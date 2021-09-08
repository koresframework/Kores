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
import com.koresframework.kores.base.FieldAccessKind
import com.koresframework.kores.base.InvokeDynamicBase
import com.koresframework.kores.base.InvokeType
import com.koresframework.kores.base.Typed
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Specify a field access or definition in [InvokeDynamicBase.bootstrapArgs].
 */
@Spec
@Serializable
data class FieldAccessHandleSpec(val accessKind: FieldAccessKind, val fieldTypeSpec: FieldTypeSpec) : Typed,
    Comparable<FieldAccessHandleSpec> {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.fieldTypeSpec.type

    /**
     * Human-readable method invocation string.
     */
    fun toInvocationString() =
        "${accessKind.name.lowercase()} ${this.fieldTypeSpec.toFieldString()}"


    override fun builder(): Builder = Builder(this)

    override fun compareTo(other: FieldAccessHandleSpec): Int {
        return this.fieldTypeSpec.compareTo(other.fieldTypeSpec)
    }

    class Builder() : Typed.Builder<FieldAccessHandleSpec, Builder> {

        override var data: KoresData = KoresData()
        lateinit var accessKind: FieldAccessKind
        lateinit var fieldTypeSpec: FieldTypeSpec

        override var type: Type
            get() = this.fieldTypeSpec.type
            set(value) { this.fieldTypeSpec = this.fieldTypeSpec.copy(fieldType = value )}

        constructor(defaults: FieldAccessHandleSpec) : this() {
            this.accessKind = defaults.accessKind
            this.fieldTypeSpec = defaults.fieldTypeSpec
        }

        override fun type(value: Type): Builder {
            this.fieldTypeSpec =
                    fieldTypeSpec.copy(fieldType = value)
            return this
        }

        fun withAccessKind(value: FieldAccessKind): Builder {
            this.accessKind = value
            return this
        }

        fun accessKind(value: FieldAccessKind): Builder {
            this.accessKind = value
            return this
        }

        fun withFieldTypeSpec(value: FieldTypeSpec): Builder {
            this.fieldTypeSpec = value
            return this
        }

        fun fieldTypeSpec(value: FieldTypeSpec): Builder {
            this.fieldTypeSpec = value
            return this
        }

        override fun buildBasic(): FieldAccessHandleSpec =
            FieldAccessHandleSpec(this.accessKind, this.fieldTypeSpec)
    }
}