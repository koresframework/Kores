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
import com.github.jonathanxd.codeapi.helper.ArrayConstructorEx;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 01/05/16.
 */
public class CodeAPI {

    // =========================================================
    //          Interfaces
    // =========================================================

    public static CodeInterface anInterface(int modifiers, String qualifiedName) {
        return anInterface__factory(modifiers, qualifiedName, new CodeSource());
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType... extensions) {
        return anInterface__factory(modifiers, qualifiedName, new CodeSource(), extensions);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, Class<?>... extensions) {
        return anInterface__factory(modifiers, qualifiedName, new CodeSource(), toCodeType(extensions));
    }


    // ** Source **

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeSource source) {
        return anInterface__factory(modifiers, qualifiedName, source);
    }

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType[] extensions, CodeSource source) {
        return anInterface__factory(modifiers, qualifiedName, source, extensions);
    }

    public static CodeInterface $anInterface(int modifiers, String qualifiedName, Class<?>[] extensions, CodeSource source) {
        return anInterface__factory(modifiers, qualifiedName, source, toCodeType(extensions));
    }

    // Factory

    private static CodeInterface anInterface__factory(int modifiers, String qualifiedName, CodeSource source, CodeType... extensions) {
        return new CodeInterface(qualifiedName, CodeModifier.extractModifiers(modifiers), ArrayUtils.toList(extensions), source);
    }

    // =========================================================
    //          Classes
    // =========================================================

    public static CodeClass aClass(int modifiers, String qualifiedName) {
        return aClass__factory(modifiers, qualifiedName, null, new CodeSource());
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, new CodeSource(), implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, null, new CodeSource(), toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, qualifiedName, superType, new CodeSource(), implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), new CodeSource(), toCodeType(implementations));
    }

    // ** Source **

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeSource source) {
        return aClass__factory(modifiers, qualifiedName, null, source);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType[] implementations, CodeSource source) {
        return aClass__factory(modifiers, qualifiedName, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>[] implementations, CodeSource source) {
        return aClass__factory(modifiers, qualifiedName, null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType[] implementations, CodeSource source) {
        return aClass__factory(modifiers, qualifiedName, superType, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>[] implementations, CodeSource source) {
        return aClass__factory(modifiers, qualifiedName, Helper.getJavaType(superType), source, toCodeType(implementations));
    }

    // Factory

    private static CodeClass aClass__factory(int modifiers, String qualifiedName, CodeType superType, CodeSource source, CodeType... implementations) {
        return new CodeClass(qualifiedName, CodeModifier.extractModifiers(modifiers), superType, ArrayUtils.toList(implementations), source);
    }

    // =========================================================
    //          Methods
    // =========================================================

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(modifiers, name, returnType, new CodeSource(), parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType) {
        return method__factory(modifiers, name, returnType, new CodeSource());
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(0, name, returnType, new CodeSource(), parameters);
    }

    public static CodeMethod method(String name, CodeType returnType) {
        return method__factory(0, name, returnType, new CodeSource());
    }


    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), new CodeSource(), parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), new CodeSource());
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(0, name, Helper.getJavaType(returnType), new CodeSource(), parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType) {
        return method__factory(0, name, Helper.getJavaType(returnType), new CodeSource());
    }

    // ** Source **

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter[] parameters, CodeSource source) {
        return method__factory(modifiers, name, returnType, source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeSource source) {
        return method__factory(modifiers, name, returnType, source);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter[] parameters, CodeSource source) {
        return method__factory(0, name, returnType, source, parameters);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeSource source) {
        return method__factory(0, name, returnType, source);
    }


    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter[] parameters, CodeSource source) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeSource source) {
        return method__factory(modifiers, name, Helper.getJavaType(returnType), source);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter[] parameters, CodeSource source) {
        return method__factory(0, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeSource source) {
        return method__factory(0, name, Helper.getJavaType(returnType), source);
    }

    // Factory

    private static CodeMethod method__factory(int modifiers, String name, CodeType returnType, CodeSource source, CodeParameter... parameters) {
        return new CodeMethod(name, CodeModifier.extractModifiers(modifiers), ArrayUtils.toList(parameters), returnType, source);
    }

    // =========================================================
    //          Constructors
    // =========================================================

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeParameter... parameters) {
        return constructor__factory(modifiers, declaringClass, new CodeSource(), parameters);
    }

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass) {
        return constructor__factory(modifiers, declaringClass, new CodeSource());
    }


    /// Class

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeParameter... parameters) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), new CodeSource(), parameters);
    }

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), new CodeSource());
    }

    // ** Source **

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeParameter[] parameters, CodeSource source) {
        return constructor__factory(modifiers, declaringClass, source, parameters);
    }

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeSource source) {
        return constructor__factory(modifiers, declaringClass, source);
    }


    /// Class

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeParameter[] parameters, CodeSource source) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), source, parameters);
    }

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeSource source) {
        return constructor__factory(modifiers, Helper.getJavaType(declaringClass), source);
    }

    // Factory
    private static CodeConstructor constructor__factory(int modifiers, CodeType declaringClass, CodeSource source, CodeParameter... parameters) {
        return new CodeConstructor(declaringClass, CodeModifier.extractModifiers(modifiers), ArrayUtils.toList(parameters), source);
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
        return new ArrayConstructorEx(arrayType, dimensions, ArrayUtils.toList(arguments));
    }

    // =========================================================
    //          Source
    // =========================================================

    public static CodeSource source(CodePart... codeParts) {
        return new CodeSource(codeParts);
    }

    // =========================================================
    //          Return
    // =========================================================

    public static Return returnValue(CodeType valueType, Literal value) {
        return Helper.returnValue(valueType, value);
    }

    public static Return returnValue(Class<?> valueType, Literal value) {
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

    public static MethodInvocation invokeVirtual(Class<?> localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    public static MethodInvocation invokeInterface(Class<?> localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    // Factory

    private static MethodSpec spec__factory(String methodName, TypeSpec methodDescription, MethodType methodType, CodeArgument... arguments) {
        return new MethodSpec(methodName, ArrayUtils.toList(arguments), methodDescription, methodType);
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
