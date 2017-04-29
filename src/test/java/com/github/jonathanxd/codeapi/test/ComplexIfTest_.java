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
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

import java.util.Collections;
import java.util.EnumSet;

public class ComplexIfTest_ {
    //
    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MutableCodeSource source = new MutableCodeSource();

        TypeDeclaration codeClass = ClassFactory.aClass(EnumSet.of(CodeModifier.PUBLIC), "test.ComplexIf", CodeSource.fromVarArgs(
                ConstructorFactory.constructor(EnumSet.of(CodeModifier.PUBLIC),
                        new CodeParameter[]{
                                new CodeParameter(Collections.emptyList(), Collections.emptySet(), Types.BOOLEAN, "h"),
                                new CodeParameter(Collections.emptyList(), Collections.emptySet(), Types.BOOLEAN, "x"),
                                new CodeParameter(Collections.emptyList(), Collections.emptySet(), Types.BOOLEAN, "y"),
                                new CodeParameter(Collections.emptyList(), Collections.emptySet(), Types.BOOLEAN, "z")
                        },
                        CodeSource.fromVarArgs(
                                VariableFactory.variable(Types.BOOLEAN, "a", Factories.check(Literals.INT(9), Operators.LESS_THAN, Literals.INT(5))),
                                VariableFactory.variable(Types.STRING, "b",
                                        Factories.ifStatement(
                                                Factories.check(Literals.INT(9), Operators.LESS_THAN, Literals.INT(5)),
                                                CodeSource.fromVarArgs(Literals.STRING("9 < 5")),
                                                CodeSource.fromVarArgs(Literals.STRING("9 >= 5"))
                                        )
                                ),
                                VariableFactory.variable(Types.STRING, "b",
                                        Factories.ifStatement(
                                                Factories.check(Literals.INT(9), Operators.LESS_THAN, Literals.INT(5)),
                                                CodeSource.fromVarArgs(Literals.STRING("9 < 5")),
                                                CodeSource.fromVarArgs(Literals.STRING("9 >= 5"))
                                        )
                                ),

                                Factories.ifStatement(
                                        Factories.ifExprs(
                                                Factories.accessVariable(Types.BOOLEAN, "h"),
                                                Operators.AND,
                                                Factories.accessVariable(Types.BOOLEAN, "x"),
                                                Operators.AND,
                                                Factories.ifExprs(Factories.accessVariable(Types.BOOLEAN, "y"), Operators.OR, Factories.accessVariable(Types.BOOLEAN, "z"))),
                                        CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("true"))),
                                        CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("false")))
                                )

                        ))
        ));

        return Pair.of(codeClass, CodeSource.fromVarArgs(codeClass));
    }

    @Test
    public void test() {
        $();
    }


}
