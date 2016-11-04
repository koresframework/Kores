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
import com.github.jonathanxd.codeapi.common.CodeArgument;
import com.github.jonathanxd.codeapi.common.MethodType;
import com.github.jonathanxd.codeapi.common.TypeSpec;

import java.util.List;

/**
 * Specification of a method.
 */
public interface MethodSpecification extends Argumenterizable, CodePart {

    /**
     * Gets the name of the method.
     *
     * @return Name of the method.
     */
    String getMethodName();


    /**
     * Sets the name of the method.
     *
     * @param name Name of the method.
     * @return new instance.
     */
    MethodSpecification setMethodName(String name);

    /**
     * Gets the description of the method.
     *
     * @return description of the method.
     */
    TypeSpec getMethodDescription();

    /**
     * Sets the description of the method.
     *
     * @param desc description of the method.
     * @return new instance.
     */
    MethodSpecification setMethodDescription(TypeSpec desc);

    /**
     * Gets the method type.
     *
     * @return Method type
     */
    MethodType getMethodType();

    /**
     * Sets the method type.
     *
     * @param type Method type
     * @return new instance.
     */
    MethodSpecification setMethodType(MethodType type);

    @Override
    MethodSpecification setArguments(List<CodeArgument> codeArgumentList);
}
