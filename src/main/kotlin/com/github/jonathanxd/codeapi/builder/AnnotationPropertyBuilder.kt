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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.base.impl.AnnotationPropertyImpl
import com.github.jonathanxd.codeapi.base.AnnotationProperty

// Generated by BuilderGen
open class AnnotationPropertyBuilder(): AnnotationProperty.Builder<AnnotationProperty, AnnotationPropertyBuilder> {

    /**
     * See [AnnotationProperty.type]
     */
    lateinit var type: com.github.jonathanxd.codeapi.type.CodeType

    /**
     * See [AnnotationProperty.name]
     */
    lateinit var name: kotlin.String

    /**
     * See [AnnotationProperty.annotations]
     */
    var annotations: kotlin.collections.List<com.github.jonathanxd.codeapi.base.Annotation> = emptyList()

    /**
     * See [AnnotationProperty.value]
     */
    var value: kotlin.Any? = null

    constructor(defaults: AnnotationProperty) : this() {
        this.type = defaults.type
        this.name = defaults.name
        this.annotations = defaults.annotations
        this.value = defaults.value
    }


    /**
     * See [AnnotationProperty.type]
     */
    override fun withType(value: com.github.jonathanxd.codeapi.type.CodeType?): AnnotationPropertyBuilder {
        this.type = value!!
        return this
    }


    /**
     * See [AnnotationProperty.name]
     */
    override fun withName(value: kotlin.String): AnnotationPropertyBuilder {
        this.name = value
        return this
    }


    /**
     * See [AnnotationProperty.annotations]
     */
    override fun withAnnotations(value: kotlin.collections.List<com.github.jonathanxd.codeapi.base.Annotation>): AnnotationPropertyBuilder {
        this.annotations = value
        return this
    }


    /**
     * See [AnnotationProperty.annotations]
     */
    override fun withAnnotations(vararg values: com.github.jonathanxd.codeapi.base.Annotation): AnnotationPropertyBuilder {
        this.annotations = values.toList()
        return this
    }


    /**
     * See [AnnotationProperty.value]
     */
    override fun withValue(value: kotlin.Any?): AnnotationPropertyBuilder {
        this.value = value
        return this
    }

    override fun build(): AnnotationProperty = AnnotationPropertyImpl(
            type = this.type,
            name = this.name,
            annotations = this.annotations,
            value = this.value
    )


    companion object {
        @JvmStatic
        fun builder() = AnnotationPropertyBuilder()
    }
}