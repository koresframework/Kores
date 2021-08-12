package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.base.comment.Code
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import com.github.jonathanxd.kores.test.kt.LiteralTest_
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.encodeToHexString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.properties.Properties
import kotlinx.serialization.properties.encodeToMap
import org.junit.Test

class LiteralClassSerialTest {

    @Test
    fun testSerialization() {
        val code = LiteralTest_().`$`()
        val format = Json {
            classDiscriminator = "_type"
            serializersModule = koresSerializerModule
            prettyPrint = true
        }
        val json = format.encodeToString(code)
        println(json)

        val prop = Cbor {
            serializersModule = koresSerializerModule
        }
        val map = prop.encodeToHexString(code)
        val bytes = prop.encodeToByteArray(code)
        println(map)
        println("Encoded size = ${bytes.size}")
    }

}