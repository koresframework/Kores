//[Kores](../../../index.md)/[com.github.jonathanxd.kores.util](../index.md)/[GenericTypeVariable](index.md)

# GenericTypeVariable

[jvm]\
class [GenericTypeVariable](index.md) : [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<[GenericDeclaration](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/GenericDeclaration.html)> 

Wrapper of [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) to [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html). This class is a little complex and is not intended to be used by external sources.

## Constructors

| | |
|---|---|
| [GenericTypeVariable](-generic-type-variable.md) | [jvm]<br>fun [GenericTypeVariable](-generic-type-variable.md)(type: [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)?, wrapped: [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<out [GenericDeclaration](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/GenericDeclaration.html)>?, bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>) |
| [GenericTypeVariable](-generic-type-variable.md) | [jvm]<br>fun [GenericTypeVariable](-generic-type-variable.md)(type: [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)?, wrapped: [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<out [GenericDeclaration](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/GenericDeclaration.html)>?, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>) |
| [GenericTypeVariable](-generic-type-variable.md) | [jvm]<br>fun [GenericTypeVariable](-generic-type-variable.md)(type: [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)?, wrappedType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>) |

## Functions

| Name | Summary |
|---|---|
| [getAnnotatedBounds](get-annotated-bounds.md) | [jvm]<br>open override fun [getAnnotatedBounds](get-annotated-bounds.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[AnnotatedType](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/AnnotatedType.html)> |
| [getAnnotation](get-annotation.md) | [jvm]<br>open override fun <[T](get-annotation.md) : [Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> [getAnnotation](get-annotation.md)(annotationClass: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](get-annotation.md)>): [T](get-annotation.md)? |
| [getAnnotations](get-annotations.md) | [jvm]<br>open override fun [getAnnotations](get-annotations.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> |
| [getAnnotationsByType](index.md#-1447628347%2FFunctions%2F-1216412040) | [jvm]<br>open fun <[T](index.md#-1447628347%2FFunctions%2F-1216412040) : [Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> [getAnnotationsByType](index.md#-1447628347%2FFunctions%2F-1216412040)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](index.md#-1447628347%2FFunctions%2F-1216412040)>): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[T](index.md#-1447628347%2FFunctions%2F-1216412040)> |
| [getBounds](get-bounds.md) | [jvm]<br>open override fun [getBounds](get-bounds.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
| [getDeclaredAnnotation](index.md#1665372079%2FFunctions%2F-1216412040) | [jvm]<br>open fun <[T](index.md#1665372079%2FFunctions%2F-1216412040) : [Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> [getDeclaredAnnotation](index.md#1665372079%2FFunctions%2F-1216412040)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](index.md#1665372079%2FFunctions%2F-1216412040)>): [T](index.md#1665372079%2FFunctions%2F-1216412040) |
| [getDeclaredAnnotations](get-declared-annotations.md) | [jvm]<br>open override fun [getDeclaredAnnotations](get-declared-annotations.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> |
| [getDeclaredAnnotationsByType](index.md#-815528673%2FFunctions%2F-1216412040) | [jvm]<br>open fun <[T](index.md#-815528673%2FFunctions%2F-1216412040) : [Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)> [getDeclaredAnnotationsByType](index.md#-815528673%2FFunctions%2F-1216412040)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](index.md#-815528673%2FFunctions%2F-1216412040)>): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[T](index.md#-815528673%2FFunctions%2F-1216412040)> |
| [getGenericDeclaration](get-generic-declaration.md) | [jvm]<br>open override fun [getGenericDeclaration](get-generic-declaration.md)(): [GenericDeclaration](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/GenericDeclaration.html)? |
| [getName](get-name.md) | [jvm]<br>open override fun [getName](get-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getTypeName](get-type-name.md) | [jvm]<br>open override fun [getTypeName](get-type-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isAnnotationPresent](index.md#-766309624%2FFunctions%2F-1216412040) | [jvm]<br>open fun [isAnnotationPresent](index.md#-766309624%2FFunctions%2F-1216412040)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [jvm]<br>val [type](type.md): [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)? |
