/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test;

import com.github.jonathanxd.kores.Instructions;
import com.github.jonathanxd.kores.Defaults;
import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.Alias;
import com.github.jonathanxd.kores.base.Annotation;
import com.github.jonathanxd.kores.base.AnnotationDeclaration;
import com.github.jonathanxd.kores.base.AnnotationProperty;
import com.github.jonathanxd.kores.base.AnonymousClass;
import com.github.jonathanxd.kores.base.ArrayConstructor;
import com.github.jonathanxd.kores.base.ArrayLength;
import com.github.jonathanxd.kores.base.ArrayLoad;
import com.github.jonathanxd.kores.base.ArrayStore;
import com.github.jonathanxd.kores.base.Case;
import com.github.jonathanxd.kores.base.Cast;
import com.github.jonathanxd.kores.base.CatchStatement;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.Retention;
import com.github.jonathanxd.kores.base.Concat;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.ControlFlow;
import com.github.jonathanxd.kores.base.EnumDeclaration;
import com.github.jonathanxd.kores.base.EnumEntry;
import com.github.jonathanxd.kores.base.EnumValue;
import com.github.jonathanxd.kores.base.FieldAccess;
import com.github.jonathanxd.kores.base.FieldDeclaration;
import com.github.jonathanxd.kores.base.FieldDefinition;
import com.github.jonathanxd.kores.base.ForEachStatement;
import com.github.jonathanxd.kores.base.ForStatement;
import com.github.jonathanxd.kores.base.IfExpr;
import com.github.jonathanxd.kores.base.IfStatement;
import com.github.jonathanxd.kores.base.InstanceOfCheck;
import com.github.jonathanxd.kores.base.InterfaceDeclaration;
import com.github.jonathanxd.kores.base.InvokeDynamic;
import com.github.jonathanxd.kores.base.InvokeType;
import com.github.jonathanxd.kores.base.IterationType;
import com.github.jonathanxd.kores.base.Label;
import com.github.jonathanxd.kores.base.LocalCode;
import com.github.jonathanxd.kores.base.MethodDeclaration;
import com.github.jonathanxd.kores.base.MethodInvocation;
import com.github.jonathanxd.kores.base.Operate;
import com.github.jonathanxd.kores.base.Return;
import com.github.jonathanxd.kores.base.StaticBlock;
import com.github.jonathanxd.kores.base.SwitchStatement;
import com.github.jonathanxd.kores.base.SwitchType;
import com.github.jonathanxd.kores.base.ThrowException;
import com.github.jonathanxd.kores.base.TryStatement;
import com.github.jonathanxd.kores.base.TryWithResources;
import com.github.jonathanxd.kores.base.TypeSpec;
import com.github.jonathanxd.kores.base.VariableAccess;
import com.github.jonathanxd.kores.base.VariableDeclaration;
import com.github.jonathanxd.kores.base.VariableDefinition;
import com.github.jonathanxd.kores.base.WhileStatement;
import com.github.jonathanxd.kores.base.comment.Code;
import com.github.jonathanxd.kores.base.comment.Comments;
import com.github.jonathanxd.kores.base.comment.Link;
import com.github.jonathanxd.kores.base.comment.Plain;
import com.github.jonathanxd.kores.common.DynamicMethodSpec;
import com.github.jonathanxd.kores.common.MethodInvokeSpec;
import com.github.jonathanxd.kores.common.MethodTypeSpec;
import com.github.jonathanxd.kores.common.Nothing;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.factory.InvocationFactory;
import com.github.jonathanxd.kores.factory.VariableFactory;
import com.github.jonathanxd.kores.generic.GenericSignature;
import com.github.jonathanxd.kores.helper.ConcatHelper;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.literal.Literals;
import com.github.jonathanxd.kores.operator.Operators;
import com.github.jonathanxd.kores.type.AnnotatedKoresType;
import com.github.jonathanxd.kores.type.Generic;
import com.github.jonathanxd.kores.type.PlainKoresType;
import com.github.jonathanxd.iutils.map.MapUtils;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * Tests proxy builder generator
 */
public class BuilderTest {

    @Test
    public void annotationBuilderTest() {
        Annotation.Builder.Companion.builder()
                .type(Test.class)
                .retention(Retention.RUNTIME)
                .values(MapUtils.mapOf(
                        "expected", NullPointerException.class
                ))
                .build();
    }

    @Test
    public void annotationDeclarationBuilderTest() {
        AnnotationDeclaration.Builder.Companion.builder()
                .qualifiedName("com.MyAnnotation")
                .properties(AnnotationProperty.Builder.Companion.builder()
                        .defaultValue("Hello world")
                        .name("message")
                        .returnType(String.class)
                        .build())
                .build();
    }

