/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.serialization

import com.koresframework.kores.base.TypeSpec
import com.koresframework.kores.common.*
import com.koresframework.kores.type.KoresType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

/**
 * Bootstrap method Arguments as specified in [com.koresframework.kores.base.InvokeDynamicBase.bootstrapArgs].
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
        is FieldAccessHandleSpec -> FieldAccessHandleSpecArg(this)
        is MethodInvokeHandleSpec -> MethodInvokeHandleSpecArg(this)
        is TypeSpec -> TypeSpecArg(this)
        is DynamicConstantSpec -> DynamicConstantSpecArg(this)
        else -> throw IllegalArgumentException("Invalid obj '$this' in Kores InvokeDynamic Bootstrap Args declaration.")
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
        is FieldAccessHandleSpecArg -> this.value
        is MethodInvokeHandleSpecArg -> this.value
        is TypeSpecArg -> this.value
        is DynamicConstantSpecArg -> this.value
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

@Serializable
@SerialName("FieldAccessHandleSpec")
data class FieldAccessHandleSpecArg(val value: FieldAccessHandleSpec): WrapperBootstrapArg()

@Serializable
@SerialName("MethodInvokeHandleSpec")
data class MethodInvokeHandleSpecArg(val value: MethodInvokeHandleSpec): WrapperBootstrapArg()

@Serializable
@SerialName("TypeSpec")
data class TypeSpecArg(val value: TypeSpec): WrapperBootstrapArg()

@Serializable
@SerialName("DynamicConstantSpec")
data class DynamicConstantSpecArg(val value: DynamicConstantSpec): WrapperBootstrapArg()
