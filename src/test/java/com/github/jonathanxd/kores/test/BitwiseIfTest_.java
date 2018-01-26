/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
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
package com.github.jonathanxd.kores.test;

import com.github.jonathanxd.kores.Instructions;
import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.kores.operator.Operators;

import org.junit.Test;

public class BitwiseIfTest_ {
    //
    public static TypeDeclaration $() {

        return ClassDeclaration.Builder.builder()
                .specifiedName("test.BitwiseIf")
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .parameters(Factories.parameter(Types.BOOLEAN, "h"),
                                        Factories.parameter(Types.BOOLEAN, "x")
                                )
                                .body(Instructions.fromVarArgs(
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_AND,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_AND: true"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_AND: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_INCLUSIVE_OR,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_INCLUSIVE_OR: true"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_INCLUSIVE_OR: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_EXCLUSIVE_OR,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_EXCLUSIVE_OR: true"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_EXCLUSIVE_OR: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.checkFalse(Factories.accessVariable(Types.BOOLEAN, "h")),
                                                        Operators.BITWISE_EXCLUSIVE_OR,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("NEGATE_FIRST BITWISE_EXCLUSIVE_OR: true"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("NEGATE_FIRST BITWISE_EXCLUSIVE_OR: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.checkFalse(Factories.accessVariable(Types.BOOLEAN, "h")),
                                                        Operators.BITWISE_EXCLUSIVE_OR,
                                                        Factories.checkFalse(Factories.accessVariable(Types.BOOLEAN, "x"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("NEGATE_ALL BITWISE_EXCLUSIVE_OR: true"))),
                                                Instructions.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("NEGATE_ALL BITWISE_EXCLUSIVE_OR: false")))
                                        )

                                )).build()
                )
                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC)
                                .returnType(Void.TYPE)
                                .name("test")
                                .parameters(Factories.parameter(Integer.TYPE, "a"), Factories.parameter(Integer.TYPE, "b"))
                                .body(Instructions.fromPart(
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.check(
                                                                Factories.accessVariable(Integer.TYPE, "a"),
                                                                Operators.LESS_THAN,
                                                                Literals.INT(100)
                                                        ),
                                                        Operators.BITWISE_AND,
                                                        Factories.check(
                                                                Factories.accessVariable(Integer.TYPE, "b"),
                                                                Operators.GREATER_THAN,
                                                                Literals.INT(100)
                                                        )
                                                ),
                                                Instructions.fromPart(Predefined.invokePrintlnStr(
                                                        Literals.STRING("a < 100 & b > 100"))),
                                                Instructions.fromPart(Predefined.invokePrintlnStr(
                                                        Literals.STRING("false")))
                                        )
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
