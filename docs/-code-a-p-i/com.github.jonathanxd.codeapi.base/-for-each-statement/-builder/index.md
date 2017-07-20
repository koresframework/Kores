[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ForEachStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-body-holder/-builder/index.md)`<`[`ForEachStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ForEachStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [iterableElement](iterable-element.md) | `lateinit var iterableElement: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [iterationType](iteration-type.md) | `lateinit var iterationType: `[`IterationType`](../../-iteration-type/index.md) |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`ForEachStatement`](../index.md)<br>Build the object of type [T](#). |
| [iterableElement](iterable-element.md) | `fun iterableElement(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [ForEachStatement.iterableElement](../iterable-element.md) |
| [iterationType](iteration-type.md) | `fun iterationType(value: `[`IterationType`](../../-iteration-type/index.md)`): Builder`<br>See [ForEachStatement.iterationType](../iteration-type.md) |
| [variable](variable.md) | `fun variable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [ForEachStatement.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ForEachStatement`](../index.md)`): Builder` |
