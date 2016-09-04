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
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.helper.AccessLocalEx;
import com.github.jonathanxd.codeapi.interfaces.AccessThis;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.interfaces.VariableDeclaration;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Optional;

/**
 * Created by jonathan on 03/06/16.
 */
public class StoreVariableVisitor implements Visitor<VariableDeclaration, Byte, MVData>, Opcodes {

    public static final StoreVariableVisitor INSTANCE = new StoreVariableVisitor();

    @Override
    public Byte[] visit(VariableDeclaration variableDeclaration,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        TypeDeclaration typeDeclaration = extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION);

        CodeType localization = variableDeclaration.getLocalization();


        CodePart value = variableDeclaration.getValue().orElse(Literals.NULL);

        // AT PODE SER: AccessThis, AccessSuper ou null -> AccessLocal | AccessStatic
        CodePart at = variableDeclaration.getAt();

        if (at == null && localization == null) {
            additional.visitVarInsn(ALOAD, 0); // Legacy
        } else if (at != null) {
            visitorGenerator.generateTo(at.getClass(), at, extraData, navigator, null, mvData);
        }

        visitorGenerator.generateTo(value.getClass(), value, extraData, navigator, null, mvData);

        // IF AT == NULL && LOCALIZATION == NULL ? I'AM STORING A LOCAL FIELD
        // IF AT != NULL IAM
        if (at == null) {
            if (localization != null) {
                additional.visitFieldInsn(PUTSTATIC, Common.codeTypeToSimpleAsm(localization), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            } else {
                // THIS
                //
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            }
        } else {
            if (at instanceof AccessLocalEx) {

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
                    i = mvData.storeInternalVar(variableDeclaration.getName(), variableDeclaration.getVariableType(), i_label, null);
                } else {
                    i = mvData.storeVar(variableDeclaration.getName(), variableDeclaration.getVariableType(), i_label, null);
                }

                Type type = Type.getType(variableDeclaration.getVariableType().getJavaSpecName());

                int opcode = type.getOpcode(ISTORE); // ALOAD

                additional.visitVarInsn(opcode, i);

                //additional.visitLocalVariable();
                //additional.visitFieldInsn(GETFIELD, Common.codeTypeToSimpleAsm(localization), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));*/
            } else if (at instanceof AccessThis) {
                // THIS
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(typeDeclaration), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            } else {
                additional.visitFieldInsn(PUTFIELD, Common.codeTypeToSimpleAsm(localization), variableDeclaration.getName(), Common.codeTypeToFullAsm(variableDeclaration.getVariableType()));
            }


        }

        //additional.visitVarInsn(ALOAD, 0);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         VariableDeclaration variableDeclaration,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
