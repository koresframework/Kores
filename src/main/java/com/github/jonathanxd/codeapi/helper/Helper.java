/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.IterationType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.MethodFragmentImpl;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.Expression;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.Group;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.VariableStore;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.keywords.Keywords;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;
import com.github.jonathanxd.codeapi.types.NullType;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.WeakValueHashMap;

import org.objectweb.asm.Type;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 07/05/16.
 */
public final class Helper {

    private final static WeakValueHashMap<Class<?>, CodeType> CODE_TYPES_CACHE = new WeakValueHashMap<>();

    private static final None NONE = new None();

    /**
     * Access local variable. Same as {@code null}.
     *
     * @return Access to local variable. Same as {@code null}.
     */
    public static Access accessLocal() {
        return new AccessLocalEx();
    }

    public static ArrayLoad accessArrayValue(CodePart target, CodePart index, CodeType valueType) {
        return new ArrayLoadEx(index, target, valueType);
    }

    public static ArrayLength arrayLength(CodePart target) {
        return new ArrayLengthEx(target);
    }

    public static VariableAccess accessLocalVariable(String name) {
        return accessVariable(null, accessLocal(), name);
    }

    public static VariableAccess accessLocalVariable(String name, CodeType type) {
        return accessVariable(null, accessLocal(), name, type);
    }

    public static VariableAccess accessLocalVariable(String name, Class<?> type) {
        return accessVariable(null, accessLocal(), name, Helper.getJavaType(type));
    }

    public static VariableAccess accessLocalVariable(FieldDeclaration fieldVariable) {
        return accessVariable(null, accessLocal(), fieldVariable.getName(), fieldVariable.getType().orElse(PredefinedTypes.OBJECT));
    }

    public static VariableAccess accessLocalVariable(VariableStore variableStore) {
        return accessVariable(null, accessLocal(), variableStore.getName(), variableStore.getVariableType());
    }


    public static VariableAccess accessStaticVariable(Class<?> localization, String name, Class<?> variableType) {
        return new SimpleVariableAccess(getJavaType(localization), name, getJavaType(variableType));
    }

    public static VariableAccess accessStaticVariable(Class<?> localization, String name, CodeType variableType) {
        return new SimpleVariableAccess(getJavaType(localization), name, variableType);
    }

    public static VariableAccess accessStaticVariable(CodeType localization, String name, CodeType variableType) {
        return new SimpleVariableAccess(localization, name, variableType);
    }

    public static AccessSuper accessSuper() {
        return new AccessSuperEx();
    }

    public static AccessSuper accessSuper(CodeType at) {
        return new AccessSuperEx(at);
    }

    public static AccessThis accessThis() {
        return new AccessThisEx();
    }

    public static AccessThis accessThis(CodeType at) {
        return new AccessThisEx(at);
    }

    public static VariableAccess accessVariable(VariableStore variableStore) {
        return accessVariable(variableStore.getLocalization(), variableStore.getAt(), variableStore.getName(), variableStore.getVariableType());
    }

    public static VariableAccess accessVariable(CodeType localization, CodePart at, String name) {
        return new SimpleVariableAccess(localization, at, name, null);
    }

    public static VariableAccess accessVariable(CodeType localization, CodePart at, String name, CodeType variableType) {
        return new SimpleVariableAccess(localization, at, name, variableType);
    }

    public static VariableAccess accessVariable(CodeType localization, String name) {
        return new SimpleVariableAccess(localization, name, null);
    }

    public static VariableAccess accessVariable(CodeType localization, String name, CodeType variableType) {
        return new SimpleVariableAccess(localization, name, variableType);
    }

    public static VariableAccess accessVariable(CodeType localization, String name, Class<?> variableType) {
        return new SimpleVariableAccess(localization, name, getJavaType(variableType));
    }

