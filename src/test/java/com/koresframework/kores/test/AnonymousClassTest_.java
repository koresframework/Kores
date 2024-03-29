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
import com.koresframework.kores.base.*;
import com.koresframework.kores.factory.Factories;
import com.koresframework.kores.helper.ConcatHelper;
import com.koresframework.kores.helper.Predefined;
import com.koresframework.kores.literal.Literals;

import com.koresframework.kores.base.Alias;
import com.koresframework.kores.base.AnonymousClass;
import com.koresframework.kores.base.KoresModifier;
import org.junit.Test;

import java.util.List;

public class AnonymousClassTest_ {
    //


    public static TypeDeclaration $() {
        PredefinedTest predefinedTest = PredefinedTest.create("test.AnonymousClassTest");

        predefinedTest.constructor.innerTypes(
                AnonymousClass.Builder.builder()
                        .outerType(predefinedTest.getTypeRef())
                        .specifiedName("AnonymousGreeter")
                        .superClass(Greeter2.class)
                        .mainConstructor(new MainConstructor(
                                ConstructorDeclaration.Builder.builder()
                                        .parameters(Factories.parameter(String.class, "a"))
                                        .body(Instructions.fromPart(Predefined.invokePrintlnStr(Literals.STRING("Created!"))))
                                        .build(),
                                List.of(Literals.STRING("[AnonymousClass]"))
                         ))
                        .methods(
                                MethodDeclaration.Builder.builder()
                                        .modifiers(KoresModifier.PUBLIC)
                                        .name("greet")
                                        .returnType(Types.VOID)
                                        .body(Instructions.fromPart(
                                                Predefined.invokePrintlnStr(
                                                        ConcatHelper.builder(Factories.invokeFieldGetter(InvokeType.INVOKE_VIRTUAL, Alias.THIS.INSTANCE, Factories.accessThis(), Types.STRING, "prefix"))
                                                                .concat(" Hello world")
                                                                .build()
                                                )
                                        ))
                                        .build()
                        )
                        .build()
        );

        return predefinedTest.build();
    }


    @Test
    public void test() {
        $();
    }


    public static abstract class Greeter2 {

        private final String prefix;

        public Greeter2() {
            this(null);
        }

        public Greeter2(String prefix) {
            this.prefix = prefix;
        }

        public abstract void greet();

        public String getPrefix() {
            return this.prefix;
        }
    }
}
