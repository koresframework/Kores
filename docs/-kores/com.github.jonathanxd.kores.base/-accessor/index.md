//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Accessor](index.md)

# Accessor

[jvm]\
interface [Accessor](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Accessor of an element. Example: field access/definition, method invocation and executable code.

#  In Java

[target](target.md) is the receiver of access.

[localization](localization.md) is the inferred or exact type of [target](target.md)

Example: String hello; hello.charAt(0); The [target](target.md) is hello variable and [localization](localization.md) is String class.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Accessor](index.md), [S](-builder/index.md) : [Accessor.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [Accessor.Builder](-builder/index.md)<[Accessor](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>abstract val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [target](target.md) | [jvm]<br>abstract val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Access target |

## Inheritors

| Name |
|---|
| [FieldAccess](../-field-access/index.md) |
| [FieldDefinition](../-field-definition/index.md) |
| [MethodInvocation](../-method-invocation/index.md) |
