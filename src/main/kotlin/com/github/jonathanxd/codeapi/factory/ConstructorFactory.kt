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
@file:JvmName("ConstructorFactory")
package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.base.impl.ConstructorDeclarationImpl
import com.github.jonathanxd.codeapi.common.CodeModifier
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.ArrayToList
import com.github.jonathanxd.codeapi.util.fromJavaModifiers
import com.github.jonathanxd.codeapi.util.emptyEnumSet
import java.util.*

// Short methods

fun constructor(signature: GenericSignature = GenericSignature.empty(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                parameters: Array<CodeParameter> = emptyArray(),
                source: CodeSource = CodeSource.empty()): ConstructorDeclaration {

    // Select correct method
    return constructor(
            annotations = emptyArray(),
            signature = signature,
            modifiers = modifiers,
            parameters = parameters,
            source = source
    )
}

fun constructor(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                parameters: Array<CodeParameter> = emptyArray(),
                source: CodeSource = CodeSource.empty()): ConstructorDeclaration {

    // Select correct method
    return constructor(
            annotations = emptyArray(),
            modifiers = modifiers,
            parameters = parameters,
            source = source
    )
}

fun constructor(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                source: CodeSource = CodeSource.empty()): ConstructorDeclaration {

    // Select correct method
    return constructor(
            annotations = emptyArray(),
            modifiers = modifiers,
            source = source
    )
}

// /Short methods

@JvmOverloads
fun constructor(annotations: Array<Annotation> = emptyArray(),
                signature: GenericSignature = GenericSignature.empty(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                parameters: Array<CodeParameter> = emptyArray(),
                source: CodeSource = CodeSource.empty(),
                comments: Comments = Comments.Absent): ConstructorDeclaration {
    return ConstructorDeclarationImpl(
            ArrayToList.toList(parameters),
            ArrayToList.toList(annotations),
            source,
            modifiers,
            signature,
            comments
    )
}

fun constructor(comments: Comments,
                annotations: Array<Annotation> = emptyArray(),
                signature: GenericSignature = GenericSignature.empty(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                parameters: Array<CodeParameter> = emptyArray(),
                source: CodeSource = CodeSource.empty()): ConstructorDeclaration {
    return ConstructorDeclarationImpl(
            ArrayToList.toList(parameters),
            ArrayToList.toList(annotations),
            source,
            modifiers,
            signature,
            comments
    )
}
