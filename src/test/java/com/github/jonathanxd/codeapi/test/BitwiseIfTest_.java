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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;

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
                                .body(CodeSource.fromVarArgs(
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_AND,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_AND: true"))),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_AND: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_INCLUSIVE_OR,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_INCLUSIVE_OR: true"))),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_INCLUSIVE_OR: false")))
                                        ),
                                        Factories.ifStatement(
                                                Factories.ifExprs(
                                                        Factories.accessVariable(Types.BOOLEAN, "h"),
                                                        Operators.BITWISE_EXCLUSIVE_OR,
                                                        Factories.accessVariable(Types.BOOLEAN, "x")),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_EXCLUSIVE_OR: true"))),
                                                CodeSource.fromVarArgs(Predefined.invokePrintlnStr(
                                                        Literals.STRING("BITWISE_EXCLUSIVE_OR: false")))
                                        )

                                )).build()
                ).build();
    }

    @Test
    public void test() {
        $();
    }


}
