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
package com.github.jonathanxd.codeapi.test.other;

import com.github.jonathanxd.codeapi.Types;
import com.github.jonathanxd.codeapi.base.ClassDeclaration;
import com.github.jonathanxd.codeapi.base.TypeDeclaration;
import com.github.jonathanxd.codeapi.base.CodeModifier;
import com.github.jonathanxd.codeapi.type.CodeTypeResolver;
import com.github.jonathanxd.codeapi.util.CodeTypes;

import org.junit.Assert;
import org.junit.Test;

public class TypeResolverTest {

    @Test
    public void typeResolverTest() {
        TypeDeclaration basex = ClassDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withQualifiedName("com.BaseX")
                .withSuperClass(Types.OBJECT)
                .withImplementations(CodeTypes.getCodeType(BaseExt.class))
                .build();

        TypeDeclaration typeDeclaration = ClassDeclaration.Builder.Companion.builder()
                .withModifiers(CodeModifier.PUBLIC)
                .withQualifiedName("com.TypeResolverTest")
                .withSuperClass(basex)
                .build();


        CodeTypeResolver<?> defaultResolver = typeDeclaration.getDefaultResolver();

        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(Base.class), typeDeclaration));
        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(BaseExt.class), typeDeclaration));
        Assert.assertTrue(defaultResolver.isAssignableFrom(CodeTypes.getCodeType(Base.class), CodeTypes.getCodeType(BaseExt.class)));
        Assert.assertTrue(defaultResolver.isAssignableFrom(basex, typeDeclaration));
    }

    interface Base {

    }

    interface BaseExt extends Base {

    }
}
