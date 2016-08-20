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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.MethodInvocationImpl;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableStore;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.read.bytecode.CommonRead;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.description.Description;
import com.github.jonathanxd.codeapi.util.description.DescriptionUtil;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by jonathan on 19/08/16.
 */
public class BytecodeMethodVisitor extends MethodVisitor {

    private final CodeInterface codeInterface;
    private final CodeMethod method;
    private final List<CodeSource> bodies = new ArrayList<>();
    private final List<Label> endLabels = new ArrayList<>();
    private final List<CodeType> type_list = new ArrayList<>();
    private final Stack<CodePart> local_stack = new Stack<>();
    private final Stack<CodePart> operand_stack = new Stack<>();
    private int var = 0;

    public BytecodeMethodVisitor(CodeInterface codeInterface, CodeMethod method, int api) {
        super(api);
        this.codeInterface = codeInterface;
        this.method = method;
        this.init();
    }

    public BytecodeMethodVisitor(CodeInterface codeInterface, CodeMethod method, int api, MethodVisitor mv) {
        super(api, mv);
        this.codeInterface = codeInterface;
        this.method = method;
        this.init();
    }

    protected void init() {
        boolean isStatic = this.method.getModifiers().contains(CodeModifier.STATIC);

        if (!isStatic) {
            this.local_stack.push(new CodeField("this", codeInterface));
        }

        for (CodeParameter codeParameter : this.method.getParameters()) {
            this.local_stack.push(new CodeField(codeParameter.getName(), codeParameter.getType()));
        }

        this.bodies.add(method.getBody().orElseThrow(IllegalStateException::new));
    }

    @Override
    public void visitParameter(String name, int access) {

        System.out.println("Visit param = " + name + " mods: " + CommonRead.modifiersFromAccess(access));

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

        try {
            CodeType type = CommonRead.typeFromOpcode(opcode);

            if (CommonRead.isConstant(opcode)) {
                this.operand_stack.push(CommonRead.toLiteral(opcode));
            } else if (CommonRead.isReturn(opcode)) {
                if(!CommonRead.isVoidReturn(opcode)) {
                    CodePart codePart = this.take(1).get(0);

                    this.getBody().add(Helper.returnValue(type, codePart));
                    //this.operand_stack.push();
                }
            } else {
                System.err.println("visitInsn: ["+opcode+"]? Type = "+type);
            }
        } catch (Exception e) {
            System.err.println("visitInsn: ["+opcode+"]");
            e.printStackTrace();
        }

        super.visitInsn(opcode);
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        try {
            Literal literal = CommonRead.intInsnToLiteral(opcode, operand);

            this.operand_stack.push(literal);
        }catch (Exception e) {
            System.err.println("visitIntInsn: ["+opcode+", "+operand+"]");
            e.printStackTrace();
        }
        super.visitIntInsn(opcode, operand);
    }

