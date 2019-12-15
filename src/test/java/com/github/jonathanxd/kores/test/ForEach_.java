/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.kores.Types;
import com.github.jonathanxd.kores.base.ClassDeclaration;
import com.github.jonathanxd.kores.base.KoresParameter;
import com.github.jonathanxd.kores.base.ConstructorDeclaration;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.factory.Factories;
import com.github.jonathanxd.kores.factory.VariableFactory;
import com.github.jonathanxd.kores.helper.Predefined;
import com.github.jonathanxd.kores.type.Generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class ForEach_ {


    public static TypeDeclaration $() {

        Assert.assertEquals(Generic.type(Types.LIST).of(Types.STRING).hashCode(), Generic.type(Types.LIST).of(Types.STRING).hashCode());
        Assert.assertEquals(Generic.type(Types.LIST).of(Types.STRING), Generic.type(Types.LIST).of(Types.STRING));

        return ClassDeclaration.Builder.builder()
                .specifiedName("com.ForEach")
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .parameters(new KoresParameter(Collections.emptyList(), Collections.emptySet(), Generic.type(Types.LIST).of(Types.STRING), "strList"))
                                .body(Instructions.fromVarArgs(
                                        Factories.forEachIterable(VariableFactory.variable(Types.STRING, "str"),
                                                Factories.accessVariable(
                                                        Generic.type(Types.LIST).of(Types.STRING),
                                                        "strList"),
                                                Instructions.fromVarArgs(
                                                        Predefined.invokePrintln(Factories.accessVariable(String.class, "str"))
                                                ))
                                )).build()
                ).build();
    }

    @Test
    public void test() {
        $();
    }


}
