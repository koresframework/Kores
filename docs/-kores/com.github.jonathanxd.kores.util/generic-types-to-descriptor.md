//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[genericTypesToDescriptor](generic-types-to-descriptor.md)

# genericTypesToDescriptor

[jvm]\
fun [genericTypesToDescriptor](generic-types-to-descriptor.md)(typeDeclaration: [TypeDeclaration](../com.github.jonathanxd.kores.base/-type-declaration/index.md), superClass: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), implementations: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, superClassIsGeneric: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), anyInterfaceIsGeneric: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?

Create a type descriptor from [typeDeclaration](generic-types-to-descriptor.md) signature.

[jvm]\
fun [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)>.[genericTypesToDescriptor](generic-types-to-descriptor.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Create a type descriptor from receiver array.
