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

import com.github.jonathanxd.codeapi.CodeInstruction;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.util.CodeTypes;

import org.junit.Test;

import java.util.Arrays;

public class SwitchTest_ {


    public static TypeDeclaration $() {

        ClassDeclaration classDeclaration = ClassDeclaration.Builder.builder()
                .qualifiedName("com.SwitchTestClass")
                .modifiers(CodeModifier.PUBLIC)
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC)
                                .parameters(
                                        Factories.parameter(int.class, "number"),
                                        Factories.parameter(int.class, "number2"),
                                        Factories.parameter(TestEnum.class, "testEnum"),
                                        Factories.parameter(String.class, "str"),
                                        Factories.parameter(Object.class, "o")
                                )
                                .body(
                                        CodeSource.fromVarArgs(
                                                Factories.switchInt(Factories.accessVariable(int.class, "number"), Arrays.asList(
                                                        Factories.caseStatement(Literals.INT(1), CodeSource.fromVarArgs(print("1"), Factories.breakFlow())),
                                                        Factories.caseStatement(Literals.INT(3), CodeSource.fromVarArgs(print("3"))),
                                                        Factories.caseStatement(Literals.INT(5), CodeSource.fromVarArgs(print("5"), Factories.breakFlow())),
                                                        Factories.defaultCase(CodeSource.fromVarArgs(print("default"))))),

                                                // Larger int
                                                Factories.switchInt(Factories.accessVariable(int.class, "number2"), Arrays.asList(
                                                        Factories.caseStatement(Literals.INT(1), CodeSource.fromVarArgs(print("1"), Factories.breakFlow())),
                                                        Factories.caseStatement(Literals.INT(10), CodeSource.fromVarArgs(print("10"), Factories.breakFlow())),
                                                        Factories.caseStatement(Literals.INT(100), CodeSource.fromVarArgs(print("100"), Factories.breakFlow())),
                                                        Factories.defaultCase(CodeSource.fromVarArgs(print("default"))))),

                                                // Enum
                                                Factories.switchEnum(Factories.accessVariable(TestEnum.class, "testEnum"), Arrays.asList(
                                                        Factories.caseStatement(Factories.enumValue(CodeTypes.getCodeType(TestEnum.class), "A"), CodeSource.fromVarArgs(print("A"), Factories.breakFlow())),
                                                        Factories.caseStatement(Factories.enumValue(CodeTypes.getCodeType(TestEnum.class), "B"), CodeSource.fromVarArgs(print("B"))),
                                                        Factories.defaultCase(CodeSource.fromVarArgs(print("B or default"))))),

                                                // String
                                                Factories.switchString(Factories.accessVariable(String.class, "str"), Arrays.asList(
                                                        Factories.caseStatement(Literals.STRING("AHEAD"), CodeSource.fromVarArgs(print("AHEAD"), Factories.breakFlow())),
                                                        Factories.caseStatement(Literals.STRING("XM"), CodeSource.fromVarArgs(print("XM"), Factories.breakFlow())),
                                                        Factories.caseStatement(Literals.STRING("AH"), CodeSource.fromVarArgs(print("AH"), Factories.breakFlow())),
                                                        Factories.defaultCase(CodeSource.fromVarArgs(print("default"))))),

                                                // Object
                                                Factories.switchString(Factories.accessVariable(Object.class, "o"), Arrays.asList(
                                                        Factories.caseStatement(Literals.INT(0), CodeSource.fromVarArgs(print("Zero"), Factories.breakFlow())),
                                                        Factories.defaultCase(CodeSource.fromVarArgs(print("default")))))

                                        )
                                )
                                .build()

                )
                .build();


        return classDeclaration;
    }

    private static CodeInstruction print(String str) {
        return Predefined.invokePrintln(Literals.STRING(str));
    }

    @Test
    public void test() {
        $();
    }

    public enum TestEnum {
        A,
        B
    }
}
