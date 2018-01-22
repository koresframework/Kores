[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.common](../../index.md) / [DynamicMethodSpec](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<`[`DynamicMethodSpec`](../index.md)`, Builder>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-named/-builder/index.md)`<`[`DynamicMethodSpec`](../index.md)`, Builder>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/index.md)`<`[`DynamicMethodSpec`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`DynamicMethodSpec`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeSpec](type-spec.md) | `lateinit var typeSpec: `[`TypeSpec`](../../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Builder`<br>See [T.array](#) |
| [build](build.md) | `fun build(): `[`DynamicMethodSpec`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [typeSpec](type-spec.md) | `fun typeSpec(value: `[`TypeSpec`](../../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`): Builder`<br>See [DynamicMethodSpec.typeSpec](../type-spec.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/arguments.md) |
