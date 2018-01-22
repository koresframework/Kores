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

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.ModifierType.*
import java.lang.reflect.Member
import java.lang.reflect.Modifier

private typealias JavaxModifier = javax.lang.model.element.Modifier

/**
 * Modifiers enum.
 *
 * @property modifierType Type of modifier.
 * @property expr Modifier name.
 */
enum class CodeModifier(val modifierType: ModifierType, expr_: String? = null) : CodePart {

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
        fun fromMember(member: Member): Collection<CodeModifier> {

            val modifiers = member.modifiers

            val collection = fromJavaModifiers(modifiers)

            if (member.declaringClass.isInterface && Modifier.isPublic(modifiers) && !Modifier.isAbstract(
                        modifiers
                    ) && !Modifier.isStatic(modifiers)
            ) {
                collection.add(CodeModifier.DEFAULT)
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
        fun fromJavaModifiers(modifiers: Int): MutableSet<CodeModifier> {
            val collection = java.util.TreeSet<CodeModifier>()

            when {
                Modifier.isPublic(modifiers) -> collection.add(CodeModifier.PUBLIC)
                Modifier.isPrivate(modifiers) -> collection.add(CodeModifier.PRIVATE)
                Modifier.isProtected(modifiers) -> collection.add(CodeModifier.PROTECTED)
                else -> collection.add(CodeModifier.PACKAGE_PRIVATE)
            }


            if (Modifier.isAbstract(modifiers)) {
                collection.add(CodeModifier.ABSTRACT)
            }


            if (Modifier.isStatic(modifiers)) {
                collection.add(CodeModifier.STATIC)
            }


            if (Modifier.isFinal(modifiers)) {
                collection.add(CodeModifier.FINAL)
            }


            if (Modifier.isTransient(modifiers)) {
                collection.add(CodeModifier.TRANSIENT)
            }


            if (Modifier.isVolatile(modifiers)) {
                collection.add(CodeModifier.VOLATILE)
            }


            if (Modifier.isSynchronized(modifiers)) {
                collection.add(CodeModifier.SYNCHRONIZED)
            }


            if (Modifier.isNative(modifiers)) {
                collection.add(CodeModifier.NATIVE)
            }


            if (Modifier.isStrict(modifiers)) {
                collection.add(CodeModifier.STRICTFP)
            }

            if (Internal.isBridge(modifiers)) {
                collection.add(CodeModifier.BRIDGE)
            }

            if (Internal.isVarArgs(modifiers)) {
                collection.add(CodeModifier.VARARGS)
            }

            if (Internal.isSynthetic(modifiers)) {
                collection.add(CodeModifier.SYNTHETIC)
            }

            if (Internal.isAnnotation(modifiers)) {
                collection.add(CodeModifier.ANNOTATION)
            }

            if (Internal.isEnum(modifiers)) {
                collection.add(CodeModifier.ENUM)
            }

            if (Internal.isMandated(modifiers)) {
                collection.add(CodeModifier.MANDATED)
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
        fun fromJavaxModifiers(modifiers: Iterable<JavaxModifier>): MutableSet<CodeModifier> {
            val collection = java.util.TreeSet<CodeModifier>()

            when {
                modifiers.contains(JavaxModifier.PUBLIC) -> collection.add(CodeModifier.PUBLIC)
                modifiers.contains(JavaxModifier.PRIVATE) -> collection.add(CodeModifier.PRIVATE)
                modifiers.contains(JavaxModifier.PROTECTED) -> collection.add(CodeModifier.PROTECTED)
                else -> collection.add(CodeModifier.PACKAGE_PRIVATE)
            }


            if (modifiers.contains(JavaxModifier.ABSTRACT)) {
                collection.add(CodeModifier.ABSTRACT)
            }


            if (modifiers.contains(JavaxModifier.STATIC)) {
                collection.add(CodeModifier.STATIC)
            }


            if (modifiers.contains(JavaxModifier.FINAL)) {
                collection.add(CodeModifier.FINAL)
            }


            if (modifiers.contains(JavaxModifier.TRANSIENT)) {
                collection.add(CodeModifier.TRANSIENT)
            }


            if (modifiers.contains(JavaxModifier.VOLATILE)) {
                collection.add(CodeModifier.VOLATILE)
            }


            if (modifiers.contains(JavaxModifier.SYNCHRONIZED)) {
                collection.add(CodeModifier.SYNCHRONIZED)
            }


            if (modifiers.contains(JavaxModifier.NATIVE)) {
                collection.add(CodeModifier.NATIVE)
            }


            if (modifiers.contains(JavaxModifier.STRICTFP)) {
                collection.add(CodeModifier.STRICTFP)
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
        fun toString(collection: Collection<CodeModifier>?): String {
            return collection?.sorted()?.map { it.name.toLowerCase() }?.joinToString(" ") ?: ""
        }

        /**
         * Convert [CodeModifier]s to Java Modifiers flags.
         *
         * @param modifiers Modifiers
         * @return Java modifiers flags ([Modifier])
         */
        @JvmStatic
        fun toJavaModifier(modifiers: Collection<CodeModifier>): Int {
            val mods = modifiers.toMutableList()

            if (!mods.contains(CodeModifier.PACKAGE_PRIVATE) && !mods.contains(CodeModifier.PUBLIC))
                mods.add(CodeModifier.PUBLIC)

            return mods.map { toJavaModifier(it) }
                .filter { it != 0 }
                .reduce { acc, i -> acc or i }
        }

        /**
         * Convert a [CodeModifier] to Java Modifiers flags.
         *
         * @param codeModifier Modifier to convert
         * @return Java modifiers flags ([Modifier])
         */
        @JvmStatic
        fun toJavaModifier(codeModifier: CodeModifier): Int {
            when (codeModifier) {
                CodeModifier.ABSTRACT -> return Modifier.ABSTRACT
                CodeModifier.FINAL -> return Modifier.FINAL
                CodeModifier.NATIVE -> return Modifier.NATIVE
                CodeModifier.PRIVATE -> return Modifier.PRIVATE
                CodeModifier.PROTECTED -> return Modifier.PROTECTED
                CodeModifier.PUBLIC -> return Modifier.PUBLIC
                CodeModifier.STATIC -> return Modifier.STATIC
                CodeModifier.STRICTFP -> return Modifier.STRICT
                CodeModifier.SYNCHRONIZED -> return Modifier.SYNCHRONIZED
                CodeModifier.TRANSIENT -> return Modifier.TRANSIENT
                CodeModifier.VOLATILE -> return Modifier.VOLATILE
                CodeModifier.BRIDGE -> return Internal.BRIDGE
                CodeModifier.VARARGS -> return Internal.VARARGS
                CodeModifier.SYNTHETIC -> return Internal.SYNTHETIC
                CodeModifier.ANNOTATION -> return Internal.ANNOTATION
                CodeModifier.ENUM -> return Internal.ENUM
                CodeModifier.MANDATED -> return Internal.MANDATED
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