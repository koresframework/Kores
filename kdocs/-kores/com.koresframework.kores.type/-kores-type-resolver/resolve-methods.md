//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[KoresTypeResolver](index.md)/[resolveMethods](resolve-methods.md)

# resolveMethods

[jvm]\
open fun [resolveMethods](resolve-methods.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): Either<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../com.koresframework.kores.base/-method-declaration/index.md)>>

Resolves or create a list of all [MethodDeclaration](../../com.koresframework.kores.base/-method-declaration/index.md) present in [type](resolve-methods.md).

The default implementation delegates the call to [resolveTypeDeclaration](resolve-type-declaration.md) and extract property value.
