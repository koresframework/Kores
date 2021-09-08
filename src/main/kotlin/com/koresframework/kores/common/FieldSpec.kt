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
import com.koresframework.kores.base.*
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type.canonicalName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Specification of a field for [InvokeDynamicBase.bootstrapArgs].
 */
@Spec
@Serializable
data class FieldSpec(val fieldName: String, @Serializable(with = TypeSerializer::class) val fieldType: Type) :
    Typed, Comparable<FieldSpec> {
    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.fieldType

    override fun builder(): Builder = Builder(this)

    /**
     * Human-readable method specification string.
     */
    fun toFieldString() =
        "$fieldName:${fieldType.canonicalName}"

    /**
     * This method will not compare the method localization.
     */
    override operator fun compareTo(other: FieldSpec): Int {
        return if (this.fieldName == other.fieldName && this.fieldType == other.fieldType) 0 else 1
    }

    /**
     * Converts this [FieldSpec] to [MethodTypeSpec]
     */
    fun toFieldTypeSpec(type: Type) =
            FieldTypeSpec(type, this)

    class Builder() : Typed.Builder<FieldSpec, Builder> {
        override var data: KoresData = KoresData()
        lateinit var fieldName: String
        lateinit var fieldType: Type

        override var type: Type
            get() = this.fieldType
            set(value) { this.fieldType = value }

        constructor(defaults: FieldSpec) : this() {
            this.fieldName = defaults.fieldName
            this.fieldType = defaults.fieldType

            this.fromData(defaults.data)
        }

        fun withFieldName(value: String): Builder {
            this.fieldName = value
            return this
        }

        fun fieldName(value: String): Builder {
            this.fieldName = value
            return this
        }

        fun withFieldType(value: Type): Builder {
            this.fieldType = value
            return this
        }

        override fun buildBasic(): FieldSpec = FieldSpec(this.fieldName, this.fieldType)

    }
}