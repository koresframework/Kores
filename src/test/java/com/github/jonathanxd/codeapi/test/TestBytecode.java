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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.generatorv2.ByteVisitGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeConstructorBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.util.CodeArgument;
import com.github.jonathanxd.codeapi.util.CodeModifier;
import com.github.jonathanxd.codeapi.util.InvokeType;
import com.github.jonathanxd.iutils.arrays.Arrays;

import org.junit.Test;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;

/**
 * Created by jonathan on 03/06/16.
 */
public class TestBytecode {
    @Test
    public void testBytecode() {

        CodeSource codeSource = new CodeSource();

        codeSource.add(Helper.declarePackage("fullName"));


        CodeSource clSource = new CodeSource();

        CodeClass codeClass = new CodeClass("fullName.Lmh",
                java.util.Arrays.asList(CodeModifier.PUBLIC),
                null, null, clSource);

        CodeField codeField = new CodeField("FIELD",
                Helper.getJavaType(String.class),
                java.util.Arrays.asList(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Literals.QUOTED_STRING("AVD"));

        CodeField codeField2 = new CodeField("n",
                Helper.getJavaType(Integer.TYPE),
                java.util.Arrays.asList(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Literals.INT(15));

        clSource.add(codeField);
        clSource.add(codeField2);

        MethodSpec spec = new MethodSpec("println", Helper.getJavaType(Void.TYPE), Collections.singletonList(new CodeArgument(Literals.QUOTED_STRING("Hello"), false, Helper.getJavaType(String.class))));

        CodePart invokeTest = Helper.invoke(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(OutputStream.class),
                Helper.accessVariable(Helper.localizedAtType(Helper.getJavaType(System.class)), "out"), spec);

        CodeConstructor codeConstructor = CodeConstructorBuilder.builder()
                .withDeclaringClass(codeClass)
                .withModifiers(java.util.Arrays.asList(CodeModifier.PUBLIC))
                .withBody(Helper.sourceOf(invokeTest))
                .build();

        clSource.add(codeConstructor);

        codeSource.add(codeClass);

        ByteVisitGenerator bytecodeGenerator = new ByteVisitGenerator();

        Byte[] gen = bytecodeGenerator.gen(codeSource);

        BCLoader bcLoader = new BCLoader();

        Class<?> define = bcLoader.define("fullName.Lmh", Arrays.PrimitiveArray.toPrimitive(gen));

        System.out.println("Class -> " + Modifier.toString(define.getModifiers()) + " " + define);

        Object o;
        try {
            o = define.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        for (Field field : define.getDeclaredFields()) {
            try {
                System.out.println("Field -> " + field +" = "+ field.get(o));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }
}
