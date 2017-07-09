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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeInferenceUtilKt;
import com.github.jonathanxd.codeapi.util.JavaResolver;
import com.github.jonathanxd.codeapi.util.MixedResolver;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TypeInference {

    @Test
    public void typeInferenceTest() {
        GenericType type = Generic.type(Mat.class).of("T");
        GenericType starting = Generic.type(Simple3.class);

        List<CodeType> typeList = new ArrayList<>();

        GenericTypeInferenceUtilKt
                .getInferredType("T", type, starting, type.getDefaultResolver(), new JavaResolver(), typeList);

        Assert.assertTrue(typeList.size() == 1);
        Assert.assertTrue(typeList.get(0).is(Types.STRING));
    }

    @Test
    public void typeInferenceTest2() {
        GenericType type = Generic.type(Mat.class).of("T");
        GenericType starting = Generic.type(Simple5.class);

        List<CodeType> typeList = new ArrayList<>();

        GenericTypeInferenceUtilKt
                .getInferredType("T", type, starting, type.getDefaultResolver(), new JavaResolver(), typeList);

        Assert.assertTrue(typeList.size() == 1);
        Assert.assertTrue(typeList.get(0).isIdEq(BigDecimal.class));
    }

    @Test
    public void typeInferenceTest3() {
        GenericType type = Generic.type(Mat.class).of("T");
        GenericType starting = Generic.type(Simple5.class);

        List<CodeType> typeList = new ArrayList<>();

        GenericTypeInferenceUtilKt
                .getInferredType("T", type, starting, type.getDefaultResolver(), new JavaResolver(), typeList);

        Assert.assertTrue(typeList.size() == 1);
        Assert.assertTrue(typeList.get(0).isIdEq(BigDecimal.class));
    }

    @Test
    public void typeInferenceTest4() {
        GenericType type = Generic.type(Mat.class).of("T");
        GenericType starting = Generic.type(Simple2.class);
        GenericType toInfer = Generic.type(List.class).of("T");

        CodeType codeType = GenericTypeInferenceUtilKt
                .inferType(toInfer, type, starting, type.getDefaultResolver(), new MixedResolver(null));

        Assert.assertTrue(codeType.is(Generic.type(List.class).of(String.class)));
    }


    static class Mat<T> {
        public List<T> getList() { // To be resolved
            return null;
        }
    }

    static class Simple<T> extends Mat<T> {
    }

    static class Z<T> extends Simple<T> {
    }

    static class Simple2 extends Z<String> {

    }

    static class Simple4<T> extends Z<BigDecimal> {

    }

    static class Simple5 extends Simple4<Integer> {

    }

    static class Simple3 extends Simple2 {

    }



}
