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
package com.github.jonathanxd.codeapi.test.processor;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.builder.Builder;
import com.github.jonathanxd.codeapi.exception.ValidationException;
import com.github.jonathanxd.codeapi.literal.Literals;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class MyProcessorTest {

    @Test
    public void test() {
        MyProcessor myProcessor = new MyProcessor();

        VariableDeclaration variableDeclaration = new VariableDeclaration(
                Collections.emptySet(),
                String.class,
                "name",
                Literals.STRING("CodeAPI")
        );

        String process = myProcessor.process(variableDeclaration);

        Assert.assertEquals("java.lang.String name = \"CodeAPI\"", process);
    }

    @Test(expected = ValidationException.class)
    public void testValidation() {
        MyProcessor myProcessor = new MyProcessor();

        VariableDeclaration variableDeclaration = new VariableDeclaration(
                Collections.emptySet(),
                String.class,
                "name",
                new VariableAccess(String.class, "name")
        );

        String process = myProcessor.process(variableDeclaration);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testUnk() {
        MyProcessor myProcessor = new MyProcessor();

        myProcessor.process(new CodePart() {
            @NotNull
            @Override
            public Builder<CodePart, ?> builder() {
                return CodePart.DefaultImpls.builder(this);
            }
        });
    }
}