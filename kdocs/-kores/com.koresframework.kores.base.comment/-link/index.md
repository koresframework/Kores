//[Kores](../../../index.md)/[com.koresframework.kores.base.comment](../index.md)/[Link](index.md)

# Link

[jvm]\
data class [Link](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **target**: [Link.LinkTarget](-link-target/index.md)) : [Comment](../-comment/index.md)

Link comment: comment linking to an element or a url

## Constructors

| | |
|---|---|
| [Link](-link.md) | [jvm]<br>fun [Link](-link.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, target: [Link.LinkTarget](-link-target/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[Link](index.md), [Link.Builder](-builder/index.md)> |
| [LinkTarget](-link-target/index.md) | [jvm]<br>interface [LinkTarget](-link-target/index.md)<br>Target of the link |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Link.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Title/name of link (null to default) |
| [target](target.md) | [jvm]<br>val [target](target.md): [Link.LinkTarget](-link-target/index.md)<br>Link target. |
