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
package com.koresframework.kores.test;

import com.koresframework.kores.Instructions;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.TryStatement;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.base.TypeSpec;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.github.jonathanxd.iutils.collection.Collections3;

import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.TryStatement;
import org.junit.Test;

import java.util.Collections;

public class TryTest_ {
    //

    public static TypeDeclaration $() {

        TryStatement tryStatement = Factories.tryStatement(
                Instructions.fromPart(
                        InvocationFactory.invokeStatic(
                                TryTest_.class,
                                "boom",
                                new TypeSpec(Void.TYPE),
                                Collections.emptyList()
                        )
                ),
                Collections3.listOf(
                        Factories.catchStatement(Exception.class,
                                VariableFactory.variable(Exception.class, "e"),
                                Instructions.fromPart(
                                        InvocationFactory.invokeVirtual(
                                                Exception.class,
                                                Factories.accessVariable(Exception.class, "e"),
                                                "printStackTrace",
                                                new TypeSpec(Void.TYPE),
                                                Collections.emptyList()
                                        )
                                ))
                ),
                Instructions.fromPart(Predefined.invokePrintln(Literals.STRING("Finally")))
        );

        return ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .specifiedName("test.TryCatchFinally")
                .constructors(ConstructorDeclaration.Builder.builder()
                        .body(Instructions.fromPart(
                                tryStatement
                        ))
                        .build())
                .build();
    }

    public static void boom() {
        throw new IllegalStateException();
    }

    @Test
    public void test() {
        $();
    }

}
