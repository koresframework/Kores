/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.type

import com.github.jonathanxd.iutils.`object`.Either
import com.github.jonathanxd.iutils.`object`.specialized.EitherObjBoolean
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.common.KoresNothing
import com.github.jonathanxd.kores.type.KoresTypeResolver.DefaultResolver.resolve
import com.github.jonathanxd.kores.util.KoresTypeResolverFunc
import com.github.jonathanxd.kores.util.conversion.getTypeDeclaration
import com.github.jonathanxd.kores.util.conversion.toRepresentation
import com.github.jonathanxd.kores.util.conversion.typeDeclaration
import java.lang.reflect.Type
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.lang.model.util.Elements

/**
 * Type resolver. Type resolvers should never throws an error when it is unable to resolve
 * result of an operation. The operation should return an [Either] instance which contains
 * either the exception describing fail of resolution or the result of resolution.
 */
interface KoresTypeResolver<out T> {

    /**
     * Resolves [type] to [T]
     */
    fun resolve(type: Type): Either<Exception, out T>

    /**
     * Resolves super class of [type].
     *
     * Should return null [Type] if there is no super class.
     */
    fun getSuperclass(type: Type): Either<Exception, Type?>

    /**
     * Resolves super interfaces of [type].
     */
    fun getInterfaces(type: Type): Either<Exception, List<Type>>

    /**
     * Checks if [type] is assignable from [from] using default resolvers.
     *
     * @return True if [type] is assignable from [from].
     */
    fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<Exception> =
        this.isAssignableFrom(type, from, Type::defaultResolver)

    /**
     * Checks if [type] is assignable [from] using resolvers provided by [resolverProvider]
     *
     * @return True if [type] is assignable from [from].
     */
    fun isAssignableFrom(
        type: Type,
        from: Type,
        resolverProvider: (Type) -> KoresTypeResolver<*>
    ): EitherObjBoolean<Exception>

    /**
     * Resolves or create [TypeDeclaration] from [type] structure and elements.
     */
    fun resolveTypeDeclaration(type: Type): Either<Exception, TypeDeclaration>

    /**
     * Resolves or create a list of all [FieldDeclaration] present in [type].
     *
     * The default implementation delegates the call to [resolveTypeDeclaration]
     * and extract property value.
     */
    fun resolveFields(type: Type): Either<Exception, List<FieldDeclaration>> =
        this.resolveTypeDeclaration(type).mapRight { it.fields }

    /**
     * Resolves or create a list of all [ConstructorDeclaration] present in [type].
     *
     * The default implementation delegates the call to [resolveTypeDeclaration]
     * and extract property value.
     */
    fun resolveConstructors(type: Type): Either<Exception, List<ConstructorDeclaration>> =
        this.resolveTypeDeclaration(type).flatMapRight {
            (it as? ConstructorsHolder)?.let {
                Either.right<Exception, List<ConstructorDeclaration>>(it.constructors)
            } ?: Either.left<Exception, List<ConstructorDeclaration>>(
                IllegalArgumentException(
                    "Type $type is not a ConstructorHolder"
                )
            )
        }

    /**
     * Resolves or create a list of all [MethodDeclaration] present in [type].
     *
     * The default implementation delegates the call to [resolveTypeDeclaration]
     * and extract property value.
     */
    fun resolveMethods(type: Type): Either<Exception, List<MethodDeclaration>> =
        this.resolveTypeDeclaration(type).mapRight { it.methods }

    /**
     * Common implementation of resolver.
     */
    abstract class CommonResolver<out T> : KoresTypeResolver<T> {

