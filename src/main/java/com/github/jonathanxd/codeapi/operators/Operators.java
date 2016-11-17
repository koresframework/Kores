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

import org.objectweb.asm.Opcodes;

/**
 * Created by jonathan on 12/05/16.
 */

/**
 * {@link Operator Operators} constants.
 *
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

    public static int convertToSimpleIf(int opcode) {
        if (opcode == Opcodes.IF_ICMPEQ) {
            return Opcodes.IFEQ;
        } else if (opcode == Opcodes.IF_ICMPLT) {
            return Opcodes.IFLT;
        } else if (opcode == Opcodes.IF_ICMPLE) {
            return Opcodes.IFLE;
        } else if (opcode == Opcodes.IF_ICMPGT) {
            return Opcodes.IFGT;
        } else if (opcode == Opcodes.IF_ICMPGE) {
            return Opcodes.IFGE;
        } else if (opcode == Opcodes.IF_ICMPNE) {
            return Opcodes.IFNE;
        }

        throw new IllegalArgumentException("Cannot convert opcode '"+opcode+"' to simple if.");
    }

    public static int primitiveToAsm(Operator operator, boolean isInverse) {
        if (!isInverse) {
            return primitiveToAsm(operator);
        } else {
            return inversePrimitiveToAsm(operator);
        }
    }

    public static int primitiveToAsm(Operator operator) {
        if (operator == EQUAL_TO) {
            // ==
            return Opcodes.IF_ICMPEQ;
        } else if (operator == LESS_THAN) {
            // <
            return Opcodes.IF_ICMPLT;
        } else if (operator == LESS_THAN_OR_EQUAL_TO) {
            // <=
            return Opcodes.IF_ICMPLE;
        } else if (operator == GREATER_THAN) {
            // >
            return Opcodes.IF_ICMPGT;
        } else if (operator == GREATER_THAN_OR_EQUAL_TO) {
            // >=
            return Opcodes.IF_ICMPGE;
        } else if (operator == NOT_EQUAL_TO) {
            // !=
            return Opcodes.IF_ICMPNE;
        }

        throw new RuntimeException("Cannot determine primitive opcode of '" + operator + "'");
    }

    public static int inversePrimitiveToAsm(Operator operator) {
        if (operator == EQUAL_TO) {
            // PARA SER IGUAL, NAO PODE SER DIFERENTE
            // !(!=)
            // !=
            return Opcodes.IF_ICMPNE;

        } else if (operator == LESS_THAN) {

            // PARA SER MENOR, NAO PODE SER MAIOR OU IGUAL
            // !(>=)
            // >=
            return Opcodes.IF_ICMPGE;

        } else if (operator == LESS_THAN_OR_EQUAL_TO) {
            // PARA SER MENOR OU IGUAL, NAO PODE SER MAIOR
            // !(>)
            // >
            return Opcodes.IF_ICMPGT;

        } else if (operator == GREATER_THAN) {
            // PARA SER MAIOR, NAO PODE SER MENOR OU IGUAL
            // !(<=)
            // <=
            return Opcodes.IF_ICMPLE;

        } else if (operator == GREATER_THAN_OR_EQUAL_TO) {
            // PARA SER MAIOR OU IGUAL, NAO PODE SER MENOR
            // !(<)
            // <
            return Opcodes.IF_ICMPLT;

        } else if (operator == NOT_EQUAL_TO) {
            // PARA SER DIFERENTE, NAO PODE SER IGUAL
            // !(==)
            return Opcodes.IF_ICMPEQ;
        }

        throw new RuntimeException("Cannot determine primitive opcode of '" + operator + "'");
    }

    public static int referenceToAsm(Operator operator, boolean isInverse) {
        if (!isInverse) {
            return referenceToAsm(operator);
        } else {
            return inverseReferenceToAsm(operator);
        }
    }

    public static int referenceToAsm(Operator operator) {
        if (operator == EQUAL_TO) {
            return Opcodes.IF_ACMPEQ;
        } else if (operator == NOT_EQUAL_TO) {
            return Opcodes.IF_ACMPNE;
        }

        throw new RuntimeException("Cannot determine reference opcode of '" + operator + "'");
    }

    public static int inverseReferenceToAsm(Operator operator) {
        if (operator == EQUAL_TO) {
            // PARA SER IGUAL, NAO PODE SER DIFERENTE
            // !(!=)
            // !=
            return Opcodes.IF_ACMPNE;
        } else if (operator == NOT_EQUAL_TO) {
            // PARA SER DIFERENTE, NAO PODE SER IGUAL
            // !(==)
            // ==
            return Opcodes.IF_ACMPEQ;
        }

        throw new RuntimeException("Cannot determine reference opcode of '" + operator + "'");
    }

    public static int inverseNullCheckToAsm(Operator operator) {
        if (operator == NOT_EQUAL_TO) {
            // PARA NAO SER NULO, NAO PODE SER NULO
            // !(NULL)
            // NULL
            return Opcodes.IFNULL;
        } else if (operator == EQUAL_TO) {
            // PARA SER NULO, NAO SER NAO-NULO
            // !(NONNULL)
            // NONNULL
            return Opcodes.IFNONNULL;
        }

        throw new RuntimeException("Cannot determine reference opcode of '" + operator + "'");
    }

    public static int nullCheckToAsm(Operator operator, boolean isInverse) {
        if (!isInverse) {
            return nullCheckToAsm(operator);
        } else {
            return inverseNullCheckToAsm(operator);
        }
    }

    public static int nullCheckToAsm(Operator operator) {
        if (operator == NOT_EQUAL_TO) {
            return Opcodes.IFNONNULL;
        } else if (operator == EQUAL_TO) {
            return Opcodes.IFNULL;
        }

        throw new RuntimeException("Cannot determine reference opcode of '" + operator + "'");
    }

    @GenerateTo(Named.class)
    private final static class SimpleOperator extends Operator {

        public SimpleOperator(String name) {
            super(name);
        }
    }

}
