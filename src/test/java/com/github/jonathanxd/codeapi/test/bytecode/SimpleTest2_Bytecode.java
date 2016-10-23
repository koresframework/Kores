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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.visitgenerator.BytecodeGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.test.ResultSaver;
import com.github.jonathanxd.codeapi.types.CodeType;

import org.junit.Test;

import java.io.PrintStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by jonathan on 12/05/16.
 */
public class SimpleTest2_Bytecode {

    // antes da refatoração: ~890ms
    @Test
    public void simpleTest() throws NoSuchFieldException {
        // Crio um novo 'código-fonte' (não um arquivo, mas sim, uma coleção de instruções, que formam um código fonte)
        CodeSource source = new CodeSource();

        // Cria o 'codigo-fonte' da classe
        CodeSource classSource = new CodeSource();

        // Crio uma classe com nome de SimpleTest2_bytecode
        CodeClass codeClass = new CodeClass("me.jonathanscripter.codeapi.test.SimpleTest2_bytecode",
                // Adiciona o modifier publico
                Collections.singletonList(CodeModifier.PUBLIC),
                null,
                Collections.emptyList(),
                // Define qual é o código fonte da classe.
                classSource);

        // Adiciono a classe ao codigo fonte
        source.add(codeClass);


        // Obtem um CodeType a partir de uma classe Java. Obs: Todas classes do CodeAPI são CodeType
        CodeType stringType = Helper.getJavaType(String.class);

        // Cria uma field (campo)
        CodeField codeField = new CodeField("myField",
                // Define o tipo da field como String
                stringType,
                // Adiciona os modificadores public final
                Arrays.asList(CodeModifier.PUBLIC, CodeModifier.FINAL));


        // Adiciona a field ao codigo fonte da classe
        classSource.add(codeField);


        // Cria um construtor para a classe 'codeClass' que criamos. CodeConstructor recebe CodeType
        // como parametro
        CodeConstructor codeConstructor = new CodeConstructor(codeClass,

                // Adiciona o modificador publico
                Collections.singletonList(CodeModifier.PUBLIC),

                // Adiciona um parametro 'myField' do tipo String ao construtor
                Collections.singletonList(new CodeParameter("myField", stringType)),

                // Define o corpo (codigo fonte) do metodo
                // Classe Helper é usada pelo menos em 70% do código, ela ajuda em tarefas comuns.
                Helper.sourceOf(
                        Helper.setVariable(null, Helper.accessThis(), "myField", stringType, Helper.accessLocalVariable("myField", stringType)),
                        Helper.ifExpression(Helper.createIfVal().add1(Helper.check(
                                Helper.accessLocalVariable("myField", stringType), Operators.NOT_EQUAL_TO, Literals.NULL
                        )).make(), Helper.sourceOf(
                                Helper.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                                        Helper.accessStaticVariable(Helper.localizedAtType(Helper.getJavaType(System.class)), "out", Helper.getJavaType(PrintStream.class)),
                                        new MethodSpecImpl("println", PredefinedTypes.VOID, Collections.singletonList(new CodeArgument(Helper.accessLocalVariable("myField", stringType), stringType)))
                                )
                        ), Helper.elseExpression(Helper.sourceOf(
                                Helper.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class, Helper.accessStaticVariable(Helper.localizedAtType(Helper.getJavaType(System.class)), "out", Helper.getJavaType(PrintStream.class)),
                                        new MethodSpecImpl("println", PredefinedTypes.VOID, Collections.singletonList(new CodeArgument(
                                                Helper.cast(stringType, stringType, Literals.QUOTED_STRING("NULL VALUE")), stringType
                                        )))
                                ))
                        ))
                ));

        // Adiciona o construtor ao codigo fonte da classe
        classSource.add(codeConstructor);


        // Algumas classes são Singleton, então você não precisa instanciar.
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        byte[] bytes = bytecodeGenerator.gen(source)[0].getBytecode();

        ResultSaver.save(this.getClass(), bytes);

        BCLoader bcLoader = new BCLoader();

        Class<?> define = bcLoader.define("me.jonathanscripter.codeapi.test.SimpleTest2_bytecode", bytes);

        try {
            Object o = define.getConstructor(String.class).newInstance((String) null);

            MethodHandle getMyField = MethodHandles.publicLookup().findGetter(define, "myField", String.class).bindTo(o);

            System.out.println("Field value = "+(String) getMyField.invoke());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }

}