    @Test
    public void annotationPropertyBuilderTest() {
        AnnotationProperty.Builder.Companion.builder()
                .defaultValue("Hello world")
                .name("message")
                .type(String.class)
                .build();
    }

    @Test
    public void anonymousClassBuilderTest() {
        AnonymousClass.Builder.Companion.builder()
                .qualifiedName("MyAnonymous")
                .array(false)
                .constructorBody(Instructions.empty())
                .modifiers(KoresModifier.PUBLIC)
                .constructorSpec(new TypeSpec(Void.TYPE))
                .build();
    }

    @Test
    public void arrayConstructorBuilderTest() {
        ArrayConstructor.Builder.Companion.builder()
                .array(true)
                .arguments(Literals.STRING("Hey"))
                .arrayType(String[].class)
                .dimensions(Literals.INT(1))
                .build();
    }

    @Test
    public void arrayLengthBuilderTest() {
        ArrayLength.Builder.Companion.builder()
                .arrayType(String[].class)
                .target(Factories.accessVariable(String.class, "array"))
                .build();
    }

    @Test
    public void arrayLoadBuilderTest() {
        ArrayLoad.Builder.Companion.builder()
                .arrayType(String[].class)
                .target(Factories.accessVariable(String.class, "array"))
                .index(Literals.INT(0))
                .valueType(String.class)
                .build();
    }

    @Test
    public void arrayStoreBuilderTest() {
        ArrayStore.Builder.Companion.builder()
                .arrayType(String[].class)
                .target(Factories.accessVariable(String.class, "array"))
                .index(Literals.INT(0))
                .valueType(String.class)
                .valueToStore(Literals.STRING("Hello world"))
                .build();
    }

    @Test
    public void caseBuilderTest() {
        Case.Builder.Companion.builder()
                .value(Literals.INT(9))
                .type(Integer.TYPE)
                .body(Instructions.fromVarArgs(
                        Predefined.invokePrintlnStr(Literals.STRING("Hello from Kores"))
                ))
                .build();
    }

    @Test
    public void castBuilderTest() {
        Cast.Builder.Companion.builder()
                .originalType(Object.class)
                .targetType(Integer.class)
                .instruction(Factories.accessVariable(Object.class, "in"))
                .build();
    }

    @Test
    public void catchStatementBuilderTest() {
        CatchStatement.Builder.Companion.builder()
                .exceptionTypes(NullPointerException.class, IllegalArgumentException.class)
                .variable(VariableDeclaration.Builder.Companion.builder()
                        .name("ex")
                        .variableType(Throwable.class)
                        .build())
                .body(Instructions.empty())
                .build();
    }

    @Test
    public void classDeclarationBuilderTest() {
        ClassDeclaration.Builder.Companion.builder()
                .name("com.MyClass")
                .implementations(CharSequence.class)
                .genericSignature(GenericSignature.empty())
                .build();
    }

    @Test
    public void codeBuilderTest() {
        Code.Builder.Companion.builder()
                .code(new Code.CodeNode.Plain("param"))
                .build();
    }

    @Test
    public void commentsBuilderTest() {
        Comments.Builder.Companion.builder()
                .comments(new Plain("Read api "), new Link("doc", new Link.LinkTarget.URL("https://example/docs")))
                .type(Comments.Type.DOCUMENTATION)
                .build();
    }

    @Test
    public void concatBuilderTest() {
        Concat.Builder.Companion.builder()
                .concatenations(Literals.STRING("Ko"), Literals.STRING("res"))
                .build();
    }

    @Test
    public void constructorDeclarationBuilderTest() {
        ConstructorDeclaration.Builder.Companion.builder()
                .name("x")
                .parameters(Factories.parameter(String.class, "x"))
                .build();
    }

    @Test
    public void controlFlowBuilderTest() {
        ControlFlow.Builder.Companion.builder()
                .type(ControlFlow.Type.BREAK)
                .build();
    }

    @Test
    public void enumDeclarationBuilderTest() {
        EnumDeclaration.Builder.Companion.builder()
                .qualifiedName("com.MyEnum")
                .entries(EnumEntry.Builder.Companion.builder().name("A").build(), EnumEntry.Builder.Companion.builder().name("B").build())
                .build();
    }

    @Test
    public void enumEntryBuilderTest() {
        EnumEntry.Builder.Companion.builder()
                .name("Y")
                .constructorSpec(new TypeSpec(Void.TYPE, Collections.singletonList(String.class)))
                .arguments(Literals.STRING("yy"))
                .build();
    }

    @Test
    public void enumValueBuilderTest() {
        EnumValue.Builder.Companion.builder()
                .enumEntry("A")
                .enumType(new PlainKoresType("com.MyEnum"))
                .build();
    }

