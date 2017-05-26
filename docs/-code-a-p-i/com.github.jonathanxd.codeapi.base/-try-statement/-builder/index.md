[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TryStatement](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<`[`TryStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TryStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [catchStatements](catch-statements.md) | `var catchStatements: List<`[`CatchStatement`](../../-catch-statement/index.md)`>` |
| [finallyStatement](finally-statement.md) | `var finallyStatement: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`TryStatement`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withCatchStatements](with-catch-statements.md) | `fun withCatchStatements(value: List<`[`CatchStatement`](../../-catch-statement/index.md)`>): Builder`<br>See [T.catchStatements](#) |
| [withFinallyStatement](with-finally-statement.md) | `fun withFinallyStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.finallyStatement](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TryStatement`](../index.md)`): Builder` |
