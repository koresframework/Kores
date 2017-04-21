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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.AnnotationDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.impl.AnnotationPropertyImpl;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

import java.util.Collections;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

public class AnnotationTest_ {


    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        AnnotationDeclaration build = AnnotationDeclaration.Builder.Companion.builder()
                .withModifiers(SetsKt.setOf(CodeModifier.PUBLIC))
                .withQualifiedName("com.MyAnnotation")
                .withProperties(CollectionsKt.listOf(new AnnotationPropertyImpl(Types.STRING, "value", Collections.emptyList(), null),
                        new AnnotationPropertyImpl(Types.STRING, "id", Collections.emptyList(), "A"),
                        new AnnotationPropertyImpl(Types.STRING.toArray(1), "names", Collections.emptyList(), new String[]{"A", "B"}),
                        new AnnotationPropertyImpl(Types.INT.toArray(1), "ns", Collections.emptyList(), new int[]{1, 2})))
                .build();

        return Pair.of(build, CodeAPI.sourceOfParts(build));
    }

    @Test
    public void test() {
        $();
    }
}
