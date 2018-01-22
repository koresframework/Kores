/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.comment.Comments
import com.github.jonathanxd.codeapi.builder.self
import java.lang.reflect.Type

/**
 * Enumeration entry.
 *
 * @property constructorSpec Enum constructor specification. Null for default enum constructor.
 * @property arguments Enum constructor arguments
 */
data class EnumEntry(
    override val annotations: List<Annotation>,
    override val name: String,
    val constructorSpec: TypeSpec?,
    override val arguments: List<CodeInstruction>,
    override val staticBlock: StaticBlock,
    override val fields: List<FieldDeclaration>,
    override val methods: List<MethodDeclaration>,
    override val innerTypes: List<TypeDeclaration>
) : Annotable, ArgumentsHolder, Named, ElementsHolder {

    override val types: List<Type>
        get() = this.constructorSpec?.parameterTypes ?: emptyList()

    override val array: Boolean
        get() = false

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Annotable.Builder<EnumEntry, Builder>,
        ArgumentsHolder.Builder<EnumEntry, Builder>,
        Named.Builder<EnumEntry, Builder>,
        ElementsHolder.Builder<EnumEntry, Builder> {

        var annotations: List<Annotation> = emptyList()
        lateinit var name: String
        var constructorSpec: TypeSpec? = null
        var arguments: List<CodeInstruction> = emptyList()

        var staticBlock: StaticBlock = StaticBlock(Comments.Absent, emptyList(), CodeSource.empty())
        var fields: List<FieldDeclaration> = emptyList()
        var methods: List<MethodDeclaration> = emptyList()
        var innerTypes: List<TypeDeclaration> = emptyList()

        constructor(defaults: EnumEntry) : this() {
            this.annotations = defaults.annotations
            this.name = defaults.name
            this.constructorSpec = defaults.constructorSpec
            this.arguments = defaults.arguments

            this.staticBlock = defaults.staticBlock
            this.fields = defaults.fields
            this.methods = defaults.methods
            this.innerTypes = defaults.innerTypes

        }

        override fun array(value: Boolean): Builder = self()

        override fun annotations(value: List<Annotation>): Builder {
            this.annotations = value
            return this
        }

        /**
         * See [EnumEntry.constructorSpec]
         */
        fun constructorSpec(value: TypeSpec?): Builder {
            this.constructorSpec = value
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun arguments(value: List<CodeInstruction>): Builder {
            this.arguments = value
            return this
        }


        override fun staticBlock(value: StaticBlock): Builder {
            this.staticBlock = value
            return this
        }

        override fun fields(value: List<FieldDeclaration>): Builder {
            this.fields = value
            return this
        }

        override fun methods(value: List<MethodDeclaration>): Builder {
            this.methods = value
            return this
        }

        override fun innerTypes(value: List<TypeDeclaration>): Builder {
            this.innerTypes = value
            return this
        }

        override fun build(): EnumEntry = EnumEntry(
            this.annotations, this.name, this.constructorSpec, this.arguments, this.staticBlock,
            this.fields, this.methods, this.innerTypes
        )

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: EnumEntry): Builder = Builder(defaults)
        }

    }
}

/**
 * Returns whether the [EnumEntry] has any declaration inside (requires a new type to be created
 * or a body).
 */
val EnumEntry.hasDeclarations
    get() = this.staticBlock.body.isNotEmpty
            || this.fields.isNotEmpty()
            || this.methods.isNotEmpty()
            || this.constructorSpec != null
            || this.innerTypes.isNotEmpty()