/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

/**
 * Invoke Specification used by dynamic invocations ({@link InvokeDynamic}).
 */
public class FullInvokeSpec extends FullMethodSpec {

    /**
     * Type of the invocation.
     */
    private final InvokeType invokeType;

    /**
     * Constructor
     *
     * @param invokeType     Type of the invocation target.
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullInvokeSpec(InvokeType invokeType, CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        super(location, returnType, methodName, parameterTypes);
        this.invokeType = invokeType;
    }

    /**
     * Constructor
     *
     * @param invokeType     Type of the invocation target.
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullInvokeSpec(InvokeType invokeType, Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        super(location, returnType, methodName, parameterTypes);
        this.invokeType = invokeType;
    }

    /**
     * Gets the invocation type.
     *
     * @return invocation type.
     */
    public InvokeType getInvokeType() {
        return this.invokeType;
    }

    @Override
    public String toString() {
        return "FullInvokeSpec[localization="+this.getLocalization()
                + ", invokeType=" + this.getInvokeType()
                + ", methodName=" + this.getMethodName()
                + ", returnType=" + this.getReturnType()
                + ", parameterSpec=" + this.getParameterTypes()
                + "]";
    }
}
