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

import com.github.jonathanxd.kores.base.comment.CommentHolder
import com.github.jonathanxd.kores.type.KoresType
import com.github.jonathanxd.kores.type.KoresTypeResolver
import com.github.jonathanxd.kores.type.TypeRef
import java.lang.reflect.Type

/**
 * Base class of all [TypeDeclaration]s like classes, interfaces and enums, and inner classes.
 */
interface TypeDeclaration : ModifiersHolder, KoresType, QualifiedNamed, GenericSignatureHolder,
    Annotable,
    CommentHolder, InnerTypesHolder, ElementsHolder {

    /**
     * Outer class (null if this type is not a inner class).
     */
    val outerType: Type?

    /**
     * The specified name (for inner classes this property is the simple name of inner class)
     */
    val specifiedName: String

    /**
     * Qualified name of this class. If this type is an inner type, this will be the
     * qualified name of [outerType] + `.` + [specifiedName] of this type.
     */
    override val qualifiedName: String

    /**
     * Binary type name of this type. If this type is an inner type, this will be the
     * type name of [outerType] + `$` + [specifiedName] of this type.
     */
    override val type: String

    /**
     * Same as [qualifiedName].
     */
    override val canonicalName: String
        get() = this.qualifiedName

    /**
     * Resolver of this type.
     */
    override val defaultResolver: KoresTypeResolver<*>
        get() = KoresTypeResolver.Kores(null)

    /**
     * Inner types of this type.
     */
    override val innerTypes: List<TypeDeclaration>

    override fun builder(): Builder<TypeDeclaration, *>

    interface Builder<out T : TypeDeclaration, S : Builder<T, S>> :
        ModifiersHolder.Builder<T, S>,
        QualifiedNamed.Builder<T, S>,
        GenericSignatureHolder.Builder<T, S>,
        Annotable.Builder<T, S>,
        CommentHolder.Builder<T, S>,
        InnerTypesHolder.Builder<T, S>,
        ElementsHolder.Builder<T, S> {

        override fun qualifiedName(value: String): S = this.specifiedName(value)

        /**
         * See [TypeDeclaration.specifiedName]
         */
        fun specifiedName(value: String): S

        /**
         * See [TypeDeclaration.outerType]
         */
        fun outerType(value: Type?): S

        /**
         * Sets the name and outer type to values specified in [typeRef]
         */
        fun base(typeRef: TypeRef): S =
            this.outerType(typeRef.outerType).specifiedName(typeRef.specifiedName)
    }
}