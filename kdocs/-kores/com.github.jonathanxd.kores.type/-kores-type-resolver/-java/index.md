//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[KoresTypeResolver](../index.md)/[Java](index.md)

# Java

[jvm]\
class [Java](index.md)(**classLoader**: [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html)) : [KoresTypeResolver.CommonResolver](../-common-resolver/index.md)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>> 

Resolver that resolves [KoresType](../../-kores-type/index.md) to Java [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html). This may resolve to KoresNothing.type is class loader fails to find class.

## Constructors

| | |
|---|---|
| [Java](-java.md) | [jvm]<br>fun [Java](-java.md)(classLoader: [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html)) |

## Functions

| Name | Summary |
|---|---|
| [getInterfaces](../-common-resolver/get-interfaces.md) | [jvm]<br>open override fun [getInterfaces](../-common-resolver/get-interfaces.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>><br>Resolves super interfaces of [type](../-common-resolver/get-interfaces.md). |
| [getSuperclass](../-common-resolver/get-superclass.md) | [jvm]<br>open override fun [getSuperclass](../-common-resolver/get-superclass.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?><br>Resolves super class of [type](../-common-resolver/get-superclass.md). |
| [isAssignableFrom](../is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](../is-assignable-from.md) is assignable from [from](../is-assignable-from.md) using default resolvers.<br>[jvm]<br>open override fun [isAssignableFrom](../-common-resolver/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](../-common-resolver/is-assignable-from.md) is assignable [from](../-common-resolver/is-assignable-from.md) using resolvers provided by [resolverProvider](../-common-resolver/is-assignable-from.md) |
| [resolve](resolve.md) | [jvm]<br>open override fun [resolve](resolve.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), out [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>><br>Resolves [type](resolve.md) to [T](../index.md) |
| [resolveConstructors](../resolve-constructors.md) | [jvm]<br>open fun [resolveConstructors](../resolve-constructors.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md)>><br>Resolves or create a list of all [ConstructorDeclaration](../../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md) present in [type](../resolve-constructors.md). |
| [resolveFields](../resolve-fields.md) | [jvm]<br>open fun [resolveFields](../resolve-fields.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../../com.github.jonathanxd.kores.base/-field-declaration/index.md)>><br>Resolves or create a list of all [FieldDeclaration](../../../com.github.jonathanxd.kores.base/-field-declaration/index.md) present in [type](../resolve-fields.md). |
| [resolveMethods](../resolve-methods.md) | [jvm]<br>open fun [resolveMethods](../resolve-methods.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../../com.github.jonathanxd.kores.base/-method-declaration/index.md)>><br>Resolves or create a list of all [MethodDeclaration](../../../com.github.jonathanxd.kores.base/-method-declaration/index.md) present in [type](../resolve-methods.md). |
| [resolveTypeDeclaration](../-common-resolver/resolve-type-declaration.md) | [jvm]<br>open override fun [resolveTypeDeclaration](../-common-resolver/resolve-type-declaration.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [TypeDeclaration](../../../com.github.jonathanxd.kores.base/-type-declaration/index.md)><br>Resolves or create [TypeDeclaration](../../../com.github.jonathanxd.kores.base/-type-declaration/index.md) from [type](../-common-resolver/resolve-type-declaration.md) structure and elements. |

## Properties

| Name | Summary |
|---|---|
| [classLoader](class-loader.md) | [jvm]<br>val [classLoader](class-loader.md): [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html) |
