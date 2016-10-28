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

import com.github.jonathanxd.codeapi.builder.AnnotationBuilder;
import com.github.jonathanxd.codeapi.builder.ClassBuilder;
import com.github.jonathanxd.codeapi.builder.ConstructorBuilder;
import com.github.jonathanxd.codeapi.builder.EnumBuilder;
import com.github.jonathanxd.codeapi.builder.InterfaceBuilder;
import com.github.jonathanxd.codeapi.builder.MethodBuilder;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.FullInvokeSpec;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.IterationType;
import com.github.jonathanxd.codeapi.common.IterationTypes;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.common.SwitchTypes;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.value.source.PlainSourceGenerator;
import com.github.jonathanxd.codeapi.generic.GenericSignature;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.AnnotationImpl;
import com.github.jonathanxd.codeapi.impl.AnnotationPropertyImpl;
import com.github.jonathanxd.codeapi.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.impl.ArrayLengthImpl;
import com.github.jonathanxd.codeapi.impl.ArrayLoadImpl;
import com.github.jonathanxd.codeapi.impl.ArrayStoreImpl;
import com.github.jonathanxd.codeapi.impl.BreakImpl;
import com.github.jonathanxd.codeapi.impl.CodeClass;
import com.github.jonathanxd.codeapi.impl.CodeConstructor;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.impl.ContinueImpl;
import com.github.jonathanxd.codeapi.impl.EnumEntryImpl;
import com.github.jonathanxd.codeapi.impl.EnumValueImpl;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.interfaces.AccessOuter;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Annotation;
import com.github.jonathanxd.codeapi.interfaces.AnnotationProperty;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.ArrayLength;
import com.github.jonathanxd.codeapi.interfaces.ArrayLoad;
import com.github.jonathanxd.codeapi.interfaces.ArrayStore;
import com.github.jonathanxd.codeapi.interfaces.Break;
import com.github.jonathanxd.codeapi.interfaces.Case;
import com.github.jonathanxd.codeapi.interfaces.Casted;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.Continue;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.EnumEntry;
import com.github.jonathanxd.codeapi.interfaces.EnumValue;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.ForEachBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.InstanceOf;
import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.interfaces.Switch;
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
import com.github.jonathanxd.codeapi.types.GenericType;
import com.github.jonathanxd.codeapi.types.PlainCodeType;
import com.github.jonathanxd.codeapi.util.ArrayToList;
import com.github.jonathanxd.codeapi.util.BiMultiVal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Factory class.
 *
 * Is highly recommended to use Builders instead of factory methods, because the documentation of
 * this class isn't complete.
 */
public final class CodeAPI {

    private static final Annotation[] EMPTY_ANNOTATIONS = {};

    // =========================================================
    //          Annotations
    // =========================================================

