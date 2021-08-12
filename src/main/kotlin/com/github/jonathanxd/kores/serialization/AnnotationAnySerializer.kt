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

import com.github.jonathanxd.kores.base.EnumValue
import com.github.jonathanxd.kores.base.KoresAnnotation
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

object AnnotationAnySerializer : KSerializer<Any> {
    private val loader = this::class.java.classLoader

    val ser = WrappedAnnotationValue.serializer()

    override val descriptor: SerialDescriptor = ser.descriptor

    override fun deserialize(decoder: Decoder): Any {
        return ser.deserialize(decoder).toAnnotationObj()
    }

    override fun serialize(encoder: Encoder, value: Any) {
        ser.serialize(encoder, value.annotationToSerializableObj())
    }

}

fun Any.annotationToSerializableObj(): WrappedAnnotationValue =
    when(this) {
        is Byte -> BytePrimitive(this)
        is Boolean -> BooleanPrimitive(this)
        is Char -> CharPrimitive(this)
        is Short -> ShortPrimitive(this)
        is Int -> IntPrimitive(this)
        is Long -> LongPrimitive(this)
        is Float -> FloatPrimitive(this)
        is Double -> DoublePrimitive(this)
        is String -> StringPrimitive(this)
        is Type -> TypePrimitive(this)
        is EnumValue -> EnumPrimitive(this)
        is KoresAnnotation -> AnnotationPrimitive(this)
        is List<*> -> ValueListPrimitive(this.map { it!!.annotationToSerializableObj() })
        else -> throw IllegalArgumentException("Invalid obj '$this' in KoresAnnotation declaration.")
    }

fun WrappedAnnotationValue.toAnnotationObj(): Any =
    when(this) {
        is BytePrimitive -> this.value
        is BooleanPrimitive -> this.value
        is CharPrimitive -> this.value
        is ShortPrimitive -> this.value
        is IntPrimitive -> this.value
        is LongPrimitive -> this.value
        is FloatPrimitive -> this.value
        is DoublePrimitive -> this.value
        is StringPrimitive -> this.value
        is TypePrimitive -> this.value
        is EnumPrimitive -> this.value
        is AnnotationPrimitive -> this.value
        is ValueListPrimitive -> this.value.map { it.toAnnotationObj() }
    }

@Serializable
sealed class WrappedAnnotationValue

@Serializable
@SerialName("Byte")
class BytePrimitive(val value: Byte): WrappedAnnotationValue()

@Serializable
@SerialName("Boolean")
class BooleanPrimitive(val value: Boolean): WrappedAnnotationValue()

@Serializable
@SerialName("Char")
class CharPrimitive(val value: Char): WrappedAnnotationValue()

@Serializable
@SerialName("Short")
class ShortPrimitive(val value: Short): WrappedAnnotationValue()

@Serializable
@SerialName("Int")
class IntPrimitive(val value: Int): WrappedAnnotationValue()

@Serializable
@SerialName("Long")
class LongPrimitive(val value: Long): WrappedAnnotationValue()

@Serializable
@SerialName("Float")
class FloatPrimitive(val value: Float): WrappedAnnotationValue()

@Serializable
@SerialName("Double")
class DoublePrimitive(val value: Double): WrappedAnnotationValue()

@Serializable
@SerialName("String")
class StringPrimitive(val value: String): WrappedAnnotationValue()

@Serializable
@SerialName("Type")
class TypePrimitive(val value: Type): WrappedAnnotationValue()

@Serializable
@SerialName("Enum")
class EnumPrimitive(val value: EnumValue): WrappedAnnotationValue()

@Serializable
@SerialName("Annotation")
class AnnotationPrimitive(@Serializable(with = AnnotationSerializer::class) val value: KoresAnnotation): WrappedAnnotationValue()

@Serializable
@SerialName("ValueList")
class ValueListPrimitive(val value: List<WrappedAnnotationValue>): WrappedAnnotationValue()