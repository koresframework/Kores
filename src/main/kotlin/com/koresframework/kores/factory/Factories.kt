/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

package com.koresframework.kores.factory

import com.koresframework.kores.*
import com.koresframework.kores.base.*
import com.koresframework.kores.base.Annotation
import com.koresframework.kores.base.Retention
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.common.Void
import com.koresframework.kores.literal.Literals
import com.koresframework.kores.operator.Operator
import com.koresframework.kores.operator.Operators
import com.koresframework.kores.type.PlainKoresType
import com.koresframework.kores.type.typeOf
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
fun annotation(
    retention: com.koresframework.kores.base.Retention,
    type: Type,
    values: Map<String, Any> = emptyMap()
): Annotation =
    Annotation(type, values, retention)

/**
 * @see Annotation
 */
@JvmOverloads
fun runtimeAnnotation(type: Type, values: Map<String, Any> = emptyMap()): Annotation =
    annotation(Retention.RUNTIME, type, values)

/**
 * @see Annotation
 */
@JvmOverloads
fun classAnnotation(type: Type, values: Map<String, Any> = emptyMap()): Annotation =
    annotation(Retention.CLASS, type, values)

/**
 * @see Annotation
 */
@JvmOverloads
fun sourceAnnotation(type: Type, values: Map<String, Any> = emptyMap()): Annotation =
    annotation(Retention.SOURCE, type, values)

/**
 * @see Annotation
 */
fun overrideAnnotation(): Annotation = sourceAnnotation(Override::class.java, mapOf())

/**
 * @see Annotation
 */
fun deprecatedAnnotation(): Annotation = sourceAnnotation(Deprecated::class.java, mapOf())

/**
 * @see Annotation
 */
@JvmOverloads
fun annotationProperty(
    comments: Comments = Comments.Absent,
    annotations: List<Annotation> = emptyList(),
    type: Type,
    name: String,
    defaultValue: Any?
): AnnotationProperty =
    AnnotationProperty(comments, annotations, type, name, defaultValue)


// Arrays

/**
 * @see ArrayConstructor
 */
fun createArray(
    arrayType: Type,
    dimensions: List<Instruction>,
    arguments: List<Instruction>
): ArrayConstructor =
    ArrayConstructor(arrayType, dimensions, arguments)

/**
 * @see ArrayConstructor
 */
fun createArray1D(arrayType: Type, arguments: List<Instruction>): ArrayConstructor =
    ArrayConstructor(arrayType, listOf(Literals.INT(arguments.size)), arguments)

/**
 * Creates array of type [arrayType] with [dimension] for receiver instructions.
 *
 * @see ArrayConstructor
 */
fun List<Instruction>.createArray(
    arrayType: Type,
    dimensions: List<Instruction>
): ArrayConstructor =
    ArrayConstructor(arrayType = arrayType, dimensions = dimensions, arguments = this)


/**
 * @see ArrayStore
 */
fun setArrayValue(
    arrayType: Type,
    target: Instruction,
    index: Instruction,
    valueType: Type,
    valueToStore: Instruction
): ArrayStore =
    ArrayStore(arrayType, target, index, valueType, valueToStore)

/**
 * Sets value at [index] of [receiver array][Instruction] of type [arrayType] to [valueToStore].
 *
 * @see ArrayStore
 */
fun Instruction.setArrayValue(
    arrayType: Type,
    index: Instruction,
    valueType: Type,
    valueToStore: Instruction
): ArrayStore =
    ArrayStore(
        arrayType = arrayType,
        target = this,
        index = index,
        valueType = valueType,
        valueToStore = valueToStore
    )

/**
 * Sets value at [index] of [receiver array][TypedInstruction] of type [arrayType][TypedInstruction.type] to [valueToStore].
 *
 * @see ArrayStore
 */
fun TypedInstruction.setArrayValue(
        index: Instruction,
        valueType: Type,
        valueToStore: Instruction
): ArrayStore =
        ArrayStore(
                arrayType = this.type,
                target = this,
                index = index,
                valueType = valueType,
                valueToStore = valueToStore
        )

