//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[BindedTypeResolver](index.md)

# BindedTypeResolver

[jvm]\
class [BindedTypeResolver](index.md)<out [T](index.md)>(**bindType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **koresTypeResolver**: [KoresTypeResolver](../-kores-type-resolver/index.md)<[T](index.md)>)

A type resolver 'binded' to a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). All functions delegates to [koresTypeResolver](kores-type-resolver.md) and uses [bindType](bind-type.md) as first argument of functions.

## Constructors

| | |
|---|---|
| [BindedTypeResolver](-binded-type-resolver.md) | [jvm]<br>fun <out [T](index.md)> [BindedTypeResolver](-binded-type-resolver.md)(bindType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), koresTypeResolver: [KoresTypeResolver](../-kores-type-resolver/index.md)<[T](index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [bindTo](bind-to.md) | [jvm]<br>fun [bindTo](bind-to.md)(bindedType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [BindedTypeResolver](index.md)<[T](index.md)><br>Creates a new [BindedTypeResolver](index.md) instance 'binded' to [bindType](bind-type.md). |
| [bindToResolver](bind-to-resolver.md) | [jvm]<br>fun <[T](bind-to-resolver.md)> [bindToResolver](bind-to-resolver.md)(codeTypeResolver: [KoresTypeResolver](../-kores-type-resolver/index.md)<[T](bind-to-resolver.md)>): [BindedTypeResolver](index.md)<[T](bind-to-resolver.md)><br>Creates a new [BindedTypeResolver](index.md) instance which delegate calls to [codeTypeResolver](bind-to-resolver.md). |
| [getInterfaces](get-interfaces.md) | [jvm]<br>fun [getInterfaces](get-interfaces.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>><br>Resolves super interfaces of [bindType](bind-type.md). |
| [getSuperclass](get-superclass.md) | [jvm]<br>fun [getSuperclass](get-superclass.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?><br>Resolves super class of [bindType](bind-type.md) |
| [isAssignableFrom](is-assignable-from.md) | [jvm]<br>fun [isAssignableFrom](is-assignable-from.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md) using default resolvers.<br>[jvm]<br>fun [isAssignableFrom](is-assignable-from.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Checks if [bindType](bind-type.md) is assignable [from](is-assignable-from.md) using resolvers provided by [resolverProvider](is-assignable-from.md) |
| [resolve](resolve.md) | [jvm]<br>fun [resolve](resolve.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), out [T](index.md)><br>Resolves [bindType](bind-type.md) to [T](index.md) |
| [resolveConstructors](resolve-constructors.md) | [jvm]<br>fun [resolveConstructors](resolve-constructors.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md)>><br>Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.kores.base/-constructor-declaration/index.md) present in bindedType  (back call to [koresTypeResolver](kores-type-resolver.md)). |
| [resolveFields](resolve-fields.md) | [jvm]<br>fun [resolveFields](resolve-fields.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../com.github.jonathanxd.kores.base/-field-declaration/index.md)>><br>Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.kores.base/-field-declaration/index.md) present in bindedType (back call to [koresTypeResolver](kores-type-resolver.md)). |
| [resolveMethods](resolve-methods.md) | [jvm]<br>fun [resolveMethods](resolve-methods.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../com.github.jonathanxd.kores.base/-method-declaration/index.md)>><br>Resolves or create a list of all [MethodDeclaration](../../com.github.jonathanxd.kores.base/-method-declaration/index.md) present in bindedType (back call to [koresTypeResolver](kores-type-resolver.md)). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | [jvm]<br>fun [resolveTypeDeclaration](resolve-type-declaration.md)(): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [TypeDeclaration](../../com.github.jonathanxd.kores.base/-type-declaration/index.md)><br>Resolves or create [TypeDeclaration](../../com.github.jonathanxd.kores.base/-type-declaration/index.md) from bindedType structure and elements (back call to [koresTypeResolver](kores-type-resolver.md)). |

## Properties

| Name | Summary |
|---|---|
| [bindType](bind-type.md) | [jvm]<br>val [bindType](bind-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [koresTypeResolver](kores-type-resolver.md) | [jvm]<br>val [koresTypeResolver](kores-type-resolver.md): [KoresTypeResolver](../-kores-type-resolver/index.md)<[T](index.md)> |
