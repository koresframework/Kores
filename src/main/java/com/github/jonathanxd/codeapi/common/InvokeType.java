/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2016 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.types.CodeType;

import static org.objectweb.asm.Opcodes.H_INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.H_INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.H_INVOKESTATIC;
import static org.objectweb.asm.Opcodes.H_INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.INVOKEDYNAMIC;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

/**
 * Created by jonathan on 03/06/16.
 */
@SuppressWarnings("Duplicates")
/**
 * Type of the invocation.
 */
public enum InvokeType {
    /**
     * Static invocation (static methods)
     */
    INVOKE_STATIC,

    /**
     * Virtual invocation (instance methods)
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
     * Interface invocation. (invoke a interface method).
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
     * Convert {@link InvokeType} to asm invocation flag.
     *
     * @param invokeType Type to convert
     * @return asm flag corresponding to {@code invokeType}.
     */
    public static int toAsm(InvokeType invokeType) {
        switch (invokeType) {
            case INVOKE_INTERFACE:
                return INVOKEINTERFACE;
            case INVOKE_SPECIAL:
                return INVOKESPECIAL;
            case INVOKE_VIRTUAL:
                return INVOKEVIRTUAL;
            case INVOKE_STATIC:
                return INVOKESTATIC;
            case INVOKE_DYNAMIC:
                return INVOKEDYNAMIC;
            default:
                throw new RuntimeException("Cannot determine opcode of '" + invokeType + "'");
        }
    }

    /**
     * Convert {@link InvokeType} to asm invocation flag (dynamic).
     *
     * @param invokeType Type to convert
     * @return asm flag corresponding to {@code invokeType} (dynamic).
     */
    public static int toAsm_H(InvokeType invokeType) {
        switch (invokeType) {
            case INVOKE_INTERFACE:
                return H_INVOKEINTERFACE;
            case INVOKE_SPECIAL:
                return H_INVOKESPECIAL;
            case INVOKE_VIRTUAL:
                return H_INVOKEVIRTUAL;
            case INVOKE_STATIC:
                return H_INVOKESTATIC;
            case INVOKE_DYNAMIC:
                throw new RuntimeException("Cannot invoke dynamic 'dynamic invocation'!");
            default:
                throw new RuntimeException("Cannot determine opcode of '" + invokeType + "'");
        }
    }

    /**
     * Get InvokeType corresponding to the {@code type}, if {@link CodeType#isInterface()} is true,
     * return {@link #INVOKE_INTERFACE} otherwise, return {@link #INVOKE_VIRTUAL}
     *
     * @param type Code Type
     * @return {@link #INVOKE_INTERFACE} is is an interface, {@link #INVOKE_VIRTUAL} otherwise
     */
    public static InvokeType get(CodeType type) {
        if (type.isInterface())
            return INVOKE_INTERFACE;

        return INVOKE_VIRTUAL;
    }
}
