[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ModuleDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`ModuleDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`ModuleDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ModuleDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [exports](exports.md) | `var exports: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Export`](../../-export/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [opens](opens.md) | `var opens: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Open`](../../-open/index.md)`>` |
| [provides](provides.md) | `var provides: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Provide`](../../-provide/index.md)`>` |
| [requires](requires.md) | `var requires: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Require`](../../-require/index.md)`>` |
| [uses](uses.md) | `var uses: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ModuleReference`](../../-module-reference/index.md)`>` |
| [version](version.md) | `var version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ModuleDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [exports](exports.md) | `fun exports(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Export`](../../-export/index.md)`>): Builder`<br>`fun exports(vararg values: `[`Export`](../../-export/index.md)`): Builder`<br>`fun exports(vararg values: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [ModuleDeclaration.exports](../exports.md) |
| [modifiers](modifiers.md) | `fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [opens](opens.md) | `fun opens(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Open`](../../-open/index.md)`>): Builder`<br>`fun opens(vararg values: `[`Open`](../../-open/index.md)`): Builder`<br>`fun opens(vararg values: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [ModuleDeclaration.opens](../opens.md) |
| [provides](provides.md) | `fun provides(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Provide`](../../-provide/index.md)`>): Builder`<br>`fun provides(vararg values: `[`Provide`](../../-provide/index.md)`): Builder`<br>`fun provides(vararg values: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<Type, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>): Builder`<br>See [ModuleDeclaration.provides](../provides.md) |
| [requires](requires.md) | `fun requires(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Require`](../../-require/index.md)`>): Builder`<br>`fun requires(vararg values: `[`Require`](../../-require/index.md)`): Builder`<br>`fun requires(vararg values: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [ModuleDeclaration.requires](../requires.md) |
| [uses](uses.md) | `fun uses(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ModuleReference`](../../-module-reference/index.md)`>): Builder`<br>`fun uses(vararg values: `[`ModuleReference`](../../-module-reference/index.md)`): Builder`<br>`fun uses(vararg values: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [ModuleDeclaration.uses](../uses.md) |
| [version](version.md) | `fun version(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [ModuleDeclaration.version](../version.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all [ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ModuleDeclaration`](../index.md)`): Builder` |
