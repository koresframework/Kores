//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[KoresTypeResolver](../index.md)/[Multi](index.md)

# Multi

[jvm]\
class [Multi](index.md)<[T](index.md)> : [KoresTypeResolver](../index.md)<[T](index.md)?> 

This is a resolver which support multiple resolvers. This resolver always returns first **valid resolved value** for each operation.

A valid resolved value depends on operations, see documentation.

## Constructors

| | |
|---|---|
| [Multi](-multi.md) | [jvm]<br>fun [Multi](-multi.md)() |

## Functions

| Name | Summary |
|---|---|
| [addResolver](add-resolver.md) | [jvm]<br>fun [addResolver](add-resolver.md)(resolver: [KoresTypeResolver](../index.md)<[T](index.md)?>)<br>Adds a resolver |
| [getInterfaces](get-interfaces.md) | [jvm]<br>open override fun [getInterfaces](get-interfaces.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>><br>First bigger list is returned. |
| [getSuperclass](get-superclass.md) | [jvm]<br>open override fun [getSuperclass](get-superclass.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?><br>First non-null and [non-nothing](../../../com.koresframework.kores.common/index.md#-1539736051%2FClasslikes%2F-1216412040) value is returned, or null if no valid value was found. |
| [isAssignableFrom](../is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](../is-assignable-from.md) is assignable from [from](../is-assignable-from.md) using default resolvers.<br>[jvm]<br>open override fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Returns true if any resolver returns true for this operation. |
| [minusAssign](minus-assign.md) | [jvm]<br>operator fun [minusAssign](minus-assign.md)(resolver: [KoresTypeResolver](../index.md)<[T](index.md)?>)<br>Removes a resolver |
| [plusAssign](plus-assign.md) | [jvm]<br>operator fun [plusAssign](plus-assign.md)(resolver: [KoresTypeResolver](../index.md)<[T](index.md)?>)<br>Adds a resolver |
| [removeResolver](remove-resolver.md) | [jvm]<br>fun [removeResolver](remove-resolver.md)(resolver: [KoresTypeResolver](../index.md)<[T](index.md)?>)<br>Removes a resolver |
| [resolve](resolve.md) | [jvm]<br>open override fun [resolve](resolve.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), out [T](index.md)?><br>First non-null and [non-nothing](../../../com.koresframework.kores.common/index.md#-1539736051%2FClasslikes%2F-1216412040) value is returned, or null if no valid value was found. |
| [resolveConstructors](../resolve-constructors.md) | [jvm]<br>open fun [resolveConstructors](../resolve-constructors.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../../com.koresframework.kores.base/-constructor-declaration/index.md)>><br>Resolves or create a list of all [ConstructorDeclaration](../../../com.koresframework.kores.base/-constructor-declaration/index.md) present in [type](../resolve-constructors.md). |
| [resolveFields](../resolve-fields.md) | [jvm]<br>open fun [resolveFields](../resolve-fields.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../../com.koresframework.kores.base/-field-declaration/index.md)>><br>Resolves or create a list of all [FieldDeclaration](../../../com.koresframework.kores.base/-field-declaration/index.md) present in [type](../resolve-fields.md). |
| [resolveMethods](../resolve-methods.md) | [jvm]<br>open fun [resolveMethods](../resolve-methods.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../../com.koresframework.kores.base/-method-declaration/index.md)>><br>Resolves or create a list of all [MethodDeclaration](../../../com.koresframework.kores.base/-method-declaration/index.md) present in [type](../resolve-methods.md). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | [jvm]<br>open override fun [resolveTypeDeclaration](resolve-type-declaration.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [TypeDeclaration](../../../com.koresframework.kores.base/-type-declaration/index.md)><br>Resolves or create [TypeDeclaration](../../../com.koresframework.kores.base/-type-declaration/index.md) from [type](resolve-type-declaration.md) structure and elements. |
