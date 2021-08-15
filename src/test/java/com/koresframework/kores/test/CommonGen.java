/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.test;

import com.koresframework.kores.Instruction;
import com.koresframework.kores.Instructions;
import com.koresframework.kores.Types;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.KoresTypes;
import com.koresframework.kores.type.LoadedKoresType;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static kotlin.collections.CollectionsKt.listOf;

public class CommonGen {

    public static final String name = CommonGen.class.getCanonicalName() + "_Generated";

    public static TypeDeclaration gen() {
        Instruction[] values = {
                Literals.STRING("A"), Literals.STRING("B"),
                Literals.STRING("C"), Literals.STRING("D"),
                Literals.STRING("E")
        };

        Instruction[] values2 = {
                Literals.STRING("F"), Literals.STRING("G"),
                Literals.STRING("H"), Literals.STRING("I"),
                Literals.STRING("J")
        };

        Instruction[] values3 = {
                Literals.INT(1)
        };

        LoadedKoresType<String[][]> stringArrayType = KoresTypes.getKoresType(String[][].class);

        TypeDeclaration typeDeclaration =
                ClassDeclaration.Builder.builder()
                        .modifiers(KoresModifier.PUBLIC)
                        .name(name)
                        .constructors(
                                ConstructorDeclaration.Builder.builder()
                                        .modifiers(KoresModifier.PUBLIC)
                                        .body(Instructions.fromVarArgs(
                                                VariableFactory.variable(stringArrayType,
                                                        "array",
                                                        Factories.createArray(stringArrayType, listOf(Literals.INT(2), Literals.INT(5)),
                                                                listOf(
                                                                        Factories.createArray(Types.STRING.toArray(1), listOf(Literals.INT(5)), Arrays.asList(values)),
                                                                        Factories.createArray(Types.STRING.toArray(1), listOf(Literals.INT(5)), Arrays.asList(values2))
                                                                )
                                                        )),

                                                VariableFactory.variable(Types.STRING.toArray(1),
                                                        "array2",
                                                        Factories.createArray(Types.STRING.toArray(1), listOf(Literals.INT(0)), Collections.emptyList())
                                                ),

                                                VariableFactory.variable(Types.OBJECT.toArray(1),
                                                        "array3",
                                                        Factories.createArray(Types.OBJECT.toArray(1), listOf(Literals.INT(1)), Arrays.asList(values3))
                                                ),

                                                Predefined.invokePrintln(
                                                        Factories.accessArrayValue(Types.STRING.toArray(1),
                                                                Factories.accessArrayValue(Types.STRING.toArray(2),
                                                                        Factories.accessVariable(
                                                                                Types.STRING.toArray(2),
                                                                                "array"
                                                                        ),
                                                                        Literals.INT(0),
                                                                        Types.STRING.toArray(1)
                                                                ),
                                                                Literals.INT(0),
                                                                Types.STRING))


                                        ))
                                        .build()
                        )
                        .build();

        return typeDeclaration;
    }

    @Test
    public void test() {
        gen();
    }

}
