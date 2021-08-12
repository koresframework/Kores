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
import kotlinx.serialization.builtins.ListSerializer
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

object BootstrapArgListSerializer : KSerializer<List<Any>> {
    private val loader = this::class.java.classLoader

    private val ser = ListSerializer(BootstrapArgSerializer)

    override val descriptor: SerialDescriptor = ser.descriptor

    override fun deserialize(decoder: Decoder): List<Any> {
        return ser.deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, value: List<Any>) {
        ser.serialize(encoder, value)
    }
}