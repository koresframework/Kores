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
package com.github.jonathanxd.codeapi.helper

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.MethodInvocationBase
import com.github.jonathanxd.codeapi.common.InvokeType
import com.github.jonathanxd.codeapi.common.TypeSpec
import java.io.PrintStream

object Predefined {
    @JvmStatic
    fun toString(part: CodePart): MethodInvocationBase {
        return CodeAPI.invokeVirtual(Any::class.java, part, "toString", TypeSpec(Types.STRING), emptyList())
    }

    @JvmStatic
    fun intToString(part: CodePart): MethodInvocationBase {
        return CodeAPI.invokeStatic(String::class.java, "valueOf",
                TypeSpec(Types.STRING, listOf(Types.INT)),
                listOf(part))
    }

    @JvmStatic
    fun invokePrintln(vararg arguments: CodePart): MethodInvocationBase {

        val arg: CodePart = if (arguments.size == 1) {
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

        return CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream::class.java,
                CodeAPI.accessStaticField(System::class.java, PrintStream::class.java, "out"),
                "println", TypeSpec(Types.VOID, listOf(Types.OBJECT)), listOf(arg))
    }

    @JvmStatic
    fun invokePrintlnStr(part: CodePart): MethodInvocationBase {
        return CodeAPI.invokeVirtual(
                PrintStream::class.java,
                CodeAPI.accessStaticField(System::class.java, PrintStream::class.java, "out"),
                "println",
                CodeAPI.typeSpec(Types.VOID, Types.STRING),
                listOf(part))
    }
}
