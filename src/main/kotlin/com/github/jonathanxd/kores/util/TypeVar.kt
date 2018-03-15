/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
@file:JvmName("TypeVarUtil")

package com.github.jonathanxd.kores.util

import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.TypeDeclaration
import com.github.jonathanxd.kores.generic.GenericSignature
import com.github.jonathanxd.kores.type.*
import java.lang.reflect.GenericDeclaration
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable
import java.util.*
import javax.lang.model.element.Parameterizable

/**
 * Returns the [GenericType] of [Class] with its parameters.
 */
val Class<*>.typeWithParams: GenericType
    get() = Generic.type(this).of(*this.typeParameters.map { it.koresType }.toTypedArray())

/**
 * Creates a [GenericSignature] from a [GenericDeclaration]
 */
val GenericDeclaration.genericSignature: GenericSignature
    get() = GenericSignature.create(*this.typeParameters.map { it.koresType.asGeneric }.toTypedArray())

/**
 * Resolves the [KoresType] of [variable] of [typeVariables] using types provided by [generic].
 */
fun getType(
    typeVariables: Array<out TypeVariable<*>>,
    variable: TypeVariable<*>,
    generic: GenericType
): KoresType? =
    getType(typeVariables, variable.name, generic)

/**
 * Resolves the [KoresType] of variable with name [variable] of [typeVariables] using types provided by [generic].
 *
 * @param typeVariables Class Type variables
 * @param variable Variable name to find type
 * @param generic Generic type with types of [typeVariables]
 */
fun getType(
    typeVariables: Array<out TypeVariable<*>>,
    variable: String,
    generic: GenericType
): KoresType? =
    (0 until generic.bounds.size)
        .takeWhile { it < typeVariables.size }
        .firstOrNull { variable == typeVariables[it].name }
        ?.let { generic.bounds[it].type }

/**
 * Returns true if [typeVariables] contains a variable with same name as [typeVariable]
 */
fun isConflict(typeVariables: Array<out TypeVariable<*>>, typeVariable: TypeVariable<*>): Boolean =
    typeVariables.any { it.name == typeVariable.name }

/**
 * Creates a list of conflicting type variables name.
 */
fun getTypeVarConflicts(
    typeVariables: Array<out TypeVariable<*>>,
    otherTypeVariables: Array<out TypeVariable<*>>
): List<String> {

    val conflicts = ArrayList<String>()

    for (typeVariable in typeVariables) {
        otherTypeVariables
            .filter { typeVariable.name == it.name }
            .forEach { conflicts.add(typeVariable.name) }
    }

    return conflicts
}

/**
 * Gets array of [TypeVariable] from [codeType].
 */
@Suppress("UNCHECKED_CAST")
fun getTypeVariables(codeType: KoresType): Array<TypeVariable<*>> {
    if (codeType is LoadedKoresType<*>) {
        return codeType.loadedType.typeParameters as Array<TypeVariable<*>>
    } else if (codeType is GenericType && codeType.isType) {
        return codeType.bounds.map { toTypeVar(it.type as GenericType) }.toTypedArray()
    } else if (codeType is TypeDeclaration) {
        return toTypeVars(codeType.genericSignature)
    } else {
        return emptyArray()
    }
}

/**
 * Gets list of [TypeVariable] of [declaration].
 */
fun getTypeVars(declaration: TypeDeclaration): Array<TypeVariable<*>> {
    return declaration.genericSignature.types.map { toTypeVar(it) }.toTypedArray()
}

/**
 * Fill type variables of [theClass] using types provided by [generic]
 */
@Suppress("UNCHECKED_CAST")
fun fillTypeVars(theClass: Class<*>, generic: GenericType): Array<out TypeVariable<*>> {
    if (generic.isType && generic.resolvedType.`is`(theClass.koresType)) {
        return fillTypeVars(theClass.typeParameters as Array<TypeVariable<*>>, generic)
    }

    return emptyArray()
}

/**
 * Fill [typeParameters] using types provided by [generic].
 */
fun fillTypeVars(
    typeParameters: Array<out TypeVariable<*>>,
    generic: GenericType
): Array<TypeVariable<*>> {
    val filledTypeVars = mutableListOf<TypeVariable<*>>()

    val bounds = generic.bounds

    for (i in bounds.indices) {
        if (i >= typeParameters.size)
            break

        val typeParameter = typeParameters[i]
        val bound = bounds[i]

        if (bound is GenericType.GenericBound) {
            val typeVar = toTypeVar(bound, typeParameter)
            filledTypeVars.add(typeVar)
        }
    }

    return filledTypeVars.toTypedArray()
}

/**
 * Finds the [TypeVariable] that has name [name] and return the [KoresType] of found [TypeVariable].
 */
