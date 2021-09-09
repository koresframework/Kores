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
package com.koresframework.kores.base

import com.koresframework.kores.Instruction
import com.koresframework.kores.builder.self
import com.koresframework.kores.common.*
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.serialization.BootstrapArgListSerializer
import com.koresframework.kores.serialization.BootstrapArgSerializer
import com.koresframework.kores.type.KoresType
import kotlinx.serialization.Serializable
import java.lang.invoke.*
import java.lang.reflect.Type
import java.util.function.Supplier

/**
 * Represents a dynamic invocation of a method. The mechanism of a dynamic invocation is very simple, when JVM encounters an
 * `invokedynamic` instruction, it calls the [bootstrap] method (which is a static method defined in [bootstrapLocalization])
 * to resolve the [target method][dynamicDescriptor]. Once resolved, the [target method/type][dynamicDescriptor] keeps linked to the
 * call-site and there is no way to revert this. Subsequent calls are routed to the resolved method without invoking the bootstrap.
 * This allows optimizations to take in place (like the JIT compiler optimizations).
 *
 * The [dynamicDescriptor] corresponds to the dynamic method that need to be resolved (or the type of a dynamic constants),
 * it contains important information about the method or constant that need to be resolved.
 * For method resolution, the [DynamicMethodSpec.name] and [DynamicMethodSpec.typeSpec] (which are provided as
 * [String] and [MethodType], respectively) are available to the bootstrap method, but [DynamicMethodSpec.arguments] is not,
 * as specified in the documentation of the property. For constant resolution, the [DynamicTypeSpec.name] and [DynamicTypeSpec.type]
 * are provided to the bootstrap method, but [DynamicTypeSpec.arguments] is not, and since constants are resolved by the bootstrap method,
 * those values are not used.
 *
 * Additional information can be provided through [bootstrapArgs] and are passed as the last argument of the
 * [bootstrap method][bootstrap]. The last parameter of [bootstrap method][bootstrap] can be a vararg, an [Array] of [Any],
 * or various parameters of the types accepted by bootstrap methods as specified in JVM Specification and in the
 * [java.lang.invoke] package documentation. The known allowed parameter types are:
 * - Literal Constants
 *   - [Int], [Float], [Long], [Double], [String] (it includes [dynamic constant][DynamicConstantSpec]).
 * - Type Constants
 *   - [Type]/[Class]
 * - Field and Method specification
 *   - [MethodHandle]
 * - Descriptors
 *   - [MethodType]/[TypeDescriptor] (since Java 12)
 *
 *
 * ### Relevant documents
 * - [Java Virtual Machine Support for Non-Java Languages](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/multiple-language-support.html)
 * - [Understanding Java method invocation with invokedynamic](https://blogs.oracle.com/javamagazine/understanding-java-method-invocation-with-invokedynamic)
 * - [Chapter 6. The Java Virtual Machine Instruction Set#invokedynamic](https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-6.html#jvms-6.5.invokedynamic)
 */
interface InvokeDynamicBase : TypedInstruction {

    /**
     * Return type of dynamic invocation
     */
    override val type: Type
        get() = dynamicDescriptor.type

    /**
     * Bootstrap method invocation specification.
     */
    val bootstrap: MethodInvokeHandleSpec

    /**
     * The [Type] that declares the [bootstrap method][bootstrap].
     *
     * This is the same value provided via [MethodTypeSpec] to the [bootstrap].[methodTypeSpec][MethodInvokeHandleSpec.methodTypeSpec].
     */
    val bootstrapLocalization: Type
        get() = this.bootstrap.methodTypeSpec.localization

    /**
     * Specification of a method or constant type to resolve dynamically. This information is used by the [bootstrap method][bootstrap]
     * to resolve the target invocation method, or the target constant.
     *
     * Arguments provided to [DynamicDescriptor] are passed to the method resolved by the [bootstrap]. This does not apply
     * to dynamic constants, as they are resolved by the bootstrap and there is no target method to pass those values.
     */
    val dynamicDescriptor: DynamicDescriptor

    /**
     * Bootstrap method Arguments, must be one of the following types:
     * - [String]
     * - [Int],
     * - [Long]
     * - [Float]
     * - [Double]
     * - [KoresType]/[Type]
     * - [MethodInvokeSpec] (normally translated into [MethodHandle] at runtime, by the JVM)
     * - [FieldAccessHandleSpec] (normally translated into [MethodHandle] at runtime, by the JVM)
     * - [MethodInvokeHandleSpec] (normally translated into [MethodHandle] at runtime, by the JVM)
     * - [TypeSpec] (normally translated into [MethodType] at runtime, by the JVM)
     * - [DynamicConstantSpec] (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).
     *
     * This is the value provided to the bootstrap method which resolves the target method to invoke. Those values
     * are stored in the **ConstantPool** and are not provided to the target method.
     *
     * Arguments that must be provided to the target method must be provided in the [dynamicDescriptor] specification.
     */
    @Serializable(with = BootstrapArgListSerializer::class)
    val bootstrapArgs: List<Any>

