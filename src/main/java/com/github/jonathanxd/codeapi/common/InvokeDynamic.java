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

/**
 * Created by jonathan on 03/06/16.
 */
public class InvokeDynamic {

    private InvokeDynamic() {
    }

    public static InvokeDynamic invokeDynamicLambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        return new InvokeLambdaDynamic(fullMethodSpec, expectedTypes);
    }

    // TODO
    public static InvokeDynamic invokeDynamicBootstrap(InvokeType invokeType, FullLoadedMethodSpec bootstrapMethodSpec) {
        return new InvokeBootstrapDynamic(bootstrapMethodSpec, invokeType);
    }

    public static boolean isInvokeDynamicLambda(InvokeDynamic type) {
        return type instanceof InvokeLambdaDynamic;
    }

    public static boolean isInvokeDynamicBootstrap(InvokeDynamic type) {
        return type instanceof InvokeBootstrapDynamic;
    }

    public static final class InvokeLambdaDynamic extends InvokeDynamic {

        private final FullMethodSpec methodSpec;
        private final TypeSpec expectedTypes;

        private InvokeLambdaDynamic(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            this.methodSpec = fullMethodSpec;
            this.expectedTypes = expectedTypes;
        }

        public TypeSpec getExpectedTypes() {
            return expectedTypes;
        }

        public FullMethodSpec getMethodSpec() {
            return methodSpec;
        }
    }

    public static final class InvokeBootstrapDynamic extends InvokeDynamic {

        private final FullLoadedMethodSpec bootstrapMethodSpec;
        private final InvokeType invokeType;

        public InvokeBootstrapDynamic(FullLoadedMethodSpec bootstrapMethodSpec, InvokeType invokeType) {
            this.bootstrapMethodSpec = bootstrapMethodSpec;
            this.invokeType = invokeType;
        }

        public FullLoadedMethodSpec getBootstrapMethodSpec() {
            return bootstrapMethodSpec;
        }

        public java.lang.invoke.MethodType getMethodType() {
            return bootstrapMethodSpec.toMethodType();
        }

        public InvokeType getInvokeType() {
            return invokeType;
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
