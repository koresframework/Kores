//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[VariableRef](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [VariableBase.Builder](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/index.md)<[VariableRef](../index.md), [VariableRef.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [VariableRef](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/base.md) | [jvm]<br>open fun [base](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/base.md)(fieldRef: [FieldRef](../../-field-ref/index.md)): [VariableRef.Builder](index.md)<br>Base this builder on [fieldRef](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/base.md) (only name and [type](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/type.md)).<br>[jvm]<br>open fun [base](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/base.md)(variableRef: [VariableRef](../index.md)): [VariableRef.Builder](index.md)<br>Base this builder on [variableRef](../../../com.github.jonathanxd.kores.base/-variable-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [VariableRef](../index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [VariableRef.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableRef.Builder](index.md)<br>See T. |
| [variableType](variable-type.md) | [jvm]<br>open override fun [variableType](variable-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableRef.Builder](index.md)<br>See [VariableBase.variableType](../../../com.github.jonathanxd.kores.base/-variable-base/variable-type.md) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
