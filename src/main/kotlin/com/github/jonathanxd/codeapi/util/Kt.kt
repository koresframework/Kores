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
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.literal.Literal
import com.github.jonathanxd.codeapi.literal.Literals
import java.lang.reflect.Type

@JvmName("booleanLiteral")
fun boolean(boolean: Boolean): Literal =
        Literals.BOOLEAN(boolean)

@JvmName("charLiteral")
fun char(char: Char): Literal =
        Literals.CHAR(char)

@JvmName("byteLiteral")
fun byte(byte: Byte): Literal =
        Literals.BYTE(byte)

@JvmName("shortLiteral")
fun short(short: Short): Literal =
        Literals.SHORT(short)

@JvmName("intLiteral")
fun int(int: Int): Literal =
        Literals.INT(int)

@JvmName("floatLiteral")
fun float(float: Float): Literal =
        Literals.FLOAT(float)

@JvmName("doubleLiteral")
fun double(double: Double): Literal =
        Literals.DOUBLE(double)

@JvmName("longLiteral")
fun long(long: Long): Literal =
        Literals.LONG(long)

@JvmName("stringLiteral")
fun string(str: String): Literal =
        Literals.STRING(str)

@JvmName("typeLiteral")
fun type(type: Type): Literal =
        Literals.TYPE(type)

fun nullLiteral(): Literal =
        Literals.NULL

fun trueLiteral(): Literal =
        Literals.TRUE

fun falseLiteral(): Literal =
        Literals.FALSE
