/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test.other;

import com.github.jonathanxd.kores.base.InvokeType;
import com.github.jonathanxd.kores.base.MethodInvocation;
import com.github.jonathanxd.kores.builder.BuilderKt;
import com.github.jonathanxd.kores.common.MethodTypeSpec;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.literal.Literals;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Collections;

import kotlin.Unit;

public class BuilderTest {

    @Test
    public void test() {


        MethodInvocation invocation = BuilderKt.build(MethodInvocation.Builder.builder(), it -> {
            it.setInvokeType(InvokeType.INVOKE_VIRTUAL);
            it.setSpec(new MethodTypeSpec(PrintStream.class, "println", Factories.typeSpec(Void.TYPE, String.class)));
            it.setTarget(Factories.accessStaticField(System.class, PrintStream.class, "out"));
            it.setArguments(Collections.singletonList(Literals.STRING("Hello")));

            return Unit.INSTANCE;
        });

        System.out.println(invocation);
    }

}
