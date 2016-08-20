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

import org.objectweb.asm.Opcodes;

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
public enum InvokeType {
    INVOKE_STATIC,
    INVOKE_VIRTUAL,
    INVOKE_SPECIAL,
    INVOKE_INTERFACE,
    INVOKE_DYNAMIC;

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

    public static InvokeType fromAsm(int asm) {
        switch (asm) {
            case INVOKEINTERFACE:
                return INVOKE_INTERFACE;
            case INVOKESPECIAL:
                return INVOKE_SPECIAL;
            case INVOKEVIRTUAL:
                return INVOKE_VIRTUAL;
            case INVOKESTATIC:
                return INVOKE_STATIC;
            case INVOKEDYNAMIC:
                return INVOKE_DYNAMIC;
            default:
                throw new RuntimeException("Cannot determine InvokeType of opcode '" + asm + "'");
        }
    }

    public static InvokeType fromAsm_H(int asm) {
        switch (asm) {
            case H_INVOKEINTERFACE:
                return INVOKE_INTERFACE;
            case H_INVOKESPECIAL:
                return INVOKE_SPECIAL;
            case H_INVOKEVIRTUAL:
                return INVOKE_VIRTUAL;
            case H_INVOKESTATIC:
                return INVOKE_STATIC;
            default:
                throw new RuntimeException("Cannot determine InvokeType of opcode '" + asm + "'");
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
