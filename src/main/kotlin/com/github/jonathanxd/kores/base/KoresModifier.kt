/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.KoresPart
import com.github.jonathanxd.kores.base.ModifierType.*
import java.lang.reflect.Member
import java.lang.reflect.Modifier

private typealias JavaxModifier = javax.lang.model.element.Modifier

/**
 * Modifiers enum.
 *
 * @property modifierType Type of modifier.
 * @property expr Modifier name.
 */
enum class KoresModifier(val modifierType: ModifierType, expr_: String? = null) : KoresPart {

    PUBLIC(VISIBILITY), PROTECTED(VISIBILITY), PRIVATE(VISIBILITY), PACKAGE_PRIVATE(VISIBILITY, ""),
    ABSTRACT(ABSTRACTION), DEFAULT(ABSTRACTION),
    STATIC(OTHER), FINAL(OTHER),
    TRANSIENT(SERIALIZATION),
    VOLATILE(CONCURRENCY), SYNCHRONIZED(CONCURRENCY),
    NATIVE(OTHER), STRICTFP(OTHER),
    BRIDGE(OTHER), VARARGS(OTHER),
    SYNTHETIC(OTHER), ANNOTATION(OTHER),
    ENUM(OTHER), MANDATED(OTHER),
    // Java 9 modules. Synthetic and Mandated are also module modifiers.
    OPEN(MODULE),
    TRANSITIVE(MODULE),
    // Compile-time only dependency
    STATIC_PHASE(MODULE);

    val expr: String = expr_ ?: this.name.toLowerCase()

    companion object {
        /**
         * Extract modifiers from a [Member]
         *
         * @param member Member
         * @return Sorted Collection of modifiers
         */
        @JvmStatic
        fun fromMember(member: Member): Collection<KoresModifier> {

            val modifiers = member.modifiers

            val collection = fromJavaModifiers(modifiers)

            if (member.declaringClass.isInterface && Modifier.isPublic(modifiers) && !Modifier.isAbstract(
                        modifiers
                    ) && !Modifier.isStatic(modifiers)
            ) {
                collection.add(KoresModifier.DEFAULT)
            }


            return collection
        }

        /**
         * Extract modifiers from Java modifiers flags ([Modifier]).
         *
         * @param modifiers Modifiers flags.
         * @return Sorted Collection of modifiers.
         */
        @JvmStatic
        fun fromJavaModifiers(modifiers: Int): MutableSet<KoresModifier> {
            val collection = java.util.TreeSet<KoresModifier>()

            when {
                Modifier.isPublic(modifiers) -> collection.add(KoresModifier.PUBLIC)
                Modifier.isPrivate(modifiers) -> collection.add(KoresModifier.PRIVATE)
                Modifier.isProtected(modifiers) -> collection.add(KoresModifier.PROTECTED)
                else -> collection.add(KoresModifier.PACKAGE_PRIVATE)
            }


            if (Modifier.isAbstract(modifiers)) {
                collection.add(KoresModifier.ABSTRACT)
            }


            if (Modifier.isStatic(modifiers)) {
                collection.add(KoresModifier.STATIC)
            }


            if (Modifier.isFinal(modifiers)) {
                collection.add(KoresModifier.FINAL)
            }


            if (Modifier.isTransient(modifiers)) {
                collection.add(KoresModifier.TRANSIENT)
            }


            if (Modifier.isVolatile(modifiers)) {
                collection.add(KoresModifier.VOLATILE)
            }


            if (Modifier.isSynchronized(modifiers)) {
                collection.add(KoresModifier.SYNCHRONIZED)
            }


            if (Modifier.isNative(modifiers)) {
                collection.add(KoresModifier.NATIVE)
            }


            if (Modifier.isStrict(modifiers)) {
                collection.add(KoresModifier.STRICTFP)
            }

            if (Internal.isBridge(modifiers)) {
                collection.add(KoresModifier.BRIDGE)
            }

            if (Internal.isVarArgs(modifiers)) {
                collection.add(KoresModifier.VARARGS)
            }

            if (Internal.isSynthetic(modifiers)) {
                collection.add(KoresModifier.SYNTHETIC)
            }

            if (Internal.isAnnotation(modifiers)) {
                collection.add(KoresModifier.ANNOTATION)
            }

            if (Internal.isEnum(modifiers)) {
                collection.add(KoresModifier.ENUM)
            }

            if (Internal.isMandated(modifiers)) {
                collection.add(KoresModifier.MANDATED)
            }

            return collection
        }

        /**
         * Extract modifiers from Javax model modifiers ([Modifier]).
         *
         * @param modifiers Modifiers.
         * @return Sorted Collection of modifiers.
         */
        @JvmStatic
        fun fromJavaxModifiers(modifiers: Iterable<JavaxModifier>): MutableSet<KoresModifier> {
            val collection = java.util.TreeSet<KoresModifier>()

            when {
                modifiers.contains(JavaxModifier.PUBLIC) -> collection.add(KoresModifier.PUBLIC)
                modifiers.contains(JavaxModifier.PRIVATE) -> collection.add(KoresModifier.PRIVATE)
                modifiers.contains(JavaxModifier.PROTECTED) -> collection.add(KoresModifier.PROTECTED)
                else -> collection.add(KoresModifier.PACKAGE_PRIVATE)
            }


            if (modifiers.contains(JavaxModifier.ABSTRACT)) {
                collection.add(KoresModifier.ABSTRACT)
            }


            if (modifiers.contains(JavaxModifier.STATIC)) {
                collection.add(KoresModifier.STATIC)
            }


            if (modifiers.contains(JavaxModifier.FINAL)) {
                collection.add(KoresModifier.FINAL)
            }


            if (modifiers.contains(JavaxModifier.TRANSIENT)) {
                collection.add(KoresModifier.TRANSIENT)
            }


            if (modifiers.contains(JavaxModifier.VOLATILE)) {
                collection.add(KoresModifier.VOLATILE)
            }


            if (modifiers.contains(JavaxModifier.SYNCHRONIZED)) {
                collection.add(KoresModifier.SYNCHRONIZED)
            }


            if (modifiers.contains(JavaxModifier.NATIVE)) {
                collection.add(KoresModifier.NATIVE)
            }


            if (modifiers.contains(JavaxModifier.STRICTFP)) {
                collection.add(KoresModifier.STRICTFP)
            }

            return collection
        }

        /**
         * Modifiers to String
         *
         * @param collection Modifiers
         * @return String containing all modifiers name.
         */
        @JvmStatic
        fun toString(collection: Collection<KoresModifier>?): String =
            collection
                ?.filter { it.expr.isNotEmpty() }
                ?.sorted()
                ?.joinToString(" ") { it.expr } ?: ""


        /**
         * Convert [KoresModifier]s to Java Modifiers flags.
         *
         * @param modifiers Modifiers
         * @return Java modifiers flags ([Modifier])
         */
        @JvmStatic
        fun toJavaModifier(modifiers: Collection<KoresModifier>): Int {
            val mods = modifiers.toMutableList()

            if (!mods.contains(KoresModifier.PACKAGE_PRIVATE) && !mods.contains(KoresModifier.PUBLIC))
                mods.add(KoresModifier.PUBLIC)

            return mods.map { toJavaModifier(it) }
                .filter { it != 0 }
                .reduce { acc, i -> acc or i }
        }

        /**
         * Convert a [KoresModifier] to Java Modifiers flags.
         *
         * @param codeModifier Modifier to convert
         * @return Java modifiers flags ([Modifier])
         */
        @JvmStatic
        fun toJavaModifier(codeModifier: KoresModifier): Int {
            when (codeModifier) {
                KoresModifier.ABSTRACT -> return Modifier.ABSTRACT
                KoresModifier.FINAL -> return Modifier.FINAL
                KoresModifier.NATIVE -> return Modifier.NATIVE
                KoresModifier.PRIVATE -> return Modifier.PRIVATE
                KoresModifier.PROTECTED -> return Modifier.PROTECTED
                KoresModifier.PUBLIC -> return Modifier.PUBLIC
                KoresModifier.STATIC -> return Modifier.STATIC
                KoresModifier.STRICTFP -> return Modifier.STRICT
                KoresModifier.SYNCHRONIZED -> return Modifier.SYNCHRONIZED
                KoresModifier.TRANSIENT -> return Modifier.TRANSIENT
                KoresModifier.VOLATILE -> return Modifier.VOLATILE
                KoresModifier.BRIDGE -> return Internal.BRIDGE
                KoresModifier.VARARGS -> return Internal.VARARGS
                KoresModifier.SYNTHETIC -> return Internal.SYNTHETIC
                KoresModifier.ANNOTATION -> return Internal.ANNOTATION
                KoresModifier.ENUM -> return Internal.ENUM
                KoresModifier.MANDATED -> return Internal.MANDATED
                else -> return 0
            }
        }
    }

