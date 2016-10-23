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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.test.tests.CommonBytecodeTest;
import com.github.jonathanxd.iutils.exceptions.RethrowException;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * Created by jonathan on 25/07/16.
 */
public class FinalFieldWithThis {


    @Test
    public void finalFieldWithThis() {
        CodeSource codeSource = new CodeSource();

        CodeClass testField = CodeAPI.aClass(Modifier.PUBLIC, "finalfieldwiththis.Test", TestBox.class, new Class[0], codeClass ->
                CodeAPI.sourceOfParts(
                        CodeAPI.field(Modifier.PRIVATE | Modifier.FINAL, TestBox.class, "testField",
                                CodeAPI.invokeConstructor(TestBox.class, CodeAPI.argument(Helper.accessThis(), Object.class))),
                        CodeAPI.constructor(Modifier.PUBLIC, codeConstructor -> CodeAPI.sourceOfParts(
                                Helper.invokeSuperInit(Helper.getJavaType(TestBox.class), CodeAPI.argument(Literals.NULL, Object.class))
                        ))
                ));

        codeSource.add(testField);

        CommonBytecodeTest.test(this.getClass(), testField, codeSource, aClass -> {
            try {
                return aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RethrowException(e, e.getCause());
            }
        });
    }

    public static class TestBox {
        private final Object o;

        public TestBox(Object o) {
            this.o = o;
        }
    }
}
