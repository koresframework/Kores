//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InnerTypesHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [InnerTypesHolder](../index.md), [S](index.md) : [InnerTypesHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [innerTypes](inner-types.md) | [jvm]<br>open fun [innerTypes](inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [S](index.md)<br>abstract fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [S](index.md)<br>See [InnerTypesHolder.innerTypes](../inner-types.md) |

## Inheritors

| Name |
|---|
| [ElementsHolder](../../-elements-holder/-builder/index.md) |
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [LocalCode](../../-local-code/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [TypeDeclaration](../../-type-declaration/-builder/index.md) |
