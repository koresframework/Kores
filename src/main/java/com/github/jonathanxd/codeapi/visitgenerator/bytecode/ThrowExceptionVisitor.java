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
import com.github.jonathanxd.codeapi.interfaces.ThrowException;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.data.MapData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 03/06/16.
 */
public class ThrowExceptionVisitor implements Visitor<ThrowException, Byte, MVData>, Opcodes {

    public static final ThrowExceptionVisitor INSTANCE = new ThrowExceptionVisitor();

    @Override
    public Byte[] visit(ThrowException e,
                        MapData extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        CodePart partToThrow = e.getPartToThrow();

        visitorGenerator.generateTo(partToThrow.getClass(), partToThrow, extraData, navigator, null, mvData);

        //visitorGenerator.generateTo(invoke.getClass(), invoke, extraData, navigator, null, mvData);
        /*CodeType exceptionType = e.getType().orElseThrow(NullPointerException::new);
        List<CodeArgument> arguments = e.getArguments();

        MethodInvocation invoke = Helper.invoke(InvokeType.INVOKE_SPECIAL, exceptionType, exceptionType,
                new MethodSpec((String) null, arguments,
                        <init>
                        (CodeType) nullPredefinedTypes#VOID,
                        MethodType.CONSTRUCTOR));*/


        additional.visitInsn(ATHROW);

        //additional.visitVarInsn(ALOAD, 0);

        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         ThrowException e,
                         MapData extraData,
                         Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
