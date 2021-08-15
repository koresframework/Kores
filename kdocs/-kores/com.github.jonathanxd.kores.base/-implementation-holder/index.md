//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ImplementationHolder](index.md)

# ImplementationHolder

[jvm]\
interface [ImplementationHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

An implementation holder

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ImplementationHolder](index.md), [S](-builder/index.md) : [ImplementationHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ImplementationHolder.Builder](-builder/index.md)<[ImplementationHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [implementations](implementations.md) | [jvm]<br>abstract val [implementations](implementations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Implementations |

## Inheritors

| Name |
|---|
| [AnonymousClass](../-anonymous-class/index.md) |
| [ClassDeclaration](../-class-declaration/index.md) |
| [EnumDeclaration](../-enum-declaration/index.md) |
| [InterfaceDeclaration](../-interface-declaration/index.md) |