    public static VariableAccess accessVariable(Class<?> localization, String name, Class<?> variableType) {
        return new SimpleVariableAccess(getJavaType(localization), name, getJavaType(variableType));
    }

    /////////// OPERATE VARIABLES
    public static VariableOperate operateVariable(VariableStore variableStore, Operator operation) {
        return operateVariable(variableStore.getLocalization(), variableStore.getAt(), variableStore.getName(), variableStore.getVariableType(), operation);
    }

    public static VariableOperate operateVariable(CodeType localization, CodePart at, String name, CodeType variableType, Operator operation) {
        return new SimpleVariableOperate(localization, at, name, variableType, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Operator operation) {
        return new SimpleVariableOperate(localization, name, null, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, CodeType variableType, Operator operation) {
        return new SimpleVariableOperate(localization, name, variableType, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Class<?> variableType, Operator operation) {
        return new SimpleVariableOperate(localization, name, getJavaType(variableType), operation, null);
    }

    public static VariableOperate operateVariable(Class<?> localization, String name, Class<?> variableType, Operator operation) {
        return new SimpleVariableOperate(getJavaType(localization), name, getJavaType(variableType), operation, null);
    }

    /////////// WITH VALUE

    public static VariableOperate operateVariable(VariableStore variableStore, Operator operation, CodePart value) {
        return operateVariable(variableStore.getLocalization(), variableStore.getAt(), variableStore.getName(), variableStore.getVariableType(), operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, CodePart at, String name, CodeType variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(localization, at, name, variableType, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Operator operation, CodePart value) {
        return new SimpleVariableOperate(localization, name, null, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, CodeType variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(localization, name, variableType, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Class<?> variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(localization, name, getJavaType(variableType), operation, value);
    }

    public static VariableOperate operateVariable(Class<?> localization, String name, Class<?> variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(getJavaType(localization), name, getJavaType(variableType), operation, value);
    }


    //////////// Other

    public static VariableOperate operateLocalVariable(String name, Class<?> variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(null, accessLocal(), name, getJavaType(variableType), operation, value);
    }

    public static VariableOperate operateLocalVariable(String name, CodeType variableType, Operator operation, CodePart value) {
        return new SimpleVariableOperate(null, accessLocal(), name, variableType, operation, value);
    }

    public static VariableOperate operateLocalVariable(String name, Class<?> variableType, Operator operation) {
        return new SimpleVariableOperate(null, accessLocal(), name, getJavaType(variableType), operation, null);
    }

    public static VariableOperate operateLocalVariable(String name, CodeType variableType, Operator operation) {
        return new SimpleVariableOperate(null, accessLocal(), name, variableType, operation, null);
    }

    public static VariableOperate operateLocalVariable(FieldDeclaration fieldDeclaration, Operator operation, CodePart value) {
        return new SimpleVariableOperate(null, accessLocal(), fieldDeclaration.getName(), fieldDeclaration.getVariableType(), operation, value);
    }

    public static VariableOperate operateLocalVariable(FieldDeclaration fieldDeclaration, Operator operation) {
        return new SimpleVariableOperate(null, accessLocal(), fieldDeclaration.getName(), fieldDeclaration.getVariableType(), operation, null);
    }

    /////////// OPERATE VARIABLES

    public static CodePart cast(CodeType originalType, CodeType type, CodePart castedPart) {
        return new CastedExPart(originalType, type, castedPart);
    }

    @SuppressWarnings("unchecked")
    public static CatchBlock catchBlock(List<CodeType> catchExceptions, String variable, CodeSource body) {

        return new CatchExBlock(variable, catchExceptions, body);
    }

    public static IfExpr check(CodePart expr1, Operator operation, CodePart expr2) {
        return new IfExprEx(expr1, operation, expr2);
    }

    public static IfExpr checkNotNull(CodePart expr1) {
        return check(expr1, Operators.NOT_EQUAL_TO, Literals.NULL);
    }

    // TODO: need review: USING KEYWORDS, I CANNOT GENERATE BYTECODE USING KEYWORDS
    @Deprecated
    public static CodePart construct(InvokeType invokeType, CodeType localization, CodePart firstExpression, CodeType type) {
        return new MethodInvocationImpl(invokeType, localization, expression(firstExpression, expression(Keywords.NEW)), new MethodSpec(type, Collections.emptyList(), MethodType.CONSTRUCTOR));
    }

    public static CodePart createDoWhile(CodeSource body, BiMultiVal<CodePart, IfExpr, Operator> expression) {
        return new SimpleExDoWhileBlock(expression, body);
    }

    public static ForBlock createFor(Expression initialization, BiMultiVal<CodePart, IfExpr, Operator> expression, Expression update, CodeSource body) {
        return new SimpleForBlock(initialization, expression, update, body);
    }

    public static ForBlock createFor(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> expression, CodePart update, CodeSource body) {

        return new SimpleForBlock(initialization, expression, update, body);
    }

    public static ForEachBlock createForEach(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockEx(field, IterationType.ITERABLE_ELEMENT, expression, body);
    }

    public static ForEachBlock createForEachArray(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockEx(field, IterationType.ARRAY, expression, body);
    }

    public static ForEachBlock createForEachIterable(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockEx(field, IterationType.ITERABLE_ELEMENT, expression, body);
    }

    public static WhileBlock createWhile(BiMultiVal<CodePart, IfExpr, Operator> expression, CodeSource body) {
        return new SimpleExWhileBlock(expression, body);
    }

    public static ElseBlock elseExpression(CodeSource elseSource) {
        return new SimpleElseBlock(elseSource);
    }
    /*
    public static IfBlock ifExpression(MultiVal<Group> groups, CodeSource body, ElseBlock elseBlock) {
        IfBlock ifBlock = new SimpleIfBlock();

        ifBlock.addAll(StorageKeys.GROUPS, groups.iterator());

        ifBlock.setBody(body);



        return ifBlock;
    }*/

    public static Expression end(CodePart expression) {
        return new NonExpressionExpr(expression);
    }

    // TODO: MISSION: REMOVE ALL EXPRESSIONS :D
    public static Expression expression(CodePart expression, Expression nestedExpression) {
        return new SimpleExpression(expression, nestedExpression, false);
    }

    public static Expression expression(CodePart expression) {
        return new SimpleExpression(expression, null, false);
    }

    public static Expression expressions(CodePart expression, CodePart... moreExpressions) {

        if (moreExpressions.length == 0)
            return expression(expression);

        DynamicExpression base = new DynamicExpression(expression, null);

        DynamicExpression current = base;

        for (int i = 0; i < moreExpressions.length; i++) {
            CodePart atI = moreExpressions[i];

            DynamicExpression newDynamicExpression = new DynamicExpression(atI, null);

            current.setNextExpression(newDynamicExpression);

            current = newDynamicExpression;

        }

        return base;
    }

    @SuppressWarnings("unchecked")
    public static <T> LoadedCodeType<T> getJavaType(Class<T> aClass) {

        if(aClass.isArray())
            return getJavaType0(aClass);

        if (CODE_TYPES_CACHE.containsKey(aClass)) {
            CodeType codeType = CODE_TYPES_CACHE.get(aClass);

            if (codeType != null && codeType instanceof LoadedCodeType)
                return (LoadedCodeType<T>) codeType;
        }

        JavaType<T> javaType = new JavaType<>(aClass);

        CODE_TYPES_CACHE.put(aClass, javaType);

        return javaType;

    }

    @SuppressWarnings("unchecked")
    private static <T> LoadedCodeType<T> getJavaType0(Class<T> aClass) {

        if (CODE_TYPES_CACHE.containsKey(aClass)) {
            CodeType codeType = CODE_TYPES_CACHE.get(aClass);

            if (codeType != null && codeType instanceof LoadedCodeType)
                return (LoadedCodeType<T>) codeType;
        }

        LoadedCodeType<T> type = new JavaType<>(aClass);

        if(aClass.isArray()) {
            Class<?> component = aClass;

            int dimensions = 0;

            do {
                ++ dimensions;
            }while ((component = component.getComponentType()).isArray());

            type = new JavaType<>((Class<T>) component).toLoadedArray(aClass, dimensions);
        }

        CODE_TYPES_CACHE.put(aClass, type);

        return type;

    }

    public static CodeType getJavaArrayType(Class<?> aClass) {
        return Helper.getJavaType0(aClass);
    }

    public static CodeType[] getJavaArrayTypes(Class<?>[] classes) {
        return Arrays.stream(classes).map(Helper::getJavaArrayType).toArray(CodeType[]::new);
    }

    @SuppressWarnings("unchecked")
    public static LoadedCodeType<?>[] getJavaTypes(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).toArray(LoadedCodeType[]::new);

    }

    public static <ID, T extends CodePart> TagLine<ID, T> tagLine(ID identification, T value) {
        return new TagLineEx<>(identification, value);
    }

    public static Group group(Expression expression) {
        return new SimpleGroup(expression);
    }

    public static BiMultiVal.Adder<CodePart, IfExpr, Operator> createIfVal() {
        return BiMultiVal.create(CodePart.class, IfExpr.class, Operator.class);
    }

    public static IfBlock ifExpression(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body /*, ElseBlock else*/) {
        return new SimpleIfBlock(body, groups, null);
    }

    public static IfBlock ifExpression(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, ElseBlock elseBlock) {
        return new SimpleIfBlock(body, groups, elseBlock);
    }

    public static MethodInvocation invokeDynamicFragment(InvokeDynamic.LambdaFragment dynamicInvoke) {
        MethodFragment methodFragment = dynamicInvoke.getMethodFragment();

        MethodSpec spec = methodFragment.getSpec();


        MethodSpec newSpec = new MethodSpec(spec.getMethodName(), spec.getArguments(), spec.getMethodDescription(), spec.getMethodType().toDynamic());

        return new MethodInvocationImpl(dynamicInvoke,
                methodFragment.getInvokeType(),
                methodFragment.getLocalization(),
                methodFragment.getTarget(),
                newSpec);
    }

    public static MethodInvocation invokeDynamic(InvokeDynamic dynamicInvoke, MethodInvocation methodInvocation) {
        MethodSpec spec = methodInvocation.getSpec();

        MethodSpec newSpec = new MethodSpec(spec.getMethodName(), spec.getArguments(), spec.getMethodDescription(), spec.getMethodType().toDynamic());

        return new MethodInvocationImpl(dynamicInvoke, methodInvocation.getInvokeType(), methodInvocation.getLocalization(), methodInvocation.getTarget(),
                newSpec);
    }

    public static MethodFragment methodFragment(CodeInterface codeInterface, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return new MethodFragmentImpl(codeInterface, scope, returnType, parameters, arguments, body);
    }

    //invoke(Helper.accessThis(), Helper.none(), Helper.methodSpec());

    public static MethodInvocation invoke(InvokeType invokeType, CodeType localization, CodePart target, MethodSpec methodSpec) {
        return new MethodInvocationImpl(invokeType, localization, target, methodSpec);
    }

    public static MethodInvocation invoke(InvokeType invokeType, Class<?> localization, CodePart target, MethodSpec methodSpec) {
        return new MethodInvocationImpl(invokeType, getJavaType(localization), target, methodSpec);
    }

    public static MethodInvocation invokeSuper(CodeType localization, MethodSpec methodSpec) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(), methodSpec);
    }

    public static MethodInvocation invokeSuperInit(CodeType localization, CodeArgument... arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(),
                new MethodSpec("<init>", PredefinedTypes.VOID, Arrays.asList(arguments)));
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type) {
        return new ArrayConstructorEx(type, new CodePart[]{}, null);
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodeArgument[] arguments) {
        return new ArrayConstructorEx(type, new CodePart[]{Literals.INT(arguments.length)}, Arrays.asList(arguments));
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodePart[] dimensions) {
        return new ArrayConstructorEx(type, dimensions, null);
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodePart[] dimensions, CodeArgument[] arguments) {
        return new ArrayConstructorEx(type, dimensions, Arrays.asList(arguments));
    }

    public static MethodInvocation invokeConstructor(InvokeType invokeType, CodeType localization, CodePart target, MethodSpec methodSpec) {
        return new MethodInvocationImpl(invokeType, localization, expressions(Keywords.NEW, target), methodSpec);
    }

    public static MethodInvocation invokeConstructor(CodeType type) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, type, type, new MethodSpec(MethodType.CONSTRUCTOR));
    }

    public static MethodInvocation invokeConstructor(CodeType type, CodeArgument[] arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, type, type, new MethodSpec(Arrays.asList(arguments), MethodType.CONSTRUCTOR));
    }

