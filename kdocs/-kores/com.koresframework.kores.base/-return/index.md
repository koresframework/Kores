//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Return](index.md)

# Return

[jvm]\
data class [Return](index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **value**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [ValueHolder](../-value-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Return value.

## Constructors

| | |
|---|---|
| [Return](-return.md) | [jvm]<br>fun [Return](-return.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), value: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[Return](index.md), [Return.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[Return](index.md), [Return.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Return.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value |
