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
package com.koresframework.kores.literal

import com.koresframework.kores.common.DynamicConstantSpec
import com.koresframework.kores.serialization.KoresTypeSerializer
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type.KoresType
import com.koresframework.kores.type.NullType
import com.koresframework.kores.type.koresType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * [Literals][Literal] constants.
 */
object Literals {

    // NullLiteral
    @JvmField
    val NULL: Literal = NullLiteral

    // BooleanLiteral
    @JvmField
    val TRUE: Literal = BoolLiteral(true)

    @JvmField
    val FALSE: Literal = BoolLiteral(false)

    // Numeric Literals

    // ByteLiteral
    @JvmStatic
    fun BYTE(b: Byte): Literal {
        return ByteLiteral(b)
    }

    // ShortLiteral
    @JvmStatic
    fun SHORT(s: Short): Literal {
        return ShortLiteral(s)
    }

    // IntegerLiteral
    @JvmStatic
    fun INT(i: Int): Literal {
        return IntLiteral(i)
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
        return LongLiteral(i)
    }

    // FloatLiteral
    @JvmStatic
    fun FLOAT(f: Float): Literal {
        return FloatLiteral(f)
    }

    // DoubleLiteral
    @JvmStatic
    fun DOUBLE(d: Double): Literal {
        return DoubleLiteral(d)
    }

    // CharLiteral
    @JvmStatic
    fun CHAR(c: Char): Literal {
        return CharLiteral(c)
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

    @JvmStatic
    fun DYNAMIC_CONSTANT(spec: DynamicConstantSpec): Literal {
        return DynamicConstantLiteral(spec)
    }

    @Serializable
    object NullLiteral : Literal("null") {
        override val value: Any = "null"
        override val name: String = "null"
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = NullType
    }

    @Serializable
    class ClassLiteral internal constructor(@Serializable(with = KoresTypeSerializer::class) val koresType: KoresType) : Literal(koresType) {

        override val name: String = this.koresType.canonicalName
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = KoresType::class.koresType
        }

    }

    @Serializable
    class ByteLiteral internal constructor(val byte: Byte) : Literal(byte) {
        override val name: String = byte.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Byte.TYPE.koresType
        }

    }

    @Serializable
    class ShortLiteral internal constructor(val short: Short) : Literal(short) {
        override val name: String = short.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Short.TYPE.koresType
        }

    }

    @Serializable
    class IntLiteral internal constructor(val int: Int) : Literal(int) {
        override val name: String = int.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Integer.TYPE.koresType
        }

    }

    @Serializable
    class BoolLiteral internal constructor(val bool: Boolean) : Literal(bool) {
        override val name: String = bool.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Boolean.TYPE.koresType
        }

    }

    @Serializable
    class LongLiteral internal constructor(val long: Long) : Literal(long) {
        override val name: String = this.long.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Long.TYPE.koresType
        }

    }

    @Serializable
    class FloatLiteral internal constructor(val float: Float) : Literal(float) {
        override val name: String = this.float.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Float.TYPE.koresType
        }

    }

    @Serializable
    class DoubleLiteral internal constructor(val double: Double) : Literal(double) {
        override val name: String = this.double.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Double.TYPE.koresType
        }

    }

    @Serializable
    class CharLiteral internal constructor(val char: Char) : Literal(char) {
        override val name: String = char.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = java.lang.Character.TYPE.koresType
        }

    }

    @Serializable
    class StringLiteral internal constructor(val original: String) : Literal('"' + original + '"') {
        override val name: String = this.original
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = TYPE

        companion object {
            private val TYPE = String::class.koresType
        }
    }

    @Serializable
    class DynamicConstantLiteral internal constructor(val spec: DynamicConstantSpec) : Literal(spec) {
        override val name: String = this.spec.toString()
        @SerialName("literalDataType")
        @Serializable(with = TypeSerializer::class)
        override val type: Type = spec.constantType
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

@JvmName("dynamicConstantLiteral")
fun constantLiteral(spec: DynamicConstantSpec): Literal =
    Literals.DYNAMIC_CONSTANT(spec)

fun nullLiteral(): Literal =
    Literals.NULL

fun trueLiteral(): Literal =
    Literals.TRUE

fun falseLiteral(): Literal =
    Literals.FALSE
