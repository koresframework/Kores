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
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.Annotation;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.factory.FieldFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.type.LoadedCodeType;
import com.github.jonathanxd.codeapi.util.ArrayToList;

import java.util.Collections;
import java.util.EnumSet;

import kotlin.collections.CollectionsKt;

import static com.github.jonathanxd.codeapi.literal.Literals.INT;
import static com.github.jonathanxd.codeapi.literal.Literals.STRING;

public class CommonGen {

    public static final String name = CommonGen.class.getCanonicalName() + "_Generated";

    public static CodeSource gen() {
        CodeArgument[] values = {
                new CodeArgument(STRING("A")), new CodeArgument(STRING("B")),
                new CodeArgument(STRING("C")), new CodeArgument(STRING("D")),
                new CodeArgument(STRING("E"))
        };

        CodeArgument[] values2 = {
                new CodeArgument(STRING("F")), new CodeArgument(STRING("G")),
                new CodeArgument(STRING("H")), new CodeArgument(STRING("I")),
                new CodeArgument(STRING("J"))
        };

        CodeArgument[] values3 = {
                new CodeArgument(INT(1))
        };

        LoadedCodeType<String[][]> stringArrayType = CodeAPI.getJavaType(String[][].class);

        TypeDeclaration typeDeclaration = ClassFactory.aClass(null,
                new Annotation[0],
                EnumSet.of(CodeModifier.PUBLIC),
                name,
                GenericSignature.empty(),
                Types.OBJECT,
                new CodeType[0],
                CodeAPI.sourceOfParts(
                        ConstructorFactory.constructor(new Annotation[0], GenericSignature.empty(), EnumSet.of(CodeModifier.PUBLIC),
                                new CodeParameter[0],
                                CodeAPI.sourceOfParts(
                                        VariableFactory.variable(stringArrayType,
                                                "array",
                                                CodeAPI.arrayConstruct(stringArrayType, new CodePart[]{INT(2), INT(5)},
                                                        CollectionsKt.listOf(
                                                                new CodeArgument(CodeAPI.arrayConstruct(Types.STRING.toArray(1), new CodePart[]{INT(5)}, ArrayToList.toList(values))),
                                                                new CodeArgument(CodeAPI.arrayConstruct(Types.STRING.toArray(1), new CodePart[]{INT(5)}, ArrayToList.toList(values2)))
                                                        )
                                                )),

                                        VariableFactory.variable(Types.STRING.toArray(1),
                                                "array2",
                                                CodeAPI.arrayConstruct(Types.STRING.toArray(1), new CodePart[]{INT(0)}, Collections.emptyList())
                                        ),

                                        VariableFactory.variable(Types.OBJECT.toArray(1),
                                                "array3",
                                                CodeAPI.arrayConstruct(Types.OBJECT.toArray(1), new CodePart[]{INT(1)}, ArrayToList.toList(values3))
                                        ),

                                        Predefined.invokePrintln(new CodeArgument(
                                                CodeAPI.getArrayValue(Types.STRING.toArray(1),
                                                        CodeAPI.getArrayValue(Types.STRING.toArray(2),
                                                                CodeAPI.accessLocalVariable(
                                                                        Types.STRING.toArray(2),
                                                                        "array"
                                                                ),
                                                                INT(0)
                                                        ),
                                                        INT(0))))


                                ))
                ));


        return CodeAPI.sourceOfParts(typeDeclaration);
    }
}
