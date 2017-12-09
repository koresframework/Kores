[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](index.md) / [resolveMethods](.)

# resolveMethods

`open fun resolveMethods(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`

Resolves or create a list of all [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [type](resolve-methods.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveMethods(java.lang.reflect.Type)/type).

The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md)
and extract property value.

