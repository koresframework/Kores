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

import com.koresframework.kores.base.comment.Code
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
