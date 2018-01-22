[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [FieldDefinition](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`FieldDefinition`](../index.md)`, Builder>, `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDefinition`](../index.md)`, Builder>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDefinition`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`FieldDefinition`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `lateinit var localization: Type` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](type.md) | `lateinit var type: Type` |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`FieldDefinition`](../index.md)<br>Build the object of type [T](#). |
| [localization](localization.md) | `fun localization(value: Type): Builder`<br>See [Accessor.localization](../../-accessor/localization.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Accessor.target](../../-accessor/target.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-field-base/-builder/base.md) | `open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](../../-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef).`open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](../../-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`FieldDefinition`](../index.md)`): Builder` |
