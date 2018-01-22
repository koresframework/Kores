/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.TypeSpec;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;

import org.junit.Test;

import static com.github.jonathanxd.codeapi.literal.Literals.STRING;
import static kotlin.collections.CollectionsKt.listOf;

public class InstanceOf_ {

    public static TypeDeclaration $() {

        VariableAccess paramAccess = Factories.accessVariable(Object.class, "param");

        return ClassDeclaration.Builder.builder()
                .name("test.InstanceOf")
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                                .name("test")
                                .parameters(Factories.parameter(Object.class, "param"))
                                .body(CodeSource.fromVarArgs(
                                        Factories.ifStatement(Factories.ifExprs(Factories.checkTrue(Factories.isInstanceOf(paramAccess, String.class))),
                                                CodeSource.fromVarArgs(
                                                        Predefined.invokePrintln(STRING("Object is String!"))
                                                ),
                                                CodeSource.fromVarArgs(
                                                        Predefined.invokePrintln(STRING("Object is not String!"))
                                                )),
                                        VariableFactory.variable(Types.BOOLEAN, "b", Factories.isInstanceOf(paramAccess, String.class)),
                                        VariableFactory.variable(Types.BOOLEAN, "b2", Factories.checkFalse(Factories.accessVariable(Types.BOOLEAN, "b"))),
                                        VariableFactory.variable(Types.INTEGER_WRAPPER, "ab", InvocationFactory.invokeConstructor(Types.INTEGER_WRAPPER, new TypeSpec(Types.VOID, listOf(Types.INT)), listOf(Literals.INT(9)))),
                                        VariableFactory.variable(Types.BOOLEAN, "b9", Factories.ifExpr(Factories.accessVariable(Types.INTEGER_WRAPPER, "ab"), Operators.EQUAL_TO, Literals.INT(9)))
                                ))
                                .build()
                )
                .build();
    }

    @Test
    public void test() {
        $();
    }

}
