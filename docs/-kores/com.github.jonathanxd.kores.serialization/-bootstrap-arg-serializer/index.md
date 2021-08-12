//[Kores](../../../index.md)/[com.github.jonathanxd.kores.serialization](../index.md)/[BootstrapArgSerializer](index.md)

# BootstrapArgSerializer

[jvm]\
object [BootstrapArgSerializer](index.md) : KSerializer<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> 

Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md).

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [jvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [serialize](serialize.md) | [jvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [jvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor |
