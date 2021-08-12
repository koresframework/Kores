//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[VariableDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [VariableBase.Builder](../../-variable-base/-builder/index.md)<[VariableDeclaration](../index.md), [VariableDeclaration.Builder](index.md)> , [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[VariableDeclaration](../index.md), [VariableDeclaration.Builder](index.md)> , [ModifiersHolder.Builder](../../-modifiers-holder/-builder/index.md)<[VariableDeclaration](../index.md), [VariableDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [VariableDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](../../-variable-base/-builder/base.md) | [jvm]<br>open fun [base](../../-variable-base/-builder/base.md)(fieldRef: [FieldRef](../../../com.github.jonathanxd.kores.common/-field-ref/index.md)): [VariableDeclaration.Builder](index.md)<br>Base this builder on [fieldRef](../../-variable-base/-builder/base.md) (only name and [type](../../-variable-base/-builder/type.md)).<br>[jvm]<br>open fun [base](../../-variable-base/-builder/base.md)(variableRef: [VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/index.md)): [VariableDeclaration.Builder](index.md)<br>Base this builder on [variableRef](../../-variable-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [VariableDeclaration](../index.md)<br>Build the object of type T. |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | [jvm]<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [VariableDeclaration.Builder](index.md)<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [VariableDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [VariableDeclaration.Builder](index.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [VariableDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [type](../../-variable-base/-builder/type.md) | [jvm]<br>open override fun [type](../../-variable-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableDeclaration.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [VariableDeclaration.Builder](index.md)<br>See T. |
| [variableType](variable-type.md) | [jvm]<br>open override fun [variableType](variable-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableDeclaration.Builder](index.md)<br>See [VariableBase.variableType](../../-variable-base/variable-type.md) |
| [withoutValue](without-value.md) | [jvm]<br>fun [withoutValue](without-value.md)(): [VariableDeclaration.Builder](index.md)<br>Removes value definition. |

## Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [value](value.md) | [jvm]<br>var [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [variableType](variable-type.md) | [jvm]<br>lateinit var [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