/**
 * @see ArrayLoad
 */
fun accessArrayValue(
    arrayType: Type,
    target: Instruction,
    index: Instruction,
    valueType: Type
): ArrayLoad =
    ArrayLoad(arrayType, target, index, valueType)

/**
 * @see ArrayLoad
 */
fun TypedInstruction.accessArrayValue(
    index: Instruction,
    valueType: Type
): ArrayLoad =
    ArrayLoad(this.type, this, index, valueType)

/**
 * Accesses the value of [valueType] of [receiver array][Instruction] at [index].
 *
 * @see ArrayLoad
 */
fun Instruction.accessArrayValue(
    arrayType: Type,
    index: Instruction,
    valueType: Type
): ArrayLoad =
    ArrayLoad(arrayType = arrayType, target = this, index = index, valueType = valueType)

/**
 * @see ArrayLength
 */
fun arrayLength(arrayType: Type, target: Instruction): ArrayLength =
    ArrayLength(arrayType, target)

/**
 * Accesses the length of [receiver array][Instruction] of type [arrayType].
 * @see ArrayLength
 */
fun Instruction.arrayLength(arrayType: Type): ArrayLength =
    ArrayLength(arrayType, target = this)

/**
 * Accesses the length of [receiver array][Instruction] of type [arrayType].
 * @see ArrayLength
 */
fun TypedInstruction.arrayLength(): ArrayLength =
    ArrayLength(this.type, target = this)

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
fun enumValue(enumType: Type, enumEntry: String): EnumValue =
    EnumValue(enumType, enumEntry)


// Variable

/**
 * @see VariableAccess
 */
fun accessVariable(type: Type, name: String): VariableAccess =
    VariableAccess(type, name)

/**
 * @see VariableAccess
 */
inline fun <reified T> accessVariable(name: String): VariableAccess =
    VariableAccess(typeOf<T>(), name)


/**
 * @see VariableAccess
 */
fun accessVariable(variable: VariableBase): VariableAccess =
    accessVariable(variable.type, variable.name)

/**
 * @see VariableDefinition
 */
fun setVariableValue(type: Type, name: String, value: Instruction): VariableDefinition =
    VariableDefinition(type, name, value)

/**
 * @see VariableDefinition
 */
fun setVariableValue(name: String, value: TypedInstruction): VariableDefinition =
    VariableDefinition(value.type, name, value)

/**
 * @see VariableDefinition
 */
fun setVariableValue(variable: VariableBase, value: Instruction): VariableDefinition =
    VariableDefinition(variable.type, variable.name, value)

// Field

/**
 * @see FieldAccess
 */
fun accessField(
    localization: Type,
    target: Instruction,
    type: Type,
    name: String
): FieldAccess =
    FieldAccess(localization, target, type, name)

/**
 * Access field with [name] and [type] of [receiver][Instruction] in [localization].
 *
 * @see FieldAccess
 */
fun Instruction.accessField(
    localization: Type,
    type: Type,
    name: String
): FieldAccess =
    FieldAccess(localization = localization, target = this, type = type, name = name)

/**
 * Access field with [name] and [type][TypedInstruction.type] of [receiver][Instruction] in [localization].
 *
 * @see FieldAccess
 */
fun TypedInstruction.accessField(
    localization: Type,
    name: String
): FieldAccess =
    FieldAccess(localization = localization, target = this, type = this.type, name = name)

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
fun setFieldValue(
    localization: Type,
    target: Instruction,
    type: Type,
    name: String,
    value: Instruction
): FieldDefinition =
    FieldDefinition(localization, target, type, name, value)

/**
 * Sets field [name] of [type] of [receiver][Instruction] in [localization].
 *
 * @see FieldDefinition
 */
fun Instruction.setFieldValue(
    localization: Type,
    type: Type,
    name: String,
    value: Instruction
): FieldDefinition =
    FieldDefinition(
        localization = localization,
        target = this,
        type = type,
        name = name,
        value = value
    )

