/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
@file:JvmName("Predefined")

package com.github.jonathanxd.codeapi.helper

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.InvokeType
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.base.TypeSpec
import com.github.jonathanxd.codeapi.factory.*
import java.io.PrintStream

/**
 * Invokes `Any.toString` on receiver.
 */
fun CodeInstruction.invokeToString(): MethodInvocation {
    return invokeVirtual(Any::class.java, this, "toString", TypeSpec(Types.STRING), emptyList())
}

/**
 * Invokes `String.valueOf(int)` on receiver.
 */
fun CodeInstruction.invokeIntToString(): MethodInvocation {
    return String::class.java.invokeStatic(
            "valueOf",
            TypeSpec(Types.STRING, listOf(Types.INT)),
            listOf(this))
}

/**
 * Invokes `System.out.println(Any)` with concatenation of [arguments].
 */
fun invokePrintln(vararg arguments: CodeInstruction): MethodInvocation {

    val arg: CodeInstruction = if (arguments.size == 1) {
        arguments.single()
    } else {
        val helper = ConcatHelper.builder()
        val iter = arguments.iterator()

        while (iter.hasNext()) {
            helper.concat(iter.next())

            if (iter.hasNext())
                helper.concat(" ")
        }

        helper.build()
    }

    return invoke(InvokeType.INVOKE_VIRTUAL, PrintStream::class.java,
            accessStaticField(System::class.java, PrintStream::class.java, "out"),
            "println", TypeSpec(Types.VOID, listOf(Types.OBJECT)), listOf(arg))
}

/**
 * Invokes `System.out.println(String)` with [part] as argument.
 */
fun invokePrintlnStr(part: CodeInstruction): MethodInvocation {
    return invokeVirtual(
            PrintStream::class.java,
            accessStaticField(System::class.java, PrintStream::class.java, "out"),
            "println",
            typeSpec(Types.VOID, Types.STRING),
            listOf(part))
}
