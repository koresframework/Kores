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
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.base.CodeModifier
import com.github.jonathanxd.codeapi.util.emptyEnumSet
import java.lang.reflect.Type
import java.util.*

// Short methods

/**
 * @see FieldDeclaration
 */
fun field(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
          type: Type,
          name: String): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), modifiers = modifiers, type = type, name = name)
}

/**
 * @see FieldDeclaration
 */
fun field(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
          type: Type,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), modifiers = modifiers, type = type, name = name, value = value)
}

/**
 * @see FieldDeclaration
 */
fun field(type: Type,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    // Provide annotations argument to let Kotlin Compiler to select correct method
    return field(annotations = emptyArray(), type = type, name = name, value = value)
}

// /Short methods

/**
 * @see FieldDeclaration
 */
@JvmOverloads
fun field(annotations: Array<Annotation> = emptyArray(),
          modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
          type: Type,
          name: String,
          value: CodePart? = null,
          comments: Comments = Comments.Absent): FieldDeclaration {
    return FieldDeclaration(
            annotations = annotations.toList(),
            value = value,
            modifiers = modifiers,
            name = name,
            type = type,
            comments = comments
    )
}

/**
 * @see FieldDeclaration
 */
fun field(comments: Comments,
          annotations: Array<Annotation> = emptyArray(),
          modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
          type: Type,
          name: String,
          value: CodePart? = null): FieldDeclaration {
    return FieldDeclaration(
            annotations = annotations.toList(),
            value = value,
            modifiers = modifiers,
            name = name,
            type = type,
            comments = comments
    )
}