        override fun getSuperclass(type: Type): Either<Exception, Type?> {

            val concreteType = type.concreteType

            if (concreteType is LoadedKoresType<*>)
                return Either.right(concreteType.loadedType.superclass?.koresType)

            if (concreteType is TypeElementKoresType)
                return Either.right(concreteType.typeElement.superclass?.let {
                    if (it.kind != TypeKind.NONE) it.getKoresType(concreteType.elements)
                    else null
                })

            if (concreteType is SuperClassHolder)
                return Either.right(concreteType.superClass.koresType)

            if (concreteType is InheritanceProvider)
                return Either.right(concreteType.superclass)

            return Either.left(IllegalArgumentException("Can't resolve super class of $type: Unknown type."))
        }

        override fun getInterfaces(type: Type): Either<Exception, List<Type>> {
            val concreteType = type.concreteType

            if (concreteType is LoadedKoresType<*>)
                return Either.right(concreteType.loadedType.interfaces?.map { it.koresType }.orEmpty())

            if (concreteType is TypeElementKoresType)
                return Either.right(concreteType.typeElement.interfaces?.filter { it.kind != TypeKind.NONE }
                    ?.map { it.getKoresType(concreteType.elements) }.orEmpty())

            if (concreteType is ImplementationHolder)
                return Either.right(concreteType.implementations.map { it.koresType }.toList())

            if (concreteType is InheritanceProvider)
                return Either.right(concreteType.superinterfaces.toList())

            return Either.left(IllegalArgumentException("Can't resolve super interfaces of $type: Unknown type."))
        }

        override fun isAssignableFrom(
            type: Type,
            from: Type,
            resolverProvider: (Type) -> KoresTypeResolver<*>
        ): EitherObjBoolean<Exception> {
            // Should I do something like TypeInfo#isAssignableFrom for GenericTypes?
            val concreteKoresType = type.concreteType
            val concreteFrom = from.concreteType

            if (concreteKoresType.`is`(concreteFrom))
                return EitherObjBoolean.right(true)

            if (concreteKoresType is LoadedKoresType<*> && concreteFrom is LoadedKoresType<*>)
                return EitherObjBoolean.right(
                    concreteKoresType.loadedType.isAssignableFrom(
                        concreteFrom.loadedType
                    )
                )

            val superClass =
                concreteFrom.let { resolverProvider(it).getSuperclass(it) }.rightOrNull()
                    ?.concreteType

            if (superClass != null) {
                if (superClass.`is`(concreteKoresType)
                        ||
                        superClass.let {
                            resolverProvider(it).isAssignableFrom(
                                concreteKoresType,
                                it,
                                resolverProvider
                            )
                                .let {
                                    if (it.isLeft) return EitherObjBoolean.left(it.left) else it.right
                                }
                        }
                ) {
                    return EitherObjBoolean.right(true)
                }
            }

            val superinterfaces =
                concreteFrom.let { resolverProvider(it).getInterfaces(it) }.rightOrNull().orEmpty()

            if (superinterfaces.isNotEmpty()) {
                if (superinterfaces.any { it.`is`(concreteKoresType) }
                        ||
                        superinterfaces.any {
                            resolverProvider(it).isAssignableFrom(
                                concreteKoresType,
                                it,
                                resolverProvider
                            )
                                .let {
                                    if (it.isLeft) return EitherObjBoolean.left(it.left) else it.right
                                }
                        }) {
                    return EitherObjBoolean.right(true)
                }
            }

            return EitherObjBoolean.right(false)
        }

        override fun resolveTypeDeclaration(type: Type): Either<Exception, TypeDeclaration> {
            val concreteType = type.concreteType

            if (concreteType is LoadedKoresType<*>)
                return Either.right(concreteType.loadedType.typeDeclaration)

            if (concreteType is TypeElementKoresType)
                return Either.right(concreteType.typeElement.getTypeDeclaration(concreteType.elements))

            if (concreteType is TypeDeclaration)
                return Either.right(concreteType.toRepresentation())

            return Either.left(IllegalArgumentException("Cannot create TypeDeclaration representation from $type"))
        }
    }

