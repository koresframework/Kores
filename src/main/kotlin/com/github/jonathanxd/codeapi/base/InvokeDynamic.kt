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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.Defaults
import com.github.jonathanxd.codeapi.common.DynamicMethodSpec
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.self
import java.lang.invoke.*
import java.lang.reflect.Type
import java.util.function.Supplier

/**
 * A dynamic invocation of a method.
 *
 * Note: this class does not extends [MethodInvocation] because it is not
 * a normal invocation.
 */
interface InvokeDynamicBase : Typed, CodeInstruction {

    /**
     * Return type of dynamic invocation
     */
    override val type: Type
        get() = dynamicMethod.type

    /**
     * Bootstrap method invocation specification.
     */
    val bootstrap: MethodInvokeSpec

    /**
     * Specification of dynamic method.
     */
    val dynamicMethod: DynamicMethodSpec

    /**
     * Bootstrap method Arguments, must be an [String], [Int],
     * [Long], [Float], [Double], [CodeType] or [MethodInvokeSpec].
     */
    val bootstrapArgs: List<Any>

    override fun builder(): Builder<InvokeDynamicBase, *>

    interface Builder<out T : InvokeDynamicBase, S : Builder<T, S>> :
            Typed.Builder<T, S> {

        override fun type(value: Type): S = self()

        /**
         * See [InvokeDynamic.bootstrap]
         */
        fun bootstrap(value: MethodInvokeSpec): S

        /**
         * See [InvokeDynamic.dynamicMethod]
         */
        fun dynamicMethod(value: DynamicMethodSpec): S

        /**
         * See [InvokeDynamic.bootstrapArgs]
         */
        fun bootstrapArgs(value: List<Any>): S

        /**
         * See [InvokeDynamic.bootstrapArgs]
         */
        fun bootstrapArgs(vararg values: Any): S = bootstrapArgs(values.toList())
    }

    /**
     * Dynamic invocation of lambda method reference.
     */
    interface LambdaMethodRefBase : InvokeDynamicBase, ArgumentsHolder {

        /**
         * Method reference to invoke
         */
        val methodRef: MethodInvokeSpec

        /**
         * Arguments to pass to method ref
         */
        override val arguments: List<CodeInstruction>

        override val types: List<Type>
            get() = this.dynamicMethod.types

        override val array: Boolean
            get() = false

        // Dynamic method, for lambdas, the get(InstanceType, AdditionalArgs)FunctionalInterfaceType
        // The InstanceType is not needed for static [methodRef]
        override val dynamicMethod: DynamicMethodSpec
            get() = DynamicMethodSpec(this.baseSam.methodName,
                    this.baseSam.typeSpec.copy(returnType = this.baseSam.localization,
                            parameterTypes =
                            (if (!methodRef.invokeType.isStatic())
                                listOf(methodRef.methodTypeSpec.localization)
                            else emptyList()) + this.baseSam.typeSpec.parameterTypes),
                    this.arguments)

        override val type: Type
            get() = this.baseSam.localization

        override val bootstrap: MethodInvokeSpec
            get() = MethodInvokeSpec(InvokeType.INVOKE_STATIC, MethodTypeSpec(
                    localization = LambdaMetafactory::class.java,
                    methodName = "metafactory",
                    typeSpec = TypeSpec(
                            returnType = CallSite::class.java,
                            parameterTypes = listOf(MethodHandles.Lookup::class.java, String::class.java, MethodType::class.java, MethodType::class.java, MethodHandle::class.java, MethodType::class.java)
                    )))

        override val bootstrapArgs: List<Any>
            get() = listOf(
                    this.currentTypes,
                    MethodInvokeSpec(this.methodRef.invokeType,
                            MethodTypeSpec(this.methodRef.methodTypeSpec.localization, this.methodRef.methodTypeSpec.methodName,
                                    this.methodRef.methodTypeSpec.typeSpec)),
                    this.expectedTypes
            )