    override fun builder(): Builder<InvokeDynamicBase, *>

    interface Builder<out T : InvokeDynamicBase, S : Builder<T, S>> :
        Typed.Builder<T, S> {

        var bootstrap: MethodInvokeHandleSpec
        var bootstrapArgs: List<Any>
        var dynamicDescriptor: DynamicDescriptor

        override var type: Type
            get() = this.dynamicDescriptor.type
            set(value) {}

        override fun type(value: Type): S = self()

        /**
         * See [InvokeDynamicBase.bootstrap]
         */
        fun bootstrap(value: MethodInvokeSpec): S =
            bootstrap(MethodInvokeHandleSpec(value.invokeType.toDynamicInvokeType(), value.methodTypeSpec))

        /**
         * See [InvokeDynamicBase.bootstrap]
         */
        fun bootstrap(value: MethodInvokeHandleSpec): S {
            this.bootstrap = value
            return self()
        }

        /**
         * See [InvokeDynamicBase.dynamicDescriptor]
         */
        fun dynamicDescriptor(value: DynamicDescriptor): S {
            this.dynamicDescriptor = value
            return self()
        }

        /**
         * See [InvokeDynamicBase.bootstrapArgs]
         */
        fun bootstrapArgs(value: List<Any>): S {
            this.bootstrapArgs = value
            return self()
        }

        /**
         * See [InvokeDynamicBase.bootstrapArgs]
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
         * Target of method ref invocation
         */
        val target: Instruction

        /**
         * Arguments to pass to method ref
         */
        override val arguments: List<Instruction>

        override val types: List<Type>
            get() = this.dynamicDescriptor.types

        override val array: Boolean
            get() = false

        // Dynamic method, for lambdas, the get(InstanceType, AdditionalArgs)FunctionalInterfaceType
        // The InstanceType is not needed for static [methodRef]
        override val dynamicDescriptor: DynamicMethodSpec
            get() = createDynamicMethodSpec(this.baseSam, this.methodRef, this.additionalArgumentsType, this.needThis, this.target, this.arguments)

        override val type: Type
            get() = this.baseSam.localization

        override val bootstrap: MethodInvokeHandleSpec
            get() = createBootstrap()

        override val bootstrapArgs: List<Any>
            get() = createBootstrapArgs(this.currentTypes, this.methodRef, this.expectedTypes)

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

            var methodRef: MethodInvokeSpec
            var baseSam: MethodTypeSpec
            var target: Instruction
            var expectedTypes: TypeSpec

            val currentTypes: TypeSpec
                get() = baseSam.typeSpec

            override var bootstrap: MethodInvokeHandleSpec
                get() = createBootstrap()
                set(value) {}

            override var bootstrapArgs: List<Any>
                get() = createBootstrapArgs(this.currentTypes, this.methodRef, this.expectedTypes)
                set(value) {}

            override var dynamicDescriptor: DynamicDescriptor
                get() = createDynamicMethodSpec(this.baseSam, this.methodRef, this.additionalArgumentsType, this.needThis, this.target, this.arguments)
                set(value) {}

            override fun type(value: Type): S = self()
            override fun bootstrap(value: MethodInvokeHandleSpec): S = self()
            override fun bootstrapArgs(value: List<Any>): S = self()
            override fun array(value: Boolean): S = self()
            override fun dynamicDescriptor(value: DynamicDescriptor): S = self()

            /**
             * See [LambdaMethodRefBase.methodRef]
             */
            fun methodRef(value: MethodInvokeSpec): S {
                this.methodRef = value
                return self()
            }

            /**
             * See [LambdaMethodRefBase.target]
             */
            fun target(value: Instruction): S {
                this.target = value
                return self()
            }

            /**
             * See [LambdaMethodRefBase.baseSam]
             */
            fun baseSam(value: MethodTypeSpec): S {
                this.baseSam = value
                return self()
            }

            /**
             * See [LambdaMethodRefBase.expectedTypes]
             */
            fun expectedTypes(value: TypeSpec): S {
                this.expectedTypes = value
                return self()
            }

        }

