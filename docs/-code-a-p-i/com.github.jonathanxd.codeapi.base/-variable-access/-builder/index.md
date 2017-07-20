[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableAccess](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-variable-base/-builder/index.md)`<`[`VariableAccess`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`VariableAccess`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `lateinit var name: String` |
| [variableType](variable-type.md) | `lateinit var variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`VariableAccess`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: String): Builder` |
| [variableType](variable-type.md) | `fun variableType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.variableType](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-variable-base/-builder/base.md) | `open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](../../-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef) (only [name](../../-named/-builder/name.md) and [type](../../-variable-base/-builder/type.md)).`open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](../../-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef). |
| [type](../../-variable-base/-builder/type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-variable-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`VariableAccess`](../index.md)`): Builder` |
