[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TryWithResources](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<`[`TryWithResources`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TryWithResources`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [catchStatements](catch-statements.md) | `var catchStatements: List<`[`CatchStatement`](../../-catch-statement/index.md)`>` |
| [finallyStatement](finally-statement.md) | `var finallyStatement: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`TryWithResources`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withCatchStatements](with-catch-statements.md) | `fun withCatchStatements(value: List<`[`CatchStatement`](../../-catch-statement/index.md)`>): Builder`<br>See [T.catchStatements](#) |
| [withFinallyStatement](with-finally-statement.md) | `fun withFinallyStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.finallyStatement](#) |
| [withVariable](with-variable.md) | `fun withVariable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [TryWithResources.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TryWithResources`](../index.md)`): Builder` |
