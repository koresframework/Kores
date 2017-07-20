[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [FieldDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`FieldDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`FieldDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | `var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`FieldDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [localization](localization.md) | `fun localization(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.localization](#) |
| [modifiers](modifiers.md) | `fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |
| [withoutValue](without-value.md) | `fun withoutValue(): Builder`<br>Removes value definition |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |
| [base](../../-field-base/-builder/base.md) | `open fun base(variableRef: `[`VariableRef`](../../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md)`): S`<br>Base this builder on [variableRef](../../-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.VariableRef)/variableRef).`open fun base(fieldRef: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): S`<br>Base this builder on [fieldRef](../../-field-base/-builder/base.md#com.github.jonathanxd.codeapi.base.FieldBase.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/fieldRef). |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [T.innerTypes](../../-inner-types-holder/-builder/inner-types.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`FieldDeclaration`](../index.md)`): Builder` |
