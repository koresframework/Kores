/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.test;

import com.github.jonathanxd.kores.Instructions;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.helper.OperateHelper;
import com.github.jonathanxd.kores.helper.Predefined;

import org.junit.Test;

import static com.github.jonathanxd.kores.literal.Literals.INT;

public class OperateTest_ {

    public static TypeDeclaration $() {

        ClassDeclaration codeClass = ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .specifiedName("com.OperateTest")
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC)
                                .parameters(Factories.parameter(int.class, "num"))
                                .body(Instructions.fromVarArgs(
                                        Predefined.invokePrintlnStr(
                                                Predefined.invokeIntToString(
                                                        OperateHelper.builder(INT(9))
                                                                .plus(Factories.accessVariable(int.class, "num"))
                                                                .plus(
                                                                        OperateHelper.builder(Factories.accessVariable(int.class, "num"))
                                                                                .multiply(INT(2))
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                        ),
                                        Predefined.invokePrintlnStr(Predefined.invokeIntToString(
                                                OperateHelper.builder(INT(9))
                                                        .neg()
                                                        .build()
                                        )),
                                        Predefined.invokePrintlnStr(Predefined.invokeIntToString(
                                                OperateHelper.builder(INT(9))
                                                        .not(INT(10))
                                                        .build()
                                        ))

                                )).build()
                ).build();

        return codeClass;
    }

    @Test
    public void test() {
        $();
    }


}
