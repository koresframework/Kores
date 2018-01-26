/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores

import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.inspect.InstructionsInspect
import com.github.jonathanxd.kores.type.`is`
import com.github.jonathanxd.kores.type.getCommonSuperType
import com.github.jonathanxd.iutils.container.primitivecontainers.BooleanContainer
import java.lang.reflect.Type
import java.util.*
import java.util.function.Consumer
import java.util.stream.Stream

/**
 * Abstract [Instruction] iterable.
 *
 * @see ArrayInstructions
 * @see MutableInstructions
 */
abstract class Instructions : Iterable<Instruction>, KoresPart {

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
    operator fun get(index: Int): Instruction {
        if (index < 0 || index >= this.size)
            throw IndexOutOfBoundsException("Index: $index. Size: $size")

        return this.getAtIndex(index)
    }

    /**
     * Gets element at index [index]. This method should only be called if the index
     * is in the bounds.
     */
    protected abstract fun getAtIndex(index: Int): Instruction

    /**
     * Returns true if this [Instructions] contains [o].
     */
    abstract operator fun contains(o: Any): Boolean

    /**
     * Returns true if this [Instructions] contains all elements of [c].
     */
    open fun containsAll(c: Collection<*>): Boolean {
        return c.all { this.contains(it) }
    }

    /**
     * Adds [other] to this [Instructions].
     */
    abstract operator fun plus(other: Instruction): Instructions

    /**
     * Removes [other] from this [Instructions].
     */
    abstract operator fun minus(other: Instruction): Instructions

    /**
     * Adds all [Instruction] of [other] to this [Instructions]
     */
    abstract operator fun plus(other: Iterable<Instruction>): Instructions

    /**
     * Removes all [Instruction] of [other] from this [Instructions]
     */
    abstract operator fun minus(other: Iterable<Instruction>): Instructions

    /**
     * Returns the index of [o] in this [Instructions].
     */
    abstract fun indexOf(o: Any): Int

    /**
     * Returns the last index of [o] in this [Instructions].
     */
    abstract fun lastIndexOf(o: Any): Int

    /**
     * For each all elements of this [Instructions].
     */
    abstract override fun forEach(action: Consumer<in Instruction>)

    /**
     * Creates an array of [Instruction] of all elements of this [Instructions].
     */
    abstract fun toArray(): Array<Instruction>

    /**
     * Creates a [Spliterator] from elements of this [Instructions].
     */
    abstract override fun spliterator(): Spliterator<Instruction>

    /**
     * Creates an [Iterator] that iterates elements of this [Instructions].
     */
    abstract override fun iterator(): Iterator<Instruction>

    /**
     * Creates a view of this [Instructions] from index [fromIndex] to index [toIndex],
     * changes to this [Instructions] is reflected in current [Instructions].
     */
    abstract fun subSource(fromIndex: Int, toIndex: Int): Instructions

    /**
     * Creates a immutable [Instructions] with elements of this [Instructions].
     */
    open fun toImmutable(): Instructions = ArrayInstructions(this.toArray())

    /**
     * Creates a mutable [Instructions] with elements of this [Instructions].
     */
    open fun toMutable(): MutableInstructions = ListInstructions(this)

    /**
     * Creates a [ListIterator] that iterates this [Instructions].
     */
    abstract fun listIterator(): ListIterator<Instruction>

    /**
     * Creates a [ListIterator] that iterates this [Instructions] and starts at [index].
     */
    abstract fun listIterator(index: Int): ListIterator<Instruction>

    /**
     * Creates a [Stream] of this [Instructions].
     */
    abstract fun stream(): Stream<Instruction>

    /**
     * Creates a parallel [Stream] of this [Instructions] (which may or may not be parallel).
     */
    abstract fun parallelStream(): Stream<Instruction>

    override fun toString(): String = if (this.isEmpty) "Instructions[]" else "Instructions[...]"

