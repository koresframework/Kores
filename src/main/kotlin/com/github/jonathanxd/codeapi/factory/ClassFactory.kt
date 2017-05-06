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
@file:JvmName("ClassFactory")

package com.github.jonathanxd.codeapi.factory

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.base.CodeModifier
import com.github.jonathanxd.codeapi.base.TypeSpec
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.emptyEnumSet
import java.lang.reflect.Type
import java.util.*

// ---------------------------------------------------------------
//       Class
// ---------------------------------------------------------------

// Short methods
fun aClass(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    // Select correct method
    return aClass(
            outerClass = null,
            modifiers = modifiers,
            qualifiedName = qualifiedName,
            source = source
    )
}

fun aClass(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           superType: Type = Types.OBJECT,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    // Select correct method
    return aClass(
            outerClass = null,
            modifiers = modifiers,
            qualifiedName = qualifiedName,
            superType = superType,
            implementations = implementations,
            source = source
    )
}

fun aClass(annotations: Array<Annotation> = emptyArray(),
           modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: Type = Types.OBJECT,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    return aClass(
            outerClass = null,
            annotations = annotations,
            modifiers = modifiers,
            qualifiedName = qualifiedName,
            signature = signature,
            superType = superType,
            implementations = implementations,
            source = source
    )
}

fun aClass(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: Type = Types.OBJECT,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    // Select correct method
    return aClass(
            outerClass = null,
            modifiers = modifiers,
            qualifiedName = qualifiedName,
            signature = signature,
            superType = superType,
            implementations = implementations,
            source = source
    )
}

// /Short methods

@JvmOverloads
fun aClass(outerClass: Type? = null,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: Type = Types.OBJECT,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty(),
           comments: Comments = Comments.Absent): ClassDeclaration {
    return ClassDeclaration(
            superClass = superType,
            implementations = implementations.toList(),
            specifiedName = qualifiedName,
            annotations = annotations.toList(),
            body = source,
            modifiers = modifiers,
            genericSignature = signature,
            outerClass = outerClass,
            comments = comments
    )
}

fun aClass(outerClass: Type? = null,
           comments: Comments,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: Type = Types.OBJECT,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    return ClassDeclaration(
            superClass = superType,
            implementations = implementations.toList(),
            specifiedName = qualifiedName,
            annotations = annotations.toList(),
            body = source,
            modifiers = modifiers,
            genericSignature = signature,
            outerClass = outerClass,
            comments = comments
    )
}

// ---------------------------------------------------------------
//       Interface
// ---------------------------------------------------------------