    public static boolean isNone(CodePart codePart) {
        return codePart == NONE;
    }

    public static boolean isNone(Named named) {
        return named == NONE;
    }

    public static CodeType localizedAtType(CodeType type) {
        return type;
    }

    @SuppressWarnings("unchecked")
    public static <T extends CodePart & Named> T none() {
        return (T) NONE;
    }

    public static CodeType nullType() {
        return NullType.getNullType();
    }

    public static Return returnValue(CodeType returnType, CodePart value) {
        return new ReturnEx(returnType, value);
    }

    public static ArrayStore setArrayValue(CodePart target, CodePart index, CodeType valueType, CodePart value) {
        return new ArrayStoreEx(index, target, valueType, value);
    }

    public static VariableStore setVariable(CodeType localization, CodePart at, String variable, CodePart value) {
        return new SimpleVariableStore(localization, at, variable, null, value);
    }

    public static VariableStore setVariable(CodeType localization, CodePart at, String variable, CodeType varType, CodePart value) {
        return new SimpleVariableStore(localization, at, variable, varType, value);
    }

    public static VariableStore setVariable(CodeType localization, String variable, CodePart value) {
        return new SimpleVariableStore(localization, null, variable, null, value);
    }

    public static VariableStore setVariable(CodeType localization, String variable, CodeType varType, CodePart value) {
        return new SimpleVariableStore(localization, null, variable, varType, value);
    }

