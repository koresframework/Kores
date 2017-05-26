[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EnumEntry](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-elements-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`EnumEntry`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [constructorSpec](constructor-spec.md) | `var constructorSpec: `[`TypeSpec`](../../-type-spec/index.md)`?` |
| [constructors](constructors.md) | `var constructors: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>` |
| [fields](fields.md) | `var fields: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`EnumEntry`](../index.md)<br>Build the object of type [T](#). |
| [withArguments](with-arguments.md) | `fun withArguments(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.arguments](#) |
| [withArray](with-array.md) | `fun withArray(value: Boolean): Builder`<br>See [T.array](#) |
| [withConstructorSpec](with-constructor-spec.md) | `fun withConstructorSpec(value: `[`TypeSpec`](../../-type-spec/index.md)`?): Builder`<br>See [EnumEntry.constructorSpec](../constructor-spec.md) |
| [withConstructors](with-constructors.md) | `fun withConstructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [withFields](with-fields.md) | `fun withFields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withMethods](with-methods.md) | `fun withMethods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withStaticBlock](with-static-block.md) | `fun withStaticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withArguments](../../-argument-holder/-builder/with-arguments.md) | `open fun withArguments(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.arguments](../../-argument-holder/arguments.md) |
| [withConstructors](../../-elements-holder/-builder/with-constructors.md) | `open fun withConstructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun withConstructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [withFields](../../-elements-holder/-builder/with-fields.md) | `open fun withFields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun withFields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [withMethods](../../-elements-holder/-builder/with-methods.md) | `open fun withMethods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun withMethods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumEntry`](../index.md)`): Builder` |
