//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ParametersHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ParametersHolder](../index.md), [S](index.md) : [ParametersHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [parameters](parameters.md) | [jvm]<br>open fun [parameters](parameters.md)(vararg values: [KoresParameter](../../-kores-parameter/index.md)): [S](index.md)<br>abstract fun [parameters](parameters.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../../-kores-parameter/index.md)>): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
