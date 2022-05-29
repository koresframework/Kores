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
package com.koresframework.kores.test.other;

import com.koresframework.kores.Instructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.base.Alias;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.MethodDeclaration;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.base.TypeSpec;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.util.StringsKt;

import com.koresframework.kores.base.Alias;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import org.junit.Test;

import java.util.Collections;

public class StringTest {
    @Test
    public void test() {

        TypeDeclaration typeDeclaration = ClassDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("com.A")
                .superClass(Types.OBJECT)
                .methods(
                        MethodDeclaration.Builder.builder()
                                .name("test")
                                .body(Instructions.fromPart(
                                        InvocationFactory.invokeVirtual(Alias.THIS.INSTANCE, Factories.accessThis(), "aa",
                                                new TypeSpec(Types.VOID, Collections.emptyList()),
                                                Collections.emptyList())
                                ))
                                .build()
                )
                .build();

        System.out.println(typeDeclaration);
        System.out.println("=== To Strings method ===");

        System.out.println(StringsKt.toString(typeDeclaration.getMethods().get(0)));

        System.out.println("=== Normal To Strings method ===");

        System.out.println(StringsKt.asString(typeDeclaration));
    }
}
