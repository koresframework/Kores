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
import java.lang.reflect.Type
import java.util.*

/**
 * Non-strict generic equality check, only works for generic types.
 *
 * This method will not make strict bound checks, it means that `List<?>` is equal to `List`,
 * `List<? extends Person>` is equal to `List<Person>`, but `List<Number>` is not equal to `List<Integer>`.
 */
fun CodeType.nonStrictEq(other: CodeType): Boolean {
    if (this is GenericType)
        return this.nonStrictEq(other)

    if (other is GenericType)
        return other.nonStrictEq(this)

    return this.`is`(other)
}

/**
 * Non-strict generic bound equality check, only works for generic types.
 *
 * This method will not make strict bound checks, it means that `List<?>` is equal to `List`,
 * `List<? extends Person>` is equal to `List<Person>`, but `List<Number>` is not equal to `List<Integer>`.
 */
fun GenericType.nonStrictEq(other: CodeType): Boolean {
    if (other is GenericType) {

        return this.isWildcard == other.isWildcard
                && this.isType == other.isType
                && this.name == other.name
                && this.bounds.nonStrictEq(other.bounds)

    } else if (other is CodeType) {

        if (this.bounds.all { it.type is GenericType && it.type.isWildcard })
            return this.codeType.identification == other.identification

        return this.isType && this.bounds.isEmpty() && this.identification == other.identification
    } else {
        return false
    }

}

/**
 * Non-strict bound comparison.
 */
private fun GenericType.Bound.nonStrictEq(other: GenericType.Bound): Boolean {
    val thisType = this.type
    val otherType = other.type

    val comparator = { it: CodeType, other: CodeType ->
        it is GenericType && it.isWildcard && it.bounds.isNotEmpty() && it.bounds.any { it.type.`is`(other) }
    }

    return comparator(thisType, otherType) || comparator(otherType, thisType) || thisType.`is`(other.type)
}

/**
 * Non-strict array bound comparison.
 */
private fun Array<out GenericType.Bound>.nonStrictEq(others: Array<out GenericType.Bound>): Boolean {

    if (this.size != others.size)
        return false

    this.forEachIndexed { index, bound ->
        if (!bound.nonStrictEq(others[index]))
            return@nonStrictEq false
    }

    return true
}


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

fun Type.`is`(another: Type) = this.codeType.`is`(another.codeType)