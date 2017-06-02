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
@file:JvmName("CodePartUtil")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.InstructionWrapper
import com.github.jonathanxd.codeapi.base.MethodInvocation
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.type.NullType
import java.lang.reflect.Type

/**
 * Returns true if a [MethodInvocation] is a invocation of super constructor
 */
val MethodInvocation.isSuperConstructorInvocation get() = this.spec.methodName == "<init>" && this.target == Alias.SUPER

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
    }?.typeOrNull


/**
 * Unwraps [CodeInstruction] if is a [InstructionWrapper] or return receiver if not.
 *
 * This functions recursively unwraps [InstructionWrapper], the operation is executed until
 * `(receiver = InstructionWrapper.wrappedInstruction) is InstructionWrapper`
 */
tailrec fun CodeInstruction.unwrap(): CodeInstruction {
    if(this !is InstructionWrapper)
        return this
    else
        return this.wrappedInstruction.unwrap()

}