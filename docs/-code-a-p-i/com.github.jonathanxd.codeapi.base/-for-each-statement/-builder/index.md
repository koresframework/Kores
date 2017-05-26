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
| [iterableElement](iterable-element.md) | `lateinit var iterableElement: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [iterationType](iteration-type.md) | `lateinit var iterationType: `[`IterationType`](../../-iteration-type/index.md) |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ForEachStatement`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withIterableElement](with-iterable-element.md) | `fun withIterableElement(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ForEachStatement.iterableElement](../iterable-element.md) |
| [withIterationType](with-iteration-type.md) | `fun withIterationType(value: `[`IterationType`](../../-iteration-type/index.md)`): Builder`<br>See [ForEachStatement.iterationType](../iteration-type.md) |
| [withVariable](with-variable.md) | `fun withVariable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [ForEachStatement.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ForEachStatement`](../index.md)`): Builder` |
