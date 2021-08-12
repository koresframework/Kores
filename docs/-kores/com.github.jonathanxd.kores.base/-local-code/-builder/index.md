//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[LocalCode](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[LocalCode](../index.md), [LocalCode.Builder](index.md)> , [InnerTypesHolder.Builder](../../-inner-types-holder/-builder/index.md)<[LocalCode](../index.md), [LocalCode.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [LocalCode](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [LocalCode](../index.md)<br>Build the object of type T. |
| [declaration](declaration.md) | [jvm]<br>fun [declaration](declaration.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [LocalCode.Builder](index.md)<br>See [LocalCode.declaration](../declaration.md) |
| [declaringType](declaring-type.md) | [jvm]<br>fun [declaringType](declaring-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [LocalCode.Builder](index.md)<br>See [LocalCode.declaringType](../declaring-type.md) |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | [jvm]<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [LocalCode.Builder](index.md)<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [LocalCode.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [invokeType](invoke-type.md) | [jvm]<br>fun [invokeType](invoke-type.md)(value: [InvokeType](../../-invoke-type/index.md)): [LocalCode.Builder](index.md)<br>See [LocalCode.invokeType](../invoke-type.md) |

## Properties

| Name | Summary |
|---|---|
| [declaration](declaration.md) | [jvm]<br>lateinit var [declaration](declaration.md): [MethodDeclaration](../../-method-declaration/index.md) |
| [declaringType](declaring-type.md) | [jvm]<br>lateinit var [declaringType](declaring-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [invokeType](invoke-type.md) | [jvm]<br>var [invokeType](invoke-type.md): [InvokeType](../../-invoke-type/index.md)? = null |
