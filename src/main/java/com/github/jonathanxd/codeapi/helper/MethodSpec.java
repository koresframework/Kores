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
package com.github.jonathanxd.codeapi.helper;

import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.common.CodeArgument;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by jonathan on 10/05/16.
 */
@GenerateTo(MethodSpecification.class)
public class MethodSpec implements MethodSpecification {

    private final Collection<CodeArgument> arguments;
    private final String methodName;
    private final CodeType returnType;
    private final MethodType methodType;

    public MethodSpec(String methodName, Collection<CodeArgument> arguments) {
        this(arguments, methodName, null, MethodType.METHOD);
    }

    public MethodSpec(String methodName, CodeType returnType, Collection<CodeArgument> arguments) {
        this(arguments, methodName, returnType, MethodType.METHOD);
    }

    public MethodSpec(CodeType returnType, Collection<CodeArgument> arguments) {
        this(arguments, null, returnType, MethodType.METHOD);
    }

    public MethodSpec(CodeType returnType, MethodType methodType, Collection<CodeArgument> arguments) {
        this(arguments, null, returnType, methodType);
    }

    public MethodSpec(Collection<CodeArgument> arguments, String methodName, CodeType returnType, MethodType methodType) {
        this.arguments = arguments == null ? Collections.emptyList() : Collections.unmodifiableCollection(arguments);
        this.methodName = methodName;
        this.returnType = returnType;
        this.methodType = methodType;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public CodeType getReturnType() {
        return returnType;
    }

    @Override
    public Collection<CodeArgument> getArguments() {
        return this.arguments;
    }

    @Override
    public boolean isArray() {
        return methodType == MethodType.ARRAY_CONSTRUCTOR;
    }

    @Override
    public MethodType getMethodType() {
        return methodType;
    }
}
