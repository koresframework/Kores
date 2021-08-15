//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ModuleDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Named.Builder](../../-named/-builder/index.md)<[ModuleDeclaration](../index.md), [ModuleDeclaration.Builder](index.md)> , [ModifiersHolder.Builder](../../-modifiers-holder/-builder/index.md)<[ModuleDeclaration](../index.md), [ModuleDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ModuleDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ModuleDeclaration](../index.md)<br>Build the object of type T. |
| [exports](exports.md) | [jvm]<br>fun [exports](exports.md)(vararg values: [Export](../../-export/index.md)): [ModuleDeclaration.Builder](index.md)<br>fun [exports](exports.md)(vararg values: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md)<br>fun [exports](exports.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Export](../../-export/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.exports](../exports.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | [jvm]<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [ModuleDeclaration.Builder](index.md)<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md) |
| [opens](opens.md) | [jvm]<br>fun [opens](opens.md)(vararg values: [Open](../../-open/index.md)): [ModuleDeclaration.Builder](index.md)<br>fun [opens](opens.md)(vararg values: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md)<br>fun [opens](opens.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Open](../../-open/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.opens](../opens.md) |
| [provides](provides.md) | [jvm]<br>fun [provides](provides.md)(vararg values: [Provide](../../-provide/index.md)): [ModuleDeclaration.Builder](index.md)<br>fun [provides](provides.md)(vararg values: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>>): [ModuleDeclaration.Builder](index.md)<br>fun [provides](provides.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Provide](../../-provide/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.provides](../provides.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [ModuleDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [requires](requires.md) | [jvm]<br>fun [requires](requires.md)(vararg values: [Require](../../-require/index.md)): [ModuleDeclaration.Builder](index.md)<br>fun [requires](requires.md)(vararg values: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md)<br>fun [requires](requires.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Require](../../-require/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.requires](../requires.md) |
| [uses](uses.md) | [jvm]<br>fun [uses](uses.md)(vararg values: [ModuleReference](../../-module-reference/index.md)): [ModuleDeclaration.Builder](index.md)<br>fun [uses](uses.md)(vararg values: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md)<br>fun [uses](uses.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../../-module-reference/index.md)>): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.uses](../uses.md) |
| [version](version.md) | [jvm]<br>fun [version](version.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ModuleDeclaration.Builder](index.md)<br>See [ModuleDeclaration.version](../version.md) |

## Properties

| Name | Summary |
|---|---|
| [exports](exports.md) | [jvm]<br>var [exports](exports.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Export](../../-export/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [opens](opens.md) | [jvm]<br>var [opens](opens.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Open](../../-open/index.md)> |
| [provides](provides.md) | [jvm]<br>var [provides](provides.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Provide](../../-provide/index.md)> |
| [requires](requires.md) | [jvm]<br>var [requires](requires.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Require](../../-require/index.md)> |
| [uses](uses.md) | [jvm]<br>var [uses](uses.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ModuleReference](../../-module-reference/index.md)> |
| [version](version.md) | [jvm]<br>var [version](version.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
