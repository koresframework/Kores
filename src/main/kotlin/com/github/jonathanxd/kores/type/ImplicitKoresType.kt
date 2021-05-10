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
/**
 * Add all `KoresType` properties to `Type`
 * as extension properties.
 */
@file:JvmName("ImplicitKoresType")

package com.github.jonathanxd.kores.type

import com.github.jonathanxd.kores.util.identityEq
import com.github.jonathanxd.kores.util.identityHash
import java.lang.reflect.Type

/**
 * See [KoresType.type]
 */
val Type.type get() = this.koresType.type

/**
 * See [KoresType.canonicalName]
 */
val Type.canonicalName get() = this.koresType.canonicalName

/**
 * See [KoresType.packageName]
 */
val Type.packageName get() = this.koresType.packageName

/**
 * See [KoresType.simpleName]
 */
val Type.simpleName get() = this.koresType.simpleName

/**
 * Returns java spec name of [Type]. See [KoresType.javaSpecName]
 */
val Type.javaSpecName get() = this.koresType.javaSpecName

/**
 * Returns binary name of [Type]. See [KoresType.binaryName]
 */
val Type.binaryName get() = this.koresType.binaryName

/**
 * Returns internal name of [Type]. See [KoresType.binaryName]
 */
val Type.internalName get() = this.koresType.internalName

/**
 * See [KoresType.isPrimitive]
 */
val Type.isPrimitive get() = this.koresType.isPrimitive

/**
 * See [KoresType.isInterface]
 */
val Type.isInterface get() = this.koresType.isInterface

/**
 * See [KoresType.isVirtual]
 */
val Type.isVirtual get() = this.koresType.isVirtual

/**
 * See [KoresType.arrayDimension]
 */
val Type.arrayDimension get() = this.koresType.arrayDimension

/**
 * See [KoresType.isArray]
 */
val Type.isArray get() = this.koresType.isArray

/**
 * See [KoresType.wrapperType]
 */
val Type.wrapperType get() = this.koresType.wrapperType

/**
 * See [KoresType.primitiveType]
 */
val Type.primitiveType get() = this.koresType.primitiveType

/**
 * See [KoresType.arrayBaseComponent]
 */
val Type.arrayBaseComponent get() = this.koresType.arrayBaseComponent

/**
 * See [KoresType.arrayComponent]
 */
val Type.arrayComponent get() = this.koresType.arrayComponent

/**
 * See [KoresType.identification]
 */
val Type.identification get() = this.koresType.identification

/**
 * See [KoresType.defaultResolver]
 */
val Type.defaultResolver get() = this.koresType.defaultResolver

/**
 * See [KoresType.bindedDefaultResolver]
 */
val Type.bindedDefaultResolver get() = this.koresType.bindedDefaultResolver

/**
 * See [KoresType.concreteType]
 */
val Type.concreteType get() = this.koresType.concreteType

/**
 * See [KoresType.superType]
 */
val Type.superType get() = this.koresType.superType

/**
 * See [KoresType.interfaces]
 */
val Type.interfaces get() = this.koresType.interfaces

/**
 * See [KoresType.isAssignableFrom]
 */
fun Type.isAssignableFrom(type: Type) = this.koresType.isAssignableFrom(type)

/**
 * See [KoresType.isAssignableFrom]
 */
fun Type.isAssignableFrom(type: Type, resolverProvider: (Type) -> KoresTypeResolver<*>) =
    this.koresType.isAssignableFrom(type, resolverProvider)

/**
 * See [KoresType.safeIsAssignableFrom]
 */
fun Type.safeIsAssignableFrom(type: Type) = this.koresType.safeIsAssignableFrom(type)

/**
 * See [KoresType.safeIsAssignableFrom]
 */
fun Type.safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> KoresTypeResolver<*>) =
    this.koresType.safeIsAssignableFrom(type, resolverProvider)

/**
 * See [KoresType.toArray]
 */
fun Type.toArray(dimensions: Int): KoresType = this.koresType.toArray(dimensions)

/**
 * See [KoresType.is]
 */
fun Type.`is`(another: Type?): Boolean = another != null && this.koresType.`is`(another.koresType)

/**
 * See [KoresType.isConcreteIdEq]
 */
fun Type.isConcreteIdEq(another: Type): Boolean = this.koresType.isConcreteIdEq(another.koresType)

/**
 * See [KoresType.compareTo]
 */
fun Type.compareTo(other: Type): Int = this.koresType.compareTo(other.koresType)

/**
 * See [KoresType.hashCode]
 */
fun Type.hash(): Int = this.koresType.identityHash()

/**
 * See [KoresType.equals]
 */
fun Type.eq(other: Any?): Boolean =
    (other as? Type)?.koresType?.let { this.koresType.identityEq(it) } ?: false
