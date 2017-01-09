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
@file:JvmName("FieldFactory")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.FieldDeclaration
import com.github.jonathanxd.codeapi.base.impl.FieldDeclarationImpl
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.ArrayToList
import com.github.jonathanxd.codeapi.util.fromJavaModifiers

// Short methods

fun field(modifiers: Int = 0,
          type: CodeType,
          name: String): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), modifiers = modifiers, type = type, name = name)
}

fun field(modifiers: Int = 0,
          type: CodeType,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), modifiers = modifiers, type = type, name = name, value = value)
}

fun field(type: CodeType,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), type = type, name = name, value = value)
}

// /Short methods

@JvmOverloads
fun field(annotations: Array<Annotation> = emptyArray(),
          modifiers: Int = 0,
          type: CodeType,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    return FieldDeclarationImpl(
            ArrayToList.toList(annotations),
            value,
            fromJavaModifiers(modifiers),
            name,
            type
    )
}

