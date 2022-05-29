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
package com.koresframework.kores.base

import com.koresframework.kores.base.InvokeType.*
import com.koresframework.kores.type.isInterface
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * TODO Documentation
 */
@Serializable
enum class DynamicInvokeType {

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
     * - Constructor methods.
     * - Private methods.
     * - Super constructor invocation. (or this constructor invocation).
     */
    INVOKE_SPECIAL,

    /**
     * Special invocation of constructors.
     */
    NEW_INVOKE_SPECIAL,

    /**
     * Interface method invocation.
     */
    INVOKE_INTERFACE;

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
     * Returns true if the InvokeType is [NEW_INVOKE_SPECIAL].
     *
     * @return True if the InvokeType is [NEW_INVOKE_SPECIAL].
     */
    fun isNewSpecial() = this == NEW_INVOKE_SPECIAL

    /**
     * Returns true if the InvokeType is [INVOKE_INTERFACE].
     *
     * @return True if the InvokeType is [INVOKE_INTERFACE].
     */
    fun isInterface() = this == INVOKE_INTERFACE

    fun toInvokeType(): InvokeType = when(this) {
        INVOKE_STATIC -> InvokeType.INVOKE_STATIC
        INVOKE_VIRTUAL -> InvokeType.INVOKE_VIRTUAL
        INVOKE_SPECIAL, NEW_INVOKE_SPECIAL -> InvokeType.INVOKE_SPECIAL
        INVOKE_INTERFACE -> InvokeType.INVOKE_INTERFACE
    }
}