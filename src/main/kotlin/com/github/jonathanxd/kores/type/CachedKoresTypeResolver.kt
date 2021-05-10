/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.kores.base.TypeDeclaration
import com.github.jonathanxd.iutils.`object`.Either
import com.github.jonathanxd.iutils.`object`.specialized.EitherObjBoolean
import com.github.jonathanxd.iutils.kt.right
import java.lang.reflect.Type

/**
 * Caches resolutions, this class is not thread-safe and does not caches [isAssignableFrom] resolution.
 */
class CachedKoresTypeResolver<T>(private val originalResolver: KoresTypeResolver<T>) :
    KoresTypeResolver<T> {
    private val resolveTypes = mutableMapOf<Type, T>()
    private val superClasses = mutableMapOf<Type, Type?>()
    private val interfaces = mutableMapOf<Type, List<Type>>()
    private val typeDeclarations = mutableMapOf<Type, TypeDeclaration>()

    override fun resolve(type: Type): Either<Exception, out T> {
        this.resolveTypes[type]?.let {
            return right(it)
        }

        return this.originalResolver.resolve(type).also {
            it.ifRight { this.resolveTypes[type] = it }
        }
    }


    override fun getSuperclass(type: Type): Either<Exception, Type?> {
        this.superClasses[type]?.let {
            return right(it)
        }

        return this.originalResolver.getSuperclass(type).also {
            it.ifRight { this.superClasses[type] = it }
        }
    }

    override fun getInterfaces(type: Type): Either<Exception, List<Type>> {
        this.interfaces[type]?.let {
            return right(it)
        }

        return this.originalResolver.getInterfaces(type).also {
            it.ifRight { this.interfaces[type] = it }
        }
    }

    override fun isAssignableFrom(
        type: Type,
        from: Type,
        resolverProvider: (Type) -> KoresTypeResolver<*>
    ): EitherObjBoolean<Exception> {
        return this.originalResolver.isAssignableFrom(type, from, resolverProvider)
    }

    override fun resolveTypeDeclaration(type: Type): Either<Exception, TypeDeclaration> {
        this.typeDeclarations[type]?.let {
            return right(it)
        }

        return this.originalResolver.resolveTypeDeclaration(type).also {
            it.ifRight { this.typeDeclarations[type] = it }
        }
    }

}