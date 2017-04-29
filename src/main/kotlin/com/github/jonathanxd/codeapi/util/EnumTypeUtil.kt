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

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.EnumDeclaration
import com.github.jonathanxd.codeapi.base.EnumValue
import com.github.jonathanxd.codeapi.base.SwitchStatement
import com.github.jonathanxd.codeapi.literal.Literal
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.LoadedCodeType

/**
 * Enum type utility
 */
object EnumTypeUtil {

    /**
     * Try to resolve int value of part [p]. If is a numeric literal, returns the numeric value of
     * the literal, if is a string literal, returns the hashcode of the string, if is a [EnumValue], tries
     * to resolve the ordinal value.
     */
    fun resolve(p: CodePart, aSwitch: Lazy<SwitchStatement>): Int {


        if (p is Literal) {
            val l = p

            if (p is Literals.CharLiteral)
                return l.name[0].toInt()

            if (p is Literals.ByteLiteral || p is Literals.ShortLiteral || p is Literals.IntLiteral)
                return Integer.parseInt(l.name)

        }

        if (p is Literals.StringLiteral) {
            return p.original.hashCode()
        }

        try {
            if (p is EnumValue) {
                val enumValue = p
                val ordinal = enumValue.ordinal

                if (ordinal > -1) {
                    return ordinal
                }

                val name = enumValue.name

                val type = aSwitch.value.type.codeType

                if (type is LoadedCodeType<*>)
                    type.loadedType.enumConstants.forEachIndexed { index, it ->
                        if(it == name)
                            return@resolve index
                    }
                else if(type is EnumDeclaration)
                    type.entries.forEachIndexed { index, it ->
                        if(it.name == name)
                            return@resolve index
                    }

            }
        } catch (e: Exception) {
            throw RuntimeException("Cannot resolve enum ordinal value, please use CodeAPI.enumValue(NAME, ORDINAL) to switch enum values that isn't available at runtime!", e)
        }


        throw RuntimeException("Cannot resolve the numeric value of '$p', a new SwitchType must be implemented to resolve this!")
    }
}
