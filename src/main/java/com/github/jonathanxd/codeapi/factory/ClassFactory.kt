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

import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.PredefinedTypes
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.impl.AnnotationDeclarationImpl
import com.github.jonathanxd.codeapi.base.impl.ClassDeclarationImpl
import com.github.jonathanxd.codeapi.base.impl.EnumDeclarationImpl
import com.github.jonathanxd.codeapi.base.impl.InterfaceDeclarationImpl
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.ArrayToList
import com.github.jonathanxd.codeapi.util.fromJavaModifiers


// Short methods
fun aClass(modifiers: Int = 0,
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

fun aClass(modifiers: Int = 0,
           qualifiedName: String,
           superType: CodeType = PredefinedTypes.OBJECT,
           implementations: Array<CodeType> = emptyArray(),
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
           modifiers: Int = 0,
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: CodeType = PredefinedTypes.OBJECT,
           implementations: Array<CodeType> = emptyArray(),
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

fun aClass(modifiers: Int = 0,
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: CodeType = PredefinedTypes.OBJECT,
           implementations: Array<CodeType> = emptyArray(),
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
fun aClass(outerClass: CodeType? = null,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: Int = 0,
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           superType: CodeType = PredefinedTypes.OBJECT,
           implementations: Array<CodeType> = emptyArray(),
           source: CodeSource = CodeSource.empty()): ClassDeclaration {
    return ClassDeclarationImpl(
            superType,
            ArrayToList.toList(implementations),
            qualifiedName,
            ArrayToList.toList(annotations),
            source,
            fromJavaModifiers(modifiers),
            signature,
            outerClass
    )
}

@JvmOverloads
fun anInterface(outerClass: CodeType? = null,
                annotations: Array<Annotation> = emptyArray(),
                modifiers: Int = 0,
                qualifiedName: String,
                signature: GenericSignature = GenericSignature.empty(),
                superInterfaces: Array<CodeType> = emptyArray(),
                source: CodeSource = CodeSource.empty()): InterfaceDeclaration {
    return InterfaceDeclarationImpl(
            outerClass = outerClass,
            annotations = ArrayToList.toList(annotations),
            modifiers = fromJavaModifiers(modifiers),
            genericSignature = signature,
            qualifiedName = qualifiedName,
            implementations = ArrayToList.toList(superInterfaces),
            body = source
    )
}

@JvmOverloads
fun anAnnotation(outerClass: CodeType? = null,
                 annotations: Array<Annotation> = emptyArray(),
                 modifiers: Int = 0,
                 qualifiedName: String,
                 signature: GenericSignature = GenericSignature.empty(),
                 properties: Array<AnnotationProperty> = emptyArray(),
                 source: CodeSource = CodeSource.empty()): AnnotationDeclaration {
    return AnnotationDeclarationImpl(
            outerClass = outerClass,
            annotations = ArrayToList.toList(annotations),
            modifiers = fromJavaModifiers(modifiers),
            genericSignature = signature,
            qualifiedName = qualifiedName,
            properties = ArrayToList.toList(properties),
            body = source
    )
}


@JvmOverloads
fun anEnum(outerClass: CodeType? = null,
           annotations: Array<Annotation> = emptyArray(),
           modifiers: Int = 0,
           qualifiedName: String,
           signature: GenericSignature = GenericSignature.empty(),
           implementations: Array<CodeType> = emptyArray(),
           entries: Array<EnumEntry> = emptyArray(),
           source: CodeSource = CodeSource.empty()): EnumDeclaration {
    return EnumDeclarationImpl(
            outerClass = outerClass,
            annotations = ArrayToList.toList(annotations),
            modifiers = fromJavaModifiers(modifiers),
            genericSignature = signature,
            qualifiedName = qualifiedName,
            implementations = ArrayToList.toList(implementations),
            entries = ArrayToList.toList(entries),
            body = source
    )
}
