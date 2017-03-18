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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Type of the invocation.
 */
enum class InvokeType {

    /**
     * Static method invocation.
     */
    INVOKE_STATIC,

    /**
     * Virtual method invocation (instance methods).
     */
    INVOKE_VIRTUAL,

    /**
     * Special invocation.
     *
     * - Initialization (constructor methods).
     * - Private methods.
     * - Superclass methods invocation.
     */
    INVOKE_SPECIAL,

    /**
     * Interface method invocation.
     */
    INVOKE_INTERFACE,

    /**
     * Invoke a method dynamically.
     *
     * Invoke dynamic uses a bootstrap to invoke the method. Dynamic invocations is used in lambdas
     * for example.
     *
     * Dynamic invocations is a hard thing that is explained in class: {@link InvokeDynamic}.
     */
    INVOKE_DYNAMIC;


    /**
     * Returns true if the InvokeType is [INVOKE_STATIC].
     *
     * @return True if the InvokeType is [INVOKE_STATIC].
     */
    fun isStatic() = this == INVOKE_STATIC

    /**
     * Returns true if the InvokeType is [INVOKE_VIRTUAL].
     *
     * @return True if the InvokeType is [INVOKE_VIRTUAL].
     */
    fun isVirtual() = this == INVOKE_VIRTUAL

    /**
     * Returns true if the InvokeType is [INVOKE_SPECIAL].
     *
     * @return True if the InvokeType is [INVOKE_SPECIAL].
     */
    fun isSpecial() = this == INVOKE_SPECIAL

    /**
     * Returns true if the InvokeType is [INVOKE_INTERFACE].
     *
     * @return True if the InvokeType is [INVOKE_INTERFACE].
     */
    fun isInterface() = this == INVOKE_INTERFACE

    /**
     * Returns true if the InvokeType is [INVOKE_DYNAMIC].
     *
     * @return True if the InvokeType is [INVOKE_DYNAMIC].
     */
    fun isDynamic() = this == INVOKE_DYNAMIC

    companion object {
        /**
         * Get InvokeType corresponding to the {@code type}, if [codeType] is null, [INVOKE_STATIC], if [CodeType.isInterface],
         * [INVOKE_INTERFACE] else [INVOKE_VIRTUAL]
         *
         * @param codeType Code Type
         * @return [INVOKE_STATIC] if null, [INVOKE_INTERFACE] if is is an interface, or is not an interface [INVOKE_VIRTUAL]
         */
        @JvmStatic
        fun get(codeType: CodeType?) = if (codeType == null) INVOKE_STATIC else if (codeType.isInterface) INVOKE_INTERFACE else INVOKE_VIRTUAL
    }
}