        companion object {
            fun createBootstrap() = MethodInvokeHandleSpec(
                DynamicInvokeType.INVOKE_STATIC, MethodTypeSpec(
                    localization = LambdaMetafactory::class.java,
                    methodName = "metafactory",
                    typeSpec = TypeSpec(
                        returnType = CallSite::class.java,
                        parameterTypes = listOf(
                            MethodHandles.Lookup::class.java,
                            String::class.java,
                            MethodType::class.java,
                            MethodType::class.java,
                            MethodHandle::class.java,
                            MethodType::class.java
                        )
                    )
                )
            )

            fun createDynamicMethodSpec(
                baseSam: MethodTypeSpec,
                methodRef: MethodInvokeSpec,
                additionalArgumentsType: List<Type>,
                needThis: Boolean,
                target: Instruction,
                arguments: List<Instruction>
            ) = DynamicMethodSpec(
                baseSam.methodName,
                baseSam.typeSpec.copy(
                    returnType = baseSam.localization,
                    parameterTypes =
                    (if (needThis)
                        listOf(methodRef.methodTypeSpec.localization)
                    else emptyList()) + additionalArgumentsType
                ),
                (if (needThis) listOf(target) else emptyList()) + arguments
            )

            fun createBootstrapArgs(
                currentTypes: TypeSpec,
                methodRef: MethodInvokeSpec,
                expectedTypes: TypeSpec
            ) = listOf(
                currentTypes,
                MethodInvokeSpec(
                    methodRef.invokeType,
                    MethodTypeSpec(
                        methodRef.methodTypeSpec.localization,
                        methodRef.methodTypeSpec.methodName,
                        methodRef.methodTypeSpec.typeSpec
                    )
                ),
                expectedTypes
            )
        }
    }

    /**
     * Invocation of lambda function.
     */
    interface LambdaLocalCodeBase : LambdaMethodRefBase, ArgumentsHolder {

        override val expectedTypes: TypeSpec
            get() = this.localCode.description

        override val methodRef: MethodInvokeSpec
            get() = MethodInvokeSpec(
                this.localCode.invokeType,
                MethodTypeSpec(
                    this.localCode.declaringType, this.localCode.declaration.name,
                    this.localCode.description
                )
            )

        override val array: Boolean
            get() = false

        /**
         * Local method to invoke
         */
        val localCode: LocalCode

        /**
         * Argument to capture from current context and pass to [localCode]
         */
        override val arguments: List<Instruction>

        override fun builder(): Builder<LambdaLocalCodeBase, *>

        interface Builder<out T : LambdaLocalCodeBase, S : Builder<T, S>> :
            LambdaMethodRefBase.Builder<T, S>,
            ArgumentsHolder.Builder<T, S> {

            var localCode: LocalCode

            override var methodRef: MethodInvokeSpec
                get() = MethodInvokeSpec(
                    this.localCode.invokeType,
                    MethodTypeSpec(
                        this.localCode.declaringType, this.localCode.declaration.name,
                        this.localCode.description
                    )
                )
                set(value) {}

            override fun type(value: Type): S = self()
            override fun bootstrap(value: MethodInvokeSpec): S = self()
            override fun bootstrapArgs(value: List<Any>): S = self()
            override fun dynamicDescriptor(value: DynamicDescriptor): S = self()
            override fun methodRef(value: MethodInvokeSpec): S = self()

            /**
             * See [LambdaLocalCodeBase.localCode]
             */
            fun localCode(value: LocalCode): S {
                this.localCode = value
                return self()
            }
        }
    }

}

