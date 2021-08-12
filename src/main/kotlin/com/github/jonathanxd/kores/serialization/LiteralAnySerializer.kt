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
package com.github.jonathanxd.kores.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

object LiteralAnySerializer : KSerializer<Any> {
    private val ser = WrapperLiteral.serializer()
    override val descriptor: SerialDescriptor = this.ser.descriptor

    override fun deserialize(decoder: Decoder): Any {
        return this.ser.deserialize(decoder).toLiteralObj()
    }

    override fun serialize(encoder: Encoder, value: Any) {
        this.ser.serialize(encoder, value.toSerializableObj())
    }
}

private fun Any.toSerializableObj(): WrapperLiteral =
    when(this) {
        "null" -> NullLiteral()
        is Byte -> ByteLiteral(this)
        is Boolean -> BoolLiteral(this)
        is Char -> CharLiteral(this)
        is Short -> ShortLiteral(this)
        is Int -> IntLiteral(this)
        is Long -> LongLiteral(this)
        is Float -> FloatLiteral(this)
        is Double -> DoubleLiteral(this)
        is String -> StringLiteral(this)
        is Type -> TypeLiteral(this)
        else -> throw IllegalArgumentException("Invalid obj '$this' in KoresAnnotation declaration.")
    }

private fun WrapperLiteral.toLiteralObj(): Any =
    when(this) {
        is ByteLiteral -> this.value
        is BoolLiteral -> this.value
        is CharLiteral -> this.value
        is ShortLiteral -> this.value
        is IntLiteral -> this.value
        is LongLiteral -> this.value
        is FloatLiteral -> this.value
        is DoubleLiteral -> this.value
        is StringLiteral -> this.value
        is TypeLiteral -> this.value
        is NullLiteral -> "null"
    }

@Serializable
sealed class WrapperLiteral

@Serializable
@SerialName("Type")
data class TypeLiteral(@Serializable(with = TypeSerializer::class) val value: Type): WrapperLiteral()

@Serializable
@SerialName("Byte")
data class ByteLiteral(val value: Byte): WrapperLiteral()

@Serializable
@SerialName("Short")
data class ShortLiteral(val value: Short): WrapperLiteral()

@Serializable
@SerialName("Int")
data class IntLiteral(val value: Int): WrapperLiteral()

@Serializable
@SerialName("Bool")
data class BoolLiteral(val value: Boolean): WrapperLiteral()

@Serializable
@SerialName("Long")
data class LongLiteral(val value: Long): WrapperLiteral()

@Serializable
@SerialName("Float")
data class FloatLiteral(val value: Float): WrapperLiteral()

@Serializable
@SerialName("Double")
data class DoubleLiteral(val value: Double): WrapperLiteral()

@Serializable
@SerialName("Char")
data class CharLiteral(val value: Char): WrapperLiteral()

@Serializable
@SerialName("String")
data class StringLiteral(val value: String): WrapperLiteral()

@Serializable
@SerialName("Null")
data class NullLiteral(val value: Unit? = null): WrapperLiteral()