//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[FieldRef](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [FieldBase.Builder](../../../com.github.jonathanxd.kores.base/-field-base/-builder/index.md)<[FieldRef](../index.md), [FieldRef.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldRef](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](../../../com.github.jonathanxd.kores.base/-field-base/-builder/base.md) | [jvm]<br>open fun [base](../../../com.github.jonathanxd.kores.base/-field-base/-builder/base.md)(fieldRef: [FieldRef](../index.md)): [FieldRef.Builder](index.md)<br>Base this builder on [fieldRef](../../../com.github.jonathanxd.kores.base/-field-base/-builder/base.md).<br>[jvm]<br>open fun [base](../../../com.github.jonathanxd.kores.base/-field-base/-builder/base.md)(variableRef: [VariableRef](../../-variable-ref/index.md)): [FieldRef.Builder](index.md)<br>Base this builder on [variableRef](../../../com.github.jonathanxd.kores.base/-field-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldRef](../index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [localization](localization.md) | [jvm]<br>open override fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldRef.Builder](index.md)<br>See T. |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldRef.Builder](index.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldRef.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldRef.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>lateinit var [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
