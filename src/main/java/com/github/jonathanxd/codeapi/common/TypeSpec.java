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

import com.github.jonathanxd.codeapi.types.CodeType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jonathan on 13/06/16.
 */
public class TypeSpec {

    private final CodeType returnType;
    private final List<CodeType> parameterSpec;

    public TypeSpec(CodeType returnType, CodeType... parameterSpecs) {
        this.returnType = returnType;
        this.parameterSpec = parameterSpecs.length <= 0 ? Collections.emptyList() : Collections.unmodifiableList(Arrays.asList(parameterSpecs));
    }

    public TypeSpec(CodeType returnType, List<CodeType> parameterSpecs) {
        this.returnType = returnType;
        this.parameterSpec = parameterSpecs == null || parameterSpecs.stream().allMatch(c -> c == null) ? Collections.emptyList() : Collections.unmodifiableList(parameterSpecs);
    }

    public CodeType getReturnType() {
        return returnType;
    }

    public List<CodeType> getParameterSpec() {
        return parameterSpec;
    }

    @Override
    public String toString() {
        return "TypeSpec[returnType=" + this.getReturnType() + ", parameterSpec=" + getParameterSpec() + "]";
    }

}
