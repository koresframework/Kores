//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ModifiersHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ModifiersHolder](../index.md), [S](index.md) : [ModifiersHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [modifiers](modifiers.md) | [jvm]<br>open fun [modifiers](modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [S](index.md)<br>abstract fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [S](index.md)<br>See [ModifiersHolder.modifiers](../modifiers.md) |
| [publicModifier](public-modifier.md) | [jvm]<br>open fun [publicModifier](public-modifier.md)(): [S](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |

## Inheritors

| Name |
|---|
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [KoresParameter](../../-kores-parameter/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [ModuleDeclaration](../../-module-declaration/-builder/index.md) |
| [TypeDeclaration](../../-type-declaration/-builder/index.md) |
| [VariableDeclaration](../../-variable-declaration/-builder/index.md) |