/**
 * Sets field [name] of [receiver type][TypedInstruction.type] of [receiver][TypedInstruction] in [localization].
 *
 * @see FieldDefinition
 */
fun TypedInstruction.setFieldValue(
    localization: Type,
    name: String,
    value: Instruction
): FieldDefinition =
    FieldDefinition(
        localization = localization,
        target = this,
        type = this.type,
        name = name,
        value = value
    )

/**
 * @see FieldDefinition
 */
fun setThisFieldValue(type: Type, name: String, value: Instruction): FieldDefinition =
    setFieldValue(Alias.THIS, Access.THIS, type, name, value)

/**
 * @see FieldDefinition
 */
fun TypedInstruction.setToThisFieldValue(name: String): FieldDefinition =
    setFieldValue(Alias.THIS, Access.THIS, this.type, name, this)

/**
 * @see FieldDefinition
 */
@JvmOverloads
fun setStaticFieldValue(
    localization: Type = Alias.THIS,
    type: Type,
    name: String,
    value: Instruction
): FieldDefinition =
    setFieldValue(localization, Access.STATIC, type, name, value)

/**
 * @see FieldDefinition
 */
@JvmOverloads
fun setStaticFieldValue(
    localization: Type = Alias.THIS,
    name: String,
    value: TypedInstruction
): FieldDefinition =
    setFieldValue(localization, Access.STATIC, value.type, name, value)

/**
 * Invoke getter of a field (`get`+`capitalize(fieldName)`).
 *
 * @param invokeType Type of invocation
 * @param localization Localization of getter
 * @param target Target of invocation
 * @param type Type of field.
 * @param name Name of field.
 */
fun invokeFieldGetter(
    invokeType: InvokeType,
    localization: Type,
    target: Instruction,
    type: Type,
    name: String
): MethodInvocation =
    invoke(invokeType, localization, target, "get${name.capitalize()}", TypeSpec(type), emptyList())

/**
 * Invoke getter of a field (`get`+`capitalize(fieldName)`) of [receiver][Instruction].
 *
 * @param invokeType Type of invocation
 * @param localization Localization of getter
 * @param type Type of field.
 * @param name Name of field.
 */
fun Instruction.invokeFieldGetter(
    invokeType: InvokeType,
    localization: Type,
    type: Type,
    name: String
): MethodInvocation =
    invoke(
        invokeType = invokeType,
        localization = localization,
        target = this,
        name = "get${name.capitalize()}",
        spec = TypeSpec(type),
        arguments = emptyList()
    )

/**
 * Invoke getter of a field (`get`+`capitalize(fieldName)`) of [receiver][TypedInstruction] and [receiver type][TypedInstruction.type].
 *
 * @param invokeType Type of invocation
 * @param localization Localization of getter
 * @param type Type of field.
 * @param name Name of field.
 */
fun TypedInstruction.invokeFieldGetter(
    invokeType: InvokeType,
    localization: Type,
    name: String
): MethodInvocation =
    invoke(
        invokeType = invokeType,
        localization = localization,
        target = this,
        name = "get${name.capitalize()}",
        spec = TypeSpec(this.type),
        arguments = emptyList()
    )

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
fun invokeFieldSetter(
    invokeType: InvokeType,
    localization: Type,
    target: Instruction,
    type: Type,
    name: String,
    value: Instruction
): MethodInvocation =
    invoke(
        invokeType,
        localization,
        target,
        "set${name.capitalize()}",
        TypeSpec(Void.type, listOf(type)),
        listOf(value)
    )

/**
 * Invoke setter of a field (`set`+`capitalize(fieldName)`) of [receiver][Instruction] with [value].
 *
 * @param invokeType Type of invocation
 * @param localization Localization of setter
 * @param type Type of field.
 * @param name Name of field.
 * @param value Value to pass to setter
 */
fun Instruction.invokeFieldSetter(
    invokeType: InvokeType,
    localization: Type,
    type: Type,
    name: String,
    value: Instruction
): MethodInvocation =
    invoke(
        invokeType = invokeType,
        localization = localization,
        target = this,
        name = "set${name.capitalize()}",
        spec = TypeSpec(Void.type, listOf(type)),
        arguments = listOf(value)
    )

