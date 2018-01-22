[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EnumEntry](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-annotable/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>, `[`Builder`](../../-elements-holder/-builder/index.md)`<`[`EnumEntry`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`EnumEntry`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [arguments](arguments.md) | `var arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [constructorSpec](constructor-spec.md) | `var constructorSpec: `[`TypeSpec`](../../-type-spec/index.md)`?` |
| [fields](fields.md) | `var fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [innerTypes](inner-types.md) | `var innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [arguments](arguments.md) | `fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Builder`<br>See [T.array](#) |
| [build](build.md) | `fun build(): `[`EnumEntry`](../index.md)<br>Build the object of type [T](#). |
| [constructorSpec](constructor-spec.md) | `fun constructorSpec(value: `[`TypeSpec`](../../-type-spec/index.md)`?): Builder`<br>See [EnumEntry.constructorSpec](../constructor-spec.md) |
| [fields](fields.md) | `fun fields(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | `fun methods(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |
| [arguments](../../-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../-arguments-holder/-builder/arguments.md) |
| [fields](../../-elements-holder/-builder/fields.md) | `open fun fields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun fields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [methods](../../-elements-holder/-builder/methods.md) | `open fun methods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun methods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumEntry`](../index.md)`): Builder` |
