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
package com.github.jonathanxd.kores.util

import com.github.jonathanxd.kores.type.KoresType
import java.lang.reflect.AnnotatedType
import java.lang.reflect.GenericDeclaration
import java.lang.reflect.Type
import java.lang.reflect.TypeVariable

/**
 * Wrapper of [KoresType] to [TypeVariable]. This class is a little complex and is not intended to be used by
 * external sources.
 */
class GenericTypeVariable internal constructor(
    val type: KoresType?,
    private val wrapped: TypeVariable<out GenericDeclaration>?,
    private val wrappedType: Type?,
    name: String?,
    private val bounds: Array<Type>
) : TypeVariable<GenericDeclaration> {

    private val name: String? = name ?: (type?.canonicalName
            ?: if (wrapped != null) wrapped.name else wrappedType!!.typeName)

    constructor(
        type: KoresType?,
        wrapped: TypeVariable<out GenericDeclaration>?,
        bounds: Array<Type>
    ) : this(type, wrapped, null, null, bounds)

    constructor(
        type: KoresType?,
        wrapped: TypeVariable<out GenericDeclaration>?,
        name: String?,
        bounds: Array<Type>
    ) : this(type, wrapped, null, name, bounds)

    constructor(type: KoresType?, wrappedType: Type?, bounds: Array<Type>) : this(
        type,
        null,
        wrappedType,
        null,
        bounds
    )

    override fun getBounds(): Array<Type> {
        return this.bounds
    }

    override fun getGenericDeclaration(): GenericDeclaration? {
        return this.wrapped?.genericDeclaration
    }

    override fun getName(): String {
        return this.name
                ?: if (this.type != null) this.type.canonicalName else if (this.wrapped != null) this.wrapped.name else this.wrappedType!!.typeName
    }

    override fun getTypeName(): String = this.getName()

    override fun getAnnotatedBounds(): Array<AnnotatedType> {
        return if (this.wrapped != null) this.wrapped.annotatedBounds else emptyArray()
    }

    override fun <T : Annotation> getAnnotation(annotationClass: Class<T>): T? {
        return this.wrapped?.getAnnotation(annotationClass)
    }

    override fun getAnnotations(): Array<Annotation> {
        return if (this.wrapped != null) this.wrapped.annotations else emptyArray()
    }

    override fun getDeclaredAnnotations(): Array<Annotation> {
        return if (this.wrapped != null) this.wrapped.declaredAnnotations else emptyArray()
    }
}
