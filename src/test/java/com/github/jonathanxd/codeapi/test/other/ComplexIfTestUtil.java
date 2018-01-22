/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.CodeInstruction;
import com.github.jonathanxd.codeapi.CodePartKt;
import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.common.Commons;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.factory.VariableFactory;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.operator.Operators;
import com.github.jonathanxd.codeapi.type.CodeTypes;
import com.github.jonathanxd.iutils.collection.Collections3;

import org.junit.Assert;
import org.junit.Test;

public class ComplexIfTestUtil {
    @Test
    public void test() {
        CodeInstruction value = Factories.ifStatement(
                Factories.check(Literals.INT(9), Operators.LESS_THAN, Literals.INT(5)),
                CodeSource.fromVarArgs(Literals.STRING("9 < 5")),
                CodeSource.fromVarArgs(Literals.STRING("9 >= 5"))
        );

        VariableFactory.variable(Types.STRING, "b", value);

        CodeInstruction value2 = Factories.tryStatement(
                CodeSource.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        CodeSource.fromVarArgs(Literals.STRING("Hello"))
                )),
                CodeSource.fromVarArgs(Literals.STRING("Hello"))
        );

        CodeInstruction value3 = Factories.tryStatement(
                CodeSource.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        CodeSource.fromVarArgs(Literals.STRING("Hello"))
                )),
                CodeSource.fromVarArgs(Literals.INT(9))
        );

        CodeInstruction value4 = Factories.tryStatement(
                CodeSource.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        CodeSource.fromVarArgs(Literals.STRING("Hello"))
                )),
                CodeSource.fromVarArgs(Commons.invokeValueOf(Types.INTEGER_WRAPPER, Literals.INT(9)))
        );

        CodeInstruction value5 = Factories.tryStatement(
                CodeSource.fromVarArgs(Literals.STRING("Hello")),
                Collections3.listOf(Factories.catchStatement(
                        IllegalArgumentException.class,
                        VariableFactory.variable(IllegalArgumentException.class, "ex"),
                        CodeSource.fromVarArgs(Literals.STRING("Hello"))
                )),
                CodeSource.empty()
        );

        Assert.assertEquals(CodeTypes.getCodeType(String.class), CodePartKt.getType(value));
        Assert.assertEquals(CodeTypes.getCodeType(String.class), CodePartKt.getType(value2));
        Assert.assertEquals(null, CodePartKt.getTypeOrNull(value3));
        Assert.assertEquals(Types.OBJECT, CodePartKt.getTypeOrNull(value4));
        Assert.assertEquals(null, CodePartKt.getTypeOrNull(value5));

    }


}
