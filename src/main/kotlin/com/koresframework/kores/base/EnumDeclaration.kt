/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.koresframework.kores.Instructions
import com.koresframework.kores.base.comment.Comments
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type.eq
import com.koresframework.kores.type.hash
import com.koresframework.kores.util.resolveQualifiedName
import com.koresframework.kores.util.resolveTypeName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type


/**
 * Enum declaration.
 */
@Serializable
data class EnumDeclaration(
    @Serializable(with = TypeSerializer::class) override val outerType: Type?,
    override val comments: Comments,
    override val annotations: List<Annotation>,
    override val modifiers: Set<KoresModifier>,
    override val specifiedName: String,
    override val genericSignature: GenericSignature,
    override val implementations: List<@Serializable(with = TypeSerializer::class) Type>,
    override val entries: List<EnumEntry>,
    override val staticBlock: StaticBlock,
    override val fields: List<FieldDeclaration>,
    override val constructors: List<ConstructorDeclaration>,
    override val methods: List<MethodDeclaration>,
    override val innerTypes: List<TypeDeclaration>
) : TypeDeclaration,
    ImplementationHolder, EntryHolder, ConstructorsHolder {

    override val data: KoresData = KoresData()

    override val qualifiedName: String = specifiedName
        get() = resolveQualifiedName(field, this.outerType)

    @SerialName("enumDeclarationType")
    override val type: String = specifiedName
        get() = resolveTypeName(field, this.outerType)

    /**
     * Gets the ordinal position of [entry]
     */
    fun getOrdinal(entry: EnumEntry) = entries.indexOf(entry)

    /**
     * Gets the ordinal position of [EnumEntry] which matches [entryPredicate]
     */
    fun getOrdinal(entryPredicate: (EnumEntry) -> Boolean) = entries.indexOfFirst(entryPredicate)

    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    override fun builder(): Builder = Builder(this)

    class Builder() : TypeDeclaration.Builder<EnumDeclaration, Builder>,
        ImplementationHolder.Builder<EnumDeclaration, Builder>,
        EntryHolder.Builder<EnumDeclaration, Builder>,
        ConstructorsHolder.Builder<EnumDeclaration, Builder> {

        override var data: KoresData = KoresData()
        override var outerType: Type? = null
        override lateinit var specifiedName: String
        override var comments: Comments = Comments.Absent
        override var annotations: List<Annotation> = emptyList()

        override var staticBlock: StaticBlock = StaticBlock(Comments.Absent, emptyList(), Instructions.empty())
        override var fields: List<FieldDeclaration> = emptyList()
        override var constructors: List<ConstructorDeclaration> = emptyList()
        override var methods: List<MethodDeclaration> = emptyList()
        override var innerTypes: List<TypeDeclaration> = emptyList()

        override var modifiers: Set<KoresModifier> = emptySet()
        override var genericSignature: GenericSignature = GenericSignature.empty()
        override var implementations: List<Type> = emptyList()
        override var entries: List<EnumEntry> = emptyList()

        constructor(defaults: EnumDeclaration) : this() {
            this.outerType = defaults.outerType
            this.specifiedName = defaults.specifiedName
            this.comments = defaults.comments
            this.annotations = defaults.annotations

            this.staticBlock = defaults.staticBlock
            this.fields = defaults.fields
            this.constructors = defaults.constructors
            this.methods = defaults.methods
            this.innerTypes = defaults.innerTypes

            this.modifiers = defaults.modifiers
            this.genericSignature = defaults.genericSignature
            this.implementations = defaults.implementations
            this.entries = defaults.entries

            this.from(defaults)
        }

        override fun buildBasic() = EnumDeclaration(
            this.outerType,
            this.comments,
            this.annotations,
            this.modifiers,
            this.specifiedName,
            this.genericSignature,
            this.implementations,
            this.entries,
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
            fun builder(defaults: EnumDeclaration): Builder = Builder(defaults)
        }

    }

}