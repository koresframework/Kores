[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [CatchStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-body-holder/-builder/index.md)`<`[`CatchStatement`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`CatchStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`CatchStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [exceptionTypes](exception-types.md) | `var exceptionTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>` |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`CatchStatement`](../index.md)<br>Build the object of type [T](#). |
| [exceptionTypes](exception-types.md) | `fun exceptionTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>): Builder`<br>See [CatchStatement.exceptionTypes](../exception-types.md)`fun exceptionTypes(vararg values: Type): Builder`<br>See [CatchStatement.variable](../variable.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [variable](variable.md) | `fun variable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [CatchStatement.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`CatchStatement`](../index.md)`): Builder` |
