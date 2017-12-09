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
| [expressions](expressions.md) | `var expressions: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [type](type.md) | `lateinit var type: `[`Type`](../-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`WhileStatement`](../index.md)<br>Build the object of type [T](#). |
| [expressions](expressions.md) | `fun expressions(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.expressions](#) |
| [type](type.md) | `fun type(value: `[`Type`](../-type/index.md)`): Builder`<br>See [WhileStatement.type](../type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [expressions](../../-if-expression-holder/-builder/expressions.md) | `open fun expressions(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.expressions](../../-if-expression-holder/-builder/expressions.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`WhileStatement`](../index.md)`): Builder` |
