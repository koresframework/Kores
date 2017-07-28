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
package com.github.jonathanxd.codeapi.type

import com.github.jonathanxd.codeapi.util.defaultResolver
import com.github.jonathanxd.iutils.`object`.Either
import com.github.jonathanxd.iutils.`object`.specialized.EitherObjBoolean
import java.lang.reflect.Type

/**
 * A type resolver 'binded' to a [Type]. All functions delegates to [codeTypeResolver] and uses [bindType]
 * as first argument of functions.
 */
class BindedTypeResolver<out T>(val bindType: Type, val codeTypeResolver: CodeTypeResolver<T>) {

    /**
     * Resolves [bindType] to [T]
     */
    fun resolve(): Either<Exception, out T> = this.codeTypeResolver.resolve(this.bindType)

    /**
     * Resolves super class of [bindType]
     */
    fun getSuperclass(): Either<Exception, Type?> = this.codeTypeResolver.getSuperclass(this.bindType)

    /**
     * Resolves super interfaces of [bindType].
     */
    fun getInterfaces(): Either<Exception, List<Type>> = this.codeTypeResolver.getInterfaces(this.bindType)

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
    fun isAssignableFrom(from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): EitherObjBoolean<Exception> =
            this.codeTypeResolver.isAssignableFrom(this.bindType, from, resolverProvider)

    /**
     * Creates a new [BindedTypeResolver] instance 'binded' to [bindType].
     */
    fun bindTo(bindedType: Type) = BindedTypeResolver(bindedType, this.codeTypeResolver)

    /**
     * Creates a new [BindedTypeResolver] instance which delegate calls to [codeTypeResolver].
     */
    fun <T> bindToResolver(codeTypeResolver: CodeTypeResolver<T>) = BindedTypeResolver(bindType, codeTypeResolver)
}