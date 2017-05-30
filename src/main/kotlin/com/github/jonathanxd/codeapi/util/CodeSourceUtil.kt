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
@file:JvmName("CodeSourceUtil")
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.ListCodeSource
import com.github.jonathanxd.codeapi.MutableCodeSource
import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.inspect.SourceInspect
import com.github.jonathanxd.iutils.container.primitivecontainers.BooleanContainer
import java.util.ArrayList

/**
 * Insert element `toInsert` in `source` after element determined by `predicate` or at end of source if not found.
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertAfterOrEnd(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = insertAfter({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            return@insertAfter true
        }

        false
    }, toInsert, source)

    if (!any.get()) {
        result.addAll(toInsert)
    }

    return result
}

/**
 * Insert element `toInsert` in `source` before element determined by `predicate` or at end of source if not found.
 *
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertBeforeOrEnd(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = insertBefore({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            true
        } else false
    }, toInsert, source)

    if (!any.get()) {
        result.addAll(toInsert)
    }

    return result
}

/**
 * Insert element `toInsert` in `source` after element determined by `predicate` or at start of source if not found.
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertAfterOrStart(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = insertAfter({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            return@insertAfter true
        }

        false
    }, toInsert, source)

    if (!any.get()) {
        result.addAll(0, toInsert)
    }

    return result
}

/**
 * Insert element `toInsert` in `source` before element determined by `predicate` or at start of source if not found.
 *
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertBeforeOrStart(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = insertBefore({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            true
        } else false
    }, toInsert, source)

    if (!any.get()) {
        result.addAll(0, toInsert)
    }

    return result
}


/**
 * Insert element `toInsert` in `source` after element determined by `predicate`
 *
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertAfter(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    return visit(source, { part, location, codeParts ->
        if (any.get())
            return@visit

        if (location == Location.AFTER) {
            if (predicate(part)) {
                codeParts.addAll(toInsert)
                any.set(true)
            }
        }
    })
}


/**
 * Insert element `toInsert` in `source` before element determined by `predicate`
 *
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert before element determined by `predicate`
 * @param source    Source to find element and insert element `toInsert`
 * @return `source`
 */
fun insertBefore(predicate: (CodePart) -> Boolean, toInsert: CodeSource, source: CodeSource): MutableCodeSource {

    val any = BooleanContainer.of(false)

    return visit(source, { part, location, codeParts ->
        if (any.get())
            return@visit

        if (location == Location.BEFORE) {
            if (predicate(part)) {
                codeParts.addAll(toInsert)
                any.set(true)
            }
        }
    })
}


/**
 * Visit Code Source elements.
 *
 * This method create a new [CodeSource] and add all elements from `codeSource`
 * before and after visits each [CodePart] of `codeSource`.
 *
 * When visiting process finish, it will clear `codeSource` and add all elements from new
 * [CodeSource]
 *
 * @param codeSource Code Source to visit
 * @param consumer   Consumer
 * @return Result source.
 */
fun visit(codeSource: CodeSource, consumer: (CodePart, Location, MutableCodeSource) -> Unit): MutableCodeSource {

    val returnSource = ListCodeSource()

    for (codePart in codeSource) {
        consumeIfExists(codePart, { codePart0 -> consumer(codePart0, Location.BEFORE, returnSource) })
        returnSource.add(codePart)
        consumeIfExists(codePart, { codePart0 -> consumer(codePart0, Location.AFTER, returnSource) })
    }

    return returnSource

}


private fun consumeIfExists(part: CodePart, sourceConsumer: (CodePart) -> Unit) {
    if (part is BodyHolder) {
        for (codePart in part.body) {
            consumeIfExists(codePart, sourceConsumer)
        }
    } else {
        sourceConsumer(part)
    }
}

/**
 * Find an element in a code source. (Highly recommended to use [SourceInspect] instead of this.
 *
 * @param codeSource Code Source.
 * @param predicate  Predicate.
 * @param function   Mapper.
 * @param U          Mapped return type.
 * @return List of mapped parts.
 */
fun <U> find(codeSource: CodeSource, predicate: (CodePart) -> Boolean, function: (CodePart) -> U): List<U> {
    val list = ArrayList<U>()

    for (codePart in codeSource) {
        if (codePart is CodeSource) {
            list.addAll(find(codePart, predicate, function))
        } else {
            if (predicate(codePart)) {
                list.add(function(codePart))
            }
        }
    }

    return list
}

/**
 * Location to insert element.
 */
enum class Location {
    /**
     * Insert before.
     */
    BEFORE,

    /**
     * Insert after.
     */
    AFTER
}
