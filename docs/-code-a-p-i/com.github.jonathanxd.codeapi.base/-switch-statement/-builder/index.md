[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [SwitchStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`SwitchStatement`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`SwitchStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`SwitchStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [cases](cases.md) | `var cases: List<`[`Case`](../../-case/index.md)`>` |
| [switchType](switch-type.md) | `lateinit var switchType: `[`SwitchType`](../../-switch-type/index.md) |
| [value](value.md) | `lateinit var value: `[`Typed`](../../-typed/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`SwitchStatement`](../index.md)<br>Build the object of type [T](#). |
| [withCases](with-cases.md) | `fun withCases(value: List<`[`Case`](../../-case/index.md)`>): Builder`<br>`fun withCases(vararg values: `[`Case`](../../-case/index.md)`): Builder`<br>See [SwitchStatement.cases](../cases.md) |
| [withSwitchType](with-switch-type.md) | `fun withSwitchType(value: `[`SwitchType`](../../-switch-type/index.md)`): Builder`<br>See [SwitchStatement.switchType](../switch-type.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#)`fun withValue(value: `[`Typed`](../../-typed/index.md)`): Builder`<br>See [SwitchStatement.value](../value.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`SwitchStatement`](../index.md)`): Builder` |
