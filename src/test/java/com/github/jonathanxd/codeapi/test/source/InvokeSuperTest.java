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
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.literals.Literals;

import org.junit.Test;

import static com.github.jonathanxd.codeapi.CodeAPI.aClass;
import static com.github.jonathanxd.codeapi.CodeAPI.accessLocalVariable;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.constructor;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING;
import static java.lang.reflect.Modifier.PUBLIC;

/**
 * Created by jonathan on 26/06/16.
 */
public class InvokeSuperTest {

    @Test
    public void test() {

        CodeClass codeClass;

        CodeSource source = sourceOfParts(codeClass = aClass(PUBLIC, "test.Impl", My.class, new Class[0], codeClass0 -> sourceOfParts(

                constructor(PUBLIC, codeConstructor -> sourceOfParts(
                        new CodeField("blc", STRING, Literals.STRING("099")),

                        Helper.invokeSuperInit(Helper.getJavaType(My.class), argument(accessLocalVariable(STRING, "blc"), STRING))

                ))

        )));

        PlainSourceGenerator generator = new PlainSourceGenerator();

        System.out.println(generator.gen(source));
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
