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
import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.FieldDeclaration;
import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.base.ScopeAccess;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.factory.InvocationFactory;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.kores.type.TypeRef;

import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;

public class ComplexInnerClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef classRef = new TypeRef("test.InnerClass");
        TypeRef innerClassRef = new TypeRef(classRef, "Inner");
        TypeRef innerInnerClassRef = new TypeRef(innerClassRef, "Inner2");

        TypeDeclaration inner2 = ClassDeclaration.Builder.builder()
                .outerType(innerClassRef)
                .specifiedName("Inner2")
                .fields()
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PRIVATE)
                                .build()
                )
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PRIVATE) // Required to be accessed from inner/outer
                                .returnType(String.class)
                                .name("call2")
                                .body(Instructions.fromVarArgs(
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

        TypeDeclaration inner = ClassDeclaration.Builder.builder()
                .outerType(classRef)
                .innerTypes(inner2)
                .specifiedName("Inner")
                .fields(
                        FieldDeclaration.Builder.builder()
                                .type(classRef)
                                .name("a")
                                .value(InvocationFactory.invokeConstructor(classRef, Factories.constructorTypeSpec(String.class), CollectionsKt.listOf(Literals.STRING("Hello"))))
                                .build(),
                        FieldDeclaration.Builder.builder()
                                .type(innerInnerClassRef)
                                .name("b")
                                .value(InvocationFactory.invokeConstructor(innerInnerClassRef, Factories.constructorTypeSpec(), CollectionsKt.listOf()))
                                .build()
                )
                .constructors()
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PROTECTED) // Required to be accessed from inner/outer
                                .returnType(String.class)
                                .name("call")
                                .body(Instructions.fromVarArgs(
                                        Predefined.invokePrintln(
                                                Factories.accessField(classRef,
                                                        ScopeAccess.outer(classRef),
                                                        Types.STRING, "field")
                                        ),
                                        InvocationFactory.invokeVirtual(classRef, ScopeAccess.outer(classRef),
                                                "mm", Factories.typeSpec(Types.VOID), Collections.emptyList()),
                                        InvocationFactory.invokeVirtual(innerInnerClassRef,
                                                InvocationFactory.invokeConstructor(innerInnerClassRef, Factories.constructorTypeSpec(), CollectionsKt.listOf()),
                                                "call2", Factories.typeSpec(Types.STRING), Collections.emptyList()),

                                        Factories.returnValue(String.class, Literals.STRING("A"))
                                )).build()
                ).build();


        return ClassDeclaration.Builder.builder()
                .base(classRef)
                .innerTypes(inner)
                .fields(FieldDeclaration.Builder.builder()
                        .modifiers(KoresModifier.PRIVATE) // Required to be accessed from inner/outer
                        .type(String.class)
                        .name("field")
                        .value(Literals.STRING("XSD"))
                        .build())
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .body(Instructions.fromVarArgs(
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
                                .modifiers(KoresModifier.PROTECTED) // Required to be accessed from inner/outer
                                .parameters(Factories.parameter(String.class, "str"))
                                .body(Instructions.fromVarArgs(
                                        Predefined.invokePrintln(Factories.accessVariable(String.class, "str"))
                                ))
                                .build()
                )
                .methods(MethodDeclaration.Builder.builder()
                        .name("mm")
                        .body(Instructions.fromVarArgs(
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
