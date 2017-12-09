[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EnumDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`EnumDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`EnumDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-entry-holder/-builder/index.md)`<`[`EnumDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-constructors-holder/-builder/index.md)`<`[`EnumDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`EnumDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [constructors](constructors.md) | `var constructors: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>` |
| [entries](entries.md) | `var entries: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`EnumEntry`](../../-enum-entry/index.md)`>` |
| [fields](fields.md) | `var fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [genericSignature](generic-signature.md) | `var genericSignature: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md) |
| [implementations](implementations.md) | `var implementations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>` |
| [innerTypes](inner-types.md) | `var innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: Type?` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`EnumDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [constructors](constructors.md) | `fun constructors(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [ConstructorsHolder.constructors](../../-constructors-holder/constructors.md) |
| [entries](entries.md) | `fun entries(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`EnumEntry`](../../-enum-entry/index.md)`>): Builder`<br>See [T.entries](#) |
| [fields](fields.md) | `fun fields(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | `fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [implementations](implementations.md) | `fun implementations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>): Builder`<br>See [T.implementations](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | `fun methods(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | `fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [outerClass](outer-class.md) | `fun outerClass(value: Type?): Builder`<br>See [TypeDeclaration.outerClass](../../-type-declaration/outer-class.md) |
| [specifiedName](specified-name.md) | `fun specifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [constructors](../../-constructors-holder/-builder/constructors.md) | `open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [ConstructorsHolder.constructors](../../-constructors-holder/constructors.md) |
| [entries](../../-entry-holder/-builder/entries.md) | `open fun entries(vararg values: `[`EnumEntry`](../../-enum-entry/index.md)`): S`<br>See [T.entries](../../-entry-holder/-builder/entries.md) |
| [implementations](../../-implementation-holder/-builder/implementations.md) | `open fun implementations(vararg values: Type): S`<br>See [T.implementations](../../-implementation-holder/-builder/implementations.md) |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | `open fun qualifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumDeclaration`](../index.md)`): Builder` |
