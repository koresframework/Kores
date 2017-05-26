[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<`[`MethodDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`MethodDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [genericSignature](generic-signature.md) | `var genericSignature: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [parameters](parameters.md) | `var parameters: List<`[`CodeParameter`](../../-code-parameter/index.md)`>` |
| [returnType](return-type.md) | `var returnType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`MethodDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [withAnnotations](with-annotations.md) | `fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withComments](with-comments.md) | `fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [withGenericSignature](with-generic-signature.md) | `fun withGenericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withModifiers](with-modifiers.md) | `fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withParameters](with-parameters.md) | `fun withParameters(value: List<`[`CodeParameter`](../../-code-parameter/index.md)`>): Builder`<br>See [T.parameters](#) |
| [withReturnType](with-return-type.md) | `fun withReturnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.returnType](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withType](../../-method-declaration-base/-builder/with-type.md) | `open fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-method-declaration-base/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`MethodDeclaration`](../index.md)`): Builder` |
