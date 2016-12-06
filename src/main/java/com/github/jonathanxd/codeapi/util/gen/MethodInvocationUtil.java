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
package com.github.jonathanxd.codeapi.util.gen;

import com.github.jonathanxd.codeapi.common.FullInvokeSpec;
import com.github.jonathanxd.codeapi.common.FullMethodSpec;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.DescriptionHelper;
import com.github.jonathanxd.codeapi.util.TypeResolver;
import com.github.jonathanxd.iutils.description.Description;
import com.github.jonathanxd.iutils.description.DescriptionUtil;

import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodInvocationUtil {
    public static void visitLambdaInvocation(InvokeDynamic.LambdaMethodReference lambdaDynamic,
                                             InvokeType invokeType,
                                             CodeType localization,
                                             MethodSpecification spec,
                                             MethodVisitor mv) {

        FullMethodSpec methodSpec = lambdaDynamic.getMethodSpec();
        TypeSpec expectedTypes = lambdaDynamic.getExpectedTypes();

        Handle metafactory = new Handle(Opcodes.H_INVOKESTATIC,
                "java/lang/invoke/LambdaMetafactory",
                "metafactory",
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                false);

        Object[] objects = {
                Type.getType(CodeTypeUtil.fullSpecToFullAsm(methodSpec)),
                new Handle(/*Opcodes.H_INVOKEINTERFACE*/ InvokeType.toAsm_H(invokeType),
                        CodeTypeUtil.codeTypeToSimpleAsm(localization),
                        spec.getMethodName(),
                        TypeSpecUtil.typeSpecToAsm(spec.getMethodDescription()),
                        invokeType == InvokeType.INVOKE_INTERFACE),

                Type.getType(CodeTypeUtil.fullSpecToFullAsm(expectedTypes))
        };

        String local = "("
                + (invokeType != InvokeType.INVOKE_STATIC ? CodeTypeUtil.codeTypeToFullAsm(localization) : "")
                + ")" + CodeTypeUtil.codeTypeToFullAsm(methodSpec.getLocalization());

        mv.visitInvokeDynamicInsn(methodSpec.getMethodName(), local, metafactory, objects);


    }

    public static void visitBootstrapInvocation(InvokeDynamic.Bootstrap bootstrap, MethodSpecification spec, MethodVisitor mv) {
        Handle handle = MethodInvocationUtil.toHandle(bootstrap);

        mv.visitInvokeDynamicInsn(spec.getMethodName(), TypeSpecUtil.typeSpecToAsm(spec.getMethodDescription()), handle, bootstrap.toAsmArguments());
    }

    public static Handle toHandle(InvokeDynamic.Bootstrap bootstrap) {
        FullMethodSpec bootstrapMethodSpec = bootstrap.getMethodSpec();
        InvokeType btpInvokeType = bootstrap.getInvokeType();

        String methodName = bootstrapMethodSpec.getMethodName();
        CodeType bsmLocalization = bootstrapMethodSpec.getLocalization();

        return new Handle(InvokeType.toAsm_H(btpInvokeType),
                CodeTypeUtil.codeTypeToSimpleAsm(bsmLocalization),
                methodName,
                CodeTypeUtil.fullSpecToFullAsm(bootstrapMethodSpec),
                btpInvokeType.isInterface());
    }

    public static FullInvokeSpec specFromHandle(Handle handle, TypeResolver typeResolver) {
        InvokeType invokeType = InvokeType.fromAsm_H(handle.getTag());

        CodeType owner = typeResolver.resolveUnknown(handle.getOwner());
        String desc = owner.getJavaSpecName() + ":" + handle.getName() + handle.getDesc();

        Description description = DescriptionUtil.parseDescription(desc);

        return new FullInvokeSpec(invokeType,
                owner,
                typeResolver.resolveUnknown(description.getReturnType()),
                handle.getName(),
                Arrays.stream(description.getParameterTypes()).map(typeResolver::resolveUnknown).toArray(CodeType[]::new));
    }

    public static InvokeDynamic fromHandle(Handle handle, Object[] args, TypeResolver typeResolver) {
        InvokeType invokeType = InvokeType.fromAsm_H(handle.getTag());
        FullInvokeSpec fullMethodSpec = MethodInvocationUtil.specFromHandle(handle, typeResolver);

        return InvokeDynamic.invokeDynamicBootstrap(invokeType, fullMethodSpec, MethodInvocationUtil.bsmArgsFromAsm(args, typeResolver));
    }

    public static Object[] bsmArgsFromAsm(Object[] asmArgs, TypeResolver typeResolver) {
        if (asmArgs == null || asmArgs.length == 0)
            return new Object[0];

        List<Object> codeAPIArgsList = new ArrayList<>();

        for (Object asmArg : asmArgs) {
            if (asmArg instanceof Integer
                    || asmArg instanceof Float
                    || asmArg instanceof Long
                    || asmArg instanceof Double
                    || asmArg instanceof String) {
                codeAPIArgsList.add(asmArg);
            } else if (asmArg instanceof Type) {

                Type type = (Type) asmArg;

                String className = type.getClassName();

                if (className != null) {
                    // Class
                    codeAPIArgsList.add(typeResolver.resolveUnknown(className));
                } else {
                    // Method
                    codeAPIArgsList.add(DescriptionHelper.toTypeSpec(type.getDescriptor(), typeResolver));
                }


            } else if (asmArg instanceof Handle) {
                codeAPIArgsList.add(MethodInvocationUtil.specFromHandle((Handle) asmArg, typeResolver));
            } else {
                throw new IllegalArgumentException("Unsupported ASM BSM Argument: " + asmArg);
            }
        }

        return codeAPIArgsList.stream().toArray(Object[]::new);
    }
}
