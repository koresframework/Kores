/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi

import com.github.jonathanxd.codeapi.base.*
import com.github.jonathanxd.codeapi.inspect.SourceInspect
import com.github.jonathanxd.codeapi.type.`is`
import com.github.jonathanxd.codeapi.type.getCommonSuperType
import com.github.jonathanxd.iutils.container.primitivecontainers.BooleanContainer
import java.lang.reflect.Type
import java.util.*
import java.util.function.Consumer
import java.util.stream.Stream

/**
 * Abstract [CodeInstruction] iterable.
 *
 * @see ArrayCodeSource
 * @see MutableCodeSource
 */
abstract class CodeSource : Iterable<CodeInstruction>, CodePart {

    /**
     * Size of source.
     */
    abstract val size: Int

    /**
     * True if is empty, false otherwise.
     */
    val isEmpty: Boolean get() = this.size == 0

    /**
     * True if is not empty, false otherwise.
     */
    val isNotEmpty: Boolean get() = !this.isEmpty

    /**
     * Gets element at index [index].
     *
     * @throws IndexOutOfBoundsException If the [index] is either negative or greater than [size].
     */
    operator fun get(index: Int): CodeInstruction {
        if (index < 0 || index >= this.size)
            throw IndexOutOfBoundsException("Index: $index. Size: $size")

        return this.getAtIndex(index)
    }

    /**
     * Gets element at index [index]. This method should only be called if the index
     * is in the bounds.
     */
    protected abstract fun getAtIndex(index: Int): CodeInstruction

    /**
     * Returns true if this [CodeSource] contains [o].
     */
    abstract operator fun contains(o: Any): Boolean

    /**
     * Returns true if this [CodeSource] contains all elements of [c].
     */
    open fun containsAll(c: Collection<*>): Boolean {
        return c.all { this.contains(it) }
    }

    /**
     * Adds [other] to this [CodeSource].
     */
    abstract operator fun plus(other: CodeInstruction): CodeSource

    /**
     * Removes [other] from this [CodeSource].
     */
    abstract operator fun minus(other: CodeInstruction): CodeSource

    /**
     * Adds all [CodeInstruction] of [other] to this [CodeSource]
     */
    abstract operator fun plus(other: Iterable<CodeInstruction>): CodeSource

    /**
     * Removes all [CodeInstruction] of [other] from this [CodeSource]
     */
    abstract operator fun minus(other: Iterable<CodeInstruction>): CodeSource

    /**
     * Returns the index of [o] in this [CodeSource].
     */
    abstract fun indexOf(o: Any): Int

    /**
     * Returns the last index of [o] in this [CodeSource].
     */
    abstract fun lastIndexOf(o: Any): Int

    /**
     * For each all elements of this [CodeSource].
     */
    abstract override fun forEach(action: Consumer<in CodeInstruction>)

    /**
     * Creates an array of [CodeInstruction] of all elements of this [CodeSource].
     */
    abstract fun toArray(): Array<CodeInstruction>

    /**
     * Creates a [Spliterator] from elements of this [CodeSource].
     */
    abstract override fun spliterator(): Spliterator<CodeInstruction>

    /**
     * Creates an [Iterator] that iterates elements of this [CodeSource].
     */
    abstract override fun iterator(): Iterator<CodeInstruction>

    /**
     * Creates a view of this [CodeSource] from index [fromIndex] to index [toIndex],
     * changes to this [CodeSource] is reflected in current [CodeSource].
     */
    abstract fun subSource(fromIndex: Int, toIndex: Int): CodeSource

    /**
     * Creates a immutable [CodeSource] with elements of this [CodeSource].
     */
    open fun toImmutable(): CodeSource = ArrayCodeSource(this.toArray())

    /**
     * Creates a mutable [CodeSource] with elements of this [CodeSource].
     */
    open fun toMutable(): MutableCodeSource = ListCodeSource(this)

    /**
     * Creates a [ListIterator] that iterates this [CodeSource].
     */
    abstract fun listIterator(): ListIterator<CodeInstruction>

    /**
     * Creates a [ListIterator] that iterates this [CodeSource] and starts at [index].
     */
    abstract fun listIterator(index: Int): ListIterator<CodeInstruction>

