//[Kores](../../index.md)/[com.koresframework.kores.util.conversion](index.md)/[toInvocation](to-invocation.md)

# toInvocation

[jvm]\
fun [MethodTypeSpec](../com.koresframework.kores.common/-method-type-spec/index.md).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), target: [Instruction](../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Create [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md) from [MethodTypeSpec](../com.koresframework.kores.common/-method-type-spec/index.md)

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation. |
| target | Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.koresframework.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)). |
| arguments | Arguments to pass to method. |

[jvm]\
fun [MethodInvokeSpec](../com.koresframework.kores.common/-method-invoke-spec/index.md).[toInvocation](to-invocation.md)(target: [Instruction](../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Create [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md) from [MethodInvokeSpec](../com.koresframework.kores.common/-method-invoke-spec/index.md)

## Parameters

jvm

| | |
|---|---|
| target | Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.koresframework.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)). |
| arguments | Arguments to pass to method. |

[jvm]\
fun [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md)?, target: [Instruction](../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Create [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md) from [Executable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Executable.html)

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation, if null, Kores will try to infer the invocation type. |
| target | Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.koresframework.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)). |
| arguments | Arguments to pass to method. |

[jvm]\
fun [ExecutableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ExecutableElement.html).[toInvocation](to-invocation.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md)?, target: [Instruction](../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>, elements: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Create [ExecutableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/ExecutableElement.html) from [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html)

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation, if null, Kores will try to infer the invocation type. |
| target | Target variable of method invocation (for invoke_static this value is ignored, you can use [Defaults.ACCESS_STATIC](../com.koresframework.kores/-defaults/-a-c-c-e-s-s_-s-t-a-t-i-c.md)). |
| arguments | Arguments to pass to method. |
