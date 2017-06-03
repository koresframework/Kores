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
package com.github.jonathanxd.codeapi.type

import com.github.jonathanxd.codeapi.base.ImplementationHolder
import com.github.jonathanxd.codeapi.base.SuperClassHolder
import com.github.jonathanxd.codeapi.type.CodeTypeResolver.DefaultResolver.resolve
import com.github.jonathanxd.codeapi.util.*
import java.lang.reflect.Type
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

/**
 * Type resolver
 */
interface CodeTypeResolver<out T> {

    /**
     * Resolves [type] to [T]
     */
    fun resolve(type: Type): T

    /**
     * Resolves super class of [type]
     */
    fun getSuperclass(type: Type): Type?

    /**
     * Resolves super interfaces of [type].
     */
    fun getInterfaces(type: Type): List<Type>

    /**
     * Checks if [type] is assignable from [from] using default resolvers.
     *
     * @return True if [type] is assignable from [from].
     */
    fun isAssignableFrom(type: Type, from: Type): Boolean =
            this.isAssignableFrom(type, from, Type::defaultResolver)

    /**
     * Checks if [type] is assignable [from] using resolvers provided by [resolverProvider]
     *
     * @return True if [type] is assignable from [from].
     */
    fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): Boolean

    /**
     * Common implementation of resolver.
     */
    abstract class CommonResolver<out T> : CodeTypeResolver<T> {

        override fun getSuperclass(type: Type): Type? {

            val concreteType = type.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType.superclass?.codeType

            if (concreteType is TypeElementCodeType)
                return concreteType.typeElement.superclass?.getCodeType(concreteType.elements)

            if (concreteType is SuperClassHolder)
                return concreteType.superClass.codeType

            if (concreteType is InheritanceProvider)
                return concreteType.superclass

            throw IllegalArgumentException("Cannot resolve super class of '$type'")
        }

        override fun getInterfaces(type: Type): List<Type> {
            val concreteType = type.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType.interfaces?.map { it.codeType }.orEmpty()

            if (concreteType is TypeElementCodeType)
                return concreteType.typeElement.interfaces?.map { it.getCodeType(concreteType.elements) }.orEmpty()

            if (concreteType is ImplementationHolder)
                return concreteType.implementations.map { it.codeType }.toList()

            if (concreteType is InheritanceProvider)
                return concreteType.superinterfaces.toList()

            throw IllegalArgumentException("Cannot resolve interfaces of '$type'")
        }

        override fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): Boolean {
            // Should I do something like TypeInfo#isAssignableFrom for GenericTypes?
            val concreteCodeType = type.concreteType
            val concreteFrom = from.concreteType

            if (concreteCodeType is LoadedCodeType<*> && concreteFrom is LoadedCodeType<*>)
                return concreteCodeType.loadedType.isAssignableFrom(concreteFrom.loadedType)

            val superClass = concreteFrom.let { resolverProvider(it).getSuperclass(it) }

            if (superClass != null) {
                if (superClass.`is`(concreteCodeType)
                        || superClass.let { resolverProvider(it).isAssignableFrom(concreteCodeType, it, resolverProvider) })
                    return true
            }

            val superinterfaces = concreteFrom.let { resolverProvider(it).getInterfaces(it) }

            if (superinterfaces.isNotEmpty()) {
                if (superinterfaces.any { it.`is`(concreteCodeType) }
                        || superinterfaces.any { resolverProvider(it).isAssignableFrom(concreteCodeType, it, resolverProvider) })
                    return true
            }

            return false
        }
    }

    /**
     * Resolver that resolves [CodeType] to Java [Class]
     */
    class Java(val classLoader: ClassLoader) : CommonResolver<Class<*>>() {
        override fun resolve(type: Type): Class<*> {
            val concreteType = type.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType

            return when (type.javaSpecName) {
                "V" -> Void.TYPE
                "Z" -> Boolean::class.javaPrimitiveType!!
                "C" -> Char::class.javaPrimitiveType!!
                "B" -> Byte::class.javaPrimitiveType!!
                "S" -> Short::class.javaPrimitiveType!!
                "I" -> Int::class.javaPrimitiveType!!
                "F" -> Float::class.javaPrimitiveType!!
                "D" -> Double::class.javaPrimitiveType!!
                "J" -> Long::class.javaPrimitiveType!!
                else -> classLoader.loadClass(type.binaryName)
            }
        }

    }

    /**
     * Resolver that resolves [CodeType] to Javax Model [TypeElement]
     */
    class Model(val elements: Elements) : CommonResolver<TypeElement>() {
        override fun resolve(type: Type): TypeElement {
            return elements.getTypeElement(type.canonicalName)
        }
    }

    /**
     * Default resolver that returns the same instance for [resolve] method.
     */
    object DefaultResolver : CommonResolver<Type>() {
        override fun resolve(type: Type): Type {
            return type
        }
    }
}