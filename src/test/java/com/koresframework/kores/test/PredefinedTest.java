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

import com.koresframework.kores.MutableInstructions;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.ConstructorDeclaration;
import com.koresframework.kores.base.StaticBlock;
import com.koresframework.kores.type.TypeRef;
import com.koresframework.kores.base.ClassDeclaration;
import com.koresframework.kores.base.KoresModifier;
import com.koresframework.kores.base.StaticBlock;
import com.koresframework.kores.type.TypeRef;

/**
 * Predefined test template, a class with a constructor.
 */
public final class PredefinedTest {

    public final ClassDeclaration.Builder classDeclaration;
    public final ConstructorDeclaration.Builder constructor;
    public final StaticBlock.Builder staticBlock;

    private PredefinedTest(ClassDeclaration.Builder classDeclaration, ConstructorDeclaration.Builder constructor, StaticBlock.Builder staticBlock) {
        this.classDeclaration = classDeclaration;
        this.constructor = constructor;
        this.staticBlock = staticBlock;
    }


    public TypeRef getTypeRef() {
        return new TypeRef(classDeclaration.getOuterType(), classDeclaration.getSpecifiedName());
    }

    public static PredefinedTest create(String name) {

        ConstructorDeclaration.Builder constructorDeclaration = ConstructorDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .body(MutableInstructions.create());

        StaticBlock.Builder staticBlock = StaticBlock.Builder.builder()
                .body(MutableInstructions.create());

        ClassDeclaration.Builder classDeclaration = ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName(name);

        return new PredefinedTest(classDeclaration, constructorDeclaration, staticBlock);
    }

    public ClassDeclaration build() {
        return this.classDeclaration
                .staticBlock(this.staticBlock.build())
                .constructors(this.constructor.build())
                .build();
    }

}
