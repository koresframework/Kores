/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.kores.base.Annotation
import com.github.jonathanxd.kores.base.TypeDeclaration
import com.github.jonathanxd.kores.util.toStr
import java.lang.reflect.Type

/**
 * A [KoresType] with annotations, to be used where `TYPE_USE Annotations` are allowed, but there is no
 * limitation of where you can use.
 *
 * This interface have various implementations, each implementation backing to variants of [KoresType]. But not all,
 * there is no special implementation for `TypeDeclaration` for example, but only a generic implementation.
 */
interface AnnotatedKoresType : WrapperKoresType {

    override val wrapped: KoresType
        get() = this.annotatedType.koresType

    /**
     * The type that is annotated with [annotations]. (May be `this`).
     */
    val annotatedType: Type

    /**
     * Annotations of the type.
     */
    val annotations: List<Annotation>
    // By delegate
    /*override val canonicalName: String
        get() = this.annotatedType.canonicalName

    override val identification: String
        get() = this.annotatedType.identification

    override val type: String
        get() = this.annotatedType.type

    override val internalName: String
        get() = this.annotatedType.internalName

    override val binaryName: String
        get() = this.annotatedType.binaryName

    override val arrayBaseComponent: KoresType
        get() = this.annotatedType.arrayBaseComponent

    override val arrayComponent: KoresType
        get() = this.annotatedType.arrayComponent

    override val arrayDimension: Int
        get() = this.annotatedType.arrayDimension

    override val bindedDefaultResolver: BindedTypeResolver<*>
        get() = this.annotatedType.koresType.bindedDefaultResolver

    override val defaultResolver: KoresTypeResolver<*>
        get() = this.annotatedType.defaultResolver

    override val interfaces: List<Type>
        get() = this.annotatedType.interfaces

    override val isArray: Boolean
        get() = this.annotatedType.isArray

    override val isInterface: Boolean
        get() = this.annotatedType.isInterface*/

    override fun builder(): Builder<AnnotatedKoresType, *>

    interface Builder<out T : AnnotatedKoresType, S : Builder<T, S>> :
        com.github.jonathanxd.kores.builder.Builder<T, S> {
        /**
         * The [type] that is annotated with [annotations].
         */
        fun annotatedType(type: Type): Builder<T, S>

        /**
         * Adds an [Annotation] to [AnnotatedKoresType.annotations].
         */
        fun addAnnotation(annotation: Annotation): Builder<T, S>

        /**
         * Defines [AnnotatedKoresType.annotations].
         */
        fun annotations(annotations: List<Annotation>): Builder<T, S>

        /**
         * Defines [AnnotatedKoresType.annotations].
         */
        fun annotations(vararg annotations: Annotation): Builder<T, S> =
            this.annotations(annotations.toList())
    }

    abstract class Abstract<out T : Abstract<T>>(
        override val annotatedType: Type,
        override val annotations: List<Annotation>,
        private val factory: (type: Type, annotations: List<Annotation>) -> T
    ) : AnnotatedKoresType,
        KoresType by annotatedType.koresType {

        override fun toString(): String = this.toStr()
        override fun equals(other: Any?): Boolean = this.eq(other)
        override fun hashCode(): Int = this.hash()

        override fun builder(): Builder<T, *> = BuilderImpl(this)

        class BuilderImpl<T : Abstract<T>>(
            private val factory: (type: Type, annotations: List<Annotation>) -> T
        ) : Builder<T, BuilderImpl<T>> {

            lateinit var annotatedType: Type
            var annotations: List<Annotation> = mutableListOf()

            constructor(defaults: Abstract<T>) : this(defaults.factory) {
                this.annotatedType = defaults.annotatedType
                this.annotations = defaults.annotations
            }

            override fun annotatedType(type: Type): BuilderImpl<T> {
                this.annotatedType = type
                return this
            }

            override fun annotations(annotations: List<Annotation>): BuilderImpl<T> {
                this.annotations = annotations
                return this
            }

            override fun addAnnotation(annotation: Annotation): BuilderImpl<T> {
                this.annotations += annotation
                return this
            }

            override fun build(): T = factory(this.annotatedType, annotations)
        }
    }


    companion object {
        fun builder(type: Type): AnnotatedKoresType.Builder<AnnotatedKoresType, *> =
            when (type) {
                is TypeDeclaration -> Abstract.BuilderImpl({ c, v ->
                    if (c is TypeDeclaration) SimpleAnnotatedWrapperKoresType(c, c, v)
                    else SimpleAnnotatedKoresType(c, v)
                }).also {
                    it.annotatedType(type)
                }
                is GenericType -> GenericAnnotatedKoresType.GenericBuilder(type)
                is LoadedKoresType<*> -> Abstract.BuilderImpl({ c, v ->
                    SimpleAnnotatedLoadedKoresType<Any>(
                        c,
                        v
                    )
                }).also {
                    it.annotatedType(type)
                }
                is UnknownKoresType -> Abstract.BuilderImpl(::SimpleAnnotatedUnknownKoresType).also {
                    it.annotatedType(type)
                }
                else -> Abstract.BuilderImpl(::SimpleAnnotatedKoresType).also {
                    it.annotatedType(type)
                }
            }


        fun annotatedType(type: Type, annotations: List<Annotation>): AnnotatedKoresType =
            builder(type).let {
                it.annotations(annotations)
                it.build()
            }

    }

