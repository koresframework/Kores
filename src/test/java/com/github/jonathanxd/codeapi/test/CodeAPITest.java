/*
 *      ${expr} - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Helper;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.storage.StorageKeys;
import com.github.jonathanxd.codeapi.util.CodeModifier;

import org.junit.Test;

import javax.annotation.processing.Processor;

/**
 * Created by jonathan on 02/05/16.
 */
public class CodeAPITest {

    @Test
    public void codeAPITest() {

        CodeSource mySource = new CodeSource();

        CodeInterface codeClass = new CodeInterface("github.com.MyClass");

        codeClass.addModifier(CodeModifier.PUBLIC);

        mySource.add(codeClass);

        codeClass.addImplementation(Helper.getJavaType(Processor.class));


        codeClass.add(StorageKeys.BODIES, Helper.sourceOf(createMethod()));


        PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;

        String source = plainSourceGenerator.gen(mySource);

        System.out.println("source = "+source);

        /*CodeParameter codeParameter = new CodeParameter();

        CodeInterface codeInterface = new CodeInterface();*/


    }

    private static CodeMethod createMethod() {
        CodeMethod codeMethod = new CodeMethod("println");
        codeMethod.addAll(StorageKeys.MODIFIERS, CodeModifier.PUBLIC, CodeModifier.STATIC);
        codeMethod.setReturnType(Helper.getJavaType(Void.TYPE));

        return codeMethod;
    }


}
