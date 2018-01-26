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
package com.github.jonathanxd.kores.type

import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.util.GenericResolver
import com.github.jonathanxd.kores.util.eq
import com.github.jonathanxd.kores.util.hash
import com.github.jonathanxd.kores.util.toStr
import com.github.jonathanxd.iutils.kt.rightOrFail
import java.lang.reflect.Type
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.element.TypeParameterElement
import javax.lang.model.type.*
import javax.lang.model.util.Elements

fun TypeElement.getKoresType(elements: Elements): KoresType =
    TypeElementKoresType(this, elements)

fun TypeMirror.getKoresType(elements: Elements): KoresType = this.toKoresType(false, elements)

fun TypeMirror.toKoresType(isParameterized: Boolean, elements: Elements): KoresType {

    fun parseIntersection(
        intersectionType: IntersectionType,
        isSuper: Boolean
    ): Array<GenericType.Bound> =
        intersectionType.bounds.map {
            if (isSuper)
                GenericType.Super(it.toKoresType(false, elements))
            else
                GenericType.Extends(it.toKoresType(false, elements))
        }.toTypedArray()

    return when (this) {
        is NoType, is PrimitiveType -> when (this.kind) {
            TypeKind.BOOLEAN -> Types.BOOLEAN
            TypeKind.BYTE -> Types.BYTE
            TypeKind.SHORT -> Types.SHORT
            TypeKind.INT -> Types.INT
            TypeKind.FLOAT -> Types.FLOAT
            TypeKind.DOUBLE -> Types.DOUBLE
            TypeKind.LONG -> Types.LONG
            TypeKind.VOID -> Types.VOID
            else -> throw IllegalArgumentException("Unknown primitive type $this!")
        }
        is javax.lang.model.type.NullType -> NullType
        is WildcardType -> {
            var generic = Generic.wildcard()

            val superBound = this.superBound

            if (superBound is DeclaredType && superBound.toString() != "java.lang.Object")
                generic = generic.`super$`(superBound.toKoresType(false, elements))
            else if (superBound is IntersectionType)
                generic = generic.of(*parseIntersection(superBound, true))

            val extendBound = this.extendsBound

            if (extendBound is DeclaredType && extendBound.toString() != "java.lang.Object")
                generic = generic.`extends$`(extendBound.toKoresType(false, elements))
            else if (extendBound is IntersectionType)
                generic = generic.of(*parseIntersection(extendBound, false))

            generic
        }
        is DeclaredType -> Generic.type((this.asElement() as TypeElement).getKoresType(elements)).of(
            *this.typeArguments.map {
                it.toKoresType(
                    true,
                    elements
                )
            }.filter { !it.`is`(Types.OBJECT) }.toTypedArray()
        )
        is ArrayType -> {
            val str = this.toString()
            val index = str.indexOf("[]")
            val dimensions = str.substring(index).length / 2

            Generic.type(this.componentType.toKoresType(true, elements)).toArray(dimensions)
        }
        is TypeVariable -> {
            var type = Generic.type(this.toString())

            if (isParameterized)
                return type

            val superBound = this.lowerBound

            if (superBound is DeclaredType && superBound.toString() != "java.lang.Object")
                type = type.`super$`(superBound.toKoresType(false, elements))
            else if (superBound is IntersectionType)
                type = type.of(*parseIntersection(superBound, true))

            val extendBound = this.upperBound

            if (extendBound is DeclaredType && extendBound.toString() != "java.lang.Object")
                type = type.`extends$`(extendBound.toKoresType(false, elements))
            else if (extendBound is IntersectionType)
                type = type.of(*parseIntersection(extendBound, false))

            type
        }
        else -> throw IllegalArgumentException("Cannot convert '$this' (type: '${this::class.java.canonicalName}') to KoresType.")

    }
}

private fun TypeParameterElement.getType(
    isParameterized: Boolean = false,
    elements: Elements
): KoresType {
    return (this.asType() as TypeVariable).toKoresType(isParameterized, elements)
}


fun TypeElement.getKoresTypeFromTypeParameters(elements: Elements): KoresType {
    var generic = Generic.type(this.getKoresType(elements))

    this.typeParameters.forEach {
        generic = generic.of(it.getType(false, elements))
    }

    return generic
}

internal class TypeElementKoresType(val typeElement: TypeElement, val elements: Elements) :
    KoresType {

    override val isArray: Boolean
        get() = false

    override val isVirtual: Boolean
        get() = true

    override val type: String
        get() = this.typeElement.typeName

    override val canonicalName: String
        get() = this.typeElement.qualifiedName.toString()

    override val isInterface: Boolean
        get() = this.typeElement.kind == ElementKind.INTERFACE

    override val isPrimitive: Boolean
        get() = false

    override fun toString(): String = this.toStr()
    override fun hashCode(): Int = this.hash()
    override fun equals(other: Any?): Boolean = this.eq(other)

    override val defaultResolver: KoresTypeResolver<TypeElement?>
        get() = KoresTypeResolver.Model(elements)

}

val TypeElement.typeName: String
    get() {
        val element = (this.enclosingElement as? TypeElement)
        return if (element != null) "${element.typeName}\$${this.simpleName}" else this.qualifiedName.toString()
    }


class ModelResolver(val elements: Elements) : GenericResolver {

    override fun resolveTypeWithParameters(
        type: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val resolved = type.koresType

        val resolve: Any? = koresTypeResolver.resolve(resolved.concreteType).rightOrFail

        if (resolve is TypeElement) {
            return resolve.asType().getKoresType(elements).asGeneric
        }

        throw IllegalStateException("$type must be a Javax Annotation Model TypeElement.")
    }

    override fun resolveGenericTypeImplementation(
        superType: Type, implemented: Type,
        koresTypeResolver: KoresTypeResolver<*>
    ): GenericType {
        val superKoresType = superType.koresType

        val resolvedSuperType: Any? =
            koresTypeResolver.resolve(superKoresType.concreteType).rightOrFail

        if (resolvedSuperType is TypeElement) {

            if (resolvedSuperType.superclass.kind != TypeKind.NONE
                    && resolvedSuperType.superclass.getKoresType(elements).concreteType.`is`(
                        implemented.concreteType
                    )
            ) {
                return resolvedSuperType.superclass.getKoresType(elements).asGeneric
            }

            val itfs = resolvedSuperType.interfaces

            for (i in itfs.indices) {
                val itf = itfs[i]

                if (itf.getKoresType(elements).concreteType.`is`(implemented.concreteType)) {
                    return itf.getKoresType(elements).asGeneric
                }
            }

            throw IllegalStateException("Can't find '$implemented' in superclasses and superinterfaces of '$resolvedSuperType'.")
        }

        throw IllegalStateException("Super type $superType which implements $implemented must be a Javax Annotation Model TypeElement.")
    }

}