    /**
     * Resolver that resolves [KoresType] to Java [Class]. This may resolve to [KoresNothing.type]
     * is class loader fails to find class.
     */
    class Java(val classLoader: ClassLoader) : CommonResolver<Class<*>>() {
        override fun resolve(type: Type): Either<Exception, out Class<*>> {
            val concreteType = type.concreteType

            if (concreteType is LoadedKoresType<*>)
                return Either.right(concreteType.loadedType)

            return when (type.javaSpecName) {
                "V" -> Either.right(Void.TYPE)
                "Z" -> Either.right(Boolean::class.javaPrimitiveType!!)
                "C" -> Either.right(Char::class.javaPrimitiveType!!)
                "B" -> Either.right(Byte::class.javaPrimitiveType!!)
                "S" -> Either.right(Short::class.javaPrimitiveType!!)
                "I" -> Either.right(Int::class.javaPrimitiveType!!)
                "F" -> Either.right(Float::class.javaPrimitiveType!!)
                "D" -> Either.right(Double::class.javaPrimitiveType!!)
                "J" -> Either.right(Long::class.javaPrimitiveType!!)
                else -> try {
                    Either.right<Exception, Class<*>>(classLoader.loadClass(type.binaryName))
                } catch (t: ClassNotFoundException) {
                    Either.left<Exception, Class<*>>(t)
                }
            }
        }

    }

    /**
     * Resolver that resolves [KoresType] to Javax Model [TypeElement], or to `null`
     * if type cannot be found.
     */
    class Model(val elements: Elements) : CommonResolver<TypeElement?>() {
        override fun resolve(type: Type): Either<Exception, out TypeElement> =
            ((type.concreteType as? TypeElementKoresType)?.typeElement
                    ?: elements.getTypeElement(type.canonicalName))?.let {
                Either.right<Exception, TypeElement>(it)
            }
                    ?: Either.left<Exception, TypeElement>(IllegalArgumentException("Cannot resolve '$type' in Model Elements."))
    }

    /**
     * Default resolver that returns the same instance for [resolve] method.
     */
    object DefaultResolver : CommonResolver<Type>() {
        override fun resolve(type: Type): Either<Exception, Type> = Either.right(type)
    }

    /**
     * Kores Resolver.
     */
    class Kores(val resolverFunc: KoresTypeResolverFunc? = null) :
        CommonResolver<TypeDeclaration?>() {

        override fun resolve(type: Type): Either<Exception, out TypeDeclaration> =
            ((type.concreteType as? TypeDeclaration)
                    ?: (resolverFunc?.apply(type.canonicalName) as? TypeDeclaration))?.let {
                Either.right<Exception, TypeDeclaration>(it)
            }
                    ?: Either.left<Exception, TypeDeclaration>(IllegalArgumentException("Cannot resolve '$type' Kores Declaration."))


    }

    /**
     * This is a resolver which support multiple resolvers. This resolver
     * always returns first **valid resolved value** for each operation.
     *
     * A valid resolved value depends on operations, see documentation.
     */
    class Multi<T> : KoresTypeResolver<T?> {

        private val resolvers = mutableListOf<KoresTypeResolver<T?>>()

        /**
         * Adds a resolver
         */
        fun addResolver(resolver: KoresTypeResolver<T?>) {
            this.resolvers += resolver
        }

        /**
         * Removes a resolver
         */
        fun removeResolver(resolver: KoresTypeResolver<T?>) {
            this.resolvers -= resolver
        }

        /**
         * Adds a resolver
         */
        operator fun plusAssign(resolver: KoresTypeResolver<T?>) {
            this.resolvers += resolver
        }

        /**
         * Removes a resolver
         */
        operator fun minusAssign(resolver: KoresTypeResolver<T?>) {
            this.resolvers -= resolver
        }

