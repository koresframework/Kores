/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.builder.InvocationBuilder;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.literals.Literals;

import org.junit.Test;

import java.io.PrintStream;

import kotlin.Unit;

public class BuilderTest {

    @Test
    public void test() {


        MethodInvocation invocation = InvocationBuilder.invocation(it -> {
            it.setInvokeType(InvokeType.INVOKE_VIRTUAL);
            it.setLocalization(PrintStream.class);
            it.setTarget(CodeAPI.accessStaticField(System.class, PrintStream.class, "out"));
            it.setMethodName("println");
            it.setSpec(CodeAPI.typeSpec(Void.TYPE, String.class));
            it.setArguments(CodeAPI.argument(Literals.STRING("Hello")));

            return Unit.INSTANCE;
        });

        System.out.println(invocation);
    }

}
