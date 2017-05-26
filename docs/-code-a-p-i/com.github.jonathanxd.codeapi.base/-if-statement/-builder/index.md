[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [IfStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`IfStatement`](../index.md)`, Builder>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`IfStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`IfStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [elseStatement](else-statement.md) | `var elseStatement: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [expressions](expressions.md) | `var expressions: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`IfStatement`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withElseStatement](with-else-statement.md) | `fun withElseStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [IfStatement.elseStatement](../else-statement.md) |
| [withExpressions](with-expressions.md) | `fun withExpressions(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.expressions](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withExpressions](../../-if-expression-holder/-builder/with-expressions.md) | `open fun withExpressions(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.expressions](../../-if-expression-holder/expressions.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`IfStatement`](../index.md)`): Builder` |
