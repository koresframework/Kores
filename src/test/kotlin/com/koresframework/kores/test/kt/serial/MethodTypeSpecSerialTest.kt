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
package com.koresframework.kores.test.kt.serial

import com.koresframework.kores.Types
import com.koresframework.kores.base.KoresAnnotation
import com.koresframework.kores.base.Retention
import com.koresframework.kores.base.TypeSpec
import com.koresframework.kores.common.MethodTypeSpec
import com.koresframework.kores.serialization.koresSerializerModule
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
            classDiscriminator = "_type"
            serializersModule = koresSerializerModule
            prettyPrint = false
        }
        val json = format.encodeToString(spec)
        println(json)

        val des = format.decodeFromString<MethodTypeSpec>(json)
        println(des)
    }

}