    /**
     * Factory methods to create immutable [Instructions].
     */
    companion object {
        private val EMPTY = emptyArray<Instruction>()
        private val EMPTY_INSTRUCTIONS = ArrayInstructions(EMPTY)

        /**
         * Returns a empty immutable [Instructions].
         */
        @JvmStatic
        fun empty(): Instructions {
            return Instructions.EMPTY_INSTRUCTIONS
        }

        /**
         * Creates a immutable [Instructions] with all elements of [parts].
         */
        @JvmStatic
        fun fromArray(parts: Array<Instruction>): Instructions {
            return ArrayInstructions(parts.clone())
        }

        /**
         * Creates a immutable [Instructions] with a single [part].
         */
        @JvmStatic
        fun fromPart(part: Instruction): Instructions {
            return ArrayInstructions(arrayOf(part))
        }

        /**
         * Creates a immutable [Instructions] with all elements of vararg [parts].
         */
        @JvmStatic
        fun fromVarArgs(vararg parts: Instruction): Instructions {
            return ArrayInstructions(Array(parts.size, { parts[it] }))
        }

        /**
         * Creates a immutable [Instructions] from elements of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromIterable(iterable: Iterable<Instruction>): Instructions {
            if (iterable is Collection<Instruction>) {
                return if (iterable.isEmpty()) {
                    empty()
                } else {
                    ArrayInstructions(iterable.toTypedArray())
                }
            }

            return ArrayInstructions(iterable.toList().toTypedArray())
        }

        /**
         * Creates a immutable [Instructions] from elements of generic [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromGenericIterable(iterable: Iterable<*>): Instructions {
            if (iterable is Collection<*>) {
                return if (iterable.isEmpty()) {
                    empty()
                } else {
                    ArrayInstructions((iterable as Collection<Instruction>).toTypedArray())
                }
            }

            return ArrayInstructions((iterable as Iterable<Instruction>).toList().toTypedArray())
        }

        /**
         * Creates a immutable [Instructions] with all elements of [Instructions] of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromInstructionsIterable(iterable: Iterable<Instructions>): Instructions {
            if (iterable is Collection<Instructions>) {
                return if (iterable.isEmpty()) {
                    empty()
                } else {
                    ArrayInstructions(iterable.flatMap { it }.toTypedArray())
                }
            }

            return ArrayInstructions(iterable.flatMap { it }.toTypedArray())
        }

    }
}

/**
 * Insert element `toInsert` in `source` after element determined by `predicate` or at end of source if not found.
 * @param predicate Predicate to determine element
 * @param toInsert  Element to insert after element determined by `predicate`
 * @return `source`
 */
fun Instructions.insertAfterOrEnd(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
fun Instructions.insertBeforeOrEnd(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
fun Instructions.insertAfterOrStart(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
fun Instructions.insertBeforeOrStart(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
fun Instructions.insertAfter(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
fun Instructions.insertBefore(
    predicate: (Instruction) -> Boolean,
    toInsert: Instructions
): MutableInstructions {

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
 * This method create a new [Instructions] and add all elements from `codeSource`
 * before and after visits each [KoresPart] of `codeSource`.
 *
 * When visiting process finish, it will clear `codeSource` and add all elements from new
 * [Instructions]
 *
 * @param consumer   Consumer
 * @return Result source.
 */
fun Instructions.visit(consumer: (Instruction, Location, MutableInstructions) -> Unit): MutableInstructions {

    val returnSource = ListInstructions()

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


private fun consumeIfExists(part: Instruction, sourceConsumer: (Instruction) -> Unit) {
    if (part is BodyHolder) {
        for (codePart in part.body) {
            consumeIfExists(codePart, sourceConsumer)
        }
    } else {
        sourceConsumer(part)
    }
}

/**
 * Find an element in a code source. (Highly recommended to use [InstructionsInspect] instead of this.
 *
 * @param predicate  Predicate.
 * @param function   Mapper.
 * @param U          Mapped return type.
 * @return List of mapped parts.
 */
fun <U> Instructions.find(
    predicate: (Instruction) -> Boolean,
    function: (Instruction) -> U
): List<U> {
    val list = ArrayList<U>()

    for (codePart in this) {
        if (codePart is Instructions) {
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
 * Tries to determine which type this [Instructions] collection leaves on stack or returns,
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
 * Returns the type that this [Instructions] leaves on stack.
 *
 * This function analyzes the last instruction of [Instructions] and infer the type of value leaved on stack.
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
fun Instructions.getLeaveType(): Type? {
    return this.lastOrNull()?.safeForComparison?.getLeaveType()
}

/**
 * Returns the type leaved in stack by this [Instruction]
 */
fun Instruction.getLeaveType(): Type? {
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
