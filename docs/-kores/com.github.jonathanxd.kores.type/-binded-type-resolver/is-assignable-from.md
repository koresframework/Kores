//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[BindedTypeResolver](index.md)/[isAssignableFrom](is-assignable-from.md)

# isAssignableFrom

[jvm]\
fun [isAssignableFrom](is-assignable-from.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>

Checks if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md) using default resolvers.

#### Return

True if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md).

[jvm]\
fun [isAssignableFrom](is-assignable-from.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)>

Checks if [bindType](bind-type.md) is assignable [from](is-assignable-from.md) using resolvers provided by [resolverProvider](is-assignable-from.md)

#### Return

True if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md).
