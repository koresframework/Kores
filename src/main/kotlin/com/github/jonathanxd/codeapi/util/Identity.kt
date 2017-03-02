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
@file:JvmName("Identity")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.GenericType
import com.github.jonathanxd.codeapi.type.LoadedCodeType
import java.util.*

/**
 * Default equals algorithm for [GenericType]
 */
fun GenericType.eq(other: Any?): Boolean {

    if (other is GenericType) {

        return this.isWildcard == other.isWildcard
                && this.isType == other.isType
                && this.name == other.name
                && Arrays.deepEquals(this.bounds, other.bounds)

    } else if (other is CodeType) {
        return this.isType && this.bounds.isEmpty() && this.identification == other.identification
    } else {
        return false
    }
}

/**
 * Default hashCode algorithm for [GenericType]
 */
fun GenericType.hash(): Int {

    if (this.isType && this.bounds.isEmpty())
        return (this as CodeType).hash()

    var result = Objects.hash(this.name, this.isType, this.isWildcard)

    result = 31 * result + Arrays.deepHashCode(this.bounds)

    return result
}

/**
 * Default to string conversion for [GenericType].
 *
 * This method convert [GenericType] to a Java Source representation of the [GenericType],
 * see the algorithm of translation [here][GenericTypeUtil.toSourceString].
 */
fun GenericType.toStr(): String {
    return GenericTypeUtil.toSourceString(this)
}

/**
 *
 * Creates string representation of components of [GenericType].
 *
 * **This method is not recommended for object comparison.**
 */
fun GenericType.toComponentString(): String {
    return ToStringBuilder.builder(this::class.java)
            .add("name", this.name)
            .add("isWildcard", this.isWildcard)
            .add(if (this.isType) "codeType" else "inferredType", this.codeType)
            .add("isType", this.isWildcard)
            .add("bounds", this.bounds.map { it.toComponentString() })
            .toString()
}

/**
 * Creates a string representation of components of [GenericType.Bound].
 *
 * **This method is not recommended for object comparison.**
 */
fun GenericType.Bound.toComponentString(): String {
    return ToStringBuilder.builder(this::class.java)
            .add("sign", this.sign)
            .add("type", this.type)
            .toString()
}

/**
 * Default hash algorithm.
 *
 * @return Hash code.
 */
fun CodeType.hash(): Int {
    return this.identification.hashCode()
}

/**
 * Default equals method.
 *
 * @param obj      Object to test.
 * @return True if this [CodeType] is equals to another [CodeType].
 */
fun CodeType.eq(obj: Any?): Boolean = obj is CodeType && this.`is`(obj)

/**
 * Default to string conversion for [CodeType].
 *
 * This methods generates a string with the simple name of current class and the [Type Identification][CodeType.identification].
 */
fun CodeType.toStr(): String = "${this::class.java.simpleName}[${this.identification}]"

/**
 * Default equality check for [LoadedCodeType], this method checks if the loaded types are equal.
 */
fun <T> LoadedCodeType<T>.eq(obj: Any?) =
        if (obj == null)
            false
        else
            if (obj is LoadedCodeType<*>)
                this.loadedType == obj.loadedType
            else
                (this as CodeType).eq(obj)