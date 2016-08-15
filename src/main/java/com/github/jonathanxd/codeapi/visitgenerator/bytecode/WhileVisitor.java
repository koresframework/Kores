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
import com.github.jonathanxd.codeapi.helper.SimpleIfBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.interfaces.WhileBlock;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class WhileVisitor implements Visitor<WhileBlock, Byte, MVData>, Opcodes {

    @Override
    public Byte[] visit(WhileBlock whileBlock,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        Label whileStart = new Label();

        CodeSource source = new CodeSource();

        whileBlock.getBody().ifPresent(source::addAll);

        IfBlock ifBlock = SimpleIfBlock.instance(whileBlock, source);

        mv.visitLabel(whileStart);

        InstructionCodePart instructionCodePart =
                (value, extraData1, navigator1, visitorGenerator1, additional)  -> {
                    mv.visitJumpInsn(GOTO, whileStart);
                };

        source.add(instructionCodePart);

        visitorGenerator.generateTo(IfBlock.class, ifBlock, extraData, navigator, null, mvData);


        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         WhileBlock whileBlock,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
/*
mv.visitIntInsn(BIPUSH, 8);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitLdcInsn("A");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitLdcInsn("B");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_2);
            mv.visitLdcInsn("C");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_3);
            mv.visitLdcInsn("D");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_4);
            mv.visitLdcInsn("E");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_5);
            mv.visitLdcInsn("F");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitIntInsn(BIPUSH, 6);
            mv.visitLdcInsn("G");
            mv.visitInsn(AASTORE);
            mv.visitInsn(DUP);
            mv.visitIntInsn(BIPUSH, 7);
            mv.visitLdcInsn("H");
            mv.visitInsn(AASTORE);
            mv.visitVarInsn(ASTORE, 1);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(66, l1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ARRAYLENGTH);
            mv.visitVarInsn(ISTORE, 2);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLineNumber(68, l2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "[Ljava/lang/String;", "clone", "()Ljava/lang/Object;", false);
            mv.visitInsn(POP);
 */