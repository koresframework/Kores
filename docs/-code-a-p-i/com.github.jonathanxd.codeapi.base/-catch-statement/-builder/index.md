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
| [exceptionTypes](exception-types.md) | `var exceptionTypes: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>` |
| [variable](variable.md) | `lateinit var variable: `[`VariableDeclaration`](../../-variable-declaration/index.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`CatchStatement`](../index.md)<br>Build the object of type [T](#). |
| [exceptionTypes](exception-types.md) | `fun exceptionTypes(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [CatchStatement.exceptionTypes](../exception-types.md)`fun exceptionTypes(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [CatchStatement.variable](../variable.md) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [variable](variable.md) | `fun variable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [CatchStatement.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`CatchStatement`](../index.md)`): Builder` |
