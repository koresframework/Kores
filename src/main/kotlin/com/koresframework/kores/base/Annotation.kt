/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.base

import com.koresframework.kores.type.`is`
import com.koresframework.kores.type.bindedDefaultResolver
import com.github.jonathanxd.iutils.`object`.Either
import com.github.jonathanxd.iutils.kt.left
import com.github.jonathanxd.iutils.kt.right
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.dataFrom
import com.koresframework.kores.serialization.AnnotationSerializer
import kotlinx.serialization.Serializable
import java.lang.annotation.RetentionPolicy
import java.lang.reflect.AnnotatedType
import java.lang.reflect.Type
import kotlin.reflect.KMutableProperty

typealias KoresAnnotation = Annotation

/**
 * An annotation, an annotation is composed by a pair of property name and property value.
 *
 * # In Java
 *
 * [type] is the annotation type and [values] are the pairs that denote annotation properties and their
 * respective values.
 *
 * Example:
 *
 * `Annotation(Override, emptyMap(), false)` is equal to `@Override`
 * `Annotation(Named, mapOf("value" to "Wow"), true)` is equal to `@Named("Wow")`
 * `Annotation(Wow, mapOf("a" to 9, "b" to 7), true)` is equal to `@Wow(a = 9, b = 7)`
 *
 * The [retention] is determined by the compiler, which inspects [type] and reads [Retention] annotation, but
 * here it need to be explicitly specified (you can also use [Retention.resolveRetention] to try to resolve the
 * retention of [type]).
 *
 * @property retention Annotation retention, this property must match the same retention of annotation [type].
 * @property type Type of annotation.
 * @property values Map of annotation values (key is the property of annotation),
 * the Annotation value must be: [Byte], [Boolean], [Char], [Short],
 * [Int], [Long], [Float], [Double], [String], [Type], [EnumValue], other [Annotation] or a List
 * of one of types cited above (with or without elements).
 */
@Serializable(with = AnnotationSerializer::class)
data class Annotation(
    override val type: Type,
    val values: Map<String, Any>,
    val retention: Retention
) :
    Typed {
    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : Typed.Builder<Annotation, Builder> {

        override var data: KoresData = KoresData()
        override lateinit var type: Type

        var values: Map<String, Any> = emptyMap()
        var retention: Retention = Retention.CLASS

        constructor(defaults: Annotation) : this() {
            this.type = defaults.type
            this.values = defaults.values
            this.retention = defaults.retention
            this.fromData(defaults.data)
        }

        /**
         * See [Annotation.values]
         */
        fun values(value: Map<String, Any>): Builder {
            this.values = value
            return this
        }

        /**
         * See [Annotation.retention]
         */
        fun retention(value: Retention): Builder {
            this.retention = value
            return this
        }

        override fun buildBasic(): Annotation = Annotation(type, values, retention)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Annotation): Builder = Builder(defaults)
        }

    }
}

@Serializable
enum class Retention {
    /**
     * Source retention of annotation
     */
    SOURCE,
    /**
     * Class retention of annotation
     */
    CLASS,
    /**
     * Runtime retention.
     */
    RUNTIME;

    companion object {
        fun resolveRetention(type: Type): Either<Exception, Retention> =
            type.bindedDefaultResolver.resolve().flatMapRight<Retention> {
                val resolved: Retention? = when (it) {
                    is AnnotatedType -> {
                        it.getDeclaredAnnotation(java.lang.annotation.Retention::class.java)
                            ?.let { fromPolicy(it.value) }
                    }
                    is TypeDeclaration -> fromAnnotable(it)
                    else -> return@flatMapRight type.bindedDefaultResolver.resolveTypeDeclaration()
                        .mapRight { fromAnnotable(it) }
                }

                return@flatMapRight resolved?.let { right<Exception, Retention>(it) }
                        ?: left<Exception, Retention>(IllegalArgumentException("Retention of type cannot be resolved"))
            }

        private fun fromAnnotable(annotable: Annotable): Retention? =
            annotable.annotations.firstOrNull { it.type.`is`(java.lang.annotation.Retention::class.java) }?.let {
                it.values["value"]?.let { it as? java.lang.annotation.RetentionPolicy }?.let { fromPolicy(it) }
            }

        fun fromPolicy(retentionPolicy: RetentionPolicy): Retention =
            when (retentionPolicy) {
                RetentionPolicy.CLASS -> CLASS
                RetentionPolicy.RUNTIME -> RUNTIME
                else -> SOURCE
            }
    }
}

