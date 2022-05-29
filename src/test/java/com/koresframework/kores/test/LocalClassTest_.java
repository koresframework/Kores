/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.koresframework.kores.Types;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.MethodDeclaration;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.TypeRef;

import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.TypeRef;
import org.junit.Test;

import java.util.Collections;

public class LocalClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef outerType = new TypeRef("test.LocalClass");

        ClassDeclaration local = ClassDeclaration.Builder.builder()
                .outerType(outerType)
                .specifiedName("Greeter")
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC)
                                .name("greet")
                                .returnType(Types.VOID)
                                .body(Instructions.fromPart(
                                        Predefined.invokePrintlnStr(Literals.STRING("Hello"))
                                ))
                                .build()
                )
                .build();


        TypeDeclaration type = ClassDeclaration.Builder.builder()
                .base(outerType)
                .specifiedName(outerType.getSpecifiedName())
                .constructors(ConstructorDeclaration.Builder.builder()
                        .innerTypes(local)
                        .modifiers(KoresModifier.PUBLIC)
                        .body(
                                Instructions.fromPart(
                                        InvocationFactory.invokeVirtual(
                                                local,
                                                InvocationFactory.invokeConstructor(local),
                                                "greet",
                                                Factories.constructorTypeSpec(),
                                                Collections.emptyList()
                                        )
                                )
                        ).build())
                .build();

        return type;
    }

    @Test
    public void test() {
        $();
    }


}
