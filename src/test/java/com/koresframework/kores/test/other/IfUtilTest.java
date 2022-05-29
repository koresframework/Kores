/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test.other;

import com.koresframework.kores.Instruction;
import com.koresframework.kores.base.IfExpr;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.inspect.IfExpressionInspectKt;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import com.github.jonathanxd.iutils.collection.Collections3;

import com.koresframework.kores.Instruction;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IfUtilTest {

    @Test
    public void ifUtilTest() {
        IfExpr expr1 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                Operators.EQUAL_TO, Literals.TRUE);

        IfExpr expr2 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "b"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr3 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "c"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr4 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "d"),
                Operators.EQUAL_TO, Literals.TRUE);

        List<Instruction> expressions =
                Collections3.listOf(expr1, Operators.AND, expr2, Operators.AND, expr3, Operators.AND, expr4);

        List<Instruction> expressions2 =
                Collections3.listOf(expr1, Operators.AND, expr2, Operators.AND, expr3, Operators.OR, expr4);

        Assert.assertTrue(IfExpressionInspectKt.alwaysBranch(expressions, instruction -> instruction == expr1));
        Assert.assertFalse(IfExpressionInspectKt.alwaysBranch(expressions2, instruction -> instruction == expr1));
        Assert.assertFalse(IfExpressionInspectKt.alwaysBranch(expressions2, instruction -> instruction == expr4));
    }

    @Test
    public void ifUtilTest2() {
        IfExpr expr1 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                Operators.EQUAL_TO, Literals.FALSE);

        IfExpr expr11 = new IfExpr(expr1, Operators.EQUAL_TO, Literals.FALSE);

        IfExpr expr2 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "b"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr3 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "c"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr4 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "d"),
                Operators.EQUAL_TO, Literals.TRUE);

        List<Instruction> expressions =
                Collections3.listOf(expr11, Operators.AND, expr2, Operators.AND, expr3, Operators.AND, expr4);

        Assert.assertTrue(IfExpressionInspectKt.alwaysBranch(expressions, instruction -> instruction instanceof IfExpr
                && IfExpressionInspectKt.isCheckTrueAnd((IfExpr) instruction, insn ->
                insn.equals(Factories.accessVariable(Boolean.TYPE, "a")))));

        Assert.assertEquals(
                new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                        Operators.EQUAL_TO, Literals.TRUE),
                IfExpressionInspectKt.removeRedundantNot(expressions).get(0));

    }

    @Test
    public void ifUtilTest3() {
        IfExpr expr1 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                Operators.EQUAL_TO, Literals.TRUE);

        IfExpr expr11 = new IfExpr(expr1, Operators.EQUAL_TO, Literals.TRUE);

        IfExpr expr2 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "b"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr3 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "c"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr4 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "d"),
                Operators.EQUAL_TO, Literals.TRUE);

        List<Instruction> expressions =
                Collections3.listOf(expr11, Operators.AND, expr2, Operators.AND, expr3, Operators.AND, expr4);

        Assert.assertEquals(
                new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                        Operators.EQUAL_TO, Literals.TRUE),
                IfExpressionInspectKt.removeRedundantNot(expressions).get(0));
    }

    @Test
    public void ifUtilTest4() {
        IfExpr expr1 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                Operators.EQUAL_TO, Literals.FALSE);

        IfExpr expr11 = new IfExpr(expr1, Operators.EQUAL_TO, Literals.TRUE);

        IfExpr expr2 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "b"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr3 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "c"),
                Operators.EQUAL_TO, Literals.TRUE);
        IfExpr expr4 = new IfExpr(Factories.accessVariable(Boolean.TYPE, "d"),
                Operators.EQUAL_TO, Literals.TRUE);

        List<Instruction> expressions =
                Collections3.listOf(expr11, Operators.AND, expr2, Operators.AND, expr3, Operators.AND, expr4);

        Assert.assertEquals(
                new IfExpr(Factories.accessVariable(Boolean.TYPE, "a"),
                        Operators.EQUAL_TO, Literals.FALSE),
                IfExpressionInspectKt.removeRedundantNot(expressions).get(0));
    }

}
