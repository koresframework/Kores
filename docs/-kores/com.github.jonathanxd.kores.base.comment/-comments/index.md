//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base.comment](../index.md)/[Comments](index.md)

# Comments

[jvm]\
data class [Comments](index.md)(**comments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>, **type**: [Comments.Type](-type/index.md)) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Hold a list of comments.

## Constructors

| | |
|---|---|
| [Comments](-comments.md) | [jvm]<br>fun [Comments](-comments.md)(comments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)>, type: [Comments.Type](-type/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[Comments](index.md), [Comments.Builder](-builder/index.md)> |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [Type](-type/index.md) | [jvm]<br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Comments.Type](-type/index.md)> <br>Comment type |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Comments.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [isAbsent](is-absent.md) | [jvm]<br>fun [isAbsent](is-absent.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Comments](index.md) instance is [Absent](-companion/-absent.md). |
| [isNotAbsent](is-not-absent.md) | [jvm]<br>fun [isNotAbsent](is-not-absent.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Comments](index.md) instance is not [Absent](-companion/-absent.md). |

## Properties

| Name | Summary |
|---|---|
| [comments](comments.md) | [jvm]<br>val [comments](comments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](../-comment/index.md)><br>Comment list |
| [type](type.md) | [jvm]<br>val [type](type.md): [Comments.Type](-type/index.md)<br>Type of comments entry. |
