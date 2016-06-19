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
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.PredefinedTypes;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.impl.CodeMethod;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.interfaces.Return;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class CodeMethodVisitor implements Visitor<CodeMethod, Byte, Object>, Opcodes {

    public static final CodeMethodVisitor INSTANCE = new CodeMethodVisitor();

    @Override
    public Byte[] visit(CodeMethod codeMethod, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

        CodeInterface codeInterface = extraData.getRequired(InterfaceVisitor.CODE_INTERFACE_REPRESENTATION);

        ClassWriter cw = extraData.getRequired(InterfaceVisitor.CLASS_WRITER_REPRESENTATION);

        int asm = Common.modifierToAsm(codeMethod.getModifiers());

        String asmParameters = Common.parametersToAsm(codeMethod.getParameters());

        org.objectweb.asm.MethodVisitor mv = cw.visitMethod(asm, codeMethod.getName(), "(" + asmParameters + ")"+codeMethod.getReturnType().orElse(PredefinedTypes.VOID).getJavaSpecName(), null, null);

        //mv.visitVarInsn(ALOAD, 1);
        final List<Variable> vars = new ArrayList<>();

        if(codeMethod.getModifiers().contains(CodeModifier.STATIC)) {
            Common.parametersToVars(codeMethod.getParameters(),/* to */ vars);
        } else {
            vars.add(new Variable("this", codeInterface));
            Common.parametersToVars(codeMethod.getParameters(), /* to */ vars);
        }

        MVData mvData = new MVData(mv, vars);

        mv.visitCode();
        Label l0 = new Label();
        mv.visitLabel(l0);
        /**
         * Declare variables
         */
        Optional<CodeSource> bodyOpt = codeMethod.getBody();

        if (bodyOpt.isPresent()) {
            visitorGenerator.generateTo(CodeSource.class, bodyOpt.get(), extraData, navigator, null, mvData);
        }

        /**
         * Instructions here
         */

        String returnType = codeMethod.getReturnType().orElse(null).getJavaSpecName();
        if(returnType.equals("V")) {
            mv.visitInsn(RETURN);
        } else {
            /*
            bodyOpt.ifPresent(bodye -> {
                if (!bodye.isEmpty()) {
                    CodePart codePart = bodye.get(bodye.size() - 1);

                    if (!(codePart instanceof Return)) {
                        System.err.println("Missing RETURN in method '" + codeMethod + "'");
                    }
                } else {
                    System.err.println("Missing RETURN in method '" + codeMethod + "'");
                }
            });
            */
        }

        mv.visitMaxs(0, 0);
        mv.visitEnd();

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r, CodeMethod codeMethod, Data extraData, Navigator<CodePart> navigator, VisitorGenerator<Byte> visitorGenerator, Object additional) {

    }

}
