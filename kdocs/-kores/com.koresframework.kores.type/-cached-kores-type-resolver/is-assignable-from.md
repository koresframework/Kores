//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[CachedKoresTypeResolver](index.md)/[isAssignableFrom](is-assignable-from.md)

# isAssignableFrom

[jvm]\
open override fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>

Checks if [type](is-assignable-from.md) is assignable [from](is-assignable-from.md) using resolvers provided by [resolverProvider](is-assignable-from.md)

#### Return

True if [type](is-assignable-from.md) is assignable from [from](is-assignable-from.md).
