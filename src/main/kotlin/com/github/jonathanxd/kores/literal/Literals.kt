/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.literal

import com.github.jonathanxd.kores.type.KoresType
import com.github.jonathanxd.kores.type.NullType
import com.github.jonathanxd.kores.type.koresType
import java.lang.reflect.Type

/**
 * [Literals][Literal] constants.
 */
object Literals {

    // NullLiteral
    @JvmField
    val NULL: Literal = SimpleLiteral("null", NullType)

    // BooleanLiteral
    @JvmField
    val TRUE: Literal = BoolLiteral(true)

    @JvmField
    val FALSE: Literal = BoolLiteral(false)

    // Numeric Literals

    // ByteLiteral
    @JvmStatic
    fun BYTE(b: Byte): Literal {
        return ByteLiteral(b.toString())
    }

    // ShortLiteral
    @JvmStatic
    fun SHORT(s: Short): Literal {
        return ShortLiteral(s.toString())
    }

    // IntegerLiteral
    @JvmStatic
    fun INT(i: Int): Literal {
        return IntLiteral(i.toString())
    }

    // BooleanLiteral
    @JvmStatic
    fun BOOLEAN(b: Boolean): Literal {
        if (b)
            return TRUE
        else
            return FALSE
    }

    // LongLiteral
    @JvmStatic
    fun LONG(i: Long): Literal {
        return LongLiteral(i.toString())
    }

    // FloatLiteral
    @JvmStatic
    fun FLOAT(f: Float): Literal {
        return FloatLiteral(f.toString())
    }

    // DoubleLiteral
    @JvmStatic
    fun DOUBLE(d: Double): Literal {
        return DoubleLiteral(d.toString())
    }

    // CharLiteral
    @JvmStatic
    fun CHAR(c: Char): Literal {
        return CharLiteral(c.toString())
    }

    // StringLiteral
    @JvmStatic
    fun STRING(s: String): Literal {
        return StringLiteral(s)
    }

    // Class Literal
    @JvmStatic
    fun CLASS(type: Type): Literal {
        return ClassLiteral(type.koresType)
    }

    @JvmStatic
    fun TYPE(type: Type): Literal {
        return ClassLiteral(type.koresType)
    }

    private class SimpleLiteral internal constructor(name: String, dataType: KoresType) :
        Literal(name, name, dataType)

    class ClassLiteral internal constructor(type: KoresType) :
        Literal(type, type.canonicalName, TYPE) {
        companion object {
            private val TYPE = KoresType::class.koresType
        }

    }

    class ByteLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {
            private val TYPE = java.lang.Byte.TYPE.koresType
        }

    }

    class ShortLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {
            private val TYPE = java.lang.Short.TYPE.koresType
        }

    }

    class IntLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {
            private val TYPE = java.lang.Integer.TYPE.koresType
        }

    }

    class BoolLiteral internal constructor(value: Boolean) : Literal(value.toString(), TYPE) {
        companion object {

            private val TYPE = java.lang.Boolean.TYPE.koresType
        }

    }

    class LongLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = java.lang.Long.TYPE.koresType
        }

    }


    class FloatLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = java.lang.Float.TYPE.koresType
        }

    }

    class DoubleLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = java.lang.Double.TYPE.koresType
        }

    }

    class CharLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = java.lang.Character.TYPE.koresType
        }

    }

    class StringLiteral internal constructor(val original: String) :
        Literal('"' + original + '"', TYPE) {
        companion object {

            private val TYPE = String::class.koresType
        }
    }
}

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
