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
package com.github.jonathanxd.codeapi.literal

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.NullType

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

    @JvmStatic
    fun isPrimitive(codePart1: CodePart, codePart2: CodePart): Boolean {
        return codePart1 is Literal && codePart2 is Literal && isPrimitive(codePart1, codePart2)
    }

    /**
     * Return true if [literal1] and [literal2] is primitive.
     *
     * @param literal1 Literal 1.
     * @param literal2 Literal 2.
     * @return True if [literal1] and [literal2] is primitive.
     */
    @JvmStatic
    fun isPrimitive(literal1: Literal, literal2: Literal): Boolean {
        return (literal1 is IntLiteral
                || literal1 is FloatLiteral
                || literal1 is DoubleLiteral
                || literal1 is CharLiteral
                || literal1 is LongLiteral
                || literal1 is BoolLiteral
                || literal1 is ShortLiteral
                || literal1 is ByteLiteral)
                && (literal2 is IntLiteral
                || literal2 is FloatLiteral
                || literal2 is DoubleLiteral
                || literal2 is CharLiteral
                || literal2 is LongLiteral
                || literal2 is BoolLiteral
                || literal2 is ShortLiteral
                || literal2 is ByteLiteral)
    }

    /**
     * Return true if [literal] is primitive
     *
     * @param literal Literal
     * @return True if [literal] is primitive.
     */
    @JvmStatic
    fun isPrimitive(literal: Literal): Boolean {
        return literal is IntLiteral
                || literal is FloatLiteral
                || literal is DoubleLiteral
                || literal is CharLiteral
                || literal is LongLiteral
                || literal is BoolLiteral
                || literal is ByteLiteral
                || literal is ShortLiteral
    }

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
        return QuotedStringLiteral(s)
    }

    // Array
    @JvmStatic
    fun ARRAY(other: Literal, array: CodeType): Literal {
        return SimpleLiteral(other.name, array)
    }

    // Class Literal
    @JvmStatic
    fun CLASS(aClass: Class<*>): Literal {
        return CLASS(CodeAPI.getJavaType(aClass))
    }

    @JvmStatic
    fun CLASS(aClass: CodeType): Literal {
        return ClassLiteral(aClass)
    }

    @GenerateTo(Literal::class)
    private class SimpleLiteral internal constructor(name: String, dataType: CodeType) : Literal(name, dataType)

    @GenerateTo(Literal::class)
    class ClassLiteral internal constructor(type: CodeType) : Literal(type.canonicalName, TYPE) {
        companion object {
            private val TYPE = CodeAPI.getJavaType(CodeType::class.java)
        }

    }

    @GenerateTo(Literal::class)
    class ByteLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {
            private val TYPE = CodeAPI.getJavaType(Integer.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class ShortLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(Integer.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class IntLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {
            private val TYPE = CodeAPI.getJavaType(Integer.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class BoolLiteral internal constructor(val value: Boolean) : Literal(value.toString(), TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(java.lang.Boolean.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class LongLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(java.lang.Long.TYPE)
        }

    }


    @GenerateTo(Literal::class)
    class FloatLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(java.lang.Float.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class DoubleLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(java.lang.Double.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class CharLiteral internal constructor(name: String) : Literal(name, TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(Character.TYPE)
        }

    }

    @GenerateTo(Literal::class)
    class QuotedStringLiteral internal constructor(val original: String) : Literal('"' + original + '"', TYPE) {
        companion object {

            private val TYPE = CodeAPI.getJavaType(String::class.java)
        }
    }
}