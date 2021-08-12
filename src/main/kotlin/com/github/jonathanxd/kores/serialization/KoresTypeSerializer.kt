package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.kores.type.KoresType
import com.github.jonathanxd.kores.type.koresType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

object KoresTypeSerializer : KSerializer<KoresType> {
    val ser = TypeSerializer

    override val descriptor: SerialDescriptor = ser.descriptor

    override fun deserialize(decoder: Decoder): KoresType {
        return ser.deserialize(decoder).koresType
    }

    override fun serialize(encoder: Encoder, value: KoresType) {
        ser.serialize(encoder, value)
    }
}