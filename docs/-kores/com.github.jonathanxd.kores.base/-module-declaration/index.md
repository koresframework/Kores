//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ModuleDeclaration](index.md)

# ModuleDeclaration

[jvm]\
data class [ModuleDeclaration](index.md)(**modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **version**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **requires**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Require](../-require/index.md)>, **exports**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Export](../-export/index.md)>, **opens**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Open](../-open/index.md)>, **uses**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)>, **provides**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Provide](../-provide/index.md)>) : [Named](../-named/index.md), [ModifiersHolder](../-modifiers-holder/index.md)

Declaration of a module.

## Constructors

| | |
|---|---|
| [ModuleDeclaration](-module-declaration.md) | [jvm]<br>fun [ModuleDeclaration](-module-declaration.md)(modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), version: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, requires: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Require](../-require/index.md)>, exports: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Export](../-export/index.md)>, opens: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Open](../-open/index.md)>, uses: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)>, provides: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Provide](../-provide/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[ModuleDeclaration](index.md), [ModuleDeclaration.Builder](-builder/index.md)> , [ModifiersHolder.Builder](../-modifiers-holder/-builder/index.md)<[ModuleDeclaration](index.md), [ModuleDeclaration.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ModuleDeclaration.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [exports](exports.md) | [jvm]<br>val [exports](exports.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Export](../-export/index.md)><br>Module exports. |
| [isPublic](index.md#-1840244568%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#-1840244568%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](modifiers.md) | [jvm]<br>open override val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers of the module. |
| [moduleReference](module-reference.md) | [jvm]<br>val [moduleReference](module-reference.md): [ModuleReference](../-module-reference/index.md)<br>Module reference. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Module name. |
| [opens](opens.md) | [jvm]<br>val [opens](opens.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Open](../-open/index.md)> |
| [provides](provides.md) | [jvm]<br>val [provides](provides.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Provide](../-provide/index.md)><br>Module service provides. |
| [requires](requires.md) | [jvm]<br>val [requires](requires.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Require](../-require/index.md)><br>Module requires. |
| [uses](uses.md) | [jvm]<br>val [uses](uses.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../-module-reference/index.md)><br>Module service uses. |
| [version](version.md) | [jvm]<br>val [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Module version. |
