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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.impl.AccessLocalImpl;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class StoreVariableVisitor implements VoidVisitor<VariableDeclaration, BytecodeClass, MVData>, Opcodes {

    public static final StoreVariableVisitor INSTANCE = new StoreVariableVisitor();

    @Override
    public void voidVisit(VariableDeclaration variableDeclaration,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        TypeDeclaration typeDeclaration = Util.find(TypeVisitor.CODE_TYPE_REPRESENTATION, extraData, null);

        CodeType localization = variableDeclaration.getLocalization().orElse(null);


        CodePart value = variableDeclaration.getValue().orElse(Literals.NULL);

        CodePart at = variableDeclaration.getTarget().orElse(null);

        if (at == null && localization == null) {
            additional.visitVarInsn(ALOAD, 0); // Legacy
        } else if (at != null) {
            visitorGenerator.generateTo(at.getClass(), at, extraData, null, mvData);
        }

        visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

        if (at == null) {
            if (localization != null) {
                additional.visitFieldInsn(PUTSTATIC, Common.codeTypeToSimpleAsm(localization), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            } else {
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            }
        } else {
            if (at instanceof AccessLocalImpl) {

                Optional<Variable> var = mvData.getVar(variableDeclaration.getName(), variableDeclaration.getVariableType());


                if (!var.isPresent() && !(variableDeclaration instanceof FieldDeclaration))
                    throw new RuntimeException("Missing Variable Definition. Variable: '" + variableDeclaration.getName() + "' Type: '" + variableDeclaration.getVariableType().getJavaSpecName() + "'.");
                else if (var.isPresent() && (variableDeclaration instanceof FieldDeclaration
                        && !(variableDeclaration instanceof HiddenField)))
                    throw new RuntimeException("Variable '" + variableDeclaration.getName() + "' Type: '" + variableDeclaration.getVariableType().getJavaSpecName() + "'. Already defined!");


                Label i_label = new Label();

                additional.visitLabel(i_label);

                int i;

                if (variableDeclaration instanceof HiddenField) {
                    i = mvData.storeInternalVar(variableDeclaration.getName(), variableDeclaration.getVariableType(), i_label, null)
                            .orElseThrow(() -> mvData.failStore(variableDeclaration));
                } else {
                    i = mvData.storeVar(variableDeclaration.getName(), variableDeclaration.getVariableType(), i_label, null)
                            .orElseThrow(() -> mvData.failStore(variableDeclaration));
                }

                Type type = Type.getType(variableDeclaration.getVariableType().getJavaSpecName());

                int opcode = type.getOpcode(ISTORE); // ALOAD

                additional.visitVarInsn(opcode, i);

            } else if (at instanceof AccessThis) {
                // THIS
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            } else {
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(localization), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            }
        }

    }

}
