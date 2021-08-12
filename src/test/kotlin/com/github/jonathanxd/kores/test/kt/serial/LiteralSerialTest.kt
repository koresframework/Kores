package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.literal.Literal
import com.github.jonathanxd.kores.literal.Literals
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class LiteralSerialTest {

    @Test
    fun testSerialization() {
        val literal = Literals.STRING("Hello World")
        val format = Json {
            serializersModule = koresSerializerModule
        }
        val json = format.encodeToString(literal)
        println(json)
        val des = format.decodeFromString<Literal>(json)
        println(des)
    }

}