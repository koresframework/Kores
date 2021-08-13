//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamic](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [InvokeDynamicBase.Builder](../../-invoke-dynamic-base/-builder/index.md)<[InvokeDynamic](../index.md), [InvokeDynamic.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [InvokeDynamic](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | [jvm]<br>open override fun [bootstrap](bootstrap.md)(value: [MethodInvokeHandleSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md)): [InvokeDynamic.Builder](index.md)<br>open fun [bootstrap](../../-invoke-dynamic-base/-builder/bootstrap.md)(value: [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [InvokeDynamic.Builder](index.md)<br>See [InvokeDynamic.bootstrap](../bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open override fun [bootstrapArgs](bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic.Builder](index.md)<br>open fun [bootstrapArgs](../../-invoke-dynamic-base/-builder/bootstrap-args.md)(vararg values: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [InvokeDynamic.Builder](index.md)<br>See [InvokeDynamic.bootstrapArgs](../bootstrap-args.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [InvokeDynamic](../index.md)<br>Build the object of type T. |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>open override fun [dynamicMethod](dynamic-method.md)(value: [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)): [InvokeDynamic.Builder](index.md)<br>See [InvokeDynamic.dynamicMethod](../dynamic-method.md) |
| [type](../../-invoke-dynamic-base/-builder/type.md) | [jvm]<br>open override fun [type](../../-invoke-dynamic-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [InvokeDynamic.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [args](args.md) | [jvm]<br>var [args](args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> |
| [bootstrap](bootstrap.md) | [jvm]<br>lateinit var [bootstrap](bootstrap.md): [MethodInvokeHandleSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md) |
| [dynamic](dynamic.md) | [jvm]<br>lateinit var [dynamic](dynamic.md): [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md) |
