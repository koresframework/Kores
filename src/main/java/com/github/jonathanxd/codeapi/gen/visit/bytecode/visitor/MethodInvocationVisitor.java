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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.MVData;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.gen.BytecodeClass;
import com.github.jonathanxd.codeapi.gen.visit.Visitor;
import com.github.jonathanxd.codeapi.gen.visit.VisitorGenerator;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.Argumenterizable;
import com.github.jonathanxd.codeapi.interfaces.MethodInvocation;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.Lazy;
import com.github.jonathanxd.iutils.containers.MutableContainer;
import com.github.jonathanxd.iutils.data.MapData;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

public class MethodInvocationVisitor implements Visitor<MethodInvocation, BytecodeClass, MVData>, Opcodes {

    public static final MethodInvocationVisitor INSTANCE = new MethodInvocationVisitor();

    @Override
    public BytecodeClass[] visit(MethodInvocation methodInvocation,
                                 MapData extraData,
                                 VisitorGenerator<BytecodeClass> visitorGenerator,
                                 MVData mvData) {

        MethodVisitor mv = mvData.getMethodVisitor();

        CodeType localization = methodInvocation.getLocalization().orElse(null);

        Lazy<CodeType> enclosingType = new Lazy<>(() -> extraData.getRequired(TypeVisitor.CODE_TYPE_REPRESENTATION, "Cannot determine current type!"));


        // If localization is not null
        if (localization != null) {

            // Create container with localization
            MutableContainer<CodeType> of = MutableContainer.of(localization);

            // Fix the access to inner class member.
            methodInvocation = Util.fixAccessor(methodInvocation, extraData, of, (mi, innerType) -> {
                // Add 'this' argument to Inner class Constructor methods.
                if (mi.get().getSpec().getMethodName().equals("<init>")) {
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

        InvokeType invokeType = methodInvocation.getInvokeType();
        CodePart target = methodInvocation.getTarget().orElse(null);
        MethodSpecification specification = methodInvocation.getSpec();

        // If invoke type is not specified try to infer it from localization
        if (invokeType == null) {
            // If localization is not specified the target type is the enclosingClass.
            if (localization == null) {
                // Get enclosing class (lazily resolved)
                localization = enclosingType.get();
            }

            // Determine the invoke type.
            invokeType = InvokeType.get(localization);
        }

        if (specification.getMethodName().equals("<init>")
                || specification.getMethodType() == MethodType.CONSTRUCTOR) {
            // Invoke constructor
            mv.visitTypeInsn(NEW, Common.codeTypeToSimpleAsm(localization));
            mv.visitInsn(DUP);
        }

        if (target != null && !(target instanceof CodeType)) {
            visitorGenerator.generateTo(target.getClass(), target, extraData, null, mvData);
        }

        visitorGenerator.generateTo(Argumenterizable.class, specification, extraData, null, mvData);

        InvokeDynamic invokeDynamic = methodInvocation.getInvokeDynamic().orElse(null);

        if (invokeDynamic != null) {

            // Generate lambda 'invokeDynamic'
            if (InvokeDynamic.isInvokeDynamicLambda(invokeDynamic)) {

                InvokeDynamic.LambdaMethodReference lambdaDynamic = (InvokeDynamic.LambdaMethodReference) invokeDynamic;

                Common.visitLambdaInvocation(lambdaDynamic, invokeType, localization, specification, mv);

                if (invokeDynamic instanceof InvokeDynamic.LambdaFragment) {
                    // Register fragment to gen
                    extraData.registerData(MethodFragmentVisitor.FRAGMENT_TYPE_INFO, ((InvokeDynamic.LambdaFragment) invokeDynamic).getMethodFragment());
                }
            } else if (InvokeDynamic.isInvokeDynamicBootstrap(invokeDynamic)) { // Generate bootstrap 'invokeDynamic'
                InvokeDynamic.Bootstrap bootstrap = (InvokeDynamic.Bootstrap) invokeDynamic;
                // Visit bootstrap invoke dynamic
                Common.visitBootstrapInvocation(bootstrap, specification, mv);
            }

        } else {

            mv.visitMethodInsn(
                /*Type like invokestatic*/InvokeType.toAsm(invokeType),
                /*Localization*/Common.codeTypeToSimpleAsm(localization),
                /*Method name*/specification.getMethodName(),
                /*(ARGUMENT)RETURN*/Common.typeSpecToAsm(specification.getMethodDescription()),
                    invokeType.isInterface());
        }


        return new BytecodeClass[0];
    }

}
