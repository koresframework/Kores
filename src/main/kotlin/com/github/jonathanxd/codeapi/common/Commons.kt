/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
@file:JvmName("Commons")

package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.Access
import com.github.jonathanxd.codeapi.base.InvokeType
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.factory.createArray1D
import com.github.jonathanxd.codeapi.factory.invoke
import com.github.jonathanxd.codeapi.factory.typeSpec
import com.github.jonathanxd.codeapi.type.Generic
import com.github.jonathanxd.codeapi.type.primitiveType
import com.github.jonathanxd.codeapi.type.simpleName
import com.github.jonathanxd.codeapi.type.wrapperType
import java.lang.reflect.Type

/**
 * Invokes `Y Y.valueOf(X)` static method of receiver [Type] that accepts the
 * primitive variant of [Type].
 *
 * Where `Y` is the wrapper type of [Type] (or itself) and `X` the primitive type of [Type] (or itself).
 *
 * @param arg Argument to get value from.
 */
fun Type.invokeValueOf(arg: CodeInstruction): MethodInvocation =
    invoke(
        invokeType = InvokeType.INVOKE_STATIC,
        localization = this.wrapperType ?: this,
        target = Access.STATIC,
        name = "valueOf",
        spec = typeSpec(this.wrapperType ?: this, this.primitiveType ?: this),
        arguments = listOf(arg)
    )

/**
 * Invokes `X Y.parseN(String)` static method of receiver [Type].
 *
 * Where `X` is the primitive type of [Type], `Y` is the wrapper type of [Type] and
 * `N` is the capitalized simple name of [Type].
 *
 * @param arg Argument to parse value from.
 */
fun Type.invokeParse(arg: CodeInstruction): MethodInvocation =
    invoke(
        invokeType = InvokeType.INVOKE_STATIC,
        localization = this.wrapperType ?: this,
        target = Access.STATIC,
        name = "parse${this.simpleName.capitalize()}",
        spec = typeSpec(this.primitiveType ?: this, Types.STRING),
        arguments = listOf(arg)
    )

/**
 * Invokes `X Y.nValue()` virtual method of [type] with receiver [CodeInstruction].
 *
 * Where `X` is the primitive type of [type], `Y` is the wrapper type of [type] and `n`
 * is the de-capitalized simple name of [type].
 */
fun CodeInstruction.invokeValue(type: Type): MethodInvocation =
    invoke(
        invokeType = InvokeType.INVOKE_VIRTUAL,
        localization = type.wrapperType ?: type,
        target = this,
        name = "${type.simpleName.decapitalize()}Value",
        spec = typeSpec(type.primitiveType ?: type),
        arguments = listOf()
    )

/**
 * Invokes `X Y.nValue()` virtual method of [base type][base] with receiver [CodeInstruction].
 *
 * Where `X` is the primitive type of [type], `Y` is the wrapper type of [base] and `n`
 * is the de-capitalized simple name of [type].
 *
 * Used in cases like `int Byte.intValue()`.
 */
fun CodeInstruction.invokeValue(base: Type, type: Type): MethodInvocation =
    invoke(
        invokeType = InvokeType.INVOKE_VIRTUAL,
        localization = base.wrapperType ?: base,
        target = this,
        name = "${type.simpleName.decapitalize()}Value",
        spec = typeSpec(type),
        arguments = listOf()
    )

/**
 * Invokes `String X.toString()` virtual method of [any type][Any] with receiver [CodeInstruction].
 */
fun CodeInstruction.invokeToString(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_VIRTUAL,
    localization = Types.OBJECT,
    target = this,
    name = "toString",
    spec = typeSpec(Types.STRING),
    arguments = emptyList()
)

/**
 * Invokes `int X.hashCode()` virtual method of [any type][Any] with receiver [CodeInstruction].
 */
fun CodeInstruction.invokeHashCode(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_VIRTUAL,
    localization = Types.OBJECT,
    target = this,
    name = "hashCode",
    spec = typeSpec(Types.INT),
    arguments = emptyList()
)

/**
 * Invokes `boolean X.equals(Y)` virtual method of [any type][Any] with receiver [CodeInstruction] and [other] as the other
 * object to test equality.
 */
fun CodeInstruction.invokeEquals(other: CodeInstruction): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_VIRTUAL,
    localization = Types.OBJECT,
    target = this,
    name = "equals",
    spec = typeSpec(Types.BOOLEAN, Types.OBJECT),
    arguments = listOf(other)
)

/**
 * Invokes `int X.compareTo(Y)` interface method of [comparable type][Comparable] with receiver [CodeInstruction]
 * and [other] as the second object to compare.
 */
fun CodeInstruction.invokeCompareTo(other: CodeInstruction): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_INTERFACE,
    localization = Types.COMPARABLE,
    target = this,
    name = "compareTo",
    spec = typeSpec(Types.INT, Types.OBJECT),
    arguments = listOf(other)
)

/**
 * Invokes `int X.compareTo(Y, V)` interface method of [comparator type][Comparator] with receiver [CodeInstruction]
 * to compare [first] and [second].
 */
fun CodeInstruction.invokeCompare(
    first: CodeInstruction,
    second: CodeInstruction
): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_INTERFACE,
    localization = Types.COMPARATOR,
    target = this,
    name = "compare",
    spec = typeSpec(Types.INT, Types.OBJECT, Types.OBJECT),
    arguments = listOf(first, second)
)

