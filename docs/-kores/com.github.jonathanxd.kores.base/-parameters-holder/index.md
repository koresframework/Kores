//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ParametersHolder](index.md)

# ParametersHolder

[jvm]\
interface [ParametersHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Parameter holder

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ParametersHolder](index.md), [S](-builder/index.md) : [ParametersHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ParametersHolder.Builder](-builder/index.md)<[ParametersHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [parameters](parameters.md) | [jvm]<br>abstract val [parameters](parameters.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)><br>Parameters |

## Inheritors

| Name |
|---|
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
