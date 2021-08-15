//[Kores](../../index.md)/[com.koresframework.kores.util.conversion](index.md)/[toStructure](to-structure.md)

# toStructure

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun <[T](to-structure.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](to-structure.md)>.[toStructure](to-structure.md)(includeFields: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, includeMethods: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, includeSubClasses: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md)>

Convert this [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) structure to [TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md)s (first element is the input class, other elements is inner-classes).

#### Return

[TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md) structure from [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html).

## Parameters

jvm

| | |
|---|---|
| includeFields | True to include fields. |
| includeMethods | True to include methods. |
| includeSubClasses | True to include sub classes. |
