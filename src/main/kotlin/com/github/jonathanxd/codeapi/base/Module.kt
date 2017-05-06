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

import java.lang.reflect.Type

/**
 * Reference to a module
 *
 * @property name Qualified name of module.
 */
data class ModuleReference(override val name: String) : Named {

    override fun builder(): Builder = Builder()

    class Builder() : Named.Builder<ModuleReference, Builder> {
        lateinit var name: String

        constructor(defaults: ModuleReference) : this() {
            this.name = defaults.name
        }

        override fun withName(value: String): Builder {
            this.name = value
            return this
        }

        override fun build(): ModuleReference = ModuleReference(this.name)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ModuleReference): Builder = Builder(defaults)
        }
    }

}

/**
 * Declaration of a module.
 *
 * @property name Module name.
 * @property requires Module requires.
 * @property exports Module exports.
 * @property uses Module service uses.
 * @property provides Module service provides.
 */
data class ModuleDeclaration(override val name: String,
                             val requires: List<Require>,
                             val exports: List<Export>,
                             val uses: List<ModuleReference>,
                             val provides: List<Provide>) : Named {

    /**
     * Module reference.
     */
    val moduleReference: ModuleReference = ModuleReference(this.name)

    override fun builder(): Builder = Builder()

    class Builder() : Named.Builder<ModuleDeclaration, Builder> {

        lateinit var name: String
        var requires: List<Require> = emptyList()
        var exports: List<Export> = emptyList()
        var uses: List<ModuleReference> = emptyList()
        var provides: List<Provide> = emptyList()

        constructor(defaults: ModuleDeclaration) : this() {
            this.name = defaults.name
            this.requires = defaults.requires
            this.exports = defaults.exports
            this.uses = defaults.uses
            this.provides = defaults.provides
        }

        override fun withName(value: String): Builder {
            this.name = value
            return this
        }

        // Requires

        /**
         * See [ModuleDeclaration.requires]
         */
        fun withRequires(value: List<Require>): Builder {
            this.requires = value
            return this
        }

        /**
         * See [ModuleDeclaration.requires]
         */
        fun withRequires(vararg values: Require): Builder = this.withRequires(values.toList())

        /**
         * See [ModuleDeclaration.requires]
         */
        fun withRequires(vararg values: String): Builder = this.withRequires(values.map { Require(ModuleReference(it), emptySet()) })

        // Exports

        /**
         * See [ModuleDeclaration.exports]
         */
        fun withExports(value: List<Export>): Builder {
            this.exports = value
            return this
        }

        /**
         * See [ModuleDeclaration.exports]
         */
        fun withExports(vararg values: Export): Builder = this.withExports(values.toList())

        /**
         * See [ModuleDeclaration.exports]
         */
        fun withExports(vararg values: String): Builder = this.withExports(values.map { Export(ModuleReference(it), emptyList()) })

        // Uses

        /**
         * See [ModuleDeclaration.uses]
         */
        fun withUses(value: List<ModuleReference>): Builder {
            this.uses = value
            return this
        }

        /**
         * See [ModuleDeclaration.uses]
         */
        fun withUses(vararg values: ModuleReference): Builder = this.withUses(values.toList())

        /**
         * See [ModuleDeclaration.uses]
         */
        fun withUses(vararg values: String): Builder = this.withUses(values.map(::ModuleReference))

        // Provides

        /**
         * See [ModuleDeclaration.provides]
         */
        fun withProvides(value: List<Provide>): Builder {
            this.provides = value
            return this
        }

        /**
         * See [ModuleDeclaration.provides]
         */
        fun withProvides(vararg values: Provide): Builder = this.withProvides(values.toList())

        /**
         * See [ModuleDeclaration.provides]
         */
        fun withProvides(vararg values: Pair<Type, Type>): Builder = this.withProvides(values.map {
            Provide(it.first, it.second)
        })


        override fun build(): ModuleDeclaration = ModuleDeclaration(this.name, this.requires, this.exports, this.uses, this.provides)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ModuleDeclaration): Builder = Builder(defaults)
        }
    }
}

/**
 * Module requires statement
 *
 * @property module Module to require.
 * @property modifiers Modifiers.
 */
data class Require(val module: ModuleReference, val modifiers: Set<CodeModifier>)

/**
 * Exports [module] to modules [to].
 *
 * @property module Modules to export.
 * @property to Modules to export to. (Empty list to export to all modules).
 */
data class Export(val module: ModuleReference, val to: List<ModuleReference>)

/**
 * Provides [with] to service [service].
 *
 * @property service Service to provide implementation.
 * @property with Service implementation/provider.
 */
data class Provide(val service: Type, val with: Type)