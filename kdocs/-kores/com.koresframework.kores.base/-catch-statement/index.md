//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[CatchStatement](index.md)

# CatchStatement

[jvm]\
data class [CatchStatement](index.md)(**exceptionTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, **variable**: [VariableDeclaration](../-variable-declaration/index.md), **body**: [Instructions](../../com.koresframework.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Typed](../-typed/index.md)

Catch statement of a try block. Catch [exceptionTypes](exception-types.md) and store caught exception in [variable](variable.md).

## Constructors

| | |
|---|---|
| [CatchStatement](-catch-statement.md) | [jvm]<br>fun [CatchStatement](-catch-statement.md)(exceptionTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, variable: [VariableDeclaration](../-variable-declaration/index.md), body: [Instructions](../../com.koresframework.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[CatchStatement](index.md), [CatchStatement.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[CatchStatement](index.md), [CatchStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [CatchStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body of exception handler. |
| [exceptionTypes](exception-types.md) | [jvm]<br>val [exceptionTypes](exception-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Exception types to catch. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variable](variable.md) | [jvm]<br>val [variable](variable.md): [VariableDeclaration](../-variable-declaration/index.md)<br>Variable to store exception. |
