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

import com.koresframework.kores.Types
import com.koresframework.kores.serialization.TypeListSerializer
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type.koresType
import com.koresframework.kores.util.bothMatches
import com.koresframework.kores.util.typeDesc
import kotlinx.serialization.Serializable
import java.lang.reflect.Type
import java.util.*

/**
 * Type Signature representation.
 *
 * @property returnType Type of the return.
 * @property parameterTypes Type of parameters
 */
@Serializable
data class TypeSpec @JvmOverloads constructor(
    @Serializable(with = TypeSerializer::class) val returnType: Type,
    @Serializable(with = TypeListSerializer::class) val parameterTypes: List<Type> = emptyList()
) : Typed, Comparable<TypeSpec> {

    override val type: Type
        get() = this.returnType

    private val returnTypeKoresType = this.type.koresType
    private val parameterTypesKoresType = this.parameterTypes.map(Type::koresType)

    override fun hashCode(): Int {
        return Objects.hash(returnType, parameterTypes)
    }

    /**
     * Human readable type specification string.
     */
    fun toTypeString() =
        "(${this.parameterTypesKoresType.joinToString { it.canonicalName }})${this.returnTypeKoresType.canonicalName}"


    override fun builder(): Builder = Builder(this)

    override fun equals(other: Any?): Boolean {

        if (other !is TypeSpec)
            return false

        return this.returnTypeKoresType.`is`(other.returnTypeKoresType)
                && this.parameterTypesKoresType == other.parameterTypesKoresType
    }

    /**
     * Returns true if concrete types of this spec is same as concrete types of [other] spec.
     */
    fun isConreteEq(other: TypeSpec): Boolean {
        return this.returnTypeKoresType.isConcreteIdEq(other.returnTypeKoresType)
                && this.parameterTypesKoresType.bothMatches(other.parameterTypesKoresType) { f, s ->
            f.isConcreteIdEq(
                s
            )
        }
    }

    override fun compareTo(other: TypeSpec): Int {
        return if (this.returnTypeKoresType.`is`(other.returnTypeKoresType)
                && this.parameterTypesKoresType == other.parameterTypesKoresType
        ) 0 else 1
    }

    class Builder() : Typed.Builder<TypeSpec, Builder> {

        var returnType: Type = Types.VOID
        var parameterTypes: List<Type> = emptyList()

        constructor(defaults: TypeSpec) : this() {
            this.returnType = defaults.returnType
            this.parameterTypes = defaults.parameterTypes
        }

        override fun type(value: Type): Builder {
            this.returnType = value
            return this
        }

        fun returnType(value: Type): Builder {
            this.returnType = value
            return this
        }

        fun parameterTypes(value: List<Type>): Builder {
            this.parameterTypes = value
            return this
        }

        fun parameterTypes(vararg values: Type): Builder {
            this.parameterTypes = values.toList()
            return this
        }

        override fun build(): TypeSpec = TypeSpec(returnType, parameterTypes)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: TypeSpec): Builder = Builder(defaults)
        }

    }
}

/**
 * Convert [TypeSpec] string description
 */
val TypeSpec.typeDesc get() = "(${this.parameterTypes.typeDesc})${this.returnType.typeDesc}"
