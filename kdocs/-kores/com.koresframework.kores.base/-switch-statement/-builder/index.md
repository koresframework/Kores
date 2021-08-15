//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[SwitchStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[SwitchStatement](../index.md), [SwitchStatement.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[SwitchStatement](../index.md), [SwitchStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [SwitchStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [SwitchStatement](../index.md)<br>Build the object of type T. |
| [cases](cases.md) | [jvm]<br>fun [cases](cases.md)(vararg values: [Case](../../-case/index.md)): [SwitchStatement.Builder](index.md)<br>fun [cases](cases.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../../-case/index.md)>): [SwitchStatement.Builder](index.md)<br>See [SwitchStatement.cases](../cases.md) |
| [switchType](switch-type.md) | [jvm]<br>fun [switchType](switch-type.md)(value: [SwitchType](../../-switch-type/index.md)): [SwitchStatement.Builder](index.md)<br>See [SwitchStatement.switchType](../switch-type.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [SwitchStatement.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [SwitchStatement.Builder](index.md)<br>See [SwitchStatement.value](../value.md) |

## Properties

| Name | Summary |
|---|---|
| [cases](cases.md) | [jvm]<br>var [cases](cases.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../../-case/index.md)> |
| [switchType](switch-type.md) | [jvm]<br>lateinit var [switchType](switch-type.md): [SwitchType](../../-switch-type/index.md) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
