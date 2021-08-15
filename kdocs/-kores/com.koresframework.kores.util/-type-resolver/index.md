//[Kores](../../../index.md)/[com.koresframework.kores.util](../index.md)/[TypeResolver](index.md)

# TypeResolver

[jvm]\
@[FunctionalInterface](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html)()

interface [TypeResolver](index.md)

Resolves a class name which may vary to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) and cache the resolved type.

## Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | [jvm]<br>abstract fun [resolve](resolve.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), isInterface: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Resolves type with [name](resolve.md) to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). |

## Inheritors

| Name |
|---|
| [SimpleResolver](../-simple-resolver/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [resolveClass](../resolve-class.md) | [jvm]<br>fun [TypeResolver](index.md).[resolveClass](../resolve-class.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Resolve type as class. |
| [resolveInterface](../resolve-interface.md) | [jvm]<br>fun [TypeResolver](index.md).[resolveInterface](../resolve-interface.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Resolve type as interface. |
| [resolveUnknown](../resolve-unknown.md) | [jvm]<br>fun [TypeResolver](index.md).[resolveUnknown](../resolve-unknown.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Resolve type as unknown, same as [resolveClass](../resolve-class.md) |
