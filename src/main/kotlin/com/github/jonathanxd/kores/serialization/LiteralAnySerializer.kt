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