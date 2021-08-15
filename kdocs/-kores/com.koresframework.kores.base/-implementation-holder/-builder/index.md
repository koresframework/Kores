//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ImplementationHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ImplementationHolder](../index.md), [S](index.md) : [ImplementationHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [implementations](implementations.md) | [jvm]<br>open fun [implementations](implementations.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>abstract fun [implementations](implementations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [AnonymousClass](../../-anonymous-class/-builder/index.md) |
| [ClassDeclaration](../../-class-declaration/-builder/index.md) |
| [EnumDeclaration](../../-enum-declaration/-builder/index.md) |
| [InterfaceDeclaration](../../-interface-declaration/-builder/index.md) |
