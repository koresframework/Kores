//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ModuleReference](index.md)

# ModuleReference

[jvm]\
data class [ModuleReference](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Named](../-named/index.md)

Reference to a module or a package.

## Constructors

| | |
|---|---|
| [ModuleReference](-module-reference.md) | [jvm]<br>fun [ModuleReference](-module-reference.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[ModuleReference](index.md), [ModuleReference.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ModuleReference.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Qualified name of module. |
