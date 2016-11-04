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
package com.github.jonathanxd.codeapi.util.gen;

import com.github.jonathanxd.codeapi.types.CodeType;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ArrayUtil {
    public static void visitArrayStore(CodeType arrayType, int dimensions, MethodVisitor mv) {
        switch (arrayType.getType()) {
            case "int": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_INT);
                break;
            }
            case "boolean": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BOOLEAN);
                break;
            }
            case "byte": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_BYTE);
                break;
            }
            case "char": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_CHAR);
                break;
            }
            case "double": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_DOUBLE);
                break;
            }
            case "float": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_FLOAT);
                break;
            }
            case "short": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_SHORT);
                break;
            }
            case "long": {
                mv.visitIntInsn(Opcodes.NEWARRAY, Opcodes.T_LONG);
                break;
            }
            default: {
                mv.visitTypeInsn(Opcodes.ANEWARRAY, CodeTypeUtil.codeTypeToSimpleArray(arrayType, dimensions));
                break;
            }
        }
    }
}
