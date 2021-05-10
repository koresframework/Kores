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
package com.github.jonathanxd.kores.test.other;

import com.github.jonathanxd.iutils.object.Either;
import com.github.jonathanxd.kores.base.TypeDeclaration;
import com.github.jonathanxd.kores.type.KoresTypes;

import org.junit.Assert;
import org.junit.Test;

public class RepresentationTest {
    @Test
    public void conversion() {
        Either<Exception, TypeDeclaration> exceptionTypeDeclarationEither =
                KoresTypes.getKoresType(A.class)
                        .getBindedDefaultResolver()
                        .resolveTypeDeclaration();

        Assert.assertTrue(exceptionTypeDeclarationEither.isRight());

        Either<Exception, TypeDeclaration> resolve2 = exceptionTypeDeclarationEither
                .getRight()
                .getBindedDefaultResolver()
                .resolveTypeDeclaration();
        Assert.assertTrue(resolve2.isRight());


        Assert.assertEquals(KoresTypes.getKoresType(A.class).getJavaSpecName(),
                exceptionTypeDeclarationEither.getRight().getJavaSpecName());

        Assert.assertEquals(KoresTypes.getKoresType(A.class).getJavaSpecName(),
                resolve2.getRight().getJavaSpecName());
    }

    public interface A {

    }
}
