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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.type.TypeRef;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

import java.util.Collections;

public class LocalClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef outerType = new TypeRef("test.LocalClass");

        ClassDeclaration local = ClassDeclaration.Builder.builder()
                .withOuterClass(outerType)
                .withSpecifiedName("Greeter")
                .withMethods(
                        MethodDeclaration.Builder.builder()
                                .withModifiers(CodeModifier.PUBLIC)
                                .withName("greet")
                                .withReturnType(Types.VOID)
                                .withBody(CodeSource.fromPart(
                                        Predefined.invokePrintlnStr(Literals.STRING("Hello"))
                                ))
                                .build()
                )
                .build();


        TypeDeclaration type = ClassDeclaration.Builder.builder()
                .base(outerType)
                .withSpecifiedName(outerType.getSpecifiedName())
                .withConstructors(ConstructorDeclaration.Builder.builder()
                        .withInnerTypes(local)
                        .withModifiers(CodeModifier.PUBLIC)
                        .withBody(
                                CodeSource.fromPart(
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
