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
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.builder.ClassDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.ConstructorDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.MethodDeclarationBuilder;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.factory.FieldFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.iutils.annotation.Named;
import com.github.jonathanxd.iutils.object.Pair;

import java.io.PrintStream;
import java.util.Collections;
import java.util.EnumSet;

import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class TestFeatures_ {
    public static CodePart invokePrintln(CodePart toPrint) {
        return CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, CodeAPI.getJavaType(PrintStream.class),
                CodeAPI.accessStaticField(CodeAPI.getJavaType(System.class), CodeAPI.getJavaType(PrintStream.class), "out"),
                "println",
                CodeAPI.typeSpec(Types.VOID, Types.OBJECT),
                singletonList(toPrint));
    }

    public static MethodDeclaration makeCM() {
        MutableCodeSource methodSource = new MutableCodeSource();

        MethodDeclaration codeMethod = MethodDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withName("printIt")
                .withParameters(new CodeParameter(Types.OBJECT, "n"))
                .withReturnType(Types.VOID)
                .withBody(methodSource)
                .build();

        methodSource.add(CodeAPI.ifStatement(
                CodeAPI.checkNotNull(CodeAPI.accessLocalVariable(Object.class, "n")),
                CodeAPI.source(invokePrintln(Literals.STRING("Hello :D")))
                )
        );

        methodSource.add(VariableFactory.variable(Types.STRING, "dingdong", Literals.STRING("DingDong")));

        methodSource.add(Predefined.invokePrintln(CodeAPI.accessLocalVariable(String.class, "dingdong")));

        methodSource.add(CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, PrintStream.class,
                CodeAPI.accessStaticField(System.class, PrintStream.class, "out"),
                "println",
                CodeAPI.typeSpec(Types.VOID, Types.OBJECT),
                singletonList(CodeAPI.accessLocalVariable(Types.OBJECT, "n"))));


        return codeMethod;
    }

    public static Pair<@Named("Main class") TypeDeclaration, @Named("Source") CodeSource> $() {

        MutableCodeSource codeSource = new MutableCodeSource();

        MutableCodeSource clSource = new MutableCodeSource();

        ClassDeclaration codeClass = ClassDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withQualifiedName("fullName." + TestFeatures_.class.getSimpleName())
                .withSuperClass(Types.OBJECT)
                .withBody(clSource)
                .build();

        FieldDeclaration codeField = FieldFactory.field(
                EnumSet.of(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Types.STRING,
                "FIELD",
                Literals.STRING("AVD")
        );

        FieldDeclaration codeField2 = FieldFactory.field(
                EnumSet.of(CodeModifier.PUBLIC, CodeModifier.FINAL),
                Types.INT,
                "n",
                Literals.INT(15)
        );

        clSource.add(codeField);
        clSource.add(codeField2);

        CodePart invokeTest = CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, CodeAPI.getJavaType(PrintStream.class),
                CodeAPI.accessStaticField(CodeAPI.getJavaType(System.class), CodeAPI.getJavaType(PrintStream.class), "out"),
                "println",
                CodeAPI.typeSpec(Types.VOID, Types.OBJECT),
                Collections.singletonList(Literals.STRING("Hello")));

        CodePart invokeTest2 = CodeAPI.invoke(InvokeType.INVOKE_VIRTUAL, codeClass,
                CodeAPI.accessThis(),
                "printIt",
                CodeAPI.typeSpec(Types.VOID, Types.OBJECT),

                Collections.singletonList(Literals.STRING("Oi")));

        ConstructorDeclaration codeConstructor = ConstructorDeclarationBuilder.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withBody(CodeAPI.source(invokeTest, invokeTest2))
                .build();

        clSource.add(codeConstructor);

        clSource.add(makeCM());
        clSource.add(makeCM2());

        codeSource.add(codeClass);

        return Pair.of(codeClass, codeSource);
    }

    public static MethodDeclaration makeCM2() {
        MutableCodeSource methodSource = new MutableCodeSource();

        MethodDeclaration codeMethod = MethodDeclarationBuilder.builder()
                .withName("check")
                .withModifiers(CodeModifier.PUBLIC)
                .withParameters(new CodeParameter(Types.INT, "x"))
                .withReturnType(Types.BOOLEAN)
                .withBody(methodSource)
                .build();

        methodSource.add(CodeAPI.ifStatement(
                CodeAPI.ifExprs(
                        CodeAPI.check(CodeAPI.accessLocalVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(9)),
                        Operators.OR,
                        CodeAPI.check(CodeAPI.accessLocalVariable(Types.INT, "x"), Operators.EQUAL_TO, Literals.INT(7))
                ),
                CodeAPI.source(
                        CodeAPI.returnValue(Types.INT, Literals.INT(0))
                )));

        methodSource.add(Predefined.invokePrintln(
                CodeAPI.accessLocalVariable(Types.INT, "x")
        ));

        methodSource.add(CodeAPI.returnValue(Types.INT, Literals.INT(1)));

        return codeMethod;
    }

}
