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

import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by jonathan on 01/05/16.
 */
public class CodeAPI {

    // =========================================================
    //          Interfaces
    // =========================================================

    public static CodeInterface anInterface(int modifiers, String qualifiedName) {
        return anInterface__uniq(modifiers, qualifiedName, new CodeSource());
    }

    public static CodeInterface anInterface(
            int modifiers,
            String qualifiedName,
            CodeType... extensions) {

        return anInterface__uniq(modifiers, qualifiedName, new CodeSource(), extensions);
    }

    public static CodeInterface $anInterface(
            int modifiers,
            String qualifiedName,
            Class<?>... extensions) {

        return anInterface__uniq(modifiers, qualifiedName, new CodeSource(), toCodeType(extensions));
    }


    /// SOURCE

    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeSource source) {
        return anInterface__uniq(modifiers, qualifiedName, source);
    }

    public static CodeInterface anInterface(
            int modifiers,
            String qualifiedName,
            CodeSource source,
            CodeType... extensions) {

        return anInterface__uniq(modifiers, qualifiedName, source, extensions);
    }

    public static CodeInterface $anInterface(
            int modifiers,
            String qualifiedName,
            CodeSource source,
            Class<?>... extensions) {

        return anInterface__uniq(modifiers, qualifiedName, source, toCodeType(extensions));
    }

    // UNIQ

    private static CodeInterface anInterface__uniq(
            int modifiers,
            String qualifiedName,
            CodeSource source,
            CodeType... extensions) {

        return new CodeInterface(qualifiedName, CodeModifier.extractModifiers(modifiers), ArrayUtils.toList(extensions), source);
    }

    // =========================================================
    //          Classes
    // =========================================================

    public static CodeClass aClass(int modifiers, String qualifiedName) {
        return aClass__uniq(modifiers, qualifiedName, null, new CodeSource());
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            CodeType... implementations) {

        return aClass__uniq(modifiers, qualifiedName, null, new CodeSource(), implementations);
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            Class<?>... implementations) {

        return aClass__uniq(modifiers, qualifiedName, null, new CodeSource(), toCodeType(implementations));
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            CodeType superType,
            CodeType... implementations) {

        return aClass__uniq(modifiers, qualifiedName, superType, new CodeSource(), implementations);
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            Class<?> superType,
            Class<?>... implementations) {

        return aClass__uniq(modifiers, qualifiedName, Helper.getJavaType(superType), new CodeSource(), toCodeType(implementations));
    }

    // Source

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeSource source) {
        return aClass__uniq(modifiers, qualifiedName, null, source);
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            CodeSource source,
            CodeType... implementations) {

        return aClass__uniq(modifiers, qualifiedName, null, source, implementations);
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            CodeSource source,
            Class<?>... implementations) {

        return aClass__uniq(modifiers, qualifiedName, null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            CodeType superType,
            CodeSource source,
            CodeType... implementations) {

        return aClass__uniq(modifiers, qualifiedName, superType, source, implementations);
    }

    public static CodeClass aClass(
            int modifiers,
            String qualifiedName,
            Class<?> superType,
            CodeSource source,
            Class<?>... implementations) {

        return aClass__uniq(modifiers, qualifiedName, Helper.getJavaType(superType), source, toCodeType(implementations));
    }

    // Uniq

    private static CodeClass aClass__uniq(
            int modifiers,
            String qualifiedName,
            CodeType superType,
            CodeSource source,
            CodeType... implementations) {

        return new CodeClass(qualifiedName, CodeModifier.extractModifiers(modifiers), superType, ArrayUtils.toList(implementations), source);
    }

    // =========================================================
    //          Methods
    // =========================================================

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter... parameters) {
        return new CodeMethod(
                name,
                CodeModifier.extractModifiers(modifiers),
                ArrayUtils.toList(parameters),
                returnType,
                new CodeSource());
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType) {
        return new CodeMethod(
                name,
                CodeModifier.extractModifiers(modifiers),
                Collections.emptyList(),
                returnType,
                new CodeSource());
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter... parameters) {
        return new CodeMethod(
                name,
                Collections.emptyList(),
                ArrayUtils.toList(parameters),
                returnType,
                new CodeSource());
    }

    public static CodeMethod method(String name, CodeType returnType) {
        return new CodeMethod(
                name,
                Collections.emptyList(),
                Collections.emptyList(),
                returnType,
                new CodeSource());
    }


    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter[] parameters) {
        return new CodeMethod(
                name,
                CodeModifier.extractModifiers(modifiers),
                ArrayUtils.toList(parameters),
                Helper.getJavaType(returnType),
                new CodeSource());
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType) {
        return new CodeMethod(
                name,
                CodeModifier.extractModifiers(modifiers),
                Collections.emptyList(),
                Helper.getJavaType(returnType),
                new CodeSource());
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter[] parameters) {
        return new CodeMethod(
                name,
                Collections.emptyList(),
                ArrayUtils.toList(parameters),
                Helper.getJavaType(returnType),
                new CodeSource());
    }

    public static CodeMethod method(String name, Class<?> returnType) {
        return new CodeMethod(
                name,
                Collections.emptyList(),
                Collections.emptyList(),
                Helper.getJavaType(returnType),
                new CodeSource());
    }

    // =========================================================
    //          Constructors
    // =========================================================

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass, CodeParameter[] parameters) {
        return new CodeConstructor(
                declaringClass,
                CodeModifier.extractModifiers(modifiers),
                ArrayUtils.toList(parameters),
                new CodeSource());
    }

    public static CodeConstructor constructor(int modifiers, CodeType declaringClass) {
        return new CodeConstructor(
                declaringClass,
                CodeModifier.extractModifiers(modifiers),
                Collections.emptyList(),
                new CodeSource());
    }


    /// Class

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass, CodeParameter[] parameters) {
        return new CodeConstructor(
                Helper.getJavaType(declaringClass),
                CodeModifier.extractModifiers(modifiers),
                ArrayUtils.toList(parameters),
                new CodeSource());
    }

    public static CodeConstructor constructor(int modifiers, Class<?> declaringClass) {
        return new CodeConstructor(
                Helper.getJavaType(declaringClass),
                CodeModifier.extractModifiers(modifiers),
                Collections.emptyList(),
                new CodeSource());
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

    // =========================================================
    //          Invoke
    // =========================================================





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
