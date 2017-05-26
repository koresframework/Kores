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
| [build](build.md) | `fun build(): `[`CatchStatement`](../index.md)<br>Build the object of type [T](#). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withExceptionTypes](with-exception-types.md) | `fun withExceptionTypes(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [CatchStatement.exceptionTypes](../exception-types.md)`fun withExceptionTypes(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [CatchStatement.variable](../variable.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withVariable](with-variable.md) | `fun withVariable(value: `[`VariableDeclaration`](../../-variable-declaration/index.md)`): Builder`<br>See [CatchStatement.variable](../variable.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`CatchStatement`](../index.md)`): Builder` |
