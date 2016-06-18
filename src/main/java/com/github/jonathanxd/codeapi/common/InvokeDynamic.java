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
package com.github.jonathanxd.codeapi.common;

import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;

import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;

import java.util.Arrays;

/**
 * Created by jonathan on 03/06/16.
 */
public class InvokeDynamic {

    private final FullMethodSpec methodSpec;

    private InvokeDynamic(FullMethodSpec fullMethodSpec) {
        this.methodSpec = fullMethodSpec;
    }

    public static InvokeDynamic invokeDynamicLambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        return new InvokeLambdaDynamic(fullMethodSpec, expectedTypes);
    }

    public static InvokeDynamic invokeDynamicBootstrap(InvokeType invokeType, FullMethodSpec bootstrapMethodSpec) {
        return new InvokeBootstrapDynamic(bootstrapMethodSpec, invokeType);
    }

    public static InvokeDynamic invokeDynamicBootstrap(InvokeType invokeType, FullMethodSpec bootstrapMethodSpec, Object... args) {
        return new InvokeBootstrapDynamic(bootstrapMethodSpec, invokeType, args);
    }

    public static boolean isInvokeDynamicLambda(InvokeDynamic type) {
        return type instanceof InvokeLambdaDynamic;
    }

    public static boolean isInvokeDynamicBootstrap(InvokeDynamic type) {
        return type instanceof InvokeBootstrapDynamic;
    }

    public static final class InvokeLambdaDynamic extends InvokeDynamic {

        private final TypeSpec expectedTypes;

        private InvokeLambdaDynamic(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            super(fullMethodSpec);
            this.expectedTypes = expectedTypes;
        }

        public TypeSpec getExpectedTypes() {
            return expectedTypes;
        }

    }

    public FullMethodSpec getMethodSpec() {
        return methodSpec;
    }

    public static final class InvokeBootstrapDynamic extends InvokeDynamic {

        private final InvokeType invokeType;
        private final Object[] arguments;

        public InvokeBootstrapDynamic(FullMethodSpec bootstrapMethodSpec, InvokeType invokeType) {
            super(bootstrapMethodSpec);
            this.invokeType = invokeType;
            this.arguments = new Object[0];
        }

        /**
         * Invoke Boostrap methods with bsm parameters
         * @param bootstrapMethodSpec Bootstrap methods
         * @param invokeType Type
         * @param arguments           BSM Arguments, must be an {@link String}, {@link Integer}, {@link Long}, {@link Float}, {@link Double}, {@link CodeType}, or {@link FullInvokeSpec}.
         */
        public InvokeBootstrapDynamic(FullMethodSpec bootstrapMethodSpec, InvokeType invokeType, Object[] arguments) {
            super(bootstrapMethodSpec);
            this.invokeType = invokeType;
            this.arguments = arguments.clone();
        }

        public Object[] toAsmArguments() {
            Object[] asmArgs = new Object[arguments.length];

            for (int i = 0; i < arguments.length; i++) {
                Object arg = arguments[i];
                final Object converted;

                if(arg instanceof String || arg instanceof Integer || arg instanceof Long || arg instanceof Float || arg instanceof Double) {
                    converted = arg;
                } else if(arg instanceof CodeType) {
                    converted = Type.getType(((CodeType) arg).getJavaSpecName());
                } else if(arg instanceof FullInvokeSpec) {
                    FullInvokeSpec invokeSpec = (FullInvokeSpec) arg;

                    converted = new Handle(InvokeType.toAsm_H(invokeSpec.getInvokeType()),
                            Common.codeTypeToSimpleAsm(invokeSpec.getLocation()),
                            invokeSpec.getMethodName(),
                            Common.typeSpecToAsm(invokeSpec),
                            invokeSpec.getInvokeType() == InvokeType.INVOKE_INTERFACE);
                } else {
                    throw new IllegalArgumentException("Illegal argument at index '"+i+"' of arguments array ["+ Arrays.toString(arguments)+"], element type unsupported! Read the documentation.");
                }

                asmArgs[i] = converted;
            }

            return asmArgs;
        }

        public InvokeType getInvokeType() {
            return invokeType;
        }

        public Object[] getArguments() {
            return arguments;
        }

        /*
            MethodType mt = MethodType.methodType(CallSite.class,
        MethodHandles.Lookup.class, String.class, MethodType.class);

Handle bootstrap = new Handle(Opcodes.INVOKESTATIC, "package1/Test2",
        "bootstrap", mt.toMethodDescriptorString());
             */



        /*@Override
        public MethodType getMethodType() {
            return methodType;
        }*/
    }
}
