//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[MethodTypeSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[MethodTypeSpec](../index.md), [MethodTypeSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodTypeSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodTypeSpec](../index.md)<br>Build the object of type T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodTypeSpec.Builder](index.md)<br>See T. |
| [withLocalization](with-localization.md) | [jvm]<br>fun [withLocalization](with-localization.md)(value: [KoresType](../../../com.koresframework.kores.type/-kores-type/index.md)): [MethodTypeSpec.Builder](index.md) |
| [withMethodName](with-method-name.md) | [jvm]<br>fun [withMethodName](with-method-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodTypeSpec.Builder](index.md) |
| [withTypeSpec](with-type-spec.md) | [jvm]<br>fun [withTypeSpec](with-type-spec.md)(value: [TypeSpec](../../../com.koresframework.kores.base/-type-spec/index.md)): [MethodTypeSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>lateinit var [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [methodName](method-name.md) | [jvm]<br>lateinit var [methodName](method-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeSpec](type-spec.md) | [jvm]<br>lateinit var [typeSpec](type-spec.md): [TypeSpec](../../../com.koresframework.kores.base/-type-spec/index.md) |