    @Override
    public void visitVarInsn(int opcode, int index) {

        CodeType type = CommonRead.typeFromOpcode(opcode);

        if (CommonRead.isStore(opcode)) {
            try {

                CodePart toStore = this.take(1).get(0);
                CodeField codeField = new CodeField("var"+this.var, type, toStore);
                this.var++;

                if (this.local_stack.size() <= index) {
                    if(this.local_stack.size() == index) {
                        this.local_stack.push(codeField);
                    } else {
                        throw new RuntimeException("Cannot store at index: '"+index+"'. Local Stack: "+this.local_stack);
                    }

                } else {
                    this.local_stack.set(index, codeField);
                }

                this.getBody().add(codeField);

            } catch (Exception e) {
                System.out.println("VAR INSN: " + opcode + " _ " + index + ", TYPE = "+type);
                e.printStackTrace();
            }
        } else if (CommonRead.isLoad(opcode)) {
            try {
                CodePart codePart = this.local_stack.get(index);

                if(codePart instanceof CodeField) {
                    CodeField field = (CodeField) codePart;

                    VariableAccess variableAccess = Helper.accessLocalVariable(field.getName(), field.getVariableType());

                    this.operand_stack.push(variableAccess);
                } else {
                    throw new RuntimeException("LocalStack = "+this.local_stack+". OperandStack = "+this.operand_stack+", NOT A FIELD: "+codePart);
                }
            }catch (Exception e) {
                throw new RuntimeException("LocalStack = "+this.local_stack, e);
            }
        } else {
            System.err.println("visitVarInsn: ["+opcode+", "+index+"]? Type = "+type);
        }


        super.visitVarInsn(opcode, index);
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        CodeType codeType = CommonRead.toCodeType(type);

        if(opcode == Opcodes.NEW) {
            this.operand_stack.push(new NEW(codeType));
        } else {
            if(opcode == Opcodes.CHECKCAST) {
                CodePart codePart = this.take(1).get(0);

                this.operand_stack.push(Helper.cast(Common.getType(codePart), codeType, codePart));
            } else {
                System.err.println("visitTypeInsn: ["+opcode+", "+type+"]");
            }
        }

        super.visitTypeInsn(opcode, type);
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        if(opcode == Opcodes.GETFIELD || opcode == Opcodes.GETSTATIC) {

            VariableAccess variableAccess;

            if(opcode == Opcodes.GETSTATIC) {
                variableAccess = Helper.accessStaticVariable(CommonRead.toCodeType(owner), name, CommonRead.toCodeType(desc));
            } else {
                CodePart codePart = this.take(1).get(0);

                if(method.getModifiers().contains(CodeModifier.STATIC)) {
                    variableAccess = Helper.accessVariable(CommonRead.toCodeType(owner), codePart, name, CommonRead.toCodeType(desc));
                } else {

                    if(this.isThis(codePart)) {
                        variableAccess = CodeAPI.accessThisField(CommonRead.toCodeType(desc), name);
                    } else {
                        variableAccess = Helper.accessVariable(CommonRead.toCodeType(owner), codePart, name, CommonRead.toCodeType(desc));
                    }
                }
            }

            this.operand_stack.push(variableAccess);
        }else

        if(opcode == Opcodes.PUTFIELD || opcode == Opcodes.PUTSTATIC) {

            CodePart value = this.take(1).get(0);

            VariableStore variableStore;

            if(opcode == Opcodes.PUTSTATIC) {
                variableStore = Helper.setVariable(CommonRead.toCodeType(owner), name, CommonRead.toCodeType(desc), value);
            } else {
                CodePart localization = this.take(1).get(0);

                if(method.getModifiers().contains(CodeModifier.STATIC)) {
                    variableStore = Helper.setVariable(CommonRead.toCodeType(owner), localization, name, CommonRead.toCodeType(desc), value);
                } else {


                    if(this.isThis(localization)) {
                        variableStore = Helper.setThisVariable(name, CommonRead.toCodeType(desc), value);
                    } else {
                        variableStore = Helper.setVariable(CommonRead.toCodeType(owner), localization, name, CommonRead.toCodeType(desc), value);
                    }
                }
            }

            this.getBody().add(variableStore);

        } else {
            System.err.println("visitFieldInsn: ["+opcode+", "+owner+", "+name+", "+desc+"]");
        }

        super.visitFieldInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        super.visitMethodInsn(opcode, owner, name, desc);
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        try {
            CodeType ownerType = CommonRead.toCodeType(owner, itf);

            Description description = DescriptionUtil.parseDescription(ownerType.getJavaSpecName() + ":" + name + desc);

            int arguments = description.getParameterTypes().length;

            List<CodePart> take = this.take(arguments);

            InvokeType invokeType = InvokeType.fromAsm(opcode);

            CodePart localization = null;

            if (invokeType != InvokeType.INVOKE_STATIC) {
                localization = this.take(1).get(0);
            }

            MethodSpec methodSpec = new MethodSpec(name,
                    CommonRead.toCodeType(description.getReturnType()),
                    CommonRead.createArguments(description, take));

            MethodInvocation methodInvocation;

            boolean isStack = this.method.getModifiers().contains(CodeModifier.STATIC);

            if(localization != null
                    && !isStack
                    && this.isThis(localization)) {
                localization = Helper.accessThis();
            }

            if(localization != null && localization instanceof NEW) {
                //((NEW) localization).getCodeType(),
                methodInvocation = Helper.invokeConstructor(InvokeType.INVOKE_SPECIAL, ((NEW) localization).getCodeType(), ((NEW) localization).getCodeType(), methodSpec);
            } else {
                if(invokeType == InvokeType.INVOKE_SPECIAL) {
                    methodInvocation = Helper.invokeSuperInit(ownerType, methodSpec.getArguments().stream().toArray(CodeArgument[]::new));
                } else {
                    methodInvocation = Helper.invoke(invokeType, ownerType, localization, methodSpec);
                }
            }

            this.getBody().add(methodInvocation);

            if(!methodSpec.getMethodDescription().getReturnType().is(PredefinedTypes.VOID)
                    || localization instanceof NEW) {
                this.operand_stack.push(methodInvocation);
            }

        } catch (Exception e) {
            System.err.println("Method -> " + owner + ":" + name + desc);
            e.printStackTrace();
        }

        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    private boolean isThis(CodePart codePart) {
        if(codePart instanceof VariableAccess) {
            return ((VariableAccess) codePart).getName().equals("this");
        }

        return false;
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

    /**
     * Take arguments from Operand Stack
     */
    public List<CodePart> take(int amount) {
        List<CodePart> codePartList = new ArrayList<>();

        for (int x = 0; x < amount; ++x) {
            try {
                codePartList.add(this.operand_stack.pop());
            } catch (Exception e) {
                throw new RuntimeException("Taken: " + codePartList
                        + ". Local Stack: " + this.local_stack
                        + ". Operand Stack: " + this.operand_stack
                        + ".", e);
            }
        }

        Collections.reverse(codePartList);

        return codePartList;
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        try {
            Description description = DescriptionUtil.parseDescription("L?;:" + name + desc);

            int arguments = description.getParameterTypes().length;

            List<CodePart> take = this.take(arguments);

            InvokeType invokeType = InvokeType.INVOKE_DYNAMIC;

            CodePart localization = null;

            MethodSpec methodSpec = new MethodSpec(name,
                    CommonRead.toCodeType(description.getReturnType()),
                    CommonRead.createArguments(description, take));

            InvokeDynamic invokeDynamic = CommonRead.fromHandle(bsm, bsmArgs);

            MethodInvocation methodInvocation = new MethodInvocationImpl(invokeType, null, localization, methodSpec);

            MethodInvocation dynamicMethodInvocation = Helper.invokeDynamic(invokeDynamic, methodInvocation);

            this.getBody().add(dynamicMethodInvocation);

            if(!methodSpec.getMethodDescription().getReturnType().is(PredefinedTypes.VOID)) {
                // BAD MANIPULATION MAY GENERATE A INFINITE LOOP.
                this.operand_stack.push(methodInvocation);
            }

        } catch (Exception e) {
            System.err.println("Method -> ?:" + name + desc);
            e.printStackTrace();
        }

        super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {

        try {
            Operator operator = Operators.genericFromAsm(opcode);


            CodeSource source = new CodeSource();

            IfExpr check = this.convertIf(opcode);

            IfBlock ifBlock = Helper.ifExpression(Helper.createIfVal()
                    .add1(check)
                    .make(), source);

            this.getBody().add(ifBlock);
            this.bodies.add(source);
            this.endLabels.add(label);
        } catch (Exception e) {
            System.err.println("visitJumpInsn: ["+opcode+", "+label+"]");
            e.printStackTrace();
        }

        super.visitJumpInsn(opcode, label);
    }

    public IfExpr convertIf(int operator) {
        if(operator == Opcodes.IFNONNULL) {
            return Helper.checkNotNull(this.take(1).get(0));
        } else if(operator == Opcodes.IFNULL) {
            return Helper.checkNull(this.take(1).get(0));
        } else {
            List<CodePart> take = this.take(2);

            return Helper.check(take.get(0), Operators.genericFromAsm(operator), take.get(1));
        }
    }

    @Override
    public void visitLabel(Label label) {
        if(!this.endLabels.isEmpty()) {
            Label label1 = this.endLabels.get(this.endLabels.size() - 1);

            if(label1 == label) {
                this.bodies.remove(this.bodies.size() - 1);
                this.endLabels.remove(label1);
            }
        }
        super.visitLabel(label);
    }

    @Override
    public void visitLdcInsn(Object cst) {

        Literal literal = CommonRead.toLiteral(cst);

        operand_stack.add(literal);

        super.visitLdcInsn(cst);
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        super.visitIincInsn(var, increment);
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        super.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        super.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        super.visitMultiANewArrayInsn(desc, dims);
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitInsnAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        super.visitTryCatchBlock(start, end, handler, type);
    }

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        return super.visitTryCatchAnnotation(typeRef, typePath, desc, visible);
    }

    @Override
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        super.visitLocalVariable(name, desc, signature, start, end, index);
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, desc, visible);
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        super.visitLineNumber(line, start);
    }

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, maxLocals);
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
    }

    public CodeSource getBody() {
        return this.bodies.get(this.bodies.size() - 1);
    }
}
