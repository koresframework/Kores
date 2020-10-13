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

import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.AnnotationDeclaration;
import com.github.jonathanxd.kores.base.AnnotationProperty;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.base.comment.Comments;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.iutils.collection.Collections3;

import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

public class AnnotationTest_ {


    public static TypeDeclaration $() {

        AnnotationDeclaration build = AnnotationDeclaration.Builder.Companion.builder()
                .modifiers(SetsKt.setOf(KoresModifier.PUBLIC))
                .qualifiedName("com.MyAnnotation")
                .properties(CollectionsKt.listOf(
                        new AnnotationProperty(Comments.Absent, Collections.emptyList(), Types.STRING, "value", null),
                        new AnnotationProperty(Comments.Absent, Collections.emptyList(), Types.STRING, "id", "A"),
                        new AnnotationProperty(Comments.Absent, Collections.emptyList(), Types.STRING.toArray(1), "names",
                                Collections3.listOf("A", "B")),
                        Factories.annotationProperty(Types.INT.toArray(1), "ns", Collections3.listOf(1, 2))
                ))
                .build();

        return build;
    }

    @Test
    public void test() {
        $();
    }
}
