//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ConstructorsHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ConstructorsHolder](../index.md), [S](index.md) : [ConstructorsHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [constructors](constructors.md) | [jvm]<br>open fun [constructors](constructors.md)(value: [ConstructorDeclaration](../../-constructor-declaration/index.md)): [S](index.md)<br>open fun [constructors](constructors.md)(vararg values: [ConstructorDeclaration](../../-constructor-declaration/index.md)): [S](index.md)<br>abstract fun [constructors](constructors.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../-constructor-declaration/index.md)>): [S](index.md)<br>See [ConstructorsHolder.constructors](../constructors.md) |

## Inheritors

| Name |
|---|
| [AnonymousClass](../../-anonymous-class/-builder/index.md) |
| [ClassDeclaration](../../-class-declaration/-builder/index.md) |
| [EnumDeclaration](../../-enum-declaration/-builder/index.md) |
