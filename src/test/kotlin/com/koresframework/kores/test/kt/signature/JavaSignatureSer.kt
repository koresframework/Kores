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
package com.koresframework.kores.test.kt.signature

import com.koresframework.kores.Instruction
import com.koresframework.kores.KoresElement
import com.koresframework.kores.type.Generic
import com.koresframework.kores.type.koresType
import com.koresframework.kores.type.typeOf
import com.koresframework.kores.type.typesOf2
import com.koresframework.kores.util.*
import org.junit.Assert
import org.junit.Test

class JavaSignatureSer {

    fun `$`() {

    }

    @Test
    fun `serialize intersection 'E extends Instruction & KoresElement'`() {
        val type = Generic.type("E").`extends$`(*typesOf2<Instruction, KoresElement>())
        Assert.assertEquals("E extends com.koresframework.kores.Instruction & com.koresframework.kores.KoresElement", type.toSourceString())
    }

    @Test
    fun `deserialize intersection 'E extends Instruction & KoresElement'`() {
        val type = genericSignatureFromSourceString("<E extends com.koresframework.kores.Instruction & com.koresframework.kores.KoresElement>") {
            resolveClass<Any>(it).koresType
        }.types.single()
        val expected = Generic.type("E").`extends$`(*typesOf2<Instruction, KoresElement>())

        Assert.assertEquals(expected, type)
    }

    @Test
    fun `deserialize intersection 'E extends List of Instruction & KoresElement'`() {
        val type = genericSignatureFromSourceString("<E extends java.util.List<? extends com.koresframework.kores.Instruction & com.koresframework.kores.KoresElement>>") {
            resolveClass<Any>(it).koresType
        }.types.single()
        val expected = Generic.type("E").`extends$`(
            Generic.type(typeOf<List<*>>()).`extends$`(
                Generic.wildcard().`extends$`(*typesOf2<Instruction, KoresElement>())
            )
        )

        Assert.assertEquals(expected, type)
    }

}