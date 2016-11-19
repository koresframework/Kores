package com.github.jonathanxd.codeapi.read.bytecode.asm

import com.github.jonathanxd.codeapi.common.MVData
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart
import com.github.jonathanxd.codeapi.read.bytecode.StackManager
import org.objectweb.asm.*

internal class OperandAddVisitor(val stackManager: StackManager,
                        api: Int = Opcodes.ASM5,
                        methodVisitor: MethodVisitor? = null) : MethodVisitor(api, methodVisitor) {

    override fun visitMultiANewArrayInsn(desc: String?, dims: Int) {
        super.visitMultiANewArrayInsn(desc, dims)
        this.push { visitMultiANewArrayInsn(desc, dims) }
    }

    override fun visitFrame(type: Int, nLocal: Int, local: Array<out Any>?, nStack: Int, stack: Array<out Any>?) {
        super.visitFrame(type, nLocal, local, nStack, stack)
    }

    override fun visitVarInsn(opcode: Int, `var`: Int) {
        super.visitVarInsn(opcode, `var`)
        this.push { visitVarInsn(opcode, `var`) }
    }

    override fun visitTryCatchBlock(start: Label?, end: Label?, handler: Label?, type: String?) {
        super.visitTryCatchBlock(start, end, handler, type)
        this.push { visitTryCatchBlock(start, end, handler, type) }
    }

    override fun visitLookupSwitchInsn(dflt: Label?, keys: IntArray?, labels: Array<out Label>?) {
        super.visitLookupSwitchInsn(dflt, keys, labels)
        this.push { visitLookupSwitchInsn(dflt, keys, labels) }
    }

    override fun visitJumpInsn(opcode: Int, label: Label?) {
        super.visitJumpInsn(opcode, label)
        this.push { visitJumpInsn(opcode, label) }
    }

    override fun visitLdcInsn(cst: Any?) {
        super.visitLdcInsn(cst)
        this.push { visitLdcInsn(cst) }
    }

    override fun visitIntInsn(opcode: Int, operand: Int) {
        super.visitIntInsn(opcode, operand)
        this.push { visitIntInsn(opcode, operand) }
    }

    override fun visitTypeInsn(opcode: Int, type: String?) {
        super.visitTypeInsn(opcode, type)
        this.push { visitTypeInsn(opcode, type) }
    }

    override fun visitAnnotationDefault(): AnnotationVisitor {
        return super.visitAnnotationDefault()
    }

    override fun visitAnnotation(desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitAnnotation(desc, visible)
    }

    override fun visitTypeAnnotation(typeRef: Int, typePath: TypePath?, desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitTypeAnnotation(typeRef, typePath, desc, visible)
    }

    override fun visitMaxs(maxStack: Int, maxLocals: Int) {
        super.visitMaxs(maxStack, maxLocals)
    }

    override fun visitInvokeDynamicInsn(name: String?, desc: String?, bsm: Handle?, vararg bsmArgs: Any?) {
        super.visitInvokeDynamicInsn(name, desc, bsm, *bsmArgs)
        this.push { visitInvokeDynamicInsn(name, desc, bsm, *bsmArgs) }
    }

    override fun visitLabel(label: Label?) {
        super.visitLabel(label)
    }

    override fun visitTryCatchAnnotation(typeRef: Int, typePath: TypePath?, desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitTryCatchAnnotation(typeRef, typePath, desc, visible)
    }

    override fun visitMethodInsn(opcode: Int, owner: String?, name: String?, desc: String?) {
        super.visitMethodInsn(opcode, owner, name, desc)
        this.push { visitMethodInsn(opcode, owner, name, desc) }
    }

    override fun visitMethodInsn(opcode: Int, owner: String?, name: String?, desc: String?, itf: Boolean) {
        super.visitMethodInsn(opcode, owner, name, desc, itf)
        this.push { visitMethodInsn(opcode, owner, name, desc, itf) }
    }

    override fun visitInsn(opcode: Int) {
        super.visitInsn(opcode)
        this.push { visitInsn(opcode) }
    }

    override fun visitInsnAnnotation(typeRef: Int, typePath: TypePath?, desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitInsnAnnotation(typeRef, typePath, desc, visible)
    }

    override fun visitParameterAnnotation(parameter: Int, desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitParameterAnnotation(parameter, desc, visible)
    }

    override fun visitIincInsn(`var`: Int, increment: Int) {
        super.visitIincInsn(`var`, increment)
        this.push { visitIincInsn(`var`, increment) }
    }

    override fun visitLineNumber(line: Int, start: Label?) {
        super.visitLineNumber(line, start)
        this.push { visitLineNumber(line, start) }
    }

    override fun visitLocalVariableAnnotation(typeRef: Int, typePath: TypePath?, start: Array<out Label>?, end: Array<out Label>?, index: IntArray?, desc: String?, visible: Boolean): AnnotationVisitor {
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible)
    }

    override fun visitTableSwitchInsn(min: Int, max: Int, dflt: Label?, vararg labels: Label?) {
        super.visitTableSwitchInsn(min, max, dflt, *labels)
        this.push { visitTableSwitchInsn(min, max, dflt, *labels) }
    }

    override fun visitEnd() {
        super.visitEnd()
    }

    override fun visitLocalVariable(name: String?, desc: String?, signature: String?, start: Label?, end: Label?, index: Int) {
        super.visitLocalVariable(name, desc, signature, start, end, index)
        this.push { visitLocalVariable(name, desc, signature, start, end, index) }
    }

    override fun visitParameter(name: String?, access: Int) {
        super.visitParameter(name, access)
        this.push { visitParameter(name, access) }
    }

    override fun visitAttribute(attr: Attribute?) {
        super.visitAttribute(attr)
        this.push { visitAttribute(attr) }
    }

    override fun visitFieldInsn(opcode: Int, owner: String?, name: String?, desc: String?) {
        super.visitFieldInsn(opcode, owner, name, desc)
        this.push { visitFieldInsn(opcode, owner, name, desc) }
    }

    override fun visitCode() {
        super.visitCode()
    }

    private fun push(visitorConsumer: MethodVisitor.() -> Unit) {
        this.stackManager.push(createInstruction(visitorConsumer))
    }

    private fun createInstruction(visitorConsumer: (MethodVisitor) -> Unit): InstructionCodePart {
        return InstructionCodePart { value, extraData, visitorGenerator, additional -> visitorConsumer((additional as MVData).methodVisitor) }
    }
}