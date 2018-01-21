/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.base.Annotation
import com.github.jonathanxd.codeapi.base.TypeDeclaration
import com.github.jonathanxd.codeapi.util.toStr
import java.lang.reflect.Type

/**
 * A [CodeType] with annotations, to be used where `TYPE_USE Annotations` are allowed, but there is no
 * limitation of where you can use.
 *
 * This interface have various implementations, each implementation backing to variants of [CodeType]. But not all,
 * there is no special implementation for `TypeDeclaration` for example, but only a generic implementation.
 */
interface AnnotatedCodeType : WrapperCodeType {

    override val wrapped: CodeType
        get() = this.annotatedType.codeType

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

    override val arrayBaseComponent: CodeType
        get() = this.annotatedType.arrayBaseComponent

    override val arrayComponent: CodeType
        get() = this.annotatedType.arrayComponent

    override val arrayDimension: Int
        get() = this.annotatedType.arrayDimension

    override val bindedDefaultResolver: BindedTypeResolver<*>
        get() = this.annotatedType.codeType.bindedDefaultResolver

    override val defaultResolver: CodeTypeResolver<*>
        get() = this.annotatedType.defaultResolver

    override val interfaces: List<Type>
        get() = this.annotatedType.interfaces

    override val isArray: Boolean
        get() = this.annotatedType.isArray

    override val isInterface: Boolean
        get() = this.annotatedType.isInterface*/

    override fun builder(): Builder<AnnotatedCodeType, *>

    interface Builder<out T : AnnotatedCodeType, S : Builder<T, S>> :
        com.github.jonathanxd.codeapi.builder.Builder<T, S> {
        /**
         * The [type] that is annotated with [annotations].
         */
        fun annotatedType(type: Type): Builder<T, S>

        /**
         * Adds an [Annotation] to [AnnotatedCodeType.annotations].
         */
        fun addAnnotation(annotation: Annotation): Builder<T, S>

        /**
         * Defines [AnnotatedCodeType.annotations].
         */
        fun annotations(annotations: List<Annotation>): Builder<T, S>

        /**
         * Defines [AnnotatedCodeType.annotations].
         */
        fun annotations(vararg annotations: Annotation): Builder<T, S> =
            this.annotations(annotations.toList())
    }

    abstract class Abstract<out T : Abstract<T>>(
        override val annotatedType: Type,
        override val annotations: List<Annotation>,
        private val factory: (type: Type, annotations: List<Annotation>) -> T
    ) : AnnotatedCodeType,
        CodeType by annotatedType.codeType {

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
        fun builder(type: Type): AnnotatedCodeType.Builder<AnnotatedCodeType, *> =
            when (type) {
                is TypeDeclaration -> Abstract.BuilderImpl({ c, v ->
                    if (c is TypeDeclaration) SimpleAnnotatedWrapperCodeType(c, c, v)
                    else SimpleAnnotatedCodeType(c, v)
                }).also {
                    it.annotatedType(type)
                }
                is GenericType -> GenericAnnotatedCodeType.GenericBuilder(type)
                is LoadedCodeType<*> -> Abstract.BuilderImpl({ c, v ->
                    SimpleAnnotatedLoadedCodeType<Any>(
                        c,
                        v
                    )
                }).also {
                    it.annotatedType(type)
                }
                is UnknownCodeType -> Abstract.BuilderImpl(::SimpleAnnotatedUnknownCodeType).also {
                    it.annotatedType(type)
                }
                else -> Abstract.BuilderImpl(::SimpleAnnotatedCodeType).also {
                    it.annotatedType(type)
                }
            }


        fun annotatedType(type: Type, annotations: List<Annotation>): AnnotatedCodeType =
            builder(type).let {
                it.annotations(annotations)
                it.build()
            }

    }

    class SimpleAnnotatedWrapperCodeType(
        override val wrapped: CodeType,
        annotatedType: Type,
        annotations: List<Annotation>
    ) : Abstract<SimpleAnnotatedCodeType>(annotatedType, annotations, ::SimpleAnnotatedCodeType)

    class SimpleAnnotatedCodeType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedCodeType>(annotatedType, annotations, ::SimpleAnnotatedCodeType)

    class SimpleAnnotatedUnknownCodeType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedUnknownCodeType>(
            annotatedType,
            annotations,
            ::SimpleAnnotatedUnknownCodeType
        ), UnknownCodeType

