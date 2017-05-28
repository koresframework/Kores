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
import com.github.jonathanxd.codeapi.Defaults;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.Access;
import com.github.jonathanxd.codeapi.base.Annotation;
import com.github.jonathanxd.codeapi.base.AnnotationDeclaration;
import com.github.jonathanxd.codeapi.base.AnnotationProperty;
import com.github.jonathanxd.codeapi.base.AnonymousClass;
import com.github.jonathanxd.codeapi.base.ArrayConstructor;
import com.github.jonathanxd.codeapi.base.ArrayLength;
import com.github.jonathanxd.codeapi.base.ArrayLoad;
import com.github.jonathanxd.codeapi.base.ArrayStore;
import com.github.jonathanxd.codeapi.base.Case;
import com.github.jonathanxd.codeapi.base.Cast;
import com.github.jonathanxd.codeapi.base.CatchStatement;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.Concat;
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.ControlFlow;
import com.github.jonathanxd.codeapi.base.EnumDeclaration;
import com.github.jonathanxd.codeapi.base.EnumEntry;
import com.github.jonathanxd.codeapi.base.EnumValue;
import com.github.jonathanxd.codeapi.base.FieldAccess;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.FieldDefinition;
import com.github.jonathanxd.codeapi.base.ForEachStatement;
import com.github.jonathanxd.codeapi.base.ForStatement;
import com.github.jonathanxd.codeapi.base.IfExpr;
import com.github.jonathanxd.codeapi.base.IfStatement;
import com.github.jonathanxd.codeapi.base.InstanceOfCheck;
import com.github.jonathanxd.codeapi.base.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.base.InvokeDynamic;
import com.github.jonathanxd.codeapi.base.Label;
import com.github.jonathanxd.codeapi.base.LocalCode;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.Operate;
import com.github.jonathanxd.codeapi.base.Return;
import com.github.jonathanxd.codeapi.base.StaticBlock;
import com.github.jonathanxd.codeapi.base.SwitchStatement;
import com.github.jonathanxd.codeapi.base.ThrowException;
import com.github.jonathanxd.codeapi.base.TryStatement;
import com.github.jonathanxd.codeapi.base.TryWithResources;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.base.VariableDefinition;
import com.github.jonathanxd.codeapi.base.WhileStatement;
import com.github.jonathanxd.codeapi.base.comment.Code;
import com.github.jonathanxd.codeapi.base.comment.Comments;
import com.github.jonathanxd.codeapi.base.comment.Link;
import com.github.jonathanxd.codeapi.base.comment.Plain;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.InvokeType;
import com.github.jonathanxd.codeapi.base.IterationType;
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.base.SwitchType;
import com.github.jonathanxd.codeapi.base.TypeSpec;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.InvocationFactory;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.ConcatHelper;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.codeapi.type.Generic;
import com.github.jonathanxd.codeapi.type.PlainCodeType;
import com.github.jonathanxd.codeapi.util.Alias;
import com.github.jonathanxd.codeapi.util.CodeTypes;
import com.github.jonathanxd.iutils.map.MapUtils;

import org.junit.Test;

