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
package com.github.jonathanxd.kores.type

import com.github.jonathanxd.kores.base.ConstructorDeclaration
import com.github.jonathanxd.kores.base.FieldDeclaration
import com.github.jonathanxd.kores.base.MethodDeclaration
import com.github.jonathanxd.kores.base.TypeDeclaration
import com.github.jonathanxd.iutils.`object`.Either
import com.github.jonathanxd.iutils.`object`.specialized.EitherObjBoolean
import java.lang.reflect.Type

/**
 * A type resolver 'binded' to a [Type]. All functions delegates to [koresTypeResolver] and uses [bindType]
 * as first argument of functions.
 */
class BindedTypeResolver<out T>(val bindType: Type, val koresTypeResolver: KoresTypeResolver<T>) {

    /**
     * Resolves [bindType] to [T]
     */
    fun resolve(): Either<Exception, out T> = this.koresTypeResolver.resolve(this.bindType)

    /**
     * Resolves super class of [bindType]
     */
    fun getSuperclass(): Either<Exception, Type?> =
        this.koresTypeResolver.getSuperclass(this.bindType)

    /**
     * Resolves super interfaces of [bindType].
     */
    fun getInterfaces(): Either<Exception, List<Type>> =
        this.koresTypeResolver.getInterfaces(this.bindType)

    /**
     * Checks if [bindType] is assignable from [from] using default resolvers.
     *
     * @return True if [bindType] is assignable from [from].
     */
    fun isAssignableFrom(from: Type): EitherObjBoolean<Exception> =
        this.isAssignableFrom(from, Type::defaultResolver)

    /**
     * Checks if [bindType] is assignable [from] using resolvers provided by [resolverProvider]
     *
     * @return True if [bindType] is assignable from [from].
     */
    fun isAssignableFrom(
        from: Type,
        resolverProvider: (Type) -> KoresTypeResolver<*>
    ): EitherObjBoolean<Exception> =
        this.koresTypeResolver.isAssignableFrom(this.bindType, from, resolverProvider)

    /**
     * Resolves or create [TypeDeclaration] from [bindedType] structure and elements (back call to [koresTypeResolver]).
     */
    fun resolveTypeDeclaration(): Either<Exception, TypeDeclaration> =
        this.koresTypeResolver.resolveTypeDeclaration(this.bindType)

    /**
     * Resolves or create a list of all [FieldDeclaration] present in [bindedType] (back call to [koresTypeResolver]).
     */
    fun resolveFields(): Either<Exception, List<FieldDeclaration>> =
        this.koresTypeResolver.resolveFields(this.bindType)

    /**
     * Resolves or create a list of all [ConstructorDeclaration] present in [bindedType]  (back call to [koresTypeResolver]).
     */
    fun resolveConstructors(): Either<Exception, List<ConstructorDeclaration>> =
        this.koresTypeResolver.resolveConstructors(this.bindType)

    /**
     * Resolves or create a list of all [MethodDeclaration] present in [bindedType] (back call to [koresTypeResolver]).
     */
    fun resolveMethods(): Either<Exception, List<MethodDeclaration>> =
        this.koresTypeResolver.resolveMethods(this.bindType)

    /**
     * Creates a new [BindedTypeResolver] instance 'binded' to [bindType].
     */
    fun bindTo(bindedType: Type) = BindedTypeResolver(bindedType, this.koresTypeResolver)

    /**
     * Creates a new [BindedTypeResolver] instance which delegate calls to [codeTypeResolver].
     */
    fun <T> bindToResolver(codeTypeResolver: KoresTypeResolver<T>) =
        BindedTypeResolver(bindType, codeTypeResolver)
}