    /**
     * Creates a [Stream] of this [CodeSource].
     */
    abstract fun stream(): Stream<CodeInstruction>

    /**
     * Creates a parallel [Stream] of this [CodeSource] (which may or may not be parallel).
     */
    abstract fun parallelStream(): Stream<CodeInstruction>

    override fun toString(): String = if (this.isEmpty) "CodeSource[]" else "CodeSource[...]"

    /**
     * Factory methods to create immutable [CodeSource].
     */
    companion object {
        private val EMPTY = emptyArray<CodeInstruction>()
        private val EMPTY_CODE_SOURCE = ArrayCodeSource(EMPTY)

        /**
         * Returns a empty immutable [CodeSource].
         */
        @JvmStatic
        fun empty(): CodeSource {
            return CodeSource.EMPTY_CODE_SOURCE
        }

        /**
         * Creates a immutable [CodeSource] with all elements of [parts].
         */
        @JvmStatic
        fun fromArray(parts: Array<CodeInstruction>): CodeSource {
            return ArrayCodeSource(parts.clone())
        }

        /**
         * Creates a immutable [CodeSource] with a single [part].
         */
        @JvmStatic
        fun fromPart(part: CodeInstruction): CodeSource {
            return ArrayCodeSource(arrayOf(part))
        }

        /**
         * Creates a immutable [CodeSource] with all elements of vararg [parts].
         */
        @JvmStatic
        fun fromVarArgs(vararg parts: CodeInstruction): CodeSource {
            return ArrayCodeSource(Array(parts.size, { parts[it] }))
        }

        /**
         * Creates a immutable [CodeSource] from elements of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromIterable(iterable: Iterable<CodeInstruction>): CodeSource {
            if (iterable is Collection<CodeInstruction>)
                return ArrayCodeSource(iterable.toTypedArray())

            return ArrayCodeSource(iterable.toList().toTypedArray())
        }

        /**
         * Creates a immutable [CodeSource] from elements of generic [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromGenericIterable(iterable: Iterable<*>): CodeSource {
            if (iterable is Collection<*>)
                return ArrayCodeSource((iterable as Collection<CodeInstruction>).toTypedArray())

            return ArrayCodeSource((iterable as Iterable<CodeInstruction>).toList().toTypedArray())
        }

        /**
         * Creates a immutable [CodeSource] with all elements of [CodeSources][CodeSource] of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromCodeSourceIterable(iterable: Iterable<CodeSource>): CodeSource {
            return ArrayCodeSource(iterable.flatMap { it }.toTypedArray())
        }

    }
}

/**
 * Insert element `toInsert` in `source` after element determined by `predicate` or at end of source if not found.
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @return `source`
 */
fun CodeSource.insertAfterOrEnd(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = this.insertAfter({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            return@insertAfter true
        }

        false
    }, toInsert)

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
 * @return `source`
 */
fun CodeSource.insertBeforeOrEnd(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = this.insertBefore({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            true
        } else false
    }, toInsert)

    if (!any.get()) {
        result.addAll(toInsert)
    }

    return result
}

/**
 * Insert element `toInsert` in `source` after element determined by `predicate` or at start of source if not found.
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @return `source`
 */
fun CodeSource.insertAfterOrStart(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = this.insertAfter({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            return@insertAfter true
        }

        false
    }, toInsert)

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
 * @return `source`
 */
fun CodeSource.insertBeforeOrStart(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    val result = this.insertBefore({ codePart ->
        if (predicate(codePart)) {
            any.toTrue()
            true
        } else false
    }, toInsert)

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
 * @return `source`
 */
fun CodeSource.insertAfter(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    return this.visit({ part, location, codeParts ->
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
 * @return `source`
 */
fun CodeSource.insertBefore(
    predicate: (CodeInstruction) -> Boolean,
    toInsert: CodeSource
): MutableCodeSource {

    val any = BooleanContainer.of(false)

    return this.visit({ part, location, codeParts ->
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
 * @param consumer   Consumer
 * @return Result source.
 */
fun CodeSource.visit(consumer: (CodeInstruction, Location, MutableCodeSource) -> Unit): MutableCodeSource {

    val returnSource = ListCodeSource()

    for (codePart in this) {
        consumeIfExists(
            codePart,
            { codePart0 -> consumer(codePart0, Location.BEFORE, returnSource) })
        returnSource.add(codePart)
        consumeIfExists(
            codePart,
            { codePart0 -> consumer(codePart0, Location.AFTER, returnSource) })
    }

    return returnSource

}


private fun consumeIfExists(part: CodeInstruction, sourceConsumer: (CodeInstruction) -> Unit) {
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
 * @param predicate  Predicate.
 * @param function   Mapper.
 * @param U          Mapped return type.
 * @return List of mapped parts.
 */
fun <U> CodeSource.find(
    predicate: (CodeInstruction) -> Boolean,
    function: (CodeInstruction) -> U
): List<U> {
    val list = ArrayList<U>()

    for (codePart in this) {
        if (codePart is CodeSource) {
            list.addAll(this.find(predicate, function))
        } else {
            if (predicate(codePart)) {
                list.add(function(codePart))
            }
        }
    }

    return list
}

/**
 * Tries to determine which type this [CodeSource] leaves on stack or returns,
 * if this `source` leaves two different types (ex, [String] and [List]), the returned type is
 * [Any], if source leaves two different primitive types, or an object type and a primitive, `null` is returned.
 *
 * This function does not check if a value of the returned [Type] will be always leaved in stack because this does
 * not do flow analysis, example of scenario that this function returns a type that may not be leaved:
 *
 * ```
 * if (a) {
 *   "Hello"
 * } else {}
 * ```
 *
 * This function will return [String], but this expression does not leave [String] in stack in all cases.
 */


/**
 * Returns the type that this [CodeSource] leaves on stack.
 *
 * This function analyzes the last instruction of [CodeSource] and infer the type of value leaved on stack.
 *
 * Examples:
 *
 * For
 *
 * ```
 * if (a == 9) {
 *   "x"
 * } else {
 *   "b"
 * }
 * ```
 * This returns [String]
 *
 * For
 *
 * ```
 * if (a == 9) {
 *   "x"
 * } else {
 *   Integer.valueOf(0)
 * }
 * ```
 *
 * This returns [Object]
 *
 * but for:
 *
 * ```
 * if (a == 9) {
 *   "x"
 * } else {
 * }
 * ```
 *
 * This returns `null`.
 */
fun CodeSource.getLeaveType(): Type? {
    return this.lastOrNull()?.safeForComparison?.getLeaveType()
}

/**
 * Returns the type leaved in stack by this [CodeInstruction]
 */
fun CodeInstruction.getLeaveType(): Type? {
    when (this) {
        is MethodInvocation -> {
            if (this.target.safeForComparison is New) {
                return (this.target.safeForComparison as New).localization
            } else {
                val rtype = this.spec.typeSpec.returnType
                if (!rtype.`is`(Types.VOID)) {
                    return rtype
                }
            }
        }
        is Access -> {
            when (this) {
                Access.SUPER -> return Alias.SUPER
                Access.THIS -> return Alias.THIS
            }
        }
        is IfStatement -> {
            val bType = this.body.getLeaveType()
            val eType = this.elseStatement.getLeaveType()

            return if (bType != null && eType != null) {
                if (bType.`is`(eType))
                    bType
                else
                    getCommonSuperType(bType, eType)
            } else {
                null
            }

        }
        is TryStatementBase -> {
            val btype = this.body.getLeaveType()
            val types = this.catchStatements.map { it.body.getLeaveType() }
            val ftype = this.finallyStatement.getLeaveType()

            return if (btype != null && ftype != null && types.isNotEmpty() && types.all { it != null }) {
                if (ftype.`is`(btype) && types.filterNotNull().all { it.`is`(btype) }) {
                    btype
                } else {
                    types.filterNotNull().fold(getCommonSuperType(ftype, btype)) { a, b ->
                        if (a == null) null
                        else getCommonSuperType(a, b)
                    }
                }
            } else {
                null
            }
        }
        is SwitchStatement -> {
            val types = this.cases.map { it.body.getLeaveType() }

            return if (types.isNotEmpty() && types.all { it != null }) {
                types.reduce { acc, type ->
                    if (acc == null || type == null) null
                    else getCommonSuperType(acc, type)
                }
            } else {
                null
            }
        }
        is LocalCode -> return null
        is BodyHolder -> return this.body.getLeaveType()
        is Typed -> return this.type
    }

    return null
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
