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
import com.github.jonathanxd.codeapi.gen.visit.VoidVisitor;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.CatchBlock;
import com.github.jonathanxd.codeapi.interfaces.FieldDeclaration;
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.interfaces.TryBlock;
import com.github.jonathanxd.codeapi.options.CodeOptions;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.gen.CodeTypeUtil;
import com.github.jonathanxd.codeapi.util.source.CodeSourceUtil;
import com.github.jonathanxd.iutils.container.primitivecontainers.BooleanContainer;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by jonathan on 03/06/16.
 */
public class TryBlockVisitor implements VoidVisitor<TryBlock, BytecodeClass, MVData>, Opcodes {

    private static int unknownException = 0;

    private static int getAndIncrementUnkEx() {
        int i = unknownException;
        ++unknownException;
        return i;
    }

    @Override
    public void voidVisit(TryBlock tryBlock,
                          MapData extraData,
                          VisitorGenerator<BytecodeClass> visitorGenerator,
                          MVData mvData) {

        final boolean INLINE_FINALLY = visitorGenerator.getOptions().getOrElse(CodeOptions.INLINE_FINALLY, Boolean.TRUE);

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
                mv.visitTryCatchBlock(l0, l1, lCatch, CodeTypeUtil.codeTypeToSimpleAsm(exceptionType));
            }

            catches.put(catchBlock, lCatch);
        }

        mv.visitLabel(l0);

        tryBlock.getBody().ifPresent(body -> visitorGenerator.generateTo(CodeSource.class, body, extraData, null, mvData));


        mv.visitLabel(l1);


        if (INLINE_FINALLY) {
            if (finallyBlock != null) {
                mv.visitLabel(finallyBlock);
                visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, null, mvData);
            }
        }


        mv.visitJumpInsn(GOTO, outOfIf);

        ///////////////////////////////

        Label i_label = new Label();

        mv.visitLabel(i_label);

        Label endLabel = new Label();

        final String unkExceptionName = "unknownException$$" + getAndIncrementUnkEx();
        final int stackPos = mvData.storeVar(unkExceptionName, Helper.getJavaType(Throwable.class), i_label, null)
                .orElseThrow(() -> mvData.failStore(unkExceptionName));

        catches.forEach((catchBlock, label) -> {


            //IMPLEMENTATION REQUIRED:

            // Catch

            mv.visitLabel(label);

            FieldDeclaration field = catchBlock.getField();
            Optional<CodePart> fieldValue = field.getValue();

            mvData.redefineVar(stackPos, field.getName(), field.getVariableType(), label, endLabel);

            mv.visitVarInsn(ASTORE, stackPos);

            if (fieldValue.isPresent()) {
                CodePart valuePart = fieldValue.get();

                visitorGenerator.generateTo(valuePart.getClass(), valuePart, extraData, null, mvData);

                mv.visitVarInsn(ASTORE, stackPos);
            }

            CodeSource codeSource = catchBlock.getBody().orElse(null);

            CodeSource toAdd = Helper.sourceOf();

            if (INLINE_FINALLY) {
                if (finallyBlock != null) {
                    toAdd = finallySource;
                }
            } else if (finallyBlock != null) {

                Logger.getLogger("Inliner").warning("Is not recommended to use non-inlined finally in Bytecode generation because the behavior is inconsistent.");

                toAdd = Helper.sourceOf((InstructionCodePart) (value, extraData1, visitorGenerator1, additional) ->
                        mv.visitJumpInsn(GOTO, finallyBlock));
            }

            BooleanContainer booleanContainer = new BooleanContainer(false);

            if (codeSource != null) {
                CodeSource codeSource1 = CodeSource.fromIterable(codeSource);


                codeSource1 = CodeSourceUtil.insertBefore(codePart -> {
                    if (codePart instanceof ThrowException) {
                        booleanContainer.set(true);
                        return true;
                    }

                    return false;
                }, toAdd, codeSource1);

                visitorGenerator.generateTo(CodeSource.class, codeSource1, extraData, null, mvData);
            }


            if (!booleanContainer.get()) {
                if (INLINE_FINALLY) {
                    if (finallyBlock != null) {
                        visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, null, mvData);
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
            visitorGenerator.generateTo(CodeSource.class, finallySource, extraData, null, mvData);
        }

        mv.visitLabel(outOfIf);

        // OUT OF --

    }
}