/**
 * Invoke setter of a field (`set`+`capitalize(fieldName)`) of [receiver][Instruction] of [receiver type][Instruction.type] with [value].
 *
 * @param invokeType Type of invocation
 * @param localization Localization of setter
 * @param type Type of field.
 * @param name Name of field.
 * @param value Value to pass to setter
 */
fun TypedInstruction.invokeFieldSetter(
    invokeType: InvokeType,
    localization: Type,
    name: String,
    value: Instruction
): MethodInvocation =
    invoke(
        invokeType = invokeType,
        localization = localization,
        target = this,
        name = "set${name.capitalize()}",
        spec = TypeSpec(Void.type, listOf(this.type)),
        arguments = listOf(value)
    )

// Return

/**
 * @see Return
 */
fun returnValue(type: Type, value: Instruction) = Return(type, value)

/**
 * @see Return
 */
fun returnValue(value: TypedInstruction) = Return(value.type, value)

/**
 * Void return (Java: `return;`)
 * @see Return
 */
fun returnVoid(): Return = returnValue(Void.type, Void)

/**
 * Creates a [Return] of receiver instruction of type [type].
 */
fun Instruction.returnValue(type: Type) =
    returnValue(type, this)

/**
 * Creates a [Return] of receiver instruction of type [type].
 */
fun TypedInstruction.returnSelfValue() =
    returnValue(this.type, this)

// Parameter

/**
 * @see KoresParameter
 */
@JvmOverloads
fun parameter(
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<KoresModifier> = emptySet(),
    type: Type,
    name: String
) = KoresParameter(annotations, modifiers, type, name)

/**
 * @see KoresParameter
 */
inline fun <reified P> parameter(
    annotations: List<Annotation> = emptyList(),
    modifiers: Set<KoresModifier> = emptySet(),
    name: String
) = KoresParameter(annotations, modifiers, typeOf<P>(), name)

/**
 * @see KoresParameter
 */
inline fun <reified P> parameter(
    name: String
) = KoresParameter(emptyList(), EnumSet.noneOf(KoresModifier::class.java), typeOf<P>(), name)


/**
 * @see KoresParameter
 */
@JvmOverloads
fun finalParameter(annotations: List<Annotation> = emptyList(), type: Type, name: String) =
    KoresParameter(annotations, EnumSet.of(KoresModifier.FINAL), type, name)

/**
 * @see KoresParameter
 */
inline fun <reified P> finalParameter(annotations: List<Annotation> = emptyList(), name: String) =
    KoresParameter(annotations, EnumSet.of(KoresModifier.FINAL), typeOf<P>(), name)

/**
 * @see KoresParameter
 */
inline fun <reified P> finalParameter(name: String) =
    KoresParameter(emptyList(), EnumSet.of(KoresModifier.FINAL), typeOf<P>(), name)

// Operate

/**
 * @see Operate
 */
fun operate(target: Instruction, operation: Operator.Math, value: Instruction): Operate =
    Operate(target, operation, value)

/**
 * Operate variable value and assign the result to the variable
 *
 * @see Operate
 */
fun operateAndAssign(
    variable: VariableBase,
    operation: Operator.Math,
    value: Instruction
): VariableDefinition =
    setVariableValue(
        variable.variableType,
        variable.name,
        operate(accessVariable(variable.variableType, variable.name), operation, value)
    )

/**
 * Operate variable value and assign the result to the variable
 *
 * @see Operate
 */
fun operateAndAssign(
    type: Type,
    name: String,
    operation: Operator.Math,
    value: Instruction
): VariableDefinition =
    setVariableValue(type, name, operate(accessVariable(type, name), operation, value))

/**
 * Operate field value and assign the result to the field
 *
 * @see Operate
 */
fun operateAndAssign(
    field: FieldBase,
    operation: Operator.Math,
    value: Instruction
): FieldDefinition =
    setFieldValue(
        field.localization,
        field.target,
        field.type,
        field.name,
        operate(
            accessField(field.localization, field.target, field.type, field.name),
            operation,
            value
        )
    )

