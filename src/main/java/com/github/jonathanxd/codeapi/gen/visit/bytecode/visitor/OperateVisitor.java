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
import com.github.jonathanxd.codeapi.builder.OperateHelper;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.interfaces.AccessLocal;
import com.github.jonathanxd.codeapi.interfaces.Operate;
import com.github.jonathanxd.codeapi.interfaces.VariableAccess;
import com.github.jonathanxd.codeapi.interfaces.VariableOperate;
import com.github.jonathanxd.codeapi.literals.Literal;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Variable;
import com.github.jonathanxd.codeapi.util.gen.CodePartUtil;
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
public class OperateVisitor implements VoidVisitor<Operate, BytecodeClass, MVData>, Opcodes {

    public static final OperateVisitor INSTANCE = new OperateVisitor();

    @Override
    public void voidVisit(Operate operate,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        CodePart target = operate.getTarget().orElse(null);

        Operator operation = Require.require(operate.getOperation(), "Operation is required.");

        CodePart value = operate.getValue().orElse(null);

        if (operation == Operators.UNARY_BITWISE_COMPLEMENT) { // ~
            Objects.requireNonNull(value, "Value cannot be null if operation is '"+operation+"'!");
            // Desugar
            CodePart desugar = OperateHelper.builder(target)
                    .subtract(
                            OperateHelper.builder(value)
                                    .xor(Literals.INT(-1))
                                    .build()
                    )
                    .build();

            visitorGenerator.generateTo(desugar.getClass(), desugar, extraData, mvData);

            return;
        }


        visitorGenerator.generateTo(target.getClass(), target, extraData, mvData);

        if(value != null) {
            visitorGenerator.generateTo(value.getClass(), value, extraData, mvData);
        }

        if(operation == Operators.ADD
                || operation == Operators.SUBTRACT
                || operation == Operators.MULTIPLY
                || operation == Operators.DIVISION
                || operation == Operators.REMAINDER
                || operation == Operators.SIGNED_LEFT_SHIFT // <<
                || operation == Operators.SIGNED_RIGHT_SHIFT // >>
                || operation == Operators.UNSIGNED_RIGHT_SHIFT // >>>
                || operation == Operators.BITWISE_EXCLUSIVE_OR // ^
                || operation == Operators.BITWISE_INCLUSIVE_OR // |
                || operation == Operators.BITWISE_AND // &
                ) {
            CodeType type = CodePartUtil.getType(target);

            operateVisit(type, operation, value == null, mvData);
        } else {
            throw new RuntimeException("Cannot handle operation: '"+operation+"'!");
        }



    }

    static void operateVisit(CodeType codeType, Operator operation, boolean valueIsNull, MVData mvData) {
        Type type = Type.getType(codeType.getJavaSpecName());

        int opcode = -1;

        if (operation == Operators.ADD) {
            opcode = type.getOpcode(IADD);
        } else if (operation == Operators.SUBTRACT) {
            if(!valueIsNull) {
                opcode = type.getOpcode(ISUB);
            } else {
                opcode = type.getOpcode(INEG);
            }
        } else if (operation == Operators.MULTIPLY) {
            opcode = type.getOpcode(IMUL);
        } else if (operation == Operators.DIVISION) {
            opcode = type.getOpcode(IDIV);
        } else if (operation == Operators.REMAINDER) {
            opcode = type.getOpcode(IREM);
        } else if (operation == Operators.BITWISE_AND) {
            opcode = type.getOpcode(IAND);
        } else if (operation == Operators.BITWISE_INCLUSIVE_OR) {
            opcode = type.getOpcode(IOR);
        } else if (operation == Operators.BITWISE_EXCLUSIVE_OR) {
            opcode = type.getOpcode(IXOR);
        } else if (operation == Operators.UNARY_BITWISE_COMPLEMENT) { // desugar
            throw new IllegalArgumentException("Invalid operator: '"+operation+"'!!!");
        }

        if (opcode != -1)
            mvData.getMethodVisitor().visitInsn(opcode);


    }
}
