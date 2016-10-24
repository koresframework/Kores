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
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.IterationType;
import com.github.jonathanxd.codeapi.common.IterationTypes;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.impl.AccessInnerImpl;
import com.github.jonathanxd.codeapi.impl.AccessLocalImpl;
import com.github.jonathanxd.codeapi.impl.AccessOuterImpl;
import com.github.jonathanxd.codeapi.impl.AccessSuperImpl;
import com.github.jonathanxd.codeapi.impl.AccessThisImpl;
import com.github.jonathanxd.codeapi.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.impl.ArrayLengthImpl;
import com.github.jonathanxd.codeapi.impl.ArrayLoadImpl;
import com.github.jonathanxd.codeapi.impl.ArrayStoreImpl;
import com.github.jonathanxd.codeapi.impl.CaseImpl;
import com.github.jonathanxd.codeapi.impl.CastedImpl;
import com.github.jonathanxd.codeapi.impl.CatchBlockImpl;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.DoWhileBlockImpl;
import com.github.jonathanxd.codeapi.impl.ElseBlockImpl;
import com.github.jonathanxd.codeapi.impl.ForBlockImpl;
import com.github.jonathanxd.codeapi.impl.ForEachBlockImpl;
import com.github.jonathanxd.codeapi.impl.IfBlockImpl;
import com.github.jonathanxd.codeapi.impl.IfExprImpl;
import com.github.jonathanxd.codeapi.impl.InstanceOfImpl;
import com.github.jonathanxd.codeapi.impl.MethodFragmentImpl;
import com.github.jonathanxd.codeapi.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.impl.ReturnImpl;
import com.github.jonathanxd.codeapi.impl.StaticBlockImpl;
import com.github.jonathanxd.codeapi.impl.SwitchImpl;
import com.github.jonathanxd.codeapi.impl.TagLineImpl;
import com.github.jonathanxd.codeapi.impl.ThrowExceptionImpl;
import com.github.jonathanxd.codeapi.impl.TryBlockImpl;
import com.github.jonathanxd.codeapi.impl.TryWithResourcesImpl;
import com.github.jonathanxd.codeapi.impl.VariableAccessImpl;
import com.github.jonathanxd.codeapi.impl.VariableDeclarationImpl;
import com.github.jonathanxd.codeapi.impl.VariableOperateImpl;
import com.github.jonathanxd.codeapi.impl.WhileBlockImpl;
import com.github.jonathanxd.codeapi.interfaces.Access;
import com.github.jonathanxd.codeapi.interfaces.AccessInner;
import com.github.jonathanxd.codeapi.interfaces.AccessOuter;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.InstanceOf;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.Named;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.Switch;
import com.github.jonathanxd.codeapi.interfaces.TagLine;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.interfaces.TryWithResources;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.LoadedCodeType;
import com.github.jonathanxd.codeapi.types.NullType;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.iutils.map.WeakValueHashMap;

import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Helper class (not backward compatible, this class may change constantly).
 *
 * If you want a stable factory use: {@link com.github.jonathanxd.codeapi.CodeAPI}.
 *
 * This class is not documented.
 */
public final class Helper {

    public static final BiMultiVal.Adder<CodePart, IfExpr, Operator> IF_EXPR = new ExpressionAdder(CodePart.class);
    private final static WeakValueHashMap<Class<?>, CodeType> CODE_TYPES_CACHE = new WeakValueHashMap<>();
    private static final None NONE = new None();

    /**
     * Access local variable. Same as {@code null}.
     *
     * @return Access to local variable. Same as {@code null}.
     */
    public static Access accessLocal() {
        return new AccessLocalImpl();
    }

    public static ArrayLoad accessArrayValue(CodePart target, CodePart index, CodeType valueType) {
        return new ArrayLoadImpl(index, target, valueType);
    }

