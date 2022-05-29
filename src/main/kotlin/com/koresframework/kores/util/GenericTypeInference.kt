/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.util

import com.koresframework.kores.base.SuperClassHolder
import com.koresframework.kores.base.TypeDeclaration
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.type.*
import com.github.jonathanxd.iutils.kt.rightOrFail
import java.lang.reflect.Type
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

/**
 * See [getInferredType] below.
 */
fun getInferredType(
    name: String,
    parameterizedType: GenericType,
    startingType: GenericType,
    koresTypeResolver: KoresTypeResolver<*>,
    genericResolver: GenericResolver
): List<KoresType> {

    return mutableListOf<KoresType>().also {
        getInferredType(
            name,
            parameterizedType,
            startingType,
            koresTypeResolver,
            genericResolver,
            it
        )
    }
}

/**
 * This function tries to find [name] in all possible types which inherits [parameterizedType],
 * this function uses a defined [genericResolver] to resolve the [GenericType] representation of a [Type].
 *
 * @param name Type variable name.
 * @param parameterizedType Target class which have the type variable [name].
 * @param startingType Initial type of class hierarchy (in other words, the type which extends [parameterizedType]
 * explicitly or implicitly).
 * @param koresTypeResolver Resolver of super types. This resolver will be used also to resolve original types.
 * @param genericResolver Resolver which will resolve generic types from [Type].
 * @param found List which types should be added
 */
fun getInferredType(
    name: String,
    parameterizedType: GenericType,
    startingType: GenericType,
    koresTypeResolver: KoresTypeResolver<*>,
    genericResolver: GenericResolver,
    found: MutableList<KoresType>
): State {

    val indexOfParam = parameterizedType.bounds.indexOfFirst {
        it.type is GenericType
                && !it.type.isWildcard
                && !it.type.isType
                && it.type.name == name
    }

    if (indexOfParam == -1)
        throw IllegalArgumentException("Cannot find $name in '$parameterizedType'")

    val resolved = genericResolver.resolveTypeWithParameters(startingType, koresTypeResolver)

    val index = resolved.bounds.indexOfFirst { it.type is GenericType && it.type.name == name }

    if (parameterizedType.concreteType.`is`(startingType.concreteType) && index != -1) {

        if (startingType.bounds.size < indexOfParam)
            throw IllegalStateException("Can't find '$indexOfParam' in implemented '$startingType'. This is a bug!")

        val first = startingType.bounds[index]

        if (first.type is GenericType) {
            if (first.type.isType) {
                found += first.type
                return State.FOUND
            }

            if (first.type.isWildcard) {
                found += Generic.wildcard()
                return State.FOUND
            }

            found += Generic.type(first.type)
            return State.FOUND
        }

        found += first.type
        return State.FOUND
    }

    val plainTypes = mutableListOf<KoresType>()

    koresTypeResolver.getSuperclass(startingType).rightOrNull()?.let {
        plainTypes += it.koresType
    }

    koresTypeResolver.getInterfaces(startingType).rightOrNull().forEach {
        plainTypes += it.koresType
    }

    val types = mutableListOf<GenericType>()

    plainTypes.forEach {
        val superType = it.let {
            genericResolver.resolveGenericTypeImplementation(
                startingType,
                it,
                koresTypeResolver
            )
        }

        types += superType
    }

    types.forEach { parameterSet ->

        if (parameterSet.concreteType.`is`(parameterizedType.concreteType)) {
            if (parameterSet.bounds.size < indexOfParam)
                throw IllegalStateException("Can't find '$indexOfParam' in implemented '$parameterSet'. This is a bug!")

            val bound = parameterSet.bounds[indexOfParam]

            if (bound.type !is GenericType || bound.type.isType && !bound.type.isWildcard) {
                found += bound.type
            } else {
                return State.REQUIRE_SUPER
            }
        } else {
            val r = getInferredType(
                name,
                parameterizedType,
                parameterSet,
                KoresTypeResolver.Two(parameterSet.defaultResolver, koresTypeResolver),
                genericResolver,
                found
            )

            if (r == State.REQUIRE_SUPER) {
                if (parameterSet.bounds.size < indexOfParam)
                    throw IllegalStateException("Can't find '$indexOfParam' in implemented '$parameterSet'. This is a bug!")

                val bound = parameterSet.bounds[indexOfParam]

                if (bound.type !is GenericType || bound.type.isType && !bound.type.isWildcard) {
                    found += bound.type
                } else {
                    return State.REQUIRE_SUPER
                }
            }
        }

    }

    return State.NONE
}

enum class State {
    /**
     * No one matching type was found
     */
    NONE,

    /**
     * Matching type found
     */
    FOUND,

    /**
     * Matching type uses a type parameter provided by super class.
     */
    REQUIRE_SUPER
}

