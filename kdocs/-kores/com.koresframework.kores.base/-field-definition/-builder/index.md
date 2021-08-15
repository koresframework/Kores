//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[FieldDefinition](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Accessor.Builder](../../-accessor/-builder/index.md)<[FieldDefinition](../index.md), [FieldDefinition.Builder](index.md)> , [FieldBase.Builder](../../-field-base/-builder/index.md)<[FieldDefinition](../index.md), [FieldDefinition.Builder](index.md)> , [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[FieldDefinition](../index.md), [FieldDefinition.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldDefinition](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](../../-field-base/-builder/base.md) | [jvm]<br>open fun [base](../../-field-base/-builder/base.md)(fieldRef: [FieldRef](../../../com.koresframework.kores.common/-field-ref/index.md)): [FieldDefinition.Builder](index.md)<br>Base this builder on [fieldRef](../../-field-base/-builder/base.md).<br>[jvm]<br>open fun [base](../../-field-base/-builder/base.md)(variableRef: [VariableRef](../../../com.koresframework.kores.common/-variable-ref/index.md)): [FieldDefinition.Builder](index.md)<br>Base this builder on [variableRef](../../-field-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldDefinition](../index.md)<br>Build the object of type T. |
| [localization](localization.md) | [jvm]<br>open override fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldDefinition.Builder](index.md)<br>See [Accessor.localization](../../-accessor/localization.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldDefinition.Builder](index.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [FieldDefinition.Builder](index.md)<br>See [Accessor.target](../../-accessor/target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldDefinition.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [FieldDefinition.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>lateinit var [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
