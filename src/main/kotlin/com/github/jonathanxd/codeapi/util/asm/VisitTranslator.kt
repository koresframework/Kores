package com.github.jonathanxd.codeapi.util.asm

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.common.*
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart
import com.github.jonathanxd.codeapi.helper.Helper
import com.github.jonathanxd.codeapi.impl.ArrayConstructorImpl
import com.github.jonathanxd.codeapi.impl.MethodInvocationImpl
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation
import com.github.jonathanxd.codeapi.interfaces.VariableAccess
import com.github.jonathanxd.codeapi.literals.Literals
import com.github.jonathanxd.codeapi.operators.Operators
import com.github.jonathanxd.codeapi.read.bytecode.EmulatedFrame
import com.github.jonathanxd.codeapi.types.CodeType
import com.github.jonathanxd.codeapi.util.DescriptionHelper
import com.github.jonathanxd.codeapi.util.TypeResolver
import com.github.jonathanxd.codeapi.util.gen.ArrayUtil
import com.github.jonathanxd.codeapi.util.gen.CodePartUtil
import com.github.jonathanxd.codeapi.util.gen.GenericUtil
import com.github.jonathanxd.codeapi.util.gen.MethodInvocationUtil
import com.github.jonathanxd.iutils.description.DescriptionUtil
import org.objectweb.asm.Handle
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.LocalVariableNode
import org.objectweb.asm.tree.ParameterNode
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

object VisitTranslator {

    private val logger = Logger.getLogger("CodeAPI_Translator")

    fun visitInsn(opcode: Int, frame: EmulatedFrame): CodePart {
        when (opcode) {
            Opcodes.NOP,
            Opcodes.POP, // Ignore POP
            Opcodes.POP2, // Ignore POP
            Opcodes.DUP, // Handling DUP* is very hard for CodeAPI
            Opcodes.DUP_X1, Opcodes.DUP_X2, Opcodes.DUP2, Opcodes.DUP2_X1, Opcodes.DUP2_X2,
            Opcodes.SWAP, // Need review
            Opcodes.LCMP, // TODO: If Expression translation
            Opcodes.FCMPL, Opcodes.FCMPG, Opcodes.DCMPL, Opcodes.DCMPG, Opcodes.MONITORENTER, // No equivalent
            Opcodes.MONITOREXIT -> {// No equivalent
                return this.createInstruction { methodVisitor -> methodVisitor.visitInsn(opcode) }
            }
        }

        var value: CodePart? = null

        if (opcode == Opcodes.ACONST_NULL)
            value = Literals.NULL

        if (opcode == Opcodes.ICONST_M1)
            value = Literals.INT(-1)

        if (opcode == Opcodes.ICONST_0)
            value = Literals.INT(0)

        if (opcode == Opcodes.ICONST_1)
            value = Literals.INT(1)

        if (opcode == Opcodes.ICONST_2)
            value = Literals.INT(2)

        if (opcode == Opcodes.ICONST_3)
            value = Literals.INT(3)

        if (opcode == Opcodes.ICONST_4)
            value = Literals.INT(4)

        if (opcode == Opcodes.ICONST_5)
            value = Literals.INT(5)

        if (opcode == Opcodes.LCONST_0)
            value = Literals.LONG(0L)

        if (opcode == Opcodes.LCONST_1)
            value = Literals.LONG(1L)

        if (opcode == Opcodes.FCONST_0)
            value = Literals.FLOAT(0f)

        if (opcode == Opcodes.FCONST_1)
            value = Literals.FLOAT(1f)

        if (opcode == Opcodes.FCONST_2)
            value = Literals.FLOAT(2f)

        if (opcode == Opcodes.DCONST_0)
            value = Literals.DOUBLE(0.0)

        if (opcode == Opcodes.DCONST_1)
            value = Literals.DOUBLE(1.0)

        if (opcode >= Opcodes.I2L && opcode <= Opcodes.I2S) {
            value = CodePartUtil.Conversion.handleConversion(opcode, frame.operandStack.pop())
        }

        if (opcode >= Opcodes.INEG && opcode <= Opcodes.DNEG) {
            value = CodePartUtil.Conversion.handleNegation(opcode, frame.operandStack.pop())
        }

        if (opcode >= Opcodes.IADD && opcode <= Opcodes.LXOR) {
            val pop = frame.operandStack.pop(2)

            value = CodePartUtil.Conversion.handleMathAndBitwise(opcode, pop[0], pop[1])
        }

        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) {
            value = CodePartUtil.Conversion.handleReturn(opcode, if (opcode == Opcodes.RETURN) null else frame.operandStack.pop())
        }

