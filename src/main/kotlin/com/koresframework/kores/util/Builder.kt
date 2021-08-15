/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.util

import com.koresframework.kores.base.KoresParameter
import com.koresframework.kores.base.MethodDeclaration
import com.koresframework.kores.factory.koresParameter
import com.koresframework.kores.factory.parameter
import com.koresframework.kores.type.typeOf

inline fun <reified R> MethodDeclaration.Builder.returnType() = returnType(typeOf<R>())

fun MethodDeclaration.Builder.parametersVararg(vararg parameters: KoresParameter) =
    parameters(parameters.toList())

inline fun <reified P1> MethodDeclaration.Builder.parameters1(name: String) =
    parameters(listOf(koresParameter().type(typeOf<P1>()).name(name).build()))

inline fun <reified P1, reified P2> MethodDeclaration.Builder.parameters2(name1: String, name2: String) =
    parameters(listOf(
        parameter(type = typeOf<P1>(), name = name1),
        parameter(type = typeOf<P2>(), name = name2),
    ))

inline fun <reified P1, reified P2, reified P3> MethodDeclaration.Builder.parameters3(name1: String, name2: String, name3: String) =
    parameters(listOf(
        parameter(type = typeOf<P1>(), name = name1),
        parameter(type = typeOf<P2>(), name = name2),
        parameter(type = typeOf<P3>(), name = name3),
    ))

inline fun <reified P1, reified P2, reified P3, reified P4> MethodDeclaration.Builder.parameters4(
    name1: String,
    name2: String,
    name3: String,
    name4: String
) =
    parameters(listOf(
        parameter(type = typeOf<P1>(), name = name1),
        parameter(type = typeOf<P2>(), name = name2),
        parameter(type = typeOf<P3>(), name = name3),
        parameter(type = typeOf<P4>(), name = name4),
    ))

inline fun <reified P1, reified P2, reified P3, reified P4, reified P5> MethodDeclaration.Builder.parameters5(
    name1: String,
    name2: String,
    name3: String,
    name4: String,
    name5: String
) =
    parameters(listOf(
        parameter(type = typeOf<P1>(), name = name1),
        parameter(type = typeOf<P2>(), name = name2),
        parameter(type = typeOf<P3>(), name = name3),
        parameter(type = typeOf<P4>(), name = name4),
        parameter(type = typeOf<P5>(), name = name5),
    ))