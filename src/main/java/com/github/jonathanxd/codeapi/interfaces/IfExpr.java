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
import com.github.jonathanxd.codeapi.operators.Operator;

/**
 * If expression.
 *
 * <pre>
 *     {@code
 *          expr1 operation expr2
 *     }
 * </pre>
 *
 * @see IfBlock
 */
public interface IfExpr extends CodePart {
    /**
     * Gets the first expression.
     *
     * @return First expression.
     */
    CodePart getExpr1();

    /**
     * Sets the first expression.
     *
     * @param expr expression.
     * @return new instance.
     */
    IfExpr setExpr1(CodePart expr);

    /**
     * Gets the operation.
     *
     * @return Operation.
     */
    Operator getOperation();

    /**
     * Sets the operation.
     *
     * @param operation Operation.
     * @return new instance.
     */
    IfExpr setOperation(Operator operation);

    /**
     * Gets the second expression.
     *
     * @return Second expression
     */
    CodePart getExpr2();

    /**
     * Sets the second expression.
     *
     * @param expr Second expression
     * @return new instance.
     */
    IfExpr setExpr2(CodePart expr);
}
