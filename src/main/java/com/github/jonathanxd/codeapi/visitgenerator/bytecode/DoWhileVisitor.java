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
import com.github.jonathanxd.codeapi.common.Flow;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.helper.SimpleIfBlock;
import com.github.jonathanxd.codeapi.interfaces.DoWhileBlock;
import com.github.jonathanxd.codeapi.interfaces.IfBlock;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class DoWhileVisitor implements Visitor<DoWhileBlock, Byte, MVData>, Opcodes {

    public static final DoWhileVisitor INSTANCE = new DoWhileVisitor();

    @Override
    public Byte[] visit(DoWhileBlock whileBlock,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        Label whileStart = new Label();
        Label outOfIf = new Label();
        Label insideStart = new Label();
        Label insideEnd = new Label();
        Label outsideEnd = new Label();

        CodeSource source = new CodeSource();

        IfBlock ifBlock = SimpleIfBlock.instance(whileBlock, source);

        mv.visitLabel(whileStart);


        mv.visitLabel(insideStart);

        Flow flow = new Flow(whileStart, insideStart, insideEnd, outsideEnd);

        extraData.registerData(ConstantDatas.FLOW_TYPE_INFO, flow);

        visitorGenerator.generateTo(IfBlock.class, ifBlock, extraData, navigator, null, mvData);

        whileBlock.getBody().ifPresent(body -> visitorGenerator.generateTo(CodeSource.class, body, extraData, navigator, null, mvData));

        mv.visitLabel(insideEnd);

        BytecodeIfBlockVisitor.visit(ifBlock, whileStart, outOfIf, true, true, extraData, navigator, visitorGenerator, mvData);

        extraData.unregisterData(ConstantDatas.FLOW_TYPE_INFO, flow);

        mv.visitLabel(outsideEnd);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         DoWhileBlock whileBlock,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
