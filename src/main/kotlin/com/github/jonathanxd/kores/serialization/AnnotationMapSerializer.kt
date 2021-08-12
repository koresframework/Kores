package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.iutils.type.TypeUtil
import com.github.jonathanxd.kores.base.Annotation
import com.github.jonathanxd.kores.base.EnumValue
import com.github.jonathanxd.kores.base.KoresAnnotation
import com.github.jonathanxd.kores.base.Retention
import com.github.jonathanxd.kores.type.*
import com.github.jonathanxd.kores.util.fromSourceString
import com.github.jonathanxd.kores.util.toStr
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
