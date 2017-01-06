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
import com.github.jonathanxd.codeapi.base.AnnotationProperty;
import com.github.jonathanxd.codeapi.base.ArrayConstructor;
import com.github.jonathanxd.codeapi.base.ArrayLength;
import com.github.jonathanxd.codeapi.base.ArrayLoad;
import com.github.jonathanxd.codeapi.base.ArrayStore;
import com.github.jonathanxd.codeapi.base.Case;
import com.github.jonathanxd.codeapi.base.Cast;
import com.github.jonathanxd.codeapi.base.CatchStatement;
import com.github.jonathanxd.codeapi.base.ControlFlow;
import com.github.jonathanxd.codeapi.base.EnumEntry;
import com.github.jonathanxd.codeapi.base.EnumValue;
import com.github.jonathanxd.codeapi.base.FieldDeclaration;
import com.github.jonathanxd.codeapi.base.ForEachStatement;
import com.github.jonathanxd.codeapi.base.ForStatement;
import com.github.jonathanxd.codeapi.base.IfExpr;
import com.github.jonathanxd.codeapi.base.IfStatement;
import com.github.jonathanxd.codeapi.base.InstanceOfCheck;
import com.github.jonathanxd.codeapi.base.Label;
import com.github.jonathanxd.codeapi.base.MethodFragment;
import com.github.jonathanxd.codeapi.base.MethodInvocation;
import com.github.jonathanxd.codeapi.base.MethodSpecification;
import com.github.jonathanxd.codeapi.base.Operate;
import com.github.jonathanxd.codeapi.base.Return;
import com.github.jonathanxd.codeapi.base.SwitchStatement;
import com.github.jonathanxd.codeapi.base.ThrowException;
import com.github.jonathanxd.codeapi.base.TryStatement;
import com.github.jonathanxd.codeapi.base.TryWithResources;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.Typed;
import com.github.jonathanxd.codeapi.base.VariableAccess;
import com.github.jonathanxd.codeapi.base.VariableDeclaration;
import com.github.jonathanxd.codeapi.base.VariableOperate;
import com.github.jonathanxd.codeapi.base.WhileStatement;
import com.github.jonathanxd.codeapi.base.impl.AnnotationImpl;
import com.github.jonathanxd.codeapi.base.impl.AnnotationPropertyImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayLengthImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayLoadImpl;
import com.github.jonathanxd.codeapi.base.impl.ArrayStoreImpl;
import com.github.jonathanxd.codeapi.base.impl.CaseImpl;
import com.github.jonathanxd.codeapi.base.impl.CastImpl;
import com.github.jonathanxd.codeapi.base.impl.CatchStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ControlFlowImpl;
import com.github.jonathanxd.codeapi.base.impl.EnumEntryImpl;
import com.github.jonathanxd.codeapi.base.impl.EnumValueImpl;
import com.github.jonathanxd.codeapi.base.impl.FieldDeclarationImpl;
import com.github.jonathanxd.codeapi.base.impl.ForEachStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ForStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.IfExprImpl;
import com.github.jonathanxd.codeapi.base.impl.IfStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.InstanceOfCheckImpl;
import com.github.jonathanxd.codeapi.base.impl.LabelImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodFragmentImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl;
import com.github.jonathanxd.codeapi.base.impl.OperateImpl;
import com.github.jonathanxd.codeapi.base.impl.ReturnImpl;
import com.github.jonathanxd.codeapi.base.impl.SwitchStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.ThrowExceptionImpl;
import com.github.jonathanxd.codeapi.base.impl.TryStatementImpl;
import com.github.jonathanxd.codeapi.base.impl.TryWithResourcesImpl;
import com.github.jonathanxd.codeapi.base.impl.VariableAccessImpl;
import com.github.jonathanxd.codeapi.base.impl.VariableOperateImpl;
import com.github.jonathanxd.codeapi.base.impl.WhileStatementImpl;
import com.github.jonathanxd.codeapi.builder.AnnotationDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.ClassDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.ConcatHelper;
import com.github.jonathanxd.codeapi.builder.ConstructorDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.EnumDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.IfExpressionHelper;
import com.github.jonathanxd.codeapi.builder.InterfaceDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.MethodDeclarationBuilder;
import com.github.jonathanxd.codeapi.builder.OperateHelper;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.IterationType;
import com.github.jonathanxd.codeapi.common.IterationTypes;
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.MethodTypeSpec;
import com.github.jonathanxd.codeapi.common.Scope;
import com.github.jonathanxd.codeapi.common.SwitchType;
import com.github.jonathanxd.codeapi.common.SwitchTypes;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.types.PlainCodeType;
import com.github.jonathanxd.codeapi.util.ArrayToList;
import com.github.jonathanxd.codeapi.util.BiMultiVal;
import com.github.jonathanxd.codeapi.util.ModifierUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static AnnotationDeclarationBuilder annotationBuilder() {
        return new AnnotationDeclarationBuilder();
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name}.
     *
     * @param type Property type.
     * @param name Property name.
     * @return Property.
     */
    public static AnnotationProperty property(CodeType type, String name) {
        return factory__property(Collections.emptyList(), type, name, null);
    }

    /**
     * Create an annotation property of type {@code type} and name {@code name}.
     *
     * @param type Property type.
     * @param name Property name.
     * @return Property.
     */
    public static AnnotationProperty property(Class<?> type, String name) {
        return factory__property(Collections.emptyList(), CodeAPI.toCodeType(type), name, null);
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
        return factory__property(Collections.emptyList(), type, name, value);
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
        return factory__property(Collections.emptyList(), CodeAPI.toCodeType(type), name, value);
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

        return new AnnotationPropertyImpl(type, name, annotationList, value);
    }

    // =========================================================
    //          Interfaces
    // =========================================================

    /**
     * Create a {@link InterfaceDeclarationBuilder}.
     *
     * @return New {@link InterfaceDeclarationBuilder}.
     */
    public static InterfaceDeclarationBuilder anInterfaceBuilder() {
        return new InterfaceDeclarationBuilder();
    }

    // =========================================================
    //          Classes
    // =========================================================

    /**
     * Create a {@link ClassDeclarationBuilder}.
     *
     * @return New {@link ClassDeclarationBuilder}.
     */
    public static ClassDeclarationBuilder aClassBuilder() {
        return new ClassDeclarationBuilder();
    }


    // =========================================================
    //          Enums
    // =========================================================

    /**
     * Creates a new enum builder.
     *
     * @return New enum builder
     */
    public static EnumDeclarationBuilder enumBuilder() {
        return new EnumDeclarationBuilder();
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
        return new EnumEntryImpl(spec, arguments, name, body);
    }

    // =========================================================
    //          Methods
    // =========================================================

    /**
     * Create a {@link MethodDeclarationBuilder}.
     *
     * @return New {@link MethodDeclarationBuilder}.
     */
    public static MethodDeclarationBuilder methodBuilder() {
        return new MethodDeclarationBuilder();
    }

    // =========================================================
    //          Constructors
    // =========================================================

    /**
     * Create a {@link ConstructorDeclarationBuilder}.
     *
     * @return New {@link ConstructorDeclarationBuilder}.
     */
    public static ConstructorDeclarationBuilder constructorBuilder() {
        return new ConstructorDeclarationBuilder();
    }

    // =========================================================
    //          Fields
    // =========================================================

    // ** Source **
    public static FieldDeclaration field(int modifiers, CodeType type, String name, CodePart value) {
        return field__factory(modifiers, type, name, value);
    }

    public static FieldDeclaration field(int modifiers, CodeType type, String name) {
        return field__factory(modifiers, type, name, null);
    }

    public static FieldDeclaration field(CodeType type, String name, CodePart value) {
        return field__factory(0, type, name, value);
    }

    public static FieldDeclaration field(CodeType type, String name) {
        return field__factory(0, type, name, null);
    }

    /// Class
    public static FieldDeclaration field(int modifiers, Class<?> type, String name, CodePart value) {
        return field__factory(modifiers, Helper.getJavaType(type), name, value);
    }

    public static FieldDeclaration field(int modifiers, Class<?> type, String name) {
        return field__factory(modifiers, Helper.getJavaType(type), name, null);
    }

    public static FieldDeclaration field(Class<?> type, String name, CodePart value) {
        return field__factory(0, Helper.getJavaType(type), name, value);
    }

    public static FieldDeclaration field(Class<?> type, String name) {
        return field__factory(0, Helper.getJavaType(type), name, null);
    }

    // Factory
    private static FieldDeclaration field__factory(int modifiers, CodeType type, String name, CodePart value) {
        return new FieldDeclarationImpl(Collections.emptyList(), value, ModifierUtil.extractModifiers(modifiers), name, type);
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
        return new ArrayConstructorImpl(ArrayToList.toList(arguments), arrayType, ArrayToList.toList(dimensions));
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
        return new ArrayLengthImpl(access.getVariableType(), access);
    }

    private static ArrayLoad getArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType) {
        return new ArrayLoadImpl(index, access, access.getVariableType(), arrayType);
    }

    private static ArrayStore setArrayValue__factory(CodePart index, VariableAccess access, CodeType arrayType, CodePart value) {
        return new ArrayStoreImpl(index, access, access.getVariableType(), value, arrayType);
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
        return new ReturnImpl(valueType, value);
    }

    public static Return returnValue(Class<?> valueType, CodePart value) {
        return new ReturnImpl(Helper.getJavaType(valueType), value);
    }

    public static Return returnLocalVariable(CodeType fieldType, String fieldName) {
        return new ReturnImpl(fieldType, CodeAPI.accessLocalVariable(fieldType, fieldName));
    }

    public static Return returnLocalVariable(Class<?> fieldType, String fieldName) {
        return new ReturnImpl(Helper.getJavaType(fieldType), CodeAPI.accessLocalVariable(Helper.getJavaType(fieldType), fieldName));
    }

    public static Return returnThisField(CodeType fieldType, String fieldName) {
        return new ReturnImpl(fieldType, CodeAPI.accessThisField(fieldType, fieldName));
    }

    public static Return returnThisField(Class<?> fieldType, String fieldName) {
        return new ReturnImpl(Helper.getJavaType(fieldType), CodeAPI.accessThisField(Helper.getJavaType(fieldType), fieldName));
    }

    public static Return returnStaticField(CodeType localization, Class<?> fieldType, String fieldName) {
        return new ReturnImpl(Helper.getJavaType(fieldType), CodeAPI.accessStaticField(localization, Helper.getJavaType(fieldType), fieldName));
    }

    public static Return returnStaticField(Class<?> localization, Class<?> fieldType, String fieldName) {
        return new ReturnImpl(Helper.getJavaType(fieldType), CodeAPI.accessStaticField(Helper.getJavaType(localization), Helper.getJavaType(fieldType), fieldName));
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
        return new CodeParameter(type, name);
    }

    /**
     * Create a {@link CodeParameter parameter}.
     *
     * @param type Parameter value type.
     * @param name Name of the parameter.
     * @return {@link CodeParameter} instance.
     */
    public static CodeParameter parameter(Class<?> type, String name) {
        return new CodeParameter(Helper.getJavaType(type), name);
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
        return invokeConstructor__factory(type, constructorTypeSpec(new CodeType[0]), Collections.emptyList());
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
        return invoke__factory(InvokeType.INVOKE_STATIC, localization, localization, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_STATIC, null, null, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, localization, target, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, null, CodeAPI.accessThis(), ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_INTERFACE, null, CodeAPI.accessThis(), ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_INTERFACE, localization, target, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
    }

    /**
     * Invoke a special method of current type declaration.
     *
     * <table summary="">
     * <tr><th>Special Invocation cases</th></tr>
     * <tr><td>Constructor Methods</td></tr>
     * <tr><td>Super class methods</td></tr>
     * <tr><td>Private methods</td></tr>
     * </table>
     *
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of special method.
     */
    public static MethodInvocation invokeSpecial(String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_SPECIAL, null, CodeAPI.accessThis(), ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
    }

    /**
     * Invoke a special method (aka super.method invocations).
     *
     * <table summary="">
     * <tr><th>Special Invocation cases</th></tr>
     * <tr><td>Constructor Methods</td></tr>
     * <tr><td>Super class methods</td></tr>
     * <tr><td>Private methods</td></tr>
     * </table>
     *
     * @param localization      Localization of the method.
     * @param target            Instance.
     * @param methodName        Name of the method.
     * @param methodDescription Method type description.
     * @param arguments         Method arguments.
     * @return Invocation of special method.
     */
    public static MethodInvocation invokeSpecial(CodeType localization, CodePart target, String methodName, TypeSpec methodDescription, CodeArgument... arguments) {
        return invoke__factory(InvokeType.INVOKE_SPECIAL, localization, target, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invokeConstructor__factory(Helper.getJavaType(type), new TypeSpec(PredefinedTypes.VOID), Collections.emptyList());
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
        return invoke__factory(InvokeType.INVOKE_STATIC, Helper.getJavaType(localization), Helper.getJavaType(localization), ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_VIRTUAL, Helper.getJavaType(localization), target, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
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
        return invoke__factory(InvokeType.INVOKE_INTERFACE, Helper.getJavaType(localization), target, ArrayToList.toList(arguments),
                spec__factory(methodName, methodDescription, MethodType.METHOD));
    }

    // Factory

    private static MethodSpecification spec__factory(String methodName, TypeSpec methodDescription, MethodType methodType) {
        return new MethodSpecificationImpl(methodType, methodName, methodDescription);
    }

    private static MethodInvocation invoke__factory(InvokeType invokeType, CodeType localization, CodePart target, List<CodeArgument> arguments, MethodSpecification methodSpecification) {
        return new MethodInvocationImpl(localization, arguments, methodSpecification, invokeType, null, target);
    }

    private static MethodInvocation invokeDynamic__factory(InvokeDynamic invokeDynamic, MethodInvocation methodInvocation) {
        MethodSpecification spec = methodInvocation.getSpec();

        MethodSpecification newSpec = new MethodSpecificationImpl(spec.getMethodType().toDynamic(), spec.getMethodName(), spec.getDescription());

        return new MethodInvocationImpl(methodInvocation.getLocalization(), methodInvocation.getArguments(), newSpec, methodInvocation.getInvokeType(), invokeDynamic, methodInvocation.getTarget());
    }

    private static MethodInvocation invokeDynamic__factory(InvokeDynamic.LambdaFragment fragment) {
        MethodFragment methodFragment = fragment.getMethodFragment();

        MethodSpecification spec = methodFragment.getSpec();


        MethodSpecification newSpec = new MethodSpecificationImpl(spec.getMethodType(), spec.getMethodName(), spec.getDescription());

        return new MethodInvocationImpl(methodFragment.getLocalization(),
                methodFragment.getArguments(),
                newSpec,
                methodFragment.getInvokeType(),
                fragment,
                methodFragment.getTarget());
    }

    private static MethodInvocation invokeConstructor__factory(CodeType type, TypeSpec spec, List<CodeArgument> arguments) {
        return new MethodInvocationImpl(type, arguments, new MethodSpecificationImpl(MethodType.CONSTRUCTOR, "<init>", spec), InvokeType.INVOKE_SPECIAL, null, type);
    }

    /*
        public static MethodInvocation invokeSuperInit(CodeType localization, CodeArgument... arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(),
                new MethodSpecImpl("<init>", PredefinedTypes.VOID, Arrays.asList(arguments), MethodType.SUPER_CONSTRUCTOR));
    }

    public static MethodInvocation invokeSuperInit(CodeType localization, TypeSpec spec, CodeArgument... arguments) {
        return new MethodInvocationImpl(InvokeType.INVOKE_SPECIAL, localization, accessSuper(),
                new MethodSpecImpl("<init>", spec, Arrays.asList(arguments), MethodType.SUPER_CONSTRUCTOR));
    }

     */

    private static MethodInvocation invokeSuperConstructor__factory(CodeType type, TypeSpec constructorSpec, CodeArgument... arguments) {
        return new MethodInvocationImpl(type, ArrayToList.toList(arguments), new MethodSpecificationImpl(MethodType.SUPER_CONSTRUCTOR, "<init>", constructorSpec), InvokeType.INVOKE_SPECIAL, null, CodeAPI.accessSuper());
    }

    private static MethodInvocation invokeThisConstructor__factory(TypeSpec constructorSpec, CodeArgument... arguments) {
        return new MethodInvocationImpl(null, ArrayToList.toList(arguments), new MethodSpecificationImpl(MethodType.SUPER_CONSTRUCTOR, "<init>", constructorSpec), InvokeType.INVOKE_SPECIAL, null, CodeAPI.accessThis());
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
        return accessField__Factory(null, null, declaration.getVariableType(), declaration.getName());
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
        return accessField__Factory(null, CodeAPI.accessThis(), fieldType, name);
    }

    /**
     * Access a local variable.
     *
     * @param variableType Type of the variable value.
     * @param name         Name of the variable.
     * @return Access to variable.
     */
    public static VariableAccess accessLocalVariable(CodeType variableType, String name) {
        return accessField__Factory(null, CodeAPI.accessLocal(), variableType, name);
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
        return accessField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name);
    }

    /**
     * Access a local variable.
     *
     * @param variableType Type of the variable value.
     * @param name         Name of the variable.
     * @return Access to variable.
     */
    public static VariableAccess accessLocalVariable(Class<?> variableType, String name) {
        return accessField__Factory(null, CodeAPI.accessLocal(), Helper.getJavaType(variableType), name);
    }

    // Factory
    private static VariableAccess accessField__Factory(CodeType localization, CodePart at, CodeType type, String name) {
        return new VariableAccessImpl(at, name, localization, type);
    }

    // =========================================================
    //          Set Variables & Fields
    // =========================================================


    public static VariableDeclaration setDeclarationValue(VariableDeclaration declaration, CodePart value) {
        return setField__Factory(null, null, declaration.getVariableType(), declaration.getName(), value);
    }

    public static FieldDeclaration setStaticThisField(CodeType fieldType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessThis(), fieldType, name, value);
    }

    public static FieldDeclaration setStaticField(CodeType localization, CodeType fieldType, String name, CodePart value) {
        return setField__Factory(localization, null, fieldType, name, value);
    }

    public static FieldDeclaration setField(CodeType localization, CodePart at, CodeType fieldType, String name, CodePart value) {
        return setField__Factory(localization, at, fieldType, name, value);
    }

    public static FieldDeclaration setThisField(CodeType fieldType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessThis(), fieldType, name, value);
    }

    public static VariableDeclaration setLocalVariable(CodeType variableType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessLocal(), variableType, name, value);
    }

    // Class

    public static FieldDeclaration setStaticThisField(Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, value);
    }

    public static FieldDeclaration setStaticField(Class<?> localization, Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(Helper.getJavaType(localization), null, Helper.getJavaType(fieldType), name, value);
    }

    public static FieldDeclaration setField(Class<?> localization, CodePart at, Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(Helper.getJavaType(localization), at, Helper.getJavaType(fieldType), name, value);
    }

    public static FieldDeclaration setThisField(Class<?> fieldType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, value);
    }

    public static VariableDeclaration setLocalVariable(Class<?> variableType, String name, CodePart value) {
        return setField__Factory(null, CodeAPI.accessLocal(), Helper.getJavaType(variableType), name, value);
    }

    // Factory
    private static FieldDeclaration setField__Factory(CodeType localization, CodePart at, CodeType type, String name, CodePart value) {
        return new FieldDeclarationImpl(Collections.emptyList(), value, Collections.emptySet(), name, type);
    }

    // =========================================================
    //          Operate Variables & Fields & Values
    // =========================================================

    public static Operate operate(CodePart part, Operator operation, CodePart value) {
        return factory__operate(part, operation, value);
    }

    public static VariableOperate operateDeclarationValue(VariableDeclaration declaration, Operator operation, CodePart value) {
        return operateField__Factory(null, null, declaration.getVariableType(), declaration.getName(), operation, value);
    }

    public static VariableOperate operateDeclarationValue(VariableDeclaration declaration, Operator operation) {
        return operateField__Factory(null, null, declaration.getVariableType(), declaration.getName(), operation, null);
    }

    public static VariableOperate operateStaticThisField(CodeType fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, CodeAPI.accessThis(), fieldType, name, operation, value);
    }

    public static VariableOperate operateStaticThisField(CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessThis(), fieldType, name, operation, null);
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
        return operateField__Factory(null, CodeAPI.accessThis(), fieldType, name, operation, value);
    }

    public static VariableOperate operateThisField(CodeType fieldType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessThis(), fieldType, name, operation, null);
    }

    public static VariableOperate operateLocalVariable(CodeType variableType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, CodeAPI.accessLocal(), variableType, name, operation, value);
    }

    public static VariableOperate operateLocalVariable(CodeType variableType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessLocal(), variableType, name, operation, null);
    }

    // Class

    public static VariableOperate operateStaticThisField(Class<?> fieldType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateStaticThisField(Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, operation, null);
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
        return operateField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, operation, value);
    }

    public static VariableOperate operateThisField(Class<?> fieldType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessThis(), Helper.getJavaType(fieldType), name, operation, null);
    }

    public static VariableOperate operateLocalVariable(Class<?> variableType, String name, Operator operation, CodePart value) {
        return operateField__Factory(null, CodeAPI.accessLocal(), Helper.getJavaType(variableType), name, operation, value);
    }

    public static VariableOperate operateLocalVariable(Class<?> variableType, String name, Operator operation) {
        return operateField__Factory(null, CodeAPI.accessLocal(), Helper.getJavaType(variableType), name, operation, null);
    }

    // Factory
    private static VariableOperate operateField__Factory(CodeType localization, CodePart at, CodeType type, String name, Operator operation, CodePart value) {
        return new VariableOperateImpl(at, name, localization, type, value, operation);
    }

    private static Operate factory__operate(CodePart part, Operator operation, CodePart value) {
        return new OperateImpl(part, operation, value);
    }

    // =========================================================
    //          Throw Exceptions
    // =========================================================

    public static ThrowException throwException(CodePart partToThrow) {
        return throwException__Factory(partToThrow);
    }

    // Factory

    private static ThrowException throwException__Factory(CodePart partToThrow) {
        return new ThrowExceptionImpl(partToThrow);
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
        return new AnnotationImpl(isVisible, annotationType, values);
    }

    // =========================================================
    //          Annotations & Case Enum Values
    // =========================================================

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @param ordinal  Ordinal value of enum entry.
     * @return Enum value
     */
    public static EnumValue enumValue(Class<?> enumType, String entry, int ordinal) {
        return enumValue__factory(CodeAPI.toCodeType(enumType), entry, ordinal);
    }

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(Class<?> enumType, String entry) {
        return enumValue__factory(CodeAPI.toCodeType(enumType), entry, -1);
    }

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @param ordinal  Ordinal value of enum entry.
     * @return Enum value
     */
    public static EnumValue enumValue(CodeType enumType, String entry, int ordinal) {
        return enumValue__factory(enumType, entry, ordinal);
    }

    /**
     * EnumValue of an Annotation property.
     *
     * @param enumType Type of enum
     * @param entry    Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(CodeType enumType, String entry) {
        return enumValue__factory(enumType, entry, -1);
    }

    /**
     * EnumValue in Case check.
     *
     * @param entry Enum entry (aka Field)
     * @return Enum value
     */
    public static EnumValue enumValue(String entry) {
        return enumValue__factory(null, entry, -1);
    }

    // Factory

    private static EnumValue enumValue__factory(CodeType enumType, String entry, int ordinal) {
        return new EnumValueImpl(enumType, entry, ordinal);
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
        return new TypeSpec(returnType, ArrayToList.toList(parameterTypes));
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
    public static Cast cast(CodeType fromType, CodeType toType, CodePart partToCast) {
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
    public static Cast cast(Class<?> fromType, Class<?> toType, CodePart partToCast) {
        return cast__Factory(toCodeType(fromType), toCodeType(toType), partToCast);
    }

    // Factory
    private static Cast cast__Factory(CodeType fromType, CodeType toType, CodePart partToCast) {
        return new CastImpl(fromType, toType, partToCast);
    }

    // =========================================================
    //          If statement
    // =========================================================

    /**
     * Create a if statement.
     *
     * @param expressions Expressions.
     * @param body        Body of the if.
     * @param elseStatement   Else statement of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(List<CodePart> expressions, CodeSource body, CodeSource elseStatement) {
        return ifStatement__Factory(expressions, body, elseStatement);
    }

    /**
     * Create a if statement.
     *
     * @param expressions Expressions.
     * @param body        Body of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(List<CodePart> expressions, CodeSource body) {
        return ifStatement__Factory(expressions, body, null);
    }

    /**
     * Create a if statement.
     *
     * @param groups    Expressions.
     * @param body      Body of the if.
     * @param elseStatement Else statement of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, CodeSource elseStatement) {
        return ifStatement__Factory(groups, body, elseStatement);
    }

    /**
     * Create a if statement.
     *
     * @param groups Expressions.
     * @param body   Body of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body) {
        return ifStatement__Factory(groups, body, null);
    }


    /**
     * Create a if statement.
     *
     * @param ifExpr    Expression.
     * @param body      Body of the if.
     * @param elseStatement Else statement of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(IfStatement ifExpr, CodeSource body, CodeSource elseStatement) {
        return ifStatement__Factory(CodeAPI.ifExprs(ifExpr), body, elseStatement);
    }

    /**
     * Create a if statement.
     *
     * @param ifExpr Expression.
     * @param body   Body of the if.
     * @return If statement.
     */
    public static IfStatement ifStatement(IfStatement ifExpr, CodeSource body) {
        return ifStatement__Factory(CodeAPI.ifExprs(ifExpr), body, CodeSource.empty());
    }


    // Factory
    private static IfStatement ifStatement__Factory(BiMultiVal<CodePart, IfExpr, Operator> groups, CodeSource body, CodeSource elseStatement) {
        return new IfStatementImpl(groups.toList(), body, elseStatement);
    }

    private static IfStatement ifStatement__Factory(List<CodePart> check, CodeSource body, CodeSource elseStatement) {
        return new IfStatementImpl(check, body, elseStatement);
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
        return new IfExprImpl(part, Operators.NOT_EQUAL_TO, Literals.NULL);
    }

    /**
     * Check if a part is null.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkNull(CodePart part) {
        return new IfExprImpl(part, Operators.EQUAL_TO, Literals.NULL);
    }

    /**
     * Check if a expression is true.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkTrue(CodePart part) {
        return new IfExprImpl(part, Operators.EQUAL_TO, Literals.TRUE);
    }

    /**
     * Check if a expression is false.
     *
     * @param part Part to check.
     * @return The verification part.
     */
    public static IfExpr checkFalse(CodePart part) {
        return new IfExprImpl(part, Operators.EQUAL_TO, Literals.FALSE);
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
        return new IfExprImpl(part1, operator, part2);
    }

    public static IfExpressionHelper expressionHelper() {
        return IfExpressionHelper.builder();
    }

    // =========================================================
    //          Lables
    // =========================================================

    /**
     * Create a label.
     *
     * @param name Name of the label
     * @param body Body of label.
     * @return new label.
     */
    public static Label label(String name, CodeSource body) {
        return new LabelImpl(name, body);
    }

    // =========================================================
    //          Break and Continue
    // =========================================================

    /**
     * Break the flow
     * @return Break ControlFlow
     */
    public static ControlFlow aBreak() {
        return CodeAPI.break__Factory(null);
    }

    /**
     * Break the flow
     *
     * @param label Label to break.
     * @return Break ControlFlow
     */
    public static ControlFlow aBreak(Label label) {
        return CodeAPI.break__Factory(label);
    }

    /**
     * Continue the flow
     * @return Continue ControlFlow
     */
    public static ControlFlow aContinue() {
        return CodeAPI.continue__Factory(null);
    }

    /**
     * Continue the flow
     *
     * @param label Label to continue.
     * @return Continue ControlFlow
     */
    public static ControlFlow aContinue(Label label) {
        return CodeAPI.continue__Factory(label);
    }

    // Factory
    private static ControlFlow break__Factory(Label label) {
        return new ControlFlowImpl(ControlFlow.Type.BREAK, label);
    }

    private static ControlFlow continue__Factory(Label label) {
        return new ControlFlowImpl(ControlFlow.Type.CONTINUE, label);
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
    public static InstanceOfCheck isInstanceOf(CodePart part, CodeType type) {
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
    public static InstanceOfCheck isInstanceOf(CodePart part, Class<?> type) {
        return isInstanceOf__Factory(part, toCodeType(type));
    }

    // Factory
    private static InstanceOfCheck isInstanceOf__Factory(CodePart part, CodeType type) {
        return new InstanceOfCheckImpl(part, type);
    }

    // =========================================================
    //          Try statement
    // =========================================================

    /**
     * Create a try-catch-finally statement.
     *
     * @param toSurround    Code to surround.
     * @param catchStatements   Catch statements.
     * @param finallySource Finally statement.
     * @return Try-Catch-Finally statement.
     */
    public static TryStatement tryStatement(CodeSource toSurround, List<CatchStatement> catchStatements, CodeSource finallySource) {
        return tryStatement__Factory(toSurround, catchStatements, finallySource);
    }

    /**
     * Create a try-catch-finally statement.
     *
     * @param toSurround    Code to surround.
     * @param catchStatement    Catch statement.
     * @param finallySource Finally statement.
     * @return Try-Catch-Finally statement.
     */
    public static TryStatement tryStatement(CodeSource toSurround, CatchStatement catchStatement, CodeSource finallySource) {
        return tryStatement__Factory(toSurround, Collections.singletonList(catchStatement), finallySource);
    }

    /**
     * Create a try-catch statement.
     *
     * @param toSurround  Code to surround.
     * @param catchStatements Catch statements.
     * @return Try-Catch statement.
     */
    public static TryStatement tryStatement(CodeSource toSurround, List<CatchStatement> catchStatements) {
        return tryStatement__Factory(toSurround, catchStatements, null);
    }

    /**
     * Create a try-catch statement.
     *
     * @param toSurround Code to surround.
     * @param catchStatement Catch statement.
     * @return Try-Catch statement.
     */
    public static TryStatement tryStatement(CodeSource toSurround, CatchStatement catchStatement) {
        return tryStatement__Factory(toSurround, Collections.singletonList(catchStatement), null);
    }

    // Factory
    private static TryStatement tryStatement__Factory(CodeSource toSurround, List<CatchStatement> catchStatements, CodeSource finallySource) {

        return new TryStatementImpl(toSurround, catchStatements, finallySource);
    }

    // =========================================================
    //          Catch statement
    // =========================================================

    /**
     * Create a catch statement for try-catch statement.
     *
     * @param exception Exception type to handle.
     * @param variable  Variable to store exception.
     * @param body      Body of the catch statement.
     * @return Catch statement.
     */
    public static CatchStatement catchStatement(CodeType exception, VariableDeclaration variable, CodeSource body) {
        return catchStatement__Factory(Collections.singletonList(exception), variable, body);
    }

    /**
     * Create a catch statement for try-catch statement.
     *
     * @param exceptions Exception types.
     * @param variable   Variable to store exception.
     * @param body       Body of the catch statement.
     * @return Catch statement.
     */
    public static CatchStatement catchStatement(List<CodeType> exceptions, VariableDeclaration variable, CodeSource body) {
        return catchStatement__Factory(exceptions, variable, body);
    }

    // Factory
    private static CatchStatement catchStatement__Factory(List<CodeType> exceptionTypes, VariableDeclaration exceptionVariable, CodeSource body) {
        return new CatchStatementImpl(exceptionTypes, body, exceptionVariable);
    }

    // =========================================================
    //          Try With resources statement
    // =========================================================

    /**
     * Create a try-with-resources statement.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param catchStatements   Catch statements.
     * @param finallySource Finally statement.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround, List<CatchStatement> catchStatements, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, catchStatements, finallySource);
    }

    /**
     * Create a try-with-resources statement.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param catchStatement    Catch statement.
     * @param finallySource Finally statement.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround, CatchStatement catchStatement, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, Collections.singletonList(catchStatement), finallySource);
    }

    /**
     * Create a try-with-resources statement.
     *
     * @param variable      Resource variable
     * @param toSurround    Code to surround.
     * @param finallySource Finally statement.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround, CodeSource finallySource) {
        return tryWithResources__Factory(variable, toSurround, Collections.emptyList(), finallySource);
    }

    /**
     * /**
     * Create a try-with-resources statement.
     *
     * @param variable    Resource variable
     * @param toSurround  Code to surround.
     * @param catchStatements Catch statements.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround, List<CatchStatement> catchStatements) {
        return tryWithResources__Factory(variable, toSurround, catchStatements, null);
    }

    /**
     * /**
     * Create a try-with-resources statement.
     *
     * @param variable   Resource variable
     * @param toSurround Code to surround.
     * @param catchStatement Catch statement.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround, CatchStatement catchStatement) {
        return tryWithResources__Factory(variable, toSurround, Collections.singletonList(catchStatement), null);
    }

    /**
     * Create a try-with-resources statement.
     *
     * @param variable   Resource variable
     * @param toSurround Code to surround.
     * @return Try-with-resources statement.
     */
    public static TryWithResources tryWithResources(VariableDeclaration variable, CodeSource toSurround) {
        return tryWithResources__Factory(variable, toSurround, Collections.emptyList(), null);
    }

    // Factory
    private static TryWithResources tryWithResources__Factory(VariableDeclaration variable, CodeSource toSurround, List<CatchStatement> catchStatements, CodeSource finallySource) {
        return new TryWithResourcesImpl(variable, catchStatements, finallySource, toSurround);
    }

    // =========================================================
    //          WhileStatement
    // =========================================================

    public static WhileStatement whileStatement(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return whileStatement__Factory(parts, source);
    }

    // Factory
    private static WhileStatement whileStatement__Factory(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return new WhileStatementImpl(WhileStatement.Type.WHILE, parts.toList(), source);
    }

    // =========================================================
    //          DoWhileStatement
    // =========================================================

    /**
     * Create a do-while statement.
     *
     * @param parts  Expression.
     * @param source Source.
     * @return Do-while statement.
     */
    public static WhileStatement doWhileStatement(BiMultiVal<CodePart, IfExpr, Operator> parts, CodeSource source) {
        return doWhileStatement__Factory(source, parts);
    }

    // Factory
    private static WhileStatement doWhileStatement__Factory(CodeSource source, BiMultiVal<CodePart, IfExpr, Operator> parts) {
        return new WhileStatementImpl(WhileStatement.Type.DO_WHILE, parts.toList(), source);
    }

    // =========================================================
    //          ForStatement
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
    public static ForStatement forStatement(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> condition, CodePart update, CodeSource body) {
        return forStatement__Factory(initialization, condition, update, body);
    }

    // Factory
    private static ForStatement forStatement__Factory(CodePart initialization, BiMultiVal<CodePart, IfExpr, Operator> condition, CodePart update, CodeSource body) {
        return new ForStatementImpl(initialization, condition.toList(), update, body);
    }

    // =========================================================
    //          ForeachStatement
    // =========================================================

    /**
     * Create a ForEach statement.
     *
     * <pre>{@code
     * forEachStatement(field IterationType expression) body
     * }</pre>
     *
     * @param field         Variable to store values.
     * @param iterationType Iteration type (constants: {@link IterationTypes}).
     * @param expression    Expression.
     * @param body          For each statement.
     * @return ForEach statement.
     */
    public static ForEachStatement forEachStatement(FieldDeclaration field, IterationType iterationType, CodePart expression, CodeSource body) {
        return forEachStatement__Factory(field, iterationType, expression, body);
    }

    /**
     * ForEach statement iterating an array.
     *
     * <pre>{@code
     * forEachStatement(field : expression) body
     * }</pre>
     *
     * @param variable      Variable to store values.
     * @param expression Expression (the array).
     * @param body       ForEach body.
     * @return ForEach statement iterating an array.
     */
    public static ForEachStatement forEachArray(VariableDeclaration variable, CodePart expression, CodeSource body) {
        return forEachStatement__Factory(variable, IterationTypes.ARRAY, expression, body);
    }

    /**
     * ForEach statement iterating an iterable element.
     *
     * <pre>{@code
     * forEachStatement(field : expression) body
     * }</pre>
     *
     * @param variable      Variable to store values.
     * @param expression Expression (the iterable object).
     * @param body       ForEach body.
     * @return ForEach statement iterating an iterable element.
     */
    public static ForEachStatement forEachIterable(VariableDeclaration variable, CodePart expression, CodeSource body) {
        return forEachStatement__Factory(variable, IterationTypes.ITERABLE_ELEMENT, expression, body);
    }

    // Factory
    private static ForEachStatement forEachStatement__Factory(VariableDeclaration variable, IterationType iterationType, CodePart expression, CodeSource body) {
        return new ForEachStatementImpl(variable, iterationType, expression, body);
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
    public static MethodTypeSpec methodTypeSpec(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return methodTypeSpec__factory(location, returnType, methodName, parameterTypes);
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
    public static MethodTypeSpec methodTypeSpec(Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return methodTypeSpec__factory(toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static MethodTypeSpec methodTypeSpec__factory(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new MethodTypeSpec(location, methodName, new TypeSpec(returnType, ArrayToList.toList(parameterTypes)));
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
    public static MethodInvokeSpec methodInvokeSpec(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return methodInvokeSpec__factory(invokeType, location, returnType, methodName, parameterTypes);
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
    public static MethodInvokeSpec methodInvokeSpec(InvokeType invokeType, Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        return methodInvokeSpec__factory(invokeType, toCodeType(location), toCodeType(returnType), methodName, toCodeType(parameterTypes));
    }

    // Factory
    private static MethodInvokeSpec methodInvokeSpec__factory(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        return new MethodInvokeSpec(invokeType, new MethodTypeSpec(location, methodName, new TypeSpec(returnType, ArrayToList.toList(parameterTypes))));
    }

    // =========================================================
    //          Method fragment
    // =========================================================

    /**
     * Create a method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragment(TypeDeclaration typeDeclaration, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, scope, returnType, parameters, arguments, body);
    }

    /**
     * Create a static method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(TypeDeclaration typeDeclaration, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, Scope.STATIC, returnType, parameters, arguments, body);
    }

    /**
     * Create a instance method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(TypeDeclaration typeDeclaration, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, Scope.INSTANCE, returnType, parameters, arguments, body);
    }


    // Class

    /**
     * Create a method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param scope         Scope of fragment.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragment(TypeDeclaration typeDeclaration, Scope scope, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, scope, toCodeType(returnType), parameters, arguments, body);
    }

    /**
     * Create a static method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentStatic(TypeDeclaration typeDeclaration, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, Scope.STATIC, toCodeType(returnType), parameters, arguments, body);
    }

    /**
     * Create a instance method fragment.
     *
     * @param typeDeclaration Class to insert method.
     * @param returnType    Return type of method.
     * @param parameters    Parameters of the method.
     * @param arguments     Arguments to pass to method.
     * @param body          Body of method.
     * @return Method fragment.
     */
    public static MethodFragment fragmentInstance(TypeDeclaration typeDeclaration, Class<?> returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {
        return fragment__factory(typeDeclaration, Scope.INSTANCE, toCodeType(returnType), parameters, arguments, body);
    }

    // Factory
    private static MethodFragment fragment__factory(TypeDeclaration typeDeclaration, Scope scope, CodeType returnType, CodeParameter[] parameters, CodeArgument[] arguments, CodeSource body) {

        List<CodeParameter> parameterList = ArrayToList.toList(parameters);

        return new MethodFragmentImpl(typeDeclaration, scope, ArrayToList.toList(arguments),
                new TypeSpec(returnType, parameterList.stream().map(CodeParameter::getType).collect(Collectors.toList())),
                parameterList, body);
    }

    // =========================================================
    //          Switch & Case
    // =========================================================

    public static SwitchStatement switchInt(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.NUMERIC, value, ArrayToList.toList(cases));
    }

    public static SwitchStatement switchString(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.STRING, value, ArrayToList.toList(cases));
    }

    public static SwitchStatement switchEnum(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.ENUM, value, ArrayToList.toList(cases));
    }

    public static SwitchStatement switchObject(Typed value, Case... cases) {
        return switch__factory(SwitchTypes.OBJECT, value, ArrayToList.toList(cases));
    }

    public static SwitchStatement switchDefined(SwitchType switchType, Typed value, Case... cases) {
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
    private static SwitchStatement switch__factory(SwitchType switchType, Typed value, List<Case> caseList) {
        return new SwitchStatementImpl(value, switchType, caseList);
    }

    private static Case case__factory(Typed value, CodeSource body) {
        return new CaseImpl(value, body);
    }


    // =========================================================
    //          Utils
    // =========================================================

    /**
     * Access this {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     *
     * Equivalent to Java {@code this}.
     *
     * @return Access this {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     */
    public static Access accessLocal() {
        return Defaults.ACCESS_LOCAL;
    }

    /**
     * Access this {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     *
     * Equivalent to Java {@code this}.
     *
     * @return Access this {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     */
    public static Access accessThis() {
        return Defaults.ACCESS_THIS;
    }

    /**
     * Access super type of current {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     *
     * Equivalent to Java {@code super}.
     *
     * @return Access super type of current {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     */
    public static Access accessSuper() {
        return Defaults.ACCESS_SUPER;
    }

    /**
     * Access enclosing class of current {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     *
     * Equivalent to Java {@code CLASS.this}.
     *
     * @param localization Localization of outer class.
     * @return Access enclosing class of current {@link com.github.jonathanxd.codeapi.base.TypeDeclaration}.
     */
    public static Access accessOuter(CodeType localization) {
        return Common.accessOuter(localization);
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
    public static CodeType toCodeType(Class<?> aClass) {
        return Helper.getJavaType(aClass);
    }

    /**
     * Convert Java {@link Class classes} to CodeAPI {@link CodeType types}.
     *
     * @param aClass Classes to convert.
     * @return Converted types.
     */
    public static CodeType[] toCodeType(Class<?>[] aClass) {
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

    public static ConcatHelper concatHelper() {
        return ConcatHelper.builder();
    }

    public static ConcatHelper concatHelper(CodePart part) {
        return ConcatHelper.builder(part);
    }

    public static ConcatHelper concatHelper(String str) {
        return ConcatHelper.builder(str);
    }

    public static ConcatHelper concatHelper(CodePart... part) {
        if (part.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper = ConcatHelper.builder(part[0]);

        for (int i = 1; i < part.length; i++) {
            helper = helper.concat(part[i]);
        }

        return helper;
    }

    public static ConcatHelper concatHelper(String... strs) {
        if (strs.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper = ConcatHelper.builder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            helper = helper.concat(strs[i]);
        }

        return helper;
    }

    public static ConcatHelper concatHelperObj(Object... objs) {
        if (objs.length == 0)
            return ConcatHelper.builder();

        ConcatHelper helper;

        Object at0 = objs[0];

        if (at0 instanceof CodePart) {
            helper = ConcatHelper.builder((CodePart) at0);
        } else if (at0 instanceof String) {
            helper = ConcatHelper.builder((String) at0);
        } else {
            throw new IllegalArgumentException("Invalid element type at index 0 (" + at0 + ") in array: '" + Arrays.toString(objs) + "'! Acceptable types: String|CodePart");
        }

        for (int i = 1; i < objs.length; i++) {
            Object atI = objs[i];
            if (at0 instanceof CodePart) {
                helper = helper.concat((CodePart) atI);
            } else if (at0 instanceof String) {
                helper = helper.concat((String) atI);
            } else {
                throw new IllegalArgumentException("Invalid element type at index " + i + " (" + atI + ") in array: '" + Arrays.toString(objs) + "'! Acceptable types: String|CodePart");
            }

        }

        return helper;
    }

    public static OperateHelper operateHelper(CodePart part) {
        return OperateHelper.builder(part);
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
     * Not supported by Java Source Code generation. ({@code PlainSourceGenerator}).
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
            return CodeAPI.invokeDynamic(invokeDynamic, methodInvocation);
        }

        private static MethodInvocation invokeDynamic__factory(InvokeDynamic.LambdaFragment fragment) {
            return CodeAPI.invokeDynamicFragment(fragment);
        }

        // Utils

        /**
         * Invoke Bootstrap methods with bsm parameters
         *
         * @param invokeType     Invocation Type.
         * @param methodTypeSpec Bootstrap method.
         * @param args           BSM Arguments, must be an {@link String}, {@link Integer}, {@link
         *                       Long}, {@link Float}, {@link Double}, {@link CodeType}, or {@link
         *                       MethodInvokeSpec}.
         * @return Bootstrap specification.
         */
        public static InvokeDynamic.Bootstrap bootstrap(InvokeType invokeType, MethodTypeSpec methodTypeSpec, Object... args) {
            return new InvokeDynamic.Bootstrap(methodTypeSpec, invokeType, args);
        }

        /**
         * Invoke a Bootstrap method.
         *
         * @param invokeType     Invocation Type.
         * @param methodTypeSpec Bootstrap method.
         * @return Bootstrap specification.
         */
        public static InvokeDynamic.Bootstrap bootstrap(InvokeType invokeType, MethodTypeSpec methodTypeSpec) {
            return new InvokeDynamic.Bootstrap(methodTypeSpec, invokeType, new Object[0]);
        }

        /**
         * Invoke a lambda method reference.
         *
         * @param methodTypeSpec Method specification ({@link InvokeDynamic}).
         * @param expectedTypes  Expected types.
         * @return Lambda Method Reference specification.
         * @see InvokeDynamic
         */
        public static InvokeDynamic.LambdaMethodReference lambda(MethodTypeSpec methodTypeSpec, TypeSpec expectedTypes) {
            return new InvokeDynamic.LambdaMethodReference(methodTypeSpec, expectedTypes);
        }

        /**
         * Invoke a lambda code.
         *
         * @param methodTypeSpec Method specification ({@link InvokeDynamic}).
         * @param expectedTypes  Expected types.
         * @param methodFragment Fragment to invoke.
         * @return Lambda Method Reference specification.
         * @see InvokeDynamic
         */
        public static InvokeDynamic.LambdaFragment code(MethodTypeSpec methodTypeSpec, TypeSpec expectedTypes, MethodFragment methodFragment) {
            return new InvokeDynamic.LambdaFragment(methodTypeSpec, expectedTypes, methodFragment);
        }

    }

}
