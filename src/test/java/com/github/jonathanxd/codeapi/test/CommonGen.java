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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.Annotation;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.CodeParameter;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.LoadedCodeType;
import com.github.jonathanxd.codeapi.util.CodeTypes;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import static com.github.jonathanxd.codeapi.literal.Literals.INT;
import static com.github.jonathanxd.codeapi.literal.Literals.STRING;
import static kotlin.collections.CollectionsKt.*;

public class CommonGen {

    public static final String name = CommonGen.class.getCanonicalName() + "_Generated";

    public static CodeSource gen() {
        CodePart[] values = {
                STRING("A"), STRING("B"),
                STRING("C"), STRING("D"),
                STRING("E")
        };

        CodePart[] values2 = {
                STRING("F"), STRING("G"),
                STRING("H"), STRING("I"),
                STRING("J")
        };

        CodePart[] values3 = {
                INT(1)
        };

        LoadedCodeType<String[][]> stringArrayType = CodeTypes.getCodeType(String[][].class);

        TypeDeclaration typeDeclaration = ClassFactory.aClass(null,
                new Annotation[0],
                EnumSet.of(CodeModifier.PUBLIC),
                name,
                GenericSignature.empty(),
                Types.OBJECT,
                new CodeType[0],
                CodeSource.fromVarArgs(
                        ConstructorFactory.constructor(new Annotation[0], GenericSignature.empty(), EnumSet.of(CodeModifier.PUBLIC),
                                new CodeParameter[0],
                                CodeSource.fromVarArgs(
                                        VariableFactory.variable(stringArrayType,
                                                "array",
                                                Factories.createArray(stringArrayType, listOf(INT(2), INT(5)),
                                                        listOf(
                                                                Factories.createArray(Types.STRING.toArray(1), listOf(INT(5)), Arrays.asList(values)),
                                                                Factories.createArray(Types.STRING.toArray(1), listOf(INT(5)), Arrays.asList(values2))
                                                        )
                                                )),

                                        VariableFactory.variable(Types.STRING.toArray(1),
                                                "array2",
                                                Factories.createArray(Types.STRING.toArray(1), listOf(INT(0)), Collections.emptyList())
                                        ),

                                        VariableFactory.variable(Types.OBJECT.toArray(1),
                                                "array3",
                                                Factories.createArray(Types.OBJECT.toArray(1), listOf(INT(1)), Arrays.asList(values3))
                                        ),

                                        Predefined.invokePrintln(
                                                Factories.accessArrayValue(Types.STRING.toArray(1),
                                                        Factories.accessArrayValue(Types.STRING.toArray(2),
                                                                Factories.accessVariable(
                                                                        Types.STRING.toArray(2),
                                                                        "array"
                                                                ),
                                                                INT(0),
                                                                Types.STRING.toArray(1)
                                                        ),
                                                        INT(0),
                                                        Types.STRING))


                                ))
                ));


        return CodeSource.fromVarArgs(typeDeclaration);
    }

    @Test
    public void test() {
        gen();
    }

}
