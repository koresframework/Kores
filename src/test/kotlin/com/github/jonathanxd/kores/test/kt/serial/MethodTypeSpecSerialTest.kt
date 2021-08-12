package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.KoresAnnotation
import com.github.jonathanxd.kores.base.Retention
import com.github.jonathanxd.kores.base.TypeSpec
import com.github.jonathanxd.kores.common.MethodTypeSpec
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class MethodTypeSpecSerialTest {

    @Test
    fun testSerialization() {
        val spec = MethodTypeSpec(
            localization = Types.STRING,
            methodName = "hello",
            typeSpec = TypeSpec(Types.STRING, listOf(Types.STRING))
        )

        val format = Json {
            serializersModule = koresSerializerModule
            prettyPrint = false
        }
        val json = format.encodeToString(spec)
        println(json)

        val des = format.decodeFromString<MethodTypeSpec>(json)
        println(des)
    }

}