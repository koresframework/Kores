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
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.ElseBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfExpr;
import com.github.jonathanxd.codeapi.literals.Literals;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@SuppressWarnings("Duplicates")
public class BytecodeIfBlockVisitor implements Opcodes {

    public static void visit(IfBlock ifBlock,
                             Label ifStartLabel,
                             Label outOfIfLabel,
                             boolean revert,
                             boolean jumpToStart,
                             MapData extraData,
                             VisitorGenerator<BytecodeClass> visitorGenerator,
                             MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        List<CodePart> ifExpression = new ArrayList<>(ifBlock.getIfExprsAndOps());

        ListIterator<CodePart> listIterator = ifExpression.listIterator();

        Optional<ElseBlock> elseBlock = ifBlock.getElseBlock();

        Label inIfLabel = new Label();

        Label elseLabel = elseBlock.isPresent() ? new Label() : null;

        while (listIterator.hasNext()) {

            CodePart current = listIterator.next();

            CodePart next = null;

            if (listIterator.hasNext()) {
                next = listIterator.next();
                listIterator.previous();
            }

            if (current instanceof IfExpr) {

                IfExpr ifExpr = (IfExpr) current;

                final boolean isInverse = !revert == (next == null || next != Operators.OR);

                Label lbl;

                if (ifBlock instanceof SwitchVisitor.SwitchIfBlock) { // Workaround ?
                    lbl = extraData.getRequired(ConstantDatas.FLOW_TYPE_INFO).getInsideEnd();
                } else {
                    lbl = jumpToStart ? ifStartLabel : !isInverse ? inIfLabel : (elseLabel == null ? outOfIfLabel : elseLabel); // Jump to else if exists
                }


                Operator operation = ifExpr.getOperation();

                CodePart expr1 = ifExpr.getExpr1();
                CodePart expr2 = ifExpr.getExpr2();

                CodeType expr1Type = Common.getType(expr1);
                CodeType expr2Type = Common.getType(expr2);

                boolean firstIsBoolean = false;
                boolean secondIsBoolean = false;

                boolean expr1Primitive = Common.isPrimitive(expr1);
                boolean expr2Primitive = Common.isPrimitive(expr2);

                if (expr1Primitive) {
                    firstIsBoolean = Common.isBoolean(expr1);
                }

                if (expr2Primitive) {
                    secondIsBoolean = Common.isBoolean(expr2);
                }

                if (firstIsBoolean || secondIsBoolean) {
                    boolean operatorIsEq = operation == Operators.EQUAL_TO;

                    boolean value = firstIsBoolean ? Common.getBooleanValue(expr1) : Common.getBooleanValue(expr2);

                    int opcode = Common.getIfNeEqOpcode(value);

                    if (!operatorIsEq)
                        opcode = Common.invertIfNeEqOpcode(opcode);

                    if (isInverse)
                        opcode = Common.invertIfNeEqOpcode(opcode);


                    if (firstIsBoolean) {
                        visitorGenerator.generateTo(expr2.getClass(), expr2, extraData, null, mvData);
                        additional.visitJumpInsn(opcode, lbl);
                    } else {
                        visitorGenerator.generateTo(expr1.getClass(), expr1, extraData, null, mvData);
                        additional.visitJumpInsn(opcode, lbl);
                    }
                } else {

                    // Old Code ->
                    // TODO: Rewrite

                    if (expr1Primitive != expr2Primitive) {

                        if (expr2Primitive) {
                            expr1 = Helper.cast(expr1Type, expr2Type, expr1);
                        } else {
                            expr2 = Helper.cast(expr2Type, expr1Type, expr2);
                        }
                    }

                    visitorGenerator.generateTo(expr1.getClass(), expr1, extraData, null, mvData);

                    if (expr2 == Literals.NULL) {
                        additional.visitJumpInsn(Operators.nullCheckToAsm(operation, isInverse), lbl);
                    } else if (Common.isPrimitive(expr1) && Common.isPrimitive(expr2)) {
                        visitorGenerator.generateTo(expr2.getClass(), expr2, extraData, null, mvData);

                        additional.visitJumpInsn(Operators.primitiveToAsm(operation, isInverse), lbl);
                    } else {
                        visitorGenerator.generateTo(expr2.getClass(), expr2, extraData, null, mvData);

                        additional.visitJumpInsn(Operators.referenceToAsm(operation, isInverse), lbl);
                    }
                }
            }

        }
        additional.visitLabel(inIfLabel);

        CodeSource body = ifBlock.getBody().orElseThrow(RuntimeException::new);

        visitorGenerator.generateTo(CodeSource.class, body, extraData, null, mvData);

        if (elseLabel != null) {
            additional.visitJumpInsn(GOTO, outOfIfLabel);
        }


        if (elseLabel != null) {
            additional.visitLabel(elseLabel);

            if (elseBlock.isPresent()) {

                ElseBlock elseBlock_ = elseBlock.get();

                Optional<CodeSource> elseBodyOpt = elseBlock_.getBody();

                if (elseBodyOpt.isPresent()) {
                    CodeSource elseBody = elseBodyOpt.get();

                    visitorGenerator.generateTo(CodeSource.class, elseBody, extraData, null, mvData);
                }
            }
        }

    }

}
