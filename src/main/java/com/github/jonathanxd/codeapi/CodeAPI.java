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
package com.github.jonathanxd.codeapi;

import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.ArrayConstructorEx;
import com.github.jonathanxd.codeapi.helper.ArrayLengthEx;
import com.github.jonathanxd.codeapi.helper.ArrayLoadEx;
import com.github.jonathanxd.codeapi.helper.ArrayStoreEx;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.util.ArrayToList;
import com.github.jonathanxd.iutils.arrays.ArrayUtils;
import com.github.jonathanxd.iutils.optional.Require;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 01/05/16.
 */
public class CodeAPI {

    // =========================================================
    //          Interfaces
    // =========================================================

    public static CodeInterface anInterface(int modifiers, String qualifiedName) {
        return anInterface__factory(modifiers, qualifiedName, null, null);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature) {
        return anInterface__factory(modifiers, qualifiedName, signature, null);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType... extensions) {
        return anInterface__factory(modifiers, qualifiedName, null, null, extensions);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType... extensions) {
        return anInterface__factory(modifiers, qualifiedName, signature, null, extensions);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, Class<?>... extensions) {
        return anInterface__factory(modifiers, qualifiedName, null, null, toCodeType(extensions));
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>... extensions) {
        return anInterface__factory(modifiers, qualifiedName, signature, null, toCodeType(extensions));
    }

    // ** Source **

