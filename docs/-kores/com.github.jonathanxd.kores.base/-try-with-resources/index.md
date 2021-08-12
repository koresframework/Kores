//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TryWithResources](index.md)

# TryWithResources

[jvm]\
data class [TryWithResources](index.md)(**variable**: [VariableDeclaration](../-variable-declaration/index.md), **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), **catchStatements**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, **finallyStatement**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [TryStatementBase](../-try-statement-base/index.md)

Try-with-resources

## Constructors

| | |
|---|---|
| [TryWithResources](-try-with-resources.md) | [jvm]<br>fun [TryWithResources](-try-with-resources.md)(variable: [VariableDeclaration](../-variable-declaration/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), catchStatements: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, finallyStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [TryStatementBase.Builder](../-try-statement-base/-builder/index.md)<[TryWithResources](index.md), [TryWithResources.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [TryWithResources.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body of try-with-resources |
| [catchStatements](catch-statements.md) | [jvm]<br>open override val [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)><br>Catch clauses/Exception handlers |
| [finallyStatement](finally-statement.md) | [jvm]<br>open override val [finallyStatement](finally-statement.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Finally statement (in bytecode generator the finally statement is inlined). |
| [variable](variable.md) | [jvm]<br>val [variable](variable.md): [VariableDeclaration](../-variable-declaration/index.md)<br>Variable to try-with-resources (value must be [AutoCloseable](https://docs.oracle.com/javase/8/docs/api/java/lang/AutoCloseable.html)). |