interface GenericResolver {

    /**
     * Resolves the [GenericType] of [type]. This generic type should be the [type] belong with their type parameters.
     */
    fun resolveTypeWithParameters(type: Type, koresTypeResolver: KoresTypeResolver<*>): GenericType

    /**
     * Resolves [GenericType] of [implemented] type, which was implemented in [superType]. This generic type
     * should be the [implemented] belong with type parameters provided by [superType].
     */
    fun resolveGenericTypeImplementation(
        superType: Type, implemented: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType
}

/**
 * Infer generic types. This function will use [getInferredType] to replace `TypeVariables` in [type].
 *
 * @param type Type which have unresolved variable types. Example: `List<T>`
 * @param parameterizedType Target class which have the type variables of [type].
 * @param startingType Initial type of class hierarchy (in other words, the type which extends [parameterizedType]
 * explicitly or implicitly).
 * @param koresTypeResolver Type resolver which will get superclass and superinterfaces.
 * @param genericResolver Resolver which will resolve generic types from [Type].
 * @param filter Filter which determines type variables to be inferred. (True to infer, false to ignore).
 */
@JvmOverloads
fun inferType(
    type: Type,
    parameterizedType: GenericType,
    startingType: GenericType,
    koresTypeResolver: KoresTypeResolver<*>,
    genericResolver: GenericResolver,
    filter: (String) -> Boolean = { true }
): KoresType {

    val startingBounds = startingType.bounds
    val cType = type.koresType

    if (cType is GenericType) {
        if (!cType.isType && !cType.isWildcard) {
            val name = cType.name

            if (filter(name) && startingBounds.none { it.type is GenericType && it.type.name == name }) {

                getInferredType(
                    name,
                    parameterizedType,
                    startingType,
                    koresTypeResolver,
                    genericResolver
                )
                    .firstOrNull()?.let { return it }
            }
        }

        val inferType = if (cType.isType) Generic.type(cType.resolvedType)
        else if (cType.isWildcard) Generic.wildcard()
        else Generic.type(cType.name)

        return inferType.of(
            *inferBoundsType(
                cType.bounds,
                parameterizedType,
                startingType,
                koresTypeResolver,
                genericResolver
            )
        )
    }

    return cType
}

/**
 * Calls [inferType] against [bounds] types.
 */
fun inferBoundsType(
    bounds: Array<out GenericType.Bound>,
    parameterizedType: GenericType,
    startingType: GenericType,
    koresTypeResolver: KoresTypeResolver<*>,
    genericResolver: GenericResolver,
    filter: (String) -> Boolean = { true }
): Array<GenericType.Bound> {
    return bounds.map {
        val erase = inferType(
            it.type,
            parameterizedType,
            startingType,
            koresTypeResolver,
            genericResolver,
            filter
        )
        if (it is GenericType.Extends) GenericType.Extends(erase)
        else if (it is GenericType.Super) GenericType.Super(erase)
        else/* if(it is GenericType.GenericBound)*/ GenericType.GenericBound(erase)
    }.toTypedArray()
}

/**
 * Erase types which can not be found on [signature].
 */
fun eraseType(type: Type, signature: GenericSignature): KoresType {
    val cType = type.koresType

    if (cType is GenericType) {
        if (!cType.isType && !cType.isWildcard) {
            val name = cType.name

            if (signature.types.none { it.name == name })
                return cType.resolvedType // Do not confuse with Type extension, this is GenericType.resolvedType
        }

        val inferType = when {
            cType.isType -> Generic.type(cType.resolvedType)
            cType.isWildcard -> Generic.wildcard()
            else -> Generic.type(cType.name)
        }

        return inferType.of(*eraseBounds(cType.bounds, signature))
    }

    return cType
}

/**
 * Calls [eraseType] agains [bounds] type.
 */
fun eraseBounds(
    bounds: Array<out GenericType.Bound>,
    signature: GenericSignature
): Array<GenericType.Bound> {
    return bounds.map {
        val erase = eraseType(it.type, signature)
        if (it is GenericType.Extends) GenericType.Extends(erase)
        else if (it is GenericType.Super) GenericType.Super(erase)
        else/* if(it is GenericType.GenericBound)*/ GenericType.GenericBound(erase)
    }.toTypedArray()
}

class JavaResolver : GenericResolver {

    override fun resolveTypeWithParameters(
        type: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val resolved = type.koresType

        val resolve: Any? = koresTypeResolver.resolve(resolved.concreteType).let {
            if (it.isRight)
                it.right
            else resolved.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }?.let {
                (it as? LoadedKoresType<*>)?.loadedType ?: it
            }

        if (resolve is Class<*>) {
            return resolve.getGenericType()
        }

        throw IllegalStateException("$type must be a Java Reflect Type.")
    }