        if (opcode == Opcodes.ARRAYLENGTH) {
            value = CodeAPI.getArrayLength(frame.operandStack.popAs(VariableAccess::class.java))
        }

        if (opcode == Opcodes.ATHROW) {
            value = CodeAPI.throwException(frame.operandStack.pop())
        }

        if (opcode == Opcodes.IASTORE || opcode == Opcodes.LASTORE || opcode == Opcodes.FASTORE || opcode == Opcodes.DASTORE || opcode == Opcodes.AASTORE || opcode == Opcodes.BASTORE || opcode == Opcodes.CASTORE || opcode == Opcodes.SASTORE) {

            val pop = frame.operandStack.pop(3)

            var array = pop[0] // Removed
            val position = pop[1]
            val valueToInsert = pop[2]

            if (array is ArrayConstructor) {

                val arguments = ArrayList(array.arguments)

                arguments.add(CodeArgument(valueToInsert, CodePartUtil.getTypeOrNull(valueToInsert)))

                array = array.setArguments(arguments)

                value = array // Will be Added
            } else {
                array as VariableAccess

                value = CodeAPI.setArrayValue(array.variableType, array, position, valueToInsert)
            }

        }

        if (opcode == Opcodes.IALOAD || opcode == Opcodes.LALOAD || opcode == Opcodes.FALOAD || opcode == Opcodes.DALOAD || opcode == Opcodes.BALOAD || opcode == Opcodes.CALOAD || opcode == Opcodes.SALOAD) {
            // Load array values
            val pop = frame.operandStack.pop(2)

            val array = pop[0] as VariableAccess
            val position = pop[1]

            value = CodeAPI.getArrayValue(array.variableType, array, position)
        }
        if (value == null)
            logger.log(Level.WARNING, "Cannot parse insn opcode: '$opcode'")