    public static ArrayLength arrayLength(CodePart target) {
        return new ArrayLengthImpl(target);
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

    public static VariableAccess accessLocalVariable(VariableDeclaration variableDeclaration) {
        return accessVariable(null, accessLocal(), variableDeclaration.getName(), variableDeclaration.getVariableType());
    }

    public static VariableAccess accessStaticVariable(Class<?> localization, String name, Class<?> variableType) {
        return new VariableAccessImpl(getJavaType(localization), name, getJavaType(variableType));
    }

    public static VariableAccess accessStaticVariable(Class<?> localization, String name, CodeType variableType) {
        return new VariableAccessImpl(getJavaType(localization), name, variableType);
    }

    public static VariableAccess accessStaticVariable(CodeType localization, String name, CodeType variableType) {
        return new VariableAccessImpl(localization, name, variableType);
    }

    public static AccessSuper accessSuper() {
        return new AccessSuperImpl();
    }

    /*public static AccessSuper accessSuper(CodeType at) {
        return new AccessSuperImpl(at);
    }*/

    public static AccessThis accessThis() {
        return new AccessThisImpl();
    }

    public static AccessInner accessInner(CodeType at) {
        return new AccessInnerImpl(at);
    }
    public static AccessOuter accessOuter(CodeType at) {
        return new AccessOuterImpl(at);
    }

    public static VariableAccess accessVariable(VariableDeclaration variableDeclaration) {
        return accessVariable(variableDeclaration.getLocalization().orElse(null), variableDeclaration.getTarget().orElse(null), variableDeclaration.getName(), variableDeclaration.getVariableType());
    }

    public static VariableAccess accessVariable(CodeType localization, CodePart at, String name) {
        return new VariableAccessImpl(localization, at, name, null);
    }

    public static VariableAccess accessVariable(CodeType localization, CodePart at, String name, CodeType variableType) {
        return new VariableAccessImpl(localization, at, name, variableType);
    }

    public static VariableAccess accessVariable(CodeType localization, String name) {
        return new VariableAccessImpl(localization, name, null);
    }

    public static VariableAccess accessVariable(CodeType localization, String name, CodeType variableType) {
        return new VariableAccessImpl(localization, name, variableType);
    }

    public static VariableAccess accessVariable(CodeType localization, String name, Class<?> variableType) {
        return new VariableAccessImpl(localization, name, getJavaType(variableType));
    }

    public static VariableAccess accessVariable(Class<?> localization, String name, Class<?> variableType) {
        return new VariableAccessImpl(getJavaType(localization), name, getJavaType(variableType));
    }

    /////////// OPERATE VARIABLES
    public static VariableOperate operateVariable(VariableDeclaration variableDeclaration, Operator operation) {
        return operateVariable(variableDeclaration.getLocalization().orElse(null), variableDeclaration.getTarget().orElse(null), variableDeclaration.getName(), variableDeclaration.getVariableType(), operation);
    }

    public static VariableOperate operateVariable(CodeType localization, CodePart at, String name, CodeType variableType, Operator operation) {
        return new VariableOperateImpl(localization, at, name, variableType, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Operator operation) {
        return new VariableOperateImpl(localization, name, null, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, CodeType variableType, Operator operation) {
        return new VariableOperateImpl(localization, name, variableType, operation, null);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Class<?> variableType, Operator operation) {
        return new VariableOperateImpl(localization, name, getJavaType(variableType), operation, null);
    }

    /////////// WITH VALUE

    public static VariableOperate operateVariable(Class<?> localization, String name, Class<?> variableType, Operator operation) {
        return new VariableOperateImpl(getJavaType(localization), name, getJavaType(variableType), operation, null);
    }

    public static VariableOperate operateVariable(VariableDeclaration variableDeclaration, Operator operation, CodePart value) {
        return operateVariable(variableDeclaration.getLocalization().orElse(null), variableDeclaration.getTarget().orElse(null), variableDeclaration.getName(), variableDeclaration.getVariableType(), operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, CodePart at, String name, CodeType variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(localization, at, name, variableType, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Operator operation, CodePart value) {
        return new VariableOperateImpl(localization, name, null, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, CodeType variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(localization, name, variableType, operation, value);
    }

    public static VariableOperate operateVariable(CodeType localization, String name, Class<?> variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(localization, name, getJavaType(variableType), operation, value);
    }


    //////////// Other

    public static VariableOperate operateVariable(Class<?> localization, String name, Class<?> variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(getJavaType(localization), name, getJavaType(variableType), operation, value);
    }

    public static VariableOperate operateLocalVariable(String name, Class<?> variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(null, accessLocal(), name, getJavaType(variableType), operation, value);
    }

    public static VariableOperate operateLocalVariable(String name, CodeType variableType, Operator operation, CodePart value) {
        return new VariableOperateImpl(null, accessLocal(), name, variableType, operation, value);
    }

    public static VariableOperate operateLocalVariable(String name, Class<?> variableType, Operator operation) {
        return new VariableOperateImpl(null, accessLocal(), name, getJavaType(variableType), operation, null);
    }

    public static VariableOperate operateLocalVariable(String name, CodeType variableType, Operator operation) {
        return new VariableOperateImpl(null, accessLocal(), name, variableType, operation, null);
    }

    public static VariableOperate operateLocalVariable(FieldDeclaration fieldDeclaration, Operator operation, CodePart value) {
        return new VariableOperateImpl(null, accessLocal(), fieldDeclaration.getName(), fieldDeclaration.getVariableType(), operation, value);
    }

    /////////// OPERATE VARIABLES

    public static VariableOperate operateLocalVariable(FieldDeclaration fieldDeclaration, Operator operation) {
        return new VariableOperateImpl(null, accessLocal(), fieldDeclaration.getName(), fieldDeclaration.getVariableType(), operation, null);
    }


    public static CodeMethod bridgeMethod(CodeMethod current, FullMethodSpec methodSpec) {
        List<CodeType> parameterTypes = methodSpec.getParameterTypes();
        List<CodeParameter> currentParameters = current.getParameters();

        if (parameterTypes.size() > currentParameters.size())
            throw new IllegalArgumentException("Specified target method has more parameters than current method!");

        CodeType currentReturnType = current.getReturnType().orElse(PredefinedTypes.VOID);

        boolean return_ = !currentReturnType.is(PredefinedTypes.VOID);

        List<CodeParameter> codeParameters = new ArrayList<>();
        List<CodeArgument> codeArguments = new ArrayList<>();

        for (int i = 0; i < currentParameters.size(); i++) {
            CodeParameter currentParameter = currentParameters.get(i);
            CodeType currentType = currentParameter.getRequiredType();
            CodeType targetType = parameterTypes.get(i);

            codeParameters.add(new CodeParameter(currentParameter.getName(), targetType));

            codeArguments.add(new CodeArgument(
                    Helper.cast(targetType, currentType, Helper.accessLocalVariable(currentParameter.getName(), targetType)), currentType
            ));
        }


        CodePart toAdd = Helper.invoke((InvokeType) null, (CodeType) null, Helper.accessThis(),
                new MethodSpecImpl(methodSpec.getMethodName(), methodSpec.getReturnType(), codeArguments));

        if (return_) {
            toAdd = Helper.returnValue(methodSpec.getReturnType(), Helper.cast(currentReturnType, methodSpec.getReturnType(), toAdd));
        }

        List<CodeModifier> codeModifiers = new ArrayList<>(current.getModifiers());

        codeModifiers.add(CodeModifier.BRIDGE);

        return new CodeMethod(methodSpec.getMethodName(),
                codeModifiers,
                codeParameters,
                currentReturnType,
                Helper.sourceOf(
                        toAdd
                ));
    }

    public static Switch aSwitch(SwitchType switchType, Typed value, List<Case> caseList) {
        return new SwitchImpl(switchType, value, caseList);
    }


    public static Case aCase(Typed value, CodeSource body) {
        return new CaseImpl(value, body);
    }

    public static Casted cast(CodeType originalType, CodeType type, CodePart castedPart) {
        return new CastedImpl(originalType, type, castedPart);
    }

    @SuppressWarnings("unchecked")
    public static CatchBlock catchBlock(List<CodeType> catchExceptions, String variable, CodeSource body) {

        return new CatchBlockImpl(new CodeField(variable, PredefinedTypes.THROWABLE), catchExceptions, body);
    }

    public static CatchBlock catchBlock(List<CodeType> catchExceptions, CodeField variable, CodeSource body) {

        return new CatchBlockImpl(variable, catchExceptions, body);
    }

    public static IfExpr check(CodePart expr1, Operator operation, CodePart expr2) {
        return new IfExprImpl(expr1, operation, expr2);
    }

    public static IfExpr checkNotNull(CodePart expr1) {
        return check(expr1, Operators.NOT_EQUAL_TO, Literals.NULL);
    }

    public static IfExpr checkNull(CodePart expr1) {
        return check(expr1, Operators.EQUAL_TO, Literals.NULL);
    }

    public static DoWhileBlock createDoWhile(CodeSource body, BiMultiVal<CodePart, IfExpr, Operator> expression) {
        return new DoWhileBlockImpl(expression, body);
    }

    public static ForBlock createFor(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> expression, CodePart update, CodeSource body) {

        return new ForBlockImpl(initialization, expression, update, body);
    }

    public static ForEachBlock createForEach(FieldDeclaration field, IterationType iterationType, CodePart expression, CodeSource body) {
        return new ForEachBlockImpl(field, iterationType, expression, body);
    }

    public static ForEachBlock createForEach(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockImpl(field, IterationTypes.ITERABLE_ELEMENT, expression, body);
    }

    public static ForEachBlock createForEachArray(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockImpl(field, IterationTypes.ARRAY, expression, body);
    }

    public static ForEachBlock createForEachIterable(FieldDeclaration field, CodePart expression, CodeSource body) {
        return new ForEachBlockImpl(field, IterationTypes.ITERABLE_ELEMENT, expression, body);
    }

    public static WhileBlock createWhile(BiMultiVal<CodePart, IfExpr, Operator> expression, CodeSource body) {
        return new WhileBlockImpl(expression, body);
    }

    public static ElseBlock elseExpression(CodeSource elseSource) {
        return new ElseBlockImpl(elseSource);
    }

    @SuppressWarnings("unchecked")
    public static <T> LoadedCodeType<T> getJavaType(Class<T> aClass) {

        if (aClass.isArray())
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

        if (aClass.isArray()) {
            Class<?> component = aClass;

            int dimensions = 0;

            do {
                ++dimensions;
            } while ((component = component.getComponentType()).isArray());

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
        return new TagLineImpl<>(identification, value);
    }

    public static BiMultiVal.Adder<CodePart, IfExpr, Operator> createIfVal() {
        return BiMultiVal.create(CodePart.class, IfExpr.class, Operator.class);
    }

    public static IfBlock ifExpression(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body /*, ElseBlock else*/) {
        return new IfBlockImpl(body, groups, null);
    }

    public static IfBlock ifExpression(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, ElseBlock elseBlock) {
        return new IfBlockImpl(body, groups, elseBlock);
    }

    public static MethodInvocation invokeDynamicFragment(InvokeDynamic.LambdaFragment dynamicInvoke) {
        MethodFragment methodFragment = dynamicInvoke.getMethodFragment();

        MethodSpecification spec = methodFragment.getSpec();


        MethodSpecImpl newSpec = new MethodSpecImpl(spec.getMethodName(), spec.getArguments(), spec.getMethodDescription(), spec.getMethodType().toDynamic());

        return new MethodInvocationImpl(dynamicInvoke,
                methodFragment.getInvokeType(),
                methodFragment.getLocalization().orElse(null),
                methodFragment.getTarget().orElse(null),
                newSpec);
    }

    public static MethodInvocation invokeDynamic(InvokeDynamic dynamicInvoke, MethodInvocation methodInvocation) {
        MethodSpecification spec = methodInvocation.getSpec();

        MethodSpecImpl newSpec = new MethodSpecImpl(spec.getMethodName(), spec.getArguments(), spec.getMethodDescription(), spec.getMethodType().toDynamic());

        return new MethodInvocationImpl(dynamicInvoke, methodInvocation.getInvokeType(), methodInvocation.getLocalization().orElse(null), methodInvocation.getTarget().orElse(null),
                newSpec);
    }

    //invoke(Helper.accessThis(), Helper.none(), Helper.methodSpec());

    public static MethodFragment methodFragment(CodeInterface codeInterface, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return new MethodFragmentImpl(codeInterface, scope, returnType, parameters, arguments, body);
    }

    public static MethodInvocation invoke(InvokeType invokeType, CodeType localization, CodePart target, MethodSpecImpl methodSpecImpl) {
        return new MethodInvocationImpl(invokeType, localization, target, methodSpecImpl);
    }

    public static MethodInvocation invoke(InvokeType invokeType, Class<?> localization, CodePart target, MethodSpecImpl methodSpecImpl) {
        return new MethodInvocationImpl(invokeType, getJavaType(localization), target, methodSpecImpl);
    }

    public static MethodInvocation invokeSuper(CodeType localization, MethodSpecImpl methodSpecImpl) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(), methodSpecImpl);
    }

    public static MethodInvocation invokeSuperInit(CodeType localization, CodeArgument... arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(),
                new MethodSpecImpl("<init>", PredefinedTypes.VOID, Arrays.asList(arguments)));
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type) {
        return new ArrayConstructorImpl(type, new CodePart[]{}, null);
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodeArgument[] arguments) {
        return new ArrayConstructorImpl(type, new CodePart[]{Literals.INT(arguments.length)}, Arrays.asList(arguments));
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodePart[] dimensions) {
        return new ArrayConstructorImpl(type, dimensions, null);
    }

    public static ArrayConstructor invokeArrayConstructor(CodeType type, CodePart[] dimensions, CodeArgument[] arguments) {
        return new ArrayConstructorImpl(type, dimensions, Arrays.asList(arguments));
    }

    public static MethodInvocation invokeConstructor(CodeType type) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, type, type, new MethodSpecImpl(MethodType.CONSTRUCTOR));
    }

    public static MethodInvocation invokeConstructor(CodeType type, CodeArgument[] arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, type, type, new MethodSpecImpl(Arrays.asList(arguments), MethodType.CONSTRUCTOR));
    }

    public static InstanceOf isInstanceOf(CodePart part, CodeType type) {
        return new InstanceOfImpl(part, type);
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
        return new ReturnImpl(returnType, value);
    }

    public static ArrayStore setArrayValue(CodePart target, CodePart index, CodeType valueType, CodePart value) {
        return new ArrayStoreImpl(index, target, valueType, value);
    }

    public static VariableDeclaration setVariable(CodeType localization, CodePart at, String variable, CodePart value) {
        return new VariableDeclarationImpl(localization, at, variable, null, value);
    }

    public static VariableDeclaration setVariable(CodeType localization, CodePart at, String variable, CodeType varType, CodePart value) {
        return new VariableDeclarationImpl(localization, at, variable, varType, value);
    }

    public static VariableDeclaration setVariable(CodeType localization, String variable, CodePart value) {
        return new VariableDeclarationImpl(localization, null, variable, null, value);
    }

    public static VariableDeclaration setVariable(CodeType localization, String variable, CodeType varType, CodePart value) {
        return new VariableDeclarationImpl(localization, null, variable, varType, value);
    }

    public static VariableDeclaration setLocalVariable(String variable, CodeType varType, CodePart value) {
        return new VariableDeclarationImpl(null, accessLocal(), variable, varType, value);
    }

    public static VariableDeclaration setLocalVariable(String variable, Class<?> varType, CodePart value) {
        return new VariableDeclarationImpl(null, accessLocal(), variable, Helper.getJavaType(varType), value);
    }

    public static VariableDeclaration setThisVariable(String variable, CodeType varType, CodePart value) {
        return new VariableDeclarationImpl(null, accessThis(), variable, varType, value);
    }

    public static VariableDeclaration setThisVariable(String variable, Class<?> varType, CodePart value) {
        return new VariableDeclarationImpl(null, accessThis(), variable, Helper.getJavaType(varType), value);
    }

    public static VariableAccess simpleVariable(String name) {
        return new VariableAccessImpl(null, name, null);
    }

    public static CodePart simpleVariable(String name, CodeType type) {
        return new VariableAccessImpl(null, name, type);
    }

    public static CodeSource sourceOf(CodePart... parts) {
        return CodeSource.fromArray(parts);
    }

    public static CodeElement staticBlock(CodeSource body) {
        return new StaticBlockImpl(body);
    }

    public static TryBlock surround(CodePart toSurround, List<CatchBlock> catchBlocks) {

        return new TryBlockImpl(catchBlocks, sourceOf(toSurround));
    }

    public static TryBlock surround(CodeSource toSurround, List<CatchBlock> catchBlocks) {

        return new TryBlockImpl(catchBlocks, toSurround);
    }

    public static TryBlock surround(CodePart toSurround, List<CatchBlock> catchBlocks, CodeSource finallyBlock) {

        return new TryBlockImpl(catchBlocks, sourceOf(toSurround), finallyBlock);
    }

    public static TryBlock surround(CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallyBlock) {

        return new TryBlockImpl(catchBlocks, toSurround, finallyBlock);
    }

    public static TryWithResources tryWithResources(VariableDeclaration variableDeclaration, CodeSource body) {
        return new TryWithResourcesImpl(variableDeclaration, body);
    }

    public static TryWithResources tryWithResources(VariableDeclaration variableDeclaration, CodeSource body, CodeSource finallyBlock) {
        return new TryWithResourcesImpl(variableDeclaration, Collections.emptyList(), body, finallyBlock);
    }

    public static TryWithResources tryWithResources(VariableDeclaration variableDeclaration, List<CatchBlock> catchBlocks, CodeSource body) {
        return new TryWithResourcesImpl(variableDeclaration, catchBlocks, body);
    }

    public static TryWithResources tryWithResources(VariableDeclaration variableDeclaration, CodeSource body, List<CatchBlock> catchBlocks, CodeSource finallyBlock) {
        return new TryWithResourcesImpl(variableDeclaration, catchBlocks, body, finallyBlock);
    }

    public static ThrowException throwException(CodeType exception, CodeArgument[] arguments) {

        MethodInvocation invoke = Helper.invoke(InvokeType.INVOKE_SPECIAL, exception, exception,
                new MethodSpecImpl(null, Arrays.asList(arguments),
                        /*<init>*/
                        (CodeType) null/*PredefinedTypes#VOID*/,
                        MethodType.CONSTRUCTOR));

        return Helper.throwException(invoke);
    }

    public static ThrowException throwException(CodePart partToThrow) {
        return new ThrowExceptionImpl(partToThrow);
    }

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
        public Named setName(String name) {
            throw new IllegalStateException("Empty element");
        }

        @Override
        public boolean isExpression() {
            throw new IllegalStateException("Empty element");
        }
    }

}
