[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TryWithResources](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-try-statement-base/-builder/index.md)`<`[`TryWithResources`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TryWithResources`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [catchStatements](catch-statements.md) | `var catchStatements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CatchStatement`](../../-catch-statement/index.md)`>` |
| [finallyStatement](finally-statement.md) | `var finallyStatement: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`TryWithResources`](../index.md)<br>Build the object of type [T](#). |
| [catchStatements](catch-statements.md) | `fun catchStatements(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CatchStatement`](../../-catch-statement/index.md)`>): Builder`<br>See [TryStatementBase.catchStatements](../../-try-statement-base/catch-statements.md) |
| [finallyStatement](finally-statement.md) | `fun finallyStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [TryStatementBase.finallyStatement](../../-try-statement-base/finally-statement.md) |
| [variable](variable.md) | `fun variable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [TryWithResources.variable](../variable.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [catchStatements](../../-try-statement-base/-builder/catch-statements.md) | `open fun catchStatements(vararg values: `[`CatchStatement`](../../-catch-statement/index.md)`): S`<br>See [TryStatementBase.catchStatements](../../-try-statement-base/catch-statements.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TryWithResources`](../index.md)`): Builder` |
