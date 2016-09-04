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
package com.github.jonathanxd.codeapi.test;

import static com.github.jonathanxd.codeapi.test.TryWithResourcesTest_.*;

/**
 * Created by jonathan on 04/09/16.
 */
@SuppressWarnings("Duplicates")
public class Test {

    public static void test() throws Throwable {
        Trm trm = new Trm();
        Throwable tr = null;

        try {
            trm.read();
        } catch (Throwable t) {
            tr = t;
            throw t;
        } finally {
            if(trm != null) {
                if(tr != null) {
                    try {
                        trm.close();
                    } catch (Throwable v) {
                        tr.addSuppressed(v);
                    }
                } else {
                    trm.close();
                }
            }
        }
    }

    public static void test3() throws Throwable {
        Trm trm = new Trm();
        Throwable tr = null;

        try {
            trm.read();
            if(trm != null) {
                if(tr != null) {
                    try {
                        trm.close();
                    } catch (Throwable v) {
                        tr.addSuppressed(v);
                    }
                } else {
                    trm.close();
                }
            }
        } catch (Throwable t) {
            tr = t;
            if(trm != null) {
                if(tr != null) {
                    try {
                        trm.close();
                    } catch (Throwable v) {
                        tr.addSuppressed(v);
                    }
                } else {
                    trm.close();
                }
            }
            throw t;
        }
    }

}
