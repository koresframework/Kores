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
import com.github.jonathanxd.codeapi.PredefinedTypes;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.MethodFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import kotlin.collections.CollectionsKt;

import static com.github.jonathanxd.codeapi.CodeAPI.accessLocalVariable;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.check;
import static com.github.jonathanxd.codeapi.CodeAPI.checkFalse;
import static com.github.jonathanxd.codeapi.CodeAPI.checkTrue;
import static com.github.jonathanxd.codeapi.CodeAPI.ifExprs;
import static com.github.jonathanxd.codeapi.CodeAPI.ifStatement;
import static com.github.jonathanxd.codeapi.CodeAPI.invokeConstructor;
import static com.github.jonathanxd.codeapi.CodeAPI.isInstanceOf;
import static com.github.jonathanxd.codeapi.CodeAPI.parameter;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.factory.FieldFactory.field;
import static com.github.jonathanxd.codeapi.literal.Literals.STRING;
import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;
import static kotlin.collections.CollectionsKt.*;

public class InstanceOf_ {

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        VariableAccess paramAccess = accessLocalVariable(Object.class, "param");

        ClassDeclaration codeClass = ClassFactory.aClass(PUBLIC, "test.InstanceOf", sourceOfParts(
                MethodFactory.method(STATIC | PUBLIC, "test", PredefinedTypes.VOID, new CodeParameter[]{parameter(Object.class, "param")},
                        sourceOfParts(
                                ifStatement(ifExprs(checkTrue(isInstanceOf(paramAccess, String.class))),
                                        sourceOfParts(
                                                Predefined.invokePrintln(argument(STRING("Object is String!")))
                                        ),
                                        sourceOfParts(
                                                Predefined.invokePrintln(argument(STRING("Object is not String!")))
                                        )),
                                field(PredefinedTypes.BOOLEAN, "b", isInstanceOf(paramAccess, String.class)),
                                field(PredefinedTypes.BOOLEAN, "b2", checkFalse(accessLocalVariable(PredefinedTypes.BOOLEAN, "b"))),
                                field(PredefinedTypes.INTEGER_TYPE, "ab", invokeConstructor(PredefinedTypes.INTEGER_TYPE, new TypeSpec(PredefinedTypes.VOID, listOf(PredefinedTypes.INTEGER_TYPE)), listOf(argument(Literals.INT(9))))),
                                field(PredefinedTypes.BOOLEAN, "b9", check(accessLocalVariable(PredefinedTypes.INTEGER_TYPE, "ab"), Operators.EQUAL_TO, Literals.INT(9)))
                        ))
        ));

        return Pair.of(codeClass, sourceOfParts(codeClass));
    }

}
