//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[FieldDefinition](index.md)

# FieldDefinition

[jvm]\
data class [FieldDefinition](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **value**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [Accessor](../-accessor/index.md), [FieldBase](../-field-base/index.md), [ValueHolder](../-value-holder/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Defines the value of a field of type [type](type.md), name [name](name.md) in type [localization](localization.md) to [value](value.md), and use [target](target.md) as instance to access ([Access.STATIC](../-access/-s-t-a-t-i-c/index.md) for static accesses).

## Constructors

| | |
|---|---|
| [FieldDefinition](-field-definition.md) | [jvm]<br>fun [FieldDefinition](-field-definition.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Accessor.Builder](../-accessor/-builder/index.md)<[FieldDefinition](index.md), [FieldDefinition.Builder](-builder/index.md)> , [FieldBase.Builder](../-field-base/-builder/index.md)<[FieldDefinition](index.md), [FieldDefinition.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[FieldDefinition](index.md), [FieldDefinition.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../-field-base/access.md) | [jvm]<br>open fun [access](../-field-base/access.md)(): [FieldAccess](../-field-access/index.md)<br>Creates access to the field that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldDefinition.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [set](../-field-base/set.md) | [jvm]<br>open fun [set](../-field-base/set.md)(value: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [FieldDefinition](index.md)<br>Creates a definition of the value of the field that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Access target |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value |