    override fun resolveGenericTypeImplementation(
        superType: Type, implemented: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val superKoresType = superType.koresType

        val resolvedSuperType: Any? = koresTypeResolver.resolve(superKoresType.concreteType).let {
            if (it.isRight)
                it.right
            else superKoresType.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }?.let {
                (it as? LoadedKoresType<*>)?.loadedType ?: it
            }

        if (resolvedSuperType is Class<*>) {
            val superClass = resolvedSuperType

            if (superClass.superclass?.`is`(implemented.concreteType) == true) {
                return superClass.genericSuperclass.asGeneric
            }

            val itfs = superClass.interfaces

            for (i in itfs.indices) {
                if (itfs[i].`is`(implemented.concreteType))
                    return superClass.genericInterfaces[i].asGeneric
            }

            throw IllegalStateException("Can't find '$implemented' in superclasses of '$superClass'.")
        }


        throw IllegalStateException("Supertype '$superType' must be a Java Reflect Type.")
    }

}

class KoresResolver : GenericResolver {

    override fun resolveTypeWithParameters(
        type: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val resolved = type.koresType

        val resolve: Any? = koresTypeResolver.resolve(resolved.concreteType).let {
            if (it.isRight)
                it.right
            else resolved.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }

        if (resolve is TypeDeclaration) {
            return Generic.type(resolve).of(*resolve.genericSignature.types)
        }

        throw IllegalStateException("$type must be a Kores TypeDeclaration.")
    }

    override fun resolveGenericTypeImplementation(
        superType: Type, implemented: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val superKoresType = superType.koresType

        val resolvedSuperType: Any? = koresTypeResolver.resolve(superKoresType.concreteType).let {
            if (it.isRight)
                it.right
            else superKoresType.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }

        if (resolvedSuperType is TypeDeclaration) {
            val superClass = resolvedSuperType

            if (superClass is SuperClassHolder && superClass.superClass.concreteType.`is`(
                        implemented.concreteType
                    )
            ) {
                return superClass.superClass.asGeneric
            }

            val itfs = superClass.interfaces

            for (i in itfs.indices) {
                if (itfs[i].concreteType.`is`(implemented.concreteType))
                    return superClass.interfaces[i].asGeneric
            }

            throw IllegalStateException("Can't find '$implemented' in superclasses of '$superClass'.")
        }


        throw IllegalStateException("both supertype '$superType' must be a Kores TypeDeclaration.")
    }
}

/**
 * Mixes [JavaResolver] with [ModelResolver] and [KoresResolver] in one resolver.
 */
class MixedResolver(val elements: Elements?) : GenericResolver {
    private val javaResolver = JavaResolver()
    private val modelResolver = elements?.let { ModelResolver(it) }
    private val koresResolver = KoresResolver()

    override fun resolveTypeWithParameters(
        type: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val resolved = type.koresType

        val resolve: Any? = koresTypeResolver.resolve(resolved.concreteType).let {
            if (it.isRight)
                it.right
            else resolved.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }

        if (resolve is LoadedKoresType<*> || resolve is Class<*>) {
            return javaResolver.resolveTypeWithParameters(type, koresTypeResolver)
        }

        if (resolve is TypeDeclaration) {
            return koresResolver.resolveTypeWithParameters(type, koresTypeResolver)
        }

        if (resolve is TypeElement) {
            return modelResolver?.resolveTypeWithParameters(type, koresTypeResolver)
                    ?: throw IllegalArgumentException("No elements provided for Javax Model Resolution of '$resolve'")
        }

        throw IllegalArgumentException("Can't resolve $type with type resolver '$koresTypeResolver'")
    }

    override fun resolveGenericTypeImplementation(
        superType: Type,
        implemented: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val rSuperType = superType.koresType

        val resolve: Any? = koresTypeResolver.resolve(rSuperType.concreteType).let {
            if (it.isRight)
                it.right
            else rSuperType.concreteType.bindedDefaultResolver.resolve().rightOrFail
        }

        if (resolve is LoadedKoresType<*> || resolve is Class<*>) {
            return javaResolver.resolveGenericTypeImplementation(
                rSuperType,
                implemented,
                koresTypeResolver
            )
        }

        if (resolve is TypeDeclaration) {
            return koresResolver.resolveGenericTypeImplementation(
                rSuperType,
                implemented,
                koresTypeResolver
            )
        }

        if (resolve is TypeElement) {
            return modelResolver?.resolveGenericTypeImplementation(
                rSuperType,
                implemented,
                koresTypeResolver
            )
                    ?: throw IllegalArgumentException("No elements provided for Javax Model Resolution of '$resolve'")
        }


        throw IllegalArgumentException("Can't resolve generic implementation of $implemented in $rSuperType with type resolver '$koresTypeResolver'")
    }

}