/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.test;

import com.github.jonathanxd.codeapi.CodeSource;
import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.AnonymousClass;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.base.InvokeType;
import com.github.jonathanxd.codeapi.base.MethodDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.factory.Factories;
import com.github.jonathanxd.codeapi.helper.ConcatHelper;
import com.github.jonathanxd.codeapi.helper.Predefined;
import com.github.jonathanxd.codeapi.literal.Literals;
import com.github.jonathanxd.codeapi.util.Alias;

import org.junit.Test;

public class AnonymousClassTest_ {
    //


    public static TypeDeclaration $() {
        PredefinedTest predefinedTest = PredefinedTest.create("test.AnonymousClassTest");

        predefinedTest.constructor.withInnerTypes(
                AnonymousClass.Builder.builder()
                        .withOuterClass(predefinedTest.getTypeRef())
                        .withSpecifiedName("AnonymousGreeter")
                        .withSuperClass(Greeter2.class)
                        .withConstructorSpec(Factories.constructorTypeSpec(String.class))
                        .withArguments(Literals.STRING("[AnonymousClass]"))
                        .withConstructorBody(CodeSource.fromPart(Predefined.invokePrintlnStr(Literals.STRING("Created!"))))
                        .withMethods(
                                MethodDeclaration.Builder.builder()
                                        .withModifiers(CodeModifier.PUBLIC)
                                        .withName("greet")
                                        .withReturnType(Types.VOID)
                                        .withBody(CodeSource.fromPart(
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
