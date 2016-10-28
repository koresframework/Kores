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
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Lazy;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.iutils.containers.MutableContainer;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by jonathan on 03/06/16.
 */
public class VariableAccessVisitor implements VoidVisitor<VariableAccess, BytecodeClass, MVData>, Opcodes {

    public static final VariableAccessVisitor INSTANCE = new VariableAccessVisitor();

    @Override
    public void voidVisit(VariableAccess variableAccess,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();


        Lazy<TypeDeclaration> typeDeclaration = new Lazy<>(() ->
                Util.find(TypeVisitor.CODE_TYPE_REPRESENTATION, extraData, null)
        );

        CodeType localization = variableAccess.getLocalization().orElse(null);

        CodePart at = variableAccess.getTarget().orElse(null);


        boolean isNull = at == null && localization == null;

        if (isNull) {
            localization = typeDeclaration.get();
        }

        if (localization != null) {

            MutableContainer<CodeType> of = MutableContainer.of(localization);

            variableAccess = Util.fixAccessor(variableAccess, extraData, of, null);

            localization = of.get();
        }

        if (!isNull & at != null) {
            visitorGenerator.generateTo(at.getClass(), at, extraData, null, mvData);
        }

        if (at == null) {
            if (localization != null) {
                additional.visitFieldInsn(GETSTATIC, Common.codeTypeToSimpleAsm(localization), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));
            } else {
                // THIS
                additional.visitFieldInsn(GETFIELD, Common.codeTypeToSimpleAsm(typeDeclaration.get()), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));
            }
        } else {

            if (at instanceof AccessLocalImpl) {

                Optional<Variable> var = mvData.getVar(variableAccess.getName(), variableAccess.getVariableType());


                if (!var.isPresent())
                    throw new RuntimeException("Variable '" + variableAccess.getName() + "' Type: '" + variableAccess.getVariableType().getJavaSpecName() + "' Not found in local variables map");

                Variable variable = var.get();

                OptionalInt varPosOpt = mvData.getVarPos(variable);

                if (!varPosOpt.isPresent())
                    throw mvData.failFind(variable);

                int i = varPosOpt.getAsInt();

                Type type = Type.getType(variable.getType().getJavaSpecName());

                int opcode = type.getOpcode(ILOAD); // ALOAD

                additional.visitVarInsn(opcode, i);
            } else if (at instanceof AccessThis) {
                // THIS
                additional.visitFieldInsn(GETFIELD, Common.codeTypeToSimpleAsm(typeDeclaration.get()), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));
            } else {
                additional.visitFieldInsn(GETFIELD, Common.codeTypeToSimpleAsm(localization), variableAccess.getName(), Common.codeTypeToFullAsm(variableAccess.getVariableType()));
            }

        }

    }

}
