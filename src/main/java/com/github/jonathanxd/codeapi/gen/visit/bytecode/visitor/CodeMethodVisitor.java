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
package com.github.jonathanxd.codeapi.gen.visit.bytecode.visitor;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.CodeParameter;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.interfaces.Annotable;
import com.github.jonathanxd.codeapi.interfaces.ClassDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodDeclaration;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.options.CodeOptions;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.asm.ParameterVisitor;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class CodeMethodVisitor implements VoidVisitor<MethodDeclaration, BytecodeClass, Object>, Opcodes {

    public static final CodeMethodVisitor INSTANCE = new CodeMethodVisitor();


    @Override
    public void voidVisit(MethodDeclaration codeMethod, MapData extraData, VisitorGenerator<BytecodeClass> visitorGenerator, Object additional) {

        boolean validateSuper = visitorGenerator.getOptions().getOrElse(CodeOptions.VALIDATE_SUPER, true);
        boolean validateThis = visitorGenerator.getOptions().getOrElse(CodeOptions.VALIDATE_THIS, true);

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


        String signature = Common.methodGenericSignature(codeMethod);

        String methodName = codeMethod.getName();

        if (codeMethod instanceof ConstructorDeclaration) {
            methodName = "<init>";
        }

        org.objectweb.asm.MethodVisitor mv = cw.visitMethod(asmModifiers, methodName, "(" + asmParameters + ")" + codeMethod.getReturnType().orElse(PredefinedTypes.VOID).getJavaSpecName(), signature, null);

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

            CodeSource methodSource = bodySource == null ? null : CodeSource.fromIterable(bodySource);

            boolean isGenerated = false;

            boolean initSuper = Common.searchForSuper(typeDeclaration, methodSource, validateSuper);
            boolean initThis = Common.searchInitThis(typeDeclaration, methodSource, validateThis);

            if (typeDeclaration instanceof ClassDeclaration && isConstructor) {
                if (!initSuper && !initThis) {
                    Common.generateSuperInvoke(typeDeclaration, mv);
                    isGenerated = true;
                }
            }

            if (isConstructor) {
                if (isGenerated) {
                    Common.declareFinalFields(visitorGenerator, methodSource, typeDeclaration, mv, extraData, mvData, validateThis);
                } else {
                    if (!initThis) {
                        methodSource =
                                CodeSourceUtil.insertAfter(
                                        part -> part instanceof MethodInvocation && Common.isInitForThat(typeDeclaration, (MethodInvocation) part),
                                        Common.finalFieldsToSource(typeDeclaration.getBody().orElseThrow(NullPointerException::new)),
                                        methodSource);
                    }
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
