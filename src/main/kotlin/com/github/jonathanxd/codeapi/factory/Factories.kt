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
@file:JvmName("Factories")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.*
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.common.*
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.operator.Operator
import com.github.jonathanxd.codeapi.operator.Operators
import com.github.jonathanxd.codeapi.type.PlainCodeType
import com.github.jonathanxd.codeapi.util.Alias
import java.lang.reflect.Type
import java.util.*

// Access

/**
 * @see Access
 */
fun accessStatic(): Access = Defaults.ACCESS_STATIC

/**
 * @see Access
 */
fun accessLocal(): Access = Defaults.ACCESS_LOCAL

/**
 * @see Access
 */
fun accessThis(): Access = Defaults.ACCESS_THIS

/**
 * @see Access
 */
fun accessSuper(): Access = Defaults.ACCESS_SUPER


// Annotations

/**
 * @see Annotation
 */
@JvmOverloads
fun annotation(visible: Boolean, type: Type, values: Map<String, Any> = emptyMap()): Annotation =
        Annotation(type, values, visible)

/**
 * @see Annotation
 */
@JvmOverloads
fun visibleAnnotation(type: Type, values: Map<String, Any> = emptyMap()): Annotation =
        annotation(true, type, values)

/**
 * @see Annotation
 */
@JvmOverloads
fun invisibleAnnotation(type: Type, values: Map<String, Any> = emptyMap()): Annotation =
        annotation(false, type, values)

/**
 * @see Annotation
 */
fun overrideAnnotation(): Annotation = visibleAnnotation(Override::class.java, mapOf())

/**
 * @see Annotation
 */
fun deprecatedAnnotation(): Annotation = visibleAnnotation(Deprecated::class.java, mapOf())

/**
 * @see Annotation
 */
@JvmOverloads
fun annotationProperty(comments: Comments = Comments.Absent, annotations: List<Annotation> = emptyList(), type: Type, name: String, defaultValue: Any?): AnnotationProperty =
        AnnotationProperty(comments, annotations, type, name, defaultValue)


// Arrays

/**
 * @see ArrayConstructor
 */
fun createArray(arrayType: Type, dimensions: List<CodeInstruction>, arguments: List<CodeInstruction>): ArrayConstructor =
        ArrayConstructor(arrayType, dimensions, arguments)

/**
 * @see ArrayStore
 */
fun setArrayValue(arrayType: Type, target: CodeInstruction, index: CodeInstruction, valueType: Type, valueToStore: CodeInstruction): ArrayStore =
        ArrayStore(arrayType, target, index, valueType, valueToStore)

/**
 * @see ArrayLoad
 */
fun accessArrayValue(arrayType: Type, target: CodeInstruction, index: CodeInstruction, valueType: Type): ArrayLoad =
        ArrayLoad(arrayType, target, index, valueType)

/**
 * @see ArrayLength
 */
fun arrayLength(arrayType: Type, target: CodeInstruction): ArrayLength =
        ArrayLength(arrayType, target)

// Enum

/**
 * @see EnumEntry
 */
fun enumEntry(name: String): EnumEntry =
        EnumEntry.Builder.builder()
                .name(name)
                .build()

/**
 * @see EnumValue
 */
@JvmOverloads
fun enumValue(enumType: Type, enumEntry: String, ordinal: Int = -1): EnumValue =
        EnumValue(enumType, enumEntry, ordinal)



// Variable

/**
 * @see VariableAccess
 */
fun accessVariable(type: Type, name: String): VariableAccess =
        VariableAccess(type, name)

/**
 * @see VariableAccess
 */
fun accessVariable(variable: VariableBase): VariableAccess =
        accessVariable(variable.type, variable.name)

/**
 * @see VariableDefinition
 */
fun setVariableValue(type: Type, name: String, value: CodeInstruction): VariableDefinition =
        VariableDefinition(type, name, value)

// Field

/**
 * @see FieldAccess
 */
fun accessField(localization: Type, target: CodeInstruction, type: Type, name: String): FieldAccess =
        FieldAccess(localization, target, type, name)

/**
 * @see FieldAccess
 */
fun accessThisField(type: Type, name: String): FieldAccess =
        accessField(Alias.THIS, accessThis(), type, name)

/**
 * @see FieldAccess
 */
@JvmOverloads
fun accessStaticField(localization: Type = Alias.THIS, type: Type, name: String): FieldAccess =
        accessField(localization, accessStatic(), type, name)

/**
 * @see FieldDefinition
 */
