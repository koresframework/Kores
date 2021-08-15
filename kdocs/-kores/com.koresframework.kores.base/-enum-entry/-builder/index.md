//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[EnumEntry](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Annotable.Builder](../../-annotable/-builder/index.md)<[EnumEntry](../index.md), [EnumEntry.Builder](index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[EnumEntry](../index.md), [EnumEntry.Builder](index.md)> , [Named.Builder](../../-named/-builder/index.md)<[EnumEntry](../index.md), [EnumEntry.Builder](index.md)> , [ElementsHolder.Builder](../../-elements-holder/-builder/index.md)<[EnumEntry](../index.md), [EnumEntry.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [EnumEntry](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [EnumEntry.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [EnumEntry.Builder](index.md)<br>See T. |
| [arguments](../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [EnumEntry.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [EnumEntry.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [EnumEntry.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [EnumEntry](../index.md)<br>Build the object of type T. |
| [constructorSpec](constructor-spec.md) | [jvm]<br>fun [constructorSpec](constructor-spec.md)(value: [TypeSpec](../../-type-spec/index.md)?): [EnumEntry.Builder](index.md)<br>See [EnumEntry.constructorSpec](../constructor-spec.md) |
| [fields](../../-elements-holder/-builder/fields.md) | [jvm]<br>open fun [fields](../../-elements-holder/-builder/fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [EnumEntry.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [EnumEntry.Builder](index.md)<br>open override fun [fields](fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [EnumEntry.Builder](index.md)<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [innerTypes](inner-types.md) | [jvm]<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [EnumEntry.Builder](index.md)<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [EnumEntry.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](../../-elements-holder/-builder/methods.md) | [jvm]<br>open fun [methods](../../-elements-holder/-builder/methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [EnumEntry.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [EnumEntry.Builder](index.md)<br>open override fun [methods](methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [EnumEntry.Builder](index.md)<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EnumEntry.Builder](index.md) |
| [staticBlock](static-block.md) | [jvm]<br>open override fun [staticBlock](static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [EnumEntry.Builder](index.md)<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
| [constructorSpec](constructor-spec.md) | [jvm]<br>var [constructorSpec](constructor-spec.md): [TypeSpec](../../-type-spec/index.md)? = null |
| [fields](fields.md) | [jvm]<br>var [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)> |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [methods](methods.md) | [jvm]<br>var [methods](methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [staticBlock](static-block.md) | [jvm]<br>var [staticBlock](static-block.md): [StaticBlock](../../-static-block/index.md) |
