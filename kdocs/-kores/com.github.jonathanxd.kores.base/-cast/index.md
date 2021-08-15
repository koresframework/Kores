//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Cast](index.md)

# Cast

[jvm]\
data class [Cast](index.md)(**originalType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, **targetType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **instruction**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [TypedInstruction](../-typed-instruction/index.md)

Value cast. Cast [instruction](instruction.md) of type [originalType](original-type.md) (null if unknown) to [targetType](target-type.md). Official BytecodeGenerator uses the [originalType](original-type.md) to auto-box and auto-unbox the value.

## Constructors

| | |
|---|---|
| [Cast](-cast.md) | [jvm]<br>fun [Cast](-cast.md)(originalType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, targetType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), instruction: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[Cast](index.md), [Cast.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Cast.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [instruction](instruction.md) | [jvm]<br>val [instruction](instruction.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Instruction to cast |
| [originalType](original-type.md) | [jvm]<br>val [originalType](original-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Origin type |
| [targetType](target-type.md) | [jvm]<br>val [targetType](target-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Target type |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
