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
@file:JvmName("CodeTypes")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.Generic
import com.github.jonathanxd.codeapi.type.GenericType
import java.lang.reflect.*
import kotlin.reflect.KClass

val <T> Class<T>.codeType: CodeType
    get() = CodeAPI.getJavaType(this)

val <T : Any> KClass<T>.codeType: CodeType
    get() = this.java.codeType

val CodeType.descName: String
    get() = "L${this.canonicalName};"

val Type.codeType: CodeType
    get() = when (this) {
        is ParameterizedType -> Generic.type(this.rawType.codeType).of(*this.actualTypeArguments.map(Type::codeType).filter { !it.`is`(Types.OBJECT) }.toTypedArray())
        is GenericArrayType -> Generic.type(this.genericComponentType.codeType)
        is TypeVariable<*> -> Generic.type(this.name).of(*this.bounds.map(Type::codeType).filter { !it.`is`(Types.OBJECT) }.toTypedArray())
        is WildcardType -> {
            var generic = Generic.wildcard()

            this.lowerBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = generic.`super$`(it.codeType)
            }

            this.upperBounds.forEach {
                if (it is Class<*> && it == Any::class.java)
                    return@forEach

                generic = generic.`extends$`(it.codeType)
            }

            generic
        }
        is Class<*> -> this.codeType
        else -> throw IllegalArgumentException("Cannot convert '$this' to CodeType.")
    }

fun CodeType.getType(name: String): CodeType? {
    if(this is GenericType)
        return this.getType(name)
    return null
}

fun CodeType.getType(name: String, inside: CodeType): CodeType? {
    if(this is GenericType)
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
    if(!this.isType && !this.isWildcard && this.name == name)
        return this.codeType
    else
        return this.codeType.getType(name) ?: this.bounds.firstOrNull { it.type.getType(name) != null }?.type
}

fun GenericType.getType(name: String, inside: CodeType): CodeType? {
    val type = (inside as? GenericType)?.codeType ?: inside

    if(!this.isType && !this.isWildcard && this.name == name)
        return type
    else if(inside is GenericType) {
        this.codeType.getType(name, inside.codeType)?.let {
            return it
        }

        this.bounds.forEachIndexed { index, bound ->
            if (inside.bounds.size == this.bounds.size)
                return bound.type.getType(name, inside.bounds[index].type)
        }
    }

    return null
}

fun GenericType.applyType(typeName: String, type: CodeType): GenericType {
    val bounds = this.bounds.map {
        when (it) {
            is GenericType.GenericBound -> GenericType.GenericBound(it.type.applyType(typeName, type))
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

        if(this.isType) {
            return Generic.type(this.codeType.applyType(typeName, type)).of(*bounds)
        }
    }

    throw IllegalArgumentException("Illegal generic receiver '$this'")
}