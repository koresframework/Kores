[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TryStatementBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`TryStatementBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [catchStatements](catch-statements.md) | `abstract fun catchStatements(value: List<`[`CatchStatement`](../../-catch-statement/index.md)`>): S`<br>`open fun catchStatements(vararg values: `[`CatchStatement`](../../-catch-statement/index.md)`): S`<br>See [T.catchStatements](catch-statements.md) |
| [finallyStatement](finally-statement.md) | `abstract fun finallyStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.finallyStatement](finally-statement.md) |
| [type](type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [body](../../-body-holder/-builder/body.md) | `abstract fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.body](../../-body-holder/-builder/body.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-try-with-resources/-builder/index.md) | `class Builder : Builder<`[`TryWithResources`](../../-try-with-resources/index.md)`, `[`Builder`](../../-try-with-resources/-builder/index.md)`>` |
| [Builder](../../-try-statement/-builder/index.md) | `class Builder : Builder<`[`TryStatement`](../../-try-statement/index.md)`, `[`Builder`](../../-try-statement/-builder/index.md)`>` |
