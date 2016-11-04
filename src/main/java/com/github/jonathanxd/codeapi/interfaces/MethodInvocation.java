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
package com.github.jonathanxd.codeapi.interfaces;

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Optional;

/**
 * A method invocation.
 */
public interface MethodInvocation extends CodePart, Typed, Accessor {

    /**
     * Gets the localization of the method.
     *
     * @return Localization of the method.
     */
    @Override
    Optional<CodeType> getLocalization();

    /**
     * Sets the localization of the method.
     *
     * @param localization Localization of the method.
     * @return new instance.
     */
    @Override
    MethodInvocation setLocalization(CodeType localization);

    /**
     * Gets the target to invoke (like instance).
     *
     * @return Target to invoke (like instance)
     */
    @Override
    Optional<CodePart> getTarget();

    /**
     * Gets the target to invoke (like instance).
     *
     * @param target Target to invoke (like instance)
     * @return new instance.
     */
    @Override
    MethodInvocation setTarget(CodePart target);

    /**
     * Gets the method specification.
     *
     * @return Method specification.
     */
    MethodSpecification getSpec();

    /**
     * Gets the method specification.
     *
     * @param specification Method specification.
     * @return new instance.
     */
    MethodInvocation setSpec(MethodSpecification specification);

    /**
     * Gets the invocation type.
     *
     * @return Invocation type.
     */
    InvokeType getInvokeType();

    /**
     * Sets the invocation type.
     *
     * @param invokeType Invocation type.
     * @return new instance.
     */
    MethodInvocation setInvokeType(InvokeType invokeType);

    /**
     * Gets the invoke dynamic.
     *
     * @return {@link Optional#of(Object)} {@link InvokeDynamic} if this is a dynamic invocation.
     */
    Optional<InvokeDynamic> getInvokeDynamic();

    /**
     * Sets the invoke dynamic.
     *
     * @param invokeDynamic Dynamic invocation.
     * @return new instance.
     */
    MethodInvocation setInvokeDynamic(InvokeDynamic invokeDynamic);

    @Override
    default Optional<CodeType> getType() {
        return Optional.ofNullable(this.getSpec().getMethodDescription().getReturnType());
    }

    @Override
    MethodInvocation setType(CodeType codeType);
}
