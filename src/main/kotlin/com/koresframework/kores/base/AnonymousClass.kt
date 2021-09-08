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

import com.koresframework.kores.Instruction
import com.koresframework.kores.Instructions
import com.koresframework.kores.Types
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.builder.self
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.dataFrom
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.util.eq
import com.koresframework.kores.util.hash
import com.koresframework.kores.util.resolveQualifiedName
import com.koresframework.kores.util.resolveTypeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Anonymous class, they can be defined like all other classes, but some generators may not
 * support all definitions (like multiple [implementations]).
 *
 * The invocation of the constructor of the anonymous class is inlined after the anonymous class definition.
 *
 * @property implementations Implementations of this anonymous class, commonly a single element, but
 * some generators may support multiple implementations.
 * @property superClass Super class of this anonymous class. Some generators may ignore this if [implementations] have
 * at least one type.
 * @property constructorSpec Specification of the constructor of the anonymous class to invoke.
 * @property constructorBody Body of the constructor of anonymous class.
 * @property arguments Arguments to use to invoke constructor of signature specified by [constructorSpec].
 */
@Serializable
data class AnonymousClass(
    override val comments: Comments,
    override val outerType: @Serializable(with = TypeSerializer::class) Type?,
    override val annotations: List<Annotation>,
    override val specifiedName: String,
    override val superClass: @Serializable(with = TypeSerializer::class) Type,
    override val implementations: List<@Serializable(with = TypeSerializer::class) Type>,
    val constructorSpec: TypeSpec,
    override val arguments: List<Instruction>,
    val constructorBody: Instructions,
    override val staticBlock: StaticBlock,
    override val fields: List<FieldDeclaration>,
    override val constructors: List<ConstructorDeclaration>,
    override val methods: List<MethodDeclaration>,
    override val innerTypes: List<TypeDeclaration>
) : TypeDeclaration, SuperClassHolder,
    ArgumentsHolder, ImplementationHolder, ConstructorsHolder {

    override val data: KoresData = KoresData()
    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerType)

    @SerialName("anonymousClassType")
    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerType)

    override val array: Boolean
        get() = false

    override val modifiers: Set<KoresModifier>
        get() = setOf(KoresModifier.PACKAGE_PRIVATE)

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
        ImplementationHolder.Builder<AnonymousClass, Builder>,
        ConstructorsHolder.Builder<AnonymousClass, Builder> {

        override var data: KoresData = KoresData()
        override var comments: Comments = Comments.Absent
        override var outerType: Type? = null
        override var annotations: List<Annotation> = emptyList()
        override lateinit var specifiedName: String
        override var superClass: Type? = Types.OBJECT
        override var implementations: List<Type> = emptyList()
        lateinit var constructorSpec: TypeSpec
        override var arguments: List<Instruction> = emptyList()
        lateinit var constructorBody: Instructions

        override var staticBlock: StaticBlock = StaticBlock(Comments.Absent, emptyList(), Instructions.empty())
        override var fields: List<FieldDeclaration> = emptyList()
        override var constructors: List<ConstructorDeclaration> = emptyList()
        override var methods: List<MethodDeclaration> = emptyList()
        override var innerTypes: List<TypeDeclaration> = emptyList()

        override var modifiers: Set<KoresModifier>
            get() = emptySet()
            set(value) {}

        override var genericSignature: GenericSignature
            get() = GenericSignature.empty()
            set(value) {}

        constructor(defaults: AnonymousClass) : this() {
            this.comments = defaults.comments
            this.outerType = defaults.outerType
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

        override fun modifiers(value: Set<KoresModifier>): Builder = self()
        override fun modifiers(vararg values: KoresModifier): Builder = self()
        override fun array(value: Boolean): Builder = self()
        override fun genericSignature(value: GenericSignature): Builder = self()

        /**
         * See [AnonymousClass.constructorSpec]
         */
        fun constructorSpec(value: TypeSpec): Builder {
            this.constructorSpec = value
            return this
        }

        /**
         * See [AnonymousClass.constructorBody]
         */
        fun constructorBody(value: Instructions): Builder {
            this.constructorBody = value
            return this
        }

        override fun buildBasic(): AnonymousClass = AnonymousClass(
            this.comments,
            this.outerType,
            this.annotations,
            this.specifiedName,
            this.superClass ?: Types.OBJECT,
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
