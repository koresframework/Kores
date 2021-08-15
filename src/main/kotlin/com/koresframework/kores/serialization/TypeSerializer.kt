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
package com.koresframework.kores.serialization

import com.github.jonathanxd.iutils.`object`.LateInit
import com.github.jonathanxd.iutils.type.TypeUtil
import com.koresframework.kores.base.KoresAnnotation
import com.koresframework.kores.type.*
import com.koresframework.kores.util.fromSourceString
import com.koresframework.kores.util.toStr
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

object TypeSerializer : KSerializer<Type> {
    private val loader = this::class.java.classLoader

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Type") {
        element<String>("type")
        element<String>("canonicalName")
        element<Boolean>("interface")
        element<String>("representation")
        element<List<KoresAnnotation>>("annotations")
    }

    override fun deserialize(decoder: Decoder): Type {
        decoder.decodeStructure(descriptor) {
            val type = LateInit.lateRef<String>("type")
            val canonicalName = LateInit.lateRef<String>("canonicalName")
            val isInterface = LateInit.lateRef<Boolean>("interface")
            val representation = LateInit.lateRef<String>("representation")
            val annotations = LateInit.lateRef<List<KoresAnnotation>>("annotations")


            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> type.init(decodeStringElement(descriptor, 0))
                    1 -> canonicalName.init(decodeStringElement(descriptor, 1))
                    2 -> isInterface.init(decodeBooleanElement(descriptor, 2))
                    3 -> representation.init(decodeStringElement(descriptor, 3))
                    4 -> annotations.init(decodeSerializableElement(descriptor, 4, ListSerializer(AnnotationSerializer)))
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }

            val resolvedType = when (type.value) {
                "LoadedKoresType" -> TypeUtil.resolveClass<Any>(canonicalName.value)
                "PlainKoresType" -> PlainKoresType(canonicalName.value, isInterface.value)
                "GenericType" -> fromSourceString(representation.value)
                else -> TypeUtil.resolveClass<Any>(canonicalName.value) // TODO: ??
            }

            return if (annotations.value.isNotEmpty()) {
                AnnotatedKoresType.annotatedType(resolvedType, annotations.value)
            } else {
                resolvedType
            }
        }
    }

    override fun serialize(encoder: Encoder, value: Type) {
        encoder.encodeStructure(descriptor) {
            val koresType = when (value) {
                is Class<*> -> value.koresType
                is ParameterizedType -> value.asGeneric
                else -> value
            }

            when (koresType) {
                is LoadedKoresType<*> -> encodeStringElement(descriptor, 0, "LoadedKoresType")
                is PlainKoresType -> encodeStringElement(descriptor, 0, "PlainKoresType")
                is GenericType -> encodeStringElement(descriptor, 0, "GenericType")
                else -> encodeStringElement(descriptor, 0, koresType::class.simpleName!!)
            }

            encodeStringElement(descriptor, 1, koresType.canonicalName)
            encodeBooleanElement(descriptor, 2, koresType.isInterface)
            when (koresType) {
                is GenericType -> encodeStringElement(descriptor, 3, koresType.toStr())
                else -> encodeStringElement(descriptor, 3, koresType.javaSpecName)
            }
            if (koresType is AnnotatedKoresType) {
                encodeSerializableElement(descriptor, 4, ListSerializer(AnnotationSerializer), koresType.annotations)
            } else {
                encodeSerializableElement(descriptor, 4, ListSerializer(AnnotationSerializer), emptyList())
            }

        }
    }
}