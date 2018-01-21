/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
@file:JvmName("CodeTypes")

package com.github.jonathanxd.codeapi.type

import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.iutils.kt.rightOrFail
import com.github.jonathanxd.iutils.map.WeakValueHashMap
import java.lang.reflect.*
import kotlin.reflect.KClass

val <T> Class<T>.codeType: LoadedCodeType<T>
    get() = getJavaType(this)

val <T : Any> KClass<T>.codeType: CodeType
    get() = this.java.codeType

// Multi
val <T> Array<out Class<T>>.codeTypes: Array<CodeType>
    get() = Array(this.size) { this[it].codeType }

val <T : Any> Array<out KClass<T>>.codeTypes: Array<CodeType>
    get() = Array(this.size) { this[it].java.codeType }

val Array<out Type>.codeTypes: Array<CodeType>
    get() = Array(this.size) { this[it].codeType }

// /Multi

val CodeType.descName: String
    get() = "L${this.canonicalName};"

/**
 * Store cached [Type] instances.
 */
private val cache = WeakValueHashMap<Type, CodeType>()

val Type.codeType: CodeType get() = this.getType(false)

val Type.asGeneric: GenericType get() = this.codeType.let { it as? GenericType ?: Generic.type(it) }

val Type.toGeneric: GenericType
    get() = this.codeType.let {
        when (it) {
            is LoadedCodeType<*> -> it.loadedType.getCodeTypeFromTypeParameters()
            is TypeDeclaration -> Generic.type(it).of(*it.genericSignature.types)
            else -> it.defaultResolver.resolveTypeDeclaration(it).rightOrFail.asGeneric
        }
    }

/**
 * Gets the concrete type of [CodeType], if this is a [GenericType], the property getter will try to
 * infer the concrete type looping the [GenericType Inferred type][GenericType.resolvedType].
 *
 * Example: for `S extends List<String>`, it will return `List` (obs: the [GenericType.resolvedType] of `S extends List<String>` is `List<String>`.
 */
val CodeType.concreteType: CodeType
    get() = if (this is GenericType) {
        var type = this
        while (type is GenericType)
            type = type.resolvedType

        type
    } else this

fun Class<*>.getCodeTypeFromTypeParameters(): GenericType {
    var generic = Generic.type(this)

    this.typeParameters.forEach {
        generic = generic.of(it.getType(false))
    }

    return generic
}

/**
 * Gets [GenericType] from [Class]. Returned type is a generic type of [Class] and type parameters.
 */
fun Class<*>.getGenericType(): GenericType {
    val bounds = this.typeParameters.map { GenericType.GenericBound(it.getType()) }.toTypedArray()

    return Generic.type(this).of(*bounds)
}

/**
 * Gets the [CodeType] from a [Type]. This method only works for Java Reflection Types and [CodeType].
 */
fun Type.getType(isParameterized: Boolean = false): CodeType {

    if (this is CodeType)
        return this

    return synchronized(cache) { cache[this] } ?: when (this) {
        is ParameterizedType -> Generic.type(this.rawType.getType(false))
            .of(*this.actualTypeArguments.map { it.getType(true) }.filter { !it.`is`(Types.OBJECT) }.toTypedArray())
        is GenericArrayType -> Generic.type(this.genericComponentType.getType(false))
        is TypeVariable<*> -> {
            val type = Generic.type(this.name)

            if (isParameterized)
                return type

            type.`extends$`(*this.bounds.map { it.getType(false) }.filter { !it.`is`(Types.OBJECT) }.toTypedArray())

        }
        is WildcardType -> {
            var generic = Generic.wildcard()

            this.lowerBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = generic.`super$`(it.getType(false))
            }

            this.upperBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = generic.`extends$`(it.getType(false))
            }

            generic
        }
        is Class<*> -> this.codeType.let {
            it
        }
        else -> throw IllegalArgumentException("Cannot convert '$this' to CodeType.")
    }.let {
        synchronized(cache) { cache[this] = it }
        it
    }
}


fun CodeType.getType(name: String): CodeType? {
    if (this is GenericType)
        return this.getType(name)
    return null
}

