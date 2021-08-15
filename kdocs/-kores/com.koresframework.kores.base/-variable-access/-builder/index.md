//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[VariableAccess](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [VariableBase.Builder](../../-variable-base/-builder/index.md)<[VariableAccess](../index.md), [VariableAccess.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [VariableAccess](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](../../-variable-base/-builder/base.md) | [jvm]<br>open fun [base](../../-variable-base/-builder/base.md)(fieldRef: [FieldRef](../../../com.koresframework.kores.common/-field-ref/index.md)): [VariableAccess.Builder](index.md)<br>Base this builder on [fieldRef](../../-variable-base/-builder/base.md) (only name and [type](../../-variable-base/-builder/type.md)).<br>[jvm]<br>open fun [base](../../-variable-base/-builder/base.md)(variableRef: [VariableRef](../../../com.koresframework.kores.common/-variable-ref/index.md)): [VariableAccess.Builder](index.md)<br>Base this builder on [variableRef](../../-variable-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [VariableAccess](../index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [VariableAccess.Builder](index.md) |
| [type](../../-variable-base/-builder/type.md) | [jvm]<br>open override fun [type](../../-variable-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableAccess.Builder](index.md)<br>See T. |
| [variableType](variable-type.md) | [jvm]<br>open override fun [variableType](variable-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableAccess.Builder](index.md)<br>See [VariableBase.variableType](../../-variable-base/variable-type.md) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [variableType](variable-type.md) | [jvm]<br>lateinit var [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
