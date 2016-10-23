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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InnerType;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.interfaces.TypeDeclaration;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Lazy;
import com.github.jonathanxd.codeapi.visitgenerator.Visitor;
import com.github.jonathanxd.codeapi.visitgenerator.VisitorGenerator;
import com.github.jonathanxd.iutils.containers.MutableContainer;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.List;

public class MethodInvocationVisitor implements Visitor<MethodInvocation, BytecodeClass, MVData>, Opcodes {

    public static final MethodInvocationVisitor INSTANCE = new MethodInvocationVisitor();

    @Override
    public BytecodeClass[] visit(MethodInvocation methodInvocation,
                        MapData extraData,
                        VisitorGenerator<BytecodeClass> visitorGenerator,
                        MVData mvData) {

        MethodVisitor additional = mvData.getMethodVisitor();

        InvokeType invokeType = methodInvocation.getInvokeType();
        CodeType localization = methodInvocation.getLocalization().orElse(null);
        CodePart target = methodInvocation.getTarget().orElse(null);

        Lazy<CodeType> enclosingType = new Lazy<>(() -> extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION, "Cannot determine current type!"));

        if(invokeType == null) {
            if(localization == null) {
                localization = enclosingType.get();
            }

            invokeType = InvokeType.get(localization);
        }

        if(localization != null) {

            MutableContainer<CodeType> of = MutableContainer.of(localization);

            methodInvocation = Util.fixAccessor(methodInvocation, extraData, of, (mi, innerType) -> {
                if(mi.get().getSpec().getMethodName().equals("<init>")) {
                    MethodSpecification spec = mi.get().getSpec();
                    TypeSpec methodDescription = spec.getMethodDescription();

                    List<CodeType> parameterTypes = new ArrayList<>(methodDescription.getParameterTypes());
                    List<CodeArgument> arguments = new ArrayList<>(spec.getArguments());

                    arguments.add(0, CodeAPI.argument(Helper.accessThis()));
                    parameterTypes.add(0, enclosingType.get());

                    methodDescription = methodDescription.setParameterTypes(parameterTypes);

                    mi.set(mi.get().setSpec(spec.setArguments(arguments).setMethodDescription(methodDescription)));
                }
            });


            localization = of.get();
        }

        InvokeDynamic invokeDynamic = methodInvocation.getInvokeDynamic().orElse(null);

        if (methodInvocation.getSpec().getMethodType() == MethodType.CONSTRUCTOR) {
            additional.visitTypeInsn(NEW, Common.codeTypeToSimpleAsm(localization));
            additional.visitInsn(DUP);
        }

        CodePart access = Util.accessEnclosingClass(extraData, target, localization, visitorGenerator, mvData);

        if(access != null)
            target = access;

        if (target != null && !(target instanceof CodeType)) {
            visitorGenerator.generateTo(target.getClass(), target, extraData, null, mvData);
        }

        MethodSpecification spec = methodInvocation.getSpec();

        visitorGenerator.generateTo(Argumenterizable.class, spec, extraData, null, mvData);

        if (invokeDynamic != null) {

            if (InvokeDynamic.isInvokeDynamicLambda(invokeDynamic)) {

                InvokeDynamic.LambdaMethodReference lambdaDynamic = (InvokeDynamic.LambdaMethodReference) invokeDynamic;

                FullMethodSpec methodSpec = lambdaDynamic.getMethodSpec();
                TypeSpec expectedTypes = lambdaDynamic.getExpectedTypes();

                Handle metafactory = new Handle(Opcodes.H_INVOKESTATIC,
                        "java/lang/invoke/LambdaMetafactory",
                        "metafactory",
                        "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                        false);

                Object[] objects = {
                        Type.getType(Common.fullSpecToFullAsm(methodSpec)),
                        new Handle(/*Opcodes.H_INVOKEINTERFACE*/ InvokeType.toAsm_H(invokeType),
                                Common.codeTypeToSimpleAsm(localization),
                                spec.getMethodName(),
                                Common.typeSpecToAsm(spec.getMethodDescription()),
                                methodInvocation.getInvokeType() == InvokeType.INVOKE_INTERFACE),

                        Type.getType(Common.fullSpecToFullAsm(expectedTypes))
                };

                String local = "("
                        + (invokeType != InvokeType.INVOKE_STATIC ? Common.codeTypeToFullAsm(localization) : "")
                        + ")" + Common.codeTypeToFullAsm(methodSpec.getLocation());

                additional.visitInvokeDynamicInsn(methodSpec.getMethodName(), local, metafactory, objects);

                if (invokeDynamic instanceof InvokeDynamic.LambdaFragment) {
                    extraData.registerData(MethodFragmentVisitor.FRAGMENT_TYPE_INFO, ((InvokeDynamic.LambdaFragment) invokeDynamic).getMethodFragment());
                }
            } else if (InvokeDynamic.isInvokeDynamicBootstrap(invokeDynamic)) {
                InvokeDynamic.Bootstrap dynamicBootstrap = (InvokeDynamic.Bootstrap) invokeDynamic;

                FullMethodSpec bootstrapMethodSpec = dynamicBootstrap.getMethodSpec();

                boolean isInterface = dynamicBootstrap.getInvokeType() == InvokeType.INVOKE_INTERFACE;

                int invoke = InvokeType.toAsm_H(dynamicBootstrap.getInvokeType());

                Handle bootstrap = new Handle(invoke, Common.codeTypeToSimpleAsm(bootstrapMethodSpec.getLocation()),
                        bootstrapMethodSpec.getMethodName(),
                        Common.fullSpecToFullAsm(bootstrapMethodSpec), isInterface);

                additional.visitInvokeDynamicInsn(spec.getMethodName(), Common.typeSpecToAsm(spec.getMethodDescription()), bootstrap, dynamicBootstrap.toAsmArguments());
            }

        } else {

            additional.visitMethodInsn(
                /*Type like invokestatic*/InvokeType.toAsm(invokeType),
                /*Localization*/Common.codeTypeToSimpleAsm(localization),
                /*Method name*/spec.getMethodName(),
                /*(ARGUMENT)RETURN*/Common.typeSpecToAsm(spec.getMethodDescription()),
                    methodInvocation.getInvokeType() == InvokeType.INVOKE_INTERFACE);
        }


        return new BytecodeClass[0];
    }

}
