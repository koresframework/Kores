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
package com.github.jonathanxd.codeapi.builder;

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.CodePart;
import com.github.jonathanxd.codeapi.base.impl.OperateImpl;
import com.github.jonathanxd.codeapi.operators.Operator;
import com.github.jonathanxd.codeapi.operators.Operators;

public final class OperateHelper {

    private CodePart part;

    private OperateHelper(CodePart part) {
        this.part = part;
    }

    public static OperateHelper builder(CodePart part) {
        return new OperateHelper(part);
    }

    /**
     * Plus (+).
     *
     * @param value 2nd value to add.
     * @return This.
     */
    public OperateHelper plus(CodePart value) {
        Operator operation = Operators.ADD;

        return this.operate(operation, value);
    }

    /**
     * Subtract (-).
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    public OperateHelper subtract(CodePart value) {
        Operator operation = Operators.SUBTRACT;

        return this.operate(operation, value);
    }

    /**
     * Multiply (*)
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    public OperateHelper multiply(CodePart value) {
        Operator operation = Operators.MULTIPLY;

        return this.operate(operation, value);
    }

    /**
     * Multiply (/)
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    public OperateHelper divide(CodePart value) {
        Operator operation = Operators.DIVISION;

        return this.operate(operation, value);
    }

    /**
     * Remainder (%)
     *
     * @param value 2nd value to remainder.
     * @return This.
     */
    public OperateHelper remainder(CodePart value) {
        Operator operation = Operators.REMAINDER;

        return this.operate(operation, value);
    }

    /**
     * Negate value.
     *
     * @return This.
     */
    public OperateHelper neg() {
        Operator operation = Operators.SUBTRACT;

        return this.operate(operation, null);
    }

    // &
    /**
     * Inclusive or (&amp;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper or(CodePart value) {
        Operator operation = Operators.BITWISE_INCLUSIVE_OR;

        return this.operate(operation, value);
    }

    // ^
    /**
     * Exclusive or (&#94;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper xor(CodePart value) {
        Operator operation = Operators.BITWISE_EXCLUSIVE_OR;

        return this.operate(operation, value);
    }


    /**
     * Bitwise not (~).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper not(CodePart value) {
        Operator operation = Operators.UNARY_BITWISE_COMPLEMENT;

        return this.operate(operation, value);
    }

    // >>
    /**
     * Bitwise shift right (&gt;&gt;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper shiftRight(CodePart value) {
        Operator operation = Operators.SIGNED_RIGHT_SHIFT;
        return this.operate(operation, value);
    }

    /**
     * Bitwise logical shift right (&gt;&gt;&gt;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper logicalShiftRight(CodePart value) {
        Operator operation = Operators.UNSIGNED_RIGHT_SHIFT;

        return this.operate(operation, value);
    }

    /**
     * Bitwise left shift (&lt;&lt;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    public OperateHelper leftShift(CodePart value) {
        Operator operation = Operators.SIGNED_LEFT_SHIFT;

        return this.operate(operation, value);
    }

    private OperateHelper operate(Operator operation, CodePart value) {
        this.part = new OperateImpl(this.part, operation, value);

        return this;
    }

    public CodePart build() {
        return this.part;
    }
}
