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
package com.koresframework.kores.test;

import com.koresframework.kores.Instructions;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.helper.ConcatHelper;
import com.koresframework.kores.helper.Predefined;

import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.helper.ConcatHelper;
import org.junit.Test;

public class ConcatTest_ {


    public static TypeDeclaration $() {


        return ClassDeclaration.Builder.builder()
                .specifiedName("com.ConcatTest")
                .constructors(
                        ConstructorDeclaration.Builder.builder()
                                .parameters(Factories.parameter(String.class, "av"))
                                .body(Instructions.fromVarArgs(
                                        Predefined.invokePrintlnStr(ConcatHelper.builder("Hello")
                                                .concat(" ")
                                                .concat(Factories.accessVariable(String.class, "av"))
                                                .concat(" :D").build()),
                                        Predefined.invokePrintlnStr(ConcatHelper.builder().build()),
                                        Predefined.invokePrintlnStr(ConcatHelper.builder("A").build()),
                                        Predefined.invokePrintlnStr(ConcatHelper.builder("A").concat("B").build())
                                ))
                                .build()
                )
                .build();
    }

    @Test
    public void test() {
        $();
    }

}
