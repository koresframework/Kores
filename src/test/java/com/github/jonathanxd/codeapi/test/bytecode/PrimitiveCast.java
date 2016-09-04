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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.iutils.arrays.PrimitiveArrayConverter;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

import static com.github.jonathanxd.codeapi.CodeAPI.aClass;
import static com.github.jonathanxd.codeapi.CodeAPI.accessLocalVariable;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.invokeConstructor;
import static com.github.jonathanxd.codeapi.CodeAPI.method;
import static com.github.jonathanxd.codeapi.CodeAPI.parameter;
import static com.github.jonathanxd.codeapi.CodeAPI.returnValue;
import static com.github.jonathanxd.codeapi.CodeAPI.source;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.BYTE;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.INT;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.LONG;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.OBJECT;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING;
import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;


/**
 * Created by jonathan on 02/05/16.
 */
@SuppressWarnings("Duplicates")
public class PrimitiveCast {

    @Test
    public void codeAPITest() {

        CodeSource mySource = new CodeSource();

        String name = this.getClass().getCanonicalName()+"_Generated";

        CodeClass codeClass = aClass(PUBLIC, name, source(
                method(PUBLIC | STATIC, "printString", INT, new CodeParameter[]{parameter(STRING, "string")},
                        source(
                                Predefined.invokePrintln(argument(accessLocalVariable(STRING, "string"), STRING)),

                                new CodeField("objectF", OBJECT, Helper.cast(INT, OBJECT, Literals.INT(9))),

                                new CodeField("iF", OBJECT, Helper.cast(INT, OBJECT, Literals.INT(9))),

                                new CodeField("IntegerBoxed", INT, Helper.cast(OBJECT, INT, Helper.accessLocalVariable("iF", OBJECT))),

                                new CodeField("IntegerBoxed2", INT, Helper.cast(OBJECT, INT, Helper.accessLocalVariable("iF", OBJECT))),

                                new CodeField("int", INT, Literals.INT(9)),

                                new CodeField("IntToInt", INT, Helper.cast(INT, INT, Helper.accessLocalVariable("int", INT))),

                                new CodeField("Long", LONG, Literals.LONG(59855246879798L)),
                                new CodeField("LongToByte", BYTE, Helper.cast(LONG, BYTE, Helper.accessLocalVariable("Long", LONG))),


                                // Cast Integer to Int
                                returnValue(int.class, Helper.cast(PredefinedTypes.INTEGER_TYPE, PredefinedTypes.INT, invokeConstructor(Integer.class, argument(Literals.INT(9), int.class))))
                        ))
        ));

        mySource.add(codeClass);




        byte[] bytes = generate(mySource);

        ResultSaver.save(this.getClass(), bytes);

        Class<?> define = new BCLoader().define(name, bytes);
        try {
            define.newInstance();

            MethodHandles.Lookup lookup = MethodHandles.publicLookup();

            MethodHandle println = lookup.findStatic(define, "printString", java.lang.invoke.MethodType.methodType(Integer.TYPE, String.class));

            int x = (int) println.invoke("Test");

            System.out.println(x);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public byte[] generate(CodeSource source) {
        BytecodeGenerator generator = new BytecodeGenerator();

        Byte[] gen = generator.gen(source).getResult();

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
