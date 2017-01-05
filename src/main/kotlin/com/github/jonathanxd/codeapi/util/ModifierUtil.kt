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
@file:JvmName("ModifierUtil")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.common.CodeModifier
import java.lang.reflect.Member
import java.lang.reflect.Modifier

/**
 * Extract modifiers from a [Member]

 * @param member Member
 * *
 * @return Sorted Collection of modifiers
 */
fun extractModifiers(member: Member): Collection<CodeModifier> {

    val modifiers = member.modifiers

    val collection = extractModifiers(modifiers)

    if (member.declaringClass.isInterface && Modifier.isPublic(modifiers) && !Modifier.isAbstract(modifiers) && !Modifier.isStatic(modifiers)) {
        collection.add(CodeModifier.DEFAULT)
    }


    return collection
}

/**
 * Extract modifiers from Java modifiers flags ([Modifier]).

 * @param modifiers Modifiers flags.
 * *
 * @return Sorted Collection of modifiers.
 */
fun extractModifiers(modifiers: Int): MutableCollection<CodeModifier> {
    val collection = java.util.TreeSet<CodeModifier>()

    if (Modifier.isPublic(modifiers)) {
        collection.add(CodeModifier.PUBLIC)
    } else if (Modifier.isPrivate(modifiers)) {
        collection.add(CodeModifier.PRIVATE)
    } else if (Modifier.isProtected(modifiers)) {
        collection.add(CodeModifier.PROTECTED)
    } else {
        collection.add(CodeModifier.PACKAGE_PRIVATE)
    }


    if (Modifier.isAbstract(modifiers)) {
        collection.add(CodeModifier.ABSTRACT)
    }


    if (Modifier.isStatic(modifiers)) {
        collection.add(CodeModifier.STATIC)
    }


    if (Modifier.isFinal(modifiers)) {
        collection.add(CodeModifier.FINAL)
    }


    if (Modifier.isTransient(modifiers)) {
        collection.add(CodeModifier.TRANSIENT)
    }


    if (Modifier.isVolatile(modifiers)) {
        collection.add(CodeModifier.VOLATILE)
    }


    if (Modifier.isSynchronized(modifiers)) {
        collection.add(CodeModifier.SYNCHRONIZED)
    }


    if (Modifier.isNative(modifiers)) {
        collection.add(CodeModifier.NATIVE)
    }


    if (Modifier.isStrict(modifiers)) {
        collection.add(CodeModifier.STRICTFP)
    }

    if (Internal.isBridge(modifiers)) {
        collection.add(CodeModifier.BRIDGE)
    }

    if (Internal.isVarArgs(modifiers)) {
        collection.add(CodeModifier.VARARGS)
    }

    if (Internal.isSynthetic(modifiers)) {
        collection.add(CodeModifier.SYNTHETIC)
    }

    if (Internal.isAnnotation(modifiers)) {
        collection.add(CodeModifier.ANNOTATION)
    }

    if (Internal.isEnum(modifiers)) {
        collection.add(CodeModifier.ENUM)
    }

    if (Internal.isMandated(modifiers)) {
        collection.add(CodeModifier.MANDATED)
    }

    return collection
}

/**
 * Modifiers to String
 *
 * @param collection Modifiers
 * @return String containing all modifiers name.
 */
fun toString(collection: Collection<CodeModifier>?): String {
    return collection?.sorted()?.map { it.expr }?.joinToString(" ") ?: ""
}

/**
 * Convert [CodeModifier]s to Java Modifiers flags.
 *
 * @param modifiers Modifiers
 * @return Java modifiers flags ([Modifier])
 */
fun toJavaModifier(modifiers: Collection<CodeModifier>): Int {
    var end = 0

    for (modifier in modifiers) {
        val toJavaModifier = toJavaModifier(modifier)

        if (toJavaModifier != 0) {
            end = end or toJavaModifier
        }
    }

    return end
}

/**
 * Convert a [CodeModifier] to Java Modifiers flags.
 *
 * @param codeModifier Modifier to convert
 * @return Java modifiers flags ([Modifier])
 */
fun toJavaModifier(codeModifier: CodeModifier): Int {
    when (codeModifier) {
        CodeModifier.ABSTRACT -> return Modifier.ABSTRACT
        CodeModifier.FINAL -> return Modifier.FINAL
        CodeModifier.NATIVE -> return Modifier.NATIVE
        CodeModifier.PRIVATE -> return Modifier.PRIVATE
        CodeModifier.PROTECTED -> return Modifier.PROTECTED
        CodeModifier.PUBLIC -> return Modifier.PUBLIC
        CodeModifier.STATIC -> return Modifier.STATIC
        CodeModifier.STRICTFP -> return Modifier.STRICT
        CodeModifier.SYNCHRONIZED -> return Modifier.SYNCHRONIZED
        CodeModifier.TRANSIENT -> return Modifier.TRANSIENT
        CodeModifier.VOLATILE -> return Modifier.VOLATILE
        CodeModifier.BRIDGE -> return Internal.BRIDGE
        CodeModifier.VARARGS -> return Internal.VARARGS
        CodeModifier.SYNTHETIC -> return Internal.SYNTHETIC
        CodeModifier.ANNOTATION -> return Internal.ANNOTATION
        CodeModifier.ENUM -> return Internal.ENUM
        CodeModifier.MANDATED -> return Internal.MANDATED
        else -> return 0
    }
}

fun newModifierSet(): Set<CodeModifier> {
    return java.util.HashSet<CodeModifier>()
}

object Internal {
    val BRIDGE = 0x00000040
    val VARARGS = 0x00000080
    val SYNTHETIC = 0x00001000
    val ANNOTATION = 0x00002000
    val ENUM = 0x00004000
    val MANDATED = 0x00008000

    fun isBridge(modifiers: Int): Boolean {
        return modifiers and BRIDGE != 0
    }

    fun isVarArgs(modifiers: Int): Boolean {
        return modifiers and VARARGS != 0
    }

    fun isSynthetic(modifiers: Int): Boolean {
        return modifiers and SYNTHETIC != 0
    }

    fun isAnnotation(modifiers: Int): Boolean {
        return modifiers and ANNOTATION != 0
    }

    fun isEnum(modifiers: Int): Boolean {
        return modifiers and ENUM != 0
    }

    fun isMandated(modifiers: Int): Boolean {
        return modifiers and MANDATED != 0
    }
}