/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.codeapi.type.CodeType
import java.util.function.Function

abstract class CodeTypeResolverFunc : (String) -> CodeType,
    Function<String, CodeType> /* Java compatibility */ {

    override fun apply(t: String): CodeType = this.invoke(t)

    override fun invoke(p1: String): CodeType {
        if (p1.endsWith("[]")) {
            val index = p1.indexOf("[]")
            val without = p1.substring(0..index)
            val dimension = p1.substring(index).replace("]", "")
            return this.resolve("${dimension}L$without;")
        }

        return this.resolve(p1)
    }

    protected abstract fun resolve(t: String): CodeType

    companion object {
        fun fromJavaFunction(func: Function<String, CodeType>): CodeTypeResolverFunc =
            WrappedCodeTypeResolver(func)

        fun fromKtFunction(func: (String) -> CodeType): CodeTypeResolverFunc =
            WrappedCodeTypeResolver0(func)
    }

    // Backward compatible
    private class WrappedCodeTypeResolver(val func: Function<String, CodeType>) :
        CodeTypeResolverFunc() {
        override fun resolve(t: String): CodeType = func.apply(t)
    }

    // Backward compatible
    private class WrappedCodeTypeResolver0(val func: (String) -> CodeType) :
        CodeTypeResolverFunc() {
        override fun resolve(t: String): CodeType = func(t)
    }
}

