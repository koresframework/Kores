//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[TypeSerializer](index.md)

# TypeSerializer

[jvm]\
object [TypeSerializer](index.md) : KSerializer<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
