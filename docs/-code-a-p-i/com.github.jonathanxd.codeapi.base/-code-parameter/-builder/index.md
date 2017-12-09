[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [CodeParameter](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`CodeParameter`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`CodeParameter`](../index.md)`, Builder>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`CodeParameter`](../index.md)`, Builder>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`CodeParameter`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`CodeParameter`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `lateinit var type: Type` |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>`fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`CodeParameter`](../index.md)<br>Build the object of type [T](#). |
| [modifiers](modifiers.md) | `fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all [ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`CodeParameter`](../index.md)`): Builder` |
