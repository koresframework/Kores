//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ThrowsHolder](index.md)

# ThrowsHolder

[jvm]\
interface [ThrowsHolder](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

A code part which declares throws statement.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ThrowsHolder](index.md), [S](-builder/index.md) : [ThrowsHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ThrowsHolder.Builder](-builder/index.md)<[ThrowsHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [throwsClause](throws-clause.md) | [jvm]<br>abstract val [throwsClause](throws-clause.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Throws exception |

## Inheritors

| Name |
|---|
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
