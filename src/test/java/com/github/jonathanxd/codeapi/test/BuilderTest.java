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
import com.github.jonathanxd.codeapi.common.Nothing;
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
                .type(Test.class)
                .visible(true)
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
                .constructorBody(CodeSource.empty())
                .modifiers(CodeModifier.PUBLIC)
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
                .body(CodeSource.fromVarArgs(
                        Predefined.invokePrintlnStr(Literals.STRING("Hello from CodeAPI"))
                ))
                .build();
    }

    @Test
    public void castBuilderTest() {
        Cast.Builder.Companion.builder()
                .originalType(Object.class)
                .targetType(Integer.class)
                .castedPart(Factories.accessVariable(Object.class, "in"))
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
                .body(CodeSource.empty())
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
                .concatenations(Literals.STRING("Code"), Literals.STRING("API"))
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
                .enumType(new PlainCodeType("com.MyEnum"))
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
                .modifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
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
                .body(CodeSource.fromVarArgs(
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
                .body(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING("< 70"))))
                .elseStatement(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING(">= 70"))))
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
                .modifiers(CodeModifier.PUBLIC)
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
                .modifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
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
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
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
                .body(CodeSource.empty())
                .build();
    }

    @Test
    public void switchStatementBuilderTest() {
        SwitchStatement.Builder.Companion.builder()
                .switchType(SwitchType.NUMERIC)
                .value(Factories.accessVariable(Integer.TYPE, "a"))
                .cases(
                        new Case(Literals.INT(1), CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 1")))),
                        new Case(Literals.INT(90), CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a = 90")))),
                        new Case(Nothing.INSTANCE, CodeSource.fromVarArgs(Predefined.invokePrintlnStr(Literals.STRING("a != 1 && a != 90"))))
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
                .body(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING("a"))))
                .build();
    }

    // Since 4.0.0
    @Test
    public void invokeDynamicBuilderTest() {
        InvokeDynamic.Builder.Companion.builder()
                .type(Void.TYPE)
                .invocation(InvocationFactory.invoke(InvokeType.INVOKE_VIRTUAL, CodeTypes.getCodeType(InvocationsTest_.class), Factories.accessStatic(),
                        "helloWorld",
                        Factories.typeSpec(Void.TYPE, String.class),
                        Collections.singletonList(Literals.STRING("World"))))
                .bootstrap(new MethodInvokeSpec(InvokeType.INVOKE_STATIC, InvocationsTest_.BOOTSTRAP_SPEC))
                .build();
    }

    @Test
    public void invokeLambdaRefBuilderTest() {
        InvokeDynamic.LambdaMethodRef.Builder.Companion.builder()
                .baseSam(new MethodTypeSpec(Supplier.class, "get", new TypeSpec(Object.class)))
                .expectedTypes(new TypeSpec(String.class))
                .invocation(InvocationFactory.invoke(
                        InvokeType.INVOKE_INTERFACE, Greeter.class, Factories.accessVariable(Greeter.class, "greeter"),
                        "hello",
                        Factories.typeSpec(String.class),
                        Collections.emptyList()))
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
                                .modifiers(CodeModifier.PUBLIC, CodeModifier.STATIC)
                                .name("$$lambda$1")
                                .returnType(Types.STRING)
                                .body(CodeSource.fromVarArgs(
                                        Factories.returnValue(Types.STRING, Literals.STRING("CodeAPI"))
                                ))
                                .build())
                        .build())
        .build();
    }
}
