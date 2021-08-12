//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Require](index.md)

# Require

[jvm]\
data class [Require](index.md)(**module**: [ModuleReference](../-module-reference/index.md), **modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Module requires statement

## Constructors

| | |
|---|---|
| [Require](-require.md) | [jvm]<br>fun [Require](-require.md)(module: [ModuleReference](../-module-reference/index.md), modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, version: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | [jvm]<br>val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [module](module.md) | [jvm]<br>val [module](module.md): [ModuleReference](../-module-reference/index.md)<br>Module to require. |
| [version](version.md) | [jvm]<br>val [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Module required version. |
