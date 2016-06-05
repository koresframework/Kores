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
import com.github.jonathanxd.codeapi.gen.common.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.Group;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.util.MultiVal;

import org.junit.Test;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by jonathan on 12/05/16.
 */
public class SimpleTest2 {

    // antes da refatoração: ~890ms
    @Test
    public void simpleTest() {
        // Crio um novo 'código-fonte' (não um arquivo, mas sim, uma coleção de instruções, que formam um código fonte)
        CodeSource source = new CodeSource();

        // Declaro uma package
        CodePart packageDeclaration = Helper.declarePackage("me.jonathanscripter.codeapi.test");

        // Adiciona ao codigo fonte
        source.add(packageDeclaration);

        // Cria o 'codigo-fonte' da classe
        CodeSource classSource = new CodeSource();

        // Crio uma classe com nome de CodeAPITest
        CodeClass codeClass = new CodeClass("CodeAPITest",
                // Adiciona o modifier publico
                Arrays.asList(CodeModifier.PUBLIC),
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
                        Helper.setVariable(Helper.accessThis(), "myField", stringType, Helper.accessLocalVariable("myField", stringType)),
                        Helper.expressions(
                                Helper.ifExpression(MultiVal.create(Group.class, Helper.group(

                                        Helper.expressions(Helper.accessLocalVariable("myField", stringType), Operators.NOT_EQUAL_TO, Literals.NULL)
                                )), Helper.sourceOf(
                                        Helper.invoke(InvokeType.INVOKE_STATIC, null,
                                                Helper.accessVariable(Helper.localizedAtType(Helper.getJavaType(System.class)), "out", Helper.getJavaType(OutputStream.class)),
                                                new MethodSpec("println", Arrays.asList(new CodeArgument(Helper.accessLocalVariable("myField", stringType))))
                                        )
                                )),
                                // Helper.elseExpression(Helper.ifExpression)... = else if (expr) { body }
                                Helper.elseExpression(
                                        Helper.sourceOf(
                                                Helper.invoke(InvokeType.INVOKE_STATIC, null, Helper.accessVariable(Helper.localizedAtType(Helper.getJavaType(System.class)), "out", Helper.getJavaType(OutputStream.class)),
                                                        new MethodSpec("println", Arrays.asList(new CodeArgument(
                                                                Helper.cast(Helper.getJavaType(String.class), Literals.QUOTED_STRING("NULL VALUE"))
                                                        )))
                                                )
                                        )
                                )
                        )
                ));

        // Adiciona o construtor ao codigo fonte da classe
        classSource.add(codeConstructor);


        // Algumas classes são Singleton, então você não precisa instanciar.
        PlainSourceGenerator plainSourceGenerator = PlainSourceGenerator.INSTANCE;

        // Gera o codigo fonte em modo plano (plain, texto plano sem formatação).
        String gen = plainSourceGenerator.gen(source);

        // irá exibir: package me.jonathanscripter.codeapi.test ; public class CodeAPITest { public final java.lang.String myField ; public CodeAPITest ( java.lang.String myField ) { this . myField = myField ; } }
        System.out.println(gen);
    }

}
