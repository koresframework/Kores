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
import com.github.jonathanxd.codeapi.util.TypeElementCodeType
import com.github.jonathanxd.codeapi.util.codeType
import com.github.jonathanxd.codeapi.util.concreteType
import com.github.jonathanxd.codeapi.util.getCodeType
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

/**
 * Type resolver
 */
interface CodeTypeResolver<out T> {

    /**
     * Resolver [codeType] to [T]
     */
    fun resolve(codeType: CodeType): T

    /**
     * Gets super classes of [codeType]
     */
    fun getSuperclass(codeType: CodeType): CodeType?

    /**
     * Gets super interfaces of [codeType].
     */
    fun getInterfaces(codeType: CodeType): List<CodeType>

    /**
     * Checks if [codeType] is assignable from [from] using default resolvers.
     *
     * @return True if [codeType] is assignable from [from].
     */
    fun isAssignableFrom(codeType: CodeType, from: CodeType): Boolean =
            this.isAssignableFrom(codeType, from, CodeType::defaultResolver)

    /**
     * Checks if [codeType] is assignable [from] using resolvers provided by [resolverProvider]
     *
     * @return True if [codeType] is assignable from [from].
     */
    fun isAssignableFrom(codeType: CodeType, from: CodeType, resolverProvider: (CodeType) -> CodeTypeResolver<*>): Boolean

    /**
     * Common implementation of resolver.
     */
    abstract class CommonResolver<out T> : CodeTypeResolver<T> {

        override fun getSuperclass(codeType: CodeType): CodeType? {

            val concreteType = codeType.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType.superclass?.codeType

            if (concreteType is TypeElementCodeType)
                return concreteType.typeElement.superclass?.getCodeType(concreteType.elements)

            if (concreteType is SuperClassHolder)
                return concreteType.superClass

            if (concreteType is InheritanceProvider)
                return concreteType.superclass

            throw IllegalArgumentException("Cannot resolve super class of '$codeType'")
        }

        override fun getInterfaces(codeType: CodeType): List<CodeType> {
            val concreteType = codeType.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType.interfaces?.map { it.codeType }.orEmpty()

            if (concreteType is TypeElementCodeType)
                return concreteType.typeElement.interfaces?.map { it.getCodeType(concreteType.elements) }.orEmpty()

            if (concreteType is ImplementationHolder)
                return concreteType.implementations.toList()

            if (concreteType is InheritanceProvider)
                return concreteType.superinterfaces.toList()

            throw IllegalArgumentException("Cannot resolve interfaces of '$codeType'")
        }

        override fun isAssignableFrom(codeType: CodeType, from: CodeType, resolverProvider: (CodeType) -> CodeTypeResolver<*>): Boolean {
            // Should I do something like TypeInfo#isAssignableFrom for GenericTypes?
            val concreteCodeType = codeType.concreteType
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
        override fun resolve(codeType: CodeType): Class<*> {
            val concreteType = codeType.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType

            return when (codeType.javaSpecName) {
                "V" -> Void.TYPE
                "Z" -> Boolean::class.javaPrimitiveType!!
                "C" -> Char::class.javaPrimitiveType!!
                "B" -> Byte::class.javaPrimitiveType!!
                "S" -> Short::class.javaPrimitiveType!!
                "I" -> Int::class.javaPrimitiveType!!
                "F" -> Float::class.javaPrimitiveType!!
                "D" -> Double::class.javaPrimitiveType!!
                "J" -> Long::class.javaPrimitiveType!!
                else -> classLoader.loadClass(codeType.binaryName)
            }
        }

    }

    /**
     * Resolver that resolves [CodeType] to Javax Model [TypeElement]
     */
    class Model(val elements: Elements) : CommonResolver<TypeElement>() {
        override fun resolve(codeType: CodeType): TypeElement {
            return elements.getTypeElement(codeType.canonicalName)
        }
    }

    /**
     * Default resolver that returns the same instance for [resolve] method.
     */
    object DefaultResolver : CommonResolver<CodeType>() {
        override fun resolve(codeType: CodeType): CodeType {
            return codeType
        }
    }
}