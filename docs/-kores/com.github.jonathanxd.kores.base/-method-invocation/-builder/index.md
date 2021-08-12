//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[MethodInvocation](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Accessor.Builder](../../-accessor/-builder/index.md)<[MethodInvocation](../index.md), [MethodInvocation.Builder](index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[MethodInvocation](../index.md), [MethodInvocation.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[MethodInvocation](../index.md), [MethodInvocation.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodInvocation](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [MethodInvocation.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodInvocation](../index.md)<br>Build the object of type T. |
| [invokeType](invoke-type.md) | [jvm]<br>fun [invokeType](invoke-type.md)(value: [InvokeType](../../-invoke-type/index.md)): [MethodInvocation.Builder](index.md)<br>See [MethodInvocation.invokeType](../invoke-type.md) |
| [localization](localization.md) | [jvm]<br>open override fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation.Builder](index.md)<br>See [Accessor.localization](../../-accessor/localization.md) |
| [spec](spec.md) | [jvm]<br>fun [spec](spec.md)(value: [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)): [MethodInvocation.Builder](index.md)<br>See [MethodInvocation.spec](../spec.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation.Builder](index.md)<br>See [Accessor.target](../../-accessor/target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [invokeType](invoke-type.md) | [jvm]<br>lateinit var [invokeType](invoke-type.md): [InvokeType](../../-invoke-type/index.md) |
| [spec](spec.md) | [jvm]<br>lateinit var [spec](spec.md): [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