    public static AnnotationBuilder annotationBuilder() {
        return AnnotationBuilder.builder();
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name}.
     *
     * @param type Property type.
     * @param name Property name.
     * @return Property.
     */
    public static AnnotationProperty property(CodeType type, String name) {
        return factory__property(null, type, name, null);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name}.
     *
     * @param type Property type.
     * @param name Property name.
     * @return Property.
     */
    public static AnnotationProperty property(Class<?> type, String name) {
        return factory__property(null, CodeAPI.toCodeType(type), name, null);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} with default value
     * {@code value}.
     *
     * @param type  Property type.
     * @param name  Property name.
     * @param value Default annotation value. The value must be: {@link Byte}, {@link Boolean},
     *              {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link Float},
     *              {@link Double}, {@link String}, {@link CodeType}, OBJECT, ARRAY, {@link
     *              EnumValue} or other {@link Annotation}.
     * @return Property.
     */
    public static AnnotationProperty property(CodeType type, String name, Object value) {
        return factory__property(null, type, name, value);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} with default value
     * {@code value}.
     *
     * @param type  Property type.
     * @param name  Property name.
     * @param value Default annotation value. The value must be: {@link Byte}, {@link Boolean},
     *              {@link Character}, {@link Short}, {@link Integer}, {@link Long}, {@link Float},
     *              {@link Double}, {@link String}, {@link CodeType}, OBJECT, ARRAY, {@link
     *              EnumValue} or other {@link Annotation}.
     * @return Property.
     */
    public static AnnotationProperty property(Class<?> type, String name, Object value) {
        return factory__property(null, CodeAPI.toCodeType(type), name, value);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} with default value
     * {@code value} and annotated with {@code annotations}.
     *
     * @param annotations Annotations.
     * @param type        Property type.
     * @param name        Property name.
     * @param value       Default annotation value. The value must be: {@link Byte}, {@link
     *                    Boolean}, {@link Character}, {@link Short}, {@link Integer}, {@link Long},
     *                    {@link Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                    ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return Property.
     */
    public static AnnotationProperty property(List<Annotation> annotations, CodeType type, String name, Object value) {
        return factory__property(annotations, type, name, value);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} with default value
     * {@code value} and annotated with {@code annotations}.
     *
     * @param annotations Annotations.
     * @param type        Property type.
     * @param name        Property name.
     * @param value       Default annotation value. The value must be: {@link Byte}, {@link
     *                    Boolean}, {@link Character}, {@link Short}, {@link Integer}, {@link Long},
     *                    {@link Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                    ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return Property.
     */
    public static AnnotationProperty property(List<Annotation> annotations, Class<?> type, String name, Object value) {
        return factory__property(annotations, CodeAPI.toCodeType(type), name, value);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} and annotated with
     * {@code annotations}.
     *
     * @param annotations Annotations.
     * @param type        Property type.
     * @param name        Property name.
     * @return Property.
     */
    public static AnnotationProperty property(List<Annotation> annotations, CodeType type, String name) {
        return factory__property(annotations, type, name, null);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name} and annotated with
     * {@code annotations}.
     *
     * @param annotations Annotations.
     * @param type        Property type.
     * @param name        Property name.
     * @return Property.
     */
    public static AnnotationProperty property(List<Annotation> annotations, Class<?> type, String name) {
        return factory__property(annotations, CodeAPI.toCodeType(type), name, null);
    }

    private static AnnotationProperty factory__property(List<Annotation> annotationList,
                                                        CodeType type,
                                                        String name,
                                                        Object value) {

        return new AnnotationPropertyImpl(annotationList, type, name, value);
    }

    // =========================================================
    //          Interfaces
    // =========================================================

    /**
     * Create a {@link InterfaceBuilder}.
     *
     * @return New {@link InterfaceBuilder}.
     */
    public static InterfaceBuilder anInterfaceBuilder() {
        return InterfaceBuilder.builder();
    }

    /**
     * Create an interface.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName) {
        return anInterface__factory(modifiers, qualifiedName, null, null);
    }

    /**
     * Create an interface with generic signature.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature) {
        return anInterface__factory(modifiers, qualifiedName, signature, null);
    }

    /**
     * Create an interface that extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param extensions    Interfaces to extend.
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType... extensions) {
        return anInterface__factory(modifiers, qualifiedName, null, null, extensions);
    }


    /**
     * Create an interface with generic signature and extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @param extensions    Interfaces to extend.
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType... extensions) {
        return anInterface__factory(modifiers, qualifiedName, signature, null, extensions);
    }

    // Class

    /**
     * Create an interface that extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param extensions    Interfaces to extend.
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, Class<?>... extensions) {
        return anInterface__factory(modifiers, qualifiedName, null, null, toCodeType(extensions));
    }

    /**
     * Create an interface with generic signature and extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @param extensions    Interfaces to extend.
     * @return {@link CodeInterface} instance.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>... extensions) {
        return anInterface__factory(modifiers, qualifiedName, signature, null, toCodeType(extensions));
    }

    // ** Source **

    /**
     * Create an interface.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source);
    }

    /**
     * Create an interface with generic signature.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source);
    }

    /**
     * Create an interface that extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param extensions    Interfaces to extend.
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, CodeType[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source, extensions);
    }

    /**
     * Create an interface with generic signature and extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @param extensions    Interfaces to extend.
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source, extensions);
    }

    /**
     * Create an interface that extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param extensions    Interfaces to extend.
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, Class<?>[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, null, source, toCodeType(extensions));
    }

    /**
     * Create an interface with generic signature and extends another interfaces.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature
     * @param extensions    Interfaces to extend.
     * @param source        Function that receives the {@link CodeInterface} instance and returns
     *                      the body to define.
     * @return {@link CodeInterface} instance with provided body.
     */
    public static CodeInterface anInterface(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>[] extensions, Function<CodeInterface, CodeSource> source) {
        return anInterface__factory(modifiers, qualifiedName, signature, source, toCodeType(extensions));
    }

    // Factory

    private static CodeInterface anInterface__factory(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeInterface, CodeSource> source, CodeType... extensions) {
        CodeInterface codeInterface = new CodeInterface(null, CodeModifier.extractModifiers(modifiers), ArrayToList.toList(extensions), signature, new CodeSource(), qualifiedName);

        if (source != null)
            return codeInterface.setBody(source.apply(codeInterface));

        return codeInterface;
    }

    // =========================================================
    //          Classes
    // =========================================================

    /**
     * Create a {@link ClassBuilder}.
     *
     * @return New {@link ClassBuilder}.
     */
    public static ClassBuilder aClassBuilder() {
        return ClassBuilder.builder();
    }


    /**
     * Create a class.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, String qualifiedName) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, null);
    }

    /**
     * Create an annotated class.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param annotations   Annotations
     * @param qualifiedName Qualified name of interface.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, null);
    }

    /**
     * Create a class with generic signature.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, null);
    }

    /**
     * Create an annotated class with generic signature.
     *
     * @param modifiers     Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                      java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                      {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                      visibility).
     * @param annotations   Annotations
     * @param qualifiedName Qualified name of interface.
     * @param signature     Generic signature.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, null);
    }

    /**
     * Create a class that implements a set of interfaces.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param qualifiedName   Qualified name of interface.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, null, implementations);
    }

    /**
     * Create an annotated class that implements a set of interfaces.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param annotations     Annotations
     * @param qualifiedName   Qualified name of interface.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, CodeType... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, null, implementations);
    }

    /**
     * Create a class with generic signature and implements a set of interfaces.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param qualifiedName   Qualified name of interface.
     * @param signature       Generic signature.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, null, implementations);
    }

    /**
     * Create an annotated class with generic signature and implements a set of interfaces.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param annotations     Annotations
     * @param qualifiedName   Qualified name of interface.
     * @param signature       Generic signature.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, CodeType... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, null, implementations);
    }

    // Class

    /**
     * Create a class.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param qualifiedName   Qualified name of interface.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, null, toCodeType(implementations));
    }

    /**
     * Create an annotated class.
     *
     * @param modifiers       Java Modifiers flag: {@link java.lang.reflect.Modifier} ({@link
     *                        java.lang.reflect.Modifier#PUBLIC}, {@link java.lang.reflect.Modifier#PRIVATE},
     *                        {@link java.lang.reflect.Modifier#PROTECTED}, or 0 to package-private
     *                        visibility).
     * @param annotations     Annotations
     * @param qualifiedName   Qualified name of interface.
     * @param implementations Implementations.
     * @return {@link CodeClass} instance.
     */
    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, Class<?>... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, Class<?>... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, superType, null, null, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, superType, null, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, superType, signature, null, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, superType, signature, null, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, Helper.getJavaType(superType), null, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, Helper.getJavaType(superType), null, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, Helper.getJavaType(superType), signature, null, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>... implementations) {
        return aClass__factory(modifiers, annotations, qualifiedName, Helper.getJavaType(superType), signature, null, toCodeType(implementations));
    }

    // ** Source **

    public static CodeClass aClass(int modifiers, String qualifiedName, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, source);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, source);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, source);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, source);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, null, signature, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, null, signature, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, superType, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, superType, null, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, superType, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, CodeType superType, CodeType[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, superType, signature, source, implementations);
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, Helper.getJavaType(superType), null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, Helper.getJavaType(superType), null, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, EMPTY_ANNOTATIONS, qualifiedName, Helper.getJavaType(superType), signature, source, toCodeType(implementations));
    }

    public static CodeClass aClass(int modifiers, Annotation[] annotations, String qualifiedName, GenericSignature<GenericType> signature, Class<?> superType, Class<?>[] implementations, Function<CodeClass, CodeSource> source) {
        return aClass__factory(modifiers, annotations, qualifiedName, Helper.getJavaType(superType), signature, source, toCodeType(implementations));
    }

    // Factory

    private static CodeClass aClass__factory(int modifiers, Annotation[] annotations, String qualifiedName, CodeType superType, GenericSignature<GenericType> signature, Function<CodeClass, CodeSource> source, CodeType... implementations) {
        CodeClass codeClass = new CodeClass(null, qualifiedName, CodeModifier.extractModifiers(modifiers), superType, ArrayToList.toList(implementations), signature, Arrays.asList(annotations), new CodeSource());

        if (source != null)
            return codeClass.setBody(source.apply(codeClass));

        return codeClass;
    }

    // =========================================================
    //          Enums
    // =========================================================

    /**
     * Creates a new enum builder.
     *
     * @return New enum builder
     */
    public static EnumBuilder enumBuilder() {
        return EnumBuilder.builder();
    }

    /**
     * Create an named enum entry.
     *
     * @param name name of enum entry.
     * @return New enum entry.
     */
    public static EnumEntry enumEntry(String name) {
        return enumEntry__factory(name, null, null, null);
    }

    /**
     * Create an named enum entry with a body.
     *
     * @param name Name of enum entry.
     * @param body Body of enum entry.
     * @return New enum entry.
     */
    public static EnumEntry enumEntry(String name, CodeSource body) {
        return enumEntry__factory(name, body, null, null);
    }

    /**
     * Create a new enum entry that calls the Enum constructor.
     *
     * @param name                 Name of entry.
     * @param constructorSpec      Constructor specification.
     * @param constructorArguments Constructor arguments.
     * @return new enum entry.
     */
    public static EnumEntry enumEntry(String name, TypeSpec constructorSpec, List<CodeArgument> constructorArguments) {
        return enumEntry__factory(name, null, constructorSpec, constructorArguments);
    }

    /**
     * Create a new enum entry that have a body and calls the Enum constructor.
     *
     * @param name                 Name of entry.
     * @param constructorSpec      Constructor specification.
     * @param constructorArguments Constructor arguments.
     * @param body                 Enum entry body.
     * @return new enum entry.
     */
    public static EnumEntry enumEntry(String name, TypeSpec constructorSpec, List<CodeArgument> constructorArguments, CodeSource body) {
        if (body.isEmpty())
            body = null;

        return enumEntry__factory(name, body, constructorSpec, constructorArguments);
    }

    // Factory

    private static EnumEntry enumEntry__factory(String name, CodeSource body, TypeSpec spec, List<CodeArgument> arguments) {
        return new EnumEntryImpl(name, body, spec, arguments);
    }

    // =========================================================
    //          Methods
    // =========================================================

    /**
     * Create a {@link MethodBuilder}.
     *
     * @return New {@link MethodBuilder}.
     */
    public static MethodBuilder methodBuilder() {
        return MethodBuilder.builder();
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(modifiers, null, name, returnType, null, parameters);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(modifiers, signature, name, returnType, null, parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType) {
        return method__factory(modifiers, null, name, returnType, null);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, CodeType returnType) {
        return method__factory(modifiers, signature, name, returnType, null);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(0, null, name, returnType, null, parameters);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, CodeType returnType, CodeParameter... parameters) {
        return method__factory(0, signature, name, returnType, null, parameters);
    }

    public static CodeMethod method(String name, CodeType returnType) {
        return method__factory(0, null, name, returnType, null);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, CodeType returnType) {
        return method__factory(0, signature, name, returnType, null);
    }

    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(modifiers, null, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(modifiers, signature, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType) {
        return method__factory(modifiers, null, name, Helper.getJavaType(returnType), null);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, Class<?> returnType) {
        return method__factory(modifiers, signature, name, Helper.getJavaType(returnType), null);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(0, null, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, Class<?> returnType, CodeParameter... parameters) {
        return method__factory(0, signature, name, Helper.getJavaType(returnType), null, parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType) {
        return method__factory(0, null, name, Helper.getJavaType(returnType), null);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, Class<?> returnType) {
        return method__factory(0, signature, name, Helper.getJavaType(returnType), null);
    }

    // ** Source **

    public static CodeMethod method(int modifiers, String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, null, name, returnType, source, parameters);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, signature, name, returnType, source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, null, name, returnType, source);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, signature, name, returnType, source);
    }

    public static CodeMethod method(String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, null, name, returnType, source, parameters);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, CodeType returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, signature, name, returnType, source, parameters);
    }

    public static CodeMethod method(String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, null, name, returnType, source);
    }

    public static CodeMethod method(GenericSignature<GenericType> signature, String name, CodeType returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, signature, name, returnType, source);
    }

    /// Class

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, null, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, signature, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(int modifiers, String name, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, null, name, Helper.getJavaType(returnType), source);
    }

    public static CodeMethod method(int modifiers, GenericSignature<GenericType> signature, String name, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(modifiers, signature, name, Helper.getJavaType(returnType), source);
    }

    public static CodeMethod method(String name, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, null, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(String name, GenericSignature<GenericType> signature, Class<?> returnType, CodeParameter[] parameters, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, signature, name, Helper.getJavaType(returnType), source, parameters);
    }

    public static CodeMethod method(String name, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, null, name, Helper.getJavaType(returnType), source);
    }

    public static CodeMethod method(String name, GenericSignature<GenericType> signature, Class<?> returnType, Function<CodeMethod, CodeSource> source) {
        return method__factory(0, signature, name, Helper.getJavaType(returnType), source);
    }

    // Factory

    private static CodeMethod method__factory(int modifiers, GenericSignature<GenericType> signature, String name, CodeType returnType, Function<CodeMethod, CodeSource> source, CodeParameter... parameters) {
        CodeMethod method = new CodeMethod(name, CodeModifier.extractModifiers(modifiers), ArrayToList.toList(parameters), returnType, signature, new CodeSource());

        if (source != null)
            return method.setBody(source.apply(method));

        return method;
    }

    // =========================================================
    //          Constructors
    // =========================================================

    /**
     * Create a {@link ConstructorBuilder}.
     *
     * @return New {@link ConstructorBuilder}.
     */
    public static ConstructorBuilder constructorBuilder() {
        return ConstructorBuilder.builder();
    }

    public static CodeConstructor constructor(int modifiers, CodeParameter... parameters) {
        return constructor__factory(modifiers, null, parameters);
    }

    public static CodeConstructor constructor(int modifiers) {
        return constructor__factory(modifiers, null);
    }

    // ** Source **

    public static CodeConstructor constructor(int modifiers, CodeParameter[] parameters, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, source, parameters);
    }

    public static CodeConstructor constructor(int modifiers, Function<CodeConstructor, CodeSource> source) {
        return constructor__factory(modifiers, source);
    }


    // Factory
    private static CodeConstructor constructor__factory(int modifiers, Function<CodeConstructor, CodeSource> source, CodeParameter... parameters) {
        CodeConstructor codeConstructor = new CodeConstructor(CodeModifier.extractModifiers(modifiers), ArrayToList.toList(parameters), new CodeSource());

        if (source != null)
            return codeConstructor.setBody(source.apply(codeConstructor));

        return codeConstructor;
    }

    // =========================================================
    //          Fields
    // =========================================================

    // ** Source **
    public static CodeField field(int modifiers, CodeType type, String name, CodePart value) {
        return field__factory(modifiers, type, name, value);
    }

    public static CodeField field(int modifiers, CodeType type, String name) {
        return field__factory(modifiers, type, name, null);
    }

    public static CodeField field(CodeType type, String name, CodePart value) {
        return field__factory(0, type, name, value);
    }

    public static CodeField field(CodeType type, String name) {
        return field__factory(0, type, name, null);
    }

    /// Class
    public static CodeField field(int modifiers, Class<?> type, String name, CodePart value) {
        return field__factory(modifiers, Helper.getJavaType(type), name, value);
    }

    public static CodeField field(int modifiers, Class<?> type, String name) {
        return field__factory(modifiers, Helper.getJavaType(type), name, null);
    }

    public static CodeField field(Class<?> type, String name, CodePart value) {
        return field__factory(0, Helper.getJavaType(type), name, value);
    }

    public static CodeField field(Class<?> type, String name) {
        return field__factory(0, Helper.getJavaType(type), name, null);
    }

    // Factory
    private static CodeField field__factory(int modifiers, CodeType type, String name, CodePart value) {
        return new CodeField(name, type, value, CodeModifier.extractModifiers(modifiers));
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
        return new ArrayConstructorImpl(arrayType, dimensions, ArrayToList.toList(arguments));
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
        return new ArrayLengthImpl(access);
    }

    private static ArrayLoad getArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType) {
        return new ArrayLoadImpl(index, access, arrayType);
    }

    private static ArrayStore setArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType, CodePart value) {
        return new ArrayStoreImpl(index, access, arrayType, value);
    }


    // =========================================================
    //          Source
    // =========================================================

    public static CodeSource emptySource() {
        return new CodeSource();
    }

    public static MutableCodeSource emptyMutableSource() {
        return new MutableCodeSource();
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

    /**
     * Create a {@link CodeParameter parameter}.
     *
     * @param type Parameter value type.
     * @param name Name of the parameter.
     * @return {@link CodeParameter} instance.
     */
    public static CodeParameter parameter(CodeType type, String name) {
        return new CodeParameter(name, type);
    }

    /**
     * Create a {@link CodeParameter parameter}.
     *
     * @param type Parameter value type.
     * @param name Name of the parameter.
     * @return {@link CodeParameter} instance.
     */
    public static CodeParameter parameter(Class<?> type, String name) {
        return new CodeParameter(name, Helper.getJavaType(type));
    }

    // =========================================================
    //          Arguments
    // =========================================================

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value) {
        return new CodeArgument(value);
    }

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @param type  Type of argument value.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value, CodeType type) {
        return new CodeArgument(value, type);
    }

    /**
     * Create an {@link CodeArgument argument}.
     *
     * @param value Value of argument.
     * @param type  Type of argument value.
     * @return {@link CodeArgument} instance.
     */
    public static CodeArgument argument(CodePart value, Class<?> type) {
        return new CodeArgument(value, Helper.getJavaType(type));
    }

    // =========================================================
    //          Invoke
    // =========================================================

    /**
     * Invoke this constructor.
     *
     * @param constructorSpec Type specification of constructor.
     * @param arguments       Constructor Arguments.
     * @return Invocation of super constructor of current class.
     */
    public static MethodInvocation invokeThisConstructor(TypeSpec constructorSpec, CodeArgument... arguments) {
        return invokeThisConstructor__factory(constructorSpec, arguments);
    }

    /**
     * Invoke super constructor of current type declaration.
     *
     * @param constructorSpec Type specification of constructor.
     * @param arguments       Constructor Arguments.
     * @return Invocation of super constructor of current class.
     */
    public static MethodInvocation invokeSuperConstructor(TypeSpec constructorSpec, CodeArgument... arguments) {
        return invokeSuperConstructor__factory(null, constructorSpec, arguments);
    }

    /**
     * Invoke super constructor of current type declaration.
     *
     * @param superClass      Super class of current type declaration (if null, CodeAPI will
     *                        determine it automatically).
     * @param constructorSpec Type specification of constructor.
     * @param arguments       Constructor Arguments.
     * @return Invocation of super constructor of current type declaration.
     */
    public static MethodInvocation invokeSuperConstructor(CodeType superClass, TypeSpec constructorSpec, CodeArgument... arguments) {
        return invokeSuperConstructor__factory(superClass, constructorSpec, arguments);
    }

    /**
     * Invoke super constructor of current type declaration.
     *
     * @param superClass      Super class of current type declaration (if null, CodeAPI will
     *                        determine it automatically).
     * @param constructorSpec Type specification of constructor.
     * @param arguments       Constructor Arguments.
     * @return Invocation of super constructor of current type declaration.
     */
    public static MethodInvocation invokeSuperConstructor(Class<?> superClass, TypeSpec constructorSpec, CodeArgument... arguments) {
        return invokeSuperConstructor__factory(Helper.getJavaType(superClass), constructorSpec, arguments);
    }

    /**
     * Invoke constructor of a {@link CodeType}.
     *
     * @param type Type to invoke constructor.
     * @return Invocation of constructor of {@code type}.
     */
    public static MethodInvocation invokeConstructor(CodeType type) {
        return invokeConstructor__factory(type);
    }

    /**
     * Invoke constructor of a {@link CodeType}.
     *
     * @param type      Type to invoke constructor.
     * @param arguments Arguments to pass to constructor.
     * @return Invocation of constructor of {@code type} with provided arguments.
     */
    public static MethodInvocation invokeConstructor(CodeType type, CodeArgument... arguments) {
        return invokeConstructor__factory(type, arguments);
    }

    /**
     * Invoke constructor of a {@link CodeType}.
     *
     * @param type      Type to invoke constructor.
     * @param spec      Method specification.
     * @param arguments Arguments to pass to constructor.
     * @return Invocation of constructor of {@code type} with provided arguments.
     */
    public static MethodInvocation invokeConstructor(CodeType type, TypeSpec spec, CodeArgument... arguments) {
        return invokeConstructor__factory(type, spec, Arrays.asList(arguments));
    }

    /**
     * Invoke constructor of a {@link CodeType}.
     *
     * @param type      Type to invoke constructor.
     * @param spec      Method specification.
     * @param arguments Arguments to pass to constructor.
     * @return Invocation of constructor of {@code type} with provided arguments.
     */
    public static MethodInvocation invokeConstructor(CodeType type, TypeSpec spec, List<CodeArgument> arguments) {
        return invokeConstructor__factory(type, spec, arguments);
    }

    /**
     * Invoke a static method.
     *
     * @param localization      Localization of the method.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of static method.
     */
    public static MethodInvocation invokeStatic(CodeType localization, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_STATIC, localization, localization,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a static method in current TypeDeclaration.
     *
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of static method.
     */
    public static MethodInvocation invokeStatic(String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_STATIC, null, null,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a instance method.
     *
     * @param localization      Localization of the method.
     * @param target            Instance.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of instance method.
     */
    public static MethodInvocation invokeVirtual(CodeType localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, localization, target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a instance method of current type declaration.
     *
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of instance method.
     */
    public static MethodInvocation invokeVirtual(String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, null, CodeAPI.accessThis(),
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a interface method of current type declaration.
     *
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of interface method.
     */
    public static MethodInvocation invokeInterface(String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, null, CodeAPI.accessThis(),
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a interface method.
     *
     * @param localization      Localization of the method.
     * @param target            Instance.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of interface method.
     */
    public static MethodInvocation invokeInterface(CodeType localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, localization, target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a method dynamically.
     *
     * @param invokeDynamic    Invoke dynamic instance.
     * @param methodInvocation Method to invoke dynamically.
     * @return Dynamic invocation.
     */
    public static MethodInvocation invokeDynamic(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
        return invokeDynamic__factory(invokeDynamic, methodInvocation);
    }

    /**
     * Invoke a lambda method dynamically.
     *
     * @param fragment Method to invoke.
     * @return Dynamic invocation.
     * @see MethodFragment
     */
    public static MethodInvocation invokeDynamicFragment(InvokeDynamic.LambdaFragment fragment) {
        return invokeDynamic__factory(fragment);
    }

    // Class

    /**
     * Invoke constructor of a {@link Class}.
     *
     * @param type Type to invoke constructor.
     * @return Invocation of constructor of {@code type}.
     */
    public static MethodInvocation invokeConstructor(Class<?> type) {
        return invokeConstructor__factory(Helper.getJavaType(type));
    }

    /**
     * Invoke constructor of a {@link Class}.
     *
     * @param type      Type to invoke constructor.
     * @param arguments Arguments to pass to constructor.
     * @return Invocation of constructor of {@code type} with provided arguments.
     */

    public static MethodInvocation invokeConstructor(Class<?> type, CodeArgument... arguments) {
        return invokeConstructor__factory(Helper.getJavaType(type), arguments);
    }

    /**
     * Invoke a static method.
     *
     * @param localization      Localization of the method.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of static method.
     */
    public static MethodInvocation invokeStatic(Class<?> localization, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_STATIC, Helper.getJavaType(localization), Helper.getJavaType(localization),
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a instance method.
     *
     * @param localization      Localization of the method.
     * @param target            Instance.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of instance method.
     */
    public static MethodInvocation invokeVirtual(Class<?> localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    /**
     * Invoke a interface method.
     *
     * @param localization      Localization of the method.
     * @param target            Instance.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of interface method.
     */
    public static MethodInvocation invokeInterface(Class<?> localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_INTERFACE, Helper.getJavaType(localization), target,
                spec__factory(methodName, methodDescription, MethodType.METHOD, arguments));
    }

    // Factory

    private static MethodSpecImpl spec__factory(String methodName, TypeSpec methodDescription, MethodType methodType, CodeArgument... arguments) {
        return new MethodSpecImpl(methodName, ArrayToList.toList(arguments), methodDescription, methodType);
    }

    private static MethodInvocation invoke__factory(InvokeType invokeType, CodeType localization, CodePart target, MethodSpecImpl methodSpecImpl) {
        return Helper.invoke(invokeType, localization, target, methodSpecImpl);
    }

    private static MethodInvocation invokeDynamic__factory(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
        return Helper.invokeDynamic(invokeDynamic, methodInvocation);
    }

    private static MethodInvocation invokeDynamic__factory(InvokeDynamic.LambdaFragment fragment) {
        return Helper.invokeDynamicFragment(fragment);
    }

    private static MethodInvocation invokeConstructor__factory(CodeType type, CodeArgument... arguments) {
        return Helper.invokeConstructor(type, arguments);
    }

    private static MethodInvocation invokeConstructor__factory(CodeType type, TypeSpec spec, List<CodeArgument> arguments) {
        return Helper.invokeConstructor(type, spec, arguments);
    }

    private static MethodInvocation invokeSuperConstructor__factory(CodeType type, TypeSpec constructorSpec, CodeArgument... arguments) {
        return Helper.invokeSuperInit(type, constructorSpec, arguments);
    }

    private static MethodInvocation invokeThisConstructor__factory(TypeSpec constructorSpec, CodeArgument... arguments) {
        return Helper.invoke(InvokeType.INVOKE_SPECIAL, (CodeType) null, CodeAPI.accessThis(),
                new MethodSpecImpl("<init>", Arrays.asList(arguments), constructorSpec, MethodType.SUPER_CONSTRUCTOR));
    }

    // =========================================================
    //          Access Variables & Fields
    // =========================================================

    /**
     * Access a variable declaration.
     *
     * @param declaration Declaration.
     * @return Access to {@code declaration}.
     */
    public static VariableAccess accessDeclaration(VariableDeclaration declaration) {
        return accessField__Factory(declaration.getLocalization().orElse(null), declaration.getTarget().orElse(null), declaration.getVariableType(), declaration.getName());
    }

    /**
     * Access a static field of current class.
     *
     * @param fieldType Type of the field.
     * @param name      Name of the field.
     * @return Access to a static field.
     */
    public static VariableAccess accessStaticField(CodeType fieldType, String name) {
        return accessField__Factory(null, null, fieldType, name);
    }

    /**
     * Access a static field of {@link CodeType type} {@code localization}.
     *
     * @param localization Localization of the field.
     * @param fieldType    Type of the field.
     * @param name         Name of the field.
     * @return Access to a static field.
     */
    public static VariableAccess accessStaticField(CodeType localization, CodeType fieldType, String name) {
        return accessField__Factory(localization, null, fieldType, name);
    }

    /**
     * Access a field or variable.
     *
     * @param localization Localization of the field.
     * @param at           Scope localization or instance of localization.
     * @param fieldType    Type of the field.
     * @param name         Name of the field.
     * @return Access to a field or variable.
     */
    public static VariableAccess accessField(CodeType localization, CodePart at, CodeType fieldType, String name) {
        return accessField__Factory(localization, at, fieldType, name);
    }

    /**
     * Access a static field of current class.
     *
     * @param fieldType Type of the field.
     * @param name      Name of the field.
     * @return Access to a static field of current class.
     */
    public static VariableAccess accessThisField(CodeType fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), fieldType, name);
    }

    /**
     * Access a local variable.
     *
     * @param variableType Type of the variable value.
     * @param name         Name of the variable.
     * @return Access to variable.
     */
    public static VariableAccess accessLocalVariable(CodeType variableType, String name) {
        return accessField__Factory(null, Helper.accessLocal(), variableType, name);
    }

    // Class

    /**
     * Access a static field of current class.
     *
     * @param fieldType Type of the field.
     * @param name      Name of the field.
     * @return Access to a static field.
     */
    public static VariableAccess accessStaticField(Class<?> fieldType, String name) {
        return accessField__Factory(null, null, Helper.getJavaType(fieldType), name);
    }

    /**
     * Access a static field of {@link CodeType type} {@code localization}.
     *
     * @param localization Localization of the field.
     * @param fieldType    Type of the field.
     * @param name         Name of the field.
     * @return Access to a static field.
     */
    public static VariableAccess accessStaticField(Class<?> localization, Class<?> fieldType, String name) {
        return accessField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name);
    }

    /**
     * Access a field or variable.
     *
     * @param localization Localization of the field.
     * @param at           Scope localization or instance of localization.
     * @param fieldType    Type of the field.
     * @param name         Name of the field.
     * @return Access to a field or variable.
     */
    public static VariableAccess accessField(Class<?> localization, CodePart at, Class<?> fieldType, String name) {
        return accessField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name);
    }

    /**
     * Access a static field of current class.
     *
     * @param fieldType Type of the field.
     * @param name      Name of the field.
     * @return Access to a static field of current class.
     */
    public static VariableAccess accessThisField(Class<?> fieldType, String name) {
        return accessField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name);
    }

    /**
     * Access a local variable.
     *
     * @param variableType Type of the variable value.
     * @param name         Name of the variable.
     * @return Access to variable.
     */
    public static VariableAccess accessLocalVariable(Class<?> variableType, String name) {
        return accessField__Factory(null, Helper.accessLocal(), Helper.getJavaType(variableType), name);
    }

    // Factory
    private static VariableAccess accessField__Factory(CodeType localization, CodePart at, CodeType type, String name) {
        return Helper.accessVariable(localization, at, name, type);
    }

    // =========================================================
    //          Set Variables & Fields
    // =========================================================


    public static VariableDeclaration setDeclarationValue(VariableDeclaration declaration, CodePart value) {
        return setField__Factory(declaration.getLocalization().orElse(null), declaration.getTarget().orElse(null), declaration.getVariableType(), declaration.getName(), value);
    }

    public static VariableDeclaration setStaticThisField(CodeType fieldType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessThis(), fieldType, name, value);
    }

    public static VariableDeclaration setStaticField(CodeType localization, CodeType fieldType, String name, CodePart value) {
        return setField__Factory(localization, null, fieldType, name, value);
    }

    public static VariableDeclaration setField(CodeType localization, CodePart at, CodeType fieldType, String name, CodePart value) {
        return setField__Factory(localization, at, fieldType, name, value);
    }

    public static VariableDeclaration setThisField(CodeType fieldType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessThis(), fieldType, name, value);
    }

    public static VariableDeclaration setLocalVariable(CodeType variableType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessLocal(), variableType, name, value);
    }

    // Class

    public static VariableDeclaration setStaticThisField(Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, value);
    }

    public static VariableDeclaration setStaticField(Class<?> localization, Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name, value);
    }

    public static VariableDeclaration setField(Class<?> localization, CodePart at, Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name, value);
    }

    public static VariableDeclaration setThisField(Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, value);
    }

    public static VariableDeclaration setLocalVariable(Class<?> variableType, String name, CodePart value) {
        return setField__Factory(null, Helper.accessLocal(), Helper.getJavaType(variableType), name, value);
    }

    // Factory
    private static VariableDeclaration setField__Factory(CodeType localization, CodePart at, CodeType type, String name, CodePart value) {
        return Helper.setVariable(localization, at, name, type, value);
    }

    // =========================================================
    //          Operate Variables & Fields
    // =========================================================

    public static VariableOperate operateDeclarationValue(VariableDeclaration declaration, Operator operation, CodePart value) {
        return operateField__Factory(declaration.getLocalization().orElse(null), declaration.getTarget().orElse(null), declaration.getVariableType(), declaration.getName(), operation, value);
    }

    public static VariableOperate operateDeclarationValue(VariableDeclaration declaration, Operator operation) {
        return operateField__Factory(declaration.getLocalization().orElse(null), declaration.getTarget().orElse(null), declaration.getVariableType(), declaration.getName(), operation, null);
    }

    public static VariableOperate operateStaticThisField(CodeType fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessThis(), fieldType, name, operation, value);
    }

    public static VariableOperate operateStaticThisField(CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessThis(), fieldType, name, operation, null);
    }

    public static VariableOperate operateStaticField(CodeType localization, CodeType fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(localization, null, fieldType, name, operation, value);
    }

    public static VariableOperate operateStaticField(CodeType localization, CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(localization, null, fieldType, name, operation, null);
    }

    public static VariableOperate operateField(CodeType localization, CodePart at, CodeType fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(localization, at, fieldType, name, operation, value);
    }

    public static VariableOperate operateField(CodeType localization, CodePart at, CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(localization, at, fieldType, name, operation, null);
    }

    public static VariableOperate operateThisField(CodeType fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessThis(), fieldType, name, operation, value);
    }

    public static VariableOperate operateThisField(CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessThis(), fieldType, name, operation, null);
    }

    public static VariableOperate operateLocalVariable(CodeType variableType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessLocal(), variableType, name, operation, value);
    }

    public static VariableOperate operateLocalVariable(CodeType variableType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessLocal(), variableType, name, operation, null);
    }

    // Class

    public static VariableOperate operateStaticThisField(Class<?> fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateStaticThisField(Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, operation, null);
    }

    public static VariableOperate operateStaticField(Class<?> localization, Class<?> fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateStaticField(Class<?> localization, Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name, operation, null);
    }

    public static VariableOperate operateField(Class<?> localization, CodePart at, Class<?> fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateField(Class<?> localization, CodePart at, Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name, operation, null);
    }

    public static VariableOperate operateThisField(Class<?> fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateThisField(Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessThis(), Helper.getJavaType(fieldType), name, operation, null);
    }

    public static VariableOperate operateLocalVariable(Class<?> variableType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, Helper.accessLocal(), Helper.getJavaType(variableType), name, operation, value);
    }

    public static VariableOperate operateLocalVariable(Class<?> variableType, String name, Operator operation) {
        return operateField__Factory(null, Helper.accessLocal(), Helper.getJavaType(variableType), name, operation, null);
    }

    // Factory
    private static VariableOperate operateField__Factory(CodeType localization, CodePart at, CodeType type, String name, Operator operation, CodePart value) {
        return Helper.operateVariable(localization, at, name, type, operation, value);
    }

    // =========================================================
    //          Throw Exceptions
    // =========================================================

    public static ThrowException throwException(CodePart partToThrow) {
        return throwException__Factory(partToThrow);
    }

    public static ThrowException throwException(CodeType exceptionType, CodeArgument... arguments) {
        return throwException__Factory(exceptionType, arguments);
    }

    //Class
    public static ThrowException throwException(Class<?> exceptionType, CodeArgument... arguments) {
        return throwException__Factory(toCodeType(exceptionType), arguments);
    }

    // Factory

    private static ThrowException throwException__Factory(CodePart partToThrow) {
        return Helper.throwException(partToThrow);
    }

    private static ThrowException throwException__Factory(CodeType exceptionType, CodeArgument... arguments) {
        MethodInvocation invoke = Helper.invoke(InvokeType.INVOKE_SPECIAL, exceptionType, exceptionType, new MethodSpecImpl(null, Arrays.asList(arguments), (CodeType) null, MethodType.CONSTRUCTOR));
        return throwException__Factory(invoke);
    }

    // =========================================================
    //          Annotations
    // =========================================================

    public static Annotation overrideAnnotation() {
        return CodeAPI.annotation(PredefinedTypes.OVERRIDE);
    }

    // CodeType

    /**
     * Create an annotation that is not visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(CodeType annotationType) {
        return annotation__Factory(false, annotationType, Collections.emptyMap());
    }

    /**
     * Create an annotation.
     *
     * @param annotationType Type of annotation
     * @param isVisible      Is annotation visible at runtime (only affects bytecode generation).
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(boolean isVisible, CodeType annotationType) {
        return annotation__Factory(isVisible, annotationType, Collections.emptyMap());
    }

    /**
     * Create an annotation that is visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @return A visible annotation
     */
    public static Annotation visibleAnnotation(CodeType annotationType) {
        return annotation__Factory(true, annotationType, Collections.emptyMap());
    }

    /**
     * Create an annotation that is not visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(CodeType annotationType, Map<String, Object> values) {
        return annotation__Factory(false, annotationType, values);
    }

    /**
     * Create an annotation that is visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A visible annotation
     */
    public static Annotation visibleAnnotation(CodeType annotationType, Map<String, Object> values) {
        return annotation__Factory(true, annotationType, values);
    }

    /**
     * Create an annotation.
     *
     * @param annotationType Type of annotation
     * @param isVisible      Is annotation visible at runtime (only affects bytecode generation).
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(boolean isVisible, CodeType annotationType, Map<String, Object> values) {
        return annotation__Factory(isVisible, annotationType, values);
    }

    // Class

    /**
     * Create an annotation that is not visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(Class<?> annotationType) {
        return annotation__Factory(false, CodeAPI.toCodeType(annotationType), Collections.emptyMap());
    }

    /**
     * Create an annotation.
     *
     * @param annotationType Type of annotation
     * @param isVisible      Is annotation visible at runtime (only affects bytecode generation).
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(boolean isVisible, Class<?> annotationType) {
        return annotation__Factory(isVisible, CodeAPI.toCodeType(annotationType), Collections.emptyMap());
    }

    /**
     * Create an annotation that is visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @return A visible annotation
     */
    public static Annotation visibleAnnotation(Class<?> annotationType) {
        return annotation__Factory(true, CodeAPI.toCodeType(annotationType), Collections.emptyMap());
    }

    /**
     * Create an annotation that is not visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(Class<?> annotationType, Map<String, Object> values) {
        return annotation__Factory(false, CodeAPI.toCodeType(annotationType), values);
    }

    /**
     * Create an annotation that is visible at runtime (only affects bytecode generation).
     *
     * @param annotationType Type of annotation
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A visible annotation
     */
    public static Annotation visibleAnnotation(Class<?> annotationType, Map<String, Object> values) {
        return annotation__Factory(true, CodeAPI.toCodeType(annotationType), values);
    }

    /**
     * Create an annotation.
     *
     * @param annotationType Type of annotation
     * @param isVisible      Is annotation visible at runtime (only affects bytecode generation).
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return A runtime invisible annotation.
     */
    public static Annotation annotation(boolean isVisible, Class<?> annotationType, Map<String, Object> values) {
        return annotation__Factory(isVisible, CodeAPI.toCodeType(annotationType), values);
    }

    // Factory

    /**
     * Create an Annotation
     *
     * @param isVisible      Is annotation visible at runtime.
     * @param annotationType Type of annotation
     * @param values         The Annotation values must be: {@link Byte}, {@link Boolean}, {@link
     *                       Character}, {@link Short}, {@link Integer}, {@link Long}, {@link
     *                       Float}, {@link Double}, {@link String}, {@link CodeType}, OBJECT,
     *                       ARRAY, {@link EnumValue} or other {@link Annotation}.
     * @return Annotation
     */
    private static Annotation annotation__Factory(boolean isVisible, CodeType annotationType, Map<String, Object> values) {
        return new AnnotationImpl(annotationType, isVisible, values);
    }

    // =========================================================
    //          Annotations & Case Enum Values
    // =========================================================

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(Class<?> enumType, String entry) {
        return enumValue__factory(CodeAPI.toCodeType(enumType), entry);
    }

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(CodeType enumType, String entry) {
        return enumValue__factory(enumType, entry);
    }

    /**
     * EnumValue in Case check.
     *
     * @param entry Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(String entry) {
        return enumValue__factory(null, entry);
    }

    // Factory

    private static EnumValue enumValue__factory(CodeType enumType, String entry) {
        return new EnumValueImpl(enumType, entry);
    }

    // =========================================================
    //          TypeSpec
    // =========================================================

    /**
     * Specification of a signature.
     *
     * @param returnType Return type.
     * @return Specification of a signature.
     */
    public static TypeSpec typeSpec(CodeType returnType) {
        return typeSpec__factory(returnType, new CodeType[]{});
    }

    /**
     * Specification of a signature.
     *
     * @param returnType     Return type.
     * @param parameterTypes Parameter types.
     * @return Specification of a signature.
     */
    public static TypeSpec typeSpec(CodeType returnType, CodeType... parameterTypes) {
        return typeSpec__factory(returnType, parameterTypes);
    }

    /**
     * Specification of a constructor signature.
     *
     * @param parameterTypes Parameter types.
     * @return Specification of a signature.
     */
    public static TypeSpec constructorTypeSpec(CodeType... parameterTypes) {
        return typeSpec__factory(PredefinedTypes.VOID, parameterTypes);
    }

    // Class

    /**
     * Specification of a signature.
     *
     * @param returnType Return type.
     * @return Specification of a signature.
     */
    public static TypeSpec typeSpec(Class<?> returnType) {
        return typeSpec__factory(toCodeType(returnType), new CodeType[]{});
    }

    /**
     * Specification of a signature.
     *
     * @param returnType     Return type.
     * @param parameterTypes Parameter types.
     * @return Specification of a signature.
     */
    public static TypeSpec typeSpec(Class<?> returnType, Class<?>... parameterTypes) {
        return typeSpec__factory(toCodeType(returnType), toCodeType(parameterTypes));
    }

    /**
     * Specification of a constructor signature.
     *
     * @param parameterTypes Parameter types.
     * @return Specification of a signature.
     */
    public static TypeSpec constructorTypeSpec(Class<?>... parameterTypes) {
        return typeSpec__factory(PredefinedTypes.VOID, toCodeType(parameterTypes));
    }

    // Factory

    private static TypeSpec typeSpec__factory(CodeType returnType, CodeType[] parameterTypes) {
        return new TypeSpec(returnType, parameterTypes);
    }

    // =========================================================
    //          Cast
    // =========================================================

    /**
     * Cast an element from a type to another type.
     *
     * @param fromType   From type.
     * @param toType     Target type to cast.
     * @param partToCast Part to cast.
     * @return Cast of element.
     */
    public static Casted cast(CodeType fromType, CodeType toType, CodePart partToCast) {
        return cast__Factory(fromType, toType, partToCast);
    }

    // Class

    /**
     * Cast an element from a type to another type.
     *
     * @param fromType   From type.
     * @param toType     Target type to cast.
     * @param partToCast Part to cast.
     * @return Cast of element.
     */
    public static Casted cast(Class<?> fromType, Class<?> toType, CodePart partToCast) {
        return cast__Factory(toCodeType(fromType), toCodeType(toType), partToCast);
    }

    // Factory
    private static Casted cast__Factory(CodeType fromType, CodeType toType, CodePart partToCast) {
        return Helper.cast(fromType, toType, partToCast);
    }

    // =========================================================
    //          If block
    // =========================================================

    /**
     * Create a if statement.
     *
     * @param groups    Expressions.
     * @param body      Body of the if.
     * @param elseBlock Else block of the if.
     * @return If statement.
     */
    public static IfBlock ifBlock(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, ElseBlock elseBlock) {
        return ifBlock__Factory(groups, body, elseBlock);
    }

    /**
     * Create a if statement.
     *
     * @param groups Expressions.
     * @param body   Body of the if.
     * @return If statement.
     */
    public static IfBlock ifBlock(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body) {
        return ifBlock__Factory(groups, body, null);
    }


    /**
     * Create a if statement.
     *
     * @param ifExpr    Expression.
     * @param body      Body of the if.
     * @param elseBlock Else block of the if.
     * @return If statement.
     */
    public static IfBlock ifBlock(IfExpr ifExpr, CodeSource body, ElseBlock elseBlock) {
        return ifBlock__Factory(CodeAPI.ifExprs(ifExpr), body, elseBlock);
    }

    /**
     * Create a if statement.
     *
     * @param ifExpr Expression.
     * @param body   Body of the if.
     * @return If statement.
     */
    public static IfBlock ifBlock(IfExpr ifExpr, CodeSource body) {
        return ifBlock__Factory(CodeAPI.ifExprs(ifExpr), body, null);
    }


    // Factory
    private static IfBlock ifBlock__Factory(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, ElseBlock elseBlock) {
        return Helper.ifExpression(groups, body, elseBlock);
    }

    // =========================================================
    //          If Checks
    // =========================================================

    /**
     * Check if a part is not null.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkNotNull(CodePart part) {
        return Helper.checkNotNull(part);
    }

    /**
     * Check if a part is null.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkNull(CodePart part) {
        return Helper.checkNull(part);
    }

    /**
     * Check if a expression is true.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkTrue(CodePart part) {
        return Helper.check(part, Operators.EQUAL_TO, Literals.BOOLEAN(true));
    }

    /**
     * Check if a expression is false.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkFalse(CodePart part) {
        return Helper.check(part, Operators.EQUAL_TO, Literals.BOOLEAN(false));
    }

    /**
     * Create a check condition.
     *
     * @param part1    Part 1.
     * @param operator Operation to do over two values.
     * @param part2    Part2.
     * @return The verification part.
     */
    public static IfExpr check(CodePart part1, Operator operator, CodePart part2) {
        return Helper.check(part1, operator, part2);
    }

    // =========================================================
    //          Else block
    // =========================================================

    /**
     * Else statement.
     *
     * @param body Body of else statement.
     * @return Else statement.
     */
    public static ElseBlock elseBlock(CodeSource body) {
        return elseBlock__Factory(body);
    }

    /**
     * Else statement.
     *
     * @param parts {@link CodePart}s in the body of else statement.
     * @return Else statement.
     */
    public static ElseBlock elseBlock(CodePart... parts) {
        return elseBlock__Factory(sourceOfParts(parts));
    }

    // Factory
    private static ElseBlock elseBlock__Factory(CodeSource body) {
        return Helper.elseExpression(body);
    }

    // =========================================================
    //          Break and Continue
    // =========================================================

    public static Break aBreak() {
        return CodeAPI.break__Factory();
    }

    public static Continue aContinue() {
        return CodeAPI.continue__Factory();
    }

    // Factory
    private static Break break__Factory() {
        return new BreakImpl();
    }

    private static Continue continue__Factory() {
        return new ContinueImpl();
    }

    // =========================================================
    //          Instance Of
    // =========================================================

    /**
     * Check if {@link CodePart part} is instance of {@link CodeType type}.
     *
     * @param part Part.
     * @param type Type.
     * @return The verification part.
     */
    public static InstanceOf isInstanceOf(CodePart part, CodeType type) {
        return isInstanceOf__Factory(part, type);
    }

    // Class

    /**
     * Check if {@link CodePart part} is instance of {@link Class type}.
     *
     * @param part Part.
     * @param type Type.
     * @return The verification part.
     */
    public static InstanceOf isInstanceOf(CodePart part, Class<?> type) {
        return isInstanceOf__Factory(part, toCodeType(type));
    }

    // Factory
    private static InstanceOf isInstanceOf__Factory(CodePart part, CodeType type) {
        return Helper.isInstanceOf(part, type);
    }

    // =========================================================
    //          Try block
    // =========================================================

    /**
     * Create a try-catch-finally statement.
     *
     * @param toSurround    Code to surround.
     * @param catchBlocks   Catch blocks.
     * @param finallySource Finally statement.
     * @return Try-Catch-Finally statement.
     */
    public static TryBlock tryBlock(CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallySource) {
        return tryBlock__Factory(toSurround, catchBlocks, finallySource);
    }

    /**
     * Create a try-catch-finally statement.
     *
     * @param toSurround    Code to surround.
     * @param catchBlock    Catch block.
     * @param finallySource Finally statement.
     * @return Try-Catch-Finally statement.
     */
    public static TryBlock tryBlock(CodeSource toSurround, CatchBlock catchBlock, CodeSource finallySource) {
        return tryBlock__Factory(toSurround, Collections.singletonList(catchBlock), finallySource);
    }

    /**
     * Create a try-catch statement.
     *
     * @param toSurround  Code to surround.
     * @param catchBlocks Catch blocks.
     * @return Try-Catch statement.
     */
    public static TryBlock tryBlock(CodeSource toSurround, List<CatchBlock> catchBlocks) {
        return tryBlock__Factory(toSurround, catchBlocks, null);
    }

    /**
     * Create a try-catch statement.
     *
     * @param toSurround Code to surround.
     * @param catchBlock Catch block.
     * @return Try-Catch statement.
     */
    public static TryBlock tryBlock(CodeSource toSurround, CatchBlock catchBlock) {
        return tryBlock__Factory(toSurround, Collections.singletonList(catchBlock), null);
    }

    // Factory
    private static TryBlock tryBlock__Factory(CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallySource) {
        return Helper.surround(toSurround, catchBlocks, finallySource);
    }

    // =========================================================
    //          Try With resources block
    // =========================================================

    /**
     * Create a try-with-resources block.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param catchBlocks   Catch blocks.
     * @param finallySource Finally statement.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, catchBlocks, finallySource);
    }

    /**
     * Create a try-with-resources block.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param catchBlock    Catch block.
     * @param finallySource Finally statement.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround, CatchBlock catchBlock, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, Collections.singletonList(catchBlock), finallySource);
    }

    /**
     * Create a try-with-resources block.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param finallySource Finally statement.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, Collections.emptyList(), finallySource);
    }

    /**
     * /**
     * Create a try-with-resources block.
     *
     * @param variable    Resource variable
     * @param toSurround  Code to surround.
     * @param catchBlocks Catch blocks.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround, List<CatchBlock> catchBlocks) {
        return tryWithResources__Factory(variable, toSurround, catchBlocks, null);
    }

    /**
     * /**
     * Create a try-with-resources block.
     *
     * @param variable   Resource variable
     * @param toSurround Code to surround.
     * @param catchBlock Catch block.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround, CatchBlock catchBlock) {
        return tryWithResources__Factory(variable, toSurround, Collections.singletonList(catchBlock), null);
    }

    /**
     * Create a try-with-resources block.
     *
     * @param variable   Resource variable
     * @param toSurround Code to surround.
     * @return Try-with-resources block.
     */
    public static TryBlock tryWithResources(VariableDeclaration variable, CodeSource toSurround) {
        return tryWithResources__Factory(variable, toSurround, Collections.emptyList(), null);
    }

    // Factory
    private static TryWithResources tryWithResources__Factory(VariableDeclaration variable, CodeSource toSurround, List<CatchBlock> catchBlocks, CodeSource finallySource) {
        return Helper.tryWithResources(variable, toSurround, catchBlocks, finallySource);
    }

    // =========================================================
    //          WhileBlock
    // =========================================================

    public static WhileBlock whileBlock(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return whileBlock__Factory(parts, source);
    }

    // Factory
    private static WhileBlock whileBlock__Factory(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return Helper.createWhile(parts, source);
    }

    // =========================================================
    //          DoWhileBlock
    // =========================================================

    /**
     * Create a do-while statement.
     *
     * @param parts  Expression.
     * @param source Source.
     * @return Do-while statement.
     */
    public static DoWhileBlock doWhileBlock(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return doWhileBlock__Factory(source, parts);
    }

    // Factory
    private static DoWhileBlock doWhileBlock__Factory(CodeSource source, BiMultiVal<CodePart, IfExpr, Operator> parts) {
        return Helper.createDoWhile(source, parts);
    }

    // =========================================================
    //          ForBlock
    // =========================================================

    /**
     * Create a for statement.
     *
     * @param initialization For initialization.
     * @param condition      Condition.
     * @param update         For Update
     * @param body           For body.
     * @return For statement.
     */
    public static ForBlock forBlock(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> condition, CodePart update, CodeSource body) {
        return forBlock__Factory(initialization, condition, update, body);
    }

    // Factory
    private static ForBlock forBlock__Factory(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> condition, CodePart update, CodeSource body) {
        return Helper.createFor(initialization, condition, update, body);
    }

    // =========================================================
    //          ForeachBlock
    // =========================================================

    /**
     * Create a ForEach statement.
     *
     * <pre>{@code
     * forEachBlock(field IterationType expression) body
     * }</pre>
     *
     * @param field         Field to store values.
     * @param iterationType Iteration type (constants: {@link IterationTypes}).
     * @param expression    Expression.
     * @param body          For each block.
     * @return ForEach statement.
     */
    public static ForEachBlock forEachBlock(FieldDeclaration field, IterationType iterationType, CodePart expression, CodeSource body) {
        return forEachBlock__Factory(field, iterationType, expression, body);
    }

    /**
     * ForEach statement iterating an array.
     *
     * <pre>{@code
     * forEachBlock(field : expression) body
     * }</pre>
     *
     * @param field      Field to store values.
     * @param expression Expression (the array).
     * @param body       ForEach body.
     * @return ForEach statement iterating an array.
     */
    public static ForEachBlock forEachArray(FieldDeclaration field, CodePart expression, CodeSource body) {
        return forEachBlock__Factory(field, IterationTypes.ARRAY, expression, body);
    }

    /**
     * ForEach statement iterating an iterable element.
     *
     * <pre>{@code
     * forEachBlock(field : expression) body
     * }</pre>
     *
     * @param field      Field to store values.
     * @param expression Expression (the iterable object).
     * @param body       ForEach body.
     * @return ForEach statement iterating an iterable element.
     */
    public static ForEachBlock forEachIterable(FieldDeclaration field, CodePart expression, CodeSource body) {
        return forEachBlock__Factory(field, IterationTypes.ITERABLE_ELEMENT, expression, body);
    }

    // Factory
    private static ForEachBlock forEachBlock__Factory(FieldDeclaration field, IterationType iterationType, CodePart expression, CodeSource body) {
        return Helper.createForEach(field, iterationType, expression, body);
    }

    // =========================================================
    //          Method Spec
    // =========================================================

    /**
     * Specification of a method.
     *
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullMethodSpec fullMethodSpec(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return fullMethodSpec__factory(location, returnType, methodName, parameterTypes);
    }

    /**
     * Specification of a method.
     *
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullMethodSpec fullMethodSpec(Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return fullMethodSpec__factory(toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static FullMethodSpec fullMethodSpec__factory(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new FullMethodSpec(location, returnType, methodName, parameterTypes);
    }

    // =========================================================
    //          Invoke Spec
    // =========================================================

    /**
     * Specification of a method to invoke.
     *
     * @param invokeType     Invocation type.
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullInvokeSpec fullInvokeSpec(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return fullInvokeSpec__factory(invokeType, location, returnType, methodName, parameterTypes);
    }

    /**
     * Specification of a method to invoke.
     *
     * @param invokeType     Invocation type.
     * @param location       Localization of method.
     * @param returnType     Return type of the method.
     * @param methodName     Name of the method.
     * @param parameterTypes Parameter types of the method.
     * @return Specification of a method.
     */
    public static FullInvokeSpec fullInvokeSpec(InvokeType invokeType, Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return fullInvokeSpec__factory(invokeType, toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static FullInvokeSpec fullInvokeSpec__factory(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new FullInvokeSpec(invokeType, location, returnType, methodName, parameterTypes);
    }

    // =========================================================
    //          Method fragment
    // =========================================================

    /**
     * Create a method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragment(CodeInterface codeInterface, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, scope, returnType, parameters, arguments, body);
    }

    /**
     * Create a method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragment(CodeInterface codeInterface, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, scope, returnType, parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    /**
     * Create a static method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(CodeInterface codeInterface, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, Scope.STATIC, returnType, parameters, arguments, body);
    }

    /**
     * Create a static method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(CodeInterface codeInterface, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, Scope.STATIC, returnType, parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    /**
     * Create a instance method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(CodeInterface codeInterface, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, Scope.INSTANCE, returnType, parameters, arguments, body);
    }

    /**
     * Create a instance method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(CodeInterface codeInterface, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, Scope.INSTANCE, returnType, parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    // Class

    /**
     * Create a method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragment(CodeInterface codeInterface, Scope scope, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, scope, toCodeType(returnType), parameters, arguments, body);
    }

    /**
     * Create a method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragment(CodeInterface codeInterface, Scope scope, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, scope, toCodeType(returnType), parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    /**
     * Create a static method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(CodeInterface codeInterface, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, Scope.STATIC, toCodeType(returnType), parameters, arguments, body);
    }

    /**
     * Create a static method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(CodeInterface codeInterface, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, Scope.STATIC, toCodeType(returnType), parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    /**
     * Create a instance method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(CodeInterface codeInterface, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(codeInterface, Scope.INSTANCE, toCodeType(returnType), parameters, arguments, body);
    }

    /**
     * Create a instance method fragment.
     *
     * @param codeInterface Code class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param source        Function that provide the method body.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(CodeInterface codeInterface, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, Function<MethodFragment, CodeSource> source) {
        MethodFragment methodFragment = fragment__factory(codeInterface, Scope.INSTANCE, toCodeType(returnType), parameters, arguments, new CodeSource());

        if (source != null)
            return methodFragment.setMethod(methodFragment.getMethod().setBody(source.apply(methodFragment)));

        return methodFragment;
    }

    // Factory
    private static MethodFragment fragment__factory(CodeInterface codeInterface, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return Helper.methodFragment(codeInterface, scope, returnType, parameters, arguments, body);
    }

    // =========================================================
    //          Switch & Case
    // =========================================================

    public static Switch switchInt(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.NUMERIC, value, ArrayToList.toList(cases));
    }

    public static Switch switchString(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.STRING, value, ArrayToList.toList(cases));
    }

    public static Switch switchEnum(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.ENUM, value, ArrayToList.toList(cases));
    }

    public static Switch switchObject(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.OBJECT, value, ArrayToList.toList(cases));
    }

    public static Switch switchDefined(SwitchType switchType, Typed value, Case... cases) {
        return switch__factory(switchType, value, ArrayToList.toList(cases));
    }

    // Case
    public static Case aCase(Typed value, CodeSource body) {
        return case__factory(value, body);
    }

    public static Case caseDefault(CodeSource body) {
        return case__factory(null, body);
    }

    // Factory
    private static Switch switch__factory(SwitchType switchType, Typed value, List<Case> caseList) {
        return Helper.aSwitch(switchType, value, caseList);
    }

    private static Case case__factory(Typed value, CodeSource body) {
        return Helper.aCase(value, body);
    }


    // =========================================================
    //          Utils
    // =========================================================

    /**
     * Access this {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     *
     * Equivalent to Java {@code this}.
     *
     * @return Access this {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     */
    public static AccessThis accessThis() {
        return Helper.accessThis();
    }

    /**
     * Access super type of current {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     *
     * Equivalent to Java {@code super}.
     *
     * @return Access super type of current {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     */
    public static AccessSuper accessSuper() {
        return Helper.accessSuper();
    }

    /**
     * Access enclosing class of current {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     *
     * Equivalent to Java {@code CLASS.this}.
     *
     * @param localization Localization of outer class.
     * @return Access enclosing class of current {@link com.github.jonathanxd.codeapi.interfaces.TypeDeclaration}.
     */
    public static AccessOuter accessOuter(CodeType localization) {
        return Helper.accessOuter(localization);
    }

    /**
     * Plain code type.
     *
     * @param name        Name of the type.
     * @param isInterface Is the type an interface.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainType(String name, boolean isInterface) {
        return new PlainCodeType(name, isInterface);
    }

    /**
     * Plain interface code type.
     *
     * @param name Name of the type.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainInterfaceType(String name) {
        return new PlainCodeType(name, true);
    }

    /**
     * Plain class code type.
     *
     * @param name Name of the type.
     * @return {@link PlainCodeType Plain Code Type} representation.
     */
    public static PlainCodeType plainClassType(String name) {
        return new PlainCodeType(name, false);
    }

    /**
     * Convert Java {@link Class class} to CodeAPI {@link CodeType type}.
     *
     * @param aClass Class to convert.
     * @return Converted type.
     */
    private static CodeType toCodeType(Class<?> aClass) {
        return Helper.getJavaType(aClass);
    }

    /**
     * Convert Java {@link Class classes} to CodeAPI {@link CodeType types}.
     *
     * @param aClass Classes to convert.
     * @return Converted types.
     */
    private static CodeType[] toCodeType(Class<?>[] aClass) {
        return Arrays.stream(aClass).map(Helper::getJavaType).toArray(CodeType[]::new);
    }

    /**
     * Helper method to create if expressions.
     *
     * @param objects {@link IfExpr}s and {@link Operator}s.
     * @return If multi values.
     */
    public static BiMultiVal<CodePart, IfExpr, Operator> ifExprs(Object... objects) {
        BiMultiVal.Adder<CodePart, IfExpr, Operator> adder = CodeAPI.ifExprs();

        for (Object object : objects) {
            if (object instanceof IfExpr) {
                adder.add1((IfExpr) object);
            } else if (object instanceof Operator) {
                adder.add2((Operator) object);
            } else {
                throw new IllegalArgumentException("Illegal input object: '" + object + "'.");
            }
        }

        return adder.make();
    }

    /**
     * Helper method to create if expressions.
     *
     * @return If multi values adder.
     */
    public static BiMultiVal.Adder<CodePart, IfExpr, Operator> ifExprs() {
        return BiMultiVal.create(CodePart.class, IfExpr.class, Operator.class);
    }

    public static Annotation[] annotations(Annotation... annotations) {
        return annotations;
    }

    public static CodeArgument[] arguments(CodeArgument... arguments) {
        return arguments;
    }

    public static CodeParameter[] parameters(CodeParameter... parameters) {
        return parameters;
    }

    public static CodeType[] types(CodeType... types) {
        return types;
    }

    public static Class<?>[] types(Class<?>... types) {
        return types;
    }

    /**
     * Helper method to create maps.
     *
     * @param objects Objects (Key and values).
     * @return Map of keys and values.
     */
    public static Map<String, Object> values(Object... objects) {
        Map<String, Object> map = new HashMap<>();

        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("Input must be odd (Pair of String and Object)");
        }

        for (int i = 0; i < objects.length; i += 2) {
            map.put((String) objects[i], objects[i + 1]);
        }

        return map;
    }


    /**
     * Generator Specific features
     *
     * Not supported by Java Source Code generation. ({@link PlainSourceGenerator}).
     */
    public static class Specific {
        // =========================================================
        //          Invoke Dynamic
        // =========================================================

        /**
         * Invoke dynamic method.
         *
         * @param invokeDynamic    Dynamic invocation specification.
         * @param methodInvocation Method to invoke dynamically.
         * @return Dynamic invocation.
         */
        public static MethodInvocation invokeDynamic(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
            return Specific.invokeDynamic__factory(invokeDynamic, methodInvocation);
        }

        /**
         * Invoke a {@link com.github.jonathanxd.codeapi.common.InvokeDynamic.LambdaFragment}
         * dynamically.
         *
         * @param fragment Lambda Fragment.
         * @return Invocation of lambda fragment.
         */
        public static MethodInvocation invokeDynamicFragment(InvokeDynamic.LambdaFragment fragment) {
            return Specific.invokeDynamic__factory(fragment);
        }

        // Factory
        private static MethodInvocation invokeDynamic__factory(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
            return Helper.invokeDynamic(invokeDynamic, methodInvocation);
        }

        private static MethodInvocation invokeDynamic__factory(InvokeDynamic.LambdaFragment fragment) {
            return Helper.invokeDynamicFragment(fragment);
        }

        private static MethodInvocation invokeConstructor__factory(CodeType type, CodeArgument... arguments) {
            return Helper.invokeConstructor(type, arguments);
        }

        // Utils

        /**
         * Invoke Bootstrap methods with bsm parameters
         *
         * @param invokeType     Invocation Type.
         * @param fullMethodSpec Bootstrap method.
         * @param args           BSM Arguments, must be an {@link String}, {@link Integer}, {@link
         *                       Long}, {@link Float}, {@link Double}, {@link CodeType}, or {@link
         *                       FullInvokeSpec}.
         * @return Bootstrap specification.
         */
        public static InvokeDynamic.Bootstrap bootstrap(InvokeType invokeType, FullMethodSpec fullMethodSpec, Object... args) {
            return InvokeDynamic.invokeDynamicBootstrap(invokeType, fullMethodSpec, args);
        }

        /**
         * Invoke a Bootstrap method.
         *
         * @param invokeType     Invocation Type.
         * @param fullMethodSpec Bootstrap method.
         * @return Bootstrap specification.
         */
        public static InvokeDynamic.Bootstrap bootstrap(InvokeType invokeType, FullMethodSpec fullMethodSpec) {
            return InvokeDynamic.invokeDynamicBootstrap(invokeType, fullMethodSpec);
        }

        /**
         * Invoke a lambda method reference.
         *
         * @param fullMethodSpec Method specification ({@link InvokeDynamic}).
         * @param expectedTypes  Expected types.
         * @return Lambda Method Reference specification.
         * @see InvokeDynamic
         */
        public static InvokeDynamic.LambdaMethodReference lambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            return InvokeDynamic.invokeDynamicLambda(fullMethodSpec, expectedTypes);
        }

        /**
         * Invoke a lambda code.
         *
         * @param fullMethodSpec Method specification ({@link InvokeDynamic}).
         * @param expectedTypes  Expected types.
         * @param methodFragment Fragment to invoke.
         * @return Lambda Method Reference specification.
         * @see InvokeDynamic
         */
        public static InvokeDynamic.LambdaMethodReference code(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes, MethodFragment methodFragment) {
            return InvokeDynamic.invokeDynamicLambdaFragment(fullMethodSpec, expectedTypes, methodFragment);
        }

    }

}
