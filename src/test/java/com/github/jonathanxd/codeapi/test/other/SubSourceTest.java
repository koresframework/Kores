/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.CodeInstruction;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.literal.Literals;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Collectors;

import static com.github.jonathanxd.codeapi.literal.Literals.STRING;

public class SubSourceTest {

    @Test
    public void subSourceTest() {
        CodeSource codeSource = CodeSource.fromVarArgs(STRING("A"), STRING("B"), STRING("C"), STRING("D"));

        CodeSource sub = codeSource.subSource(0, codeSource.getSize() - 1);

        Function<CodeInstruction, String> func = i -> ((Literals.StringLiteral) i).getOriginal();

        String collect1 = sub
                .stream().map(func).collect(Collectors.joining(", "));

        String collect2 = codeSource.subSource(1, codeSource.getSize() - 1)
                .stream().map(func)
                .collect(Collectors.joining(", "));

        String collect3 = sub
                .subSource(1, sub.getSize())
                .stream().map(func).collect(Collectors.joining(", "));

        String collect4 = sub
                .subSource(1, sub.getSize())
                .subSource(0, 1)
                .stream().map(func).collect(Collectors.joining(", "));


        Assert.assertEquals("A, B, C", collect1);
        Assert.assertEquals("B, C", collect2);
        Assert.assertEquals("B, C", collect3);
        Assert.assertEquals("B", collect4);
    }

}
