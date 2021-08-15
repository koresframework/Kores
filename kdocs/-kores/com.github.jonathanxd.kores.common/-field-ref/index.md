//[Kores](../../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[FieldRef](index.md)

# FieldRef

[jvm]\
data class [FieldRef](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [FieldBase](../../com.github.jonathanxd.kores.base/-field-base/index.md)

Field reference

## Constructors

| | |
|---|---|
| [FieldRef](-field-ref.md) | [jvm]<br>fun [FieldRef](-field-ref.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [FieldBase.Builder](../../com.github.jonathanxd.kores.base/-field-base/-builder/index.md)<[FieldRef](index.md), [FieldRef.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../../com.github.jonathanxd.kores.base/-field-base/access.md) | [jvm]<br>open fun [access](../../com.github.jonathanxd.kores.base/-field-base/access.md)(): [FieldAccess](../../com.github.jonathanxd.kores.base/-field-access/index.md)<br>Creates access to the field that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldRef.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [set](../../com.github.jonathanxd.kores.base/-field-base/set.md) | [jvm]<br>open fun [set](../../com.github.jonathanxd.kores.base/-field-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../../com.github.jonathanxd.kores.base/-field-definition/index.md)<br>Creates a definition of the value of the field that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Field localization. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of the access |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
