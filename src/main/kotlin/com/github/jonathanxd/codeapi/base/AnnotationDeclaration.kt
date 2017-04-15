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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.buildergenerator.Defaults
import com.github.jonathanxd.buildergenerator.annotation.DefaultImpl
import com.github.jonathanxd.buildergenerator.annotation.MethodRef
import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.AnnotationDeclarationBuilder
import com.github.jonathanxd.codeapi.builder.invoke

/**
 * Annotation declaration
 */
@Concrete
interface AnnotationDeclaration : TypeDeclaration {

    /**
     * Annotation properties
     */
    val properties: List<AnnotationProperty>

    override val isInterface: Boolean
        get() = true

    override fun builder(): Builder<AnnotationDeclaration, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : AnnotationDeclaration, S : Builder<T, S>> : TypeDeclaration.Builder<T, S> {
        /**
         * See [T.properties]
         */
        fun withProperties(value: List<AnnotationProperty>): S

        /**
         * See [T.properties]
         */
        @DefaultImpl(MethodRef(value = Defaults::class, name = "varArgToList"))
        fun withProperties(vararg values: AnnotationProperty): S

        companion object {
            fun builder(): Builder<AnnotationDeclaration, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: AnnotationDeclaration): Builder<AnnotationDeclaration, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }
    }
}