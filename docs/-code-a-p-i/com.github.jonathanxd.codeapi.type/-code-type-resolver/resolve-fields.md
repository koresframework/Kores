[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](index.md) / [resolveFields](.)

# resolveFields

`open fun resolveFields(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`

Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [type](resolve-fields.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveFields(java.lang.reflect.Type)/type).

The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md)
and extract property value.