/**
 * Invokes `int Objects.hash(T...)` static method to calculate hash code of `T` values.
 *
 * Where `T` is the receiver list of instructions.
 */
fun List<CodeInstruction>.invokeHash(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "hash",
    spec = typeSpec(Types.INT, Types.OBJECT.toArray(1)),
    arguments = listOf(createArray1D(Types.OBJECT.toArray(1), this))
)

/**
 * Invokes `boolean Objects.equals(A, B)` static method.
 *
 * Where `A` is the receiver and `B` is [other].
 */
fun CodeInstruction.invokeObjectsEquals(other: CodeInstruction): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "equals",
    spec = typeSpec(Types.BOOLEAN, Types.OBJECT, Types.OBJECT),
    arguments = listOf(this, other)
)

/**
 * Invokes `String Objects.toString(A)` static method.
 *
 * Where `A` is the receiver.
 */
fun CodeInstruction.invokeObjectsToString(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "toString",
    spec = typeSpec(Types.STRING, Types.OBJECT),
    arguments = listOf(this)
)

/**
 * Invokes `Object Objects.requireNonNull(T)` static method (this function does not auto-cast).
 *
 * Where `T` is the receiver.
 */
fun CodeInstruction.invokeRequireNonNull(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "requireNonNull",
    spec = typeSpec(Types.OBJECT, Types.OBJECT),
    arguments = listOf(this)
)

/**
 * Invokes `Object Objects.requireNonNull(T, M)` static method (this function does not auto-cast).
 *
 * Where `T` is the receiver and `M` the [message].
 */
fun CodeInstruction.invokeRequireNonNull(message: CodeInstruction): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "requireNonNull",
    spec = typeSpec(Types.OBJECT, Types.OBJECT, Types.STRING),
    arguments = listOf(this, message)
)

/**
 * Invokes `Object Objects.requireNonNull(T, M)` static method (this function does not auto-cast).
 *
 * Where `T` is the receiver and `M` the [messageSupplier].
 */
fun CodeInstruction.invokeRequireNonNullSuppliedMessage(messageSupplier: CodeInstruction): MethodInvocation =
    invoke(
        invokeType = InvokeType.INVOKE_STATIC,
        localization = Types.OBJECTS,
        target = Access.STATIC,
        name = "requireNonNull",
        spec = typeSpec(Types.OBJECT, Types.OBJECT, Generic.type(Types.SUPPLIER).of(Types.STRING)),
        arguments = listOf(this, messageSupplier)
    )

/**
 * Invokes `Object Objects.compare(A, B, C)` static method (this function does not auto-cast).
 *
 * Where `A` is the [first] object to compare, `B` the [second] object to compare and `C` the receiver comparator.
 */
fun CodeInstruction.invokeObjectsCompare(
    first: CodeInstruction,
    second: CodeInstruction
): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.OBJECTS,
    target = Access.STATIC,
    name = "compare",
    spec = typeSpec(Types.OBJECT, Types.OBJECT, Types.OBJECT, Types.COMPARATOR),
    arguments = listOf(first, second, this)
)

/**
 * Invokes `Set Collections.singleton(S)` static method.
 *
 * Where `S` is the receiver object.
 */
fun CodeInstruction.invokeSingleton(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS,
    target = Access.STATIC,
    name = "singleton",
    spec = typeSpec(Types.SET, Types.OBJECT),
    arguments = listOf(this)
)

/**
 * Invokes `List Collections.singletonList(S)` static method.
 *
 * Where `S` is the receiver object.
 */
fun CodeInstruction.invokeSingletonList(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS,
    target = Access.STATIC,
    name = "singletonList",
    spec = typeSpec(Types.LIST, Types.OBJECT),
    arguments = listOf(this)
)

/**
 * Invokes `Map Collections.singletonMap(SK, SV)` static method.
 *
 * Where `SK` is the [key] and `SV` is the [value].
 */
fun invokeSingletonMap(key: CodeInstruction, value: CodeInstruction): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS,
    target = Access.STATIC,
    name = "singletonMap",
    spec = typeSpec(Types.MAP, Types.OBJECT, Types.OBJECT),
    arguments = listOf(key, value)
)

/**
 * Invokes `List Collections3.listOf(S...)` static method.
 *
 * Where `S` is the receiver object.
 */
fun List<CodeInstruction>.invokeListOf(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS3,
    target = Access.STATIC,
    name = "listOf",
    spec = typeSpec(Types.LIST, Types.OBJECTS),
    arguments = listOf(createArray1D(Types.OBJECT.toArray(1), this))
)

/**
 * Invokes `Set Collections3.setOf(S...)` static method.
 *
 * Where `S` is the receiver object.
 */
fun List<CodeInstruction>.invokeSetOf(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS3,
    target = Access.STATIC,
    name = "setOf",
    spec = typeSpec(Types.SET, Types.OBJECTS),
    arguments = listOf(createArray1D(Types.OBJECT.toArray(1), this))
)

/**
 * Invokes `Map Collections3.mapOf(S...)` static method.
 *
 * Where `S` is the receiver object.
 */
fun List<CodeInstruction>.invokeMapOf(): MethodInvocation = invoke(
    invokeType = InvokeType.INVOKE_STATIC,
    localization = Types.COLLECTIONS3,
    target = Access.STATIC,
    name = "mapOf",
    spec = typeSpec(Types.MAP, Types.OBJECTS),
    arguments = listOf(createArray1D(Types.OBJECT.toArray(1), this))
)
