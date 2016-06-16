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
package com.github.jonathanxd.codeapi.util;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.TypePath;

/**
 * Created by jonathan on 13/06/16.
 */
public class UtilMethodVisitor {
    private final MethodVisitor methodVisitor;
    private int count = 0;

    public UtilMethodVisitor(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void visitParameter(String name, int access) {
        methodVisitor.visitParameter(name, access);
        ++count;
    }

    public void visitAttribute(Attribute attr) {
        methodVisitor.visitAttribute(attr);
        ++count;
    }

    public void visitVarInsn(int opcode, int var) {
        methodVisitor.visitVarInsn(opcode, var);
        ++count;
    }

    public void visitJumpInsn(int opcode, Label label) {
        methodVisitor.visitJumpInsn(opcode, label);
        ++count;
    }

    public void visitTypeInsn(int opcode, String type) {
        methodVisitor.visitTypeInsn(opcode, type);
        ++count;
    }

    public void visitEnd() {
        methodVisitor.visitEnd();
        ++count;
    }

    public void visitCode() {
        methodVisitor.visitCode();
        ++count;
    }

    public void visitInsn(int opcode) {
        methodVisitor.visitInsn(opcode);
        ++count;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        ++count;
        return methodVisitor.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        ++count;
        return methodVisitor.visitAnnotation(desc, visible);
    }

    public void visitLdcInsn(Object cst) {
        methodVisitor.visitLdcInsn(cst);
        ++count;
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        ++count;
        return methodVisitor.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        methodVisitor.visitLookupSwitchInsn(dflt, keys, labels);
        ++count;
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        methodVisitor.visitMaxs(maxStack, maxLocals);
        ++count;
    }

    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        methodVisitor.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
        ++count;
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        ++count;
        return methodVisitor.visitInsnAnnotation(typeRef, typePath, desc, visible);
    }

    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        methodVisitor.visitLocalVariable(name, desc, signature, start, end, index);
        ++count;
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        methodVisitor.visitMethodInsn(opcode, owner, name, desc);
        ++count;
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        methodVisitor.visitMultiANewArrayInsn(desc, dims);
        ++count;
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        methodVisitor.visitFieldInsn(opcode, owner, name, desc);
        ++count;
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        methodVisitor.visitTableSwitchInsn(min, max, dflt, labels);
        ++count;
    }

    public void visitLabel(Label label) {
        methodVisitor.visitLabel(label);
        ++count;
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        ++count;
        return methodVisitor.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
    }

    public void visitIincInsn(int var, int increment) {
        methodVisitor.visitIincInsn(var, increment);
        ++count;
    }

    public void visitIntInsn(int opcode, int operand) {
        methodVisitor.visitIntInsn(opcode, operand);
        ++count;
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        ++count;
        return methodVisitor.visitParameterAnnotation(parameter, desc, visible);
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        methodVisitor.visitFrame(type, nLocal, local, nStack, stack);
        ++count;
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        methodVisitor.visitMethodInsn(opcode, owner, name, desc, itf);
        ++count;
    }

    public void visitLineNumber(int line, Label start) {
        methodVisitor.visitLineNumber(line, start);
        ++count;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        methodVisitor.visitTryCatchBlock(start, end, handler, type);
        ++count;
    }

    public AnnotationVisitor visitAnnotationDefault() {
        ++count;
        return methodVisitor.visitAnnotationDefault();
    }

    public int getCount() {
        return count;
    }
}