fun setFieldValue(localization: Type, target: CodeInstruction, type: Type, name: String, value: CodeInstruction): FieldDefinition =
        FieldDefinition(localization, target, type, name, value)

/**
 * @see FieldDefinition
 */
fun setThisFieldValue(type: Type, name: String, value: CodeInstruction): FieldDefinition =
        setFieldValue(Alias.THIS, Access.THIS, type, name, value)

/**
 * @see FieldDefinition
 */
@JvmOverloads
fun setStaticFieldValue(localization: Type = Alias.THIS, type: Type, name: String, value: CodeInstruction): FieldDefinition =
        setFieldValue(localization, Access.STATIC, type, name, value)

/**
 * Invoke getter of a field (`get`+`capitalize(fieldName)`).
 *
 * @param invokeType Type of invocation
 * @param localization Localization of getter
 * @param target Target of invocation
 * @param type Type of field.
 * @param name Name of field.
 */
fun invokeFieldGetter(invokeType: InvokeType, localization: Type, target: CodeInstruction, type: Type, name: String): MethodInvocation =
        invoke(invokeType, localization, target, "get${name.capitalize()}", TypeSpec(type), emptyList())

/**
 * Invoke setter of a field (`set`+`capitalize(fieldName)`) with [value].
 *
 * @param invokeType Type of invocation
 * @param localization Localization of setter
 * @param target Target of invocation
 * @param type Type of field.
 * @param name Name of field.
 * @param value Value to pass to setter
 */
fun invokeFieldSetter(invokeType: InvokeType, localization: Type, target: CodeInstruction, type: Type, name: String, value: CodeInstruction): MethodInvocation =
        invoke(invokeType, localization, target, "set${name.capitalize()}", TypeSpec(Void.type, listOf(type)), listOf(value))

// Return

/**
 * @see Return
 */
fun returnValue(type: Type, value: CodeInstruction) = Return(type, value)

/**
 * Void return (Java: `return;`)
 * @see Return
 */
fun returnVoid(): Return = returnValue(Void.type, Void)

// Parameter

/**
 * @see CodeParameter
 */
@JvmOverloads
fun parameter(annotations: List<Annotation> = emptyList(), modifiers: Set<CodeModifier> = emptySet(), type: Type, name: String) = CodeParameter(annotations, modifiers, type, name)

/**
 * @see CodeParameter
 */
@JvmOverloads
fun finalParameter(annotations: List<Annotation> = emptyList(), type: Type, name: String) = CodeParameter(annotations, EnumSet.of(CodeModifier.FINAL), type, name)

// Operate

/**
 * @see Operate
 */
fun operate(target: CodeInstruction, operation: Operator.Math, value: CodeInstruction): Operate =
        Operate(target, operation, value)

/**
 * Operate variable value and assign the result to the variable
 *
 * @see Operate
 */
fun operateAndAssign(variable: VariableBase, operation: Operator.Math, value: CodeInstruction): VariableDefinition =
        setVariableValue(variable.variableType, variable.name, operate(accessVariable(variable.variableType, variable.name), operation, value))

/**
 * Operate variable value and assign the result to the variable
 *
 * @see Operate
 */
fun operateAndAssign(type: Type, name: String, operation: Operator.Math, value: CodeInstruction): VariableDefinition =
        setVariableValue(type, name, operate(accessVariable(type, name), operation, value))

/**
 * Operate field value and assign the result to the field
 *
 * @see Operate
 */
fun operateAndAssign(field: FieldBase, operation: Operator.Math, value: CodeInstruction): FieldDefinition =
        setFieldValue(field.localization, field.target, field.type, field.name, operate(accessField(field.localization, field.target, field.type, field.name), operation, value))

/**
 * Operate field value and assign the result to the field
 *
 * @see Operate
 */
fun operateAndAssign(localization: Type, target: CodeInstruction, type: Type, name: String, operation: Operator.Math, value: CodeInstruction): FieldDefinition =
        setFieldValue(localization, target, type, name, operate(accessField(localization, target, type, name), operation, value))

// Throw

/**
 * @see ThrowException
 */
fun throwException(part: CodeInstruction) = ThrowException(part)


// Cast

/**
 * @see Cast
 */
fun cast(from: Type?, to: Type, part: CodeInstruction): Cast =
        Cast(from, to, part)

// IfExpr

/**
 * @see IfExpr
 */
fun ifExpr(expr1: CodeInstruction, operation: Operator.Conditional, expr2: CodeInstruction): IfExpr =
        IfExpr(expr1, operation, expr2)


/**
 * @see IfExpr
 */