fun findType(typeVariables: Array<out TypeVariable<*>>?, name: String): KoresType? {
    if (typeVariables == null)
        return null

    return typeVariables
        .filter { it.name == name && it.bounds.isNotEmpty() }
        .map { com.github.jonathanxd.iutils.type.TypeUtil.from(it.bounds[0]) }
        .firstOrNull { it != null }
        ?.koresType
}

/**
 * Finds the [GenericType] that has name [name] and return the [KoresType] of found [GenericType].
 */
fun findType(signature: GenericSignature?, name: String): KoresType? {
    if (signature == null)
        return null

    val types = signature.types

    return types
        .firstOrNull { !it.isType && it.name == name }
        ?.resolvedType
}

/**
 * Creates an array of [TypeVariable] from a [generic signature][signature].
 */
fun toTypeVars(signature: GenericSignature?): Array<TypeVariable<*>> =
    signature?.types?.map { toTypeVar(it) }?.toTypedArray() ?: emptyArray()


/**
 * Creates a [TypeVariable] from a [generic type][generic].
 */
fun toTypeVar(generic: GenericType): TypeVariable<*> {
    if (generic.isType || generic.bounds.isEmpty())
        return GenericTypeVariable(
            generic.resolvedType,
            null,
            generic.name,
            arrayOf(
                if (generic.isType) GenericJavaType(generic.resolvedType) else GenericTypeVariable(
                    generic.resolvedType,
                    null,
                    generic.name,
                    emptyArray()
                )
            )
        )

    val typeList = mutableListOf<Type>()

    val bounds = generic.bounds

    bounds.map { it.type }
        .forEach {
            if (it is GenericType) {
                typeList.add(toTypeVar(it))
            } else {
                typeList.add(GenericJavaType(it))
            }
        }

    return GenericTypeVariable(generic.resolvedType, null, generic.name, typeList.toTypedArray())
}

/**
 * Creates a [TypeVariable] from a [generic bound][bound] and [variable].
 */
private fun toTypeVar(bound: GenericType.Bound, variable: TypeVariable<*>): TypeVariable<*> {

    if (bound.type is Generic) {
        val generic = bound.type

        if (generic.isType || generic.bounds.isEmpty())
            return GenericTypeVariable(
                generic.resolvedType,
                variable,
                arrayOf(
                    if (generic.isType) GenericJavaType(generic.resolvedType) else GenericTypeVariable(
                        generic.resolvedType,
                        null,
                        generic.name,
                        emptyArray()
                    )
                )
            )

        val typeList = ArrayList<Type>()

        val typeVarBounds = variable.bounds
        val bounds = generic.bounds

        for (i in bounds.indices) {
            if (i >= typeVarBounds.size)
                break

            val typeVarBound = typeVarBounds[i]

            val typeBound = bounds[i]

            if (typeVarBound is TypeVariable<*>) {
                typeList.add(toTypeVar(typeBound, typeVarBound))
            } else {
                typeList.add(
                    toTypeVar(
                        typeBound,
                        GenericTypeVariable(typeBound.type, typeVarBound, emptyArray())
                    )
                )
            }
        }

        return GenericTypeVariable(
            generic.resolvedType,
            variable,
            generic.type,
            typeList.toTypedArray()
        )
    } else {
        return GenericTypeVariable(bound.type, variable, arrayOf(GenericJavaType(bound.type)))
    }
}

/**
 * Infers a type for receiver type variable.
 */
fun Type.inferType(
    variables: Array<out TypeVariable<*>>,
    classVariables: Array<out TypeVariable<*>>,
    genericType: GenericType
): KoresType {
    this.koresType.let {
        if (it !is GenericType || it.isType) {

            return if (it is GenericType) {
                it.resolvedType
            } else {
                it
            }
        } else {
            val variable =
                when (this) {
                    is TypeVariable<*> -> this
                    is GenericType -> toTypeVar(this)
                    else -> {
                        toTypeVar(
                            (it as? GenericType)
                                    ?: throw IllegalArgumentException("Invalid receiver type. A generic type is required")
                        )
                    }
                }

            return if (!isConflict(variables, variable)) {
                getType(classVariables, variable, genericType)
                        ?: throw IllegalStateException("Cannot infer type")
            } else {
                com.github.jonathanxd.iutils.type.TypeUtil.from(variable)?.koresType
                        ?: Types.OBJECT
            }

        }
    }
}

private class GenericJavaType internal constructor(private val type: KoresType) : Type {

    override fun getTypeName(): String {
        return this.type.canonicalName
    }

    companion object {

        fun fromBound(bound: GenericType.Bound): GenericJavaType {
            val type: KoresType
            if (bound.sign == "*") {
                type = Types.OBJECT
            } else {
                type = bound.type
            }

            return GenericJavaType(type)
        }
    }
}
