//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[QualifiedNamed](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [QualifiedNamed](../index.md), [S](index.md) : [QualifiedNamed.Builder](index.md)<[T](index.md), [S](index.md)>> : [Named.Builder](../../-named/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [qualifiedName](qualified-name.md) | [jvm]<br>abstract fun [qualifiedName](qualified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |

## Inheritors

| Name |
|---|
| [TypeDeclaration](../../-type-declaration/-builder/index.md) |