    object Internal {
        @JvmField
        val BRIDGE = 0x00000040

        @JvmField
        val VARARGS = 0x00000080

        @JvmField
        val SYNTHETIC = 0x00001000

        @JvmField
        val ANNOTATION = 0x00002000

        @JvmField
        val ENUM = 0x00004000

        @JvmField
        val MANDATED = 0x00008000

        @JvmStatic
        fun isBridge(modifiers: Int): Boolean {
            return modifiers and BRIDGE != 0
        }

        @JvmStatic
        fun isVarArgs(modifiers: Int): Boolean {
            return modifiers and VARARGS != 0
        }

        @JvmStatic
        fun isSynthetic(modifiers: Int): Boolean {
            return modifiers and SYNTHETIC != 0
        }

        @JvmStatic
        fun isAnnotation(modifiers: Int): Boolean {
            return modifiers and ANNOTATION != 0
        }

        @JvmStatic
        fun isEnum(modifiers: Int): Boolean {
            return modifiers and ENUM != 0
        }

        @JvmStatic
        fun isMandated(modifiers: Int): Boolean {
            return modifiers and MANDATED != 0
        }
    }
}

/**
 * Modifier type enum.
 */
enum class ModifierType {

    /**
     * - No Visibility Modifiers
     *
     * - Public, Protected Private
     */
    VISIBILITY,

    /**
     * - Synchronized
     *
     * - Volatile
     */
    CONCURRENCY,

    /**
     * - Transient
     */
    SERIALIZATION,

    /**
     * - Default
     *
     * - Abstract
     */
    ABSTRACTION,

    /**
     * - Other Modifiers like: Static, Final
     */
    OTHER,

    /**
     * Java 9 module modifiers
     */
    MODULE

}