        /**
         * Description of base SAM method, example, if the target functional interface
         * is [Supplier], then the base SAM method is the [Supplier.get].
         */
        val baseSam: MethodTypeSpec

        /**
         * Current types of lambda sam.
         */
        val currentTypes: TypeSpec
            get() = baseSam.typeSpec

        /**
         * Types expected by the caller of lambda SAM.
         */
        val expectedTypes: TypeSpec

        override fun builder(): Builder<LambdaMethodRefBase, *>

        interface Builder<out T : LambdaMethodRefBase, S : Builder<T, S>> :
                InvokeDynamicBase.Builder<T, S>,
                ArgumentsHolder.Builder<T, S> {

            override fun type(value: Type): S = self()
            override fun bootstrap(value: MethodInvokeSpec): S = self()
            override fun bootstrapArgs(value: List<Any>): S = self()
            override fun array(value: Boolean): S = self()
            override fun dynamicMethod(value: DynamicMethodSpec): S = self()

            /**
             * See [LambdaMethodRefBase.methodRef]
             */
            fun methodRef(value: MethodInvokeSpec): S

            /**
             * See [LambdaMethodRefBase.baseSam]
             */
            fun baseSam(value: MethodTypeSpec): S

            /**
             * See [LambdaMethodRefBase.expectedTypes]
             */
            fun expectedTypes(value: TypeSpec): S

        }
    }

    /**
     * Invocation of lambda function.
     */
    interface LambdaLocalCodeBase : LambdaMethodRefBase, ArgumentsHolder {

        override val expectedTypes: TypeSpec
            get() = this.localCode.description

        private val needThis
            get() = this.localCode.invokeType != InvokeType.INVOKE_STATIC

        override val methodRef: MethodInvokeSpec
            get() = MethodInvokeSpec(this.localCode.invokeType,
                    MethodTypeSpec(this.localCode.declaringType, this.localCode.declaration.name,
                            this.localCode.description))

        override val dynamicMethod: DynamicMethodSpec
            get() = DynamicMethodSpec(this.baseSam.methodName,
                    this.baseSam.typeSpec.copy(returnType = this.baseSam.localization),
                    (if (!needThis) listOf() else listOf(Defaults.ACCESS_THIS)) + arguments)

        override val array: Boolean
            get() = false

        /**
         * Local method to invoke
         */
        val localCode: LocalCode

        /**
         * Argument to capture from current context and pass to [localCode]
         */
        override val arguments: List<CodeInstruction>

        override fun builder(): Builder<LambdaLocalCodeBase, *>

        interface Builder<out T : LambdaLocalCodeBase, S : Builder<T, S>> :
                LambdaMethodRefBase.Builder<T, S>,
                ArgumentsHolder.Builder<T, S> {

            override fun type(value: Type): S = self()
            override fun bootstrap(value: MethodInvokeSpec): S = self()
            override fun bootstrapArgs(value: List<Any>): S = self()
            override fun dynamicMethod(value: DynamicMethodSpec): S = self()
            override fun methodRef(value: MethodInvokeSpec): S = self()

            /**
             * See [LambdaLocalCodeBase.localCode]
             */
            fun localCode(value: LocalCode): S
        }
    }

}

