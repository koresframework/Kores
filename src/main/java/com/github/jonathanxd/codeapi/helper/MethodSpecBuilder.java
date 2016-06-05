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
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.common.CodeArgument;

import java.util.Collection;

/**
 * Created by jonathan on 04/06/16.
 */
public final class MethodSpecBuilder {
    private Collection<CodeArgument> arguments;
    private String methodName;
    private CodeType returnType;
    private MethodType methodType;

    private MethodSpecBuilder() {
    }

    public static MethodSpecBuilder builder() {
        return new MethodSpecBuilder();
    }

    public MethodSpecBuilder withArguments(Collection<CodeArgument> arguments) {
        this.arguments = arguments;
        return this;
    }

    public MethodSpecBuilder withMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public MethodSpecBuilder withReturnType(CodeType returnType) {
        this.returnType = returnType;
        return this;
    }

    public MethodSpecBuilder withMethodType(MethodType methodType) {
        this.methodType = methodType;
        return this;
    }

    public MethodSpec build() {
        return new MethodSpec(arguments, methodName, returnType, methodType);
    }
}
