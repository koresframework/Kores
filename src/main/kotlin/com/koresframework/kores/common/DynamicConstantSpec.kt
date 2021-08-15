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
import com.koresframework.kores.base.Typed
import com.koresframework.kores.serialization.BootstrapArgSerializer
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Dynamic Constant as specified in [JEP 309](https://openjdk.java.net/jeps/309) to be used in [com.koresframework.kores.base.InvokeDynamicBase.bootstrapArgs]
 * and in [bootstrapArgs].
 *
 * @property constantName The name of the constant to resolve dynamically.
 * @property constantType The type of the constant value that the method produces.
 * @property bootstrapMethod The bootstrap method used to resolve the constant.
 * @property bootstrapArgs The constraints as [com.koresframework.kores.base.InvokeDynamicBase.bootstrapArgs].
 */
@Spec
@Serializable
data class DynamicConstantSpec(
    val constantName: String,
    val constantType: Type,
    val bootstrapMethod: MethodInvokeHandleSpec,
    val bootstrapArgs: List<@Serializable(with = BootstrapArgSerializer::class) Any>
) : Typed, Comparable<DynamicConstantSpec> {

    override val type: Type
        get() = this.constantType

    /**
     * Human-readable method invocation string.
     */
    fun toInvocationString() =
        "$constantName.$bootstrapMethod<invokeDynamic>(${constantType}, $bootstrapArgs)"

    override fun builder(): Builder = Builder(this)

    override fun compareTo(other: DynamicConstantSpec): Int {
        return if (this.constantName == other.constantName &&
            this.constantType == other.constantType &&
            this.bootstrapMethod == other.bootstrapMethod &&
                this.bootstrapArgs == other.bootstrapArgs) 0 else 1
    }

    class Builder() : Typed.Builder<DynamicConstantSpec, Builder> {

        lateinit var constantName: String
        lateinit var descriptor: Type
        lateinit var bootstrapMethod: MethodInvokeHandleSpec
        lateinit var bootstrapArgs: List<Any>


        constructor(defaults: DynamicConstantSpec) : this() {
            this.constantName = defaults.constantName
            this.descriptor = defaults.constantType
            this.bootstrapMethod = defaults.bootstrapMethod
            this.bootstrapArgs = defaults.bootstrapArgs
        }

        override fun type(value: Type): Builder {
            this.descriptor = value
            return this
        }

        fun constantName(value: String): Builder {
            this.constantName = value
            return this
        }

        fun descriptor(value: Type): Builder {
            this.descriptor = value
            return this
        }

        fun bootstrapMethod(value: MethodInvokeHandleSpec): Builder {
            this.bootstrapMethod = value
            return this
        }

        fun bootstrapArgs(value: List<Any>): Builder {
            this.bootstrapArgs = value
            return this
        }

        override fun build(): DynamicConstantSpec =
            DynamicConstantSpec(this.constantName, this.descriptor, this.bootstrapMethod, this.bootstrapArgs)
    }
}