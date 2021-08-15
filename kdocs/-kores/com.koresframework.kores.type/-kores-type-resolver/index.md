//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[KoresTypeResolver](index.md)

# KoresTypeResolver

[jvm]\
interface [KoresTypeResolver](index.md)<out [T](index.md)>

Type resolver. Type resolvers should never throws an error when it is unable to resolve result of an operation. The operation should return an Either instance which contains either the exception describing fail of resolution or the result of resolution.

## Types

| Name | Summary |
|---|---|
| [CommonResolver](-common-resolver/index.md) | [jvm]<br>abstract class [CommonResolver](-common-resolver/index.md)<out [T](-common-resolver/index.md)> : [KoresTypeResolver](index.md)<[T](-common-resolver/index.md)> <br>Common implementation of resolver. |
| [DefaultResolver](-default-resolver/index.md) | [jvm]<br>object [DefaultResolver](-default-resolver/index.md) : [KoresTypeResolver.CommonResolver](-common-resolver/index.md)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> <br>Default resolver that returns the same instance for [resolve](-default-resolver/resolve.md) method. |
| [Java](-java/index.md) | [jvm]<br>class [Java](-java/index.md)(**classLoader**: [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html)) : [KoresTypeResolver.CommonResolver](-common-resolver/index.md)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>> <br>Resolver that resolves [KoresType](../-kores-type/index.md) to Java [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html). |
| [Kores](-kores/index.md) | [jvm]<br>class [Kores](-kores/index.md)(**resolverFunc**: [KoresTypeResolverFunc](../../com.koresframework.kores.util/-kores-type-resolver-func/index.md)?) : [KoresTypeResolver.CommonResolver](-common-resolver/index.md)<[TypeDeclaration](../../com.koresframework.kores.base/-type-declaration/index.md)?> <br>Kores Resolver. |
| [Model](-model/index.md) | [jvm]<br>class [Model](-model/index.md)(**elements**: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)) : [KoresTypeResolver.CommonResolver](-common-resolver/index.md)<[TypeElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/TypeElement.html)?> <br>Resolver that resolves [KoresType](../-kores-type/index.md) to Javax Model [TypeElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/TypeElement.html), or to null if type cannot be found. |
| [Multi](-multi/index.md) | [jvm]<br>class [Multi](-multi/index.md)<[T](-multi/index.md)> : [KoresTypeResolver](index.md)<[T](-multi/index.md)?> <br>This is a resolver which support multiple resolvers. |
| [Two](-two/index.md) | [jvm]<br>class [Two](-two/index.md)<out [A](-two/index.md) : [X](-two/index.md), out [B](-two/index.md) : [X](-two/index.md), out [X](-two/index.md)>(**first**: [KoresTypeResolver](index.md)<[A](-two/index.md)>, **second**: [KoresTypeResolver](index.md)<[B](-two/index.md)>) : [KoresTypeResolver](index.md)<[X](-two/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | [jvm]<br>abstract fun [getInterfaces](get-interfaces.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>><br>Resolves super interfaces of [type](get-interfaces.md). |
| [getSuperclass](get-superclass.md) | [jvm]<br>abstract fun [getSuperclass](get-superclass.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?><br>Resolves super class of [type](get-superclass.md). |
| [isAssignableFrom](is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](is-assignable-from.md) is assignable from [from](is-assignable-from.md) using default resolvers.<br>[jvm]<br>abstract fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [type](is-assignable-from.md) is assignable [from](is-assignable-from.md) using resolvers provided by [resolverProvider](is-assignable-from.md) |
| [resolve](resolve.md) | [jvm]<br>abstract fun [resolve](resolve.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), out [T](index.md)><br>Resolves [type](resolve.md) to [T](index.md) |
| [resolveConstructors](resolve-constructors.md) | [jvm]<br>open fun [resolveConstructors](resolve-constructors.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../com.koresframework.kores.base/-constructor-declaration/index.md)>><br>Resolves or create a list of all [ConstructorDeclaration](../../com.koresframework.kores.base/-constructor-declaration/index.md) present in [type](resolve-constructors.md). |
| [resolveFields](resolve-fields.md) | [jvm]<br>open fun [resolveFields](resolve-fields.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../com.koresframework.kores.base/-field-declaration/index.md)>><br>Resolves or create a list of all [FieldDeclaration](../../com.koresframework.kores.base/-field-declaration/index.md) present in [type](resolve-fields.md). |
| [resolveMethods](resolve-methods.md) | [jvm]<br>open fun [resolveMethods](resolve-methods.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../com.koresframework.kores.base/-method-declaration/index.md)>><br>Resolves or create a list of all [MethodDeclaration](../../com.koresframework.kores.base/-method-declaration/index.md) present in [type](resolve-methods.md). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | [jvm]<br>abstract fun [resolveTypeDeclaration](resolve-type-declaration.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [TypeDeclaration](../../com.koresframework.kores.base/-type-declaration/index.md)><br>Resolves or create [TypeDeclaration](../../com.koresframework.kores.base/-type-declaration/index.md) from [type](resolve-type-declaration.md) structure and elements. |

## Inheritors

| Name |
|---|
| [CachedKoresTypeResolver](../-cached-kores-type-resolver/index.md) |
| [KoresTypeResolver](-common-resolver/index.md) |
| [KoresTypeResolver](-multi/index.md) |
| [KoresTypeResolver](-two/index.md) |
