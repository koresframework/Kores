[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [StaticBlock](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<`[`StaticBlock`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`StaticBlock`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`StaticBlock`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [genericSignature](generic-signature.md) | `fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [modifiers](modifiers.md) | `fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [parameters](parameters.md) | `fun parameters(value: List<`[`CodeParameter`](../../-code-parameter/index.md)`>): Builder`<br>See [T.parameters](#) |
| [returnType](return-type.md) | `fun returnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.returnType](#) |
| [throwsClause](throws-clause.md) | `fun throwsClause(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [ThrowsHolder.throwsClause](../../-throws-holder/throws-clause.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [type](../../-method-declaration-base/-builder/type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-method-declaration-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`StaticBlock`](../index.md)`): Builder` |