    public static VariableStore setLocalVariable(String variable, CodeType varType, CodePart value) {
        return new SimpleVariableStore(null, accessLocal(), variable, varType, value);
    }

    public static VariableStore setLocalVariable(String variable, Class<?> varType, CodePart value) {
        return new SimpleVariableStore(null, accessLocal(), variable, Helper.getJavaType(varType), value);
    }

    public static VariableStore setThisVariable(String variable, CodeType varType, CodePart value) {
        return new SimpleVariableStore(null, accessThis(), variable, varType, value);
    }

    public static VariableStore setThisVariable(String variable, Class<?> varType, CodePart value) {
        return new SimpleVariableStore(null, accessThis(), variable, Helper.getJavaType(varType), value);
    }

    public static VariableAccess simpleVariable(String name) {
        return new SimpleVariableAccess(null, name, null);
    }

    public static CodePart simpleVariable(String name, CodeType type) {
        return new SimpleVariableAccess(null, name, type);
    }

    public static CodeSource sourceOf(CodePart... parts) {
        CodeSource source = new CodeSource();

        for (CodePart part : parts) {
            source.add(part);
        }

        return source;
    }

    public static CodeElement staticBlock(CodeSource body) {
        SimpleStaticBlock simpleStaticBlock = new SimpleStaticBlock(body);
        return simpleStaticBlock;
    }

