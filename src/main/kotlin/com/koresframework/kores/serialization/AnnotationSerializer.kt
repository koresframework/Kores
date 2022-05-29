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

import com.github.jonathanxd.iutils.`object`.LateInit
import com.github.jonathanxd.iutils.type.TypeUtil
import com.koresframework.kores.base.KoresAnnotation
import com.koresframework.kores.base.Retention
import com.koresframework.kores.type.*
import com.koresframework.kores.util.fromSourceString
import com.koresframework.kores.util.toStr
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*
import java.lang.reflect.Type

object AnnotationSerializer : KSerializer<KoresAnnotation> {
    private val loader = this::class.java.classLoader

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Annotation") {
        element<Type>("type")
        element<Map<String, WrappedAnnotationValue>>("properties")
        element<Retention>("retention")
    }

    override fun deserialize(decoder: Decoder): KoresAnnotation {
        return decoder.decodeStructure(descriptor) {
            val type = LateInit.lateRef<Type>("type")
            val properties = LateInit.lateRef<Map<String, Any>>("type")
            val retention = LateInit.lateRef<Retention>("retention")

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type.init(decodeSerializableElement(descriptor, 0, TypeSerializer))
                    1 -> properties.init(decodeSerializableElement(descriptor, 1, AnnotationMapSerializer))
                    2 -> retention.init(decodeSerializableElement(descriptor, 2, Retention.serializer()))
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }

            return@decodeStructure KoresAnnotation(type.value, properties.value, retention.value)
        }
    }

    override fun serialize(encoder: Encoder, value: KoresAnnotation) {
        encoder.encodeStructure(descriptor) {
            encodeSerializableElement(descriptor, 0, TypeSerializer, value.type)
            encodeSerializableElement(descriptor, 1, AnnotationMapSerializer, value.values)
            encodeSerializableElement(descriptor, 2, Retention.serializer(), value.retention)
        }
    }
}