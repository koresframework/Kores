/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
@file:JvmName("DynamicInvocationFactory")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.base.InvokeDynamic
import com.github.jonathanxd.codeapi.base.LocalCode
import com.github.jonathanxd.codeapi.base.TypeSpec
import com.github.jonathanxd.codeapi.common.DynamicMethodSpec
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec
import com.github.jonathanxd.codeapi.common.MethodTypeSpec

/**
 * @see InvokeDynamic
 */
fun invokeDynamic(
    bootstrap: MethodInvokeSpec,
    dynamicMethod: DynamicMethodSpec,
    args: List<Any>
): InvokeDynamic =
    InvokeDynamic(bootstrap, dynamicMethod, args)

/**
 * @see InvokeDynamic
 */
fun invokeDynamicLambda(
    methodRef: MethodInvokeSpec,
    target: CodeInstruction,
    arguments: List<CodeInstruction>,
    baseSam: MethodTypeSpec, expectedTypes: TypeSpec
): InvokeDynamic.LambdaMethodRef =
    InvokeDynamic.LambdaMethodRef(methodRef, target, arguments, baseSam, expectedTypes)

/**
 * @see InvokeDynamic
 */
fun invokeDynamicLambdaCode(
    baseSam: MethodTypeSpec,
    expectedTypes: TypeSpec,
    localCode: LocalCode,
    arguments: List<CodeInstruction>
): InvokeDynamic.LambdaLocalCode =
    InvokeDynamic.LambdaLocalCode(baseSam, expectedTypes, localCode, arguments)