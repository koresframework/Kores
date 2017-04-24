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

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.InvokeType
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.common.MethodInvokeSpec
import com.github.jonathanxd.codeapi.common.TypeSpec
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.self
import java.lang.invoke.CallSite
import java.lang.invoke.LambdaMetafactory
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import java.lang.reflect.Type
import java.util.function.Supplier

/**
 * A dynamic invocation of a method.
 *
 * Note: this class does not extends [MethodInvocationBase] because it is not
 * a normal invocation.
 */
@Concrete
interface InvokeDynamicBase : Typed {

    /**
     * Return type of dynamic invocation
     */
    override val type: Type

    /**
     * Bootstrap method invocation specification.
     */
    val bootstrap: MethodInvokeSpec

    /**
     * Invocation to handle dynamically.
     */
    val invocation: MethodInvocationBase

    /**
     * Bootstrap method Arguments, must be an [String], [Int],
     * [Long], [Float], [Double], [CodeType] or [MethodInvokeSpec].
     */
    val args: List<Any>

    override fun builder(): Builder<InvokeDynamicBase, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : InvokeDynamicBase, S : Builder<T, S>> :
            Typed.Builder<T, S> {

        /**
         * See [T.bootstrap]
         */
        fun withBootstrap(value: MethodInvokeSpec): S

        /**
         * See [T.invocation]
         */
        fun withInvocation(value: MethodInvocationBase): S

        /**
         * See [T.args]
         */
        fun withArgs(value: List<Any>): S

        /**
         * See [T.args]
         */
        fun withArgs(vararg values: Any): S = withArgs(values.toList())

        companion object {
            fun builder(): Builder<InvokeDynamicBase, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: InvokeDynamicBase): Builder<InvokeDynamicBase, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }
    }

    /**
     * Dynamic invocation of lambda method reference.
     */
    @Concrete
    interface LambdaMethodRefBase : InvokeDynamicBase {

        override val type: Type
            get() = this.baseSam.localization

        override val bootstrap: MethodInvokeSpec
            get() = MethodInvokeSpec(InvokeType.INVOKE_STATIC, MethodTypeSpec(
                    localization = LambdaMetafactory::class.java,
                    methodName = "metafactory",
                    typeSpec = TypeSpec(
                            returnType = CallSite::class.java,
                            parameterTypes = listOf(MethodHandles.Lookup::class.java, String::class.java, MethodType::class.java, MethodType::class.java, MethodHandles::class.java, MethodType::class.java)
                    )))

        override val args: List<Any>
            get() = listOf(
                    this.baseSam.typeSpec,
                    MethodInvokeSpec(this.invocation.invokeType,
                            MethodTypeSpec(this.invocation.localization, this.invocation.spec.methodName, this.invocation.spec.typeSpec)),
                    this.expectedTypes
            )

        /**
         * Description of base SAM method, example, if the target functional interface
         * is [Supplier], then the base SAM method is the [Supplier.get].
         */
        val baseSam: MethodTypeSpec

        /**
         * Types expected by the caller of lambda SAM.
         */
        val expectedTypes: TypeSpec

        override fun builder(): Builder<LambdaMethodRefBase, *> = CodeAPI.getBuilderProvider()(this)

        interface Builder<out T : LambdaMethodRefBase, S : Builder<T, S>> :
                InvokeDynamicBase.Builder<T, S> {

            override fun withType(value: Type): S = self()
            override fun withBootstrap(value: MethodInvokeSpec): S = self()
            override fun withArgs(value: List<Any>): S = self()

            /**
             * See [T.baseSam]
             */
            fun withBaseSam(value: MethodTypeSpec): S

            /**
             * See [T.expectedTypes]
             */
            fun withExpectedTypes(value: TypeSpec): S

            companion object {
                fun builder(): Builder<LambdaMethodRefBase, *> = CodeAPI.getBuilderProvider().invoke()
                fun builder(defaults: LambdaMethodRefBase): Builder<LambdaMethodRefBase, *> = CodeAPI.getBuilderProvider().invoke(defaults)
            }

        }
    }

    /**
     * Invocation of lambda function.
     */
    @Concrete
    interface LambdaLocalMethodBase : LambdaMethodRefBase {

        override val expectedTypes: TypeSpec
            get() = this.localMethod.description

        override val invocation: MethodInvocationBase
            get() = this.localMethod

        /**
         * Method to invoke
         */
        val localMethod: LocalCode

        override fun builder(): Builder<LambdaLocalMethodBase, *> = CodeAPI.getBuilderProvider()(this)

        interface Builder<out T : LambdaLocalMethodBase, S : Builder<T, S>> :
                LambdaMethodRefBase.Builder<T, S> {

            override fun withType(value: Type): S = self()
            override fun withBootstrap(value: MethodInvokeSpec): S = self()
            override fun withArgs(value: List<Any>): S = self()
            override fun withExpectedTypes(value: TypeSpec): S = self()
            override fun withInvocation(value: MethodInvocationBase): S = self()

            /**
             * See [T.localMethod]
             */
            fun withLocalMethod(value: LocalCode): S

            companion object {
                fun builder(): Builder<LambdaLocalMethodBase, *> = CodeAPI.getBuilderProvider().invoke()
                fun builder(defaults: LambdaLocalMethodBase): Builder<LambdaLocalMethodBase, *> = CodeAPI.getBuilderProvider().invoke(defaults)
            }

        }
    }

}

data class InvokeDynamic(override val type: Type, override val bootstrap: MethodInvokeSpec, override val invocation: MethodInvocationBase, override val args: List<Any>) : InvokeDynamicBase {

    data class LambdaMethodRef(override val invocation: MethodInvocationBase, override val baseSam: MethodTypeSpec, override val expectedTypes: TypeSpec) : InvokeDynamicBase.LambdaMethodRefBase

    data class LambdaLocalMethod(override val baseSam: MethodTypeSpec, override val localMethod: LocalCode) : InvokeDynamicBase.LambdaLocalMethodBase

}
