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

import com.koresframework.kores.Instructions;
import com.koresframework.kores.base.Label;
import com.koresframework.kores.base.VariableDeclaration;
import com.koresframework.kores.inspect.InstructionsInspect;

import com.koresframework.kores.inspect.InstructionsInspect;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestInspect {

    @Test
    public void inspect() {
        Instructions source = GenericClass_.$().getMethods().get(0).getBody();

        List<VariableDeclaration> inspect = InstructionsInspect.Companion
                .builder(codePart -> codePart instanceof VariableDeclaration)
                .include(bodied -> bodied instanceof Label)
                .includeRoot(true)
                .mapTo(codePart -> (VariableDeclaration) codePart)
                .inspect(source);

        System.out.println(inspect);

        Assert.assertTrue(inspect.size() == 3);
        Assert.assertEquals("fieldi", inspect.get(0).getName());
    }

}
