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
| [expr1](expr1.md) | `lateinit var expr1: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [expr2](expr2.md) | `lateinit var expr2: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [operation](operation.md) | `lateinit var operation: `[`Conditional`](../../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`IfExpr`](../index.md)<br>Build the object of type [T](#). |
| [expr1](expr1.md) | `fun expr1(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [IfExpr.expr1](../expr1.md) |
| [expr2](expr2.md) | `fun expr2(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [IfExpr.expr2](../expr2.md) |
| [operation](operation.md) | `fun operation(value: `[`Conditional`](../../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md)`): Builder`<br>See [IfExpr.operation](../operation.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`IfExpr`](../index.md)`): Builder` |