    public static TryCatchBlock surround(CodePart toSurround, List<CatchBlock> catchBlocks) {

        return new TryCatchBlock(null, catchBlocks, sourceOf(toSurround));
    }

    public static TryCatchBlock surround(CodeSource toSurround, List<CatchBlock> catchBlocks) {

        return new TryCatchBlock(null, catchBlocks, toSurround);
    }

    public static TryCatchBlock surround(CodePart toSurround, List<CatchBlock> catchBlocks, CodeSource finallyBlock) {

        return new TryCatchBlock(null, catchBlocks, sourceOf(toSurround), finallyBlock);
    }

    public static TryCatchBlock surround(CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallyBlock) {

        return new TryCatchBlock(null, catchBlocks, toSurround, finallyBlock);
    }

    public static ThrowException throwException(CodeType exception, CodeArgument[] arguments) {
        return new ThrowExceptionEx(exception, Arrays.asList(arguments));
    }

    public static TryBlock tryCatchBlock(CodePart expression) {
        return new TryCatchBlock(expression, new CodeSource());
    }

    public static TryBlock tryCatchBlock(CodePart expression, List<CatchBlock> catchBlocks) {
        return new TryCatchBlock(expression, catchBlocks, new CodeSource());
    }
    /*
    public static IfBlock ifExpression(MultiVal<Group> groups, CodeSource body, ElseBlock elseBlock) {
        IfBlock ifBlock = new SimpleIfBlock();

        ifBlock.addAll(StorageKeys.GROUPS, groups.iterator());

        ifBlock.setBody(body);



        return ifBlock;
    }*/
    public static final BiMultiVal.Adder<CodePart, IfExpr, Operator> IF_EXPR = new ExpressionAdder(CodePart.class);

