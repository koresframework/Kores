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

import com.github.jonathanxd.codeapi.CodeElement;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.common.InvokeDynamic;
import com.github.jonathanxd.codeapi.common.InvokeType;
import com.github.jonathanxd.codeapi.types.CodeType;

/**
 * Method fragment is a method invocation and declaration in the CallSite. Commonly used in lambdas.
 */
public interface MethodFragment extends MethodInvocation, CodeElement, CodePart {

    /**
     * Gets the method declaration.
     *
     * @return Method declaration.
     */
    MethodDeclaration getMethod();

    /**
     * Sets the method declaration.
     *
     * @param method Method declaration.
     * @return new instance.
     */
    MethodFragment setMethod(MethodDeclaration method);

    /**
     * Gets the target declaration.
     *
     * @return Target declaration.
     */
    TypeDeclaration getTargetDeclaration();

    /**
     * Sets the target declaration.
     *
     * @param targetDeclaration Target declaration.
     * @return new instance.
     */
    MethodFragment setTargetDeclaration(TypeDeclaration targetDeclaration);

    @Override
    MethodFragment setLocalization(CodeType localization);

    @Override
    MethodFragment setTarget(CodePart target);

    @Override
    MethodFragment setSpec(MethodSpecification specification);

    @Override
    MethodFragment setInvokeType(InvokeType invokeType);

    @Override
    MethodFragment setInvokeDynamic(InvokeDynamic invokeDynamic);

    @Override
    MethodFragment setType(CodeType codeType);
}
