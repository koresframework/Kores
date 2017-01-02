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

import com.github.jonathanxd.codeapi.base.impl.ClassDeclarationImpl
import com.github.jonathanxd.codeapi.base.ClassDeclaration

// Generated by BuilderGen
class ClassDeclarationBuilder(): Builder<ClassDeclaration, ClassDeclarationBuilder>() {
    var superClass: com.github.jonathanxd.codeapi.types.CodeType? = null
    var implementations: kotlin.collections.List<com.github.jonathanxd.codeapi.types.CodeType> = emptyList()
    lateinit var qualifiedName: kotlin.String
    var annotations: kotlin.collections.List<com.github.jonathanxd.codeapi.base.Annotation> = emptyList()
    var body: com.github.jonathanxd.codeapi.CodeSource? = null
    var modifiers: kotlin.collections.List<com.github.jonathanxd.codeapi.common.CodeModifier> = emptyList()
    lateinit var genericSignature: com.github.jonathanxd.codeapi.generic.GenericSignature
    var outerClass: com.github.jonathanxd.codeapi.types.CodeType? = null

    constructor(defaults: ClassDeclaration) : this() {
        this.superClass = defaults.superClass
        this.implementations = defaults.implementations
        this.qualifiedName = defaults.qualifiedName
        this.annotations = defaults.annotations
        this.body = defaults.body
        this.modifiers = defaults.modifiers
        this.genericSignature = defaults.genericSignature
        this.outerClass = defaults.outerClass
    }

    fun withSuperClass(value: com.github.jonathanxd.codeapi.types.CodeType?): ClassDeclarationBuilder {
        this.superClass = value
        return this
    }

    fun withImplementations(value: kotlin.collections.List<com.github.jonathanxd.codeapi.types.CodeType>): ClassDeclarationBuilder {
        this.implementations = value
        return this
    }

    fun withQualifiedName(value: kotlin.String): ClassDeclarationBuilder {
        this.qualifiedName = value
        return this
    }

    fun withAnnotations(value: kotlin.collections.List<com.github.jonathanxd.codeapi.base.Annotation>): ClassDeclarationBuilder {
        this.annotations = value
        return this
    }

    fun withBody(value: com.github.jonathanxd.codeapi.CodeSource?): ClassDeclarationBuilder {
        this.body = value
        return this
    }

    fun withModifiers(value: kotlin.collections.List<com.github.jonathanxd.codeapi.common.CodeModifier>): ClassDeclarationBuilder {
        this.modifiers = value
        return this
    }

    fun withGenericSignature(value: com.github.jonathanxd.codeapi.generic.GenericSignature): ClassDeclarationBuilder {
        this.genericSignature = value
        return this
    }

    fun withOuterClass(value: com.github.jonathanxd.codeapi.types.CodeType?): ClassDeclarationBuilder {
        this.outerClass = value
        return this
    }

    override fun build(): ClassDeclaration = ClassDeclarationImpl(
        superClass = this.superClass,
        implementations = this.implementations,
        qualifiedName = this.qualifiedName,
        annotations = this.annotations,
        body = this.body,
        modifiers = this.modifiers,
        genericSignature = this.genericSignature,
        outerClass = this.outerClass
    )
}