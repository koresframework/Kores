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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.CodePart

/**
 * Provides builders of CodePart
 */
interface BuilderProvider {

    /**
     * Register providers of builder
     */
    fun <T: CodePart, B: Builder<T, B>> register(type: Class<T>, provider: () -> B, defaultsProvider: (defaults: T) -> B)

    /**
     * Creates a builder of part [T] with [codePart] as default value provider.
     */
    operator fun <T: CodePart, B: Builder<T, *>> get(type: Class<B>, codePart: T): B

    /**
     * Creates a builder of part [T] with default values.
     */
    operator fun <T: CodePart, B: Builder<T, *>> get(type: Class<B>): B


}

/**
 * Creates a builder of part [T].
 */
operator inline fun <T: CodePart, reified B: Builder<T, *>> BuilderProvider.invoke(): B {
    return this[B::class.java]
}

/**
 * Creates a builder of part [T].
 */
operator inline fun <T: CodePart, reified B: Builder<T, *>> BuilderProvider.invoke(codePart: T): B {
    return this[B::class.java, codePart]
}