        return value ?: this.createInstruction { methodVisitor -> methodVisitor.visitInsn(opcode) }
    }

    fun visitIntInsn(opcode: Int, operand: Int): CodePart {
        if (opcode == Opcodes.BIPUSH) {
            return Literals.BYTE(operand.toByte())
        } else if (opcode == Opcodes.SIPUSH) {
            return Literals.SHORT(operand.toShort())
        } else if (opcode == Opcodes.ANEWARRAY) {
            val arrayType = ArrayUtil.getArrayType(operand)

            return UnsizedArray(arrayType, emptyArray(), emptyList())
        } else {

            return this.createInstruction { methodVisitor -> methodVisitor.visitIntInsn(opcode, operand) }
        }
    }

    fun visitVarInsn(opcode: Int, slot: Int, frame: EmulatedFrame): CodePart? {

        if (opcode == Opcodes.ILOAD || opcode == Opcodes.LLOAD || opcode == Opcodes.FLOAD || opcode == Opcodes.DLOAD || opcode == Opcodes.ALOAD) {
            frame.loadToStack(slot)
        } else if (opcode == Opcodes.ISTORE || opcode == Opcodes.LSTORE || opcode == Opcodes.FSTORE || opcode == Opcodes.DSTORE || opcode == Opcodes.ASTORE) {

            val pop = frame.operandStack.pop()

            val info = frame.getInfo(slot)

            val type = info?.type ?: CodePartUtil.getType(pop)
            val name = info?.name ?: "var$slot"

            val field = CodeAPI.field(type, name, pop)

            frame.store(field, slot)

            return field
        } else {
            if (opcode == Opcodes.RET)
                this.logger.warning("Cannot handle RET opcode")

            return this.createInstruction { methodVisitor -> methodVisitor.visitVarInsn(opcode, slot) }
        }

        return null
    }

    fun visitTypeInsn(opcode: Int, type: String, typeResolver: TypeResolver, frame: EmulatedFrame): CodePart {
        val codeType = typeResolver.resolveUnknown(type)

        when (opcode) {
            Opcodes.NEW -> return NEW(codeType)
            Opcodes.CHECKCAST -> {
                val codePart = frame.operandStack.pop()

                return CodeAPI.cast(CodePartUtil.getTypeOrNull(codePart), codeType, codePart)
            }
            Opcodes.INSTANCEOF -> {
                val codePart = frame.operandStack.pop()
                return CodeAPI.isInstanceOf(codePart, codeType)
            }
            Opcodes.ANEWARRAY -> {
                return UnsizedArray(codeType, emptyArray(), emptyList())
            }
            else -> {
                this.logger.warning("Cannot handle opcode: '$opcode'!")
                return this.createInstruction { methodVisitor -> methodVisitor.visitTypeInsn(opcode, type) }
            }
        }
    }

    fun visitFieldInsn(opcode: Int, owner: String, name: String, desc: String, typeResolver: TypeResolver, frame: EmulatedFrame): CodePart {
        val codeOwner = typeResolver.resolveUnknown(owner)
        val codeType = typeResolver.resolveUnknown(desc)

        when (opcode) {
            Opcodes.GETSTATIC -> {
                return CodeAPI.accessStaticField(codeOwner, codeType, name)
            }
            Opcodes.PUTSTATIC -> {
                val value = frame.operandStack.pop()

                return CodeAPI.setStaticField(codeOwner, codeType, name, value)
            }
            Opcodes.GETFIELD -> {
                val instance = frame.operandStack.pop()

                return CodeAPI.accessField(codeOwner, instance, codeType, name)
            }
            Opcodes.PUTFIELD -> {
                val pop = frame.operandStack.pop(2)
                val instance = pop[0]
                val value = pop[1]

                return CodeAPI.setField(codeOwner, instance, codeType, name, value)
            }
        }

        return this.createInstruction { methodVisitor -> methodVisitor.visitFieldInsn(opcode, owner, name, desc) }
    }

    fun visitMethodInsn(opcode: Int,
                        owner: String,
                        name: String,
                        desc: String,
                        itf: Boolean,
                        declaringType: CodeType,
                        typeResolver: TypeResolver,
                        frame: EmulatedFrame): CodePart {
        try {
            // Resolve the method owner type
            val ownerType = typeResolver.resolve(owner, itf)

            // Parse the method description
            val description = DescriptionUtil.parseDescription(ownerType.javaSpecName + ":" + name + desc)

            // Get number of arguments
            val arguments = description.parameterTypes.size

            // Pop all arguments from operand stack
            val pop = frame.operandStack.pop(arguments)

            // Create argument array
            val argumentsArray = pop.map(::CodeArgument).toTypedArray()

            // Gets the invocation type from asm opcode
            val invokeType = InvokeType.fromAsm(opcode)

            // Invocation target part
            var target: CodePart? = null

            // If the invocation type is not static
            if (invokeType != InvokeType.INVOKE_STATIC) {
                // Pops the invocation target from operand stack
                target = frame.operandStack.pop()
            }

            // Create TypeSpecification from the method description
            val spec = DescriptionHelper.toTypeSpec(description, typeResolver)

            // Create the method specification
            val methodSpec = MethodSpecImpl(
                    name,
                    // Resolve return type
                    typeResolver.resolveUnknown(description.returnType),
                    // Specify arguments
                    Arrays.asList<CodeArgument>(*argumentsArray)
            )

            // Method invocation part
            val methodInvocation: MethodInvocation

            if (target != null && target is NEW) {
                // Create invocation of a constructor of a class
                methodInvocation = CodeAPI.invokeConstructor(target.codeType, spec, *argumentsArray)
            } else {
                // If target is not a constructor (NEW)
                // If invoke type is special, create a super/this constructor invocation
                if (invokeType == InvokeType.INVOKE_SPECIAL) {
                    // If method type is same as method declaring type
                    if (ownerType.`is`(declaringType)) {
                        // Create this constructor invocation
                        methodInvocation = CodeAPI.invokeThisConstructor(spec, *argumentsArray)
                    } else {
                        // If is not same, invoke super class constructor
                        methodInvocation = CodeAPI.invokeSuperConstructor(ownerType, spec, *argumentsArray)
                    }
                } else {
                    // If is not invoke special, invoke normally.
                    methodInvocation = Helper.invoke(invokeType, ownerType, target, methodSpec)
                }
            }

            return methodInvocation

        } catch (e: Exception) {
            this.logger.log(Level.WARNING, "Method -> $owner:$name$desc", e)

            return this.createInstruction { methodVisitor -> methodVisitor.visitMethodInsn(opcode, owner, name, desc, itf) }
        }

    }

    fun visitDynamicMethodInsn(name: String,
                               desc: String,
                               bsm: Handle,
                               bsmArgs: Array<out Any>,
                               typeResolver: TypeResolver,
                               frame: EmulatedFrame): CodePart {
        try {
            // Parse bootstrap method description
            val description = DescriptionUtil.parseDescription("L?;:" + name + desc)

            // Get number of arguments
            val arguments = description.parameterTypes.size

            // Pop arguments from stack
            val pop = frame.operandStack.pop(arguments)

            // Create a list of arguments
            val argumentList = pop.map(::CodeArgument).toList()

            // Specify InvokeType as Dynamic
            val invokeType = InvokeType.INVOKE_DYNAMIC

            // Create TypeSpec from bootstrap method description
            val typeSpec = DescriptionHelper.toTypeSpec(description, typeResolver)

            // Create method specification of bootstrap method
            val methodSpec = MethodSpecImpl(name, typeSpec, argumentList)

            // Create dynamic invocation of the bootstrap method
            val invokeDynamic = MethodInvocationUtil.fromHandle(bsm, bsmArgs, typeResolver)

            // Create a method invocation of the bootstrap method
            val methodInvocation = MethodInvocationImpl(invokeType, null, null, methodSpec)

            // Create Dynamic invocation version of 'methodInvocation'
            val dynamicMethodInvocation = Helper.invokeDynamic(invokeDynamic, methodInvocation)

            // Add invocation to the body
            //this.addToBody(dynamicMethodInvocation);

            return dynamicMethodInvocation

        } catch (e: Exception) {
            this.logger.log(Level.WARNING, "DynamicMethod -> dynamic:$name$desc", e)

            return this.createInstruction { methodVisitor -> methodVisitor.visitInvokeDynamicInsn(name, desc, bsm, *bsmArgs) }
        }

    }

    fun visitLdcInsn(cst: Any): CodePart {
        if (CodePartUtil.Conversion.isLiteral(cst)) {
            val literal = CodePartUtil.Conversion.toLiteral(cst)

            return literal
        } else {
            return this.createInstruction { methodVisitor -> methodVisitor.visitLdcInsn(cst) }
        }
    }

    fun visitIincInsn(slot: Int, increment: Int, frame: EmulatedFrame): CodePart {
        val variable = frame.load(slot)

        if (variable !is VariableAccess) {
            this.logger.warning("Cannot handle variable increment. Variable: '$variable', slot: '$slot', increment: '$increment'!")
            return this.createInstruction { methodVisitor -> methodVisitor.visitIincInsn(slot, increment) }
        } else {

            val literal = if (increment != 1 && increment != -1) Literals.INT(increment) else null

            val operation = if (increment == 1) {
                Operators.INCREMENT
            } else if (increment == -1) {
                Operators.DECREMENT
            } else if (increment > 0) {
                Operators.ADD
            } else {
                Operators.SUBTRACT
            }

            return CodeAPI.operateLocalVariable(variable.variableType, variable.name, operation, literal)
        }

    }

    // Extra
    fun initMethod(method: MethodDeclaration, parameters: List<CodeParameter>, frame: EmulatedFrame) {
        var pos = 0

        if (!method.modifiers.contains(CodeModifier.STATIC)) {
            frame.storeAccess(CodeAPI.accessThis(), pos)
            ++pos
        }

        val collect = parameters
                .map({ codeParameter -> CodeAPI.accessLocalVariable(codeParameter.requiredType, codeParameter.name) })
                .toList()

        frame.storeValues(collect, pos)
    }

    fun fixParametersNames(parameters: List<CodeParameter>, parametersNodes: List<ParameterNode>, frame: EmulatedFrame): List<CodeParameter> =
        parameters.mapIndexed { i, parameter ->

            val nodeName = if(parametersNodes.size > i) parametersNodes[i].name else null

            val info = frame.getInfo(i)
            val name: String = info?.name ?: nodeName ?: parameter.name
            val type: CodeType = info?.type ?: parameter.requiredType

            return@mapIndexed parameter.setName(name).setType(type)
        }

    inline fun readParameters(nodes: List<ParameterNode>, nameFunc: (Int, String) -> Unit) {
        nodes.forEachIndexed { i, parameterNode ->
            nameFunc(i, parameterNode.name)
        }
    }

    inline fun readVariableTable(nodes: List<LocalVariableNode>, typeResolver: TypeResolver, storeFunc: (Int, CodeType, String) -> Unit) {
        nodes.forEach {
            val signatureType = it.signature?.let { GenericUtil.Read.parse(typeResolver, it)?.types?.get(0) }
            val type = signatureType ?: typeResolver.resolveUnknown(it.desc)
            val name = it.name
            val index = it.index
            storeFunc(index, type, name)
        }
    }

    private fun createInstruction(visitorConsumer: (MethodVisitor) -> Unit): InstructionCodePart {
        return InstructionCodePart { value, extraData, visitorGenerator, additional -> visitorConsumer((additional as MVData).methodVisitor) }
    }

    private class NEW internal constructor(val codeType: CodeType) : CodePart

    private class UnsizedArray(arrayType: CodeType, dimensions: Array<CodePart>, arguments: List<CodeArgument>) : ArrayConstructorImpl(arrayType, dimensions, arguments) {

        override fun getDimensions(): Array<CodePart> {
            return arrayOf(Literals.INT(this.arguments.size))
        }
    }

    private class SizedArray(arrayType: CodeType, dimensions: Array<CodePart>, arguments: List<CodeArgument>) : ArrayConstructorImpl(arrayType, dimensions, arguments)

}