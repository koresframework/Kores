//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Annotation](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../-typed/-builder/index.md)<[Annotation](../index.md), [Annotation.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Annotation](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Annotation](../index.md)<br>Build the object of type T. |
| [retention](retention.md) | [jvm]<br>fun [retention](retention.md)(value: [Retention](../../-retention/index.md)): [Annotation.Builder](index.md)<br>See [Annotation.retention](../retention.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation.Builder](index.md)<br>See [Annotation.type](../type.md) |
| [values](values.md) | [jvm]<br>fun [values](values.md)(value: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [Annotation.Builder](index.md)<br>See [Annotation.values](../values.md) |

## Properties

| Name | Summary |
|---|---|
| [retention](retention.md) | [jvm]<br>var [retention](retention.md): [Retention](../../-retention/index.md) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [values](values.md) | [jvm]<br>var [values](values.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> |
