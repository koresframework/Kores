//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.base.comment](../../../index.md)/[Link](../../index.md)/[LinkTarget](../index.md)/[Element](index.md)

# Element

[jvm]\
interface [Element](index.md) : [Link.LinkTarget](../index.md)

A link to an element

## Types

| Name | Summary |
|---|---|
| [Class](-class/index.md) | [jvm]<br>data class [Class](-class/index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Link.LinkTarget.Element](index.md)<br>A link to a class |
| [Field](-field/index.md) | [jvm]<br>data class [Field](-field/index.md)(**declaringClass**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Link.LinkTarget.Element](index.md)<br>A link to a field |
| [Method](-method/index.md) | [jvm]<br>data class [Method](-method/index.md)(**spec**: [MethodTypeSpec](../../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)) : [Link.LinkTarget.Element](index.md)<br>A link to a method |

## Inheritors

| Name |
|---|
| [Link.LinkTarget.Element](-class/index.md) |
| [Link.LinkTarget.Element](-method/index.md) |
| [Link.LinkTarget.Element](-field/index.md) |
