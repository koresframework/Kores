/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.common

import com.koresframework.kores.annotation.Spec
import com.koresframework.kores.base.Named
import com.koresframework.kores.base.Typed
import kotlinx.serialization.Serializable
import java.lang.reflect.Type
import java.lang.invoke.MethodType

/**
 * Dynamic descriptor describes an invocation target of a `invokedynamic` instruction.
 *
 * Since Java 12, [java.lang.invoke.TypeDescriptor] is available to abstract the third argument of a bootstrap method.
 * It can be a [Class] (represented by [DynamicTypeSpec] in Kores), when linking to constants,
 * or a [MethodType] (represented by [DynamicMethodSpec]) when linking for methods.
 *
 * @since 4.2.2.base
 */
@Serializable
@Spec
sealed class DynamicDescriptor : Named, Typed {
    abstract override fun builder(): Builder<DynamicDescriptor, *>

    interface Builder<out T : DynamicDescriptor, S : Builder<T, S>> :
        Typed.Builder<T, S>, Named.Builder<T, S>
}