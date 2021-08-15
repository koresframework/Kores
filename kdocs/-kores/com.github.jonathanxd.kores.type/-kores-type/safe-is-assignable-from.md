//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[KoresType](index.md)/[safeIsAssignableFrom](safe-is-assignable-from.md)

# safeIsAssignableFrom

[jvm]\
open fun [safeIsAssignableFrom](safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>

open fun [safeIsAssignableFrom](safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>

Returns Either that holds either failure exception or whether this type is assignable from [type](safe-is-assignable-from.md).