    public static final class ExpressionAdder extends BiMultiVal.Adder<CodePart, IfExpr, Operator> {

        ExpressionAdder(Class<CodePart> baseType) {
            super(baseType);
        }
    }

    @GenerateTo(CodeType.class)
    final private static class JavaType<T> implements LoadedCodeType<T> {
        private final Class<T> type;

        private JavaType(Class<T> type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (obj instanceof Class) {
                return this.type.equals(obj);
            }

            if (obj instanceof LoadedCodeType) {
                return this.type.equals(((LoadedCodeType) obj).getLoadedType());
            }

            if (obj instanceof CodeType) {
                return this.getJavaSpecName().equals(((CodeType) obj).getJavaSpecName());
            }

            return super.equals(obj);
        }

        @Override
        public String getJavaSpecName() {
            return Type.getDescriptor(type);
        }

        @Override
        public String getType() {
            return Type.getType(type).getClassName();
        }

        @Override
        public String getCanonicalName() {
            return this.type.getCanonicalName();
        }

        @Override
        public int hashCode() {
            return type.hashCode();
        }

        @Override
        public boolean isInterface() {
            return type.isInterface();
        }

        @Override
        public boolean isPrimitive() {
            return type.isPrimitive();
        }

        @Override
        public Class<T> getLoadedType() {
            return this.type;
        }

        @Override
        public boolean isVirtual() {
            return false;
        }

        @Override
        public String toString() {
            return this.getJavaSpecName();
        }
    }

    final private static class None implements CodePart, Named {

        @Override
        public String getName() {
            throw new IllegalStateException("Empty element");
        }

        @Override
        public boolean isExpression() {
            throw new IllegalStateException("Empty element");
        }
    }

    @GenerateTo(Expression.class)
    private static final class NonExpressionExpr extends SimpleExpression {

        public NonExpressionExpr(CodePart expression) {
            this(expression, null);
        }

        public NonExpressionExpr(CodePart expression, Expression nextExpression) {
            super(expression, nextExpression, true);
        }

        @Override
        public boolean isCodeBlock() {
            return true;
        }

    }

}
