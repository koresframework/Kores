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
package com.github.jonathanxd.codeapi.read.bytecode.asm

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.MutableCodeSource
import com.github.jonathanxd.codeapi.common.CodeParameter
import com.github.jonathanxd.codeapi.common.Environment
import com.github.jonathanxd.codeapi.impl.CodeConstructor
import com.github.jonathanxd.codeapi.impl.CodeMethod
import com.github.jonathanxd.codeapi.impl.StaticBlockImpl
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead
import com.github.jonathanxd.codeapi.read.bytecode.Constants
import com.github.jonathanxd.codeapi.read.bytecode.EmulatedFrame
import com.github.jonathanxd.codeapi.util.asm.VisitTranslator
import com.github.jonathanxd.codeapi.util.gen.GenericUtil
import org.objectweb.asm.Handle
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.*

object MethodAnalyzer {
    @Suppress("UNCHECKED_CAST")
    fun analyze(methodNode: MethodNode, environment: Environment): MethodDeclaration {
        val methodName = methodNode.name
        val desc = methodNode.desc
        val parameters = methodNode.parameters as List<ParameterNode>

        val codeModifiers = CommonRead.modifiersFromAccess(methodNode.access)

        val declaration = environment.data.getRequired(Constants.TYPE_DECLARATION)

        val typeSpec = CommonRead.typeSpecFromDesc(environment, declaration, methodName, desc)

        val codeParameters = typeSpec.parameterTypes.mapIndexed { i, codeType ->

            val name = if (parameters.size > i) parameters[i].name else "param$i"

            CodeParameter(name, codeType)
        }


        val method: MethodDeclaration =
                when (methodName) {
                    "<init>" -> CodeConstructor(codeModifiers, codeParameters, MutableCodeSource())
                    "<clinit>" -> StaticBlockImpl(MutableCodeSource())
                    else -> CodeMethod(methodName, codeModifiers, codeParameters, typeSpec.returnType, MutableCodeSource())
                }

        val instructions = methodNode.instructions

        val analyze = Analyze(instructions, method, declaration, environment)

        analyze.analyze()

        return method
    }

    class Analyze(val instructions: InsnList, val method: MethodDeclaration, val declaringType: TypeDeclaration, val environment: Environment) {

        val frame = EmulatedFrame()

        fun analyze(): MethodDeclaration {

            val array = instructions.toArray()
            val parameters = method.parameters.toMutableList()

            VisitTranslator.readVariableTable(array, this.environment, this.frame::storeInfo)

            VisitTranslator.readParameters(array, { i, name -> parameters[i] = parameters[i].setName(name) })

            VisitTranslator.initMethod(this.method, parameters, this.frame)

            array.forEach {

                when(it) {
                    is InsnNode -> this.visitInsn(it.opcode)
                    is VarInsnNode -> this.visitVarInsn(it.opcode, it.`var`)
                    is TypeInsnNode -> this.visitTypeInsn(it.opcode, it.desc)
                    is FieldInsnNode -> this.visitFieldInsn(it.opcode, it.owner, it.name, it.desc)
                    is MethodInsnNode -> this.visitMethodInsn(it.opcode, it.owner, it.name, it.desc, it.itf)
                    is InvokeDynamicInsnNode -> this.visitInvokeDynamicInsn(it.name, it.desc, it.bsm, it.bsmArgs)
                    is LdcInsnNode -> this.visitLdcInsn(it.cst)
                    is IincInsnNode -> this.visitIincInsn(it.`var`, it.incr)
                    is ParameterNode, is LocalVariableNode -> {
                        // Ignore
                    }
                    else -> OperandAddVisitor(this.frame.operandStack)
                }


                println("InsnList: $it")

                /*when(it) {
                is InsnNode -> {
                    it.opcode
                }
            }*/
            }

            return method.setParameters(parameters)
        }

        fun visitInsn(opcode: Int) {
            VisitTranslator.visitInsn(opcode, this.frame).pushToOperand()
        }

        fun visitVarInsn(opcode: Int, slot: Int) {
            VisitTranslator.visitVarInsn(opcode, slot, this.frame)?.pushToOperand()
        }

        fun visitTypeInsn(opcode: Int, type: String) {
            VisitTranslator.visitTypeInsn(opcode, type, this.environment, this.frame).pushToOperand()
        }

        fun visitFieldInsn(opcode: Int, owner: String, name: String, desc: String) {
            VisitTranslator.visitFieldInsn(opcode, owner, name, desc, this.environment, this.frame).pushToOperand()
        }

        fun visitLdcInsn(cst: Any) {
            VisitTranslator.visitLdcInsn(cst).pushToOperand()
        }

        fun visitMethodInsn(opcode: Int, owner: String, name: String, desc: String, itf: Boolean) {
            VisitTranslator.visitMethodInsn(opcode, owner, name, desc, itf, declaringType, this.environment, this.frame).pushToOperand()
        }

        fun visitInvokeDynamicInsn(name: String, desc: String, bsm: Handle, bsmArgs: Array<out Any>) {
            VisitTranslator.visitDynamicMethodInsn(name, desc, bsm, bsmArgs, this.environment, this.frame).pushToOperand()

        }

        fun visitIincInsn(slot: Int, increment: Int) {
            VisitTranslator.visitIincInsn(slot, increment, this.frame).pushToOperand()
        }


        private fun CodePart.pushToOperand() {
            frame.operandStack.push(this)
        }
    }

}
