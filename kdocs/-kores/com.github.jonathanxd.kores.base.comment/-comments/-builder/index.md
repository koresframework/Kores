//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base.comment](../../index.md)/[Comments](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[Comments](../index.md), [Comments.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Comments](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Comments](../index.md)<br>Build the object of type T. |
| [comments](comments.md) | [jvm]<br>fun [comments](comments.md)(vararg values: [Comment](../../-comment/index.md)): [Comments.Builder](index.md)<br>fun [comments](comments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../../-comment/index.md)>): [Comments.Builder](index.md)<br>See [Comments.comments](../comments.md) |
| [type](type.md) | [jvm]<br>fun [type](type.md)(value: [Comments.Type](../-type/index.md)): [Comments.Builder](index.md)<br>See [Comments.type](../type.md) |

## Properties

| Name | Summary |
|---|---|
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../../-comment/index.md)> |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Comments.Type](../-type/index.md) |
