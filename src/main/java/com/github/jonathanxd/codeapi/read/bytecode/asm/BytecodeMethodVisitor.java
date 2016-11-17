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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.Environment;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor.InstructionCodePart;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.ArrayConstructorImpl;
import com.github.jonathanxd.codeapi.impl.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.impl.MethodSpecImpl;
import com.github.jonathanxd.codeapi.interfaces.ArrayConstructor;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead;
import com.github.jonathanxd.codeapi.read.bytecode.EmulatedFrame;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.DescriptionHelper;
import com.github.jonathanxd.codeapi.util.gen.ArrayUtil;
import com.github.jonathanxd.codeapi.util.gen.CodePartUtil;
import com.github.jonathanxd.codeapi.util.gen.MethodInvocationUtil;
import com.github.jonathanxd.iutils.description.Description;
import com.github.jonathanxd.iutils.description.DescriptionUtil;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
        int pos = 0;

        if (!this.method.getModifiers().contains(CodeModifier.STATIC)) {
            this.frame.store(CodeAPI.accessThis(), pos);
            ++pos;
        }

        List<VariableAccess> collect = this.parameterList.stream()
                .map(codeParameter -> CodeAPI.accessLocalVariable(codeParameter.getRequiredType(), codeParameter.getName()))
                .collect(Collectors.toList());

        this.frame.storeValues(collect, pos);
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

        label:
        {
            // Break on opcodes that will be parsed by another method (like visitVarInsn)

            switch (opcode) {
                case NOP:
                case POP: // Ignore POP
                case POP2: // Ignore POP
                case DUP: // Handling DUP* is very hard for CodeAPI
                case DUP_X1:
                case DUP_X2:
                case DUP2:
                case DUP2_X1:
                case DUP2_X2:
                case SWAP: // Need review
                case LCMP: // TODO: If Expression translation
                case FCMPL:
                case FCMPG:
                case DCMPL:
                case DCMPG:
                case MONITORENTER: // No equivalent
                case MONITOREXIT: // No equivalent
                    break label;
            }

            CodePart value = null;

            if (opcode == ACONST_NULL)
                value = Literals.NULL;

            if (opcode == ICONST_M1)
                value = Literals.INT(-1);

            if (opcode == ICONST_0)
                value = Literals.INT(0);

            if (opcode == ICONST_1)
                value = Literals.INT(1);

            if (opcode == ICONST_2)
                value = Literals.INT(2);

            if (opcode == ICONST_3)
                value = Literals.INT(3);

            if (opcode == ICONST_4)
                value = Literals.INT(4);

            if (opcode == ICONST_5)
                value = Literals.INT(5);

            if (opcode == LCONST_0)
                value = Literals.LONG(0L);

            if (opcode == LCONST_1)
                value = Literals.LONG(1L);

            if (opcode == FCONST_0)
                value = Literals.FLOAT(0F);

            if (opcode == FCONST_1)
                value = Literals.FLOAT(1F);

            if (opcode == FCONST_2)
                value = Literals.FLOAT(2F);

            if (opcode == DCONST_0)
                value = Literals.DOUBLE(0D);

            if (opcode == DCONST_1)
                value = Literals.DOUBLE(1D);

            if (opcode >= I2L && opcode <= I2S) {
                value = CodePartUtil.Conversion.handleConversion(opcode, this.frame.getOperandStack().pop());
            }

            if (opcode >= INEG && opcode <= DNEG) {
                value = CodePartUtil.Conversion.handleNegation(opcode, this.frame.getOperandStack().pop());
            }

            if (opcode >= IADD && opcode <= LXOR) {
                List<CodePart> pop = this.frame.getOperandStack().pop(2);

                value = CodePartUtil.Conversion.handleMathAndBitwise(opcode, pop.get(0), pop.get(1));
            }

            if (opcode >= IRETURN && opcode <= RETURN) {
                value = CodePartUtil.Conversion.handleReturn(opcode, opcode == RETURN ? null : this.frame.getOperandStack().pop());
            }

            if (opcode == ARRAYLENGTH) {
                value = CodeAPI.getArrayLength(this.frame.getOperandStack().popAs(VariableAccess.class));
            }

            if (opcode == ATHROW) {
                value = CodeAPI.throwException(this.frame.getOperandStack().pop());
            }

            if (opcode == IASTORE || opcode == LASTORE || opcode == FASTORE || opcode == DASTORE || opcode == AASTORE || opcode == BASTORE || opcode == CASTORE || opcode == SASTORE) {

                List<CodePart> pop = this.frame.getOperandStack().pop(3);

                CodePart array = pop.get(0); // Removed
                CodePart position = pop.get(1);
                CodePart valueToInsert = pop.get(2);

                if (array instanceof ArrayConstructor) {
                    ArrayConstructor newarray_ = (ArrayConstructor) array;

                    List<CodeArgument> arguments = new ArrayList<>(newarray_.getArguments());

                    arguments.add(new CodeArgument(valueToInsert, CodePartUtil.getTypeOrNull(valueToInsert)));

                    newarray_ = newarray_.setArguments(arguments);

                    value = newarray_; // Will be Added
                } else {
                    VariableAccess access = (VariableAccess) array;

                    value = CodeAPI.setArrayValue(access.getVariableType(), access, position, valueToInsert);
                }

            }

            if(opcode == IALOAD || opcode == LALOAD || opcode == FALOAD || opcode == DALOAD || opcode == BALOAD || opcode == CALOAD || opcode == SALOAD) {
                // Load array values
                List<CodePart> pop = this.frame.getOperandStack().pop(2);

                VariableAccess array = (VariableAccess) pop.get(0);
                CodePart position = pop.get(1);

                value = CodeAPI.getArrayValue(array.getVariableType(), array, position);
            }
            if (value == null)
                logger.log(Level.WARNING, "Cannot parse insn opcode: '" + opcode + "'");

            if (value != null)
                this.frame.getOperandStack().push(value);
        }

        super.visitInsn(opcode);


        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitInsn(opcode)));
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        super.visitIntInsn(opcode, operand);

        if (opcode == BIPUSH) {
            this.frame.getOperandStack().push(Literals.BYTE((byte) operand));
        } else if (opcode == SIPUSH) {
            this.frame.getOperandStack().push(Literals.SHORT((short) operand));
        } else if (opcode == ANEWARRAY) {
            CodeType arrayType = ArrayUtil.getArrayType(operand);

            this.frame.getOperandStack().push(new UnsizedArray(arrayType, new CodePart[0], Collections.emptyList()));
        }

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitIntInsn(opcode, operand)));
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        super.visitVarInsn(opcode, var);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitVarInsn(opcode, var)));
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        super.visitTypeInsn(opcode, type);

        CodeType codeType = this.environment.resolveUnknown(type);

        if (opcode == Opcodes.NEW) {
            this.frame.getOperandStack().push(new NEW(codeType));
        } else {
            if (opcode == Opcodes.CHECKCAST) {
                CodePart codePart = this.frame.getOperandStack().pop();

                this.frame.getOperandStack().push(CodeAPI.cast(CodePartUtil.getTypeOrNull(codePart), codeType, codePart));
            } else {
                System.err.println("visitTypeInsn: [" + opcode + ", " + type + "]");
                this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitTypeInsn(opcode, type)));
            }
        }

    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        super.visitFieldInsn(opcode, owner, name, desc);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitFieldInsn(opcode, owner, name, desc)));
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        super.visitMethodInsn(opcode, owner, name, desc);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitMethodInsn(opcode, owner, name, desc)));
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        super.visitMethodInsn(opcode, owner, name, desc, itf);

        try {
            // Resolve the method owner type
            CodeType ownerType = this.environment.resolve(owner, itf);

            // Parse the method description
            Description description = DescriptionUtil.parseDescription(ownerType.getJavaSpecName() + ":" + name + desc);

            // Get number of arguments
            int arguments = description.getParameterTypes().length;

            // Pop all arguments from operand stack
            List<CodePart> pop = this.frame.getOperandStack().pop(arguments);

            // Create argument array
            CodeArgument[] argumentsArray = pop.stream().map(CodeArgument::new).toArray(CodeArgument[]::new);

            // Gets the invocation type from asm opcode
            InvokeType invokeType = InvokeType.fromAsm(opcode);

            // Invocation target part
            CodePart target = null;

            // If the invocation type is not static
            if (invokeType != InvokeType.INVOKE_STATIC) {
                // Pops the invocation target from operand stack
                target = this.frame.getOperandStack().pop();
            }

            // Create TypeSpecification from the method description
            TypeSpec spec = DescriptionHelper.toTypeSpec(description, this.environment.getTypeResolver());

            // Create the method specification
            MethodSpecification methodSpec = new MethodSpecImpl(
                    name,
                    // Resolve return type
                    this.environment.resolveUnknown(description.getReturnType()),
                    // Specify arguments
                    Arrays.asList(argumentsArray)
            );

            // Method invocation part
            MethodInvocation methodInvocation;

            if (target != null && target instanceof NEW) {
                // Create invocation of a constructor of a class
                methodInvocation = CodeAPI.invokeConstructor(((NEW) target).getCodeType(), spec, argumentsArray);
            } else {
                // If target is not a constructor (NEW)
                // If invoke type is special, create a super/this constructor invocation
                if (invokeType == InvokeType.INVOKE_SPECIAL) {
                    // If method type is same as method declaring type
                    if (ownerType.is(this.declaringType)) {
                        // Create this constructor invocation
                        methodInvocation = CodeAPI.invokeThisConstructor(spec, argumentsArray);
                    } else {
                        // If is not same, invoke super class constructor
                        methodInvocation = CodeAPI.invokeSuperConstructor(ownerType, spec, argumentsArray);
                    }
                } else {
                    // If is not invoke special, invoke normally.
                    methodInvocation = Helper.invoke(invokeType, ownerType, target, methodSpec);
                }
            }

            if (!methodSpec.getMethodDescription().getReturnType().is(PredefinedTypes.VOID)
                    || target instanceof NEW) {
                this.frame.getOperandStack().push(methodInvocation);
            } else {
                this.addToBody(methodInvocation);
            }

        } catch (Exception e) {
            System.err.println("Method -> " + owner + ":" + name + desc);
            e.printStackTrace();

            this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitMethodInsn(opcode, owner, name, desc, itf)));
        }
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);

        try {
            // Parse bootstrap method description
            Description description = DescriptionUtil.parseDescription("L?;:" + name + desc);

            // Get number of arguments
            int arguments = description.getParameterTypes().length;

            // Pop arguments from stack
            List<CodePart> pop = this.frame.getOperandStack().pop(arguments);

            // Create a list of arguments
            List<CodeArgument> argumentList = pop.stream().map(CodeArgument::new).collect(Collectors.toList());

            // Specify InvokeType as Dynamic
            InvokeType invokeType = InvokeType.INVOKE_DYNAMIC;

            // Create TypeSpec from bootstrap method description
            TypeSpec typeSpec = DescriptionHelper.toTypeSpec(description, this.environment.getTypeResolver());

            // Create method specification of bootstrap method
            MethodSpecification methodSpec = new MethodSpecImpl(name, typeSpec, argumentList);

            // Create dynamic invocation of the bootstrap method
            InvokeDynamic invokeDynamic = MethodInvocationUtil.fromHandle(bsm, bsmArgs, this.environment.getTypeResolver());

            // Create a method invocation of the bootstrap method
            MethodInvocation methodInvocation = new MethodInvocationImpl(invokeType, null, null, methodSpec);

            // Create Dynamic invocation version of 'methodInvocation'
            MethodInvocation dynamicMethodInvocation = Helper.invokeDynamic(invokeDynamic, methodInvocation);

            // Add invocation to the body
            //this.addToBody(dynamicMethodInvocation);

            if (!methodSpec.getMethodDescription().getReturnType().is(PredefinedTypes.VOID)) {
                // BAD MANIPULATION MAY GENERATE A INFINITE LOOP.
                this.frame.getOperandStack().push(dynamicMethodInvocation);
            }

        } catch (Exception e) {
            System.err.println("Method -> ?:" + name + desc);
            e.printStackTrace();
            this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs)));
        }

    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        super.visitJumpInsn(opcode, label);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitJumpInsn(opcode, label)));
    }

    @Override
    public void visitLabel(Label label) {
        super.visitLabel(label);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitLabel(label)));
    }

    @Override
    public void visitLdcInsn(Object cst) {

        super.visitLdcInsn(cst);

        //this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitLdcInsn(cst)));
        if (CodePartUtil.Conversion.isLiteral(cst)) {
            Literal literal = CodePartUtil.Conversion.toLiteral(cst);

            this.frame.getOperandStack().push(literal);
        }

    }

    @Override
    public void visitIincInsn(int var, int increment) {
        super.visitIincInsn(var, increment);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitIincInsn(var, increment)));
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        super.visitTableSwitchInsn(min, max, dflt, labels);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitTableSwitchInsn(min, max, dflt, labels)));
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        super.visitLookupSwitchInsn(dflt, keys, labels);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitLookupSwitchInsn(dflt, keys, labels)));
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        super.visitMultiANewArrayInsn(desc, dims);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitMultiANewArrayInsn(desc, dims)));
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitInsnAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        super.visitTryCatchBlock(start, end, handler, type);

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitTryCatchBlock(start, end, handler, type)));
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

        this.addToBody(this.createInstruction(methodVisitor -> methodVisitor.visitLineNumber(line, start)));
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
