//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[IfExpr](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[IfExpr](../index.md), [IfExpr.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [IfExpr](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [IfExpr](../index.md)<br>Build the object of type T. |
| [expr1](expr1.md) | [jvm]<br>fun [expr1](expr1.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpr.Builder](index.md)<br>See [IfExpr.expr1](../expr1.md) |
| [expr2](expr2.md) | [jvm]<br>fun [expr2](expr2.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpr.Builder](index.md)<br>See [IfExpr.expr2](../expr2.md) |
| [operation](operation.md) | [jvm]<br>fun [operation](operation.md)(value: [Operator.Conditional](../../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md)): [IfExpr.Builder](index.md)<br>See [IfExpr.operation](../operation.md) |

## Properties

| Name | Summary |
|---|---|
| [expr1](expr1.md) | [jvm]<br>lateinit var [expr1](expr1.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [expr2](expr2.md) | [jvm]<br>lateinit var [expr2](expr2.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [operation](operation.md) | [jvm]<br>lateinit var [operation](operation.md): [Operator.Conditional](../../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md) |
