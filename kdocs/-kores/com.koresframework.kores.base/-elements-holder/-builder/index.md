//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ElementsHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ElementsHolder](../index.md), [S](index.md) : [ElementsHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [InnerTypesHolder.Builder](../../-inner-types-holder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [fields](fields.md) | [jvm]<br>open fun [fields](fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [S](index.md)<br>open fun [fields](fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [S](index.md)<br>abstract fun [fields](fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [S](index.md)<br>See [ElementsHolder.fields](../fields.md) |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | [jvm]<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [S](index.md)<br>abstract fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [S](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | [jvm]<br>open fun [methods](methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [S](index.md)<br>open fun [methods](methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [S](index.md)<br>abstract fun [methods](methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [S](index.md)<br>See [ElementsHolder.methods](../methods.md) |
| [staticBlock](static-block.md) | [jvm]<br>abstract fun [staticBlock](static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [S](index.md)<br>See [ElementsHolder.staticBlock](../static-block.md) |

## Inheritors

| Name |
|---|
| [EnumEntry](../../-enum-entry/-builder/index.md) |
| [TypeDeclaration](../../-type-declaration/-builder/index.md) |
