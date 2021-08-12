package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.iutils.`object`.LateInit
import com.github.jonathanxd.iutils.type.TypeUtil
import com.github.jonathanxd.kores.base.KoresAnnotation
import com.github.jonathanxd.kores.base.Retention
import com.github.jonathanxd.kores.type.*
import com.github.jonathanxd.kores.util.fromSourceString
import com.github.jonathanxd.kores.util.toStr
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
        decoder.decodeStructure(descriptor) {
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

            return KoresAnnotation(type.value, properties.value, retention.value)
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