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
     * Constructor declaration
     */
    val constructors: List<ConstructorDeclaration>

    /**
     * Methods of type
     */
    val methods: List<MethodDeclaration>

    interface Builder<out T: ElementsHolder, S: Builder<T, S>> : InnerTypesHolder.Builder<T, S> {

        /**
         * See [TypeDeclaration.staticBlock]
         */
        fun withStaticBlock(value: StaticBlock): S

        /**
         * See [TypeDeclaration.fields]
         */
        fun withFields(value: List<FieldDeclaration>): S

        /**
         * See [TypeDeclaration.fields]
         */
        fun withFields(vararg values: FieldDeclaration): S = this.withFields(values.toList())

        /**
         * See [TypeDeclaration.fields]
         */
        fun withFields(value: FieldDeclaration): S = this.withFields(listOf(value))

        /**
         * See [TypeDeclaration.constructors]
         */
        fun withConstructors(value: List<ConstructorDeclaration>): S

        /**
         * See [TypeDeclaration.constructors]
         */
        fun withConstructors(vararg values: ConstructorDeclaration): S = this.withConstructors(values.toList())

        /**
         * See [TypeDeclaration.constructors]
         */
        fun withConstructors(value: ConstructorDeclaration): S = this.withConstructors(listOf(value))

        /**
         * See [TypeDeclaration.methods]
         */
        fun withMethods(value: List<MethodDeclaration>): S

        /**
         * See [TypeDeclaration.methods]
         */
        fun withMethods(vararg values: MethodDeclaration): S = this.withMethods(values.toList())

        /**
         * See [TypeDeclaration.methods]
         */
        fun withMethods(value: MethodDeclaration): S = this.withMethods(listOf(value))

    }

}