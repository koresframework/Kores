//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[KoresTypeSerializer](index.md)

# KoresTypeSerializer

[jvm]\
object [KoresTypeSerializer](index.md) : KSerializer<[KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)>

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
| [ser](ser.md) | [jvm]<br>val [ser](ser.md): [TypeSerializer](../-type-serializer/index.md) |
