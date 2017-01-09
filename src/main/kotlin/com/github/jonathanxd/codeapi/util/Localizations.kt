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
@file:JvmName("Localizations")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.type.CodeType


sealed class Alias {
    /**
     * Current class localization.
     *
     * **Must be manually handled.**
     */
    object THIS : Alias(), CodeType by CodeAPI.getJavaType(THIS::class.java) {
        override fun hashCode(): Int = super.hashCode()
        override fun equals(other: Any?): Boolean = other == THIS
    }

    /**
     * Super class localization
     *
     * **Must be manually handled.**
     */
    object SUPER : Alias(), CodeType by CodeAPI.getJavaType(SUPER::class.java) {
        override fun hashCode(): Int = super.hashCode()
        override fun equals(other: Any?): Boolean = other == THIS
    }

    /**
     * Interface extension localization.
     *
     * **Must be manually handled.**
     *
     * @param n Index of implementation interfaces
     */
    data class INTERFACE(val n: Int) : Alias(), CodeType by CodeAPI.getJavaType(INTERFACE::class.java) {
        override val type: String = "${INTERFACE::class.java.canonicalName}($n)"
        override val canonicalName: String = type

        override fun hashCode(): Int {
            var result = 1

            result = 31 * result + super.hashCode()
            result = 31 * result + n

            return result
        }

        override fun equals(other: Any?): Boolean {
            if (other !is INTERFACE)
                return false

            return this.n == other.n
        }
    }

}