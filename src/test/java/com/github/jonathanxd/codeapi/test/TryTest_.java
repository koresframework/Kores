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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.TryStatement;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.TypeSpec;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.iutils.collection.Collections3;

import org.junit.Test;

import java.util.Collections;

public class TryTest_ {
    //

    public static TypeDeclaration $() {

        TryStatement tryStatement = Factories.tryStatement(
                CodeSource.fromPart(Predefined.invokePrintln(Literals.STRING("Ok"))),
                Collections3.listOf(
                        Factories.catchStatement(Exception.class,
                                VariableFactory.variable(Exception.class, "e"),
                                CodeSource.fromPart(
                                        InvocationFactory.invokeVirtual(
                                                Exception.class,
                                                Factories.accessVariable(Exception.class, "e"),
                                                "printStackTrace",
                                                new TypeSpec(Void.TYPE),
                                                Collections.emptyList()
                                        )
                                ))
                ),
                CodeSource.fromPart(Predefined.invokePrintln(Literals.STRING("Finally")))
        );

        return ClassDeclaration.Builder.builder()
                .modifiers(CodeModifier.PUBLIC)
                .specifiedName("test.TryCatchFinally")
                .constructors(ConstructorDeclaration.Builder.builder()
                        .body(CodeSource.fromPart(
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
