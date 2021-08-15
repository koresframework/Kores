//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[CatchStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[CatchStatement](../index.md), [CatchStatement.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[CatchStatement](../index.md), [CatchStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [CatchStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.koresframework.kores/-instructions/index.md)): [CatchStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [CatchStatement](../index.md)<br>Build the object of type T. |
| [exceptionTypes](exception-types.md) | [jvm]<br>fun [exceptionTypes](exception-types.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [CatchStatement.Builder](index.md)<br>See [CatchStatement.variable](../variable.md)<br>[jvm]<br>fun [exceptionTypes](exception-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [CatchStatement.Builder](index.md)<br>See [CatchStatement.exceptionTypes](../exception-types.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [CatchStatement.Builder](index.md)<br>See T. |
| [variable](variable.md) | [jvm]<br>fun [variable](variable.md)(value: [VariableDeclaration](../../-variable-declaration/index.md)): [CatchStatement.Builder](index.md)<br>See [CatchStatement.variable](../variable.md) |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.koresframework.kores/-instructions/index.md) |
| [exceptionTypes](exception-types.md) | [jvm]<br>var [exceptionTypes](exception-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
| [variable](variable.md) | [jvm]<br>lateinit var [variable](variable.md): [VariableDeclaration](../../-variable-declaration/index.md) |
