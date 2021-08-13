//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[BootstrapArgSerializer](index.md)

# BootstrapArgSerializer

[jvm]\
object [BootstrapArgSerializer](index.md) : KSerializer<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> 

Bootstrap method Arguments as specified in [com.github.jonathanxd.kores.base.InvokeDynamicBase.bootstrapArgs](../../com.github.jonathanxd.kores.base/-invoke-dynamic-base/bootstrap-args.md).

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
