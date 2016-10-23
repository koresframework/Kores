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
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.interfaces.AccessSuper;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.Bodied;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.Extender;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.asm.ParameterVisitor;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.VoidVisitor;
import com.github.jonathanxd.iutils.data.MapData;

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
public class CodeMethodVisitor implements VoidVisitor<MethodDeclaration, BytecodeClass, Object>, Opcodes {

    public static final CodeMethodVisitor INSTANCE = new CodeMethodVisitor();

    public static void declareFinalFields(VisitorGenerator<?> visitorGenerator, CodeSource methodBody, TypeDeclaration typeDeclaration, MethodVisitor mv, MapData extraData, MVData mvData) {

        if (searchInitThis(typeDeclaration, methodBody)) {
            // Calling this() will redirect to a constructor that initialize variables
            return;
        }

        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                typeDeclaration.getBody().orElseThrow(NullPointerException::new),
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);

        for (FieldDeclaration codeField : all) {

            Optional<CodePart> valueOpt = codeField.getValue();

            if (valueOpt.isPresent()) {
                CodePart value = valueOpt.get();

                Label labeln = new Label();

                mv.visitLabel(labeln);
                mv.visitVarInsn(ALOAD, 0);
                visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

                mv.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), codeField.getName(), Common.codeTypeToFullAsm(codeField.getType().get()));
            }

        }
    }

    public static CodeSource finalFieldsToSource(CodeSource classSource, MapData extraData) {
        CodeSource codeSource = new CodeSource();
        /**
         * Declare variables
         */
        Collection<FieldDeclaration> all = CodeSourceUtil.find(
                classSource,
                codePart ->
                        codePart instanceof CodeField
                                && !((CodeField) codePart).getModifiers().contains(CodeModifier.STATIC)
                                && ((CodeField) codePart).getValue().isPresent(),
                codePart -> (CodeField) codePart);

        for (FieldDeclaration codeField : all) {

            CodeType type = codeField.getVariableType();
            String name = codeField.getName();
            Optional<CodePart> value = codeField.getValue();

            if (value.isPresent()) {
                codeSource.add(Helper.setThisVariable(name, type, value.get()));
            }
        }

        return codeSource;
    }

    public static void generateSuperInvoke(TypeDeclaration typeDeclaration, MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);

        CodeType superType = ((Extender) typeDeclaration).getSuperType().orElse(null);
        if (superType == null) {
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        } else {
            mv.visitMethodInsn(INVOKESPECIAL, Common.codeTypeToSimpleAsm(superType), "<init>", "()V", false);
        }
    }

    public static boolean isInitForThat(TypeDeclaration typeDeclaration, MethodInvocation methodInvocation) {
        boolean any = ((typeDeclaration instanceof Extender) && ((Extender) typeDeclaration).getSuperType().filter(c -> methodInvocation.getLocalization().orElse(null).compareTo(c) == 0).isPresent());

        boolean accept = (methodInvocation.getTarget().orElse(null) instanceof AccessThis || methodInvocation.getTarget().orElse(null) instanceof AccessSuper);

        return any
                && accept
                && methodInvocation.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                && methodInvocation.getSpec().getMethodName().equals("<init>");

    }

    public static boolean searchForInitTo(TypeDeclaration typeDeclaration, CodeSource codeParts, Predicate<CodePart> targetAccessPredicate) {
        if (codeParts == null)
            return false;

        for (CodePart codePart : codeParts) {
            if (codePart instanceof Bodied) {
                if (searchForSuper(typeDeclaration, ((Bodied) codePart).getBody().orElse(null))) {
                    return true;
                }
            }

            if (codePart instanceof MethodInvocation) {
                MethodInvocation mi = (MethodInvocation) codePart;

                boolean any = ((typeDeclaration instanceof Extender) && ((Extender) typeDeclaration).getSuperType().filter(c -> mi.getLocalization().orElse(null).compareTo(c) == 0).isPresent());

                if (any
                        && targetAccessPredicate.test(mi.getTarget().orElse(null))
                        && mi.getInvokeType().equals(InvokeType.INVOKE_SPECIAL)

                        && mi.getSpec().getMethodName().equals("<init>")) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean searchInitThis(TypeDeclaration typeDeclaration, CodeSource codeParts) {
        return searchForInitTo(typeDeclaration, codeParts, codePart -> codePart instanceof AccessThis);
    }

    public static boolean searchForSuper(TypeDeclaration typeDeclaration, CodeSource codeParts) {
        return searchForInitTo(typeDeclaration, codeParts, codePart -> codePart instanceof AccessSuper);
    }

    @Override
    public void voidVisit(MethodDeclaration codeMethod, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, Object additional) {

        boolean isConstructor = codeMethod instanceof ConstructorDeclaration;


        TypeDeclaration typeDeclaration = extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION, "Cannot find CodeClass. Register 'TypeVisitor.CODE_TYPE_REPRESENTATION'!");

        ClassWriter cw = Util.find(TypeVisitor.CLASS_WRITER_REPRESENTATION, extraData, additional);

        Optional<CodeSource> bodyOpt = codeMethod.getBody();

        Collection<CodeModifier> modifiers = new ArrayList<>(codeMethod.getModifiers());

        if (!isConstructor && ((!codeMethod.hasBody()) && !modifiers.contains(CodeModifier.ABSTRACT))) {
            modifiers.add(CodeModifier.ABSTRACT);
        }

        int asmModifiers = Common.modifierToAsm(modifiers);

        List<CodeParameter> parameters = codeMethod.getParameters();
        String asmParameters = Common.parametersToAsm(parameters);


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
            Common.parametersToVars(parameters,/* to */ vars);
        } else {
            vars.add(new Variable("this", typeDeclaration, null, null));
            Common.parametersToVars(parameters, /* to */ vars);
        }

        MVData mvData = new MVData(mv, vars);

        visitorGenerator.generateTo(Annotable.class, codeMethod, extraData, null, mvData);

        for (int i = 0; i < parameters.size(); i++) {
            CodeParameter codeParameter = parameters.get(i);

            visitorGenerator.generateTo(Annotable.class, codeParameter, extraData, null, new ParameterVisitor(mvData, i));
        }

        if (codeMethod.hasBody() || isConstructor) {
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);

            CodeSource bodySource = bodyOpt.orElse(null);

            CodeSource methodSource = bodySource == null ? null : new CodeSource(bodySource);

            boolean isGenerated = false;

            if (typeDeclaration instanceof ClassDeclaration && isConstructor) {
                if (!searchForSuper(typeDeclaration, methodSource)) {
                    CodeMethodVisitor.generateSuperInvoke(typeDeclaration, mv);
                    isGenerated = true;
                }
            }

            if (isConstructor) {
                if (isGenerated) {
                    CodeMethodVisitor.declareFinalFields(visitorGenerator, methodSource, typeDeclaration, mv, extraData, mvData);
                } else {


                    methodSource =
                            CodeSourceUtil.insertAfter(
                                    part -> part instanceof MethodInvocation && CodeMethodVisitor.isInitForThat(typeDeclaration, (MethodInvocation) part),
                                    CodeMethodVisitor.finalFieldsToSource(typeDeclaration.getBody().orElseThrow(NullPointerException::new), extraData),
                                    methodSource);
                }
            }

            if (methodSource != null) {
                visitorGenerator.generateTo(CodeSource.class, methodSource, extraData, null, mvData);
            }

            /**
             * Instructions here
             */

            String returnType = codeMethod.getReturnType().orElse(PredefinedTypes.VOID).getJavaSpecName();
            if (returnType.equals("V")) {
                mv.visitInsn(RETURN);
            }
            try {
                mv.visitMaxs(0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Label end = new Label();

            mv.visitLabel(end);

            mvData.visitVars(l0, end);

        }


        mv.visitEnd();
    }

}
