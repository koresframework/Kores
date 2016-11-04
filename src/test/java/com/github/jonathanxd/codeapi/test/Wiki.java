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
import com.github.jonathanxd.codeapi.classloader.CodeClassLoader;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.BytecodeGenerator;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;

import org.junit.Test;

import java.io.PrintStream;

import static com.github.jonathanxd.codeapi.CodeAPI.aClass;
import static com.github.jonathanxd.codeapi.CodeAPI.accessLocalVariable;
import static com.github.jonathanxd.codeapi.CodeAPI.accessStaticField;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.field;
import static com.github.jonathanxd.codeapi.CodeAPI.invokeVirtual;
import static com.github.jonathanxd.codeapi.CodeAPI.method;
import static com.github.jonathanxd.codeapi.CodeAPI.parameter;
import static com.github.jonathanxd.codeapi.CodeAPI.parameters;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.CodeAPI.typeSpec;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.STRING;
import static com.github.jonathanxd.codeapi.helper.PredefinedTypes.VOID;
import static com.github.jonathanxd.codeapi.literals.Literals.STRING;
import static java.lang.reflect.Modifier.FINAL;
import static java.lang.reflect.Modifier.PRIVATE;
import static java.lang.reflect.Modifier.PUBLIC;

public class Wiki {


    @Test
    public void wiki() throws Throwable {
        CodeSource source = sourceOfParts(
                field(PRIVATE | FINAL, STRING, "myField", STRING("Hello")),
                method(PUBLIC, "test", VOID, parameters(parameter(String.class, "name")), method ->
                        sourceOfParts(
                                field(String.class, "variable"),
                                Predefined.invokePrintlnStr(STRING("Hello world")),
                                Predefined.invokePrintlnStr(accessLocalVariable(String.class, "name")),
                                accessStaticField(System.class, PrintStream.class, "out"),
                                invokeVirtual(
                                        PrintStream.class,
                                        accessStaticField(System.class, PrintStream.class, "out"),
                                        "println",
                                        typeSpec(VOID, STRING),
                                        argument(STRING("Hello")))
                        )
                )
        );

        TypeDeclaration decl = aClass(PUBLIC, "com.MyClass", aClass -> source);

        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        BytecodeClass[] gen = bytecodeGenerator.gen(decl);

        CodeClassLoader codeClassLoader = new CodeClassLoader();

        Class<?> define = codeClassLoader.define(gen);

        define.getDeclaredMethod("test", String.class).invoke(define.newInstance(), "codeapi");


    }
}
