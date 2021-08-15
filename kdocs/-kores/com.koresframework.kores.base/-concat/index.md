//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Concat](index.md)

# Concat

[jvm]\
data class [Concat](index.md)(**concatenations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md), [TypedInstruction](../-typed-instruction/index.md)

String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/index.html) will be used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official JavaSourceGenerator this will be translated into string concatenation.

## Constructors

| | |
|---|---|
| [Concat](-concat.md) | [jvm]<br>fun [Concat](-concat.md)(concatenations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[Concat](index.md), [Concat.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Concat.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [concatenations](concatenations.md) | [jvm]<br>val [concatenations](concatenations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)> |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
