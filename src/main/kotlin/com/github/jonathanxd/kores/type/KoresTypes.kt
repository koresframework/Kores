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
@file:JvmName("KoresTypes")

package com.github.jonathanxd.kores.type

import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.TypeDeclaration
import com.github.jonathanxd.iutils.kt.rightOrFail
import com.github.jonathanxd.iutils.map.WeakValueHashMap
import java.lang.reflect.*
import kotlin.reflect.KClass

val <T> Class<T>.koresType: LoadedKoresType<T>
    get() = getJavaType(this)

val <T : Any> KClass<T>.koresType: KoresType
    get() = this.java.koresType

// Multi
val <T> Array<out Class<T>>.koresTypes: Array<KoresType>
    get() = Array(this.size) { this[it].koresType }

val <T : Any> Array<out KClass<T>>.koresTypes: Array<KoresType>
    get() = Array(this.size) { this[it].java.koresType }

val Array<out Type>.koresTypes: Array<KoresType>
    get() = Array(this.size) { this[it].koresType }

// /Multi

val KoresType.descName: String
    get() = "L${this.canonicalName};"

/**
 * Store cached [Type] instances.
 */
private val cache = WeakValueHashMap<Type, KoresType>()

val Type.koresType: KoresType get() = this.getType(false)

val Type.asGeneric: GenericType get() = this.koresType.let { it as? GenericType ?: Generic.type(it) }

val Type.toGeneric: GenericType
    get() = this.koresType.let {
        when (it) {
            is LoadedKoresType<*> -> it.loadedType.getKoresTypeFromTypeParameters()
            is TypeDeclaration -> Generic.type(it).of(*it.genericSignature.types)
            else -> it.defaultResolver.resolveTypeDeclaration(it).rightOrFail.toGeneric
        }
    }

/**
 * Gets the concrete type of [KoresType], if this is a [GenericType], the property getter will try to
 * infer the concrete type looping the [GenericType Inferred type][GenericType.resolvedType].
 *
 * Example: for `S extends List<String>`, it will return `List` (obs: the [GenericType.resolvedType] of `S extends List<String>` is `List<String>`.
 */
val KoresType.concreteType: KoresType
    get() = if (this is GenericType) {
        var type = this
        while (type is GenericType)
            type = type.resolvedType

        type
    } else this

fun Class<*>.getKoresTypeFromTypeParameters(): GenericType {
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
 * Gets the [KoresType] from a [Type]. This method only works for Java Reflection Types and [KoresType].
 */
fun Type.getType(isParameterized: Boolean = false): KoresType =
    this.getType(previous = null, isParameterized)
/**
 * Gets the [KoresType] from a [Type]. This method only works for Java Reflection Types and [KoresType].
 */
fun Type.getType(previous: Type? = null, isParameterized: Boolean = false): KoresType {

    if (this is KoresType)
        return this

    return synchronized(cache) { cache[this] } ?: when (this) {
        is ParameterizedType -> Generic.type(this.rawType.getType(this, false))
            .of(*this.actualTypeArguments.map { it.getType(this, true) }.filter { !it.`is`(Types.OBJECT) }.toTypedArray())
        is GenericArrayType -> Generic.type(this.genericComponentType.getType(this, false))
        is TypeVariable<*> -> {
            val type = Generic.type(this.name)

            if (isParameterized)
                return type

            type.`extends$`(*this.bounds.map { it.getType(this, false) }.filter { !it.`is`(Types.OBJECT) }.toTypedArray())

        }
        is WildcardType -> {
            var generic = Generic.wildcard()

            fun buildIfRecursive(it: Type): Generic? {
                if (previous != null && it is TypeVariable<*> && it.bounds.any { it === previous }) {
                    val nBounds = it.bounds.map { type ->
                        if (type === previous) {
                            // TODO: Support recursive types, such as K extends Comparable<? super K>
                            //  Currently this is not possible because Generic instance is only available when all
                            //  bounds are already built, so there is no way to K inside Comparable<? super K>
                            //  reference the K extends Comparable<? super K>, which will not be constructed
                            //  until the K inside is resolved.
                            //  this is not easy to resolve, as allowing cyclic generics may impose other problems
                            //  with already existing systems in Kores, such as Generic Inference, Generic Translation
                            //  and identity equality check.
                            //  but a way to resolve that is to replace the K inside Comparable<? super K> with the
                            //  K extends Comparable<? super K> after the Generic instance is created, as a post-processing
                            //  task, however, Generic is immutable, so we will need a Builder for the Generic, which
                            //  would allow self-reference to occur, as we will have the Builder before the type is built,
                            //  then we just glue them all.
                            Generic.type(it.name)
                        } else {
                            type.getType(this, false)
                        }
                    }.filter { !it.`is`(Types.OBJECT) }.toTypedArray()
                    val type = Generic.type(it.name)

                    return type.`extends$`(*nBounds)
                } else {
                    return null;
                }
            }

            this.lowerBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = buildIfRecursive(it) ?: generic.`super$`(it.getType(this, false))
            }

            this.upperBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = buildIfRecursive(it) ?: generic.`extends$`(it.getType(this, false))
            }

            generic
        }
        is Class<*> -> this.koresType.let {
            it
        }
        else -> throw IllegalArgumentException("Cannot convert '$this' to KoresType.")
    }.let {
        synchronized(cache) { cache[this] = it }
        it
    }
}


fun KoresType.getType(name: String): KoresType? {
    if (this is GenericType)
        return this.getType(name)
    return null
}

fun KoresType.getType(name: String, inside: KoresType): KoresType? {
    if (this is GenericType)
        return this.getType(name, inside)
    return null
}

fun KoresType.applyType(typeName: String, type: KoresType): KoresType {
    if (this is GenericType)
        return this.applyType(typeName, type)
    else
        return this
}

fun GenericType.getType(name: String): KoresType? {
    if (!this.isType && !this.isWildcard && this.name == name)
        return this.resolvedType
    else
        return this.resolvedType.getType(name)
                ?: this.bounds.firstOrNull { it.type.getType(name) != null }?.type
}

fun GenericType.getType(name: String, inside: KoresType): KoresType? {
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

fun GenericType.applyType(typeName: String, type: KoresType): GenericType {
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
 * Cache [KoresType] instance of [Class]
 */
private val loadedCache = WeakValueHashMap<Class<*>, KoresType>()

/**
 * Gets the cached [LoadedKoresType] for [aClass] or create a instance of [LoadedKoresType]
 * if no one is cached.
 */
@Suppress("UNCHECKED_CAST")
private fun <T> getJavaType(aClass: Class<T>): LoadedKoresType<T> {

    if (aClass.isArray)
        return getJavaType0(aClass)

    if (loadedCache.containsKey(aClass)) {
        val koresType = loadedCache[aClass]

        if (koresType != null && koresType is LoadedKoresType<*>)
            return koresType as LoadedKoresType<T>
    }

    val javaType = JavaType(aClass)

    loadedCache[aClass] = javaType

    return javaType

}

/**
 * Gets the cached [LoadedKoresType] for [aClass] or create a instance of [LoadedKoresType]
 * if no one is cached. (treat arrays).
 */
@Suppress("UNCHECKED_CAST")
private fun <T> getJavaType0(aClass: Class<T>): LoadedKoresType<T> {

    if (loadedCache.containsKey(aClass)) {
        val koresType = loadedCache[aClass]

        if (koresType != null && koresType is LoadedKoresType<*>)
            return koresType as LoadedKoresType<T>
    }

    var type: LoadedKoresType<T> = JavaType(aClass)

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