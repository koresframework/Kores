[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.common](../../index.md) / [FieldRef](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-field-base/-builder/index.md)`<`[`FieldRef`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`FieldRef`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `lateinit var localization: Type` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](type.md) | `lateinit var type: Type` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`FieldRef`](../index.md)<br>Build the object of type [T](#). |
| [localization](localization.md) | `fun localization(value: Type): Builder`<br>See [T.localization](#) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../../com.github.jonathanxd.codeapi.base/-field-base/-builder/base.md) | `open fun base(variableRef: `[`VariableRef`](../../-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](../../../com.github.jonathanxd.codeapi.base/-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../index.md)`): S`<br>Base this builder on [fieldRef](../../../com.github.jonathanxd.codeapi.base/-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder` |
