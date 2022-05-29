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
import com.koresframework.kores.Types;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.KoresParameter;
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.MethodDeclaration;
import com.koresframework.kores.base.TypeDeclaration;
import com.koresframework.kores.factory.VariableFactory;
import com.koresframework.kores.generic.GenericSignature;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.Generic;
import com.koresframework.kores.type.KoresTypes;

import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.FieldDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.generic.GenericSignature;
import com.koresframework.kores.literal.Literals;
import com.koresframework.kores.type.Generic;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class GenericClass_ {


    public static TypeDeclaration $() {

        return ClassDeclaration.Builder.builder()
                .specifiedName("com.Generic")
                .genericSignature(GenericSignature.create(Generic.type("T").extends$(
                        Generic.type(KoresTypes.getKoresType(List.class)).of("T")
                )))
                .implementations(Generic.type(KoresTypes.getKoresType(List.class)).of("T"))
                .fields(FieldDeclaration.Builder.builder()
                        .type(Generic.type("T"))
                        .name("test")
                        .build())

                .methods(
                        MethodDeclaration.Builder.builder()
                                .modifiers(KoresModifier.PUBLIC, KoresModifier.STATIC)
                                .genericSignature(GenericSignature.create(Generic.type("T").extends$(
                                        Generic.type(Types.LIST).of("T")
                                )))
                                .name("test")
                                .parameters(new KoresParameter(Collections.emptyList(), Collections.emptySet(), Generic.type("T"), "val"))
                                .body(Instructions.fromVarArgs(
                                        VariableFactory.variable(Generic.type("T"), "fieldi", Literals.NULL),
                                        VariableFactory.variable(Generic.type(Object.class), "field2", Literals.NULL),
                                        VariableFactory.variable(Generic.type(List.class).of(Generic.type(String.class)),
                                                "field3",
                                                Literals.NULL)
                                ))
                                .build()

                ).build();
    }

    @Test
    public void test() {
        $();
    }


}
