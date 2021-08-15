//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[KoresTypeResolver](../index.md)/[CommonResolver](index.md)

# CommonResolver

[jvm]\
abstract class [CommonResolver](index.md)<out [T](index.md)> : [KoresTypeResolver](../index.md)<[T](index.md)> 

Common implementation of resolver.

## Constructors

| | |
|---|---|
| [CommonResolver](-common-resolver.md) | [jvm]<br>fun [CommonResolver](-common-resolver.md)() |

## Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | [jvm]<br>open override fun [getInterfaces](get-interfaces.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>><br>Resolves super interfaces of [type](get-interfaces.md). |
| [getSuperclass](get-superclass.md) | [jvm]<br>open override fun [getSuperclass](get-superclass.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?><br>Resolves super class of [type](get-superclass.md). |
| [isAssignableFrom](../is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](../is-assignable-from.md) is assignable from [from](../is-assignable-from.md) using default resolvers.<br>[jvm]<br>open override fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](is-assignable-from.md) is assignable [from](is-assignable-from.md) using resolvers provided by [resolverProvider](is-assignable-from.md) |
| [resolve](../resolve.md) | [jvm]<br>abstract fun [resolve](../resolve.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), out [T](index.md)><br>Resolves [type](../resolve.md) to [T](../index.md) |
| [resolveConstructors](../resolve-constructors.md) | [jvm]<br>open fun [resolveConstructors](../resolve-constructors.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../../com.koresframework.kores.base/-constructor-declaration/index.md)>><br>Resolves or create a list of all [ConstructorDeclaration](../../../com.koresframework.kores.base/-constructor-declaration/index.md) present in [type](../resolve-constructors.md). |
| [resolveFields](../resolve-fields.md) | [jvm]<br>open fun [resolveFields](../resolve-fields.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../../com.koresframework.kores.base/-field-declaration/index.md)>><br>Resolves or create a list of all [FieldDeclaration](../../../com.koresframework.kores.base/-field-declaration/index.md) present in [type](../resolve-fields.md). |
| [resolveMethods](../resolve-methods.md) | [jvm]<br>open fun [resolveMethods](../resolve-methods.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../../com.koresframework.kores.base/-method-declaration/index.md)>><br>Resolves or create a list of all [MethodDeclaration](../../../com.koresframework.kores.base/-method-declaration/index.md) present in [type](../resolve-methods.md). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | [jvm]<br>open override fun [resolveTypeDeclaration](resolve-type-declaration.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [TypeDeclaration](../../../com.koresframework.kores.base/-type-declaration/index.md)><br>Resolves or create [TypeDeclaration](../../../com.koresframework.kores.base/-type-declaration/index.md) from [type](resolve-type-declaration.md) structure and elements. |

## Inheritors

| Name |
|---|
| [KoresTypeResolver](../-java/index.md) |
| [KoresTypeResolver](../-model/index.md) |
| [KoresTypeResolver](../-default-resolver/index.md) |
| [KoresTypeResolver](../-kores/index.md) |
