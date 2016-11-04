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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.lang.reflect.Modifier;

public class SwitchTest_ {


    public static Pair<@Named("Main class") CodeClass, @Named("Source") CodeSource> $() {

        CodeClass codeClass = CodeAPI.aClassBuilder()
                .withQualifiedName("com.SwitchTestClass")
                .withModifiers(Modifier.PUBLIC)
                .withBody(CodeAPI.sourceOfParts(

                        CodeAPI.constructorBuilder()
                                .withModifiers(Modifier.PUBLIC)
                                .withParameters(CodeAPI.parameters(
                                        CodeAPI.parameter(int.class, "number"),
                                        CodeAPI.parameter(int.class, "number2"),
                                        CodeAPI.parameter(TestEnum.class, "testEnum"),
                                        CodeAPI.parameter(String.class, "str"),
                                        CodeAPI.parameter(Object.class, "o")
                                        ))
                                .withBody(
                                        CodeAPI.sourceOfParts(
                                                CodeAPI.switchInt(CodeAPI.accessLocalVariable(int.class, "number"),
                                                        CodeAPI.aCase(Literals.INT(1), CodeAPI.sourceOfParts(print("1"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(Literals.INT(3), CodeAPI.sourceOfParts(print("3"))),
                                                        CodeAPI.aCase(Literals.INT(5), CodeAPI.sourceOfParts(print("5"), CodeAPI.aBreak())),
                                                        CodeAPI.caseDefault(CodeAPI.sourceOfParts(print("default")))),

                                                // Larger int
                                                CodeAPI.switchInt(CodeAPI.accessLocalVariable(int.class, "number2"),
                                                        CodeAPI.aCase(Literals.INT(1), CodeAPI.sourceOfParts(print("1"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(Literals.INT(10), CodeAPI.sourceOfParts(print("10"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(Literals.INT(100), CodeAPI.sourceOfParts(print("100"), CodeAPI.aBreak())),
                                                        CodeAPI.caseDefault(CodeAPI.sourceOfParts(print("default")))),

                                                // Enum
                                                CodeAPI.switchEnum(CodeAPI.accessLocalVariable(TestEnum.class, "testEnum"),
                                                        CodeAPI.aCase(CodeAPI.enumValue("A"), CodeAPI.sourceOfParts(print("A"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(CodeAPI.enumValue("B"), CodeAPI.sourceOfParts(print("B"))),
                                                        CodeAPI.caseDefault(CodeAPI.sourceOfParts(print("B or default")))),

                                                // String
                                                CodeAPI.switchString(CodeAPI.accessLocalVariable(String.class, "str"),
                                                        CodeAPI.aCase(Literals.STRING("AHEAD"), CodeAPI.sourceOfParts(print("AHEAD"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(Literals.STRING("XM"), CodeAPI.sourceOfParts(print("XM"), CodeAPI.aBreak())),
                                                        CodeAPI.aCase(Literals.STRING("AH"), CodeAPI.sourceOfParts(print("AH"), CodeAPI.aBreak())),
                                                        CodeAPI.caseDefault(CodeAPI.sourceOfParts(print("default")))),

                                                // Object
                                                CodeAPI.switchString(CodeAPI.accessLocalVariable(Object.class, "o"),
                                                        CodeAPI.aCase(Literals.INT(0), CodeAPI.sourceOfParts(print("Zero"), CodeAPI.aBreak())),
                                                        CodeAPI.caseDefault(CodeAPI.sourceOfParts(print("default"))))

                                        )
                                )
                                .build()

                ))
                .build();


        return Pair.of(codeClass, CodeAPI.sourceOfParts(codeClass));
    }

    private static CodePart print(String str) {
        return Predefined.invokePrintln(CodeAPI.argument(Literals.STRING(str), PredefinedTypes.STRING));
    }

    public enum TestEnum {
        A,
        B
    }
}
