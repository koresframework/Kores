//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[MethodSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[MethodSpec](../index.md), [MethodSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodSpec](../index.md)<br>Build the object of type T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodSpec.Builder](index.md)<br>See T. |
| [withMethodName](with-method-name.md) | [jvm]<br>fun [withMethodName](with-method-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodSpec.Builder](index.md) |
| [withTypeSpec](with-type-spec.md) | [jvm]<br>fun [withTypeSpec](with-type-spec.md)(value: [TypeSpec](../../../com.koresframework.kores.base/-type-spec/index.md)): [MethodSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [methodName](method-name.md) | [jvm]<br>lateinit var [methodName](method-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeSpec](type-spec.md) | [jvm]<br>lateinit var [typeSpec](type-spec.md): [TypeSpec](../../../com.koresframework.kores.base/-type-spec/index.md) |
