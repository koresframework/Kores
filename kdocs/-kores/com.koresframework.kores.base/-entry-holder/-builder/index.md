//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[EntryHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [EntryHolder](../index.md), [S](index.md) : [EntryHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [entries](entries.md) | [jvm]<br>open fun [entries](entries.md)(vararg values: [EnumEntry](../../-enum-entry/index.md)): [S](index.md)<br>abstract fun [entries](entries.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[EnumEntry](../../-enum-entry/index.md)>): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [EnumDeclaration](../../-enum-declaration/-builder/index.md) |
