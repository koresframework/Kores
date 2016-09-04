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
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.containers.primitivecontainers.BooleanContainer;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonathan on 03/06/16.
 */
public class TryBlockVisitor implements Visitor<TryBlock, Byte, MVData>, Opcodes {

    @Override
    public Byte[] visit(TryBlock tryBlock,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        final boolean INLINE_FINALLY = visitorGenerator.getOptions().INLINE_FINALLY.isEnabled();

        MethodVisitor mv = mvData.getMethodVisitor();


        Label l0 = new Label(); // Code to surround
        Label l1 = new Label(); // if no exceptions.
        //Label lCatch = new Label(); // Catch block

        final Label finallyBlock;

        CodeSource finallySource = tryBlock.getFinallyBlock().orElse(null);

        if (finallySource != null) {
            finallyBlock = new Label();
        } else {
            finallyBlock = null;
        }

        Map<CatchBlock, Label> catches = new HashMap<>();

        Label outOfIf = new Label(); // Out of if

        for (CatchBlock catchBlock : tryBlock.getCatchBlocks()) {

            Label lCatch = new Label();

            List<CodeType> exceptionTypes = catchBlock.getExceptionTypes();

            for (CodeType exceptionType : exceptionTypes) {
                mv.visitTryCatchBlock(l0, l1, lCatch, Common.codeTypeToSimpleAsm(exceptionType));
            }

            catches.put(catchBlock, lCatch);
        }

        mv.visitLabel(l0);

        tryBlock.getBody().ifPresent(body -> visitorGenerator.generateTo(CodeSource.class, body, extraData, navigator, null, mvData));


        mv.visitLabel(l1);


        if (INLINE_FINALLY) {
            if (finallyBlock != null) {
                mv.visitLabel(finallyBlock);
                visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, navigator, null, mvData);
            }
        }


        mv.visitJumpInsn(GOTO, outOfIf);

        ///////////////////////////////

        Label i_label = new Label();

        mv.visitLabel(i_label);

        Label endLabel = new Label();

        final int stackPos = mvData.storeVar("unknownException$$", Helper.getJavaType(Throwable.class), i_label, null);

        catches.forEach((catchBlock, label) -> {


            //IMPLEMENTATION REQUIRED:

            // Catch

            mv.visitLabel(label);

            String s = catchBlock.getName();

            mvData.redefineVar(stackPos, s, Helper.getJavaType(Throwable.class), label, endLabel);

            mv.visitVarInsn(ASTORE, stackPos);

            CodeSource codeSource = catchBlock.getBody().orElse(null);

            CodePart toAdd;

            if (INLINE_FINALLY) {
                if (finallyBlock != null) {
                    toAdd = finallySource;
                }
            } else if (!INLINE_FINALLY && finallyBlock != null) {
                toAdd = (InstructionCodePart) (value, extraData1, navigator1, visitorGenerator1, additional) -> {
                    mv.visitJumpInsn(GOTO, finallyBlock);
                };
            }

            BooleanContainer booleanContainer = new BooleanContainer(false);

            if (codeSource != null) {
                CodeSource codeSource1 = new CodeSource(codeSource);


                codeSource1 = CodeSourceUtil.insertBefore(codePart -> {
                    if (codePart instanceof ThrowException) {
                        booleanContainer.set(true);
                        return true;
                    }

                    return false;
                }, finallySource, codeSource1);

                visitorGenerator.generateTo(CodeSource.class, codeSource1, extraData, navigator, null, mvData);
            }


            if (!booleanContainer.get()) {
                if (INLINE_FINALLY) {
                    if (finallyBlock != null) {
                        visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, navigator, null, mvData);
                    }
                } else if (!INLINE_FINALLY && finallyBlock != null) {
                    mv.visitJumpInsn(GOTO, finallyBlock);
                }
            }

            mv.visitJumpInsn(GOTO, outOfIf);


        });

        mv.visitLabel(endLabel);

        if (!INLINE_FINALLY && finallyBlock != null) {
            mv.visitLabel(finallyBlock);
            visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, navigator, null, mvData);
        }

        mv.visitLabel(outOfIf);

        // OUT OF --


        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         TryBlock tryBlock,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }

    /*
    mv = cw.visitMethod(ACC_PUBLIC, "ldcIng", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/RuntimeException");
            Label l3 = new Label();
            mv.visitTryCatchBlock(l0, l1, l3, "java/io/IOException");
            Label l4 = new Label();
            mv.visitLabel(l4);
            mv.visitLineNumber(91, l4);
            mv.visitLdcInsn("V");
            mv.visitVarInsn(ASTORE, 1);
            mv.visitLabel(l0);
            mv.visitLineNumber(93, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/github/jonathanxd/codeapi/test/Simple", "lt", "(Ljava/lang/String;)V", false);
            mv.visitLabel(l1);
            mv.visitLineNumber(98, l1);
            Label l5 = new Label();
            mv.visitJumpInsn(GOTO, l5);
            mv.visitLabel(l2);
            mv.visitLineNumber(94, l2);
            mv.visitFrame(Opcodes.F_FULL, 2, new Object[]{"com/github/jonathanxd/codeapi/test/Simple", "java/lang/String"}, 1, new Object[]{"java/lang/RuntimeException"});
            mv.visitVarInsn(ASTORE, 2);
            Label l6 = new Label();
            mv.visitLabel(l6);
            mv.visitLineNumber(98, l6);
            mv.visitJumpInsn(GOTO, l5);
            mv.visitLabel(l3);
            mv.visitLineNumber(96, l3);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/io/IOException"});
            mv.visitVarInsn(ASTORE, 2);
            mv.visitLabel(l5);
            mv.visitLineNumber(99, l5);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(RETURN);
     */
}
