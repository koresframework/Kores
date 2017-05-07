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
package com.github.jonathanxd.codeapi.util.conversion

import com.github.jonathanxd.codeapi.base.CodeModifier
import com.github.jonathanxd.codeapi.base.CodeParameter
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.util.fromJavaModifiers
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.*
import kotlin.reflect.KParameter
import kotlin.reflect.full.valueParameters
import kotlin.reflect.jvm.kotlinFunction

/**
 * Returns true if receiver [Method] is accessible from [typeDeclaration] or accessible to be [overwritten][override]
 * from [typeDeclaration].
 *
 * @param override True to check if method is accessible to be overwritten by [typeDeclaration] method.
 */
@JvmOverloads
fun Method.isAccessibleFrom(typeDeclaration: TypeDeclaration, override: Boolean = false): Boolean {
    val package_ = typeDeclaration.packageName
    val methodPackage = this.declaringClass.`package`?.name
    val modifiers = this.modifiers

    return if (Modifier.isPublic(modifiers)
            || (override && Modifier.isProtected(modifiers)))
        true
    else methodPackage != null && package_ == methodPackage
}

fun fixModifiers(modifiers: Int): EnumSet<CodeModifier> = EnumSet.copyOf(fromJavaModifiers(modifiers).let {
    it.remove(CodeModifier.ABSTRACT)
    return@let it
})

/**
 * Returns if [method] is valid for implementation.
 */
fun isValidImpl(method: Method) = !method.isBridge
        && !method.isSynthetic
        && !Modifier.isNative(method.modifiers)
        && !Modifier.isFinal(method.modifiers)

/**
 * Checks if all elements of receiver [Iterable] is equal to elements of [other].
 */
fun <T : Any> Iterable<T>.isEqual(other: Iterable<*>): Boolean {

    val thisIterator = this.iterator()
    val otherIterator = other.iterator()

    while (thisIterator.hasNext() && otherIterator.hasNext()) {
        if (thisIterator.next() != otherIterator.next())
            return false

    }

    return !thisIterator.hasNext() && !otherIterator.hasNext()
}

/**
 * Gets parameter names of receiver [Method].
 */
val Method.parameterNames: List<String>
    get() = this.kotlinParameters?.mapIndexed { i, it -> it.name ?: this.parameters[i].name } ?: this.parameters.map { it.name }

/**
 * Gets kotlin parameters from receiver [Method].
 */
val Method.kotlinParameters: List<KParameter>?
    get() = this.kotlinFunction?.valueParameters

/**
 * Gets code parameters of receiver [Method].
 */
val Method.codeParameters: List<CodeParameter>
    get() = this.kotlinParameters?.map { it.toCodeParameter() } ?: this.parameters.map { it.toCodeParameter() }

/**
 * Gets parameter names of receiver [Constructor].
 */
val <T: Any> Constructor<T>.parameterNames: List<String>
    get() = this.kotlinParameters?.mapIndexed { i, it -> it.name ?: this.parameters[i].name } ?: this.parameters.map { it.name }

/**
 * Gets kotlin parameter of receiver [Constructor].
 */
val <T: Any> Constructor<T>.kotlinParameters: List<KParameter>?
    get() = this.kotlinFunction?.valueParameters

/**
 * Gets code parameters of receiver [Method].
 */
val <T: Any> Constructor<T>.codeParameters: List<CodeParameter>
    get() = this.kotlinParameters?.map { it.toCodeParameter() } ?: this.parameters.map { it.toCodeParameter() }