/**
 * Operate field value and assign the result to the field
 *
 * @see Operate
 */
fun operateAndAssign(
    localization: Type,
    target: Instruction,
    type: Type,
    name: String,
    operation: Operator.Math,
    value: Instruction
): FieldDefinition =
    setFieldValue(
        localization,
        target,
        type,
        name,
        operate(accessField(localization, target, type, name), operation, value)
    )

// Throw

/**
 * @see ThrowException
 */
fun throwException(part: Instruction) = ThrowException(part)

/**
 * Throws [receiver][Instruction] as exception.
 *
 * @see ThrowException
 */
fun Instruction.throwThisException() = ThrowException(this)


// Cast

/**
 * @see Cast
 */
fun cast(from: Type?, to: Type, part: Instruction): Cast =
    Cast(from, to, part)

/**
 * @see Cast
 */
fun cast(to: Type, part: TypedInstruction): Cast =
    Cast(part.type, to, part)

/**
 * Creates a cast of receiver from type [from] to type [to].
 */
fun Instruction.cast(from: Type?, to: Type) =
    cast(from, to, this)

/**
 * Creates a cast of receiver from type [from] to type [to].
 */
fun TypedInstruction.cast(to: Type) =
    cast(this.type, to, this)

// IfExpr

/**
 * @see IfExpr
 */
fun ifExpr(
    expr1: Instruction,
    operation: Operator.Conditional,
    expr2: Instruction
): IfExpr =
    IfExpr(expr1, operation, expr2)


/**
 * @see IfExpr
 */
fun check(expr1: Instruction, operation: Operator.Conditional, expr2: Instruction): IfExpr =
    ifExpr(expr1, operation, expr2)

/**
 * Helper function to create if expressions. This function converts a sequence of: [IfExpr],
 * [Operator], [IfGroup], [List] and [KoresPart] into a list of expressions (which for the three first types
 * no conversion is done), if a [List] is found, it will be converted to a [IfGroup]. If a [KoresPart] is found
 * it will be converted to a [IfExpr] that checks if the `codePart` is equal to `true`.
 *
 * @param objects Sequence of operations.
 * @return Sequence of if expressions.
 * @throws IllegalArgumentException If an element is not of a valid type.
 */
