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
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.util.ToStringBuilder;
import com.github.jonathanxd.codeapi.visitgenerator.bytecode.Common;
import com.github.jonathanxd.codeapi.interfaces.MethodSpecification;
import com.github.jonathanxd.codeapi.types.CodeType;
import com.github.jonathanxd.codeapi.common.CodeArgument;

import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 10/05/16.
 */
@GenerateTo(MethodSpecification.class)
public class MethodSpec implements MethodSpecification {

    private final List<CodeArgument> arguments;
    private final String methodName;
    private final TypeSpec methodDescription;
    private final MethodType methodType;

    public MethodSpec(MethodType methodType) {
        this(null, null, (CodeType) null, methodType);
    }

    public MethodSpec(List<CodeArgument> arguments, MethodType methodType) {
        this(null, arguments, (CodeType) null, methodType);
    }

    public MethodSpec(String methodName, List<CodeArgument> arguments) {
        this(methodName, arguments, (CodeType) null, MethodType.METHOD);
    }

    public MethodSpec(String methodName, CodeType returnType, List<CodeArgument> arguments) {
        this(methodName, arguments, returnType, MethodType.METHOD);
    }

    public MethodSpec(String methodName, Class<?> returnType, List<CodeArgument> arguments) {
        this(methodName, arguments, Helper.getJavaType(returnType), MethodType.METHOD);
    }

    public MethodSpec(String methodName, Class<?> returnType, List<CodeArgument> arguments, MethodType methodType) {
        this(methodName, arguments, Helper.getJavaType(returnType), methodType);
    }

    public MethodSpec(String methodName, TypeSpec methodDescription, List<CodeArgument> arguments) {
        this(methodName, arguments, methodDescription, MethodType.METHOD);
    }

    public MethodSpec(CodeType returnType, List<CodeArgument> arguments) {
        this(null, arguments, returnType, MethodType.METHOD);
    }

    public MethodSpec(CodeType returnType, List<CodeArgument> arguments, MethodType methodType) {
        this(null, arguments, returnType, methodType);
    }

    public MethodSpec(TypeSpec methodDescription, List<CodeArgument> arguments) {
        this(null, arguments, methodDescription, MethodType.METHOD);
    }

    public MethodSpec(TypeSpec methodDescription, List<CodeArgument> arguments, MethodType methodType) {
        this(null, arguments, methodDescription, methodType);
    }

    public MethodSpec(String methodName, List<CodeArgument> arguments, CodeType returnType, MethodType methodType) {
        this.arguments = arguments == null ? Collections.emptyList() : Collections.unmodifiableList(arguments);
        this.methodName = methodName != null ? methodName : methodType == MethodType.CONSTRUCTOR ? "<init>" : null;
        this.methodDescription = Common.specFromLegacy(returnType, arguments);
        this.methodType = methodType;
    }

    public MethodSpec(String methodName, List<CodeArgument> arguments, TypeSpec methodDescription, MethodType methodType) {
        this.arguments = arguments == null ? Collections.emptyList() : Collections.unmodifiableList(arguments);
        this.methodName = methodName != null ? methodName : methodType == MethodType.CONSTRUCTOR ? "<init>" : null;
        this.methodDescription = methodDescription;
        this.methodType = methodType;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public TypeSpec getMethodDescription() {
        return methodDescription;
    }

    @Override
    public List<CodeArgument> getArguments() {
        return this.arguments;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public MethodType getMethodType() {
        return methodType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.builder(this.getClass())
                .add("type", this.getMethodType())
                .add("methodName", this.getMethodName())
                .add("description", this.getMethodDescription())
                .add("arguments", this.getArguments())
                .toString();
    }
}
