[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [FieldBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`FieldBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withLocalization](with-localization.md) | `abstract fun withLocalization(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.localization](../localization.md) |
| [withTarget](with-target.md) | `abstract fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.target](../target.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withName](../../-named/-builder/with-name.md) | `abstract fun withName(value: String): S` |
| [withType](../../-typed/-builder/with-type.md) | `abstract fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-typed/type.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-declaration/-builder/index.md) | `class Builder : Builder<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>` |
| [Builder](../../-field-definition/-builder/index.md) | `class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, Builder<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDefinition`](../../-field-definition/index.md)`, `[`Builder`](../../-field-definition/-builder/index.md)`>` |
| [Builder](../../../com.github.jonathanxd.codeapi.common/-field-ref/-builder/index.md) | `class Builder : Builder<`[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`, `[`Builder`](../../../com.github.jonathanxd.codeapi.common/-field-ref/-builder/index.md)`>` |
