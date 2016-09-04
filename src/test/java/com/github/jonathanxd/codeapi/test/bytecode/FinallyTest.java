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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.test.tests.CommonBytecodeTest;
import com.github.jonathanxd.iutils.annotations.Named;

import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by jonathan on 21/08/16.
 */
public class FinallyTest {

    @Test(expected = RuntimeException.class)
    public void test() {
        CodeSource codeSource = new CodeSource();

        CodeClass codeInterface;

        codeSource.add(codeInterface = CodeAPI.aClass(Modifier.PUBLIC, "test.Btc", codeClass -> CodeAPI.sourceOfParts(
                CodeAPI.constructor(Modifier.PUBLIC, codeClass, codeConstructor -> CodeAPI.sourceOfParts(
                        Helper.surround(CodeAPI.sourceOfParts(
                                Helper.throwException(Helper.getJavaType(RuntimeException.class), new CodeArgument[]{
                                    CodeAPI.argument(Literals.STRING("EXCEPTION"), String.class)
                                })
                                ),
                                Collections.singletonList(
                                        Helper.catchBlock(Collections.singletonList(Helper.getJavaType(Exception.class)), "ex",
                                                Helper.sourceOf(Helper.throwException(Helper.getJavaType(RuntimeException.class), new CodeArgument[]{
                                                        CodeAPI.argument(Literals.STRING("Rethrow"), String.class),
                                                        CodeAPI.argument(Helper.accessLocalVariable("ex", Throwable.class), Throwable.class)
                                                }))
                                        )
                                ),
                                CodeAPI.sourceOfParts(
                                        Predefined.invokePrintln(CodeAPI.argument(Literals.STRING("Finally"), String.class))
                                ))
                ))
        )));

        @Named("Instance") Object test = CommonBytecodeTest.test(this.getClass(), codeInterface, codeSource);
    }

}
