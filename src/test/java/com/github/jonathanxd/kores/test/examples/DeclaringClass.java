/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test.examples;

import com.github.jonathanxd.kores.base.Annotation;
import com.github.jonathanxd.kores.base.AnnotationDeclaration;
import com.github.jonathanxd.kores.base.AnnotationProperty;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.EnumDeclaration;
import com.github.jonathanxd.kores.base.EnumEntry;
import com.github.jonathanxd.kores.base.EnumValue;
import com.github.jonathanxd.kores.base.InterfaceDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.iutils.map.MapUtils;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import kotlin.collections.CollectionsKt;

public class DeclaringClass {

    @Test
    public void classes() {
        ClassDeclaration classDeclaration = ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyClassDeclaration")
                .build();

        InterfaceDeclaration interfaceDeclaration = InterfaceDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyInterfaceDeclaration")
                .build();

        AnnotationDeclaration annotationDeclaration = AnnotationDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyAnnotationDeclaration")
                .build();

        EnumDeclaration enumDeclaration = EnumDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyEnumDeclaration")
                .build();
    }

    @Test
    public void annotation() {
        AnnotationDeclaration annotationDeclaration = AnnotationDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyAnnotationDeclaration")
                .properties(
                        AnnotationProperty.Builder.builder()
                                .type(String.class)
                                .name("value")
                                .defaultValue("")
                                .build(),
                        AnnotationProperty.Builder.builder()
                                .type(Class.class)
                                .name("type")
                                .defaultValue(String.class)
                                .build(),
                        AnnotationProperty.Builder.builder()
                                .type(MyEnum.class)
                                .name("enum")
                                .defaultValue(new EnumValue(MyEnum.class, "A"))
                                .build(),
                        AnnotationProperty.Builder.builder()
                                .type(MyAnnotation.class)
                                .name("annotation")
                                .defaultValue(
                                        Annotation.Builder.builder()
                                                .type(MyAnnotation.class)
                                                .values(MapUtils.mapOf(
                                                        "value", new EnumValue(MyEnum.class, "A")
                                                ))
                                                .build()
                                )
                                .build()
                )
                .build();
    }

    @Test
    public void enumDeclaration() {
        EnumDeclaration enumDeclaration = EnumDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyEnumDeclaration")
                .entries(
                        Factories.enumEntry("A")
                )
                .build();

        EnumDeclaration enumDeclaration2 = EnumDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.mypackage.MyEnumDeclaration")
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .parameters(Factories.parameter(String.class, "name"))
                                .build()
                )
                .entries(
                        EnumEntry.Builder.builder()
                                .constructorSpec(Factories.constructorTypeSpec(String.class))
                                .arguments(CollectionsKt.listOf(Literals.STRING("A")))
                                .name("A")
                                .build()
                )
                .build();

    }

    public enum MyEnum {
        A, B
    }


    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        MyEnum value();
    }
}
