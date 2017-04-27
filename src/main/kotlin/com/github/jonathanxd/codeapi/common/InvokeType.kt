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
 * Type of the invocation. In JVM, the invocation type depends on where the element is declared and
 * which modifiers it has. [INVOKE_VIRTUAL] is used to invoke instance methods in `class`es, [INVOKE_INTERFACE]
 * is used to invoke interface methods in `interface`s, a special opcode is required for methods declared
 * in `interface` because JVM needs to resolve the position of the method in the method table. [INVOKE_STATIC] is used
 * for invocation of static methods, does not matter where it is declared or if it is private. [INVOKE_SPECIAL] is used to invoke
 * constructors and for private methods, for private methods,
 * [INVOKE_SPECIAL] is required because [INVOKE_VIRTUAL] will always call the method of `current class`, which
 * is bad for private methods, because class inheritance can hide the private method and can cause a unexpected
 * behavior. In JVM [INVOKE_SPECIAL] instruction is used to invoke super class constructor, but it behaves different
 * for instance construction (read [INVOKE_SUPER] for more information)
 * because of this, [INVOKE_SUPER] was introduced to achieve the super constructor invocation
 * and this constructor invocation.
 *
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
     * - Constructor methods.
     * - Private methods.
     */
    INVOKE_SPECIAL,

    /**
     * Special invocation.
     *
     * Invoke super/this class constructor. This is a special
     * invocation type, this does not exists in JVM bytecode but
     * the [INVOKE_SPECIAL] behaves different for super constructor invocation and
     * this constructor invocation.
     *
     * In JVM, to construct a instance, we need to visit `new` instruction, that allocates a instance of object with default initial
     * values, and then, we need to call the constructor using `invokespecial`. But to call `super` and `this` constructor,
     * we need to pass a `uninitialized_this` to the `invokespecial` calling the initialization constructor of super class or of the
     * current class. There is not way to differ a normal constructor invocation from a super constructor invocation because both
     * have the same specification, in older versions we used a class called `MethodType` to specify the type of the method, but now
     * we use a special invocation because it is better. But remember, there is not opcode called `invokesuper` in the JVM,
     * in BytecodeGenerator this will be converted to a `invokespecial` but in a **special** way.
     */
    INVOKE_SUPER,

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
     * Returns true if the InvokeType is [INVOKE_INTERFACE].
     *
     * @return True if the InvokeType is [INVOKE_INTERFACE].
     */
    fun isInterface() = this == INVOKE_INTERFACE

    companion object {

        /**
         * Get InvokeType corresponding to the [codeType]. If [codeType] is null, [INVOKE_STATIC], if [CodeType.isInterface],
         * [INVOKE_INTERFACE] else [INVOKE_VIRTUAL].
         *
         * @param codeType Code Type
         * @return [INVOKE_STATIC] if null, [INVOKE_INTERFACE] if is is an interface, or is not an interface [INVOKE_VIRTUAL]
         */
        @JvmStatic
        fun get(codeType: CodeType?) = if (codeType == null) INVOKE_STATIC else if (codeType.isInterface) INVOKE_INTERFACE else INVOKE_VIRTUAL
    }
}