/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.type

import java.lang.reflect.Type

/**
 * Builder of a [GenericType].
 *
 * Examples:
 *
 * List of String:
 * `GenericTypeBuilder().withType(List::class.codeType).addOfBound(String::class.codeType).build()`
 *
 * T extends List of wildcard extends CharSequence: `<T: List<out CharSequence>>` or `<T extends List<? extends CharSequence>>`
 * ```
 * GenericTypeBuilder().withName("T").withExtendsBound(
 *   GenericTypeBuilder().withType(List::class.codeType).withExtendsBound(
 *     GenericTypeBuilder().wildcard().withExtendsBound(CharSequence::class.codeType).build()
 *   ).build()
 * )
 * ```
 *
 * You may also prefer the [Generic] style:
 * ```
 * Generic.type("T").extends_(
 *   Generic.type(List::class.codeType).extends_(
 *     Generic.wildcard().extends_(CharSequence::class.codeType)
 *   )
 * )
 * ```
 *
 * **Attention: All calls of the methods of [Generic] class creates a copy of the `bound` array (except the first call), if you mind performance use the [GenericTypeBuilder]**
 *
 */
class GenericTypeBuilder() : GenericType.Builder<GenericType, GenericTypeBuilder> {

    var name: String? = null
    var type: KoresType? = null
    var bounds: MutableList<GenericType.Bound> = mutableListOf()

    constructor(defaults: GenericType) : this() {
        if (!defaults.isType)
            this.name = defaults.name
        else
            this.type = defaults.resolvedType

        this.bounds = defaults.bounds.toMutableList()
    }


    override fun name(value: String): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.name = value
        this.type = null
        return this
    }

    override fun wildcard(): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.name = "*"
        this.type = null
        return this
    }

    override fun type(value: Type): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.name = null
        this.type = value.koresType
        return this
    }

    override fun bounds(value: Array<GenericType.Bound>): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds = value.toMutableList()
        return this
    }

    override fun addBounds(bounds: Array<GenericType.Bound>): GenericType.Builder<GenericType, GenericTypeBuilder> {
        bounds.forEach {
            this.bounds.add(it)
        }
        return this
    }

    override fun addBounds(bounds: Collection<GenericType.Bound>): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds.addAll(bounds)
        return this
    }

    override fun addBound(bound: GenericType.Bound): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds.add(bound)
        return this
    }

    override fun addExtendsBound(value: Type): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds.add(GenericType.Extends(value.koresType))
        return this
    }

    override fun addSuperBound(value: Type): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds.add(GenericType.Super(value.koresType))
        return this
    }

    override fun addOfBound(value: Type): GenericType.Builder<GenericType, GenericTypeBuilder> {
        this.bounds.add(GenericType.GenericBound(value.koresType))
        return this
    }

    override fun build(): GenericType = GenericTypeImpl(
        name = this.name,
        codeType = this.type,
        bounds = this.bounds.toTypedArray()
    )

    companion object {
        @JvmStatic
        fun builder() = GenericTypeBuilder()
    }

}