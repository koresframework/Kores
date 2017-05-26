[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [IfExpr](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`IfExpr`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`IfExpr`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [expr1](expr1.md) | `lateinit var expr1: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [expr2](expr2.md) | `lateinit var expr2: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [operation](operation.md) | `lateinit var operation: `[`Conditional`](../../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`IfExpr`](../index.md)<br>Build the object of type [T](#). |
| [withExpr1](with-expr1.md) | `fun withExpr1(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [IfExpr.expr1](../expr1.md) |
| [withExpr2](with-expr2.md) | `fun withExpr2(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [IfExpr.expr2](../expr2.md) |
| [withOperation](with-operation.md) | `fun withOperation(value: `[`Conditional`](../../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md)`): Builder`<br>See [IfExpr.operation](../operation.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`IfExpr`](../index.md)`): Builder` |
