[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](index.md) / [resolveConstructors](.)

# resolveConstructors

`open fun resolveConstructors(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`

Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [type](resolve-constructors.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveConstructors(java.lang.reflect.Type)/type).

The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md)
and extract property value.

