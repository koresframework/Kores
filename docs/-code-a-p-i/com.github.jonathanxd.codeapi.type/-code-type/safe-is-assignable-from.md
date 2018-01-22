[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeType](index.md) / [safeIsAssignableFrom](.)

# safeIsAssignableFrom

`open fun safeIsAssignableFrom(type: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`
`open fun safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Returns `Either` that holds either failure exception or whether `this type` is assignable
from [type](safe-is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$safeIsAssignableFrom(java.lang.reflect.Type)/type).

