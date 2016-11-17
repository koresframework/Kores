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
import com.github.jonathanxd.codeapi.interfaces.AccessLocal;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.optional.Require;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by jonathan on 03/06/16.
 */
public class VariableOperateVisitor implements VoidVisitor<VariableOperate, BytecodeClass, MVData>, Opcodes {

    public static final VariableOperateVisitor INSTANCE = new VariableOperateVisitor();

    @Override
    public void voidVisit(VariableOperate variableOperate,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        CodePart at = variableOperate.getTarget().orElse(null);

        Operator operation = Require.require(variableOperate.getOperation(), "Operation is required.");

        CodePart value = variableOperate.getValue().orElse(null);

        boolean constantVal = true;

        int constant = 1;

        if (value != null && (!(value instanceof Literal) || !Require.require(((Literal) value).getType(), "Literal Type required").getJavaSpecName().equals("I"))) {
            constantVal = false;
        } else if (value != null) {
            constant = Integer.valueOf(((Literal) value).getName());
        }


        Optional<Variable> var = mvData.getVar(variableOperate.getName(), variableOperate.getVariableType());


        if (!var.isPresent())
            throw new RuntimeException("Variable '" + variableOperate.getName() + "' Type: '" + variableOperate.getVariableType().getJavaSpecName() + "' Not found in local variables map");

        Variable variable = var.get();

        OptionalInt varPosOpt = mvData.getVarPos(variable);

        if (!varPosOpt.isPresent())
            throw new IllegalStateException("Cannot find variable '" + variable + "' in stack table: " + mvData.getVariables());

        int i = (int) varPosOpt.getAsInt();

        if (at instanceof AccessLocal) {
            if (operation == Operators.INCREMENT) {
                mv.visitIincInsn(i, 1);
                return;
            } else if (operation == Operators.DECREMENT) {
                mv.visitIincInsn(i, -1);
                return;
            } else if (constantVal) {
                if (operation == Operators.ADD) {
                    mv.visitIincInsn(i, constant);
                    return;
                }
                if (operation == Operators.SUBTRACT) {
                    mv.visitIincInsn(i, -constant);
                    return;
                }
            }

            Objects.requireNonNull(value, "value is null, cannot operate without value using operator: " + operation);

            visitorGenerator.generateTo(VariableAccess.class, variableOperate, extraData, null, mvData);

            visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

            OperateVisitor.operateVisit(variableOperate.getVariableType(), operation, false, mvData);
        } else {
            Objects.requireNonNull(value, "value is null, cannot operate without value using operator: " + operation);

            visitorGenerator.generateTo(VariableAccess.class, variableOperate, extraData, null, mvData);

            visitorGenerator.generateTo(value.getClass(), value, extraData, null, mvData);

            OperateVisitor.operateVisit(variableOperate.getVariableType(), operation, false, mvData);

        }

    }
}
