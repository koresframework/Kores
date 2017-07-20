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
| [expressions](expressions.md) | `var expressions: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`IfStatement`](../index.md)<br>Build the object of type [T](#). |
| [elseStatement](else-statement.md) | `fun elseStatement(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [IfStatement.elseStatement](../else-statement.md) |
| [expressions](expressions.md) | `fun expressions(value: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.expressions](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [expressions](../../-if-expression-holder/-builder/expressions.md) | `open fun expressions(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.expressions](../../-if-expression-holder/-builder/expressions.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`IfStatement`](../index.md)`): Builder` |
