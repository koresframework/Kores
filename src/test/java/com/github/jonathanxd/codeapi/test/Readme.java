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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;

import org.junit.Test;

import java.io.PrintStream;

import static com.github.jonathanxd.codeapi.CodeAPI.aClass;
import static com.github.jonathanxd.codeapi.CodeAPI.accessStaticField;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.constructor;
import static com.github.jonathanxd.codeapi.CodeAPI.emptySource;
import static com.github.jonathanxd.codeapi.CodeAPI.invokeVirtual;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.*;
import static java.lang.reflect.Modifier.PUBLIC;

/**
 * Created by jonathan on 18/06/16.
 */

public class Readme {

    @Test
    public void readme() {
        CodeSource source = emptySource();

        CodeClass myClass = aClass(PUBLIC, "mypackage.MyClass", codeClass -> sourceOfParts(
                constructor(PUBLIC, codeClass, codeConstructor -> sourceOfParts(
                        invokeVirtual(PrintStream.class,
                                accessStaticField(System.class, PrintStream.class, "out"),
                                "println",
                                new TypeSpec(VOID, STRING),
                                argument(Literals.STRING("Hello, world!")))
                ))
        ));

        source.add(myClass);


        PlainSourceGenerator plainSourceGenerator = new PlainSourceGenerator();
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        String plainSource = plainSourceGenerator.gen(source);

        System.out.println(plainSource);

        Byte[] bytecode = bytecodeGenerator.gen(source).getResult();
        byte[] bytes = PrimitiveArrayConverter.toPrimitive(bytecode);
        
        BCLoader bytecodeLoader = new BCLoader();

        Class<?> cl = bytecodeLoader.define(myClass, bytes);

        try {
            cl.newInstance();
        } catch (Throwable t) { throw new RuntimeException(t); }

    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(CodeInterface codeInterface, byte[] bytes) {
            return super.defineClass(codeInterface.getQualifiedName(), bytes, 0, bytes.length);
        }
    }

}
