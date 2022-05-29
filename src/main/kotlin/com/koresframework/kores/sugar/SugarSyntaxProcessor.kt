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
package com.koresframework.kores.sugar

import com.koresframework.kores.KoresPart
import com.koresframework.kores.processor.Processor
import com.koresframework.kores.processor.ProcessorManager
import com.github.jonathanxd.iutils.data.TypedData

/**
 * Sugar syntax processor. Kores provides a way to register a sugar syntax processor, a sugar
 * syntax processor transforms a value of type [T] into a [KoresPart].
 */
abstract class SugarSyntaxProcessor<in T> : Processor<T> {

    /**
     * Process [t] and transforms in [KoresPart].
     *
     * This class should only convert [t] to [KoresPart] and should not call [ProcessorManager.process]. This class
     * is intended only for simple conversions, if you need complex conversions you need to write a [Processor].
     */
    abstract fun process(t: T, codeProcessor: ProcessorManager<*>): KoresPart

    override fun process(part: T, data: TypedData, processorManager: ProcessorManager<*>) {
        processorManager.process(this.process(part, processorManager), data)
    }
}
