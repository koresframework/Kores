//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[BaseTypeSerializer](index.md)

# BaseTypeSerializer

[jvm]\
abstract class [BaseTypeSerializer](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : KSerializer<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
| [name](name.md) | [jvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [JavaTypeSerializer](../-java-type-serializer/index.md) |
| [PredefinedTypeSerializer](../-predefined-type-serializer/index.md) |