fun check(expr1: CodeInstruction, operation: Operator.Conditional, expr2: CodeInstruction): IfExpr =
        ifExpr(expr1, operation, expr2)

/**
 * Helper function to create if expressions. This function converts a sequence of: [IfExpr],
 * [Operator], [IfGroup], [List] and [CodePart] into a list of expressions (which for the three first types
 * no conversion is done), if a [List] is found, it will be converted to a [IfGroup]. If a [CodePart] is found
 * it will be converted to a [IfExpr] that checks if the `codePart` is equal to `true`.
 *
 * @param objects Sequence of operations.
 * @return Sequence of if expressions.
 * @throws IllegalArgumentException If an element is not of a valid type.
 */
fun ifExprs(vararg objects: Any): List<CodeInstruction> {
    val list = ArrayList<CodeInstruction>()

    for (any in objects) {
        if (any is IfExpr || any is Operator || any is IfGroup) {
            list.add(any as CodeInstruction)
        } else if (any is CodeInstruction) {
            list.add(checkTrue(any))
        } else if (any is List<*>) {
            @Suppress("UNCHECKED_CAST")
            val other = any as List<CodeInstruction>
            list.add(IfGroup(other))
        } else {
            throw IllegalArgumentException("Illegal input object: '$any'.")
        }
    }

    return list
}

/**
 * [IfExpr] that checks if [part] is not `null`
 */