    @Test
    public void fieldAccessBuilderTest() {
        FieldAccess.Builder.Companion.builder()
                .target(Defaults.ACCESS_STATIC)
                .localization(System.class)
                .type(PrintStream.class)
                .name("out")
                .build();
    }

    @Test
    public void fieldDeclarationBuilderTest() {
        FieldDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                .type(PrintStream.class)
                .name("out")
                .build();
    }

    @Test
    public void fieldDefinitionBuilderTest() {
        FieldDefinition.Builder.Companion.builder()
                .target(Defaults.ACCESS_STATIC)
                .localization(System.class)
                .type(PrintStream.class)
                .name("out")
                .value(Literals.NULL)
                .build();
    }

    @Test
    public void forEachStatementBuilderTest() {
        ForEachStatement.Builder.Companion.builder()
                .variable(VariableDeclaration.Builder.Companion.builder()
                        .variableType(String.class)
                        .name("s")
                        .build())
                .iterableElement(Factories.accessVariable(Generic.type(List.class).of(String.class), "myList"))
                .iterationType(IterationType.ITERABLE_ELEMENT)
                .build();
    }

    @Test
    public void forStatementBuilderTest() {
        ForStatement.Builder.Companion.builder()
                .forInit(VariableFactory.variable(Integer.TYPE, "i", Literals.INT(0)))
                .forExpression(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(100)))
                .forUpdate(Factories.operateAndAssign(Integer.TYPE, "i", Operators.ADD, Literals.INT(1)))
                .body(Instructions.fromVarArgs(
                        Predefined.invokePrintln(ConcatHelper.builder("Number: ")
                                .concat(VariableFactory.variable(Integer.TYPE, "i"))
                                .concat(".")
                                .build())
                ))
                .build();
    }

    @Test
    public void ifExprBuilderTest() {
        IfExpr.Builder.Companion.builder()
                .expr1(Factories.accessVariable(Integer.TYPE, "i"))
                .operation(Operators.LESS_THAN)
                .expr2(Literals.INT(5))
                .build();
    }

    @Test
    public void ifStatementBuilderTest() {
        IfStatement.Builder.Companion.builder()
                .expressions(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(70)))
                .body(Instructions.fromPart(Predefined.invokePrintlnStr(Literals.STRING("< 70"))))
                .elseStatement(Instructions.fromPart(Predefined.invokePrintlnStr(Literals.STRING(">= 70"))))
                .build();
    }

    @Test
    public void instanceOfBuilderTest() {
        InstanceOfCheck.Builder.Companion.builder()
                .checkType(String.class)
                .part(Factories.accessVariable(String.class, "a"))
                .build();
    }

    @Test
    public void interfaceDeclarationBuilderTest() {
        InterfaceDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.PUBLIC)
                .name("com.MyInterface")
                .build();
    }

    @Test
    public void labelBuilderTest() {
        Label.Builder.Companion.builder()
                .name("myLabel")
                .build();
    }

    @Test
    public void linkBuilderTest() {
        Link.Builder.Companion.builder()
                .name("JavaDocs")
                .target(new Link.LinkTarget.URL("https://docs.oracle.com/javase/8/docs/api/"))
                .build();
    }

    @Test
    public void methodDeclarationBuilderTest() {
        MethodDeclaration.Builder.Companion.builder()
                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                .name("call")
                .returnType(Void.TYPE)
                .parameters()
                .build();
    }

    @Test
    public void methodFragmentBuilderTest() {
        LocalCode.Builder.builder()
                .declaringType(ClassDeclaration.Builder.builder().qualifiedName("com.x").build()) // will be removed
                .declaration(
                        MethodDeclaration.Builder.Companion.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                                .name("fragment$call")
                                .returnType(Void.TYPE)
                                .parameters()
                                .build()
                )
                .invokeType(InvokeType.INVOKE_VIRTUAL)
                .build();
    }

    @Test
    public void methodInvocationBuilderTest() {
        MethodInvocation.Builder.Companion.builder()
                .localization(Alias.THIS.INSTANCE)
                .target(Defaults.ACCESS_THIS)
                .invokeType(InvokeType.INVOKE_VIRTUAL)
                .spec(new MethodTypeSpec(Alias.THIS.INSTANCE, "hi", new TypeSpec(Void.TYPE)))
                .build();
    }

    @Test
    public void operateBuilderTest() {
        Operate.Builder.Companion.builder()
                .operation(Operators.MULTIPLY)
                .target(Factories.accessVariable(Integer.TYPE, "a"))
                .value(Literals.INT(9))
                .build();
    }

    @Test
    public void plainBuilderTest() {
        Plain.Builder.Companion.builder()
                .text("yx")
                .build();
    }

    @Test
    public void returnBuilderTest() {
        Return.Builder.Companion.builder()
                .type(Integer.TYPE)
                .value(Literals.INT(7))
                .build();
    }

    @Test
    public void staticBlockBuilderTest() {
        StaticBlock.Builder.Companion.builder()
                .body(Instructions.empty())
                .build();
    }

    @Test
    public void switchStatementBuilderTest() {
        SwitchStatement.Builder.Companion.builder()
                .switchType(SwitchType.NUMERIC)
                .value(Factories.accessVariable(Integer.TYPE, "a"))
                .cases(
                        new Case(Literals.INT(1), Instructions.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 1")))),
                        new Case(Literals.INT(90), Instructions.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 90")))),
                        new Case(Nothing.INSTANCE, Instructions.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a != 1 && a != 90"))))
                )
                .build();
    }

    @Test
    public void throwExceptionBuilderTest() {
        ThrowException.Builder.Companion.builder()
                .value(InvocationFactory.invokeConstructor(NullPointerException.class))
                .build();
    }

    @Test
    public void tryStatementBuilderTest() {
        TryStatement.Builder.Companion.builder().build();
    }

    @Test
    public void tryWithResourcesBuilderTest() {
        TryWithResources.Builder.Companion.builder()
                .variable(VariableDeclaration.Builder.Companion.builder()
                        .name("mi")
                        .variableType(TryWithResourcesTest_.Trm.class)
                        .value(
                                InvocationFactory.invokeVirtual(TryWithResourcesTest_.Trm.class, Factories.accessVariable(TryWithResourcesTest_.Trm.class, "mi"), "read", new TypeSpec(Void.TYPE), Collections.emptyList())
                        )
                        .build()
                )
                .build();
    }

    @Test
    public void variableAccessBuilderTest() {
        VariableAccess.Builder.Companion.builder()
                .name("a")
                .type(String.class)
                .build();
    }

    @Test
    public void variableDeclarationBuilderTest() {
        VariableDeclaration.Builder.Companion.builder()
                .name("a")
                .type(String.class)
                .value(Literals.NULL)
                .build();
    }

    @Test
    public void variableDefinitionBuilderTest() {
        VariableDefinition.Builder.Companion.builder()
                .name("a")
                .type(String.class)
                .value(Literals.NULL)
                .build();
    }

    @Test
    public void whileStatementBuilderTest() {
        WhileStatement.Builder.Companion.builder()
                .type(WhileStatement.Type.DO_WHILE)
                .expressions(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(70)))
                .body(Instructions.fromPart(Predefined.invokePrintlnStr(Literals.STRING("a"))))
                .build();
    }

    // Since 4.0.0
    @Test
    public void invokeDynamicBuilderTest() {
        InvokeDynamic.Builder.Companion.builder()
                .type(Void.TYPE)
                .dynamicMethod(new DynamicMethodSpec("helloWorld",
                        Factories.typeSpec(Void.TYPE, String.class),
                        Collections.singletonList(Literals.STRING("World"))))
                .bootstrap(new MethodInvokeSpec(InvokeType.INVOKE_STATIC, InvocationsTest_.BOOTSTRAP_SPEC))
                .build();
    }

    @Test
    public void invokeLambdaRefBuilderTest() {
        InvokeDynamic.LambdaMethodRef.Builder.Companion.builder()
                .baseSam(new MethodTypeSpec(Supplier.class, "get", new TypeSpec(Object.class)))
                .target(Factories.accessVariable(Greeter.class, "greeter"))
                .expectedTypes(new TypeSpec(String.class))
                .methodRef(new MethodInvokeSpec(
                        InvokeType.INVOKE_INTERFACE,
                        new MethodTypeSpec(Greeter.class, "hello", Factories.typeSpec(String.class))
                ))
                .build();
    }

    @Test
    public void invokeLambdaFuncBuilderTest() {
        InvokeDynamic.LambdaLocalCode.Builder.Companion.builder()
                .baseSam(new MethodTypeSpec(Supplier.class, "get", new TypeSpec(Object.class)))
                .expectedTypes(new TypeSpec(String.class))
                .localCode(LocalCode.Builder.builder()
                        .declaringType(ClassDeclaration.Builder.Companion.builder().qualifiedName("com.x").build())
                        .declaration(MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                                .name("$$lambda$1")
                                .returnType(Types.STRING)
                                .body(Instructions.fromVarArgs(
                                        Factories.returnValue(Types.STRING, Literals.STRING("Kores"))
                                ))
                                .build())
                        .build())
                .build();
    }

    @Test
    public void annotatedTypeTest() {
        AnnotatedKoresType.Companion.builder(String.class)
                .annotations(new ArrayList<>())
                .addAnnotation(Annotation.Builder.builder()
                        .retention(Retention.RUNTIME)
                        .type(NotNull.class)
                        .build())
                .build();
    }
}
