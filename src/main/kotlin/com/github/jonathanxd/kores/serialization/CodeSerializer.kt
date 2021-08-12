package com.github.jonathanxd.kores.serialization

import com.github.jonathanxd.kores.base.comment.Code
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import java.util.concurrent.ConcurrentHashMap
import kotlin.reflect.KClass


/*
class CodeSerializer : KSerializer<Code> {
    private val typeSerializerMap = ConcurrentHashMap<String, KSerializer<*>>()
    private val typeResolverMap = ConcurrentHashMap<KClass<*>, String>()

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Code") {
        element<String>("type")
        element<Code.CodeNode>("node")
    }

    override fun deserialize(decoder: Decoder): Code {
        decoder.decodeStructure(descriptor) {
            val type = decodeStringElement(descriptor, 0)
            val codeNode = decode
        }
    }

    override fun serialize(encoder: Encoder, value: Code) {
        encoder.encodeStructure(descriptor) {
            val type = if (value.code is Code.CodeNode.Plain) "Plain" else "CodeRepresentation"
            encodeStringElement(descriptor, 0, type)
            when (type) {
                "Plain" -> Code.CodeNode.Plain.serializer()
                else -> Code.CodeNode.CodeRepresentation.serializer()
            }
            encodeSerializableElement(descriptor, 1, )
        }
    }

    private fun <T> getSerializer(type: String): KSerializer<T> {
        return (this.typeSerializerMap[type] as? KSerializer<T>?) ?: throw IllegalStateException("Missing Serializer for type '$type'")
    }

    private fun getSerializeName(type: KClass<*>): String {
        return this.typeResolverMap[type] ?: throw IllegalStateException("Missing TypeId for type '$type'")
    }
}
*/
