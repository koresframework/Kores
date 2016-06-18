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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.generatorv2.ByteVisitGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeClassBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeFieldBuilder;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.CodeMethodBuilder;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;
import com.github.jonathanxd.iutils.optional.Require;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static com.github.jonathanxd.codeapi.CodeAPI.*;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.*;
import static java.lang.reflect.Modifier.*;


/**
 * Created by jonathan on 02/05/16.
 */
@SuppressWarnings("Duplicates")
public class CodeAPITest_API {

    @Test
    public void codeAPITest() {

        CodeSource mySource = new CodeSource();

        String name = this.getClass().getCanonicalName()+"_Generated";

        CodeClass codeClass = aClass(PUBLIC, name, source(
                method(PUBLIC | STATIC, "printString", VOID, new CodeParameter[]{parameter(STRING, "string")},
                        source(
                                Predefined.invokePrintln(argument(accessLocalVariable(STRING, "string"), STRING))
                        ))
        ));

        mySource.add(codeClass);




        byte[] bytes = generate(mySource);

        Class<?> define = new BCLoader().define(name, bytes);
        try {
            define.newInstance();

            MethodHandles.Lookup lookup = MethodHandles.publicLookup();

            MethodHandle println = lookup.findStatic(define, "printString", java.lang.invoke.MethodType.methodType(Void.TYPE, String.class));

            println.invoke((Object) "Test");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public byte[] generate(CodeSource source) {
        ByteVisitGenerator generator = new ByteVisitGenerator();

        Byte[] gen = generator.gen(source);

        byte[] bytes = PrimitiveArrayConverter.toPrimitive(gen);

        ResultSaver.save(this.getClass(), bytes);

        return bytes;
    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }

}