// Short methods
fun anInterface(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anInterface(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                source = source
        )


fun anInterface(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                superInterfaces: Array<Type> = emptyArray(),
                source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anInterface(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                superInterfaces = superInterfaces,
                source = source
        )


fun anInterface(annotations: Array<Annotation> = emptyArray(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                signature: GenericSignature = GenericSignature.empty(),
                superInterfaces: Array<Type> = emptyArray(),
                source: CodeSource = CodeSource.empty()) =
        anInterface(
                outerClass = null,
                annotations = annotations,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                signature = signature,
                superInterfaces = superInterfaces,
                source = source
        )


fun anInterface(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                signature: GenericSignature = GenericSignature.empty(),
                superInterfaces: Array<Type> = emptyArray(),
                source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anInterface(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                signature = signature,
                superInterfaces = superInterfaces,
                source = source
        )


// /Short methods

@JvmOverloads
fun anInterface(outerClass: Type? = null,
                annotations: Array<Annotation> = emptyArray(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                signature: GenericSignature = GenericSignature.empty(),
                superInterfaces: Array<Type> = emptyArray(),
                source: CodeSource = CodeSource.empty(),
                comments: Comments = Comments.Absent): InterfaceDeclaration {
    return InterfaceDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            implementations = superInterfaces.toList(),
            body = source,
            comments = comments
    )
}

fun anInterface(outerClass: Type? = null,
                comments: Comments,
                annotations: Array<Annotation> = emptyArray(),
                modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                qualifiedName: String,
                signature: GenericSignature = GenericSignature.empty(),
                superInterfaces: Array<Type> = emptyArray(),
                source: CodeSource = CodeSource.empty()): InterfaceDeclaration {
    return InterfaceDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            implementations = superInterfaces.toList(),
            comments = comments,
            body = source
    )
}

// ---------------------------------------------------------------
//       Annotation
// ---------------------------------------------------------------

// Short methods
fun anAnnotation(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                 qualifiedName: String,
                 properties: Array<AnnotationProperty> = emptyArray(),
                 source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anAnnotation(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                properties = properties,
                source = source
        )

fun anAnnotation(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                 qualifiedName: String,
                 source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anAnnotation(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                properties = emptyArray(),
                source = source
        )

fun anAnnotation(qualifiedName: String,
                 source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anAnnotation(
                outerClass = null,
                modifiers = emptyEnumSet(),
                qualifiedName = qualifiedName,
                properties = emptyArray(),
                source = source
        )

// /Short methods


@JvmOverloads
fun anAnnotation(outerClass: Type? = null,
                 annotations: Array<Annotation> = emptyArray(),
                 modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                 qualifiedName: String,
                 signature: GenericSignature = GenericSignature.empty(),
                 properties: Array<AnnotationProperty> = emptyArray(),
                 source: CodeSource = CodeSource.empty(),
                 comments: Comments = Comments.Absent): AnnotationDeclaration {
    return AnnotationDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            properties = properties.toList(),
            body = source,
            comments = comments
    )
}

fun anAnnotation(outerClass: Type? = null,
                 comments: Comments,
                 annotations: Array<Annotation> = emptyArray(),
                 modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
                 qualifiedName: String,
                 signature: GenericSignature = GenericSignature.empty(),
                 properties: Array<AnnotationProperty> = emptyArray(),
                 source: CodeSource = CodeSource.empty()): AnnotationDeclaration {
    return AnnotationDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            properties = properties.toList(),
            comments = comments,
            body = source
    )
}

// ---------------------------------------------------------------
//       Enum
// ---------------------------------------------------------------

// Short methods
fun anEnum(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anEnum(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                entries = emptyArray(),
                source = source
        )


fun anEnum(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           implementations: Array<Type> = emptyArray(),
           source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anEnum(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                implementations = implementations,
                entries = emptyArray(),
                source = source
        )


fun anEnum(modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           implementations: Array<Type> = emptyArray(),
           entries: Array<EnumEntry> = emptyArray(),
           source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anEnum(
                outerClass = null,
                modifiers = modifiers,
                qualifiedName = qualifiedName,
                implementations = implementations,
                entries = entries,
                source = source
        )


fun anEnum(qualifiedName: String,
           source: CodeSource = CodeSource.empty()) =
        // Select correct method
        anEnum(
                outerClass = null,
                modifiers = emptyEnumSet(),
                qualifiedName = qualifiedName,
                entries = emptyArray(),
                source = source
        )

// /Short methods

@JvmOverloads
fun anEnum(outerClass: Type? = null,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           implementations: Array<Type> = emptyArray(),
           entries: Array<EnumEntry> = emptyArray(),
           source: CodeSource = CodeSource.empty(),
           comments: Comments = Comments.Absent): EnumDeclaration {
    return EnumDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            implementations = implementations.toList(),
            entries = entries.toList(),
            body = source,
            comments = comments
    )
}

fun anEnum(outerClass: Type? = null,
           comments: Comments,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: EnumSet<CodeModifier> = emptyEnumSet(),
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           implementations: Array<Type> = emptyArray(),
           entries: Array<EnumEntry> = emptyArray(),
           source: CodeSource = CodeSource.empty()): EnumDeclaration {
    return EnumDeclaration(
            outerClass = outerClass,
            annotations = annotations.toList(),
            modifiers = modifiers,
            genericSignature = signature,
            specifiedName = qualifiedName,
            implementations = implementations.toList(),
            entries = entries.toList(),
            comments = comments,
            body = source
    )
}


// ---------------------------------------------------------------
//       Anonymous class
// ---------------------------------------------------------------

// Short methods
fun anonymousClass(outerClass: Type,
                   name: String,
                   superType: Type,
                   source: CodeSource = CodeSource.empty()): AnonymousClass {
    // Select correct method
    return anonymousClass(
            outerClass = outerClass,
            qualifiedName = name,
            superType = superType,
            source = source
    )
}

fun anonymousClass(outerClass: Type,
                   name: String,
                   superType: Type,
                   constructorSpec: TypeSpec,
                   arguments: Array<CodePart>,
                   source: CodeSource = CodeSource.empty()): AnonymousClass {
    // Select correct method
    return anonymousClass(
            outerClass = outerClass,
            qualifiedName = name,
            superType = superType,
            constructorSpec = constructorSpec,
            arguments = arguments,
            source = source
    )
}

fun anonymousClass(outerClass: Type,
                   name: String,
                   superType: Type,
                   constructorSpec: TypeSpec,
                   arguments: Array<CodePart>,
                   constructorBody: CodeSource,
                   source: CodeSource = CodeSource.empty()): AnonymousClass {
    // Select correct method
    return anonymousClass(
            outerClass = outerClass,
            qualifiedName = name,
            superType = superType,
            arguments = arguments,
            constructorSpec = constructorSpec,
            constructorBody = constructorBody,
            source = source
    )
}

// /Short methods

@JvmOverloads
fun anonymousClass(outerClass: Type,
                   annotations: Array<Annotation> = emptyArray(),
                   qualifiedName: String,
                   superType: Type,
                   constructorSpec: TypeSpec = TypeSpec(Types.VOID),
                   arguments: Array<CodePart> = emptyArray(),
                   source: CodeSource = CodeSource.empty(),
                   constructorBody: CodeSource = CodeSource.empty(),
                   comments: Comments = Comments.Absent): AnonymousClass {
    return AnonymousClass(
            outerClass = outerClass,
            annotations = annotations.toList(),
            comments = comments,
            superClass = superType,
            specifiedName = qualifiedName,
            body = source,
            constructorSpec = constructorSpec,
            arguments = arguments.toList(),
            constructorBody = constructorBody,
            implementations = emptyList()
    )
}

