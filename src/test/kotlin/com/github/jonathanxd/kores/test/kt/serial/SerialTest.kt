package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.base.comment.Code
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class SerialTest {

    @Test
    fun testSerialization() {
        val code = Code(Code.CodeNode.Plain("Hello World"))
        val format = Json {
            serializersModule = koresSerializerModule
        }
        val json = format.encodeToString(code)
        println(json)
    }

}