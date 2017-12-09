[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [FieldBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`FieldBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef). |
| [localization](localization.md) | `abstract fun localization(value: Type): S`<br>See [T.localization](localization.md) |
| [target](target.md) | `abstract fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.target](target.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [name](../../-named/-builder/name.md) | `abstract fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |
| [type](../../-typed/-builder/type.md) | `abstract fun type(value: Type): S`<br>See [T.type](../../-typed/-builder/type.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-declaration/-builder/index.md) | `class Builder : Builder<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>` |
| [Builder](../../-field-definition/-builder/index.md) | `class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, Builder<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>` |
| [Builder](../../../com.github.jonathanxd.codeapi.common/-field-ref/-builder/index.md) | `class Builder : Builder<`[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`, `[`Builder`](../../../com.github.jonathanxd.codeapi.common/-field-ref/-builder/index.md)`>` |
