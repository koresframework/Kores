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
package com.koresframework.kores.test.other.processing;

import com.koresframework.kores.base.VariableDeclaration;
import com.koresframework.kores.processor.Processor;
import com.koresframework.kores.processor.ProcessorManager;
import com.koresframework.kores.type.ImplicitKoresType;
import com.github.jonathanxd.iutils.data.TypedData;
import com.github.jonathanxd.iutils.kt.KeyUtilKt;

import org.jetbrains.annotations.NotNull;

public class VariableDeclarationProcessor implements Processor<VariableDeclaration> {

    @Override
    public void process(VariableDeclaration part, @NotNull TypedData data, @NotNull ProcessorManager<?> processorManager) {
        StringBuilder require = KeyUtilKt.require(MyProcessorManager.APPENDER_KEY, data);

        require.append(ImplicitKoresType.getCanonicalName(part.getVariableType()));
        require.append(' ');
        require.append(part.getName());
        require.append(' ');
        require.append('=');
        require.append(' ');
        processorManager.process(part.getValue(), data);
        require.append(';');
    }

    @Override
    public void endProcess(VariableDeclaration part, @NotNull TypedData data, @NotNull ProcessorManager<?> processorManager) {

    }

}