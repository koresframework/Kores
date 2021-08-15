/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test;

import com.koresframework.kores.Instruction;
import com.koresframework.kores.Instructions;
import com.koresframework.kores.MutableInstructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.base.Alias;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.InvokeType;
import com.koresframework.kores.base.MethodDeclaration;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.InvocationFactory;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import com.koresframework.kores.type.KoresTypes;

import com.koresframework.kores.base.Alias;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Collections;

import static java.util.Collections.singletonList;

@SuppressWarnings("Duplicates")
public class TestFeatures_ {

    public static Instruction invokePrintln(Instruction toPrint) {
        return InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, KoresTypes.getKoresType(PrintStream.class),
                Factories.accessStaticField(KoresTypes.getKoresType(System.class), KoresTypes.getKoresType(PrintStream.class), "out"),
                "println",
                Factories.typeSpec(Types.VOID, Types.OBJECT),
                singletonList(toPrint));
    }

    public static MethodDeclaration createPrintItMethod() {
        MutableInstructions methodSource = MutableInstructions.create();

        MethodDeclaration codeMethod = MethodDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .name("printIt")
                .parameters(Factories.parameter(Types.OBJECT, "n"))
                .returnType(Types.VOID)
                .body(methodSource)
                .build();

        methodSource.add(Factories.ifStatement(
                Factories.checkNotNull(Factories.accessVariable(Object.class, "n")),
                Instructions.fromVarArgs(invokePrintln(Literals.STRING("Hello :D"))),
                Instructions.empty()
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
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("fullName." + TestFeatures_.class.getSimpleName())
                .superClass(Types.OBJECT)
                .fields(
                        FieldDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.FINAL)
                                .type(Types.STRING)
                                .name("FIELD")
                                .value(Literals.STRING("AVD"))
                                .build(),
                        FieldDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.FINAL)
                                .type(Types.INT)
                                .name("n")
                                .value(Literals.INT(15))
                                .build()
                );

        Instruction invokeTest = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, KoresTypes.getKoresType(PrintStream.class),
                Factories.accessStaticField(KoresTypes.getKoresType(System.class), KoresTypes.getKoresType(PrintStream.class), "out"),
                "println",
                Factories.typeSpec(Types.VOID, Types.OBJECT),
                Collections.singletonList(Literals.STRING("Hello")));

        Instruction invokeTest2 = InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, Alias.THIS.INSTANCE,
                Factories.accessThis(),
                "printIt",
                Factories.typeSpec(Types.VOID, Types.OBJECT),

                Collections.singletonList(Literals.STRING("Oi")));

        ConstructorDeclaration codeConstructor = ConstructorDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.PUBLIC)
                .body(Instructions.fromVarArgs(invokeTest, invokeTest2))
                .build();


        codeClassBuilder
                .constructors(codeConstructor)
                .methods(createPrintItMethod(), createCheckMethod());

        return codeClassBuilder.build();
    }

    public static MethodDeclaration createCheckMethod() {
        MutableInstructions methodSource = MutableInstructions.create();

        MethodDeclaration codeMethod = MethodDeclaration.Builder.builder()
                .name("check")
                .modifiers(KoresModifier.PUBLIC)
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
                Instructions.fromVarArgs(
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
