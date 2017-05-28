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
/**
 * Add all `CodeType` properties to `Type`
 * as extension properties.
 */
@file:JvmName("ImplicitCodeType")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.type.CodeType
import java.lang.reflect.Type

/**
 * See [CodeType.type]
 */
val Type.type get() = this.codeType.type

/**
 * See [CodeType.canonicalName]
 */
val Type.canonicalName get() = this.codeType.canonicalName

/**
 * See [CodeType.packageName]
 */
val Type.packageName get() = this.codeType.packageName

/**
 * See [CodeType.simpleName]
 */
val Type.simpleName get() = this.codeType.simpleName

/**
 * Returns java spec name of [Type]. See [CodeType.javaSpecName]
 */
val Type.javaSpecName get() = this.codeType.javaSpecName

/**
 * Returns binary name of [Type]. See [CodeType.binaryName]
 */
val Type.binaryName get() = this.codeType.javaSpecName

/**
 * Returns internal name of [Type]. See [CodeType.binaryName]
 */
val Type.internalName get() = this.codeType.internalName

/**
 * See [CodeType.isPrimitive]
 */
val Type.isPrimitive get() = this.codeType.isPrimitive

/**
 * See [CodeType.isInterface]
 */
val Type.isInterface get() = this.codeType.isInterface

/**
 * See [CodeType.isVirtual]
 */
val Type.isVirtual get() = this.codeType.isVirtual

/**
 * See [CodeType.arrayDimension]
 */
val Type.arrayDimension get() = this.codeType.arrayDimension

/**
 * See [CodeType.isArray]
 */
val Type.isArray get() = this.codeType.isArray

/**
 * See [CodeType.wrapperType]
 */
val Type.wrapperType get() = this.codeType.wrapperType

/**
 * See [CodeType.primitiveType]
 */
val Type.primitiveType get() = this.codeType.primitiveType

/**
 * See [CodeType.arrayBaseComponent]
 */
val Type.arrayBaseComponent get() = this.codeType.arrayBaseComponent

/**
 * See [CodeType.arrayComponent]
 */
val Type.arrayComponent get() = this.codeType.arrayComponent

/**
 * See [CodeType.identification]
 */
val Type.identification get() = this.codeType.identification

/**
 * See [CodeType.defaultResolver]
 */
val Type.defaultResolver get() = this.codeType.defaultResolver

/**
 * See [CodeType.toArray]
 */
fun Type.toArray(dimensions: Int): CodeType = this.codeType.toArray(dimensions)

/**
 * See [CodeType.is]
 */
fun Type.`is`(another: Type?): Boolean = another != null && this.codeType.`is`(another.codeType)

/**
 * See [CodeType.compareTo]
 */
fun Type.compareTo(other: Type): Int = this.codeType.compareTo(other.codeType)

/**
 * See [CodeType.hashCode]
 */
fun Type.hash(): Int = this.codeType.hashCode()

/**
 * See [CodeType.equals]
 */
fun Type.eq(other: Any?): Boolean = (other as? Type)?.codeType?.let { this.codeType == it } ?: false
