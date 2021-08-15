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

import com.github.jonathanxd.iutils.map.MapUtils;
import com.koresframework.kores.Instructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.base.*;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.generic.GenericSignature;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.PlainKoresType;
import kotlin.collections.SetsKt;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Collections;

import static kotlin.collections.CollectionsKt.listOf;

public class AnnotatedTest_ {
    //


    @Test
    public void test() {
        $();
    }

    public static TypeDeclaration $() {

        PlainKoresType plainKoresType = new PlainKoresType("java.lang.invoke.MethodHandle.PolymorphicSignature", true);

        TypeDeclaration typeDeclaration = ClassDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.fromJavaModifiers(Modifier.PUBLIC))
                .genericSignature(GenericSignature.empty())
                .annotations(listOf(
                        Factories.runtimeAnnotation(Simple.class,
                                MapUtils.mapOf("value", new Object[]{
                                        Factories.enumValue(MyEnum.class, "A"), Factories.enumValue(MyEnum.class, "B"), Factories.enumValue(MyEnum.class, "C")
                                })
                        ))
                )
                .qualifiedName("test.AnnotatedTestClass")
                .fields(FieldDeclaration.Builder.Companion.builder()
                        .modifiers(SetsKt.setOf(KoresModifier.PUBLIC, KoresModifier.STATIC))
                        .annotations(listOf(Factories.runtimeAnnotation(Simple.class,
                                MapUtils.mapOf("value", new Object[]{
                                        Factories.enumValue(MyEnum.class, "A")
                                }))))
                        .type(Types.STRING)
                        .name("field")
                        .value(Literals.NULL)
                        .build())
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(SetsKt.setOf(KoresModifier.PUBLIC, KoresModifier.STATIC))
                                .annotations(listOf(Factories.runtimeAnnotation(plainKoresType)))
                                .genericSignature(GenericSignature.empty())
                                .name("polymorphic")
                                .returnType(Types.OBJECT)
                                .parameters(listOf(new KoresParameter(listOf(Factories.deprecatedAnnotation()), Collections.emptySet(), Types.OBJECT, "first")))
                                .body(Instructions.fromVarArgs(Factories.returnValue(Types.OBJECT, Literals.NULL)))
                                .build()

                )
                .build();

        return typeDeclaration;
    }

    public enum MyEnum {
        A,
        B,
        C
    }

    public @interface Simple {
        MyEnum[] value() default {};

        MyEnum myEnum() default MyEnum.A;
    }

}
