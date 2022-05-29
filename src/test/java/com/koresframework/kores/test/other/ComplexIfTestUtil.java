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
import com.koresframework.kores.KoresPartKt;
import com.koresframework.kores.Instructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.common.Commons;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.operator.Operators;
import com.koresframework.kores.type.KoresTypes;
import com.github.jonathanxd.iutils.collection.Collections3;

import org.junit.Assert;
import org.junit.Test;

public class ComplexIfTestUtil {
    @Test
    public void test() {
        Instruction value = Factories.ifStatement(
                Factories.check(Literals.INT(9), Operators.LESS_THAN, Literals.INT(5)),
                Instructions.fromVarArgs(Literals.STRING("9 < 5")),
                Instructions.fromVarArgs(Literals.STRING("9 >= 5"))
        );

        VariableFactory.variable(Types.STRING, "b", value);

        Instruction value2 = Factories.tryStatement(
                Instructions.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        Instructions.fromVarArgs(Literals.STRING("Hello"))
                )),
                Instructions.fromVarArgs(Literals.STRING("Hello"))
        );

        Instruction value3 = Factories.tryStatement(
                Instructions.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        Instructions.fromVarArgs(Literals.STRING("Hello"))
                )),
                Instructions.fromVarArgs(Literals.INT(9))
        );

        Instruction value4 = Factories.tryStatement(
                Instructions.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        Instructions.fromVarArgs(Literals.STRING("Hello"))
                )),
                Instructions.fromVarArgs(Commons.invokeValueOf(Types.INTEGER_WRAPPER, Literals.INT(9)))
        );

        Instruction value5 = Factories.tryStatement(
                Instructions.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        Instructions.fromVarArgs(Literals.STRING("Hello"))
                )),
                Instructions.empty()
        );

        Assert.assertEquals(KoresTypes.getKoresType(String.class), KoresPartKt.getType(value));
        Assert.assertEquals(KoresTypes.getKoresType(String.class), KoresPartKt.getType(value2));
        Assert.assertEquals(null, KoresPartKt.getTypeOrNull(value3));
        Assert.assertEquals(Types.OBJECT, KoresPartKt.getTypeOrNull(value4));
        Assert.assertEquals(null, KoresPartKt.getTypeOrNull(value5));

    }


}
