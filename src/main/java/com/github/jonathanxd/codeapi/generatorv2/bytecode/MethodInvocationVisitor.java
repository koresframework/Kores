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
package com.github.jonathanxd.codeapi.generatorv2.bytecode;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.generatorv2.Visitor;
import com.github.jonathanxd.codeapi.generatorv2.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.impl.CodeField;
import com.github.jonathanxd.codeapi.impl.CodeInterface;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.InvokeType;
import com.github.jonathanxd.iutils.iterator.Navigator;
import com.github.jonathanxd.iutils.object.GenericRepresentation;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/**
 * Created by jonathan on 03/06/16.
 */
public class MethodInvocationVisitor implements Visitor<MethodInvocation, Byte, MethodVisitor> {

    public static final MethodInvocationVisitor INSTANCE = new MethodInvocationVisitor();

    @Override
    public Byte[] visit(MethodInvocation methodInvocation,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MethodVisitor additional) {

        CodePart target = methodInvocation.getTarget();

        if(target != null) {
            visitorGenerator.generateTo(target.getClass(), target, extraData, navigator, null, null);
        }

        MethodSpec spec = methodInvocation.getSpec();

        additional.visitMethodInsn(
                /*Type like invokestatic*/InvokeType.toAsm(methodInvocation.getInvokeType()),
                /*Localization*/Common.codeTypeToSimpleAsm(methodInvocation.getLocalization()),
                /*Method name*/spec.getMethodName(),
                /*(ARGUMENT)RETURN*/Common.specToAsm(spec),
                false);


        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         MethodInvocation methodInvocation,
                         Data extraData, Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MethodVisitor additional) {

    }
}
