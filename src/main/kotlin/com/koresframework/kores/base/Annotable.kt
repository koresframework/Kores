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

import com.koresframework.kores.KoresPart
import com.koresframework.kores.builder.self
import com.koresframework.kores.type.`is`
import java.lang.reflect.Type
import kotlin.reflect.KMutableProperty

/**
 * An part that can be annotated, like methods, fields, classes, type usage, etc...
 */
interface Annotable : KoresPart {

    /**
     * Annotations
     */
    val annotations: List<Annotation>

    /**
     * Returns whether `this` [Annotable] contains an annotation of specified [type].
     */
    fun isAnnotationPresent(type: Type) =
        this.annotations.any { it.type.`is`(type) }

    /**
     * Gets the annotation of type [type] if present, or null otherwise.
     */
    fun getDeclaredAnnotation(type: Type) =
        this.annotations.firstOrNull { it.type.`is`(type) }

    /**
     * Gets the annotation of type [type] if present, or null otherwise.
     */
    fun getAnnotation(type: Type) = this.getDeclaredAnnotation(type)

    override fun builder(): Builder<Annotable, *>

    interface Builder<out T : Annotable, S : Builder<T, S>> :
        com.koresframework.kores.builder.Builder<T, S>, KoresPart.PartBuilder<T, S> {

        var annotations: List<Annotation>

        /**
         * See [T.annotations]
         */
        fun annotations(value: List<Annotation>): S {
            this.annotations = value
            return self()
        }

        /**
         * See [T.annotations]
         */
        fun annotations(vararg values: Annotation): S = annotations(values.toList())
    }
}

