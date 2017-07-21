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

/**
 * Holder of some elements.
 */
interface ElementsHolder : InnerTypesHolder {

    /**
     * Static block
     */
    val staticBlock: StaticBlock

    /**
     * Fields of the type.
     */
    val fields: List<FieldDeclaration>

    /**
     * Methods of type
     */
    val methods: List<MethodDeclaration>

    override fun builder(): Builder<ElementsHolder, *>

    interface Builder<out T: ElementsHolder, S: Builder<T, S>> : InnerTypesHolder.Builder<T, S> {

        /**
         * See [ElementsHolder.staticBlock]
         */
        fun staticBlock(value: StaticBlock): S

        /**
         * See [ElementsHolder.fields]
         */
        fun fields(value: List<FieldDeclaration>): S

        /**
         * See [ElementsHolder.fields]
         */
        fun fields(vararg values: FieldDeclaration): S = this.fields(values.toList())

        /**
         * See [ElementsHolder.fields]
         */
        fun fields(value: FieldDeclaration): S = this.fields(listOf(value))

        /**
         * See [ElementsHolder.methods]
         */
        fun methods(value: List<MethodDeclaration>): S

        /**
         * See [ElementsHolder.methods]
         */
        fun methods(vararg values: MethodDeclaration): S = this.methods(values.toList())

        /**
         * See [ElementsHolder.methods]
         */
        fun methods(value: MethodDeclaration): S = this.methods(listOf(value))

    }

}