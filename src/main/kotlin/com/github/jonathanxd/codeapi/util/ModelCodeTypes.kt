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
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.type.*
import com.github.jonathanxd.codeapi.type.CodeTypeResolver
import com.github.jonathanxd.codeapi.type.NullType
import java.lang.reflect.Type
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.element.TypeParameterElement
import javax.lang.model.type.*
import javax.lang.model.util.Elements

fun TypeElement.getCodeType(elements: Elements): CodeType = TypeElementCodeType(this, elements)

fun TypeMirror.getCodeType(elements: Elements): CodeType = this.toCodeType(false, elements)

fun TypeMirror.toCodeType(isParameterized: Boolean, elements: Elements): CodeType {

    fun parseIntersection(intersectionType: IntersectionType, isSuper: Boolean): Array<GenericType.Bound> =
            intersectionType.bounds.map {
                if (isSuper)
                    GenericType.Super(it.toCodeType(false, elements))
                else
                    GenericType.Extends(it.toCodeType(false, elements))
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
                generic = generic.`super$`(superBound.toCodeType(false, elements))
            else if (superBound is IntersectionType)
                generic = generic.of(*parseIntersection(superBound, true))

            val extendBound = this.extendsBound

            if (extendBound is DeclaredType && extendBound.toString() != "java.lang.Object")
                generic = generic.`extends$`(extendBound.toCodeType(false, elements))
            else if (extendBound is IntersectionType)
                generic = generic.of(*parseIntersection(extendBound, false))

            generic
        }
        is DeclaredType -> Generic.type((this.asElement() as TypeElement).getCodeType(elements)).of(*this.typeArguments.map { it.toCodeType(true, elements) }.filter { !it.`is`(Types.OBJECT) }.toTypedArray())
        is ArrayType -> {
            val str = this.toString()
            val index = str.indexOf("[]")
            val dimensions = str.substring(index).length / 2

            Generic.type(this.componentType.toCodeType(true, elements)).toArray(dimensions)
        }
        is TypeVariable -> {
            var type = Generic.type(this.toString())

            if (isParameterized)
                return type

            val superBound = this.lowerBound

            if (superBound is DeclaredType && superBound.toString() != "java.lang.Object")
                type = type.`super$`(superBound.toCodeType(false, elements))
            else if (superBound is IntersectionType)
                type = type.of(*parseIntersection(superBound, true))

            val extendBound = this.upperBound

            if (extendBound is DeclaredType && extendBound.toString() != "java.lang.Object")
                type = type.`extends$`(extendBound.toCodeType(false, elements))
            else if (extendBound is IntersectionType)
                type = type.of(*parseIntersection(extendBound, false))

            type
        }
        else -> throw IllegalArgumentException("Cannot convert '$this' (type: '${this::class.java.canonicalName}') to CodeType.")

    }
}

private fun TypeParameterElement.getType(isParameterized: Boolean = false, elements: Elements): CodeType {
    return (this.asType() as TypeVariable).toCodeType(isParameterized, elements)
}


fun TypeElement.getCodeTypeFromTypeParameters(elements: Elements): CodeType {
    var generic = Generic.type(this.getCodeType(elements))

    this.typeParameters.forEach {
        generic = generic.of(it.getType(false, elements))
    }

    return generic
}

internal class TypeElementCodeType(val typeElement: TypeElement, val elements: Elements) : CodeType {

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

    override val defaultResolver: CodeTypeResolver<TypeElement?>
        get() = CodeTypeResolver.Model(elements)

}

val TypeElement.typeName: String
    get() {
        val element = (this.enclosingElement as? TypeElement)
        return if (element != null) "${element.typeName}\$${this.simpleName}" else this.qualifiedName.toString()
    }


class ModelResolver(val elements: Elements) : GenericResolver {

    override fun resolveTypeWithParameters(type: Type,
                                           codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val resolved = type.codeType

        val resolve: Any? = codeTypeResolver.resolve(resolved.concreteType)

        if (resolve is TypeElement) {
            return resolve.asType().getCodeType(elements).asGeneric
        }

        throw IllegalStateException("$type must be a Javax Annotation Model TypeElement.")
    }

    override fun resolveGenericTypeImplementation(superType: Type, implemented: Type,
                                                  codeTypeResolver: CodeTypeResolver<*>): GenericType {
        val superCodeType = superType.codeType
        val implementedCodeType = implemented.codeType

        val resolvedSuperType: Any? = codeTypeResolver.resolve(superCodeType.concreteType)
        val resolvedImplemented: Any? = codeTypeResolver.resolve(implementedCodeType.concreteType)

        if (resolvedSuperType is TypeElement && resolvedImplemented is TypeElement) {
            val superElement = resolvedSuperType
            val implementedElement = resolvedImplemented

            if (superElement.superclass.kind != TypeKind.NONE
                    && superElement.superclass.getCodeType(elements).concreteType.`is`(implementedCodeType.concreteType)) {
                return superElement.superclass.getCodeType(elements).asGeneric
            }

            val itfs = superElement.interfaces

            for (i in itfs.indices) {
                val itf = itfs[i]

                if (itf.getCodeType(elements).concreteType.`is`(implementedCodeType.concreteType)) {
                    return itf.getCodeType(elements).asGeneric
                }
            }

            throw IllegalStateException("Can't find '$implementedElement' in superclasses and superinterfaces of '$superElement'.")
        }

        throw IllegalStateException("Super type $superType and implemented type $implemented must be a Javax Annotation Model TypeElement.")
    }

}