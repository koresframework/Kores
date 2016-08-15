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
package com.github.jonathanxd.codeapi.visitgenerator.bytecode;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.InterfaceDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by jonathan on 03/06/16.
 */
public class CodeMethodVisitor implements Visitor<MethodDeclaration, Byte, Object>, Opcodes {

    public static final CodeMethodVisitor INSTANCE = new CodeMethodVisitor();

    public static void declareFinalFields(VisitorGenerator<?> visitorGenerator, CodeSource methodBody, InterfaceDeclaration codeInterface, MethodVisitor mv, MapData extraData, Navigator<CodePart> navigator, MVData mvData) {

        if (searchInitThis(codeInterface, methodBody)) {
            // Calling this() will redirect to a constructor that initialize variables
            return;
        }

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = extraData.getAll(FieldVisitor.FIELDS_TO_ASSIGN);

        for (FieldDeclaration codeField : all) {

            CodePart value = codeField.getValue().get();

            Label labeln = new Label();

            mv.visitLabel(labeln);
            mv.visitVarInsn(ALOAD, 0);
            visitorGenerator.generateTo(value.getClass(), value, extraData, navigator, null, mvData);

            mv.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(codeInterface), codeField.getName(), Common.codeTypeToFullAsm(codeField.getType().get()));
        }
    }

    public static CodeSource finalFieldsToSource(MapData extraData) {
        CodeSource codeSource = new CodeSource();
        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = extraData.getAll(FieldVisitor.FIELDS_TO_ASSIGN);

        for (FieldDeclaration codeField : all) {
            CodeType type = codeField.getVariableType();
            String name = codeField.getName();
            Optional<CodePart> value = codeField.getValue();

            codeSource.add(Helper.setThisVariable(name, type, value.get()));
        }

        return codeSource;
    }

    public static void generateSuperInvoke(InterfaceDeclaration codeInterface, MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);

        CodeType superType = ((ClassDeclaration) codeInterface).getSuperType().orElse(null);
        if (superType == null) {
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        } else {
            mv.visitMethodInsn(INVOKESPECIAL, Common.codeTypeToSimpleAsm(superType), "<init>", "()V", false);
        }
    }

    public static boolean isInitForThat(InterfaceDeclaration codeInterface, MethodInvocation methodInvocation) {
        boolean any = ((codeInterface instanceof ClassDeclaration) && ((ClassDeclaration) codeInterface).getSuperType().filter(c -> methodInvocation.getLocalization().compareTo(c) == 0).isPresent());

        boolean accept = (methodInvocation.getTarget() instanceof AccessThis || methodInvocation.getTarget() instanceof AccessSuper);
        if (any
                && accept
                && methodInvocation.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                && methodInvocation.getSpec().getMethodName().equals("<init>")) {
            return true;
        }

        return false;
    }

    public static boolean searchForInitTo(InterfaceDeclaration codeInterface, CodeSource codeParts, Predicate<CodePart> targetAccessPredicate) {
        if (codeParts == null)
            return false;

        for (CodePart codePart : codeParts) {
            if (codePart instanceof Bodied) {
                if (searchForSuper(codeInterface, ((Bodied) codePart).getBody().orElse(null))) {
                    return true;
                }
            }

            if (codePart instanceof MethodInvocation) {
                MethodInvocation mi = (MethodInvocation) codePart;

                boolean any = ((codeInterface instanceof ClassDeclaration) && ((ClassDeclaration) codeInterface).getSuperType().filter(c -> mi.getLocalization().compareTo(c) == 0).isPresent());

                if (any
                        && targetAccessPredicate.test(mi.getTarget())
                        && mi.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                        && mi.getSpec().getMethodName().equals("<init>")) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean searchInitThis(InterfaceDeclaration codeInterface, CodeSource codeParts) {
        return searchForInitTo(codeInterface, codeParts, codePart -> codePart instanceof AccessThis);
    }

    public static boolean searchForSuper(InterfaceDeclaration codeInterface, CodeSource codeParts) {
        return searchForInitTo(codeInterface, codeParts, codePart -> codePart instanceof AccessSuper);
    }

    @Override
    public Byte[] visit(MethodDeclaration codeMethod, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

        boolean isConstructor = codeMethod instanceof ConstructorDeclaration;


        InterfaceDeclaration codeInterface = extraData.getRequired(InterfaceVisitor.CODE_INTERFACE_REPRESENTATION);

        ClassWriter cw = extraData.getRequired(InterfaceVisitor.CLASS_WRITER_REPRESENTATION);

        Optional<CodeSource> bodyOpt = codeMethod.getBody();

        Collection<CodeModifier> modifiers = new ArrayList<>(codeMethod.getModifiers());

        if (!isConstructor && ((!codeMethod.hasBody()) && !modifiers.contains(CodeModifier.ABSTRACT))) {
            modifiers.add(CodeModifier.ABSTRACT);
        }

        int asmModifiers = Common.modifierToAsm(modifiers);


        String asmParameters = Common.parametersToAsm(codeMethod.getParameters());


        // Important: Method Visitor

        String signature = Common.methodGenericSignature(codeMethod);

        String methodName = codeMethod.getName();

        if (codeMethod instanceof ConstructorDeclaration) {
            methodName = "<init>";
        }

        org.objectweb.asm.MethodVisitor mv = cw.visitMethod(asmModifiers, methodName, "(" + asmParameters + ")" + codeMethod.getReturnType().orElse(PredefinedTypes.VOID).getJavaSpecName(), signature, null);

        //mv.visitVarInsn(ALOAD, 1);
        final List<Variable> vars = new ArrayList<>();


        if (modifiers.contains(CodeModifier.STATIC)) {
            Common.parametersToVars(codeMethod.getParameters(),/* to */ vars);
        } else {
            vars.add(new Variable("this", codeInterface, null, null));
            Common.parametersToVars(codeMethod.getParameters(), /* to */ vars);
        }

        MVData mvData = new MVData(mv, vars);

        if (codeMethod.hasBody() || isConstructor) {
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);

            CodeSource bodySource = bodyOpt.orElse(null);

            CodeSource methodSource = bodySource == null ? null : new CodeSource(bodySource);

            boolean isGenerated = false;

            if (codeInterface instanceof ClassDeclaration && isConstructor) {
                if (!searchForSuper(codeInterface, methodSource)) {
                    CodeMethodVisitor.generateSuperInvoke(codeInterface, mv);
                    isGenerated = true;
                }
            }

            if (isConstructor) {
                if (isGenerated) {
                    CodeMethodVisitor.declareFinalFields(visitorGenerator, methodSource, codeInterface, mv, extraData, navigator, mvData);
                } else {


                    methodSource =
                            CodeSourceUtil.insertAfter(
                                    part -> part instanceof MethodInvocation && CodeMethodVisitor.isInitForThat(codeInterface, (MethodInvocation) part),
                                    CodeMethodVisitor.finalFieldsToSource(extraData),
                                    methodSource);
                }
            }

            if (methodSource != null) {
                visitorGenerator.generateTo(CodeSource.class, methodSource, extraData, navigator, null, mvData);
            }

            /**
             * Instructions here
             */

            String returnType = codeMethod.getReturnType().orElse(PredefinedTypes.VOID).getJavaSpecName();
            if (returnType.equals("V")) {
                mv.visitInsn(RETURN);
            }

            mv.visitMaxs(0, 0);

            Label end = new Label();

            mv.visitLabel(end);

            mvData.visitVars(l0, end);

        }


        mv.visitEnd();

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, MethodDeclaration codeMethod, MapData extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

    }
}
