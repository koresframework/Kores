package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.iutils.`object`.LateInit
import com.github.jonathanxd.iutils.type.TypeUtil
import com.github.jonathanxd.kores.base.KoresAnnotation
import com.github.jonathanxd.kores.type.*
import com.github.jonathanxd.kores.util.fromSourceString
import com.github.jonathanxd.kores.util.toStr
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