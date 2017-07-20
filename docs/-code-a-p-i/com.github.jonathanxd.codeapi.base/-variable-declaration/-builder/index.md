[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-variable-base/-builder/index.md)`<`[`VariableDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`VariableDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`VariableDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`VariableDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | `var modifiers: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [value](value.md) | `var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [variableType](variable-type.md) | `lateinit var variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`VariableDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [modifiers](modifiers.md) | `fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |
| [variableType](variable-type.md) | `fun variableType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.variableType](#) |
| [withoutValue](without-value.md) | `fun withoutValue(): Builder`<br>Removes value definition. |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-variable-base/-builder/base.md) | `open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](../../-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](../../-variable-base/-builder/base.md#com.github.jonathanxd.codeapi.base.VariableBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef) (only [name](../../-named/-builder/name.md) and [type](../../-variable-base/-builder/type.md)). |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [type](../../-variable-base/-builder/type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-variable-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`VariableDeclaration`](../index.md)`): Builder` |
