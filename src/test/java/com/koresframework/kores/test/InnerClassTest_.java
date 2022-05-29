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
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.MethodDeclaration;
import com.koresframework.kores.base.ScopeAccess;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.TypeRef;

import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.ScopeAccess;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.TypeRef;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;

public class InnerClassTest_ {
    //
    public static TypeDeclaration $() {

        TypeRef classRef = new TypeRef("test.InnerClass");
        TypeRef innerClassRef = new TypeRef(classRef, "Inner");

        TypeDeclaration inner = ClassDeclaration.Builder.builder()
                .outerType(classRef)
                .specifiedName("Inner")
                .fields(
                        /*FieldDeclaration.Builder.builder()
                                .type(classRef)
                                .modifiers(KoresModifier.PRIVATE, KoresModifier.FINAL)
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
                                .body(Instructions.fromPart(
                                        Factories.setFieldValue(Alias.THIS.INSTANCE, Factories.accessThis(), classRef, "outer",
                                                Factories.accessVariable(classRef, "outer"))
                                ))
                                .build()*/
                )
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
                                        Factories.returnValue(String.class, Literals.STRING("A"))
                                )).build()
                ).build();

        return ClassDeclaration.Builder.builder()
                .base(classRef)
                .innerTypes(inner)
                .fields(FieldDeclaration.Builder.builder()
                        .modifiers(KoresModifier.PROTECTED) // Required to be accessed from inner/outer
                        .type(String.class)
                        .name("field")
                        .value(Literals.STRING("XSD"))
                        .build())
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .body(Instructions.fromVarArgs(
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
        TypeDeclaration $ = $();
        Assert.assertEquals("test.InnerClass", $.getQualifiedName());
        Assert.assertEquals("test.InnerClass.Inner", $.getInnerTypes().get(0).getQualifiedName());
        Assert.assertEquals("test/InnerClass$Inner", $.getInnerTypes().get(0).getInternalName());
        Assert.assertEquals("test/InnerClass$Inner", $.getInnerTypes().get(0).builder().build().getInternalName());
    }


}