@Serializable
data class InvokeDynamic(
    override val bootstrap: MethodInvokeHandleSpec,
    override val dynamicDescriptor: DynamicDescriptor,
    override val bootstrapArgs: List<@Serializable(with = BootstrapArgSerializer::class) Any>
) : InvokeDynamicBase {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() :
        InvokeDynamicBase.Builder<InvokeDynamic, Builder> {

        override var data: KoresData = KoresData()
        override lateinit var bootstrap: MethodInvokeHandleSpec
        override lateinit var dynamicDescriptor: DynamicDescriptor
        override var bootstrapArgs: List<Any> = emptyList()

        constructor(defaults: InvokeDynamic) : this() {
            this.bootstrap = defaults.bootstrap
            this.dynamicDescriptor = defaults.dynamicDescriptor
            this.bootstrapArgs = defaults.bootstrapArgs

            this.from(defaults)
        }

        override fun buildBasic(): InvokeDynamic = InvokeDynamic(this.bootstrap, this.dynamicDescriptor, this.bootstrapArgs)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: InvokeDynamic): Builder = Builder(defaults)
        }

    }

    @Serializable
    data class LambdaMethodRef(
        override val methodRef: MethodInvokeSpec,
        override val target: Instruction,
        override val arguments: List<Instruction>,
        override val baseSam: MethodTypeSpec,
        override val expectedTypes: TypeSpec
    ) : InvokeDynamicBase.LambdaMethodRefBase {
        override val data: KoresData = KoresData()

        override fun builder(): LambdaMethodRef.Builder = LambdaMethodRef.Builder(this)

        class Builder() :
            InvokeDynamicBase.LambdaMethodRefBase.Builder<LambdaMethodRef, Builder> {

            override var data: KoresData = KoresData()
            override lateinit var methodRef: MethodInvokeSpec
            override lateinit var target: Instruction
            override var arguments: List<Instruction> = emptyList()
            override lateinit var baseSam: MethodTypeSpec
            override lateinit var expectedTypes: TypeSpec

            constructor(defaults: LambdaMethodRef) : this() {
                this.methodRef = defaults.methodRef
                this.target = defaults.target
                this.arguments = defaults.arguments
                this.baseSam = defaults.baseSam
                this.expectedTypes = defaults.expectedTypes
            }

            override fun buildBasic(): LambdaMethodRef = LambdaMethodRef(
                this.methodRef, this.target, this.arguments,
                this.baseSam, this.expectedTypes
            )

            companion object {
                @JvmStatic
                fun builder(): Builder = Builder()

                @JvmStatic
                fun builder(defaults: LambdaMethodRef): Builder = Builder(defaults)
            }

        }
    }

    @Serializable
    data class LambdaLocalCode(
        override val baseSam: MethodTypeSpec,
        override val expectedTypes: TypeSpec,
        override val localCode: LocalCode,
        override val arguments: List<Instruction>
    ) : InvokeDynamicBase.LambdaLocalCodeBase {

        override val data: KoresData = KoresData()

        override val target: Instruction
            get() = if (this.needThis) Access.THIS else Access.STATIC

        override val types: List<Type> = this.localCode.parameters.map(KoresParameter::type)

        override fun builder(): LambdaLocalCode.Builder = LambdaLocalCode.Builder(this)

        class Builder() :
            InvokeDynamicBase.LambdaLocalCodeBase.Builder<LambdaLocalCode, Builder> {

            override var data: KoresData = KoresData()
            override lateinit var baseSam: MethodTypeSpec
            override lateinit var localCode: LocalCode
            override var arguments: List<Instruction> = emptyList()
            override lateinit var expectedTypes: TypeSpec

            override var target: Instruction
                get() = if (this.needThis) Access.THIS else Access.STATIC
                set(value) {}

            override fun array(value: Boolean): Builder = self()
            override fun target(value: Instruction): Builder = self()

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

            override fun arguments(value: List<Instruction>): Builder {
                this.arguments = value
                return this
            }

            override fun buildBasic(): LambdaLocalCode =
                LambdaLocalCode(this.baseSam, this.expectedTypes, this.localCode, this.arguments)

            companion object {
                @JvmStatic
                fun builder(): Builder = Builder()

                @JvmStatic
                fun builder(defaults: LambdaLocalCode): Builder = Builder(defaults)
            }

        }
    }

}

val InvokeDynamicBase.LambdaMethodRefBase.additionalArgumentsType: List<Type>
    get() = if (baseSam.typeSpec.parameterTypes.size !=
            this.methodRef.methodTypeSpec.typeSpec.parameterTypes.size
    ) {
        val samSpec = baseSam.typeSpec
        val invkSpec = this.methodRef.methodTypeSpec.typeSpec

        invkSpec.parameterTypes.subList(
            0,
            (invkSpec.parameterTypes.size - samSpec.parameterTypes.size)
        )
    } else emptyList()

val InvokeDynamicBase.LambdaMethodRefBase.Builder<*, *>.additionalArgumentsType: List<Type>
    get() = if (baseSam.typeSpec.parameterTypes.size !=
            this.methodRef.methodTypeSpec.typeSpec.parameterTypes.size
    ) {
        val samSpec = baseSam.typeSpec
        val invkSpec = this.methodRef.methodTypeSpec.typeSpec

        invkSpec.parameterTypes.subList(
            0,
            (invkSpec.parameterTypes.size - samSpec.parameterTypes.size)
        )
    } else emptyList()

private val InvokeDynamicBase.LambdaMethodRefBase.needThis
    get() = !methodRef.invokeType.isStatic()

private val InvokeDynamicBase.LambdaMethodRefBase.Builder<*, *>.needThis
    get() = !methodRef.invokeType.isStatic()