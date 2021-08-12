package com.github.jonathanxd.kores.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.lang.reflect.Type

object TypeListSerializer : KSerializer<List<Type>> {
    val ser = ListSerializer(TypeSerializer)

    override val descriptor: SerialDescriptor = ser.descriptor

    override fun deserialize(decoder: Decoder): List<Type> {
        return ser.deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, value: List<Type>) {
        ser.serialize(encoder, value)
    }
}