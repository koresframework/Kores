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
package com.github.jonathanxd.codeapi.read.bytecode.asm;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.Environment;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart;
import com.github.jonathanxd.codeapi.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead;
import com.github.jonathanxd.codeapi.read.bytecode.EmulatedFrame;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.asm.VisitTranslator;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

escription;

public class BytecodeMethodVisitor extends MethodVisitor implements Opcodes {

    private final Logger logger = Logger.getLogger("CodeAPI_Debug");

    private final EmulatedFrame frame = new EmulatedFrame();
    private final Environment environment;
    private final TypeDeclaration declaringType;
    private final MethodDeclaration method;
    private final List<CodeParameter> parameterList;
    private int paramPos = 0;

    public BytecodeMethodVisitor(int api, Environment environment, TypeDeclaration declaringType, MethodDeclaration method) {
        this(api, null, environment, declaringType, method);
    }

    public BytecodeMethodVisitor(int api, MethodVisitor mv, Environment environment, TypeDeclaration declaringType, MethodDeclaration method) {
        super(api, mv);
        this.environment = environment;
        this.declaringType = declaringType;
        this.parameterList = new ArrayList<>(method.getParameters());
        this.method = method.setParameters(this.parameterList);
        this.init();
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static MutableCodeSource asMutable(Optional<CodeSource> source) {
        return (MutableCodeSource) Require.require(source);
    }

    private void init() {
        VisitTranslator.INSTANCE.initMethod(this.method, this.parameterList, this.frame);
    }

    @Override
    public void visitParameter(String name, int access) {

        this.parameterList.set(this.paramPos, this.parameterList.get(this.paramPos).setName(name));

        ++this.paramPos;

        System.out.println("Visit parameter name = " + name + ", modifiers: " + CommonRead.modifiersFromAccess(access));

        super.visitParameter(name, access);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        return super.visitAnnotationDefault();
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        return super.visitParameterAnnotation(parameter, desc, visible);
    }

    @Override
    public void visitAttribute(Attribute attr) {
        super.visitAttribute(attr);
    }

    @Override
    public void visitCode() {
        super.visitCode();
    }

    @Override
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        super.visitFrame(type, nLocal, local, nStack, stack);
    }

    @Override
    public void visitInsn(int opcode) {
        super.visitInsn(opcode);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitInsn(opcode, this.frame));
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitIntInsn(opcode, operand));
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);

        CodePart part = VisitTranslator.INSTANCE.visitVarInsn(opcode, var, this.frame);

        if(part != null) {
            this.frame.getOperandStack().push(part);
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        super.visitTypeInsn(opcode, type);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitTypeInsn(opcode, type, this.environment, this.frame));
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        super.visitFieldInsn(opcode, owner, name, desc);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitFieldInsn(opcode, owner, name, desc, this.environment, this.frame));
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        //super.visitMethodInsn(opcode, owner, name, desc);
        // Deprecated <Java 7
        this.visitMethodInsn(opcode, owner, name, desc, false);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitMethodInsn(opcode, owner, name, desc, itf, this.declaringType, this.environment, this.frame));
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitDynamicMethodInsn(name, desc, bsm, bsmArgs, this.environment, this.frame));

    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        super.visitJumpInsn(opcode, label);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitJumpInsn(opcode, label)));
    }

    @Override
    public void visitLabel(Label label) {
        super.visitLabel(label);

        //this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitLabel(label)));
    }

    @Override
    public void visitLdcInsn(Object cst) {

        super.visitLdcInsn(cst);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitLdcInsn(cst));

    }

    @Override
    public void visitIincInsn(int var, int increment) {
        super.visitIincInsn(var, increment);

        this.frame.getOperandStack().push(VisitTranslator.INSTANCE.visitIincInsn(var, increment, this.frame));
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        super.visitTableSwitchInsn(min, max, dflt, labels);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitTableSwitchInsn(min, max, dflt, labels)));
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        super.visitLookupSwitchInsn(dflt, keys, labels);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitLookupSwitchInsn(dflt, keys, labels)));
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        super.visitMultiANewArrayInsn(desc, dims);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitMultiANewArrayInsn(desc, dims)));
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitInsnAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        super.visitTryCatchBlock(start, end, handler, type);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitTryCatchBlock(start, end, handler, type)));
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        super.visitLocalVariable(name, desc, signature, start, end, index);
        // MVData work.
        //this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitLocalVariable(name, desc, signature, start, end, index)));
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        super.visitLineNumber(line, start);

        this.frame.getOperandStack().push(this.createInstruction(methodVisitor -> methodVisitor.visitLineNumber(line, start)));
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, maxLocals);

        //this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitMaxs(maxStack, maxLocals)));
    }

    @Override
    public void visitEnd() {
        super.visitEnd();


        List<CodePart> codeParts = this.frame.getOperandStack().popAll();

        MutableCodeSource source = this.method.getBody().orElse(CodeSource.empty()).toMutable();

        source.addAll(codeParts);

        asMutable(this.declaringType.getBody()).add(
                this.method.setBody(source)
        );

    }

    private void addToBody(CodePart codePart) {
        asMutable(this.method.getBody()).add(codePart);
    }

    private InstructionCodePart createInstruction(Consumer<MethodVisitor> visitorConsumer) {
        return (value, extraData, visitorGenerator, additional) -> {
            visitorConsumer.accept(((MVData) additional).getMethodVisitor());
        };
    }

    private <T> T thatOr(T t, T t2) {
        if (t != null)
            return t;
        else
            return t2;
    }

    private static final class NEW implements CodePart {
        private final CodeType codeType;

        private NEW(CodeType codeType) {
            this.codeType = codeType;
        }

        public CodeType getCodeType() {
            return codeType;
        }
    }

    private class UnsizedArray extends ArrayConstructorImpl {

        public UnsizedArray(CodeType arrayType, CodePart[] dimensions, List<CodeArgument> arguments) {
            super(arrayType, dimensions, arguments);
        }

        @Override
        public CodePart[] getDimensions() {
            return new CodePart[]{Literals.INT(this.getArguments().size())};
        }
    }

    private class SizedArray extends ArrayConstructorImpl {

        public SizedArray(CodeType arrayType, CodePart[] dimensions, List<CodeArgument> arguments) {
            super(arrayType, dimensions, arguments);
        }
    }
}
