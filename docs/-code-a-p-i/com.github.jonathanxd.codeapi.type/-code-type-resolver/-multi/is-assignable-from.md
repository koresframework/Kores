[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Multi](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Overrides [CodeTypeResolver.isAssignableFrom](../is-assignable-from.md)

Returns true if any resolver returns true for this operation.

