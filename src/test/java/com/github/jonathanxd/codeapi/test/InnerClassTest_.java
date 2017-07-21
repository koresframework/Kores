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
import com.github.jonathanxd.codeapi.base.Access;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.ScopeAccess;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.type.TypeRef;
import com.github.jonathanxd.codeapi.util.Alias;

import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;

public class InnerClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef classRef = new TypeRef("test.InnerClass");
        TypeRef innerClassRef = new TypeRef(classRef, "Inner");

        TypeDeclaration inner = ClassDeclaration.Builder.builder()
                .outerClass(classRef)
                .specifiedName("Inner")
                .fields(
                        /*FieldDeclaration.Builder.builder()
                                .type(classRef)
                                .modifiers(CodeModifier.PRIVATE, CodeModifier.FINAL)
                                .name("outer")
                                .build(),*/
                        FieldDeclaration.Builder.builder()
                                .type(classRef)
                                .name("a")
                                .value(InvocationFactory.invokeConstructor(classRef, Factories.constructorTypeSpec(String.class), CollectionsKt.listOf(Literals.STRING("Hello"))))
                                .build()
                )
                .constructors(
                        /*ConstructorDeclaration.Builder.builder()
                                .parameters(Factories.parameter(classRef, "outer"))
                                .body(CodeSource.fromPart(
                                        Factories.setFieldValue(Alias.THIS.INSTANCE, Factories.accessThis(), classRef, "outer",
                                                Factories.accessVariable(classRef, "outer"))
                                ))
                                .build()*/
                )
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PROTECTED) // Required to be accessed from inner/outer
                                .returnType(String.class)
                                .name("call")
                                .body(CodeSource.fromVarArgs(
                                        Predefined.invokePrintln(
                                                Factories.accessField(classRef,
                                                        ScopeAccess.outer(classRef),
                                                        Types.STRING, "field")
                                        ),
                                        InvocationFactory.invokeVirtual(classRef, ScopeAccess.outer(classRef),
                                                "mm", Factories.typeSpec(Types.VOID), Collections.emptyList()),
                                        Factories.returnValue(String.class, Literals.STRING("A"))
                                )).build()
                ).build();

        return ClassDeclaration.Builder.builder()
                .base(classRef)
                .innerTypes(inner)
                .fields(FieldDeclaration.Builder.builder()
                        .modifiers(CodeModifier.PROTECTED) // Required to be accessed from inner/outer
                        .type(String.class)
                        .name("field")
                        .value(Literals.STRING("XSD"))
                        .build())
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .body(CodeSource.fromVarArgs(
                                        InvocationFactory.invokeVirtual(
                                                inner,
                                                InvocationFactory.invokeConstructor(inner/*,
                                                        Factories.voidTypeSpec(classRef),
                                                        Collections.singletonList(Factories.accessThis())*/),
                                                "call",
                                                Factories.typeSpec(String.class),
                                                Collections.emptyList()
                                        )
                                ))
                                .build(),
                        ConstructorDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PROTECTED) // Required to be accessed from inner/outer
                                .parameters(Factories.parameter(String.class, "str"))
                                .body(CodeSource.fromVarArgs(
                                        Predefined.invokePrintln(Factories.accessVariable(String.class, "str"))
                                ))
                                .build()
                )
                .methods(MethodDeclaration.Builder.builder()
                        .name("mm")
                        .body(CodeSource.fromVarArgs(
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
