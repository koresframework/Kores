//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[New](index.md)

# New

[jvm]\
data class [New](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Represents the construction of type, used to invoke constructor methods. (not super constructor or this constructor).

## Constructors

| | |
|---|---|
| [New](-new.md) | [jvm]<br>fun [New](-new.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[New](index.md), [New.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [New.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
