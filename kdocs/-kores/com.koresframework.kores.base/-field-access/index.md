//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[FieldAccess](index.md)

# FieldAccess

[jvm]\
data class [FieldAccess](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Accessor](../-accessor/index.md), [TypedInstruction](../-typed-instruction/index.md), [Named](../-named/index.md)

Access a field of type [type](type.md), name [name](name.md) in type [localization](localization.md) using [target](target.md) as instance (Use a Access.Type.STATIC to static accesses).

## Constructors

| | |
|---|---|
| [FieldAccess](-field-access.md) | [jvm]<br>fun [FieldAccess](-field-access.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Accessor.Builder](../-accessor/-builder/index.md)<[FieldAccess](index.md), [FieldAccess.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[FieldAccess](index.md), [FieldAccess.Builder](-builder/index.md)> , [Named.Builder](../-named/-builder/index.md)<[FieldAccess](index.md), [FieldAccess.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldAccess.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Access target |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
