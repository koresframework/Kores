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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.builder.CodeConstructorBuilder;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;

import org.junit.Test;

import java.io.PrintStream;

import static com.github.jonathanxd.codeapi.helper.Helper.accessStaticVariable;
import static com.github.jonathanxd.codeapi.helper.Helper.invoke;
import static com.github.jonathanxd.codeapi.helper.Helper.sourceOf;
import static java.util.Collections.singletonList;

/**
 * Created by jonathan on 03/06/16.
 */
public class TestLoopBytecode {
    @Test
    public void testBytecode() {

        MutableCodeSource codeSource = new MutableCodeSource();

        MutableCodeSource clSource = new MutableCodeSource();

        CodeClass codeClass = new CodeClass("fullName." + this.getClass().getSimpleName(),
                singletonList(CodeModifier.PUBLIC),
                null, null, clSource);

        VariableAccess accessX = Helper.accessLocalVariable("x", PredefinedTypes.INT);
        VariableAccess accessI = Helper.accessLocalVariable("i", PredefinedTypes.INT);
        VariableAccess accessU = Helper.accessLocalVariable("u", PredefinedTypes.INT);


        CodeConstructor codeConstructor = CodeConstructorBuilder.builder()
                .withDeclaringClass(codeClass)
                .withModifiers(singletonList(CodeModifier.PUBLIC))
                .withBody(sourceOf(

                        new CodeField("x", PredefinedTypes.INT, Literals.INT(0)),

                        Helper.createWhile(
                                Helper.createIfVal().add1(Helper.check(accessX, Operators.LESS_THAN, Literals.INT(17))).make(),
                                Helper.sourceOf(
                                        Predefined.invokePrintln(new CodeArgument(accessX, int.class)),
                                        Helper.operateLocalVariable("x", PredefinedTypes.INT, Operators.INCREMENT)
                                )
                        ),

                        Helper.createFor(new CodeField("i", PredefinedTypes.INT, Literals.INT(0)),
                                Helper.createIfVal().add1(Helper.check(accessI, Operators.LESS_THAN, Literals.INT(100))).make(),
                                Helper.operateLocalVariable("i", PredefinedTypes.INT, Operators.INCREMENT),
                                Helper.sourceOf(
                                        CodeAPI.ifBlock(CodeAPI.check(accessI, Operators.EQUAL_TO, Literals.INT(5)),
                                                CodeAPI.sourceOfParts(CodeAPI.aContinue())),
                                        Predefined.invokePrintln(new CodeArgument(accessI, int.class))
                                )),


                        new CodeField("u", PredefinedTypes.INT, Literals.INT(0)),

                        Helper.createDoWhile(Helper.sourceOf(
                                Predefined.invokePrintln(new CodeArgument(accessU, int.class)),
                                Helper.operateLocalVariable("u", PredefinedTypes.INT, Operators.INCREMENT),
                                CodeAPI.ifBlock(CodeAPI.ifExprs(CodeAPI.check(accessU, Operators.EQUAL_TO, Literals.INT(2))),
                                        CodeAPI.sourceOfParts(CodeAPI.aBreak()))

                        ), Helper.createIfVal().add1(Helper.check(accessU, Operators.LESS_THAN, Literals.INT(5))).make()),
                        // Chama um metodo Virtual (metodos de instancia) na Classe PrintStream
                        invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                                // Acessa uma variavel estatica 'out' com tipo PrintStream na classe System
                                accessStaticVariable(System.class, "out", PrintStream.class),
                                // Especificação do metodo
                                // Informa que o metodo é println, e retorna um void
                                new MethodSpecImpl("println", Void.TYPE,
                                        // Adiciona um argumento String
                                        // Informa qual o tipo de argumento esperado no metodo, nao necessariamente o que foi passado
                                        singletonList(new CodeArgument(Literals.STRING("Hello World"), String.class))))
                ))
                .build();


        clSource.add(codeConstructor);

        codeSource.add(codeClass);

        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        byte[] gen = bytecodeGenerator.gen(codeSource)[0].getBytecode();

        ResultSaver.save(this.getClass(), gen);

        BCLoader bcLoader = new BCLoader();

        Class<?> define = bcLoader.define("fullName." + this.getClass().getSimpleName(), gen);

        try {
            define.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }
}