        /**
         * First non-null and [non-nothing][KoresNothing] value is returned, or `null` if no
         * valid value was found.
         */
        @Suppress("UNCHECKED_CAST")
        override fun resolve(type: Type): Either<Exception, out T?> =
            resolvers.map { it.resolve(type) }.firstOrNull { it.isRight }
                    ?: Either.left<Exception, T?>(
                        IllegalArgumentException(
                            "None of provided resolvers was" +
                                    " able to resolve $type. Provided resolvers: '${resolvers.joinToString()}'"
                        )
                    )

        /**
         * First non-null and [non-nothing][KoresNothing] value is returned, or `null` if no
         * valid value was found.
         */
        override fun getSuperclass(type: Type): Either<Exception, Type?> =
            resolvers.map { it.getSuperclass(type) }
                .firstOrNull { it.isRight }
                    ?: Either.left<Exception, Type?>(
                        IllegalArgumentException(
                            "None of provided resolvers was" +
                                    " able to resolve $type super class. Provided resolvers: '${resolvers.joinToString()}'"
                        )
                    )

        /**
         * First bigger list is returned.
         */
        override fun getInterfaces(type: Type): Either<Exception, List<Type>> =
            resolvers.map { it.getInterfaces(type) }
                .filter { it.isRight }
                .sortedByDescending { it.right.size }
                .firstOrNull()
                    ?: Either.left<Exception, List<Type>>(
                        IllegalArgumentException(
                            "None of provided resolvers was" +
                                    " able to resolve $type super interfaces. Provided resolvers: '${resolvers.joinToString()}'"
                        )
                    )

        /**
         * Returns true if any resolver returns true for this operation.
         */
        override fun isAssignableFrom(
            type: Type,
            from: Type,
            resolverProvider: (Type) -> KoresTypeResolver<*>
        ): EitherObjBoolean<Exception> =
            resolvers.map { it.isAssignableFrom(type, from, resolverProvider) }
                .firstOrNull { it.isRight && it.right }
                    ?: EitherObjBoolean.left<Exception>(
                        IllegalArgumentException(
                            "None of provided resolvers was" +
                                    " able to resolve whether $type is assignable from $from. Provided resolvers: '${resolvers.joinToString()}'"
                        )
                    )

        override fun resolveTypeDeclaration(type: Type): Either<Exception, TypeDeclaration> =
            resolvers.map { it.resolveTypeDeclaration(type) }
                .firstOrNull { it.isRight }
                    ?: Either.left<Exception, TypeDeclaration>(
                        IllegalArgumentException(
                            "None of provided resolvers was" +
                                    " able to resolve TypeDeclaration representation of $type."
                        )
                    )
    }

    class Two<out A, out B, out X>(
        val first: KoresTypeResolver<A>,
        val second: KoresTypeResolver<B>
    ) : KoresTypeResolver<X> where A : X, B : X {
        @Suppress("UNCHECKED_CAST")
        override fun resolve(type: Type): Either<Exception, out X> =
            (this.first.resolve(type) as Either<Exception, X>).flatMapLeft {
                this.second.resolve(type) as Either<Exception, X>
            }

        override fun getSuperclass(type: Type): Either<Exception, Type?> =
            this.first.getSuperclass(type).flatMapLeft {
                this.second.getSuperclass(type)
            }

        override fun getInterfaces(type: Type): Either<Exception, List<Type>> =
            this.first.getInterfaces(type).flatMapLeft {
                this.second.getInterfaces(type)
            }

        override fun isAssignableFrom(
            type: Type,
            from: Type,
            resolverProvider: (Type) -> KoresTypeResolver<*>
        ): EitherObjBoolean<Exception> =
            this.first.isAssignableFrom(type, from, resolverProvider).flatMapLeft {
                this.second.isAssignableFrom(type, from, resolverProvider)
            }

        override fun resolveTypeDeclaration(type: Type): Either<Exception, TypeDeclaration> =
            this.first.resolveTypeDeclaration(type).flatMapLeft {
                this.second.resolveTypeDeclaration(type)
            }

    }
}