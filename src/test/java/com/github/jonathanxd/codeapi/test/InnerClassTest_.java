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
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.type.TypeRef;

import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;

public class InnerClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef classRef = new TypeRef("test.InnerClass");
        TypeRef innerClassRef = new TypeRef(classRef, "Inner");

        TypeDeclaration inner = ClassDeclaration.Builder.builder()
                .withOuterClass(classRef)
                .withSpecifiedName("Inner")
                .withFields(
                        FieldDeclaration.Builder.builder()
                                .withType(classRef)
                                .withName("a")
                                .withValue(InvocationFactory.invokeConstructor(classRef, Factories.constructorTypeSpec(String.class), CollectionsKt.listOf(Literals.STRING("Hello"))))
                                .build()
                )
                .withMethods(
                        MethodDeclaration.Builder.builder()
                                .withModifiers(CodeModifier.PRIVATE)
                                .withReturnType(String.class)
                                .withName("call")
                                .withBody(CodeSource.fromVarArgs(
                                        Predefined.invokePrintln(
                                                Factories.accessField(classRef, Factories.accessOuter(classRef), Types.STRING, "field")
                                        ),
                                        InvocationFactory.invokeVirtual(classRef, Factories.accessOuter(classRef), "mm", Factories.typeSpec(Types.VOID), Collections.emptyList()),
                                        Factories.returnValue(String.class, Literals.STRING("A"))
                                )).build()
                ).build();

        return ClassDeclaration.Builder.builder()
                .base(classRef)
                .withInnerTypes(inner)
                .withFields(FieldDeclaration.Builder.builder()
                        .withModifiers(CodeModifier.PRIVATE)
                        .withType(String.class)
                        .withName("field")
                        .withValue(Literals.STRING("XSD"))
                        .build())
                .withConstructors(
                        ConstructorDeclaration.Builder.builder()
                                .withBody(CodeSource.fromVarArgs(
                                        InvocationFactory.invokeVirtual(
                                                inner,
                                                InvocationFactory.invokeConstructor(inner),
                                                "call",
                                                Factories.typeSpec(String.class),
                                                Collections.emptyList()
                                        )
                                ))
                                .build(),
                        ConstructorDeclaration.Builder.builder()
                                .withModifiers(CodeModifier.PRIVATE)
                                .withParameters(Factories.parameter(String.class, "str"))
                                .withBody(CodeSource.fromVarArgs(
                                        Predefined.invokePrintln(Factories.accessVariable(String.class, "str"))
                                ))
                                .build()
                )
                .withMethods(MethodDeclaration.Builder.builder()
                        .withName("mm")
                        .withBody(CodeSource.fromVarArgs(
                                Predefined.invokePrintln(Literals.STRING("A"))
                        ))
                        .build())
                .build();
    }

    @Test
    public void test() {
        $();
    }


}
