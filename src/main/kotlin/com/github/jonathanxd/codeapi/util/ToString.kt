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
@file:JvmName("ToString")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.base.BodyHolder
import java.lang.reflect.Modifier
import java.util.*


/**
 * Create a String representation of the part of this [CodePart]
 *
 * This method take care of StackOverFlow.
 *
 * `@top` means top declaration
 */
fun Any?.asString(): String = toString(mutableListOf(), this)

private fun toString(parts: MutableList<CodePart>, part: Any?): String =
        part.let {
            if (it == null)
                "null"
            else
                it.javaClass.simpleName + StringJoiner(", ", "[", "]").let { buffer ->
                    toString(parts, it, { a -> buffer.add(a) })
                    buffer.toString()
                }
        }


private fun toString(parts: MutableList<CodePart>, part: Any, buffer: (String) -> Unit) {

    if (part !is CodePart) {
        buffer(part.toString())
        return
    }

    val fields = (part.javaClass.fields + part.javaClass.declaredFields).distinct()

    parts.add(part)

    val access: List<Pair<String, Any?>> = fields.filter { !Modifier.isStatic(it.modifiers) }.map {
        it.isAccessible = true
        it.name to it[part]
    }.let {
        if (it.isEmpty()) {
            part.javaClass.methods.filter {
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

        if (value is Iterable<*>) {
            if (value is CodePart)
                parts.add(value)

            value.forEach { vall ->
                buffer("$name = ${toString(parts, vall)}")
            }
        } else {

            if (parts.contains(value)) {
                buffer("$name = @out")
            } else {
                if (value == null) {
                    buffer("$name = null")
                } else {
                    if (value is CodePart) {
                        parts.add(value)
                        val str = try {
                            value.toString()
                        } catch (e: Error) {
                            toString(parts, value)
                        }

                        buffer("$name = $str")
                    } else {
                        buffer("$name = $value")
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
