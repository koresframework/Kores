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
package com.github.jonathanxd.codeapi;

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
import com.github.jonathanxd.codeapi.base.InvokeDynamicBase;
import com.github.jonathanxd.codeapi.base.Label;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodDeclarationBase;
import com.github.jonathanxd.codeapi.base.LocalCode;
import com.github.jonathanxd.codeapi.base.MethodInvocationBase;
import com.github.jonathanxd.codeapi.base.Operate;
import com.github.jonathanxd.codeapi.base.Return;
import com.github.jonathanxd.codeapi.base.StaticBlock;
import com.github.jonathanxd.codeapi.base.SwitchStatement;
import com.github.jonathanxd.codeapi.base.ThrowException;
import com.github.jonathanxd.codeapi.base.TryStatementBase;
import com.github.jonathanxd.codeapi.base.TryWithResources;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.base.VariableDefinition;
import com.github.jonathanxd.codeapi.base.WhileStatement;
import com.github.jonathanxd.codeapi.base.comment.Code;
import com.github.jonathanxd.codeapi.base.comment.Comments;
import com.github.jonathanxd.codeapi.base.comment.Link;
import com.github.jonathanxd.codeapi.base.comment.Plain;
import com.github.jonathanxd.codeapi.builder.Builder;
import com.github.jonathanxd.codeapi.builder.BuilderProvider;
import com.github.jonathanxd.codeapi.builder.proxy.ProxyBuilderFactoryKt;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassCacheKt;

public final class BuilderGeneratorProvider implements BuilderProvider {

    private static final Map<Class<?>, Class<?>> IMPLEMENTATIONS = new HashMap<>();

    static {
        //put(AnnotationDeclaration.Builder.class, AnnotationDeclarationImpl.class);
        //put(AnnotationProperty.Builder.class, AnnotationPropertyImpl.class);
        //put(AnonymousClass.Builder.class, AnonymousClassImpl.class);
        //put(ArrayConstructor.Builder.class, ArrayConstructorImpl.class);
        //put(ArrayLength.Builder.class, ArrayLengthImpl.class);
        put(ArrayLoad.Builder.class, ArrayLoad.class);
        put(ArrayStore.Builder.class, ArrayStore.class);
        put(Case.Builder.class, Case.class);
        put(Cast.Builder.class, Cast.class);
        put(CatchStatement.Builder.class, CatchStatement.class);
        put(ClassDeclaration.Builder.class, ClassDeclaration.class);
        put(Code.Builder.class, Code.class);
        put(Comments.Builder.class, Comments.class);
        put(Concat.Builder.class, Concat.class);
        put(ConstructorDeclaration.Builder.class, ConstructorDeclaration.class);
        put(ControlFlow.Builder.class, ControlFlow.class);
        put(EnumDeclaration.Builder.class, EnumDeclaration.class);
        put(EnumEntry.Builder.class, EnumEntry.class);
        put(EnumValue.Builder.class, EnumValue.class);
        put(FieldAccess.Builder.class, FieldAccess.class);
        put(FieldDeclaration.Builder.class, FieldDeclaration.class);
        put(FieldDefinition.Builder.class, FieldDefinition.class);
        put(ForEachStatement.Builder.class, ForEachStatement.class);
        put(ForStatement.Builder.class, ForStatement.class);
        put(IfExpr.Builder.class, IfExpr.class);
        put(IfStatement.Builder.class, IfStatement.class);
        put(InstanceOfCheck.Builder.class, InstanceOfCheck.class);
        put(InterfaceDeclaration.Builder.class, InterfaceDeclaration.class);
        put(Label.Builder.class, Label.class);
        put(Link.Builder.class, Link.class);
        put(MethodDeclarationBase.Builder.class, MethodDeclaration.class);
        put(LocalCode.Builder.class, LocalCode.class);
        put(MethodInvocationBase.Builder.class, MethodInvocationBase.class);
        put(Operate.Builder.class, Operate.class);
        put(Plain.Builder.class, Plain.class);
        put(Return.Builder.class, Return.class);
        put(StaticBlock.Builder.class, StaticBlock.class);
        put(SwitchStatement.Builder.class, SwitchStatement.class);
        put(ThrowException.Builder.class, ThrowException.class);
        put(TryStatementBase.Builder.class, TryStatementBase.class);
        put(TryWithResources.Builder.class, TryWithResources.class);
        put(VariableAccess.Builder.class, VariableAccess.class);
        put(VariableDeclaration.Builder.class, VariableDeclaration.class);
        put(VariableDefinition.Builder.class, VariableDefinition.class);
        put(WhileStatement.Builder.class, WhileStatement.class);

        // Since 4.0.0
        put(InvokeDynamicBase.Builder.class, InvokeDynamic.class);
        put(InvokeDynamicBase.LambdaMethodRefBase.Builder.class, InvokeDynamic.LambdaMethodRef.class);
        put(InvokeDynamicBase.LambdaLocalMethodBase.Builder.class, InvokeDynamic.LambdaLocalMethod.class);
    }

    private static void put(Class<?> builder, Class<?> impl) {
        IMPLEMENTATIONS.put(builder, impl);
    }

    @Override
    public <T extends CodePart, B extends Builder<? extends T, ?>> void register(@NotNull Class<B> type, @NotNull Function0<? extends B> factory, @NotNull Function1<? super T, ? extends B> defaultsFactory) {

    }

    @NotNull
    @Override
    public <T extends CodePart, B extends Builder<? extends T, ?>> B get(@NotNull Class<B> type, @NotNull T codePart) {
        Class<?> implClass = Objects.requireNonNull(IMPLEMENTATIONS.get(type), "IMPLEMENTATIONS.get(type)");

        KClass<B> builder = KClassCacheKt.getOrCreateKotlinClass(type);
        KClass<?> impl = KClassCacheKt.getOrCreateKotlinClass(implClass);

        return ProxyBuilderFactoryKt.create(builder, impl, codePart);
    }

    @NotNull
    @Override
    public <T extends CodePart, B extends Builder<? extends T, ?>> B get(@NotNull Class<B> type) {

        Class<?> implClass = Objects.requireNonNull(IMPLEMENTATIONS.get(type), "IMPLEMENTATIONS.get(type)");

        KClass<B> builder = KClassCacheKt.getOrCreateKotlinClass(type);
        KClass<?> impl = KClassCacheKt.getOrCreateKotlinClass(implClass);

        return ProxyBuilderFactoryKt.create(builder, impl, null);
    }
}
