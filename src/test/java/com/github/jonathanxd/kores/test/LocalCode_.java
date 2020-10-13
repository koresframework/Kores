/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.kores.MutableInstructions;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.FieldDeclaration;
import com.github.jonathanxd.kores.base.InvokeType;
import com.github.jonathanxd.kores.base.LocalCode;
import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.helper.ConcatHelper;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.kores.type.Generic;

import org.junit.Test;

import java.util.Collections;

public class LocalCode_ {

    public static TypeDeclaration $() {

        MutableInstructions source = MutableInstructions.create();

        ClassDeclaration classDeclaration =

                ClassDeclaration.Builder.builder()
                        .specifiedName("com.MethodFragment")
                        .fields(FieldDeclaration.Builder.builder()
                                .type(Generic.type("T"))
                                .name("test")
                                .build())
                        .methods(MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                                .name("test")
                                .body(source)
                                .build())
                        .build();

        LocalCode build = LocalCode.Builder.builder()
                .declaringType(classDeclaration)
                .invokeType(InvokeType.INVOKE_SPECIAL)
                .declaration(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PRIVATE, KoresModifier.STATIC)
                                .returnType(String.class)
                                .parameters(Factories.parameter(String.class, "input"))
                                .name("sameMod")
                                .body(Instructions.fromVarArgs(
                                        Factories.returnValue(String.class,
                                                ConcatHelper.builder("[")
                                                        .concat(Factories.accessVariable(String.class, "input"))
                                                        .concat("]")
                                                        .build()
                                        )
                                ))
                                .build()
                )
                .build();

        source.add(build);

        source.add(Predefined.invokePrintln(
                build.createInvocation(Collections.singletonList(Literals.STRING("Hello")))
        ));

        return classDeclaration;
    }

    @Test
    public void test() {
        $();
    }


}