fun ifExprs(vararg objects: Any): List<Instruction> {
    val list = ArrayList<Instruction>()

    for (any in objects) {
        if (any is IfExpr || any is Operator || any is IfGroup) {
            if (any is Operator)
                if (any != Operators.OR
                        && any != Operators.AND
                        && any != Operators.BITWISE_INCLUSIVE_OR
                        && any != Operators.BITWISE_EXCLUSIVE_OR
                        && any != Operators.BITWISE_AND
                )
                    throw IllegalArgumentException("Input object is not a valid operator, it must be: OR or AND or short-circuit BITWISE_INCLUSIVE_OR, BITWISE_EXCLUSIVE_OR or BITWISE_AND. Current: $any")

            list.add(any as Instruction)
        } else if (any is Instruction) {
            list.add(checkTrue(any))
        } else if (any is List<*>) {
            @Suppress("UNCHECKED_CAST")
            val other = any as List<Instruction>
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
fun checkNotNull(part: Instruction) = ifExpr(part, Operators.NOT_EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [receiver][Instruction] is not `null`
 */
fun Instruction.checkThisNotNull() = ifExpr(this, Operators.NOT_EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [part] is `null`
 */
fun checkNull(part: Instruction) = ifExpr(part, Operators.EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [receiver][Instruction] is `null`
 */
fun Instruction.checkThisNull() = ifExpr(this, Operators.EQUAL_TO, Literals.NULL)

/**
 * [IfExpr] that checks if [part] is `true`
 */
fun checkTrue(part: Instruction) = ifExpr(part, Operators.EQUAL_TO, Literals.TRUE)

/**
 * [IfExpr] that checks if [receiver][Instruction] is `true`
 */
fun Instruction.checThiskTrue() = ifExpr(this, Operators.EQUAL_TO, Literals.TRUE)

/**
 * [IfExpr] that checks if [part] is `false`
 */
fun checkFalse(part: Instruction) = ifExpr(part, Operators.EQUAL_TO, Literals.FALSE)

/**
 * [IfExpr] that checks if [receiver][Instruction] is `false`
 */
fun Instruction.checkThisFalse() = ifExpr(this, Operators.EQUAL_TO, Literals.FALSE)

// IfStatement

/**
 * @see IfStatement
 */
@JvmOverloads
fun ifStatement(
    expressions: List<Instruction>,
    body: Instructions,
    elseStatement: Instructions = Instructions.empty()
): IfStatement =
    IfStatement(expressions, body, elseStatement)

/**
 * @see IfStatement
 */
@JvmOverloads
fun ifStatement(
    ifExpr: IfExpr,
    body: Instructions,
    elseStatement: Instructions = Instructions.empty()
): IfStatement =
    IfStatement(listOf(ifExpr), body, elseStatement)


// Label

/**
 * @see Label
 */
@JvmOverloads
fun label(name: String, body: Instructions = Instructions.empty()): Label =
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
fun isInstanceOf(part: Instruction, type: Type): InstanceOfCheck = InstanceOfCheck(part, type)

/**
 * Checks if [receiver][Instruction] is instance of [type]
 *
 * @see InstanceOfCheck
 */
fun Instruction.isThisInstanceOf(type: Type): InstanceOfCheck = InstanceOfCheck(this, type)

// TryStatement

/**
 * @see TryStatement
 */
@JvmOverloads
fun tryStatement(
    body: Instructions,
    catchStatements: List<CatchStatement>,
    finallyStatement: Instructions = Instructions.empty()
): TryStatement =
    TryStatement(body, catchStatements, finallyStatement)

// CatchStatement

/**
 * @see CatchStatement
 */
fun catchStatement(
    exceptionTypes: List<Type>,
    variable: VariableDeclaration,
    body: Instructions
): CatchStatement =
    CatchStatement(exceptionTypes, variable, body)

/**
 * @see CatchStatement
 */
fun catchStatement(
    exceptionType: Type,
    variable: VariableDeclaration,
    body: Instructions
): CatchStatement =
    catchStatement(listOf(exceptionType), variable, body)

// TryWithResources

/**
 * @see TryWithResources
 */
@JvmOverloads
fun tryWithResources(
    variable: VariableDeclaration,
    body: Instructions,
    catchStatements: List<CatchStatement> = emptyList(),
    finallyStatement: Instructions = Instructions.empty()
): TryWithResources =
    TryWithResources(variable, body, catchStatements, finallyStatement)

// WhileStatement

/**
 * @see [WhileStatement]
 */
@JvmOverloads
fun whileStatement(
    type: WhileStatement.Type = WhileStatement.Type.WHILE,
    expressions: List<Instruction>,
    body: Instructions
): WhileStatement =
    WhileStatement(type, expressions, body)

/**
 * @see [WhileStatement]
 */
fun doWhileStatement(expressions: List<Instruction>, body: Instructions): WhileStatement =
    WhileStatement(WhileStatement.Type.DO_WHILE, expressions, body)

// ForStatement

/**
 * @see ForStatement
 */
fun forStatement(
    forInit: Instruction,
    forExpression: List<Instruction>,
    forUpdate: Instruction,
    body: Instructions
): ForStatement =
    ForStatement(listOf(forInit), forExpression, listOf(forUpdate), body)

/**
 * @see ForStatement
 */
fun forStatement(
    forInit: List<Instruction>,
    forExpression: List<Instruction>,
    forUpdate: List<Instruction>,
    body: Instructions
): ForStatement =
    ForStatement(forInit, forExpression, forUpdate, body)

/**
 * @see ForStatement
 */
fun forStatement(
    forInit: Instruction,
    forExpression: IfExpr,
    forUpdate: Instruction,
    body: Instructions
): ForStatement =
    forStatement(forInit, listOf(forExpression), forUpdate, body)

// ForEachStatement

/**
 * @see ForEachStatement
 */
fun forEachStatement(
    variable: VariableDeclaration,
    iterationType: IterationType,
    iterableElement: Instruction,
    body: Instructions
): ForEachStatement =
    ForEachStatement(variable, iterationType, iterableElement, body)

/**
 * Loop elements of an iterable element.
 *
 * @see ForEachStatement
 */
fun forEachIterable(
    variable: VariableDeclaration,
    iterableElement: Instruction,
    body: Instructions
): ForEachStatement =
    forEachStatement(variable, IterationType.ITERABLE_ELEMENT, iterableElement, body)

/**
 * Loop elements of an array.
 *
 * @see ForEachStatement
 */
fun forEachArray(
    variable: VariableDeclaration,
    iterableElement: Instruction,
    body: Instructions
): ForEachStatement =
    forEachStatement(variable, IterationType.ARRAY, iterableElement, body)

// Switch & Case

/**
 * @see SwitchStatement
 */
fun switchStatement(
    value: Instruction,
    switchType: SwitchType,
    cases: List<Case>
): SwitchStatement =
    SwitchStatement(value, switchType, cases)

/**
 * Switch [receiver][Instruction]
 *
 * @see SwitchStatement
 */
fun Instruction.switchThisStatement(
    switchType: SwitchType,
    cases: List<Case>
): SwitchStatement =
    SwitchStatement(this, switchType, cases)

/**
 * @see SwitchStatement
 */
fun switchInt(value: Instruction, cases: List<Case>): SwitchStatement =
    switchStatement(value, SwitchType.NUMERIC, cases)

/**
 * Case [receiver][Instruction] int.
 *
 * @see SwitchStatement
 */
fun Instruction.switchThisInt(cases: List<Case>): SwitchStatement =
    switchStatement(this, SwitchType.NUMERIC, cases)

/**
 * @see SwitchStatement
 */
fun switchString(value: Instruction, cases: List<Case>): SwitchStatement =
    switchStatement(value, SwitchType.STRING, cases)

/**
 * Case [receiver][Instruction] string.
 * @see SwitchStatement
 */
fun Instruction.switchThisString(cases: List<Case>): SwitchStatement =
    switchStatement(this, SwitchType.STRING, cases)

/**
 * @see SwitchStatement
 */
fun switchEnum(value: Instruction, cases: List<Case>): SwitchStatement =
    switchStatement(value, SwitchType.ENUM, cases)

/**
 * Case [receiver][Instruction] enum.
 * @see SwitchStatement
 */
fun Instruction.switchThisEnum(cases: List<Case>): SwitchStatement =
    switchStatement(this, SwitchType.ENUM, cases)

/**
 * @see Case
 */
fun caseStatement(value: Instruction, body: Instructions): Case =
    Case(value, body)

/**
 * Case [receiver][Instruction] value.
 * @see Case
 */
fun Instruction.caseThis(body: Instructions): Case =
    Case(this, body)

/**
 * @see Case
 */
fun defaultCase(body: Instructions): Case =
    caseStatement(KoresNothing, body)


// PlainKoresType

/**
 * @see PlainKoresType
 */
fun plainType(name: String, isInterface: Boolean): PlainKoresType =
    PlainKoresType(name, isInterface)


/**
 * @see PlainKoresType
 */
fun plainInterfaceType(name: String): PlainKoresType =
    plainType(name, true)


/**
 * @see PlainKoresType
 */
fun plainClassType(name: String): PlainKoresType =
    plainType(name, false)

// TypeSpec

/**
 * @see TypeSpec
 */
fun typeSpec(rtype: Type) =
    TypeSpec(rtype, emptyList())

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

/**
 * Creates a [Line] instance linking [value] to [line number][line].
 */
fun line(line: Int, value: Instruction): Line =
    if (value is Typed) Line.TypedLine(line, value, value.type) else Line.NormalLine(line, value)

/**
 * Creates a [Line] of number [line]
 */
fun Instruction.line(line: Int) =
    line(line, this)