    class SimpleAnnotatedWrapperKoresType(
        override val wrapped: KoresType,
        annotatedType: Type,
        annotations: List<Annotation>
    ) : Abstract<SimpleAnnotatedKoresType>(annotatedType, annotations, ::SimpleAnnotatedKoresType)

    class SimpleAnnotatedKoresType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedKoresType>(annotatedType, annotations, ::SimpleAnnotatedKoresType)

    class SimpleAnnotatedUnknownKoresType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedUnknownKoresType>(
            annotatedType,
            annotations,
            ::SimpleAnnotatedUnknownKoresType
        ), UnknownKoresType

    @Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE", "UNCHECKED_CAST")
    class SimpleAnnotatedLoadedKoresType<T>(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedLoadedKoresType<T>>(
            annotatedType,
            annotations,
            ::SimpleAnnotatedLoadedKoresType
        ),
        LoadedKoresType<T> by annotatedType.koresType as LoadedKoresType<T> {

        override val type: String
            get() = super<LoadedKoresType>.type

        override val canonicalName: String
            get() = super<LoadedKoresType>.canonicalName

        override val primitiveType: KoresType?
            get() = super<LoadedKoresType>.primitiveType

        override val wrapperType: KoresType?
            get() = super<LoadedKoresType>.wrapperType

        override val defaultResolver: KoresTypeResolver<Class<*>>
            get() = super<LoadedKoresType>.defaultResolver

        override val isInterface: Boolean
            get() = super<LoadedKoresType>.isInterface

        override val isArray: Boolean
            get() = super<LoadedKoresType>.isArray

        override val isPrimitive: Boolean
            get() = super<LoadedKoresType>.isPrimitive

        override val isVirtual: Boolean
            get() = super<LoadedKoresType>.isVirtual

        override fun builder(): Builder<SimpleAnnotatedLoadedKoresType<T>, *> =
            super<Abstract>.builder()
    }

    @Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
    class GenericAnnotatedKoresType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<GenericAnnotatedKoresType>(annotatedType, annotations, ::GenericAnnotatedKoresType),
        GenericType by annotatedType.asGeneric {

        override fun builder() = GenericBuilder(this.annotatedType.asGeneric)

        override val wrapped: KoresType
            get() = super<GenericType>.wrapped

        override val type: String
            get() = super<GenericType>.type

        override val identification: String
            get() = super<GenericType>.identification

        override val arrayBaseComponent: KoresType
            get() = super<GenericType>.arrayBaseComponent

        override val javaSpecName: String
            get() = super<GenericType>.javaSpecName

        override val simpleName: String
            get() = super<GenericType>.simpleName

        override val packageName: String
            get() = super<GenericType>.packageName

        override val canonicalName: String
            get() = super<GenericType>.canonicalName

        override val arrayDimension: Int
            get() = super<GenericType>.arrayDimension

        override val arrayComponent: KoresType
            get() = super<GenericType>.arrayComponent

        override val isArray: Boolean
            get() = super<GenericType>.isArray

        override val wrapperType: KoresType?
            get() = super<GenericType>.wrapperType

        override val primitiveType: KoresType?
            get() = super<GenericType>.primitiveType

        override val isPrimitive: Boolean
            get() = super<GenericType>.isPrimitive

        override val isInterface: Boolean
            get() = super<GenericType>.isInterface

        override val isVirtual: Boolean
            get() = super<GenericType>.isVirtual

        override val defaultResolver: KoresTypeResolver<*>
            get() = super<GenericType>.defaultResolver

        override fun compareTo(other: KoresType): Int =
            super<GenericType>.compareTo(other)

        override fun `is`(other: KoresType?): Boolean {
            return super<GenericType>.`is`(other)
        }

        class GenericBuilder(origin: GenericType) :
            AnnotatedKoresType.Builder<GenericAnnotatedKoresType, GenericBuilder>,
            GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {

            var annotations: List<Annotation> = listOf()
            var backingGeneric = origin.builder()

            override fun annotatedType(type: Type): Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric = type.asGeneric.builder()
                return this
            }

            override fun annotations(annotations: List<Annotation>): Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.annotations = annotations
                return this
            }

            override fun addAnnotation(annotation: Annotation): Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.annotations += annotation
                return this
            }

            override fun name(value: String): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.name(value)
                return this
            }

            override fun wildcard(): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.wildcard()
                return this
            }

            override fun type(value: Type): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.type(value)
                return this
            }

            override fun bounds(value: Array<GenericType.Bound>): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.bounds(value)
                return this
            }

            override fun addBounds(bounds: Array<GenericType.Bound>): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addBounds(bounds)
                return this
            }

            override fun addBounds(bounds: Collection<GenericType.Bound>): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addBounds(bounds)
                return this
            }

            override fun addBound(bound: GenericType.Bound): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addBound(bound)
                return this
            }

            override fun addExtendsBound(value: Type): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addExtendsBound(value)
                return this
            }

            override fun addSuperBound(value: Type): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addSuperBound(value)
                return this
            }

            override fun addOfBound(value: Type): GenericType.Builder<GenericAnnotatedKoresType, GenericBuilder> {
                this.backingGeneric.addOfBound(value)
                return this
            }

            override fun build(): GenericAnnotatedKoresType =
                GenericAnnotatedKoresType(this.backingGeneric.build(), annotations)
        }
    }
}