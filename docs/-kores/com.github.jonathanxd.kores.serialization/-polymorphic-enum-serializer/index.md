//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[PolymorphicEnumSerializer](index.md)

# PolymorphicEnumSerializer

[jvm]\
class [PolymorphicEnumSerializer](index.md)<[T](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[T](index.md)>>(**enumSerializer**: KSerializer<[T](index.md)>) : KSerializer<[T](index.md)>

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [T](index.md) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [T](index.md)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
