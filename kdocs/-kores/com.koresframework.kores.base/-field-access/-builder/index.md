//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[FieldAccess](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Accessor.Builder](../../-accessor/-builder/index.md)<[FieldAccess](../index.md), [FieldAccess.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[FieldAccess](../index.md), [FieldAccess.Builder](index.md)> , [Named.Builder](../../-named/-builder/index.md)<[FieldAccess](../index.md), [FieldAccess.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldAccess](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](base.md) | [jvm]<br>fun [base](base.md)(ref: [FieldRef](../../../com.koresframework.kores.common/-field-ref/index.md)): [FieldAccess.Builder](index.md)<br>Base this builder in [ref](base.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldAccess](../index.md)<br>Build the object of type T. |
| [localization](localization.md) | [jvm]<br>open override fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldAccess.Builder](index.md)<br>See [Accessor.localization](../../-accessor/localization.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldAccess.Builder](index.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [FieldAccess.Builder](index.md)<br>See [Accessor.target](../../-accessor/target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldAccess.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>lateinit var [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
