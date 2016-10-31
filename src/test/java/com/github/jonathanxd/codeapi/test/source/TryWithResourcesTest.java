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
package com.github.jonathanxd.codeapi.test.source;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.test.TryWithResourcesTest_;
import com.github.jonathanxd.codeapi.test.tests.CommonSourceTest;
import com.github.jonathanxd.codeapi.test.tests.SourceTest;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

/**
 * Created by jonathan on 03/06/16.
 */
public class TryWithResourcesTest {
    @Test
    public void testSource() {
        Pair<@Named("Main class") CodeClass, @Named("Source") CodeSource> $ = TryWithResourcesTest_.$();
        SourceTest test = CommonSourceTest.test($._2());
        test.expect("package test ; \n" +
                "public class TryWithResourcesTestClass { \n" +
                "    public TryWithResourcesTestClass ( ) { \n" +
                "        try (  com.github.jonathanxd.codeapi.test.TryWithResourcesTest_.Trm trm = new com.github.jonathanxd.codeapi.test.TryWithResourcesTest_.Trm ( ) ) { \n" +
                "            trm . read ( ) ; \n" +
                "             \n" +
                "        } \n" +
                "        \n" +
                "         \n" +
                "    } \n" +
                "    \n" +
                "     \n" +
                "} \n\n");
    }
}
