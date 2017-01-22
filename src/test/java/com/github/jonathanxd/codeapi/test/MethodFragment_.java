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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.FieldFactory;
import com.github.jonathanxd.codeapi.factory.MethodFactory;
import com.github.jonathanxd.codeapi.fragment.SimpleMethodFragmentBuilder;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.util.EnumSet;

import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static kotlin.collections.CollectionsKt.listOf;

public class MethodFragment_ {

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MutableCodeSource source = new MutableCodeSource();

        ClassDeclaration classDeclaration = ClassFactory.aClass(EnumSet.of(CodeModifier.PUBLIC), "com.MethodFragment", sourceOfParts(
                MethodFactory.method(EnumSet.of(CodeModifier.STATIC, CodeModifier.PUBLIC), "test", Types.VOID,
                        source),
                FieldFactory.field(EnumSet.of(CodeModifier.PUBLIC), Generic.type("T"), "test")
        ));

        source.add(
                Predefined.invokePrintln(
                        SimpleMethodFragmentBuilder.builder()
                                .withDeclaringType(classDeclaration)
                                .withScope(Scope.STATIC)
                                .withDescription(new TypeSpec(Types.STRING, listOf(Types.STRING)))
                                .withParameters(CodeAPI.parameter(String.class, "input"))
                                .withArguments(Literals.STRING("BOB"))
                                .withBody(CodeAPI.sourceOfParts(
                                        CodeAPI.returnValue(Types.STRING, CodeAPI.accessLocalVariable(String.class, "input"))
                                ))
                                .build()
                )
        );

        return Pair.of(classDeclaration, sourceOfParts(classDeclaration));
    }

}