    @Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE", "UNCHECKED_CAST")
    class SimpleAnnotatedLoadedCodeType<T>(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<SimpleAnnotatedLoadedCodeType<T>>(
            annotatedType,
            annotations,
            ::SimpleAnnotatedLoadedCodeType
        ),
        LoadedCodeType<T> by annotatedType.codeType as LoadedCodeType<T> {

        override val type: String
            get() = super<LoadedCodeType>.type

        override val canonicalName: String
            get() = super<LoadedCodeType>.canonicalName

        override val primitiveType: CodeType?
            get() = super<LoadedCodeType>.primitiveType

        override val wrapperType: CodeType?
            get() = super<LoadedCodeType>.wrapperType

        override val defaultResolver: CodeTypeResolver<Class<*>>
            get() = super<LoadedCodeType>.defaultResolver

        override val isInterface: Boolean
            get() = super<LoadedCodeType>.isInterface

        override val isArray: Boolean
            get() = super<LoadedCodeType>.isArray

        override val isPrimitive: Boolean
            get() = super<LoadedCodeType>.isPrimitive

        override val isVirtual: Boolean
            get() = super<LoadedCodeType>.isVirtual

        override fun builder(): Builder<SimpleAnnotatedLoadedCodeType<T>, *> =
            super<Abstract>.builder()
    }

    @Suppress("DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
    class GenericAnnotatedCodeType(annotatedType: Type, annotations: List<Annotation>) :
        Abstract<GenericAnnotatedCodeType>(annotatedType, annotations, ::GenericAnnotatedCodeType),
        GenericType by annotatedType.asGeneric {

        override fun builder() = GenericBuilder(this.annotatedType.asGeneric)

        override val wrapped: CodeType
            get() = super<GenericType>.wrapped

        override val type: String
            get() = super<GenericType>.type

        override val identification: String
            get() = super<GenericType>.identification

        override val arrayBaseComponent: CodeType
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

        override val arrayComponent: CodeType
            get() = super<GenericType>.arrayComponent

        override val isArray: Boolean
            get() = super<GenericType>.isArray

        override val wrapperType: CodeType?
            get() = super<GenericType>.wrapperType

        override val primitiveType: CodeType?
            get() = super<GenericType>.primitiveType

        override val isPrimitive: Boolean
            get() = super<GenericType>.isPrimitive

        override val isInterface: Boolean
            get() = super<GenericType>.isInterface

        override val isVirtual: Boolean
            get() = super<GenericType>.isVirtual

        override fun compareTo(other: CodeType): Int =
            super<GenericType>.compareTo(other)

        override fun `is`(other: CodeType?): Boolean {
            return super<GenericType>.`is`(other)
        }

        class GenericBuilder(origin: GenericType) :
            AnnotatedCodeType.Builder<GenericAnnotatedCodeType, GenericBuilder>,
            GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {

            var annotations: List<Annotation> = listOf()
            var backingGeneric = origin.builder()

            override fun annotatedType(type: Type): Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric = type.asGeneric.builder()
                return this
            }

            override fun annotations(annotations: List<Annotation>): Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.annotations = annotations
                return this
            }

            override fun addAnnotation(annotation: Annotation): Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.annotations += annotation
                return this
            }

            override fun name(value: String): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.name(value)
                return this
            }

            override fun wildcard(): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.wildcard()
                return this
            }

            override fun type(value: Type): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.type(value)
                return this
            }

            override fun bounds(value: Array<GenericType.Bound>): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.bounds(value)
                return this
            }

            override fun addBounds(bounds: Array<GenericType.Bound>): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addBounds(bounds)
                return this
            }

            override fun addBounds(bounds: Collection<GenericType.Bound>): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addBounds(bounds)
                return this
            }

            override fun addBound(bound: GenericType.Bound): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addBound(bound)
                return this
            }

            override fun addExtendsBound(value: Type): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addExtendsBound(value)
                return this
            }

            override fun addSuperBound(value: Type): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addSuperBound(value)
                return this
            }

            override fun addOfBound(value: Type): GenericType.Builder<GenericAnnotatedCodeType, GenericBuilder> {
                this.backingGeneric.addOfBound(value)
                return this
            }

            override fun build(): GenericAnnotatedCodeType =
                GenericAnnotatedCodeType(this.backingGeneric.build(), annotations)
        }
    }
}