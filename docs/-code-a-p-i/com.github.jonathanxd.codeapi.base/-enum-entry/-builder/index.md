[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EnumEntry](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-elements-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`EnumEntry`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [constructorSpec](constructor-spec.md) | `var constructorSpec: `[`TypeSpec`](../../-type-spec/index.md)`?` |
| [fields](fields.md) | `var fields: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [name](name.md) | `lateinit var name: String` |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `fun arguments(value: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: Boolean): Builder`<br>See [T.array](#) |
| [build](build.md) | `fun build(): `[`EnumEntry`](../index.md)<br>Build the object of type [T](#). |
| [constructorSpec](constructor-spec.md) | `fun constructorSpec(value: `[`TypeSpec`](../../-type-spec/index.md)`?): Builder`<br>See [EnumEntry.constructorSpec](../constructor-spec.md) |
| [constructors](constructors.md) | `fun constructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [fields](fields.md) | `fun fields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [methods](methods.md) | `fun methods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../-arguments-holder/-builder/arguments.md) |
| [constructors](../../-elements-holder/-builder/constructors.md) | `open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [fields](../../-elements-holder/-builder/fields.md) | `open fun fields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun fields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [methods](../../-elements-holder/-builder/methods.md) | `open fun methods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun methods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumEntry`](../index.md)`): Builder` |
