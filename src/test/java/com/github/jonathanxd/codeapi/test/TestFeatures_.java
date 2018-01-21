/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.Alias;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.InvokeType;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.codeapi.type.CodeTypes;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Collections;

import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class TestFeatures_ {

    public static CodeInstruction invokePrintln(CodeInstruction toPrint) {
        return InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(PrintStream.class),
                Factories.accessStaticField(CodeTypes.getCodeType(System.class), CodeTypes.getCodeType(PrintStream.class), "out"),
                "println",
                Factories.typeSpec(Types.VOID, Types.OBJECT),
                singletonList(toPrint));
    }

    public static MethodDeclaration createPrintItMethod() {
        MutableCodeSource methodSource = MutableCodeSource.create();

        MethodDeclaration codeMethod = MethodDeclaration.Builder.builder()
                .modifiers(CodeModifier.PUBLIC)
                .name("printIt")
                .parameters(Factories.parameter(Types.OBJECT, "n"))
                .returnType(Types.VOID)
                .body(methodSource)
                .build();

        methodSource.add(Factories.ifStatement(
                Factories.checkNotNull(Factories.accessVariable(Object.class, "n")),
                CodeSource.fromVarArgs(invokePrintln(Literals.STRING("Hello :D"))),
                CodeSource.empty()
                )
        );

        methodSource.add(VariableFactory.variable(Types.STRING, "dingdong", Literals.STRING("DingDong")));

        methodSource.add(Predefined.invokePrintln(Factories.accessVariable(String.class, "dingdong")));

        methodSource.add(InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                Factories.accessStaticField(System.class, PrintStream.class, "out"),
                "println",
                Factories.typeSpec(Types.VOID, Types.OBJECT),
                singletonList(Factories.accessVariable(Types.OBJECT, "n"))));


        return codeMethod;
    }

    public static TypeDeclaration $() {

        ClassDeclaration.Builder codeClassBuilder = ClassDeclaration.Builder.builder()
                .modifiers(CodeModifier.PUBLIC)
                .qualifiedName("fullName." + TestFeatures_.class.getSimpleName())
                .superClass(Types.OBJECT)
                .fields(
                        FieldDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.FINAL)
                                .type(Types.STRING)
                                .name("FIELD")
                                .value(Literals.STRING("AVD"))
                                .build(),
                        FieldDeclaration.Builder.builder()
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.FINAL)
                                .type(Types.INT)
                                .name("n")
                                .value(Literals.INT(15))
                                .build()
                );

        CodeInstruction invokeTest = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(PrintStream.class),
                Factories.accessStaticField(CodeTypes.getCodeType(System.class), CodeTypes.getCodeType(PrintStream.class), "out"),
                "println",
                Factories.typeSpec(Types.VOID, Types.OBJECT),
                Collections.singletonList(Literals.STRING("Hello")));

        CodeInstruction invokeTest2 = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, Alias.THIS.INSTANCE,
                Factories.accessThis(),
                "printIt",
                Factories.typeSpec(Types.VOID, Types.OBJECT),

                Collections.singletonList(Literals.STRING("Oi")));

        ConstructorDeclaration codeConstructor = ConstructorDeclaration.Builder.Companion.builder()
                .modifiers(CodeModifier.PUBLIC)
                .body(CodeSource.fromVarArgs(invokeTest, invokeTest2))
                .build();


        codeClassBuilder
                .constructors(codeConstructor)
                .methods(createPrintItMethod(), createCheckMethod());

        return codeClassBuilder.build();
    }

    public static MethodDeclaration createCheckMethod() {
        MutableCodeSource methodSource = MutableCodeSource.create();

        MethodDeclaration codeMethod = MethodDeclaration.Builder.builder()
                .name("check")
                .modifiers(CodeModifier.PUBLIC)
                .parameters(Factories.parameter(Types.INT, "x"))
                .returnType(Types.BOOLEAN)
                .body(methodSource)
                .build();

        methodSource.add(Factories.ifStatement(
                Factories.ifExprs(
                        Factories.check(Factories.accessVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(9)),
                        Operators.OR,
                        Factories.check(Factories.accessVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(7))
                ),
                CodeSource.fromVarArgs(
                        Factories.returnValue(Types.INT, Literals.INT(0))
                )));

        methodSource.add(Predefined.invokePrintln(
                Factories.accessVariable(Types.INT, "x")
        ));

        methodSource.add(Factories.returnValue(Types.INT, Literals.INT(1)));

        return codeMethod;
    }

    @Test
    public void test() {
        $();
    }


}
