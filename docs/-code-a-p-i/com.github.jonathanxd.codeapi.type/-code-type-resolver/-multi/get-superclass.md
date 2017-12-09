[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Multi](index.md) / [getSuperclass](.)

# getSuperclass

`fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`

Overrides [CodeTypeResolver.getSuperclass](../get-superclass.md)

First non-null and [non-nothing](../../../com.github.jonathanxd.codeapi.common/-code-nothing.md) value is returned, or `null` if no
valid value was found.

