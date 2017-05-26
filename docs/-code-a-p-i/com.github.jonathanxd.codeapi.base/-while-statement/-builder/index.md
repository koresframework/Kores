[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [WhileStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`WhileStatement`](../index.md)`, Builder>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`WhileStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`WhileStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [expressions](expressions.md) | `var expressions: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [type](type.md) | `lateinit var type: `[`Type`](../-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`WhileStatement`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withExpressions](with-expressions.md) | `fun withExpressions(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.expressions](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](../-type/index.md)`): Builder`<br>See [WhileStatement.type](../type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withExpressions](../../-if-expression-holder/-builder/with-expressions.md) | `open fun withExpressions(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.expressions](../../-if-expression-holder/expressions.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`WhileStatement`](../index.md)`): Builder` |
