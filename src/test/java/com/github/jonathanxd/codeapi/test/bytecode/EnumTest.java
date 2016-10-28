/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test.bytecode;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.test.EnumTest_;
import com.github.jonathanxd.codeapi.test.tests.CommonBytecodeTest;
import com.github.jonathanxd.iutils.annotations.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $ = EnumTest_.$();

        @Named("Instance") Class<Enum> test = (Class<Enum>) CommonBytecodeTest.test(this.getClass(), $._1(), $._2(), aClass -> aClass);

        Enum a = Enum.valueOf(test, "A");

        Assert.assertEquals(0, a.ordinal());
        Assert.assertEquals("A", a.name());

        EnumTest_.MyItf myItf = (EnumTest_.MyItf) a;

        myItf.v();
    }

}

