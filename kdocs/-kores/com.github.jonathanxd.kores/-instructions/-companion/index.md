//[Kores](../../../../index.md)/[com.github.jonathanxd.kores](../../index.md)/[Instructions](../index.md)/[Companion](index.md)

# Companion

[jvm]\
object [Companion](index.md)

Factory methods to create immutable [Instructions](../index.md).

## Functions

| Name | Summary |
|---|---|
| [empty](empty.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [empty](empty.md)(): [Instructions](../index.md)<br>Returns a empty immutable [Instructions](../index.md). |
| [fromArray](from-array.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromArray](from-array.md)(parts: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Instruction](../../-instruction/index.md)>): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) with all elements of [parts](from-array.md). |
| [fromGenericIterable](from-generic-iterable.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromGenericIterable](from-generic-iterable.md)(iterable: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<*>): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) from elements of generic [iterable](from-generic-iterable.md). |
| [fromInstructionsIterable](from-instructions-iterable.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromInstructionsIterable](from-instructions-iterable.md)(iterable: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instructions](../index.md)>): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) with all elements of [Instructions](../index.md) of [iterable](from-instructions-iterable.md). |
| [fromIterable](from-iterable.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromIterable](from-iterable.md)(iterable: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../../-instruction/index.md)>): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) from elements of [iterable](from-iterable.md). |
| [fromPart](from-part.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromPart](from-part.md)(part: [Instruction](../../-instruction/index.md)): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) with a single [part](from-part.md). |
| [fromVarArgs](from-var-args.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromVarArgs](from-var-args.md)(vararg parts: [Instruction](../../-instruction/index.md)): [Instructions](../index.md)<br>Creates a immutable [Instructions](../index.md) with all elements of vararg [parts](from-var-args.md). |
