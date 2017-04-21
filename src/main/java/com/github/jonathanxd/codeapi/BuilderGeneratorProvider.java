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
import com.github.jonathanxd.codeapi.base.Label;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.MethodFragment;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.MethodSpecification;
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
import com.github.jonathanxd.codeapi.base.impl.AccessImpl;
import com.github.jonathanxd.codeapi.base.impl.AnnotationDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.AnnotationImpl;
import com.github.jonathanxd.codeapi.base.impl.AnnotationPropertyImpl;
import com.github.jonathanxd.codeapi.base.impl.AnonymousClassImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayLengthImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayLoadImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayStoreImpl;
import com.github.jonathanxd.codeapi.base.impl.CaseImpl;
import com.github.jonathanxd.codeapi.base.impl.CastImpl;
import com.github.jonathanxd.codeapi.base.impl.CatchStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ClassDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.ConcatImpl;
import com.github.jonathanxd.codeapi.base.impl.ConstructorDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.ControlFlowImpl;
import com.github.jonathanxd.codeapi.base.impl.EnumDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.EnumEntryImpl;
import com.github.jonathanxd.codeapi.base.impl.EnumValueImpl;
import com.github.jonathanxd.codeapi.base.impl.FieldAccessImpl;
import com.github.jonathanxd.codeapi.base.impl.FieldDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.FieldDefinitionImpl;
import com.github.jonathanxd.codeapi.base.impl.ForEachStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ForStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.IfExprImpl;
import com.github.jonathanxd.codeapi.base.impl.IfStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.InstanceOfCheckImpl;
import com.github.jonathanxd.codeapi.base.impl.InterfaceDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.LabelImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodFragmentImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl;
import com.github.jonathanxd.codeapi.base.impl.OperateImpl;
import com.github.jonathanxd.codeapi.base.impl.ReturnImpl;
import com.github.jonathanxd.codeapi.base.impl.StaticBlockImpl;
import com.github.jonathanxd.codeapi.base.impl.SwitchStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ThrowExceptionImpl;
import com.github.jonathanxd.codeapi.base.impl.TryStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.TryWithResourcesImpl;
import com.github.jonathanxd.codeapi.base.impl.VariableAccessImpl;
import com.github.jonathanxd.codeapi.base.impl.VariableDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.VariableDefinitionImpl;
import com.github.jonathanxd.codeapi.base.impl.WhileStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.comment.CodeImpl;
import com.github.jonathanxd.codeapi.base.impl.comment.CommentsImpl;
import com.github.jonathanxd.codeapi.base.impl.comment.LinkImpl;
import com.github.jonathanxd.codeapi.base.impl.comment.PlainImpl;
import com.github.jonathanxd.codeapi.builder.Builder;
import com.github.jonathanxd.codeapi.builder.BuilderProvider;
import com.github.jonathanxd.codeapi.builder.proxy.ProxyBuilderFactoryKt;
import com.github.jonathanxd.iutils.object.Pair;

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
        put(Access.Builder.class, AccessImpl.class);
        put(Annotation.Builder.class, AnnotationImpl.class);
        put(AnnotationDeclaration.Builder.class, AnnotationDeclarationImpl.class);
        put(AnnotationProperty.Builder.class, AnnotationPropertyImpl.class);
        put(AnonymousClass.Builder.class, AnonymousClassImpl.class);
        put(ArrayConstructor.Builder.class, ArrayConstructorImpl.class);
        put(ArrayLength.Builder.class, ArrayLengthImpl.class);
        put(ArrayLoad.Builder.class, ArrayLoadImpl.class);
        put(ArrayStore.Builder.class, ArrayStoreImpl.class);
        put(Case.Builder.class, CaseImpl.class);
        put(Cast.Builder.class, CastImpl.class);
        put(CatchStatement.Builder.class, CatchStatementImpl.class);
        put(ClassDeclaration.Builder.class, ClassDeclarationImpl.class);
        put(Code.Builder.class, CodeImpl.class);
        put(Comments.Builder.class, CommentsImpl.class);
        put(Concat.Builder.class, ConcatImpl.class);
        put(ConstructorDeclaration.Builder.class, ConstructorDeclarationImpl.class);
        put(ControlFlow.Builder.class, ControlFlowImpl.class);
        put(EnumDeclaration.Builder.class, EnumDeclarationImpl.class);
        put(EnumEntry.Builder.class, EnumEntryImpl.class);
        put(EnumValue.Builder.class, EnumValueImpl.class);
        put(FieldAccess.Builder.class, FieldAccessImpl.class);
        put(FieldDeclaration.Builder.class, FieldDeclarationImpl.class);
        put(FieldDefinition.Builder.class, FieldDefinitionImpl.class);
        put(ForEachStatement.Builder.class, ForEachStatementImpl.class);
        put(ForStatement.Builder.class, ForStatementImpl.class);
        put(IfExpr.Builder.class, IfExprImpl.class);
        put(IfStatement.Builder.class, IfStatementImpl.class);
        put(InstanceOfCheck.Builder.class, InstanceOfCheckImpl.class);
        put(InterfaceDeclaration.Builder.class, InterfaceDeclarationImpl.class);
        put(Label.Builder.class, LabelImpl.class);
        put(Link.Builder.class, LinkImpl.class);
        put(MethodDeclaration.Builder.class, MethodDeclarationImpl.class);
        put(MethodFragment.Builder.class, MethodFragmentImpl.class);
        put(MethodInvocation.Builder.class, MethodInvocationImpl.class);
        put(MethodSpecification.Builder.class, MethodSpecificationImpl.class);
        put(Operate.Builder.class, OperateImpl.class);
        put(Plain.Builder.class, PlainImpl.class);
        put(Return.Builder.class, ReturnImpl.class);
        put(StaticBlock.Builder.class, StaticBlockImpl.class);
        put(SwitchStatement.Builder.class, SwitchStatementImpl.class);
        put(ThrowException.Builder.class, ThrowExceptionImpl.class);
        put(TryStatement.Builder.class, TryStatementImpl.class);
        put(TryWithResources.Builder.class, TryWithResourcesImpl.class);
        put(VariableAccess.Builder.class, VariableAccessImpl.class);
        put(VariableDeclaration.Builder.class, VariableDeclarationImpl.class);
        put(VariableDefinition.Builder.class, VariableDefinitionImpl.class);
        put(WhileStatement.Builder.class, WhileStatementImpl.class);
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
