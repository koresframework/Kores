[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.common](../../index.md) / [VariableRef](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/index.md)`<`[`VariableRef`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`VariableRef`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `lateinit var name: String` |
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`VariableRef`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: String): Builder` |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [variableType](variable-type.md) | `fun variableType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.variableType](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/base.md) | `open fun base(variableRef: `[`VariableRef`](../index.md)`): S`<br>Base this builder on [variableRef](../../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../../-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](../../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef) (only [name](../../../com.github.jonathanxd.codeapi.base/-named/-builder/name.md) and [type](../../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/type.md)). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder` |
