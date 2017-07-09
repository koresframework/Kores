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
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.base.SuperClassHolder
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.type.*
import com.github.jonathanxd.codeapi.type.CodeTypeResolver
import java.lang.reflect.Type
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

/**
 * See [getInferredType] below.
 */
fun getInferredType(name: String,
                    parameterizedType: GenericType,
                    startingType: GenericType,
                    codeTypeResolver: CodeTypeResolver<*>,
                    genericResolver: GenericResolver): List<CodeType> {

    return mutableListOf<CodeType>().also {
        getInferredType(name, parameterizedType, startingType, codeTypeResolver, genericResolver, it)
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
 * @param codeTypeResolver Resolver of super types. This resolver will be used also to resolve original types.
 * @param genericResolver Resolver which will resolve generic types from [Type].
 * @param found List which types should be added
 */
fun getInferredType(name: String,
                    parameterizedType: GenericType,
                    startingType: GenericType,
                    codeTypeResolver: CodeTypeResolver<*>,
                    genericResolver: GenericResolver,
                    found: MutableList<CodeType>): State {

    val indexOfParam = parameterizedType.bounds.indexOfFirst {
        it.type is GenericType
                && !it.type.isWildcard
                && !it.type.isType
                && it.type.name == name
    }

    if (indexOfParam == -1)
        throw IllegalArgumentException("Cannot find $name in '$parameterizedType'")

    val resolved = genericResolver.resolveTypeWithParameters(startingType, codeTypeResolver)

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

    val plainTypes = mutableListOf<CodeType>()

    codeTypeResolver.getSuperclass(startingType)?.let {
        plainTypes += it.codeType
    }

    codeTypeResolver.getInterfaces(startingType).forEach {
        plainTypes += it.codeType
    }

    val types = mutableListOf<GenericType>()

    plainTypes.forEach {
        val superType = it.let { genericResolver.resolveGenericTypeImplementation(startingType, it, codeTypeResolver) }

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
            val r = getInferredType(name, parameterizedType, parameterSet, codeTypeResolver, genericResolver, found)

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
    fun resolveTypeWithParameters(type: Type, codeTypeResolver: CodeTypeResolver<*>): GenericType

    /**
     * Resolves [GenericType] of [implemented] type, which was implemented in [superType]. This generic type
     * should be the [implemented] belong with type parameters provided by [superType].
     */
    fun resolveGenericTypeImplementation(superType: Type, implemented: Type,
                                         codeTypeResolver: CodeTypeResolver<*>): GenericType
}

/**
 * Infer generic types. This function will use [getInferredType] to replace `TypeVariables` in [type].
 *
 * @param type Type which have unresolved variable types. Example: `List<T>`
 * @param parameterizedType Target class which have the type variables of [type].
 * @param startingType Initial type of class hierarchy (in other words, the type which extends [parameterizedType]
 * explicitly or implicitly).
 * @param codeTypeResolver Type resolver which will get superclass and superinterfaces.
 * @param genericResolver Resolver which will resolve generic types from [Type].
 * @param filter Filter which determines type variables to be inferred. (True to infer, false to ignore).
 */
@JvmOverloads
fun inferType(type: Type,
              parameterizedType: GenericType,
              startingType: GenericType,
              codeTypeResolver: CodeTypeResolver<*>,
              genericResolver: GenericResolver,
              filter: (String) -> Boolean = {true}): CodeType {

    val startingBounds = startingType.bounds
    val cType = type.codeType

    if (cType is GenericType) {
        if (!cType.isType && !cType.isWildcard) {
            val name = cType.name

            if (filter(name) && startingBounds.none { it.type is GenericType && it.type.name == name }) {

                getInferredType(name, parameterizedType, startingType, codeTypeResolver, genericResolver)
                        .firstOrNull()?.let { return it }
            }
        }

        val inferType = if (cType.isType) Generic.type(cType.resolvedType)
        else if (cType.isWildcard) Generic.wildcard()
        else Generic.type(cType.name)

        return inferType.of(*inferBoundsType(cType.bounds, parameterizedType, startingType, codeTypeResolver, genericResolver))
    }

    return cType
}

/**
 * Calls [inferType] against [bounds] types.
 */
fun inferBoundsType(bounds: Array<out GenericType.Bound>,
                    parameterizedType: GenericType,
                    startingType: GenericType,
                    codeTypeResolver: CodeTypeResolver<*>,
                    genericResolver: GenericResolver,
                    filter: (String) -> Boolean = {true}): Array<GenericType.Bound> {
    return bounds.map {
        val erase = inferType(it.type, parameterizedType, startingType, codeTypeResolver, genericResolver, filter)
        if (it is GenericType.Extends) GenericType.Extends(erase)
        else if (it is GenericType.Super) GenericType.Super(erase)
        else/* if(it is GenericType.GenericBound)*/ GenericType.GenericBound(erase)
    }.toTypedArray()
}

/**
 * Erase types which can not be found on [signature].
 */
fun eraseType(type: Type, signature: GenericSignature): CodeType {
    val cType = type.codeType

    if (cType is GenericType) {
        if (!cType.isType && !cType.isWildcard) {
            val name = cType.name

            if (signature.types.none { it.name == name })
                return cType.resolvedType // Do not confuse with extension, this is GenericType.codeType
        }

        val inferType = if (cType.isType) Generic.type(cType.resolvedType)
        else if (cType.isWildcard) Generic.wildcard()
        else Generic.type(cType.name)

        return inferType.of(*eraseBounds(cType.bounds, signature))
    }

    return cType
}

/**
 * Calls [eraseType] agains [bounds] type.
 */
fun eraseBounds(bounds: Array<out GenericType.Bound>, signature: GenericSignature): Array<GenericType.Bound> {
    return bounds.map {
        val erase = eraseType(it.type, signature)
        if (it is GenericType.Extends) GenericType.Extends(erase)
        else if (it is GenericType.Super) GenericType.Super(erase)
        else/* if(it is GenericType.GenericBound)*/ GenericType.GenericBound(erase)
    }.toTypedArray()
}

class JavaResolver : GenericResolver {

    override fun resolveTypeWithParameters(type: Type, codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val resolved = type.codeType

        val resolve: Any? = codeTypeResolver.resolve(resolved.concreteType)?.let {
            (it as? LoadedCodeType<*>)?.loadedType ?: it
        }

        if (resolve is Class<*>) {
            return resolve.getGenericType()
        }

        throw IllegalStateException("$type must be a Java Reflect Type.")
    }

    override fun resolveGenericTypeImplementation(superType: Type, implemented: Type,
                                                  codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val superCodeType = superType.codeType
        val implementedCodeType = implemented.codeType

        val resolvedSuperType: Any? = codeTypeResolver.resolve(superCodeType.concreteType)?.let {
            (it as? LoadedCodeType<*>)?.loadedType ?: it
        }

        if (resolvedSuperType is Class<*>) {
            val superClass = resolvedSuperType

            if (superClass.superclass.`is`(implemented.concreteType)) {
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

class CodeAPIResolver : GenericResolver {

    override fun resolveTypeWithParameters(type: Type, codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val resolved = type.codeType

        val resolve: Any? = codeTypeResolver.resolve(resolved.concreteType)

        if (resolve is TypeDeclaration) {
            return Generic.type(resolve).of(*resolve.genericSignature.types)
        }

        throw IllegalStateException("$type must be a CodeAPI TypeDeclaration.")
    }

    override fun resolveGenericTypeImplementation(superType: Type, implemented: Type,
                                                  codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val superCodeType = superType.codeType

        val resolvedSuperType: Any? = codeTypeResolver.resolve(superCodeType.concreteType)

        if (resolvedSuperType is TypeDeclaration) {
            val superClass = resolvedSuperType

            if (superClass is SuperClassHolder && superClass.`is`(implemented.concreteType)) {
                return superClass.superClass.asGeneric
            }

            val itfs = superClass.interfaces

            for (i in itfs.indices) {
                if (itfs[i].`is`(implemented.concreteType))
                    return superClass.interfaces[i].asGeneric
            }

            throw IllegalStateException("Can't find '$implemented' in superclasses of '$superClass'.")
        }


        throw IllegalStateException("both supertype '$superType' must be a CodeAPI TypeDeclaration.")
    }
}

/**
 * Mixes [JavaResolver] with [ModelResolver] and [CodeAPIResolver] in one resolver.
 */
class MixedResolver(val elements: Elements?) : GenericResolver {
    private val javaResolver = JavaResolver()
    private val modelResolver = elements?.let { ModelResolver(it) }
    private val codeapiResolver = CodeAPIResolver()

    override fun resolveTypeWithParameters(type: Type, codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val resolved = type.codeType

        val resolve: Any? = codeTypeResolver.resolve(resolved.concreteType)

        if (resolve is LoadedCodeType<*> || resolve is Class<*>) {
            return javaResolver.resolveTypeWithParameters(type, codeTypeResolver)
        }

        if (resolve is TypeDeclaration) {
            return codeapiResolver.resolveTypeWithParameters(type, codeTypeResolver)
        }

        if (resolve is TypeElement) {
            return modelResolver?.resolveTypeWithParameters(type, codeTypeResolver)
            ?: throw IllegalArgumentException("No elements provided for Javax Model Resolution of '$resolve'")
        }

        throw IllegalArgumentException("Can't resolve $type with type resolver '$codeTypeResolver'")
    }

    override fun resolveGenericTypeImplementation(superType: Type, implemented: Type, codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val rSuperType = superType.codeType

        val resolve: Any? = codeTypeResolver.resolve(rSuperType.concreteType)

        if (resolve is LoadedCodeType<*> || resolve is Class<*>) {
            return javaResolver.resolveGenericTypeImplementation(rSuperType, implemented, codeTypeResolver)
        }

        if (resolve is TypeDeclaration) {
            return codeapiResolver.resolveGenericTypeImplementation(rSuperType, implemented, codeTypeResolver)
        }

        if (resolve is TypeElement) {
            return modelResolver?.resolveGenericTypeImplementation(rSuperType, implemented, codeTypeResolver)
                    ?: throw IllegalArgumentException("No elements provided for Javax Model Resolution of '$resolve'")
        }


        throw IllegalArgumentException("Can't resolve generic implementation of $implemented in $rSuperType with type resolver '$codeTypeResolver'")
    }

}