data class InvokeDynamic(override val bootstrap: MethodInvokeSpec,
                         override val dynamicMethod: DynamicMethodSpec,
                         override val bootstrapArgs: List<Any>) : InvokeDynamicBase {

    override fun builder(): InvokeDynamic.Builder = InvokeDynamic.Builder(this)

    class Builder() :
            InvokeDynamicBase.Builder<InvokeDynamic, Builder> {

        lateinit var bootstrap: MethodInvokeSpec
        lateinit var dynamic: DynamicMethodSpec
        var args: List<Any> = emptyList()

        constructor(defaults: InvokeDynamic) : this() {
            this.bootstrap = defaults.bootstrap
            this.dynamic = defaults.dynamicMethod
            this.args = defaults.bootstrapArgs
        }

        override fun bootstrap(value: MethodInvokeSpec): Builder {
            this.bootstrap = value
            return this
        }

        override fun dynamicMethod(value: DynamicMethodSpec): Builder {
            this.dynamic = value
            return this
        }

        override fun bootstrapArgs(value: List<Any>): Builder {
            this.args = value
            return this
        }

        override fun build(): InvokeDynamic = InvokeDynamic(this.bootstrap, this.dynamic, this.args)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: InvokeDynamic): Builder = Builder(defaults)
        }

    }

    data class LambdaMethodRef(override val methodRef: MethodInvokeSpec,
                               override val arguments: List<CodeInstruction>,
                               override val baseSam: MethodTypeSpec,
                               override val expectedTypes: TypeSpec) : InvokeDynamicBase.LambdaMethodRefBase {

        override fun builder(): LambdaMethodRef.Builder = LambdaMethodRef.Builder(this)

        class Builder() :
                InvokeDynamicBase.LambdaMethodRefBase.Builder<LambdaMethodRef, Builder> {

            lateinit var methodRef: MethodInvokeSpec
            var arguments: List<CodeInstruction> = emptyList()
            lateinit var baseSam: MethodTypeSpec
            lateinit var expectedTypes: TypeSpec

            constructor(defaults: LambdaMethodRef) : this() {
                this.methodRef = defaults.methodRef
                this.baseSam = defaults.baseSam
                this.expectedTypes = defaults.expectedTypes
            }

            override fun methodRef(value: MethodInvokeSpec): Builder {
                this.methodRef = value
                return this
            }

            override fun arguments(value: List<CodeInstruction>): Builder {
                this.arguments = value
                return this
            }

            override fun baseSam(value: MethodTypeSpec): Builder {
                this.baseSam = value
                return this
            }

            override fun expectedTypes(value: TypeSpec): Builder {
                this.expectedTypes = value
                return this
            }

            override fun build(): LambdaMethodRef = LambdaMethodRef(this.methodRef, this.arguments, this.baseSam, this.expectedTypes)

            companion object {
                @JvmStatic
                fun builder(): Builder = Builder()

                @JvmStatic
                fun builder(defaults: LambdaMethodRef): Builder = Builder(defaults)
            }

        }
    }

    data class LambdaLocalCode(override val baseSam: MethodTypeSpec,
                               override val expectedTypes: TypeSpec,
                               override val localCode: LocalCode,
                               override val arguments: List<CodeInstruction>) : InvokeDynamicBase.LambdaLocalCodeBase {

        override val types: List<Type> = this.localCode.parameters.map(CodeParameter::type)

        override fun builder(): LambdaLocalCode.Builder = LambdaLocalCode.Builder(this)

        class Builder() :
                InvokeDynamicBase.LambdaLocalCodeBase.Builder<LambdaLocalCode, Builder> {

            lateinit var baseSam: MethodTypeSpec
            lateinit var localCode: LocalCode
            var arguments: List<CodeInstruction> = emptyList()
            lateinit var expectedTypes: TypeSpec

            constructor(defaults: LambdaLocalCode) : this() {
                this.baseSam = defaults.baseSam
                this.localCode = defaults.localCode
                this.arguments = defaults.arguments
                this.expectedTypes = defaults.expectedTypes
            }

            override fun expectedTypes(value: TypeSpec): Builder {
                this.expectedTypes = value
                return this
            }

            override fun baseSam(value: MethodTypeSpec): Builder {
                this.baseSam = value
                return this
            }

            override fun localCode(value: LocalCode): Builder {
                this.localCode = value
                return this
            }

            override fun array(value: Boolean): Builder = self()

            override fun arguments(value: List<CodeInstruction>): Builder {
                this.arguments = value
                return this
            }

            override fun build(): LambdaLocalCode = LambdaLocalCode(this.baseSam, this.expectedTypes, this.localCode, this.arguments)

            companion object {
                @JvmStatic
                fun builder(): Builder = Builder()

                @JvmStatic
                fun builder(defaults: LambdaLocalCode): Builder = Builder(defaults)
            }

        }
    }

}
