//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Export](index.md)

# Export

[jvm]\
data class [Export](index.md)(**module**: [ModuleReference](../-module-reference/index.md), **to**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)>, **modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>)

Exports [module](module.md) to modules [to](to.md).

## Constructors

| | |
|---|---|
| [Export](-export.md) | [jvm]<br>fun [Export](-export.md)(module: [ModuleReference](../-module-reference/index.md), to: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)>, modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>) |

## Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | [jvm]<br>val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [module](module.md) | [jvm]<br>val [module](module.md): [ModuleReference](../-module-reference/index.md)<br>Module to export. |
| [to](to.md) | [jvm]<br>val [to](to.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)><br>Modules to export to. |
