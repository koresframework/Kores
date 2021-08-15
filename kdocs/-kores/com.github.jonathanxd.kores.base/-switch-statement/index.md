//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[SwitchStatement](index.md)

# SwitchStatement

[jvm]\
data class [SwitchStatement](index.md)(**value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **switchType**: [SwitchType](../-switch-type/index.md), **cases**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>) : [ValueHolder](../-value-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Switch statement, this switch can switch numeric values and object values (like Enum, String or other objects).

You could switch objects, but make sure that the object implements [Any.hashCode](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/hash-code.html) and [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) methods.

## Constructors

| | |
|---|---|
| [SwitchStatement](-switch-statement.md) | [jvm]<br>fun [SwitchStatement](-switch-statement.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), switchType: [SwitchType](../-switch-type/index.md), cases: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[SwitchStatement](index.md), [SwitchStatement.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[SwitchStatement](index.md), [SwitchStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [SwitchStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [cases](cases.md) | [jvm]<br>val [cases](cases.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Case](../-case/index.md)><br>Cases statements. |
| [switchType](switch-type.md) | [jvm]<br>val [switchType](switch-type.md): [SwitchType](../-switch-type/index.md)<br>Type of the switch |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Value to switch |
