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

import java.util.HashMap
import java.util.Optional
import java.util.function.Function
import java.util.function.Predicate

/**
 * String helper.
 */
class ToStringBuilder internal constructor(private val type: Class<*>) {
    private val map = HashMap<String, Any>()

    /**
     * Adds [key]=[value]
     */
    fun add(key: String, value: Any): ToStringBuilder {
        this.map.put(key, ToStringBuilder.toString(value))
        return this
    }

    /**
     * Adds [key]=[value.get][value] if [value] is present.
     */
    fun addOptional(key: String, value: Optional<*>): ToStringBuilder {
        if (value.isPresent)
            this.add(key, value.get())

        return this
    }

    /**
     * Adds [key]=[value] if [value] matches [predicate]
     */
    fun <T: Any> addIf(key: String, value: T, predicate: (T) -> Boolean): ToStringBuilder {
        if (predicate(value))
            this.add(key, value)

        return this
    }

    /**
     * Adds [key]=[mapped value][value] (mapped with [mapper]) if [value] matches [predicate]
     */
    fun <T: Any, R: Any> addMapped(key: String, value: T, predicate: (T) -> Boolean, mapper: (T) -> R): ToStringBuilder {
        if (predicate(value))
            this.add(key, mapper(value))

        return this
    }

    override fun toString(): String {
        val s = this.map.toString()
        val str = s.substring(1, s.length - 1)

        return type.simpleName + "[" + str + "]"
    }

    companion object {

        @JvmStatic
        fun builder(type: Class<*>): ToStringBuilder {
            return ToStringBuilder(type)
        }

        @JvmStatic
        fun builderOfObject(type: Any): ToStringBuilder {
            return ToStringBuilder.builder(type.javaClass)
        }

        private fun toString(o: Any?): String {
            if (o == null)
                return "null"

            var oStr = o.toString()

            if (o is Collection<*> || o.javaClass.isArray) {
                oStr = "{" + oStr.substring(1, oStr.length - 1) + "}"
            } else if (o is String) {
                oStr = "\"" + oStr + "\""
            }

            return oStr
        }
    }
}
