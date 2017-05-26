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
| [value](value.md) | `var value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`FieldDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [withAnnotations](with-annotations.md) | `fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [withComments](with-comments.md) | `fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withLocalization](with-localization.md) | `fun withLocalization(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.localization](#) |
| [withModifiers](with-modifiers.md) | `fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withTarget](with-target.md) | `fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [T.target](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withAnnotations](../../-annotable/-builder/with-annotations.md) | `open fun withAnnotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/annotations.md) |
| [withInnerTypes](../../-inner-types-holder/-builder/with-inner-types.md) | `open fun withInnerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [T.innerTypes](../../-inner-types-holder/inner-types.md) |
| [withModifiers](../../-modifiers-holder/-builder/with-modifiers.md) | `open fun withModifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withPublicModifier](../../-modifiers-holder/-builder/with-public-modifier.md) | `open fun withPublicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`FieldDeclaration`](../index.md)`): Builder` |
