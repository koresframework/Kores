[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [AnonymousClass](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-constructors-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`AnonymousClass`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [arguments](arguments.md) | `var arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [constructorBody](constructor-body.md) | `lateinit var constructorBody: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [constructorSpec](constructor-spec.md) | `lateinit var constructorSpec: `[`TypeSpec`](../../-type-spec/index.md) |
| [constructors](constructors.md) | `var constructors: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>` |
| [fields](fields.md) | `var fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [implementations](implementations.md) | `var implementations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>` |
| [innerTypes](inner-types.md) | `var innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: Type?` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |
| [superClass](super-class.md) | `var superClass: Type` |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [arguments](arguments.md) | `fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Builder`<br>See [T.array](#) |
| [build](build.md) | `fun build(): `[`AnonymousClass`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [CommentHolder.comments](#) |
| [constructorBody](constructor-body.md) | `fun constructorBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [AnonymousClass.constructorBody](../constructor-body.md) |
| [constructorSpec](constructor-spec.md) | `fun constructorSpec(value: `[`TypeSpec`](../../-type-spec/index.md)`): Builder`<br>See [AnonymousClass.constructorSpec](../constructor-spec.md) |
| [constructors](constructors.md) | `fun constructors(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [ConstructorsHolder.constructors](../../-constructors-holder/constructors.md) |
| [fields](fields.md) | `fun fields(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | `fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [implementations](implementations.md) | `fun implementations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>): Builder`<br>See [T.implementations](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | `fun methods(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | `fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>`fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [outerType](outer-type.md) | `fun outerType(value: Type?): Builder`<br>See [TypeDeclaration.outerType](../../-type-declaration/outer-type.md) |
| [specifiedName](specified-name.md) | `fun specifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |
| [superClass](super-class.md) | `fun superClass(value: Type?): Builder`<br>See [T.superClass](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../-arguments-holder/-builder/arguments.md) |
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [constructors](../../-constructors-holder/-builder/constructors.md) | `open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [ConstructorsHolder.constructors](../../-constructors-holder/constructors.md) |
| [implementations](../../-implementation-holder/-builder/implementations.md) | `open fun implementations(vararg values: Type): S`<br>See [T.implementations](../../-implementation-holder/-builder/implementations.md) |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | `open fun qualifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnonymousClass`](../index.md)`): Builder` |
