/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.base

import java.lang.reflect.Type

/**
 * Reference to a module or a package.
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

        override fun name(value: String): Builder {
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
 * @property modifiers Modifiers of the module. Valid modifiers are [KoresModifier.OPEN],
 * [KoresModifier.SYNTHETIC] and [KoresModifier.MANDATED].
 * @property name Module name.
 * @property version Module version. (null means no version).
 * @property requires Module requires.
 * @property exports Module exports.
 * @property uses Module service uses.
 * @property provides Module service provides.
 */
data class ModuleDeclaration(
    override val modifiers: Set<KoresModifier>,
    override val name: String,
    val version: String?,
    val requires: List<Require>,
    val exports: List<Export>,
    val opens: List<Open>,
    val uses: List<ModuleReference>,
    val provides: List<Provide>
) : Named, ModifiersHolder {


    /**
     * Module reference.
     */
    val moduleReference: ModuleReference = ModuleReference(this.name)

    override fun builder(): Builder = Builder()

    class Builder() : Named.Builder<ModuleDeclaration, Builder>,
        ModifiersHolder.Builder<ModuleDeclaration, Builder> {

        var modifiers: Set<KoresModifier> = emptySet()
        lateinit var name: String
        var version: String? = null
        var requires: List<Require> = emptyList()
        var exports: List<Export> = emptyList()
        var opens: List<Open> = emptyList()
        var uses: List<ModuleReference> = emptyList()
        var provides: List<Provide> = emptyList()

        constructor(defaults: ModuleDeclaration) : this() {
            this.modifiers = defaults.modifiers
            this.name = defaults.name
            this.version = defaults.version
            this.requires = defaults.requires
            this.exports = defaults.exports
            this.opens = defaults.opens
            this.uses = defaults.uses
            this.provides = defaults.provides
        }

        override fun modifiers(value: Set<KoresModifier>): Builder {
            this.modifiers = value
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        /**
         * See [ModuleDeclaration.version]
         */
        fun version(value: String): Builder {
            this.version = value
            return this
        }

        // Requires

        /**
         * See [ModuleDeclaration.requires]
         */
        fun requires(value: List<Require>): Builder {
            this.requires = value
            return this
        }

        /**
         * See [ModuleDeclaration.requires]
         */
        fun requires(vararg values: Require): Builder = this.requires(values.toList())

        /**
         * See [ModuleDeclaration.requires]
         */
        fun requires(vararg values: String): Builder =
            this.requires(values.map { Require(ModuleReference(it), emptySet(), null) })

        // Exports

        /**
         * See [ModuleDeclaration.exports]
         */
        fun exports(value: List<Export>): Builder {
            this.exports = value
            return this
        }

        /**
         * See [ModuleDeclaration.exports]
         */
        fun exports(vararg values: Export): Builder = this.exports(values.toList())

        /**
         * See [ModuleDeclaration.exports]
         */
        fun exports(vararg values: String): Builder = this.exports(values.map {
            Export(ModuleReference(it), emptyList(), emptySet())
        })

        // Exports

        /**
         * See [ModuleDeclaration.opens]
         */
        fun opens(value: List<Open>): Builder {
            this.opens = value
            return this
        }

        /**
         * See [ModuleDeclaration.opens]
         */
        fun opens(vararg values: Open): Builder = this.opens(values.toList())

        /**
         * See [ModuleDeclaration.opens]
         */
        fun opens(vararg values: String): Builder =
            this.opens(values.map { Open(ModuleReference(it), emptyList(), emptySet()) })

        // Uses

        /**
         * See [ModuleDeclaration.uses]
         */
        fun uses(value: List<ModuleReference>): Builder {
            this.uses = value
            return this
        }

        /**
         * See [ModuleDeclaration.uses]
         */
        fun uses(vararg values: ModuleReference): Builder = this.uses(values.toList())

        /**
         * See [ModuleDeclaration.uses]
         */
        fun uses(vararg values: String): Builder = this.uses(values.map(::ModuleReference))

        // Provides

        /**
         * See [ModuleDeclaration.provides]
         */
        fun provides(value: List<Provide>): Builder {
            this.provides = value
            return this
        }

        /**
         * See [ModuleDeclaration.provides]
         */
        fun provides(vararg values: Provide): Builder = this.provides(values.toList())

        /**
         * See [ModuleDeclaration.provides]
         */
        fun provides(vararg values: Pair<Type, List<Type>>): Builder = this.provides(values.map {
            Provide(it.first, it.second)
        })


        override fun build(): ModuleDeclaration = ModuleDeclaration(
            this.modifiers, this.name, this.version, this.requires,
            this.exports, this.opens, this.uses, this.provides
        )

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
 * @property modifiers Modifiers. Valid modifiers are [KoresModifier.STATIC_PHASE], [KoresModifier.TRANSITIVE]
 * [KoresModifier.SYNTHETIC] and [KoresModifier.MANDATED].
 * @property version Module required version.
 */
data class Require(
    val module: ModuleReference,
    val modifiers: Set<KoresModifier>,
    val version: String?
)

/**
 * Exports [module] to modules [to].
 *
 * @property module Module to export.
 * @property to Modules to export to. (Empty list to export to all modules).
 * @property modifiers Modifiers. Valid modifiers are [KoresModifier.SYNTHETIC] and [KoresModifier.MANDATED]
 */
data class Export(
    val module: ModuleReference,
    val to: List<ModuleReference>,
    val modifiers: Set<KoresModifier>
)

/**
 * Provides [with] to service [service].
 *
 * @property service Service to provide implementation.
 * @property with Service implementations/providers.
 */
data class Provide(val service: Type, val with: List<Type>)

/**
 * Opens [module] to modules [to].
 *
 * @property Module Package to open, allowing reflection.
 * @property to Modules to open to, allowing reflective access. (Empty list to open to all modules).
 * @property modifiers Modifiers. Valid modifiers are [KoresModifier.SYNTHETIC] and [KoresModifier.MANDATED]
 */
data class Open(
    val module: ModuleReference,
    val to: List<ModuleReference>,
    val modifiers: Set<KoresModifier>
)