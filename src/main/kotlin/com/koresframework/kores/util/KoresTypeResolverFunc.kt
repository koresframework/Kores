/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.util

import com.koresframework.kores.type.KoresType
import java.util.function.Function

abstract class KoresTypeResolverFunc : (String) -> KoresType,
    Function<String, KoresType> /* Java compatibility */ {

    override fun apply(t: String): KoresType = this.invoke(t)

    override fun invoke(p1: String): KoresType {
        if (p1.endsWith("[]")) {
            val index = p1.indexOf("[]")
            val without = p1.substring(0..index)
            val dimension = p1.substring(index).replace("]", "")
            return this.resolve("${dimension}L$without;")
        }

        return this.resolve(p1)
    }

    protected abstract fun resolve(t: String): KoresType

    companion object {
        fun fromJavaFunction(func: Function<String, KoresType>): KoresTypeResolverFunc =
            WrappedKoresTypeResolver(func)

        fun fromKtFunction(func: (String) -> KoresType): KoresTypeResolverFunc =
            WrappedKoresTypeResolver0(func)
    }

    // Backward compatible
    private class WrappedKoresTypeResolver(val func: Function<String, KoresType>) :
        KoresTypeResolverFunc() {
        override fun resolve(t: String): KoresType = func.apply(t)
    }

    // Backward compatible
    private class WrappedKoresTypeResolver0(val func: (String) -> KoresType) :
        KoresTypeResolverFunc() {
        override fun resolve(t: String): KoresType = func(t)
    }
}

