//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Alias](index.md)

# Alias

[jvm]\
sealed class [Alias](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Type alias. They are only supported in specific contexts, which depends on the generator.

This commonly is used when you want to invoke methods, access fields, etc... of current class, super class or super interface, but you don't have access to this information.

#  In Java

Type alias does not exists in Java language (because you always have access to this information), but would be something like: this.class, super.class.

## Types

| Name | Summary |
|---|---|
| [INTERFACE](-i-n-t-e-r-f-a-c-e/index.md) | [jvm]<br>data class [INTERFACE](-i-n-t-e-r-f-a-c-e/index.md)(**n**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)<br>Interface extension localization. |
| [SUPER](-s-u-p-e-r/index.md) | [jvm]<br>object [SUPER](-s-u-p-e-r/index.md) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)<br>Super class localization**Must be manually handled.** |
| [THIS](-t-h-i-s/index.md) | [jvm]<br>object [THIS](-t-h-i-s/index.md) : [Alias](index.md), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)<br>Current class localization. |

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [resolve](resolve.md) | [jvm]<br>abstract fun [resolve](resolve.md)(declaration: [TypeDeclaration](../-type-declaration/index.md)): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Called with current type declaration (the class that contains the alias) to resolve the real type. |

## Inheritors

| Name |
|---|
| [Alias](-t-h-i-s/index.md) |
| [Alias](-s-u-p-e-r/index.md) |
| [Alias](-i-n-t-e-r-f-a-c-e/index.md) |
