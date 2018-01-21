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

import com.github.jonathanxd.codeapi.base.Access
import com.github.jonathanxd.codeapi.base.Alias
import com.github.jonathanxd.codeapi.base.InstructionWrapper
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.builder.Builder
import com.github.jonathanxd.codeapi.type.NullType
import com.github.jonathanxd.codeapi.type.`is`
import com.github.jonathanxd.codeapi.type.codeType
import com.github.jonathanxd.codeapi.type.isPrimitive
import java.lang.reflect.Type

/**
 * A CodePart is an element that can exists in the source code.
 *
 * All interfaces that have a concrete implementation and extends [CodePart] must provide a
 * `builder` method that return a builder instance with defined default values.
 *
 */
interface CodePart {

    /**
     * This builder may or may not accept null values, it depends on implementation.
     */
    fun builder(): Builder<CodePart, *> = SelfBuilder(this)

    class SelfBuilder(val self: CodePart) : Builder<CodePart, SelfBuilder> {
        override fun build(): CodePart = self
    }
}

/**
 * Returns true if the type of this [CodePart] is primitive
 */
val CodePart.isPrimitive: Boolean
    get() = this.type.isPrimitive

/**
 * Gets the type of [CodePart]
 */
val CodePart.type: Type
    get() = this.typeOrNull ?: throw IllegalArgumentException("Cannot infer type of part '$this'!")


/**
 * Gets the type of [CodePart] or null if receiver is not a [Typed] instance.
 */
val CodePart.typeOrNull: Type?
    get() = (this as? Typed)?.type?.let {
        if (it.`is`(NullType))
            Types.OBJECT
        else it
    } ?: (this as? InstructionWrapper)?.wrappedInstruction?.also {
        if (it == this)
            throw IllegalStateException("InstructionWrapper wrapping itself.")
    }?.typeOrNull ?: (this as? Access)?.let {
        when (it) {
            Access.THIS, Access.LOCAL, Access.STATIC -> Alias.THIS.codeType
            Access.SUPER -> Alias.SUPER.codeType
        }
    } ?: (this as? CodeInstruction)?.getLeaveType() ?: (this as? CodeSource)?.getLeaveType()

