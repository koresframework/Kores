/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test;

import com.koresframework.kores.Instructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.base.*;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import org.junit.Test;

import static com.koresframework.kores.literal.Literals.STRING;
import static kotlin.collections.CollectionsKt.listOf;

public class InstanceOf_ {

    public static TypeDeclaration $() {

        VariableAccess paramAccess = Factories.accessVariable(Object.class, "param");

        return ClassDeclaration.Builder.builder()
                .name("test.InstanceOf")
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                                .name("test")
                                .parameters(Factories.parameter(Object.class, "param"))
                                .body(Instructions.fromVarArgs(
                                        Factories.ifStatement(Factories.ifExprs(Factories.checkTrue(Factories.isInstanceOf(paramAccess, String.class))),
                                                Instructions.fromVarArgs(
                                                        Predefined.invokePrintln(STRING("Object is String!"))
                                                ),
                                                Instructions.fromVarArgs(
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
