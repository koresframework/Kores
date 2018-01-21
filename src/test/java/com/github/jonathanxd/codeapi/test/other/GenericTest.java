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

import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.type.GenericTypeBuilder;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class GenericTest {

    @Test
    public void generic() {

        Assert.assertTrue(Generic.type(Types.CODE_PART).is(Types.CODE_PART));
        Assert.assertFalse(Types.CODE_PART.is(Generic.type(Types.CODE_PART).of(Types.STRING)));

        GenericType build = GenericTypeBuilder.builder()
                .type(Map.class)
                .addOfBound(String.class)
                .addOfBound(
                        GenericTypeBuilder.builder().type(List.class)
                                .addOfBound(GenericTypeBuilder.builder().wildcard().addExtendsBound("K").build())
                                .build()

                )
                .build();

        Assert.assertTrue(build.is(
                Generic.type(Map.class)
                        .of(String.class)
                        .of(Generic.type(List.class).of(Generic.wildcard().extends$("K")))
        ));
    }


    @Test
    public void methodSigTest() {
        MethodDeclaration build = MethodDeclaration.Builder.builder()
                .name("test")
                .genericSignature(GenericSignature.create(
                        Generic.type("T").extends$(CharSequence.class)
                ))
                .parameters(Factories.parameter(Generic.type("T"), "self"))
                .returnType(Generic.type("T"))
                .build();

        String s = GenericTypeUtil.methodGenericSignature(build);

        String s2 = GenericTypeUtil.methodGenericSignature(MethodDeclaration.Builder.builder()
                .name("test").genericSignature(GenericSignature.create(
                        Generic.type("T").extends$(Object.class)
                ))
                .parameters(Factories.parameter(Generic.type("T"), "self"))
                .returnType(Generic.type("T"))
                .build());

        String s3 = GenericTypeUtil.methodGenericSignature(MethodDeclaration.Builder.builder()
                .name("test").genericSignature(GenericSignature.create(
                        Generic.type("T")
                ))
                .parameters(Factories.parameter(Generic.type("T"), "self"))
                .returnType(Generic.type("T"))
                .build());

        String s4 = GenericTypeUtil.methodGenericSignature(MethodDeclaration.Builder.builder()
                .name("test").genericSignature(GenericSignature.create(
                        Generic.type("T").extends$(Throwable.class)
                ))
                .throwsClause(Generic.type("T"))
                .build());

        Assert.assertEquals("<T::Ljava/lang/CharSequence;>(TT;)TT;", s);
        Assert.assertEquals("<T:Ljava/lang/Object;>(TT;)TT;", s2);
        Assert.assertEquals("<T:Ljava/lang/Object;>(TT;)TT;", s3);
        Assert.assertEquals("<T:Ljava/lang/Throwable;>()V^TT;", s4);
    }
}
