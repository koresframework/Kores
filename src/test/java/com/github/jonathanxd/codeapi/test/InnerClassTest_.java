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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.util.Arrays;

import static com.github.jonathanxd.codeapi.CodeAPI.aClass;
import static com.github.jonathanxd.codeapi.CodeAPI.accessField;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.constructor;
import static com.github.jonathanxd.codeapi.CodeAPI.method;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static java.lang.reflect.Modifier.PRIVATE;
import static java.lang.reflect.Modifier.PUBLIC;

/**
 * Created by jonathan on 03/09/16.
 */
public class InnerClassTest_ {
    //

    public static Pair<@Named("Main class") CodeClass, @Named("Source") CodeSource> $() {

        CodeClass codeClass = aClass(PUBLIC, "test.InnerClass");

        TypeDeclaration inner = aClass(PUBLIC, "Inner", CodeAPI.source(
                CodeAPI.field(PUBLIC, codeClass, "a",
                        CodeAPI.invokeConstructor(codeClass, CodeAPI.constructorTypeSpec(String.class), CodeAPI.argument(Literals.STRING("Hello")))),
                method(PRIVATE, "call", PredefinedTypes.STRING, CodeAPI.source(
                        Predefined.invokePrintln(argument(
                                accessField(codeClass, Helper.accessOuter(codeClass), PredefinedTypes.STRING, "field"),
                                PredefinedTypes.STRING
                        )),
                        CodeAPI.invokeVirtual(codeClass, Helper.accessOuter(codeClass), "mm", CodeAPI.typeSpec(PredefinedTypes.VOID)),
                        CodeAPI.returnValue(String.class, Literals.STRING("A"))
                ))
        )).setOuterClass(codeClass);

        codeClass = codeClass.setBody(CodeAPI.sourceOfParts(
                new CodeField("field",
                        Helper.getJavaType(String.class),
                        Literals.STRING("XSD"),
                        Arrays.asList(CodeModifier.PRIVATE)),

                CodeAPI.constructor(PUBLIC, constructor -> CodeAPI.sourceOfParts(
                        CodeAPI.invokeVirtual(inner,
                                CodeAPI.invokeConstructor(inner),
                                "call", CodeAPI.typeSpec(String.class))
                )),
                constructor(PRIVATE, CodeAPI.parameters(CodeAPI.parameter(String.class, "str")), CodeAPI.source(
                        Predefined.invokePrintln(CodeAPI.argument(CodeAPI.accessLocalVariable(String.class, "str"), String.class))
                )),
                CodeAPI.method(PUBLIC, "mm", PredefinedTypes.VOID, codeMethod -> CodeAPI.sourceOfParts(
                        Predefined.invokePrintln(CodeAPI.argument(Literals.STRING("A"), String.class))
                )),
                inner
        ));


        return Pair.of(codeClass, sourceOfParts(codeClass));
    }
}
