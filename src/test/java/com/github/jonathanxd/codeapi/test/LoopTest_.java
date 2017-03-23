/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.builder.ConstructorDeclarationBuilder;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.io.PrintStream;

import static com.github.jonathanxd.codeapi.CodeAPI.accessStaticField;
import static com.github.jonathanxd.codeapi.CodeAPI.source;
import static com.github.jonathanxd.codeapi.factory.VariableFactory.variable;
import static java.util.Collections.singletonList;

public class LoopTest_ {

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MutableCodeSource codeSource = new MutableCodeSource();

        MutableCodeSource clSource = new MutableCodeSource();

        ClassDeclaration codeClass = ClassDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withSuperClass(Types.OBJECT)
                .withQualifiedName("fullName." + LoopTest_.class.getSimpleName())
                .withBody(clSource)
                .build();

        VariableAccess accessX = CodeAPI.accessLocalVariable(Types.INT, "x");
        VariableAccess accessI = CodeAPI.accessLocalVariable(Types.INT, "i");
        VariableAccess accessU = CodeAPI.accessLocalVariable(Types.INT, "u");


        ConstructorDeclaration codeConstructor = ConstructorDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withBody(source(

                        variable(Types.INT, "x", Literals.INT(0)),

                        CodeAPI.whileStatement(
                                CodeAPI.ifExprs(CodeAPI.check(accessX, Operators.LESS_THAN, Literals.INT(17))),
                                source(
                                        Predefined.invokePrintln(accessX),
                                        CodeAPI.operateAndAssign(Types.INT, "x", Operators.ADD, Literals.INT(1))
                                )
                        ),

                        CodeAPI.forStatement(variable(Types.INT, "i", Literals.INT(0)),
                                CodeAPI.ifExprs(CodeAPI.check(accessI, Operators.LESS_THAN, Literals.INT(100))),
                                CodeAPI.operateAndAssign(Types.INT, "i", Operators.ADD, Literals.INT(1)),
                                source(
                                        CodeAPI.ifStatement(CodeAPI.check(accessI, Operators.EQUAL_TO, Literals.INT(5)),
                                                CodeAPI.sourceOfParts(CodeAPI.aContinue())),
                                        Predefined.invokePrintln(accessI)
                                )),


                        variable(Types.INT, "u", Literals.INT(0)),

                        CodeAPI.doWhileStatement(
                                CodeAPI.ifExprs(CodeAPI.check(accessU, Operators.LESS_THAN, Literals.INT(5))),
                                source(
                                        Predefined.invokePrintln(accessU),
                                        CodeAPI.operateAndAssign(Types.INT, "u", Operators.ADD, Literals.INT(1)),
                                        CodeAPI.ifStatement(CodeAPI.ifExprs(CodeAPI.check(accessU, Operators.EQUAL_TO, Literals.INT(2))),
                                                CodeAPI.sourceOfParts(CodeAPI.aBreak()))
                                )),
                        // Chama um metodo Virtual (metodos de instancia) na Classe PrintStream
                        CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                                // Acessa uma variavel estatica 'out' com tipo PrintStream na classe System
                                accessStaticField(System.class, PrintStream.class, "out"),
                                // Especificação do metodo
                                "println",
                                // Informa que o metodo é println, recebe String e retorna um void
                                CodeAPI.typeSpec(Types.VOID, Types.STRING),
                                // Adiciona um argumento String
                                singletonList(Literals.STRING("Hello World")))
                ))
                .build();


        clSource.add(codeConstructor);

        codeSource.add(codeClass);

        return Pair.of(codeClass, codeSource);

    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(String name, byte[] bytes) {
            return super.defineClass(name, bytes, 0, bytes.length);
        }
    }
}
