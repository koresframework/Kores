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
package com.koresframework.kores.test.kt

import com.koresframework.kores.Types
import com.koresframework.kores.base.ClassDeclaration
import com.koresframework.kores.base.KoresModifier
import com.koresframework.kores.base.ConstructorDeclaration
import com.koresframework.kores.base.TypeDeclaration
import com.koresframework.kores.factory.source
import com.koresframework.kores.factory.variable
import com.koresframework.kores.literal.*
import com.koresframework.kores.util.conversion.toLiteral
import org.junit.Test

class LiteralTest_ {
    fun `$`(): TypeDeclaration {

        return ClassDeclaration.Builder.builder()
                .modifiers(KoresModifier.PUBLIC)
                .qualifiedName("test." + LiteralTest_::class.java.simpleName)
                .constructors(ConstructorDeclaration.Builder.builder()
                        .modifiers(KoresModifier.PUBLIC)
                        .body(source(
                                variable(Types.BOOLEAN, "bool", falseLiteral()),
                                variable(Types.CHAR, "char", char('c')),
                                variable(Types.BYTE, "byte", byte(0)),
                                variable(Types.SHORT, "short", short(0)),
                                variable(Types.INT, "int", int(0)),
                                variable(Types.FLOAT, "float", float(1.0F)),
                                variable(Types.DOUBLE, "double", double(0.0009)),
                                variable(Types.LONG, "long", long(10000000000L)),
                                variable(Types.CLASS, "class", type(String::class.java)),
                                variable(Types.STRING, "string", string("Hello")),
                                variable(Types.STRING, "string2", "Hello".toLiteral())
                        ))
                        .build())
                .build()

    }

    @Test
    fun test() {
        `$`()
    }
}