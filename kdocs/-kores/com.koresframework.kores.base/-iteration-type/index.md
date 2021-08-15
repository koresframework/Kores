//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[IterationType](index.md)

# IterationType

[jvm]\
data class [IterationType](index.md)(**iteratorMethodSpec**: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md), **hasNextName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **nextMethodSpec**: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md))

Iteration type used to generate bytecode and source code iterations.

## Constructors

| | |
|---|---|
| [IterationType](-iteration-type.md) | [jvm]<br>fun [IterationType](-iteration-type.md)(iteratorMethodSpec: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md), hasNextName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextMethodSpec: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [hasNextName](has-next-name.md) | [jvm]<br>val [hasNextName](has-next-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of method which returns true if has next elements. |
| [iteratorMethodSpec](iterator-method-spec.md) | [jvm]<br>val [iteratorMethodSpec](iterator-method-spec.md): [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md)<br>Specification of iterator method. |
| [nextMethodSpec](next-method-spec.md) | [jvm]<br>val [nextMethodSpec](next-method-spec.md): [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md)<br>Specification of method which returns the next element. |
