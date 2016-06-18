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
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.generatorv2.Visitor;
import com.github.jonathanxd.codeapi.generatorv2.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.MethodSpec;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Data;
import com.github.jonathanxd.codeapi.util.MVData;
import com.github.jonathanxd.iutils.iterator.Navigator;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/**
 * Created by jonathan on 03/06/16.
 */
public class MethodInvocationVisitor implements Visitor<MethodInvocation, Byte, MVData>, Opcodes {

    public static final MethodInvocationVisitor INSTANCE = new MethodInvocationVisitor();

    @Override
    public Byte[] visit(MethodInvocation methodInvocation,
                        Data extraData,
                        Navigator<CodePart> navigator,
                        VisitorGenerator<Byte> visitorGenerator,
                        MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();


        InvokeType invokeType = methodInvocation.getInvokeType();

        InvokeDynamic dynamicInvoke = methodInvocation.getDynamicInvoke().orElse(null);

        if(methodInvocation.getSpec().getMethodType() == MethodType.CONSTRUCTOR) {
            additional.visitTypeInsn(NEW, Common.codeTypeToSimpleAsm(methodInvocation.getLocalization()));
            additional.visitInsn(DUP);
            //additional.visitVarInsn(ALOAD, 0);
        }

        CodePart target = methodInvocation.getTarget();

        if (target != null && !(target instanceof CodeType)) {
            visitorGenerator.generateTo(target.getClass(), target, extraData, navigator, null, mvData);
        }

        MethodSpec spec = methodInvocation.getSpec();

        visitorGenerator.generateTo(Argumenterizable.class, spec, extraData, navigator, null, mvData);

        /*if(invokeType == InvokeType.INVOKE_DYNAMIC) {
            additional.visitCode();
            java.lang.invoke.MethodType mt = java.lang.invoke.MethodType.methodType(CallSite.class,
                    MethodHandles.Lookup.class,
                    String.class,
                    MethodType.class);

            Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, "kathik/InvokeDynamicCreator", bsmName,
                    mt.toMethodDescriptorString());

            additional.visitInvokeDynamicInsn("runDynamic", Common.specToAsm(spec), bootstrap);
        }*/

        if(dynamicInvoke != null && InvokeDynamic.isInvokeDynamicLambda(dynamicInvoke)) {

            FullMethodSpec methodSpec = dynamicInvoke.getMethodSpec();
            TypeSpec expectedTypes = dynamicInvoke.getExpectedTypes();

            additional.visitInsn(DUP);
            additional.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false);
            additional.visitInsn(POP);


            // ?
            // LambdaMetafactory.metafactory(caller, name, invokedType, samMethodType, implMethod, instantiatedMethodType) : CallSite
            Handle metafactory = new Handle(Opcodes.H_INVOKESTATIC,
                    "java/lang/invoke/LambdaMetafactory",
                    "metafactory",
                    "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;");

            Object[] objects = {
                    Type.getType(Common.fullSpecToFullAsm(methodSpec)),
                    new Handle(/*Opcodes.H_INVOKEINTERFACE*/ InvokeType.toAsm_H(invokeType),
                            Common.codeTypeToSimpleAsm(methodInvocation.getLocalization()),
                            spec.getMethodName(), Common.typeSpecToAsm(spec.getMethodDescription()),
                            methodInvocation.getInvokeType() == InvokeType.INVOKE_INTERFACE),

                        Type.getType(Common.fullSpecToFullAsm(expectedTypes))
            };

            String local = "("+Common.codeTypeToFullAsm(methodInvocation.getLocalization())+")"+Common.codeTypeToFullAsm(methodSpec.getLocation());

            additional.visitInvokeDynamicInsn(methodSpec.getMethodName(), local, metafactory, objects);

        }else {

            additional.visitMethodInsn(
                /*Type like invokestatic*/InvokeType.toAsm(invokeType),
                /*Localization*/Common.codeTypeToSimpleAsm(methodInvocation.getLocalization()),
                /*Method name*/spec.getMethodName(),
                /*(ARGUMENT)RETURN*/Common.typeSpecToAsm(spec.getMethodDescription()),
                    methodInvocation.getInvokeType() == InvokeType.INVOKE_INTERFACE);
        }


        return new Byte[0];
    }

    @Override
    public void endVisit(Byte[] r,
                         MethodInvocation methodInvocation,
                         Data extraData, Navigator<CodePart> navigator,
                         VisitorGenerator<Byte> visitorGenerator,
                         MVData mvData) {

    }
}
/*
mv.visitTypeInsn(NEW, "com/github/jonathanxd/codeapi/test/Simple$Dado");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitLdcInsn("JOAO");
            mv.visitMethodInsn(INVOKESPECIAL, "com/github/jonathanxd/codeapi/test/Simple$Dado", "<init>", "(Lcom/github/jonathanxd/codeapi/test/Simple;Ljava/lang/String;)V", false);
 */