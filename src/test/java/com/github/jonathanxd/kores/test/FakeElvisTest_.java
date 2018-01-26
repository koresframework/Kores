/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test;

import com.github.jonathanxd.kores.Instructions;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.base.TypeSpec;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.kores.operator.Operators;

import org.junit.Test;

import java.util.Collections;

import static com.github.jonathanxd.kores.factory.Factories.accessVariable;
import static com.github.jonathanxd.kores.factory.Factories.ifExpr;
import static com.github.jonathanxd.kores.factory.Factories.ifExprs;
import static com.github.jonathanxd.kores.factory.Factories.ifStatement;
import static com.github.jonathanxd.kores.factory.Factories.parameter;
import static com.github.jonathanxd.kores.factory.Factories.returnValue;
import static com.github.jonathanxd.kores.factory.InvocationFactory.invokeConstructor;
import static com.github.jonathanxd.kores.factory.InvocationFactory.invokeStatic;

/**
 * A fake elvis, which cannot be expressed in Java (but can be expressed in bytecode).
 *
 * The structure represents something like this:
 *
 * <pre>
 *     {@code
 *     class ElvisExpandTest {
 *         fun test(a: String) {
 *             TestClass(if (a == null) TestClass.noti(); "" else TestClass.noti(); a)
 *         }
 *     }
 *
 *     }
 * </pre>
 */
public class FakeElvisTest_ {

    public static TypeDeclaration $() {
        return ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .name("com.FakeElvisTest")
                .methods(MethodDeclaration.Builder.builder()
                        .modifiers(KoresModifier.PUBLIC)
                        .returnType(TestClass.class)
                        .name("test")
                        .parameters(parameter(String.class, "a"))
                        .body(Instructions.fromVarArgs(
                                returnValue(TestClass.class, invokeConstructor(TestClass.class,
                                        new TypeSpec(Void.TYPE, Collections.singletonList(String.class)),
                                        Collections.singletonList(
                                                ifStatement(
                                                        ifExprs(
                                                                ifExpr(
                                                                accessVariable(String.class, "a"),
                                                                Operators.EQUAL_TO,
                                                                Literals.NULL
                                                                )
                                                        ),
                                                        Instructions.fromVarArgs(
                                                                invokeStatic(TestClass.class, "noti"),
                                                                Literals.STRING("")
                                                        ),
                                                        Instructions.fromVarArgs(
                                                                invokeStatic(TestClass.class, "noti2"),
                                                                accessVariable(String.class, "a")
                                                        ))
                                        )
                                ))
                        ))
                        .build())
                .build();
    }

    @Test
    public void test() {
        $();
    }

    public static class TestClass {
        private final String s;

        public TestClass(String s) {
            this.s = s;
        }

        public String getS() {
            return this.s;
        }

        public static void noti() {

        }

        public static void noti2() {

        }
    }


}