fun CodeType.getType(name: String, inside: CodeType): CodeType? {
    if (this is GenericType)
        return this.getType(name, inside)
    return null
}

fun CodeType.applyType(typeName: String, type: CodeType): CodeType {
    if (this is GenericType)
        return this.applyType(typeName, type)
    else
        return this
}

fun GenericType.getType(name: String): CodeType? {
    if (!this.isType && !this.isWildcard && this.name == name)
        return this.resolvedType
    else
        return this.resolvedType.getType(name)
                ?: this.bounds.firstOrNull { it.type.getType(name) != null }?.type
}

fun GenericType.getType(name: String, inside: CodeType): CodeType? {
    val type = (inside as? GenericType)?.resolvedType ?: inside

    if (!this.isType && !this.isWildcard && this.name == name)
        return type
    else if (inside is GenericType) {
        this.resolvedType.getType(name, inside.resolvedType)?.let {
            return it
        }

        this.bounds.forEachIndexed { index, bound ->
            if (inside.bounds.size == this.bounds.size)
                bound.type.getType(name, inside.bounds[index].type)?.let { return it }
        }
    }

    return null
}

fun GenericType.applyType(typeName: String, type: CodeType): GenericType {
    val bounds = this.bounds.map {
        when (it) {
            is GenericType.GenericBound -> GenericType.GenericBound(
                it.type.applyType(
                    typeName,
                    type
                )
            )
            is GenericType.Super -> GenericType.Super(it.type.applyType(typeName, type))
            is GenericType.Extends -> GenericType.Extends(it.type.applyType(typeName, type))
            else -> throw IllegalArgumentException("Illegal bound type '$it'!")
        }
    }.toTypedArray()

    if (!this.isType && !this.isWildcard) {
        if (this.name == typeName) {
            return type as? GenericType ?: Generic.type(type).of(*bounds)
        }
    } else {
        if (this.isWildcard) {
            return Generic.wildcard().of(*bounds)
        }

        if (this.isType) {
            return Generic.type(this.resolvedType.applyType(typeName, type)).of(*bounds)
        }
    }

    return this
}

// Loaded types

/**
 * Cache [CodeType] instance of [Class]
 */
private val loadedCache = WeakValueHashMap<Class<*>, CodeType>()

/**
 * Gets the cached [LoadedCodeType] for [aClass] or create a instance of [LoadedCodeType]
 * if no one is cached.
 */
@Suppress("UNCHECKED_CAST")
private fun <T> getJavaType(aClass: Class<T>): LoadedCodeType<T> {

    if (aClass.isArray)
        return getJavaType0(aClass)

    if (loadedCache.containsKey(aClass)) {
        val codeType = loadedCache[aClass]

        if (codeType != null && codeType is LoadedCodeType<*>)
            return codeType as LoadedCodeType<T>
    }

    val javaType = JavaType(aClass)

    loadedCache.put(aClass, javaType)

    return javaType

}

/**
 * Gets the cached [LoadedCodeType] for [aClass] or create a instance of [LoadedCodeType]
 * if no one is cached. (treat arrays).
 */
@Suppress("UNCHECKED_CAST")
private fun <T> getJavaType0(aClass: Class<T>): LoadedCodeType<T> {

    if (loadedCache.containsKey(aClass)) {
        val codeType = loadedCache[aClass]

        if (codeType != null && codeType is LoadedCodeType<*>)
            return codeType as LoadedCodeType<T>
    }

    var type: LoadedCodeType<T> = JavaType(aClass)

    if (aClass.isArray) {
        var component: Class<*> = aClass

        var dimensions = 0

        do {
            ++dimensions
            component = component.componentType
        } while (component.isArray)

        type = JavaType(component as Class<T>).toLoadedArray(aClass, dimensions)
    }

    loadedCache.put(aClass, type)

    return type

}

/**
 * Compares this list of [Type] with [input type list][list]
 */
fun List<Type>.`is`(list: List<Type>) =
    if (this.size != list.size) false else this.indices.all { this[it].`is`(list[it]) }