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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.Annotation;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.CodeParameter;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.FieldFactory;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.MethodFactory;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.type.CodeType;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import org.junit.Test;

import java.util.Collections;
import java.util.EnumSet;

import kotlin.collections.CollectionsKt;

public class InnerClassTest_ {
    //
    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MutableCodeSource source = MutableCodeSource.create();

        TypeDeclaration codeClass = ClassFactory.aClass(EnumSet.of(CodeModifier.PUBLIC), "test.InnerClass", source);

        TypeDeclaration inner = ClassFactory.aClass(codeClass, new Annotation[0],
                EnumSet.of(CodeModifier.PUBLIC),
                "Inner",
                GenericSignature.empty(),
                Types.OBJECT,
                new CodeType[0],
                CodeSource.fromVarArgs(
                        FieldFactory.field(EnumSet.of(CodeModifier.PUBLIC), codeClass, "a",
                                InvocationFactory.invokeConstructor(codeClass, Factories.constructorTypeSpec(String.class), CollectionsKt.listOf(Literals.STRING("Hello")))),
                        MethodFactory.method(EnumSet.of(CodeModifier.PRIVATE), "call", Types.STRING, CodeSource.fromVarArgs(
                                Predefined.invokePrintln(
                                        Factories.accessField(codeClass, Factories.accessOuter(codeClass), Types.STRING, "field")
                                ),
                                InvocationFactory.invokeVirtual(codeClass, Factories.accessOuter(codeClass), "mm", Factories.typeSpec(Types.VOID), Collections.emptyList()),
                                Factories.returnValue(String.class, Literals.STRING("A"))
                        ))
                ));

        source.addAll(CodeSource.fromVarArgs(
                FieldFactory.field(EnumSet.of(CodeModifier.PRIVATE),
                        CodeTypes.getCodeType(String.class),
                        "field",
                        Literals.STRING("XSD")),

                ConstructorFactory.constructor(EnumSet.of(CodeModifier.PUBLIC), CodeSource.fromVarArgs(
                        InvocationFactory.invokeVirtual(
                                inner,
                                InvocationFactory.invokeConstructor(inner),
                                "call",
                                Factories.typeSpec(String.class),
                                Collections.emptyList()
                        )
                )),
                ConstructorFactory.constructor(EnumSet.of(CodeModifier.PRIVATE), new CodeParameter[]{Factories.parameter(String.class, "str")},
                        CodeSource.fromVarArgs(
                                Predefined.invokePrintln(Factories.accessVariable(String.class, "str"))
                        )),
                MethodFactory.method(EnumSet.of(CodeModifier.PUBLIC), "mm", Types.VOID, CodeSource.fromVarArgs(
                        Predefined.invokePrintln(Literals.STRING("A"))
                )),
                inner
        ));


        return Pair.of(codeClass, CodeSource.fromVarArgs(codeClass));
    }

    @Test
    public void test() {
        $();
    }


}
