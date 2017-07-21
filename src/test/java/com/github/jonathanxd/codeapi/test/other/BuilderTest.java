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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.base.InvokeType;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.builder.BuilderKt;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.literal.Literals;

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



    class A {

        private final String s = "X";

        class B {
            private final int i = 9;

            public void c() {
                System.out.println(new C().getS());
            }

            class C {
                private C() {

                }

                public String getS() {
                    return A.this.s;
                }
            }
        }

        public void b() {
            new B().c();
        }
    }

}
