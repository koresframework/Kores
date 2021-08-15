//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[ProcessorManager](index.md)/[process](process.md)

# process

[jvm]\
open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [R](index.md)

open fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](process.md)>, part: [T](process.md)): [R](index.md)

Process [part](process.md) and returns a value of type [R](index.md).

[jvm]\
open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData): [R](index.md)

Process [part](process.md) with [data](process.md) and returns a value of type [R](index.md).

[jvm]\
abstract fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](process.md)>, part: [T](process.md), data: TypedData): [R](index.md)

Process [part](process.md) of type [type](process.md) with [data](process.md) and returns a value of type [R](index.md).
