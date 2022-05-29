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

import com.koresframework.kores.MutableInstructions
import com.koresframework.kores.base.KoresModifier
import com.koresframework.kores.base.MethodDeclaration
import com.koresframework.kores.base.MethodInvocation
import com.koresframework.kores.factory.accessVariable
import com.koresframework.kores.factory.parameter
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.helper.invokePrintln
import com.koresframework.kores.helper.invokePrintlnStr
import com.koresframework.kores.literal.Literal
import com.koresframework.kores.literal.Literals
import com.koresframework.kores.serialization.koresSerializerModule
import com.koresframework.kores.type.Generic
import com.koresframework.kores.type.GenericType
import com.koresframework.kores.util.parameters1
import com.koresframework.kores.util.parametersVararg
import com.koresframework.kores.util.returnType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test

class SysOutPrintlnSerialTest {

    @Test
    fun testSerialization() {
        val basicInvocation = invokePrintlnStr(Literals.STRING("Hello world"))
        val format = Json {
            classDiscriminator = "_type"
            prettyPrint = true
            serializersModule = koresSerializerModule
        }
        val json = format.encodeToString(basicInvocation)
        println(json)
        val des = format.decodeFromString<MethodInvocation>(json)
        println(des)
    }

    @Test
    fun testMethodDeclSerialization() {
        val methodDecl = MethodDeclaration.Builder.builder()
            .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
            .name("printSomething")
            .returnType<String>()
            .parameters1<String>("something")
            .body(MutableInstructions.create(listOf(
                invokePrintlnStr(accessVariable<String>("something"))
            )))
            .build()

        val format = Json {
            classDiscriminator = "_type"
            prettyPrint = true
            serializersModule = koresSerializerModule
        }
        val json = format.encodeToString(methodDecl)
        println(json)
        val des = format.decodeFromString<MethodDeclaration>(json)
        println(des)
    }

    @Test
    fun testMethodDeclGenericSignSerialization() {
        val methodDecl = MethodDeclaration.Builder.builder()
            .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
            .name("printSomething")
            .genericSignature(GenericSignature.create(Generic.type("T")))
            .returnType<String>()
            .parametersVararg(parameter(type = Generic.type("T"), name = "something"))
            .body(MutableInstructions.create(listOf(
                invokePrintln(accessVariable(type = Generic.type("T"), name = "something"))
            )))
            .build()

        val format = Json {
            classDiscriminator = "_type"
            prettyPrint = true
            serializersModule = koresSerializerModule
        }
        val json = format.encodeToString(methodDecl)
        println(json)
        val des = format.decodeFromString<MethodDeclaration>(json)
        println(des)
    }

}