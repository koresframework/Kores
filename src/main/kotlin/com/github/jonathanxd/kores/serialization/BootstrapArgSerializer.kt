package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.kores.common.MethodInvokeSpec
import com.github.jonathanxd.kores.common.MethodTypeSpec
import com.github.jonathanxd.kores.type.KoresType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

/**
 * Bootstrap method Arguments, must be an [String], [Int],
 * [Long], [Float], [Double], [KoresType] or [MethodInvokeSpec].
 */
object BootstrapArgSerializer : KSerializer<Any> {
    private val ser = WrapperBootstrapArg.serializer()
    override val descriptor: SerialDescriptor = this.ser.descriptor

    override fun deserialize(decoder: Decoder): Any {
        return this.ser.deserialize(decoder).toBootstrapArgObj()
    }

    override fun serialize(encoder: Encoder, value: Any) {
        this.ser.serialize(encoder, value.toSerializableObj())
    }
}

private fun Any.toSerializableObj(): WrapperBootstrapArg =
    when(this) {
        is Byte -> ByteBootstrapArg(this)
        is Boolean -> BoolBootstrapArg(this)
        is Char -> CharBootstrapArg(this)
        is Short -> ShortBootstrapArg(this)
        is Int -> IntBootstrapArg(this)
        is Long -> LongBootstrapArg(this)
        is Float -> FloatBootstrapArg(this)
        is Double -> DoubleBootstrapArg(this)
        is String -> StringBootstrapArg(this)
        is Type -> TypeBootstrapArg(this)
        is MethodInvokeSpec -> MethodInvokeSpecArg(this)
        else -> throw IllegalArgumentException("Invalid obj '$this' in KoresAnnotation declaration.")
    }

private fun WrapperBootstrapArg.toBootstrapArgObj(): Any =
    when(this) {
        is ByteBootstrapArg -> this.value
        is BoolBootstrapArg -> this.value
        is CharBootstrapArg -> this.value
        is ShortBootstrapArg -> this.value
        is IntBootstrapArg -> this.value
        is LongBootstrapArg -> this.value
        is FloatBootstrapArg -> this.value
        is DoubleBootstrapArg -> this.value
        is StringBootstrapArg -> this.value
        is TypeBootstrapArg -> this.value
        is MethodInvokeSpecArg -> this.value
    }

@Serializable
sealed class WrapperBootstrapArg

@Serializable
@SerialName("Type")
data class TypeBootstrapArg(@Serializable(with = TypeSerializer::class) val value: Type): WrapperBootstrapArg()

@Serializable
@SerialName("Byte")
data class ByteBootstrapArg(val value: Byte): WrapperBootstrapArg()

@Serializable
@SerialName("Short")
data class ShortBootstrapArg(val value: Short): WrapperBootstrapArg()

@Serializable
@SerialName("Int")
data class IntBootstrapArg(val value: Int): WrapperBootstrapArg()

@Serializable
@SerialName("Bool")
data class BoolBootstrapArg(val value: Boolean): WrapperBootstrapArg()

@Serializable
@SerialName("Long")
data class LongBootstrapArg(val value: Long): WrapperBootstrapArg()

@Serializable
@SerialName("Float")
data class FloatBootstrapArg(val value: Float): WrapperBootstrapArg()

@Serializable
@SerialName("Double")
data class DoubleBootstrapArg(val value: Double): WrapperBootstrapArg()

@Serializable
@SerialName("Char")
data class CharBootstrapArg(val value: Char): WrapperBootstrapArg()

@Serializable
@SerialName("String")
data class StringBootstrapArg(val value: String): WrapperBootstrapArg()

@Serializable
@SerialName("MethodTypeSpec")
data class MethodInvokeSpecArg(val value: MethodInvokeSpec): WrapperBootstrapArg()