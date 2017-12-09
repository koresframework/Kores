[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`VariableBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef) (only [name](../../-named/-builder/name.md) and [type](type.md)). |
| [type](type.md) | `open fun type(value: Type): S`<br>See [T.type](type.md) |
| [variableType](variable-type.md) | `abstract fun variableType(value: Type): S`<br>See [T.variableType](variable-type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [name](../../-named/-builder/name.md) | `abstract fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-variable-access/-builder/index.md) | `class Builder : Builder<`[`VariableAccess`](../../-variable-access/index.md)`, `[`Builder`](../../-variable-access/-builder/index.md)`>` |
| [Builder](../../-variable-declaration/-builder/index.md) | `class Builder : Builder<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>` |
| [Builder](../../../com.github.jonathanxd.codeapi.common/-variable-ref/-builder/index.md) | `class Builder : Builder<`[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`, `[`Builder`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/-builder/index.md)`>` |
