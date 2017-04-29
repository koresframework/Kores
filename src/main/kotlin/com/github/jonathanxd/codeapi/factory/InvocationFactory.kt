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
@file:JvmName("InvocationFactory")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Defaults
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.common.*
import com.github.jonathanxd.codeapi.util.Alias
import java.lang.reflect.Type

/**
 * Invoke a method with signature [spec] and [name] of class [localization] using instance [target] with
 * [arguments].
 *
 * @see InvokeType
 * @see MethodInvocation
 */
fun invoke(invokeType: InvokeType, localization: Type, target: CodePart, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        MethodInvocation(
                invokeType = invokeType,
                target = target,
                spec = MethodTypeSpec(
                        localization,
                        name,
                        spec
                ),
                arguments = arguments

        )

fun invokeVirtual(localization: Type, target: CodePart, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_VIRTUAL, localization, target, name, spec, arguments)

fun invokeInterface(localization: Type, target: CodePart, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_INTERFACE, localization, target, name, spec, arguments)

fun invokeSpecial(localization: Type, target: CodePart, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, localization, target, name, spec, arguments)

fun invokeConstructor(localization: Type, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, localization, New(localization), CONSTRUCTOR, spec, arguments)

fun invokeConstructor(localization: Type) =
        invokeConstructor(localization, TypeSpec(Types.VOID, emptyList()), emptyList())

fun invokeSuperConstructor(localization: Type, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, localization, Alias.SUPER, CONSTRUCTOR, spec, arguments)

fun invokeSuperConstructor(spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, Alias.SUPER, Alias.SUPER, CONSTRUCTOR, spec, arguments)

fun invokeThisConstructor(localization: Type, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, localization, Defaults.ACCESS_THIS, CONSTRUCTOR, spec, arguments)

fun invokeThisConstructor(spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_SPECIAL, Alias.THIS, Defaults.ACCESS_THIS, CONSTRUCTOR, spec, arguments)

fun invokeStatic(localization: Type, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_STATIC, localization, Defaults.ACCESS_STATIC, name, spec, arguments)

fun invokeStatic(localization: Type, target: CodePart, name: String, spec: TypeSpec, arguments: List<CodePart>) =
        invoke(InvokeType.INVOKE_VIRTUAL, localization, target, name, spec, arguments)