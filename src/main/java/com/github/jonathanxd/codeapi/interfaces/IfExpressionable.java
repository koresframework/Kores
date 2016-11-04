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
import com.github.jonathanxd.codeapi.operators.Operators;

import java.util.List;

/**
 * A element that holds multiple {@link IfExpr}s and {@link Operators Operations}.
 */
public interface IfExpressionable extends CodePart {

    /**
     * A method that checks if the {@code codePart} is a valid {@link IfExpr} or {@link Operators
     * Operation}.
     *
     * @param codePart Part to check.
     */
    static void check(CodePart codePart) {
        if (!(codePart instanceof IfExpr || codePart == Operators.AND || codePart == Operators.OR)) {
            throw new IllegalArgumentException("Accept only IfExpr and Operators AND & OR. Current: " + codePart);
        }
    }

    /**
     * Gets if expressions and operators.
     *
     * @return If expressions and operators.
     */
    List<CodePart> getIfExprsAndOps();

    /**
     * Sets if expressions and operators.
     *
     * @param ifExprsAndOps If expressions and operators.
     * @return new instance.
     */
    IfExpressionable setIfExprsAndOps(List<CodePart> ifExprsAndOps);

}
