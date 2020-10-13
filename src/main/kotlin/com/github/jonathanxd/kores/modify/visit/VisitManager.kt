/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.modify.visit

import com.github.jonathanxd.iutils.data.TypedData
import java.util.*

/**
 * Manager of visitor of part [T].
 *
 * The implementation must care about [register] methods, these methods put values in [partVisitorMap],
 * that isn't accessible from the implementation, if you want to control the register behavior
 * override these methods.
 *
 * The [getVisitor] method is always called to find a registered visitor.
 */
open class VisitManager<T : Any> {

    /**
     * Registered visitors.
     */
    private val partVisitorMap = HashMap<Class<*>, PartVisitor<*>>()

    /**
     * Unmodifiable view of registered visitors.
     */
    val visitors = Collections.unmodifiableMap(this.partVisitorMap)

    /**
     * Registers visitor of [type].
     */
    open fun <U : Any> register(type: Class<U>, visitor: PartVisitor<U>) {
        this.partVisitorMap.put(type, visitor)
    }

    /**
     * Registers a visitor of [type]. (super variance).
     */
    open fun <U : Any> registerSuper(type: Class<U>, visitor: PartVisitor<in U>) {
        this.partVisitorMap.put(type, visitor)
    }

    /**
     * Register a generic visitor of [type].
     */
    open fun registerGeneric(type: Class<*>, visitor: PartVisitor<*>) {
        this.partVisitorMap.put(type, visitor)
    }

    /**
     * Visits [part]
     */
    @Suppress("UNCHECKED_CAST")
    fun <U : Any> visit(part: U, data: TypedData): U {
        return this.getNonNullVisitor<U>(part::class.java).visit(part, data, this)
    }

    /**
     * Visits [part] of [type].
     */
    @Suppress("UNCHECKED_CAST")
    fun <U : Any> visit(type: Class<U>, part: U, data: TypedData): U {
        return this.getNonNullVisitor<U>(type).visit(part, data, this)
    }

    /**
     * Visits [part].
     */
    @Suppress("UNCHECKED_CAST")
    fun visit(part: T): T {
        val aClass = part::class.java

        val data = TypedData()

        val visitor = this.getNonNullVisitor<T>(aClass)

        return visitor.visit(part, data, this)
    }

    private fun <U : Any> getNonNullVisitor(type: Class<*>): PartVisitor<U> {
        return this.getVisitor<U>(type)
                ?: throw IllegalArgumentException("Required visitor of '$type' not registered!")
    }

    /**
     * Gets the visitor of [type].
     */
    @Suppress("UNCHECKED_CAST")
    protected open fun <U : Any> getVisitor(type: Class<*>): PartVisitor<U>? {
        return this.visitors[type] as? PartVisitor<U>
    }
}
