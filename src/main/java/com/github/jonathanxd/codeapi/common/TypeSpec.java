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

import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.helper.Helper;
import com.github.jonathanxd.codeapi.interfaces.RequiredTyped;
import com.github.jonathanxd.codeapi.interfaces.Typed;
import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Specification of return type and parameter types.
 *
 * Commonly this specification is used by {@link com.github.jonathanxd.codeapi.helper.MethodSpec} to
 * specify a method to be invoked.
 */
public class TypeSpec implements Typed, RequiredTyped, CodePart {

    /**
     * Return type
     */
    private final CodeType returnType;

    /**
     * Parameter types
     */
    private final List<CodeType> parameterTypes;

    /**
     * Constructor
     *
     * @param returnType     Return type
     */
    public TypeSpec(CodeType returnType) {
        this(returnType, (List<CodeType>) null);
    }

    /**
     * Constructor
     *
     * @param returnType     Return type
     * @param parameterTypes Parameter types
     */
    public TypeSpec(CodeType returnType, Class<?>... parameterTypes) {
        this(returnType, parameterTypes.length <= 0 ? null : Arrays.asList(Helper.getJavaTypes(parameterTypes)));
    }

    /**
     * Constructor
     *
     * @param returnType     Return type
     * @param parameterTypes Parameter types
     */
    public TypeSpec(CodeType returnType, CodeType... parameterTypes) {
        this(returnType, parameterTypes.length <= 0 ? null : Arrays.asList(parameterTypes));
    }

    /**
     * Constructor
     *
     * @param returnType     Return type
     * @param parameterTypes Parameter types
     */
    public TypeSpec(CodeType returnType, List<CodeType> parameterTypes) {
        this.returnType = returnType;
        this.parameterTypes = parameterTypes == null || parameterTypes.stream().allMatch(c -> c == null) ? Collections.emptyList() : Collections.unmodifiableList(parameterTypes);
    }

    @Override
    public Optional<CodeType> getType() {
        return Optional.of(this.getReturnType());
    }

    /**
     * Gets the return type
     *
     * @return Return type
     */
    public CodeType getReturnType() {
        return this.returnType;
    }

    /**
     * Gets the parameter types.
     *
     * @return Parameter types.
     */
    public List<CodeType> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override
    public String toString() {
        return "TypeSpec[returnType=" + this.getReturnType() + ", parameterSpec=" + getParameterTypes() + "]";
    }

}
