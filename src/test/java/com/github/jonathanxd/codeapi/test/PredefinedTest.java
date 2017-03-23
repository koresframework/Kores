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
import com.github.jonathanxd.codeapi.base.ConstructorDeclaration;
import com.github.jonathanxd.codeapi.base.StaticBlock;
import com.github.jonathanxd.codeapi.common.CodeModifier;

/**
 * Predefined test template, a class with a constructor.
 */
public final class PredefinedTest {

    public final ClassDeclaration classDeclaration;
    public final ConstructorDeclaration constructor;
    public final StaticBlock staticBlock;

    private PredefinedTest(ClassDeclaration classDeclaration, ConstructorDeclaration constructor, StaticBlock staticBlock) {
        this.classDeclaration = classDeclaration;
        this.constructor = constructor;
        this.staticBlock = staticBlock;
    }

    public static PredefinedTest create(String name) {

        ConstructorDeclaration constructorDeclaration = ConstructorDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withBody(new MutableCodeSource())
                .build();

        StaticBlock staticBlock = StaticBlock.Builder.Companion.builder()
                .withBody(new MutableCodeSource())
                .build();

        ClassDeclaration classDeclaration = ClassDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withQualifiedName(name)
                .withBody(CodeAPI.source(constructorDeclaration, staticBlock).toMutable())
                .build();

        return new PredefinedTest(classDeclaration, constructorDeclaration, staticBlock);
    }

}
