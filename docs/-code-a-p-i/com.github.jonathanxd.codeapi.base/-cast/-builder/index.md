[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Cast](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`Cast`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Cast`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [castedPart](casted-part.md) | `lateinit var castedPart: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [originalType](original-type.md) | `var originalType: Type?` |
| [targetType](target-type.md) | `lateinit var targetType: Type` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Cast`](../index.md)<br>Build the object of type [T](#). |
| [instruction](instruction.md) | `fun instruction(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Cast.instruction](../instruction.md) |
| [originalType](original-type.md) | `fun originalType(value: Type?): Builder`<br>See [Cast.originalType](../original-type.md) |
| [targetType](target-type.md) | `fun targetType(value: Type): Builder`<br>See [Cast.targetType](../target-type.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Cast`](../index.md)`): Builder` |
