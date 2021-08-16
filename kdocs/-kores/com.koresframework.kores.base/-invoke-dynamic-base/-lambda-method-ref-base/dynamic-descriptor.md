//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaMethodRefBase](index.md)/[dynamicDescriptor](dynamic-descriptor.md)

# dynamicDescriptor

[jvm]\
open override val [dynamicDescriptor](dynamic-descriptor.md): [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/index.md)

Specification of the method to invoke dynamically. This information is used by the [bootstrap method](bootstrap.md) to resolve the target invocation method.

Arguments provided to [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/index.md) are passed to the method resolved by the [bootstrap](bootstrap.md).
