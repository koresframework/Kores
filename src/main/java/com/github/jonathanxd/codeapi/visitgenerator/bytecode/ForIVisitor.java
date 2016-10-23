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

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.common.Flow;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.impl.IfBlockImpl;
import com.github.jonathanxd.codeapi.interfaces.ForBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.codeapi.visitgenerator.VoidVisitor;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class ForIVisitor implements VoidVisitor<ForBlock, BytecodeClass, MVData>, Opcodes {

    public static final ForIVisitor INSTANCE = new ForIVisitor();

    @Override
    public void voidVisit(ForBlock forBlock,
                        MapData extraData,
                        VisitorGenerator<BytecodeClass> visitorGenerator,
                        MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        Label outsideStart = new Label();
        Label whileStart = new Label();
        Label whileEnd = new Label();
        Label outsideEnd = new Label();

        mv.visitLabel(outsideStart);

        forBlock.getForInit().ifPresent(forInit -> visitorGenerator.generateTo(forInit.getClass(), forInit, extraData, null, mvData));


        CodeSource source = new CodeSource();

        forBlock.getBody().ifPresent(source::addAll);

        IfBlock ifBlock = IfBlockImpl.instance(forBlock, source);

        mv.visitLabel(whileStart);

        Flow flow = new Flow(outsideStart, whileStart, whileEnd, outsideEnd);

        extraData.registerData(ConstantDatas.FLOW_TYPE_INFO, flow);

        InstructionCodePart instructionCodePart =
                (value, extraData1, visitorGenerator1, additional) -> {
                    mv.visitLabel(whileEnd);
                    forBlock.getForUpdate().ifPresent(forUpdate -> visitorGenerator.generateTo(forUpdate.getClass(), forUpdate, extraData, null, mvData));
                    mv.visitJumpInsn(GOTO, whileStart);
                };

        source.add(instructionCodePart);

        visitorGenerator.generateTo(IfBlock.class, ifBlock, extraData, null, mvData);

        extraData.unregisterData(ConstantDatas.FLOW_TYPE_INFO, flow);

        mv.visitLabel(outsideEnd);

    }

}