import java.io.PrintStream;
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
                .withType(Test.class)
                .withVisible(true)
                .withValues(MapUtils.mapOf(
                        "expected", NullPointerException.class
                ))
                .build();
    }

    @Test
    public void annotationDeclarationBuilderTest() {
        AnnotationDeclaration.Builder.Companion.builder()
                .withQualifiedName("com.MyAnnotation")
                .withProperties(AnnotationProperty.Builder.Companion.builder()
                        .withValue("Hello world")
                        .withName("message")
                        .withReturnType(String.class)
                        .build())
                .build();
    }

    @Test
    public void annotationPropertyBuilderTest() {
        AnnotationProperty.Builder.Companion.builder()
                .withValue("Hello world")
                .withName("message")
                .withType(String.class)
                .build();
    }

    @Test
    public void anonymousClassBuilderTest() {
        AnonymousClass.Builder.Companion.builder()
                .withQualifiedName("MyAnonymous")
                .withArray(false)
                .withConstructorBody(CodeSource.empty())
                .withModifiers(CodeModifier.PUBLIC)
                .withConstructorSpec(new TypeSpec(Void.TYPE))
                .build();
    }

    @Test
    public void arrayConstructorBuilderTest() {
        ArrayConstructor.Builder.Companion.builder()
                .withArray(true)
                .withArguments(Literals.STRING("Hey"))
                .withArrayType(String[].class)
                .withDimensions(Literals.INT(1))
                .build();
    }

    @Test
    public void arrayLengthBuilderTest() {
        ArrayLength.Builder.Companion.builder()
                .withArrayType(String[].class)
                .withTarget(Factories.accessVariable(String.class, "array"))
                .build();
    }

    @Test
    public void arrayLoadBuilderTest() {
        ArrayLoad.Builder.Companion.builder()
                .withArrayType(String[].class)
                .withTarget(Factories.accessVariable(String.class, "array"))
                .withIndex(Literals.INT(0))
                .withValueType(String.class)
                .build();
    }

    @Test
    public void arrayStoreBuilderTest() {
        ArrayStore.Builder.Companion.builder()
                .withArrayType(String[].class)
                .withTarget(Factories.accessVariable(String.class, "array"))
                .withIndex(Literals.INT(0))
                .withValueType(String.class)
                .withValueToStore(Literals.STRING("Hello world"))
                .build();
    }

    @Test
    public void caseBuilderTest() {
        Case.Builder.Companion.builder()
                .withValue(Literals.INT(9))
                .withType(Integer.TYPE)
                .withBody(CodeSource.fromVarArgs(
                        Predefined.invokePrintlnStr(Literals.STRING("Hello from CodeAPI"))
                ))
                .build();
    }

    @Test
    public void castBuilderTest() {
        Cast.Builder.Companion.builder()
                .withOriginalType(Object.class)
                .withTargetType(Integer.class)
                .withCastedPart(Factories.accessVariable(Object.class, "in"))
                .build();
    }

    @Test
    public void catchStatementBuilderTest() {
        CatchStatement.Builder.Companion.builder()
                .withExceptionTypes(NullPointerException.class, IllegalArgumentException.class)
                .withVariable(VariableDeclaration.Builder.Companion.builder()
                        .withName("ex")
                        .withVariableType(Throwable.class)
                        .build())
                .withBody(CodeSource.empty())
                .build();
    }

    @Test
    public void classDeclarationBuilderTest() {
        ClassDeclaration.Builder.Companion.builder()
                .withName("com.MyClass")
                .withImplementations(CharSequence.class)
                .withGenericSignature(GenericSignature.empty())
                .build();
    }

    @Test
    public void codeBuilderTest() {
        Code.Builder.Companion.builder()
                .withCode(new Code.CodeNode.Plain("param"))
                .build();
    }

    @Test
    public void commentsBuilderTest() {
        Comments.Builder.Companion.builder()
                .withComments(new Plain("Read api "), new Link("doc", new Link.LinkTarget.URL("https://example/docs")))
                .withType(Comments.Type.DOCUMENTATION)
                .build();
    }

    @Test
    public void concatBuilderTest() {
        Concat.Builder.Companion.builder()
                .withConcatenations(Literals.STRING("Code"), Literals.STRING("API"))
                .build();
    }

    @Test
    public void constructorDeclarationBuilderTest() {
        ConstructorDeclaration.Builder.Companion.builder()
                .withName("x")
                .withParameters(Factories.parameter(String.class, "x"))
                .build();
    }

    @Test
    public void controlFlowBuilderTest() {
        ControlFlow.Builder.Companion.builder()
                .withType(ControlFlow.Type.BREAK)
                .build();
    }

    @Test
    public void enumDeclarationBuilderTest() {
        EnumDeclaration.Builder.Companion.builder()
                .withQualifiedName("com.MyEnum")
                .withEntries(EnumEntry.Builder.Companion.builder().withName("A").build(), EnumEntry.Builder.Companion.builder().withName("B").build())
                .build();
    }

    @Test
    public void enumEntryBuilderTest() {
        EnumEntry.Builder.Companion.builder()
                .withName("Y")
                .withConstructorSpec(new TypeSpec(Void.TYPE, Collections.singletonList(String.class)))
                .withArguments(Literals.STRING("yy"))
                .build();
    }

    @Test
    public void enumValueBuilderTest() {
        EnumValue.Builder.Companion.builder()
                .withEnumEntry("A")
                .withEnumType(new PlainCodeType("com.MyEnum"))
                .build();
    }

    @Test
    public void fieldAccessBuilderTest() {
        FieldAccess.Builder.Companion.builder()
                .withTarget(Defaults.ACCESS_STATIC)
                .withLocalization(System.class)
                .withType(PrintStream.class)
                .withName("out")
                .build();
    }

    @Test
    public void fieldDeclarationBuilderTest() {
        FieldDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                .withType(PrintStream.class)
                .withName("out")
                .build();
    }

    @Test
    public void fieldDefinitionBuilderTest() {
        FieldDefinition.Builder.Companion.builder()
                .withTarget(Defaults.ACCESS_STATIC)
                .withLocalization(System.class)
                .withType(PrintStream.class)
                .withName("out")
                .withValue(Literals.NULL)
                .build();
    }

    @Test
    public void forEachStatementBuilderTest() {
        ForEachStatement.Builder.Companion.builder()
                .withVariable(VariableDeclaration.Builder.Companion.builder()
                        .withVariableType(String.class)
                        .withName("s")
                        .build())
                .withIterableElement(Factories.accessVariable(Generic.type(List.class).of(String.class), "myList"))
                .withIterationType(IterationType.ITERABLE_ELEMENT)
                .build();
    }

    @Test
    public void forStatementBuilderTest() {
        ForStatement.Builder.Companion.builder()
                .withForInit(VariableFactory.variable(Integer.TYPE, "i", Literals.INT(0)))
                .withForExpression(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(100)))
                .withForUpdate(Factories.operateAndAssign(Integer.TYPE, "i", Operators.ADD, Literals.INT(1)))
                .withBody(CodeSource.fromVarArgs(
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
                .withExpr1(Factories.accessVariable(Integer.TYPE, "i"))
                .withOperation(Operators.LESS_THAN)
                .withExpr2(Literals.INT(5))
                .build();
    }

    @Test
    public void ifStatementBuilderTest() {
        IfStatement.Builder.Companion.builder()
                .withExpressions(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(70)))
                .withBody(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING("< 70"))))
                .withElseStatement(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING(">= 70"))))
                .build();
    }

    @Test
    public void instanceOfBuilderTest() {
        InstanceOfCheck.Builder.Companion.builder()
                .withCheckType(String.class)
                .withPart(Factories.accessVariable(String.class, "a"))
                .build();
    }

    @Test
    public void interfaceDeclarationBuilderTest() {
        InterfaceDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withName("com.MyInterface")
                .build();
    }

    @Test
    public void labelBuilderTest() {
        Label.Builder.Companion.builder()
                .withName("myLabel")
                .build();
    }

    @Test
    public void linkBuilderTest() {
        Link.Builder.Companion.builder()
                .withName("JavaDocs")
                .withTarget(new Link.LinkTarget.URL("https://docs.oracle.com/javase/8/docs/api/"))
                .build();
    }

    @Test
    public void methodDeclarationBuilderTest() {
        MethodDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                .withName("call")
                .withReturnType(Void.TYPE)
                .withParameters()
                .build();
    }

    @Test
    public void methodFragmentBuilderTest() {
        LocalCode.Builder.builder()
                .withDeclaringType(ClassDeclaration.Builder.builder().withQualifiedName("com.x").build()) // will be removed
                .withDeclaration(
                        MethodDeclaration.Builder.Companion.builder()
                                .withModifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                                .withName("fragment$call")
                                .withReturnType(Void.TYPE)
                                .withParameters()
                                .build()
                )
                .withInvokeType(InvokeType.INVOKE_VIRTUAL)
                .build();
    }

    @Test
    public void methodInvocationBuilderTest() {
        MethodInvocation.Builder.Companion.builder()
                .withLocalization(Alias.THIS.INSTANCE)
                .withTarget(Defaults.ACCESS_THIS)
                .withInvokeType(InvokeType.INVOKE_VIRTUAL)
                .withSpec(new MethodTypeSpec(Alias.THIS.INSTANCE, "hi", new TypeSpec(Void.TYPE)))
                .build();
    }

    @Test
    public void operateBuilderTest() {
        Operate.Builder.Companion.builder()
                .withOperation(Operators.MULTIPLY)
                .withTarget(Factories.accessVariable(Integer.TYPE, "a"))
                .withValue(Literals.INT(9))
                .build();
    }

    @Test
    public void plainBuilderTest() {
        Plain.Builder.Companion.builder()
                .withText("yx")
                .build();
    }

    @Test
    public void returnBuilderTest() {
        Return.Builder.Companion.builder()
                .withType(Integer.TYPE)
                .withValue(Literals.INT(7))
                .build();
    }

    @Test
    public void staticBlockBuilderTest() {
        StaticBlock.Builder.Companion.builder()
                .withBody(CodeSource.empty())
                .build();
    }

    @Test
    public void switchStatementBuilderTest() {
        SwitchStatement.Builder.Companion.builder()
                .withSwitchType(SwitchType.NUMERIC)
                .withValue(Factories.accessVariable(Integer.TYPE, "a"))
                .withCases(
                        new Case(Literals.INT(1), CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 1")))),
                        new Case(Literals.INT(90), CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 90")))),
                        new Case(null, CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a != 1 && a != 90"))))
                )
                .build();
    }

    @Test
    public void throwExceptionBuilderTest() {
        ThrowException.Builder.Companion.builder()
                .withValue(InvocationFactory.invokeConstructor(NullPointerException.class))
                .build();
    }

    @Test
    public void tryStatementBuilderTest() {
        TryStatement.Builder.Companion.builder().build();
    }

    @Test
    public void tryWithResourcesBuilderTest() {
        TryWithResources.Builder.Companion.builder()
                .withVariable(VariableDeclaration.Builder.Companion.builder()
                        .withName("mi")
                        .withVariableType(TryWithResourcesTest_.Trm.class)
                        .withValue(
                                InvocationFactory.invokeVirtual(TryWithResourcesTest_.Trm.class, Factories.accessVariable(TryWithResourcesTest_.Trm.class, "mi"), "read", new TypeSpec(Void.TYPE), Collections.emptyList())
                        )
                        .build()
                )
                .build();
    }

    @Test
    public void variableAccessBuilderTest() {
        VariableAccess.Builder.Companion.builder()
                .withName("a")
                .withType(String.class)
                .build();
    }

    @Test
    public void variableDeclarationBuilderTest() {
        VariableDeclaration.Builder.Companion.builder()
                .withName("a")
                .withType(String.class)
                .withValue(Literals.NULL)
                .build();
    }

    @Test
    public void variableDefinitionBuilderTest() {
        VariableDefinition.Builder.Companion.builder()
                .withName("a")
                .withType(String.class)
                .withValue(Literals.NULL)
                .build();
    }

    @Test
    public void whileStatementBuilderTest() {
        WhileStatement.Builder.Companion.builder()
                .withType(WhileStatement.Type.DO_WHILE)
                .withExpressions(Factories.check(Factories.accessVariable(Integer.TYPE, "i"), Operators.LESS_THAN, Literals.INT(70)))
                .withBody(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING("a"))))
                .build();
    }

    // Since 4.0.0
    @Test
    public void invokeDynamicBuilderTest() {
        InvokeDynamic.Builder.Companion.builder()
                .withType(Void.TYPE)
                .withInvocation(InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(InvocationsTest_.class), Factories.accessStatic(),
                        "helloWorld",
                        Factories.typeSpec(Void.TYPE, String.class),
                        Collections.singletonList(Literals.STRING("World"))))
                .withBootstrap(new MethodInvokeSpec(InvokeType.INVOKE_STATIC, InvocationsTest_.BOOTSTRAP_SPEC))
                .build();
    }

    @Test
    public void invokeLambdaRefBuilderTest() {
        InvokeDynamic.LambdaMethodRef.Builder.Companion.builder()
                .withBaseSam(new MethodTypeSpec(Supplier.class, "get", new TypeSpec(Object.class)))
                .withExpectedTypes(new TypeSpec(String.class))
                .withInvocation(InvocationFactory.invoke(
                        InvokeType.INVOKE_INTERFACE, Greeter.class, Factories.accessVariable(Greeter.class, "greeter"),
                        "hello",
                        Factories.typeSpec(String.class),
                        Collections.emptyList()))
                .build();
    }

    @Test
    public void invokeLambdaFuncBuilderTest() {
        InvokeDynamic.LambdaLocalCode.Builder.Companion.builder()
                .withBaseSam(new MethodTypeSpec(Supplier.class, "get", new TypeSpec(Object.class)))
                .withExpectedTypes(new TypeSpec(String.class))
                .withLocalCode(LocalCode.Builder.builder()
                        .withDeclaringType(ClassDeclaration.Builder.Companion.builder().withQualifiedName("com.x").build())
                        .withDeclaration(MethodDeclaration.Builder.builder()
                                .withModifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                                .withName("$$lambda$1")
                                .withReturnType(Types.STRING)
                                .withBody(CodeSource.fromVarArgs(
                                        Factories.returnValue(Types.STRING, Literals.STRING("CodeAPI"))
                                ))
                                .build())
                        .build())
        .build();
    }
}
