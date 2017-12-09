[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TryStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-try-statement-base/-builder/index.md)`<`[`TryStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TryStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [catchStatements](catch-statements.md) | `var catchStatements: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CatchStatement`](../../-catch-statement/index.md)`>` |
| [finallyStatement](finally-statement.md) | `var finallyStatement: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`TryStatement`](../index.md)<br>Build the object of type [T](#). |
| [catchStatements](catch-statements.md) | `fun catchStatements(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CatchStatement`](../../-catch-statement/index.md)`>): Builder`<br>See [T.catchStatements](#) |
| [finallyStatement](finally-statement.md) | `fun finallyStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.finallyStatement](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [catchStatements](../../-try-statement-base/-builder/catch-statements.md) | `open fun catchStatements(vararg values: `[`CatchStatement`](../../-catch-statement/index.md)`): S`<br>See [T.catchStatements](../../-try-statement-base/-builder/catch-statements.md) |
| [type](../../-try-statement-base/-builder/type.md) | `open fun type(value: Type): S`<br>See [T.type](../../-try-statement-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TryStatement`](../index.md)`): Builder` |
