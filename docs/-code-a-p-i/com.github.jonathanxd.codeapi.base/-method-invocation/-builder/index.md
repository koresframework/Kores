[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodInvocation](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`MethodInvocation`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [invokeType](invoke-type.md) | `lateinit var invokeType: `[`InvokeType`](../../-invoke-type/index.md) |
| [spec](spec.md) | `lateinit var spec: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Builder`<br>See [T.array](#) |
| [build](build.md) | `fun build(): `[`MethodInvocation`](../index.md)<br>Build the object of type [T](#). |
| [invokeType](invoke-type.md) | `fun invokeType(value: `[`InvokeType`](../../-invoke-type/index.md)`): Builder`<br>See [MethodInvocation.invokeType](../invoke-type.md) |
| [localization](localization.md) | `fun localization(value: Type): Builder`<br>See [T.localization](#) |
| [spec](spec.md) | `fun spec(value: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [MethodInvocation.spec](../spec.md) |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../-arguments-holder/-builder/arguments.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`MethodInvocation`](../index.md)`): Builder` |
