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

import com.github.jonathanxd.codeapi.CodeAPI;
import com.github.jonathanxd.codeapi.MutableCodeSource;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.common.CodeModifier;
import com.github.jonathanxd.codeapi.common.TypeSpec;
import com.github.jonathanxd.codeapi.factory.ClassFactory;
import com.github.jonathanxd.codeapi.factory.ConstructorFactory;
import com.github.jonathanxd.codeapi.literal.Literals;

import org.junit.Test;

import java.io.PrintStream;
import java.util.EnumSet;

import static com.github.jonathanxd.codeapi.CodeAPI.accessStaticField;
import static com.github.jonathanxd.codeapi.CodeAPI.argument;
import static com.github.jonathanxd.codeapi.CodeAPI.emptyMutableSource;
import static com.github.jonathanxd.codeapi.CodeAPI.sourceOfParts;
import static com.github.jonathanxd.codeapi.Types.STRING;
import static com.github.jonathanxd.codeapi.Types.VOID;
import static java.lang.reflect.Modifier.PUBLIC;
import static kotlin.collections.CollectionsKt.listOf;

/**
 * Created by jonathan on 18/06/16.
 */

public class Readme {

    @Test
    public void readme() {
        MutableCodeSource source = emptyMutableSource();

        ClassDeclaration myClass = ClassFactory.aClass(EnumSet.of(CodeModifier.PUBLIC), "mypackage.MyClass", sourceOfParts(
                ConstructorFactory.constructor(EnumSet.of(CodeModifier.PUBLIC), sourceOfParts(
                        CodeAPI.invokeVirtual(PrintStream.class,
                                accessStaticField(System.class, PrintStream.class, "out"),
                                "println",
                                new TypeSpec(VOID, listOf(STRING)),
                                listOf(argument(Literals.STRING("Hello, world!"))))
                ))
        ));

        source.add(myClass);


        // Only works if Source and bytecode module is present
        /*PlainSourceGenerator plainSourceGenerator = new PlainSourceGenerator();
        BytecodeGenerator bytecodeGenerator = new BytecodeGenerator();

        String plainSource = plainSourceGenerator.gen(source);

        System.out.println(plainSource);

        byte[] bytes = bytecodeGenerator.gen(source)[0].getBytecode();

        BCLoader bytecodeLoader = new BCLoader();

        Class<?> cl = bytecodeLoader.define(myClass, bytes);

        try {
            cl.newInstance();
        } catch (Throwable t) { throw new RuntimeException(t); }*/

    }

    private static final class BCLoader extends ClassLoader {

        public Class<?> define(TypeDeclaration typeDeclaration, byte[] bytes) {
            return super.defineClass(typeDeclaration.getPlatformName(), bytes, 0, bytes.length);
        }
    }

}
