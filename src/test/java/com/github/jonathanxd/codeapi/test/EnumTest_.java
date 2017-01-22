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
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.EnumDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.builder.EnumDeclarationBuilder;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

public class EnumTest_ {


    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {
        EnumDeclaration codeEnum = new EnumDeclarationBuilder()
                .withModifiers(SetsKt.setOf(CodeModifier.PUBLIC))
                .withImplementations(CollectionsKt.listOf(CodeTypes.getCodeType(MyItf.class)))
                .withQualifiedName("com.MyEnum")//CodeAPI.sourceOfParts(Predefined.invokePrintln(CodeAPI.argument(Literals.STRING("A"), String.class)))
                .withEntries(
                        CodeAPI.enumEntry("A", CodeAPI.sourceOfParts(
                                CodeAPI.methodBuilder()
                                        .withModifiers(SetsKt.setOf(CodeModifier.PUBLIC))
                                        .withAnnotations(CodeAPI.overrideAnnotation())
                                        .withReturnType(Types.VOID)
                                        .withName("v")
                                        .withBody(CodeAPI.sourceOfParts(
                                                Predefined.invokePrintln(Literals.STRING("A"))
                                        ))
                                        .build()

                        )),
                        CodeAPI.enumEntry("B",
                                CodeAPI.sourceOfParts(
                                        CodeAPI.methodBuilder()
                                                .withModifiers(CodeModifier.PUBLIC)
                                                .withAnnotations(CodeAPI.overrideAnnotation())
                                                .withReturnType(Types.VOID)
                                                .withName("v")
                                                .withBody(CodeAPI.sourceOfParts(
                                                        Predefined.invokePrintln(Literals.STRING("B"))
                                                ))
                                                .build()

                                ))
                )//
                .build();

        return Pair.of(codeEnum, CodeAPI.sourceOfParts(codeEnum));
    }

    public interface MyItf {
        void v();
    }

}
