//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [InvokeDynamicBase](../index.md), [S](index.md) : [InvokeDynamicBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [Typed.Builder](../../-typed/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | [jvm]<br>abstract fun [bootstrap](bootstrap.md)(value: [MethodInvokeHandleSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md)): [S](index.md)<br>open fun [bootstrap](bootstrap.md)(value: [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [S](index.md)<br>See [InvokeDynamic.bootstrap](../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open fun [bootstrapArgs](bootstrap-args.md)(vararg values: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [S](index.md)<br>abstract fun [bootstrapArgs](bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [S](index.md)<br>See [InvokeDynamic.bootstrapArgs](../../-invoke-dynamic/bootstrap-args.md) |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>abstract fun [dynamicMethod](dynamic-method.md)(value: [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)): [S](index.md)<br>See [InvokeDynamic.dynamicMethod](../../-invoke-dynamic/dynamic-method.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [InvokeDynamicBase.LambdaMethodRefBase](../-lambda-method-ref-base/-builder/index.md) |
| [InvokeDynamic](../../-invoke-dynamic/-builder/index.md) |
