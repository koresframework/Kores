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
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.common.CodeNothing
import com.github.jonathanxd.codeapi.type.CodeTypeResolver.DefaultResolver.resolve
import com.github.jonathanxd.codeapi.type.CodeTypeResolver.Multi
import com.github.jonathanxd.codeapi.util.*
import java.lang.reflect.Type
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.lang.model.util.Elements

/**
 * Type resolver. Type resolvers should never throws an error when it is unable to resolve
 * result of an operation. The operation should return `null` - in the cases which `null` is allowed -
 * return [CodeNothing], empty [List] or `false` when the resolver is unable to resolve the result of
 * operation. These semantics are required to [Multi] work correctly with any resolver.
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
                return concreteType.typeElement.superclass?.let {
                    if (it.kind != TypeKind.NONE) it.getCodeType(concreteType.elements)
                    else null
                }

            if (concreteType is SuperClassHolder)
                return concreteType.superClass.codeType

            if (concreteType is InheritanceProvider)
                return concreteType.superclass

            return null
        }

        override fun getInterfaces(type: Type): List<Type> {
            val concreteType = type.concreteType

            if (concreteType is LoadedCodeType<*>)
                return concreteType.loadedType.interfaces?.map { it.codeType }.orEmpty()

            if (concreteType is TypeElementCodeType)
                return concreteType.typeElement.interfaces?.filter { it.kind != TypeKind.NONE }
                        ?.map { it.getCodeType(concreteType.elements) }.orEmpty()

            if (concreteType is ImplementationHolder)
                return concreteType.implementations.map { it.codeType }.toList()

            if (concreteType is InheritanceProvider)
                return concreteType.superinterfaces.toList()

            return emptyList()
        }

        override fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): Boolean {
            // Should I do something like TypeInfo#isAssignableFrom for GenericTypes?
            val concreteCodeType = type.concreteType
            val concreteFrom = from.concreteType

            if (concreteCodeType.`is`(from))
                return true

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
     * Resolver that resolves [CodeType] to Java [Class]. This may resolve to [CodeNothing.type]
     * is class loader fails to find class.
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
                else -> try {
                    classLoader.loadClass(type.binaryName)
                } catch (t: ClassNotFoundException) {
                    CodeNothing::class.java
                }
            }
        }

    }

    /**
     * Resolver that resolves [CodeType] to Javax Model [TypeElement], or to `null`
     * if type cannot be found.
     */
    class Model(val elements: Elements) : CommonResolver<TypeElement?>() {
        override fun resolve(type: Type): TypeElement? =
                (type.concreteType as? TypeElementCodeType)?.typeElement
                        ?: elements.getTypeElement(type.canonicalName)
    }

    /**
     * Default resolver that returns the same instance for [resolve] method.
     */
    object DefaultResolver : CommonResolver<Type>() {
        override fun resolve(type: Type): Type = type
    }

    /**
     * CodeAPI Resolver.
     */
    class CodeAPI(val resolverFunc: CodeTypeResolverFunc? = null) : CommonResolver<TypeDeclaration?>() {

        override fun resolve(type: Type): TypeDeclaration? =
                (type.concreteType as? TypeDeclaration) ?:
                        (resolverFunc?.apply(type.canonicalName) as? TypeDeclaration)

    }

    /**
     * This is a resolver which support multiple resolvers. This resolver
     * always returns first **valid resolved value** for each operation.
     *
     * A valid resolved value depends on operations, see documentation.
     */
    class Multi<T> : CodeTypeResolver<T?> {

        private val resolvers = mutableListOf<CodeTypeResolver<T?>>()

        /**
         * Adds a resolver
         */
        fun addResolver(resolver: CodeTypeResolver<T?>) {
            this.resolvers += resolver
        }

        /**
         * Removes a resolver
         */
        fun removeResolver(resolver: CodeTypeResolver<T?>) {
            this.resolvers -= resolver
        }

        /**
         * Adds a resolver
         */
        operator fun plusAssign(resolver: CodeTypeResolver<T?>) {
            this.resolvers += resolver
        }

        /**
         * Removes a resolver
         */
        operator fun minusAssign(resolver: CodeTypeResolver<T?>) {
            this.resolvers -= resolver
        }

        /**
         * First non-null and [non-nothing][CodeNothing] value is returned, or `null` if no
         * valid value was found.
         */
        @Suppress("UNCHECKED_CAST")
        override fun resolve(type: Type): T? =
                resolvers.map { it.resolve(type) }.firstOrNull {
                    it != null
                            && it != CodeNothing
                            && (it is Type && !it.`is`(CodeNothing.type))
                }

        /**
         * First non-null and [non-nothing][CodeNothing] value is returned, or `null` if no
         * valid value was found.
         */
        override fun getSuperclass(type: Type): Type? =
                resolvers.map { it.getSuperclass(type) }.firstOrNull { it != null && !it.`is`(CodeNothing.type) }

        /**
         * First bigger list is returned.
         */
        override fun getInterfaces(type: Type): List<Type> =
                resolvers.map { it.getInterfaces(type) }.sortedByDescending { it.size }.firstOrNull() ?: emptyList()

        /**
         * Returns true if any resolver returns true for this operation.
         */
        override fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): Boolean =
                resolvers.any { it.isAssignableFrom(type, from, resolverProvider) }


    }
}