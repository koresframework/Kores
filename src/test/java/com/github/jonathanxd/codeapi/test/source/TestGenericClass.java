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
import com.github.jonathanxd.codeapi.test.GenericClass_;
import com.github.jonathanxd.codeapi.test.tests.CommonSourceTest;
import com.github.jonathanxd.iutils.annotations.Named;
import com.github.jonathanxd.iutils.object.Bi;

import org.junit.Test;

/**
 * Created by jonathan on 07/07/16.
 */
public class TestGenericClass {

    @Test
    public void genericClass() {
        Bi<@Named("Main class") CodeClass, @Named("Source") CodeSource> $ = GenericClass_.$();
        CommonSourceTest.test($._2()).consume(System.out::println).expect("package com ; \n" +
                "public class Generic < T extends java.util.List < T > > implements java.util.List < T > { \n" +
                "    public static < T extends java.util.List < T > > void test ( T val ) { \n" +
                "         T fieldi = null ; \n" +
                "         \n" +
                "    } \n" +
                "    \n" +
                "    public T test ; \n" +
                "     \n" +
                "} \n\n");
    }

}
