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
package com.koresframework.kores.util

import com.koresframework.kores.KoresPart
import com.koresframework.kores.base.BodyHolder
import java.lang.reflect.Modifier
import java.util.*

@Suppress("NOTHING_TO_INLINE")
inline fun String.containsBefore(str: String, before: String): Boolean {
    val findIndex = this.indexOf(str)
    val beforeIndex = this.indexOf(before)

    if (findIndex == -1)
        return false

    if (beforeIndex == -1)
        return true

    return findIndex < beforeIndex
}

/**
 * Create a String representation of the part of this [KoresPart]
 *
 * This method doesn't throw StackOverFlow.
 *
 * `@top` means top declaration
 */
@JvmOverloads
fun Any?.asString(simple: Boolean = true): String = toString(mutableListOf(), this, simple)

private fun toString(parts: MutableList<KoresPart>, part: Any?, simple: Boolean): String =
    part.let {
        if (it == null)
            "null"
        else
            it::class.java.simpleName + StringJoiner(", ", "[", "]").let { buffer ->
                toString(parts, it, simple, { a -> buffer.add(a) })
                buffer.toString()
            }
    }

private fun toString(
    parts: MutableList<KoresPart>,
    part: Any,
    simple: Boolean,
    buffer: (String) -> Unit
) {

    if (part !is KoresPart) {
        buffer(part.toString())
        return
    }

    val fields = (part::class.java.fields + part::class.java.declaredFields).distinct()

    parts.add(part)

    val access: List<Pair<String, Any?>> = fields.filter { !Modifier.isStatic(it.modifiers) }.map {
        it.isAccessible = true
        it.name to it[part]
    }.let {
            if (it.isEmpty()) {
                part::class.java.methods.filter {
                    !Modifier.isStatic(it.modifiers)
                            && Modifier.isPublic(it.modifiers)
                            && it.name.startsWith("get")
                            && it.parameterCount == 0
                            && it.returnType != Void.TYPE
                }.map {
                        //it.isAccessible = true
                        it.name.substring(3).decapitalize() to it.invoke(part)
                    }
            } else it
        }

    access.forEach {
        val name = it.first
        val value = it.second

        if (simple) {
            buffer("$name = $value")
        } else {
            if (value is Iterable<*>) {
                if (value is KoresPart)
                    parts.add(value)

                value.forEach { vall ->
                    buffer("$name = ${toString(parts, vall, simple)}")
                }
            } else {

                if (parts.contains(value)) {
                    buffer("$name = @out")
                } else {
                    if (value == null) {
                        buffer("$name = null")
                    } else {
                        if (value is KoresPart) {
                            parts.add(value)
                            val str = toString(parts, value, simple)

                            buffer("$name = $str")
                        } else {
                            buffer("$name = $value")
                        }
                    }
                }
            }
        }

    }


}


/**
 * Create a String representation of the body of this [BodyHolder]
 *
 * This method take care of StackOverFlow.
 *
 * `@top` means top declaration
 */
fun toString(part: BodyHolder): String = StringJoiner(", ", "[", "]").let {
    toString(null, part, { a -> it.add(a) })
    it.toString()
}

private fun toString(lastHolder: BodyHolder?, part: BodyHolder, buffer: (String) -> Unit) {
    part.body.forEach {
        if (lastHolder != null && part.body.contains(lastHolder) && it == lastHolder) {
            buffer("@top")
        } else {
            if (it is BodyHolder) {
                StringJoiner(", ", "[", "]").let { joiner ->
                    toString(part, it, { a -> joiner.add(a) })
                    buffer(joiner.toString())
                }
            } else {
                buffer(it.toString())
            }
        }

    }
}
