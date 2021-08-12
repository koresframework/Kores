package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.KoresAnnotation
import com.github.jonathanxd.kores.base.Retention
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class AnnotationSerialTest {

    @Test
    fun testSerialization() {
        val annotation = KoresAnnotation(
            type = Types.STRING,
            values = mutableMapOf(
                "hello" to "world",
                "more" to listOf(
                    KoresAnnotation(
                        type = Types.STRING,
                        values = emptyMap(),
                        retention = Retention.RUNTIME
                    )
                )
            ),
            retention = Retention.RUNTIME
        )
        val format = Json {
            serializersModule = koresSerializerModule
            prettyPrint = false
        }
        val json = format.encodeToString(annotation)
        println(json)

        val des = format.decodeFromString<KoresAnnotation>(json)
        println(des)
    }

}