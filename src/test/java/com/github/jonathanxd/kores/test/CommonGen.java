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

import com.github.jonathanxd.kores.Instruction;
import com.github.jonathanxd.kores.Instructions;
import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresModifier;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.factory.VariableFactory;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.type.LoadedKoresType;
import com.github.jonathanxd.kores.type.KoresTypes;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.github.jonathanxd.kores.literal.Literals.INT;
import static com.github.jonathanxd.kores.literal.Literals.STRING;
import static kotlin.collections.CollectionsKt.listOf;

public class CommonGen {

    public static final String name = CommonGen.class.getCanonicalName() + "_Generated";

    public static TypeDeclaration gen() {
        Instruction[] values = {
                STRING("A"), STRING("B"),
                STRING("C"), STRING("D"),
                STRING("E")
        };

        Instruction[] values2 = {
                STRING("F"), STRING("G"),
                STRING("H"), STRING("I"),
                STRING("J")
        };

        Instruction[] values3 = {
                INT(1)
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
                                                        Factories.createArray(stringArrayType, listOf(INT(2), INT(5)),
                                                                listOf(
                                                                        Factories.createArray(Types.STRING.toArray(1), listOf(INT(5)), Arrays.asList(values)),
                                                                        Factories.createArray(Types.STRING.toArray(1), listOf(INT(5)), Arrays.asList(values2))
                                                                )
                                                        )),

                                                VariableFactory.variable(Types.STRING.toArray(1),
                                                        "array2",
                                                        Factories.createArray(Types.STRING.toArray(1), listOf(INT(0)), Collections.emptyList())
                                                ),

                                                VariableFactory.variable(Types.OBJECT.toArray(1),
                                                        "array3",
                                                        Factories.createArray(Types.OBJECT.toArray(1), listOf(INT(1)), Arrays.asList(values3))
                                                ),

                                                Predefined.invokePrintln(
                                                        Factories.accessArrayValue(Types.STRING.toArray(1),
                                                                Factories.accessArrayValue(Types.STRING.toArray(2),
                                                                        Factories.accessVariable(
                                                                                Types.STRING.toArray(2),
                                                                                "array"
                                                                        ),
                                                                        INT(0),
                                                                        Types.STRING.toArray(1)
                                                                ),
                                                                INT(0),
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
