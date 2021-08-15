//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ModifiersHolder](index.md)

# ModifiersHolder

[jvm]\
interface [ModifiersHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

A element that have modifiers.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ModifiersHolder](index.md), [S](-builder/index.md) : [ModifiersHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ModifiersHolder.Builder](-builder/index.md)<[ModifiersHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [isPublic](is-public.md) | [jvm]<br>open val [isPublic](is-public.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](modifiers.md) | [jvm]<br>abstract val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |

## Inheritors

| Name |
|---|
| [FieldDeclaration](../-field-declaration/index.md) |
| [KoresParameter](../-kores-parameter/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [ModuleDeclaration](../-module-declaration/index.md) |
| [TypeDeclaration](../-type-declaration/index.md) |
| [VariableDeclaration](../-variable-declaration/index.md) |
