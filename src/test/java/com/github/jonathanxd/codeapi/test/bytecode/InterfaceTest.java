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
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.BytecodeGenerator;

import org.junit.Test;

import static com.github.jonathanxd.codeapi.CodeAPI.anInterface;
import static com.github.jonathanxd.codeapi.CodeAPI.method;
import static com.github.jonathanxd.codeapi.CodeAPI.parameter;
import static com.github.jonathanxd.codeapi.CodeAPI.returnValue;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.INT;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.VOID;
import static java.lang.reflect.Modifier.PUBLIC;

/**
 * Created by jonathan on 26/06/16.
 */
public class InterfaceTest {

    @Test
    public void test() {

        CodeInterface codeInterface;



        CodeSource source = sourceOfParts(codeInterface = anInterface(PUBLIC, "test.Impl", new CodeType[0], codeClass0 -> sourceOfParts(

                method(PUBLIC, "parse", VOID, parameter(STRING, "string")),

                method(PUBLIC, "getI", INT, new CodeParameter[]{parameter(INT, "num")}, codeMethod -> sourceOfParts(
                        returnValue(INT, Helper.operateLocalVariable("num", INT, Operators.MULTIPLY, Literals.INT(9)))
                ))

        )));


        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        byte[] gen = bytecodeGenerator.gen(source)[0].getBytecode();

        ResultSaver.save(this.getClass(), gen);


        Class<?> define = new BCLoader().define(codeInterface, gen);

        /*try {
            //My o = (My) define.newInstance();

            //System.out.println(o.getId());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RethrowException(e);
        }*/

    }


    public static class My {
        private final String id;

        public My(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(CodeInterface codeInterface, byte[] bytes) {
            return super.defineClass(codeInterface.getQualifiedName(), bytes, 0, bytes.length);
        }
    }

}