fun checkNotNull(part: CodeInstruction) = ifExpr(part, Operators.NOT_EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [part] is `null`
 */
fun checkNull(part: CodeInstruction) = ifExpr(part, Operators.EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [part] is `true`
 */
fun checkTrue(part: CodeInstruction) = ifExpr(part, Operators.EQUAL_TO, Literals.TRUE)

/**
 * [IfExpr] that checks if [part] is `false`
 */
fun checkFalse(part: CodeInstruction) = ifExpr(part, Operators.EQUAL_TO, Literals.FALSE)

// IfStatement

/**
 * @see IfStatement
 */
@JvmOverloads
fun ifStatement(expressions: List<CodeInstruction>, body: CodeSource, elseStatement: CodeSource = CodeSource.empty()): IfStatement =
        IfStatement(expressions, body, elseStatement)

/**
 * @see IfStatement
 */
@JvmOverloads
fun ifStatement(ifExpr: IfExpr, body: CodeSource, elseStatement: CodeSource = CodeSource.empty()): IfStatement =
        IfStatement(listOf(ifExpr), body, elseStatement)


// Label

/**
 * @see Label
 */
@JvmOverloads
fun label(name: String, body: CodeSource = CodeSource.empty()): Label =
        Label(name, body)

// ControlFlow

/**
 * @see ControlFlow
 */
@JvmOverloads
fun controlFlow(type: ControlFlow.Type, at: Label? = null): ControlFlow =
        ControlFlow(type, at)

/**
 * `break`
 *
 * `break @at`
 *
 * @see ControlFlow
 */
@JvmOverloads
fun breakFlow(at: Label? = null) = controlFlow(ControlFlow.Type.BREAK, at)

/**
 * `continue`
 *
 * `continue @at`
 *
 * @see ControlFlow
 */
@JvmOverloads
fun continueFlow(at: Label? = null) = controlFlow(ControlFlow.Type.CONTINUE, at)

// InstanceOfCheck

/**
 * Checks if [part] is instance of [type]
 *
 * @see InstanceOfCheck
 */
fun isInstanceOf(part: CodeInstruction, type: Type): InstanceOfCheck = InstanceOfCheck(part, type)

// TryStatement

/**
 * @see TryStatement
 */
@JvmOverloads
fun tryStatement(body: CodeSource, catchStatements: List<CatchStatement>, finallyStatement: CodeSource = CodeSource.empty()): TryStatement =
        TryStatement(body, catchStatements, finallyStatement)

// CatchStatement

/**
 * @see CatchStatement
 */
fun catchStatement(exceptionTypes: List<Type>, variable: VariableDeclaration, body: CodeSource): CatchStatement =
        CatchStatement(exceptionTypes, variable, body)

/**
 * @see CatchStatement
 */
fun catchStatement(exceptionType: Type, variable: VariableDeclaration, body: CodeSource): CatchStatement =
        catchStatement(listOf(exceptionType), variable, body)

// TryWithResources

/**
 * @see TryWithResources
 */
@JvmOverloads
fun tryWithResources(variable: VariableDeclaration, body: CodeSource, catchStatements: List<CatchStatement> = emptyList(), finallyStatement: CodeSource = CodeSource.empty()): TryWithResources =
        TryWithResources(variable, body, catchStatements, finallyStatement)

// WhileStatement

/**
 * @see [WhileStatement]
 */
@JvmOverloads
fun whileStatement(type: WhileStatement.Type = WhileStatement.Type.WHILE, expressions: List<CodeInstruction>, body: CodeSource): WhileStatement =
        WhileStatement(type, expressions, body)

/**
 * @see [WhileStatement]
 */
fun doWhileStatement(expressions: List<CodeInstruction>, body: CodeSource): WhileStatement =
        WhileStatement(WhileStatement.Type.DO_WHILE, expressions, body)

// ForStatement

/**
 * @see ForStatement
 */
fun forStatement(forInit: CodeInstruction, forExpression: List<CodeInstruction>, forUpdate: CodeInstruction, body: CodeSource): ForStatement =
        ForStatement(forInit, forExpression, forUpdate, body)

/**
 * @see ForStatement
 */
fun forStatement(forInit: CodeInstruction, forExpression: IfExpr, forUpdate: CodeInstruction, body: CodeSource): ForStatement =
        forStatement(forInit, listOf(forExpression), forUpdate, body)

// ForEachStatement

/**
 * @see ForEachStatement
 */
fun forEachStatement(variable: VariableDeclaration, iterationType: IterationType, iterableElement: CodeInstruction, body: CodeSource): ForEachStatement =
        ForEachStatement(variable, iterationType, iterableElement, body)

/**
 * Loop elements of an iterable element.
 *
 * @see ForEachStatement
 */
fun forEachIterable(variable: VariableDeclaration, iterableElement: CodeInstruction, body: CodeSource): ForEachStatement =
        forEachStatement(variable, IterationType.ITERABLE_ELEMENT, iterableElement, body)

/**
 * Loop elements of an array.
 *
 * @see ForEachStatement
 */
fun forEachArray(variable: VariableDeclaration, iterableElement: CodeInstruction, body: CodeSource): ForEachStatement =
        forEachStatement(variable, IterationType.ARRAY, iterableElement, body)

// Switch & Case

/**
 * @see SwitchStatement
 */
fun switchStatement(value: CodeInstruction, switchType: SwitchType, cases: List<Case>): SwitchStatement =
        SwitchStatement(value, switchType, cases)

/**
 * @see SwitchStatement
 */
fun switchInt(value: CodeInstruction, cases: List<Case>): SwitchStatement =
        switchStatement(value, SwitchType.NUMERIC, cases)

/**
 * @see SwitchStatement
 */
fun switchString(value: CodeInstruction, cases: List<Case>): SwitchStatement =
        switchStatement(value, SwitchType.STRING, cases)

/**
 * @see SwitchStatement
 */
fun switchObject(value: CodeInstruction, cases: List<Case>): SwitchStatement =
        switchStatement(value, SwitchType.OBJECT, cases)

/**
 * @see SwitchStatement
 */
fun switchEnum(value: CodeInstruction, cases: List<Case>): SwitchStatement =
        switchStatement(value, SwitchType.ENUM, cases)

/**
 * @see Case
 */
fun caseStatement(value: CodeInstruction, body: CodeSource): Case =
        Case(value, body)

/**
 * @see Case
 */
fun defaultCase(body: CodeSource): Case =
        caseStatement(CodeNothing, body)


// PlainCodeType

/**
 * @see PlainCodeType
 */
fun plainType(name: String, isInterface: Boolean): PlainCodeType =
        PlainCodeType(name, isInterface)


/**
 * @see PlainCodeType
 */
fun plainInterfaceType(name: String): PlainCodeType =
        plainType(name, true)


/**
 * @see PlainCodeType
 */
fun plainClassType(name: String): PlainCodeType =
        plainType(name, false)

// TypeSpec

/**
 * @see TypeSpec
 */
fun typeSpec(rtype: Type, ptypes: List<Type>) =
        TypeSpec(rtype, ptypes.toList())

/**
 * @see TypeSpec
 */
fun typeSpec(rtype: Type, ptype: Type) =
        typeSpec(rtype, listOf(ptype))

/**
 * @see TypeSpec
 */
fun typeSpec(rtype: Type, vararg ptypes: Type) =
        typeSpec(rtype, ptypes.toList())

/**
 * @see TypeSpec
 */
fun voidTypeSpec(vararg ptypes: Type) =
        typeSpec(Types.VOID, ptypes.toList())

/**
 * @see TypeSpec
 */
fun constructorTypeSpec(vararg ptypes: Type) =
        typeSpec(Types.VOID, ptypes.toList())