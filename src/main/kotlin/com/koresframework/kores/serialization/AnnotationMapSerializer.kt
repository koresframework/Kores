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

import com.github.jonathanxd.iutils.type.TypeUtil
import com.koresframework.kores.base.Annotation
import com.koresframework.kores.base.EnumValue
import com.koresframework.kores.base.KoresAnnotation
import com.koresframework.kores.base.Retention
import com.koresframework.kores.type.*
import com.koresframework.kores.util.fromSourceString
import com.koresframework.kores.util.toStr
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import java.lang.reflect.Type

object AnnotationMapSerializer : KSerializer<Map<String, Any>> {
    private val loader = this::class.java.classLoader

    val ser = MapSerializer(String.serializer(), WrappedAnnotationValue.serializer())

    override val descriptor: SerialDescriptor = ser.descriptor

    override fun deserialize(decoder: Decoder): Map<String, Any> {
        return ser.deserialize(decoder).toAnnotationObj()
    }

    override fun serialize(encoder: Encoder, value: Map<String, Any>) {
        ser.serialize(encoder, value.toSerializableObj())
    }

    private fun Map<String, Any>.toSerializableObj(): Map<String, WrappedAnnotationValue> =
        this.map {
            it.key to it.value.annotationToSerializableObj()
        }.toMap()

    private fun Map<String, WrappedAnnotationValue>.toAnnotationObj(): Map<String, Any> =
        this.map {
            it.key to it.value.toAnnotationObj()
        }.toMap()
}
