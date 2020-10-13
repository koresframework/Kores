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
package com.github.jonathanxd.kores.test.other;

import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.type.Generic;
import com.github.jonathanxd.kores.type.KoresTypes;
import com.github.jonathanxd.kores.util.conversion.ConversionsKt;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionsTest {

    @Test
    public void testGenericMethodConversion() throws Exception {
        Method test = ConversionsTest.class.getDeclaredMethod("test", List.class);
        MethodDeclaration methodDeclaration = ConversionsKt.toMethodDeclaration(test);

        Assert.assertEquals(Generic.type(List.class).of(Integer.class),
                KoresTypes.getKoresType(methodDeclaration.getReturnType()));

        Assert.assertEquals(1, methodDeclaration.getParameters().size());

        Assert.assertEquals(Generic.type(List.class).of(String.class),
                KoresTypes.getKoresType(methodDeclaration.getParameters().get(0).getType()));
    }


    public List<Integer> test(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
