package com.github.jonathanxd.kores.test.kt.serial

import com.github.jonathanxd.kores.MutableInstructions
import com.github.jonathanxd.kores.base.KoresModifier
import com.github.jonathanxd.kores.base.MethodDeclaration
import com.github.jonathanxd.kores.base.MethodInvocation
import com.github.jonathanxd.kores.factory.accessVariable
import com.github.jonathanxd.kores.factory.parameter
import com.github.jonathanxd.kores.generic.GenericSignature
import com.github.jonathanxd.kores.helper.invokePrintln
import com.github.jonathanxd.kores.helper.invokePrintlnStr
import com.github.jonathanxd.kores.literal.Literal
import com.github.jonathanxd.kores.literal.Literals
import com.github.jonathanxd.kores.serialization.koresSerializerModule
import com.github.jonathanxd.kores.type.Generic
import com.github.jonathanxd.kores.type.GenericType
import com.github.jonathanxd.kores.util.parameters1
import com.github.jonathanxd.kores.util.parametersVararg
import com.github.jonathanxd.kores.util.returnType
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