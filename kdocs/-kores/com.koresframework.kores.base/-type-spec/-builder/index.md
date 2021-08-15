//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[TypeSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../-typed/-builder/index.md)<[TypeSpec](../index.md), [TypeSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [TypeSpec](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [TypeSpec](../index.md)<br>Build the object of type T. |
| [parameterTypes](parameter-types.md) | [jvm]<br>fun [parameterTypes](parameter-types.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [TypeSpec.Builder](index.md)<br>fun [parameterTypes](parameter-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [TypeSpec.Builder](index.md) |
| [returnType](return-type.md) | [jvm]<br>fun [returnType](return-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [TypeSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [TypeSpec.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [parameterTypes](parameter-types.md) | [jvm]<br>var [parameterTypes](parameter-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
| [returnType](return-type.md) | [jvm]<br>var [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