    public static CodeInterface anInterface(int modifiers, String qualifiedName, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source, extensions);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source, extensions);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, Class<?>[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source, toCodeType(extensions));
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source, toCodeType(extensions));
    }

    // Factory

    private static CodeInterface anInterface__factory(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeInterface, CodeSource> source, CodeType... extensions) {
        CodeInterface codeInterface = new CodeInterface(qualifiedName, CodeModifier.extractModifiers(modifiers), ArrayToList.toList(extensions), signature, new CodeSource());

        if(source != null)
            Require.require(codeInterface.getBody()).addAll(source.apply(codeInterface));

        return codeInterface;
    }

    // =========================================================
    //          Classes
    // =========================================================

    public static CodeClass aClass(int modifiers, String qualifiedName) {
        return aClass__factory(modifiers, qualifiedName, null, null, null);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature) {
        return aClass__factory(modifiers, qualifiedName, null, signature, null);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, null, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, signature, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, null, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, signature, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, superType, null, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, superType, signature, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), null, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), signature, null, toCodeType(implementations));
    }

    // ** Source **

    public static CodeClass aClass(int modifiers, String qualifiedName, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, null, source);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, signature, source);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, null, signature, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, superType, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, superType, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), signature, source, toCodeType(implementations));
    }

    // Factory

    private static CodeClass aClass__factory(int modifiers, String qualifiedName, CodeType superType, GenericSignature<GenericType> signature, Function<CodeClass, CodeSource> source, CodeType... implementations) {
        CodeClass codeClass = new CodeClass(qualifiedName, CodeModifier.extractModifiers(modifiers), superType, ArrayToList.toList(implementations), signature, new CodeSource());

        if(source != null)
            Require.require(codeClass.getBody()).addAll(source.apply(codeClass));

        return codeClass;
    }

    // =========================================================
    //          Methods
    // =========================================================

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(modifiers, name, returnType, null, parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType) {
        return method__factory(modifiers, name, returnType, null);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(0, name, returnType, null, parameters);
    }

    public static CodeMethod method(String name, CodeType returnType) {
        return method__factory(0, name, returnType, null);
    }


    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), null);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(0, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType) {
        return method__factory(0, name, Helper.getJavaType(returnType), null);
    }

    // ** Source **

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, name, returnType, source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, name, returnType, source);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, name, returnType, source, parameters);
    }

    public static CodeMethod method(String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, name, returnType, source);
    }


    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), source);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, name, Helper.getJavaType(returnType), source);
    }

    // Factory

    private static CodeMethod method__factory(int modifiers, String name, CodeType returnType, Function<CodeMethod, CodeSource> source, CodeParameter... parameters) {
        CodeMethod method = new CodeMethod(name, CodeModifier.extractModifiers(modifiers), ArrayToList.toList(parameters), returnType, new CodeSource());

        if(source != null)
            Require.require(method.getBody()).addAll(source.apply(method));

        return method;
    }

    // =========================================================
    //          Constructors
    // =========================================================

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeParameter... parameters) {
        return constructor__factory(modifiers, declaringClass, null, parameters);
    }

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass) {
        return constructor__factory(modifiers, declaringClass, null);
    }


    /// Class

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeParameter... parameters) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), null, parameters);
    }

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), null);
    }

    // ** Source **

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeParameter[] parameters, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, declaringClass, source, parameters);
    }

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, declaringClass, source);
    }


    /// Class

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeParameter[] parameters, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), source, parameters);
    }

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), source);
    }

    // Factory
    private static CodeConstructor constructor__factory(int modifiers, CodeType declaringClass, Function<CodeConstructor, CodeSource> source, CodeParameter... parameters) {
        CodeConstructor codeConstructor = new CodeConstructor(declaringClass, CodeModifier.extractModifiers(modifiers), ArrayToList.toList(parameters), new CodeSource());

        if(source != null)
            Require.require(codeConstructor.getBody()).addAll(source.apply(codeConstructor));

        return codeConstructor;
    }

    // =========================================================
    //          Array Constructors
    // =========================================================

    public static ArrayConstructor arrayConstruct(CodeType arrayType, CodePart[] dimensions, CodeArgument... arguments) {
        return arrayConstruct__factory(arrayType, dimensions, arguments);
    }

    public static ArrayConstructor arrayConstruct(CodeType arrayType, CodePart[] dimensions) {
        return arrayConstruct__factory(arrayType, dimensions);
    }

    // Class

    public static ArrayConstructor arrayConstruct(Class<?> arrayType, CodePart[] dimensions) {
        return arrayConstruct__factory(Helper.getJavaType(arrayType), dimensions);
    }

    public static ArrayConstructor arrayConstruct(Class<?> arrayType, CodePart[] dimensions, CodeArgument... arguments) {
        return arrayConstruct__factory(Helper.getJavaType(arrayType), dimensions, arguments);
    }

    // Factory

    private static ArrayConstructor arrayConstruct__factory(CodeType arrayType, CodePart[] dimensions, CodeArgument... arguments) {
        return new ArrayConstructorEx(arrayType, dimensions, ArrayToList.toList(arguments));
    }

    // =========================================================
    //          Array Manipulate
    // =========================================================

    public static ArrayLength getArrayLength(VariableAccess access) {
        return getArrayLength__factory(access);
    }

    public static ArrayLoad getArrayValue(CodeType arrayType, VariableAccess access, CodePart index) {
        return getArrayValue__factory(index, access, arrayType);
    }

    public static ArrayStore setArrayValue(CodeType arrayType, VariableAccess access, CodePart index, CodePart value) {
        return setArrayValue__factory(index, access, arrayType, value);
    }

    // Class

    public static ArrayLoad getArrayValue(Class<?> arrayType, VariableAccess access, CodePart index) {
        return getArrayValue__factory(index, access, Helper.getJavaType(arrayType));
    }

    public static ArrayStore setArrayValue(Class<?> arrayType, VariableAccess access, CodePart index, CodePart value) {
        return setArrayValue__factory(index, access, Helper.getJavaType(arrayType), value);
    }

    // Factory

    private static ArrayLength getArrayLength__factory(VariableAccess access) {
        return new ArrayLengthEx(access);
    }

    private static ArrayLoad getArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType) {
        return new ArrayLoadEx(index, access, arrayType);
    }

    private static ArrayStore setArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType, CodePart value) {
        return new ArrayStoreEx(index, access, arrayType, value);
    }


    // =========================================================
    //          Source
    // =========================================================

    public static CodeSource emptySource(CodePart... codeParts) {
        return new CodeSource();
    }

    public static CodeSource sourceOfParts(CodePart... codeParts) {
        return new CodeSource(codeParts);
    }

    public static <T> Function<T, CodeSource> source(CodePart... codeParts) {
        return (t) -> new CodeSource(codeParts);
    }

    public static <T> Function<T, CodeSource> source(Function<T, CodeSource> sourceFunction) {
        return sourceFunction;
    }

    // =========================================================
    //          Return
    // =========================================================

    public static Return returnValue(CodeType valueType, CodePart value) {
        return Helper.returnValue(valueType, value);
    }

    public static Return returnValue(Class<?> valueType, CodePart value) {
        return Helper.returnValue(Helper.getJavaType(valueType), value);
    }

    public static Return returnLocalVariable(CodeType fieldType, String fieldName) {
        return Helper.returnValue(fieldType, Helper.accessLocalVariable(fieldName, fieldType));
    }

    public static Return returnLocalVariable(Class<?> fieldType, String fieldName) {
        return Helper.returnValue(Helper.getJavaType(fieldType), Helper.accessLocalVariable(fieldName, Helper.getJavaType(fieldType)));
    }

    public static Return returnThisField(CodeType fieldType, String fieldName) {
        return Helper.returnValue(fieldType, Helper.accessVariable(null, Helper.accessThis(), fieldName, fieldType));
    }

    public static Return returnThisField(Class<?> fieldType, String fieldName) {
        return Helper.returnValue(Helper.getJavaType(fieldType), Helper.accessVariable(null, Helper.accessThis(), fieldName, Helper.getJavaType(fieldType)));
    }

    public static Return returnField(CodeType localization, Class<?> fieldType, String fieldName) {
        return Helper.returnValue(Helper.getJavaType(fieldType), Helper.accessVariable(localization, fieldName, Helper.getJavaType(fieldType)));
    }

    public static Return returnField(Class<?> localization, Class<?> fieldType, String fieldName) {
        return Helper.returnValue(Helper.getJavaType(fieldType), Helper.accessVariable(Helper.getJavaType(localization), fieldName, Helper.getJavaType(fieldType)));
    }


    // =========================================================
    //          Parameters
    // =========================================================

    public static CodeParameter parameter(CodeType type, String name) {
        return new CodeParameter(name, type);
    }

    public static CodeParameter parameter(Class<?> type, String name) {
        return new CodeParameter(name, Helper.getJavaType(type));
    }

    // =========================================================
    //          Arguments
    // =========================================================

    public static CodeArgument argument(CodePart value) {
        return new CodeArgument(value);
    }

    public static CodeArgument argument(CodePart value, CodeType type) {
        return new CodeArgument(value, type);
    }

    public static CodeArgument argument(CodePart value, Class<?> type) {
        return new CodeArgument(value, Helper.getJavaType(type));
    }

    // =========================================================
    //          Invoke
    // =========================================================

    public static MethodInvocation invokeConstructor(CodeType type) {
        return invokeConstructor__factory(type);
    }

    public static MethodInvocation invokeConstructor(CodeType type, CodeArgument... arguments) {
        return invokeConstructor__factory(type, arguments);
    }

    public static MethodInvocation invokeStatic(CodeType localization, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_STATIC, localization, localization,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeVirtual(CodeType localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, localization, target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeInterface(CodeType localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, localization, target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeDynamic(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
        return invokedynamic__factory(invokeDynamic, methodInvocation);
    }

    // Class

    public static MethodInvocation invokeConstructor(Class<?> type) {
        return invokeConstructor__factory(Helper.getJavaType(type));
    }

    public static MethodInvocation invokeConstructor(Class<?> type, CodeArgument... arguments) {
        return invokeConstructor__factory(Helper.getJavaType(type), arguments);
    }

    public static MethodInvocation invokeStatic(Class<?> localization, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_STATIC, Helper.getJavaType(localization), Helper.getJavaType(localization),
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeVirtual(CodePart target, Class<?> localization, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeInterface(Class<?> localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    // Factory

    private static MethodSpec spec__factory(String methodName, TypeSpec methodDescription, MethodType methodType, CodeArgument... arguments) {
        return new MethodSpec(methodName, ArrayToList.toList(arguments), methodDescription, methodType);
    }

    private static MethodInvocation invoke__factory(InvokeType invokeType, CodeType localization, CodePart target, MethodSpec methodSpec) {
        return Helper.invoke(invokeType, localization, target, methodSpec);
    }

    private static MethodInvocation invokedynamic__factory(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
        return Helper.invokeDynamic(invokeDynamic, methodInvocation);
    }

    private static MethodInvocation invokeConstructor__factory(CodeType type, CodeArgument... arguments) {
        return Helper.invokeConstructor(type, arguments);
    }

    // =========================================================
    //          Access Variables & Fields
    // =========================================================

    public static VariableAccess accessStaticThisField(CodeType fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), fieldType, name);
    }

    public static VariableAccess accessStaticField(CodeType localization, CodeType fieldType, String name) {
        return accessField__Factory(localization, null, fieldType, name);
    }

    public static VariableAccess accessField(CodeType localization, CodePart at, CodeType fieldType, String name) {
        return accessField__Factory(localization, at, fieldType, name);
    }

    public static VariableAccess accessThisField(CodeType fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), fieldType, name);
    }

    public static VariableAccess accessLocalVariable(CodeType variableType, String name) {
        return accessField__Factory(null, Helper.accessLocal(), variableType, name);
    }

    // Class

    public static VariableAccess accessStaticThisField(Class<?> fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name);
    }

    public static VariableAccess accessStaticField(Class<?> localization, Class<?> fieldType, String name) {
        return accessField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name);
    }

    public static VariableAccess accessField(Class<?> localization, CodePart at, Class<?> fieldType, String name) {
        return accessField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name);
    }

    public static VariableAccess accessThisField(Class<?> fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name);
    }

    public static VariableAccess accessLocalVariable(Class<?> variableType, String name) {
        return accessField__Factory(null, Helper.accessLocal(), Helper.getJavaType(variableType), name);
    }

    // Factory

    private static VariableAccess accessField__Factory(CodeType localization, CodePart at, CodeType type, String name) {
        return Helper.accessVariable(localization, at, name, type);
    }

    // =========================================================
    //          Utils
    // =========================================================

    private static CodeType toCodeType(Class<?> aClass) {
        return Helper.getJavaType(aClass);
    }

    private static CodeType[] toCodeType(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).toArray(CodeType[]::new);
    }

    private static Collection<CodeType> toCodeTypeCollection(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).collect(Collectors.toList());
    }
}
