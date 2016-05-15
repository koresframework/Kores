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
package com.github.jonathanxd.codeapi.operators;

import com.github.jonathanxd.codeapi.annotation.GenerateTo;
import com.github.jonathanxd.codeapi.interfaces.Named;

/**
 * Created by jonathan on 12/05/16.
 */

/**
 * @see <a href=https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html>Summary of
 * Operators</a>
 */
public class Operators {

    public static final Operator ASSIGNMENT = new SimpleOperator("=");

    public static final Operator ADD = new SimpleOperator("+");
    public static final Operator SUBTRACT = new SimpleOperator("-");
    public static final Operator MULTIPLY = new SimpleOperator("*");
    public static final Operator DIVISION = new SimpleOperator("/");
    public static final Operator REMAINDER = new SimpleOperator("%");

    public static final Operator INCREMENT = new SimpleOperator("++");
    public static final Operator DECREMENT = new SimpleOperator("--");

    public static final Operator NOT = new SimpleOperator("!");

    public static final Operator EQUAL_TO = new SimpleOperator("==");
    public static final Operator NOT_EQUAL_TO = new SimpleOperator("!=");
    public static final Operator GREATER_THAN = new SimpleOperator(">");
    public static final Operator GREATER_THAN_OR_EQUAL_TO = new SimpleOperator(">=");
    public static final Operator LESS_THAN = new SimpleOperator("<");
    public static final Operator LESS_THAN_OR_EQUAL_TO = new SimpleOperator("<=");

    public static final Operator AND = new SimpleOperator("&&");
    public static final Operator OR = new SimpleOperator("||");

    public static final Operator UNARY_BITWISE_COMPLEMENT = new SimpleOperator("~");
    public static final Operator BITWISE_AND = new SimpleOperator("&");
    public static final Operator BITWISE_EXCLUSIVE_OR = new SimpleOperator("^");
    public static final Operator BITWISE_INCLUSIVE_OR = new SimpleOperator("|");

    public static final Operator SIGNED_LEFT_SHIFT = new SimpleOperator("<<");
    public static final Operator SIGNED_RIGHT_SHIFT = new SimpleOperator(">>");
    public static final Operator UNSIGNED_RIGHT_SHIFT = new SimpleOperator(">>>");

    @GenerateTo(Named.class)
    private final static class SimpleOperator extends Operator {

        public SimpleOperator(String name) {
            super(name);
        }
    }

}
