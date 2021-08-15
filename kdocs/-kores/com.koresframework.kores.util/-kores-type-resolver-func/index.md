//[Kores](../../../index.md)/[com.koresframework.kores.util](../index.md)/[KoresTypeResolverFunc](index.md)

# KoresTypeResolverFunc

[jvm]\
abstract class [KoresTypeResolverFunc](index.md) : [Function1](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-function1/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [KoresType](../../com.koresframework.kores.type/-kores-type/index.md)> , [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [KoresType](../../com.koresframework.kores.type/-kores-type/index.md)>

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [andThen](index.md#-56344939%2FFunctions%2F-1216412040) | [jvm]<br>open fun <[V](index.md#-56344939%2FFunctions%2F-1216412040) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [andThen](index.md#-56344939%2FFunctions%2F-1216412040)(p0: [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)<in [KoresType](../../com.koresframework.kores.type/-kores-type/index.md), out [V](index.md#-56344939%2FFunctions%2F-1216412040)>): [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [V](index.md#-56344939%2FFunctions%2F-1216412040)> |
| [apply](apply.md) | [jvm]<br>open override fun [apply](apply.md)(t: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](../../com.koresframework.kores.type/-kores-type/index.md) |
| [compose](index.md#1605073868%2FFunctions%2F-1216412040) | [jvm]<br>open fun <[V](index.md#1605073868%2FFunctions%2F-1216412040) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [compose](index.md#1605073868%2FFunctions%2F-1216412040)(p0: [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)<in [V](index.md#1605073868%2FFunctions%2F-1216412040), out [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)>): [Function](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html)<[V](index.md#1605073868%2FFunctions%2F-1216412040), [KoresType](../../com.koresframework.kores.type/-kores-type/index.md)> |
| [invoke](invoke.md) | [jvm]<br>open operator override fun [invoke](invoke.md)(p1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](../../com.koresframework.kores.type/-kores-type/index.md) |
