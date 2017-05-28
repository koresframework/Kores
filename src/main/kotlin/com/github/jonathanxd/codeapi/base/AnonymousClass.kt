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

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.util.*
import java.lang.reflect.Type

/**
 * Anonymous class, in Bytecode, anonymous class can have implementations,
 * in other languages it depends on specification. (Official Java generator may comment implementations).
 */
data class AnonymousClass(override val comments: Comments,
                          override val outerClass: Type?,
                          override val annotations: List<Annotation>,
                          override val specifiedName: String,
                          override val superClass: Type,
                          override val implementations: List<Type>,
                          val constructorSpec: TypeSpec,
                          override val arguments: List<CodeInstruction>,
                          val constructorBody: CodeSource,
                          override val staticBlock: StaticBlock,
                          override val fields: List<FieldDeclaration>,
                          override val constructors: List<ConstructorDeclaration>,
                          override val methods: List<MethodDeclaration>,
                          override val innerTypes: List<TypeDeclaration>) : TypeDeclaration, SuperClassHolder, ArgumentsHolder, ImplementationHolder {

    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerClass)

    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerClass)

    override val array: Boolean
        get() = false

    override val modifiers: Set<CodeModifier>
        get() = setOf(CodeModifier.PACKAGE_PRIVATE)

    override val types: List<Type>
        get() = this.constructorSpec.parameterTypes

    override val genericSignature: GenericSignature
        get() = GenericSignature.empty()


    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    override fun builder(): Builder = Builder(this)

    class Builder() :
            TypeDeclaration.Builder<AnonymousClass, Builder>,
            SuperClassHolder.Builder<AnonymousClass, Builder>,
            ArgumentsHolder.Builder<AnonymousClass, Builder>,
            ImplementationHolder.Builder<AnonymousClass, Builder> {

        var comments: Comments = Comments.Absent
        var outerClass: Type? = null
        var annotations: List<Annotation> = emptyList()
        lateinit var specifiedName: String
        var superClass: Type = Types.OBJECT
        var implementations: List<Type> = emptyList()
        lateinit var constructorSpec: TypeSpec
        var arguments: List<CodeInstruction> = emptyList()
        lateinit var constructorBody: CodeSource

        var staticBlock: StaticBlock = StaticBlock(Comments.Absent, emptyList(), CodeSource.empty())
        var fields: List<FieldDeclaration> = emptyList()
        var constructors: List<ConstructorDeclaration> = emptyList()
        var methods: List<MethodDeclaration> = emptyList()
        var innerTypes: List<TypeDeclaration> = emptyList()

        constructor(defaults: AnonymousClass) : this() {
            this.comments = defaults.comments
            this.outerClass = defaults.outerClass
            this.annotations = defaults.annotations
            this.specifiedName = defaults.specifiedName
            this.superClass = defaults.superClass
            this.implementations = defaults.implementations
            this.constructorSpec = defaults.constructorSpec
            this.arguments = defaults.arguments
            this.constructorBody = defaults.constructorBody

            this.staticBlock = defaults.staticBlock
            this.fields = defaults.fields
            this.constructors = defaults.constructors
            this.methods = defaults.methods
            this.innerTypes = defaults.innerTypes

        }

        override fun withModifiers(value: Set<CodeModifier>): Builder = self()
        override fun withModifiers(vararg values: CodeModifier): Builder = self()
        override fun withArray(value: Boolean): Builder = self()
        override fun withGenericSignature(value: GenericSignature): Builder = self()

        override fun withOuterClass(value: Type?): Builder {
            this.outerClass = value
            return this
        }

        override fun withComments(value: Comments): Builder {
            this.comments = value
            return this
        }

        override fun withAnnotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        override fun withStaticBlock(value: StaticBlock): Builder {
            this.staticBlock = value
            return this
        }

        override fun withFields(value: List<FieldDeclaration>): Builder {
            this.fields = value
            return this
        }

        override fun withConstructors(value: List<ConstructorDeclaration>): Builder {
            this.constructors = value
            return this
        }

        override fun withMethods(value: List<MethodDeclaration>): Builder {
            this.methods = value
            return this
        }

        override fun withInnerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun withSuperClass(value: Type?): Builder {
            this.superClass = value!!
            return this
        }

        override fun withImplementations(value: List<Type>): Builder {
            this.implementations = value
            return this
        }

        override fun withArguments(value: List<CodeInstruction>): Builder {
            this.arguments = value
            return this
        }

        override fun withSpecifiedName(value: String): Builder {
            this.specifiedName = value
            return this
        }

        /**
         * See [AnonymousClass.constructorSpec]
         */
        fun withConstructorSpec(value: TypeSpec): Builder {
            this.constructorSpec = value
            return this
        }

        /**
         * See [AnonymousClass.constructorBody]
         */
        fun withConstructorBody(value: CodeSource): Builder {
            this.constructorBody = value
            return this
        }

        override fun build(): AnonymousClass = AnonymousClass(
                this.comments,
                this.outerClass,
                this.annotations,
                this.specifiedName,
                this.superClass,
                this.implementations,
                this.constructorSpec,
                this.arguments,
                this.constructorBody,
                this.staticBlock,
                this.fields,
                this.constructors,
                this.methods,
                this.innerTypes
        )


        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: AnonymousClass): Builder = Builder(defaults)
        }
    }
}
