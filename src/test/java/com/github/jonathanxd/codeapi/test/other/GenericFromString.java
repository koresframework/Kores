/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.type.GenericType;
import com.github.jonathanxd.codeapi.util.GenericTypeUtil;

import org.junit.Assert;
import org.junit.Test;

public class GenericFromString {

    @Test
    public void genericFromString() {

        GenericType genericType = GenericTypeUtil.fromSourceString("java.util.List<? extends java.util.Set<java.lang.String>>");

        Assert.assertEquals(genericType.toString(), "java.util.List<? extends java.util.Set<java.lang.String>>");

        GenericType genericType2 = GenericTypeUtil.fromSourceString("java.util.List<? extends java.util.Map<java.lang.String, java.util.List<? super java.lang.Integer>>>");

        Assert.assertEquals(genericType2.toString(), "java.util.List<? extends java.util.Map<java.lang.String, java.util.List<? super java.lang.Integer>>>");

    }

}
