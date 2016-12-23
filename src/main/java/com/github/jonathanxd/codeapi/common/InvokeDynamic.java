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

import com.github.jonathanxd.codeapi.interfaces.MethodFragment;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;

import java.util.function.Supplier;

/**
 * Dynamic invocation of a method using a Bootstrap.
 */
public class InvokeDynamic {

    /**
     * Specification of method.
     */
    private final FullMethodSpec methodSpec;

    private InvokeDynamic(FullMethodSpec fullMethodSpec) {
        this.methodSpec = fullMethodSpec;
    }

    /**
     * Generate a lambda invocation of an SAM interface method.
     *
     * @param fullMethodSpec Specification of SAM interface method, example: {@link
     *                       Supplier#get()}.
     * @param expectedTypes  Expected types (example: If a {@link Supplier} of {@link String},
     *                       expected return type is {@link Supplier}).
     * @return Lambda method reference.
     */
    public static LambdaMethodReference invokeDynamicLambda(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
        return new LambdaMethodReference(fullMethodSpec, expectedTypes);
    }

    /**
     * Generate a lambda invocation of an SAM interface method.
     *
     * @param fullMethodSpec Specification of SAM interface method, example: {@link
     *                       Supplier#get()}.
     * @param expectedTypes  Expected types (example: If a {@link Supplier} of {@link String},
     *                       expected return type is {@link Supplier}).
     * @param fragment       Fragment (like lambda body).
     * @return Lambda method reference.
     */
    public static LambdaFragment invokeDynamicLambdaFragment(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes, MethodFragment fragment) {
        return new LambdaFragment(fullMethodSpec, expectedTypes, fragment);
    }

    /**
     * Invoke a bootstrap method.
     *
     * @param invokeType          Type of invocation.
     * @param bootstrapMethodSpec Bootstrap method specification.
     * @return Invocation of bootstrap method.
     */
    public static Bootstrap invokeDynamicBootstrap(InvokeType invokeType, FullMethodSpec bootstrapMethodSpec) {
        return new Bootstrap(bootstrapMethodSpec, invokeType);
    }

    /**
     * Invoke a bootstrap method.
     *
     * @param invokeType          Type of invocation.
     * @param bootstrapMethodSpec Bootstrap method specification.
     * @param args                Bootstrap arguments: must be an {@link String}, {@link Integer},
     *                            {@link Long}, {@link Float}, {@link Double}, {@link CodeType}, or
     *                            {@link FullInvokeSpec}.
     * @return Invocation of bootstrap method.
     */
    public static Bootstrap invokeDynamicBootstrap(InvokeType invokeType, FullMethodSpec bootstrapMethodSpec, Object... args) {
        return new Bootstrap(bootstrapMethodSpec, invokeType, args);
    }

    public static boolean isInvokeDynamicLambda(InvokeDynamic type) {
        return type instanceof LambdaMethodReference;
    }

    public static boolean isInvokeDynamicBootstrap(InvokeDynamic type) {
        return type instanceof Bootstrap;
    }

    public FullMethodSpec getMethodSpec() {
        return this.methodSpec;
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("methodSpec", this.getMethodSpec())
                .toString();
    }

    public static class LambdaMethodReference extends InvokeDynamic {

        private final TypeSpec expectedTypes;

        private LambdaMethodReference(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes) {
            super(fullMethodSpec);
            this.expectedTypes = expectedTypes;
        }

        public TypeSpec getExpectedTypes() {
            return expectedTypes;
        }

        @Override
        public String toString() {
            return ToStringBuilder.builder(this.getClass())
                    .add("methodSpec", this.getMethodSpec())
                    .add("expectedTypes", this.getExpectedTypes())
                    .toString();
        }
    }

    public static final class LambdaFragment extends LambdaMethodReference {

        private final MethodFragment methodFragment;

        private LambdaFragment(FullMethodSpec fullMethodSpec, TypeSpec expectedTypes, MethodFragment methodFragment) {
            super(fullMethodSpec, expectedTypes);
            this.methodFragment = methodFragment;
        }

        public MethodFragment getMethodFragment() {
            return this.methodFragment;
        }

        @Override
        public String toString() {
            return ToStringBuilder.builder(this.getClass())
                    .add("methodSpec", this.getMethodSpec())
                    .add("expectedTypes", this.getExpectedTypes())
                    .add("methodFragment", this.getMethodFragment())
                    .toString();
        }
    }

    public static final class Bootstrap extends InvokeDynamic {

        private final InvokeType invokeType;
        private final Object[] arguments;

        public Bootstrap(FullMethodSpec bootstrapMethodSpec, InvokeType invokeType) {
            super(bootstrapMethodSpec);
            this.invokeType = invokeType;
            this.arguments = new Object[0];
        }

        /**
         * Invoke Boostrap methods with bsm parameters
         *
         * @param bootstrapMethodSpec Bootstrap methods
         * @param invokeType          Type
         * @param arguments           BSM Arguments, must be an {@link String}, {@link Integer},
         *                            {@link Long}, {@link Float}, {@link Double}, {@link CodeType},
         *                            or {@link FullInvokeSpec}.
         */
        public Bootstrap(FullMethodSpec bootstrapMethodSpec, InvokeType invokeType, Object[] arguments) {
            super(bootstrapMethodSpec);
            this.invokeType = invokeType;
            this.arguments = arguments.clone();
        }

        public InvokeType getInvokeType() {
            return this.invokeType;
        }

        public Object[] getArguments() {
            return this.arguments;
        }

        @Override
        public String toString() {
            return ToStringBuilder.builder(this.getClass())
                    .add("methodSpec", this.getMethodSpec())
                    .add("invokeType", this.getInvokeType())
                    .add("arguments", this.getArguments())
                    .toString();
        }
    }
}
