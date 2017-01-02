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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Specification of a invocation of a method.
 */
public class FullMethodSpec extends TypeSpec implements Comparable<FullMethodSpec> {

    /**
     * Localization of invocation target.
     */
    private final CodeType location;

    /**
     * Name of the method of invocation target.
     */
    private final String methodName;

    /**
     * Constructor
     *
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullMethodSpec(CodeType location, CodeType returnType, String methodName, CodeType... parameterTypes) {
        super(returnType, parameterTypes);
        this.location = location;
        this.methodName = methodName;
    }

    /**
     * Constructor
     *
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullMethodSpec(Class<?> location, Class<?> returnType, String methodName, Class<?>... parameterTypes) {
        super(Helper.getJavaType(returnType), Arrays.stream(parameterTypes).map(Helper::getJavaType).toArray(CodeType[]::new));
        this.location = Helper.getJavaType(location);
        this.methodName = methodName;
    }

    /**
     * Constructor
     *
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullMethodSpec(CodeType location, CodeType returnType, String methodName, List<CodeType> parameterTypes) {
        super(returnType, parameterTypes);
        this.location = location;
        this.methodName = methodName;
    }

    /**
     * Constructor
     *
     * @param location       Localization of the invocation target (type).
     * @param returnType     Return type of the invocation target.
     * @param methodName     Name of the invocation target.
     * @param parameterTypes Types of the parameters of invocation target.
     */
    public FullMethodSpec(Class<?> location, Class<?> returnType, String methodName, List<Class<?>> parameterTypes) {
        super(Helper.getJavaType(returnType), parameterTypes.stream().map(Helper::getJavaType).collect(Collectors.toList()));
        this.location = Helper.getJavaType(location);
        this.methodName = methodName;
    }

    /**
     * Gets the localization of invocation target.
     *
     * @return Localization of invocation target.
     */
    public CodeType getLocalization() {
        return this.location;
    }

    /**
     * Gets the name of method of invocation target.
     *
     * @return Name of method of invocation target.
     */
    public String getMethodName() {
        return this.methodName;
    }

    @Override
    public FullMethodSpec setParameterTypes(List<CodeType> parameterTypes) {
        return new FullMethodSpec(this.getLocalization(), this.getReturnType(), this.getMethodName(), parameterTypes);
    }

    @Override
    public FullMethodSpec setReturnType(CodeType returnType) {
        return new FullMethodSpec(this.getLocalization(), returnType, this.getMethodName(), this.getParameterTypes());
    }

    /*@Override
    public FullMethodSpec setType(CodeType codeType) {
        return this.setReturnType(codeType);
    }*/

    public FullMethodSpec setLocation(CodeType location) {
        return new FullMethodSpec(location, this.getReturnType(), this.getMethodName(), this.getParameterTypes());
    }

    public FullMethodSpec setMethodName(String methodName) {
        return new FullMethodSpec(this.getLocalization(), this.getReturnType(), methodName, this.getParameterTypes());
    }

    @Override
    public String toString() {
        return "FullMethodSpec[localization="+this.getLocalization()
                + ", methodName=" + this.getMethodName()
                + ", returnType=" + this.getReturnType()
                + ", parameterSpec=" + this.getParameterTypes()
                + "]";
    }

    /**
     *
     * This method will not compare the method localization.
     *
     * {@inheritDoc}
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public int compareTo(FullMethodSpec o) {
        if(o == null)
            return -1;

        return this.getMethodName().equals(o.getMethodName())
                && this.getParameterTypes().equals(o.getParameterTypes())
                && this.getReturnType().is(o.getReturnType()) ? 0 : 1;
    }

    @Override
    public boolean isExpression() {
        return CodePart.DefaultImpls.isExpression(this);
    }
}
