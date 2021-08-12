//[Kores](../../../index.md)/[com.github.jonathanxd.kores.helper](../index.md)/[IfExpressionHelper](index.md)

# IfExpressionHelper

[jvm]\
class [IfExpressionHelper](index.md)

If expression helper.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addIfGroup](add-if-group.md) | [jvm]<br>fun [addIfGroup](add-if-group.md)(ifGroup: [IfGroup](../../com.github.jonathanxd.kores.base/-if-group/index.md)): [IfExpressionHelper](index.md)<br>Adds a if group to expression list. |
| [and](and.md) | [jvm]<br>fun [and](and.md)(): [IfExpressionHelper](index.md)<br>Adds and expression.<br>[jvm]<br>fun [and](and.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And checks if [part1](and.md)[part2](and.md). |
| [andCheckInstance](and-check-instance.md) | [jvm]<br>fun [andCheckInstance](and-check-instance.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [IfExpressionHelper](index.md)<br>And checks if [part1](and-check-instance.md) is instanceof[type](and-check-instance.md). |
| [andFalse](and-false.md) | [jvm]<br>fun [andFalse](and-false.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And checks if [part1](and-false.md) is false. |
| [andNotNull](and-not-null.md) | [jvm]<br>fun [andNotNull](and-not-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And checks if [part1](and-not-null.md) is not null. |
| [andNull](and-null.md) | [jvm]<br>fun [andNull](and-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And checks if [part1](and-null.md) is null. |
| [andObjectEqual](and-object-equal.md) | [jvm]<br>fun [andObjectEqual](and-object-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And compares [part1](and-object-equal.md) and [part2](and-object-equal.md) using [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) method. |
| [andRefEqual](and-ref-equal.md) | [jvm]<br>fun [andRefEqual](and-ref-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And compares [part1](and-ref-equal.md) and [part2](and-ref-equal.md) by reference. |
| [andTrue](and-true.md) | [jvm]<br>fun [andTrue](and-true.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>And checks if [part1](and-true.md) is true. |
| [build](build.md) | [jvm]<br>fun [build](build.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>Build expressions. |
| [check](check.md) | [jvm]<br>fun [check](check.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Checks if [part1](check.md)[part2](check.md). |
| [checkFalse](check-false.md) | [jvm]<br>fun [checkFalse](check-false.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Checks if [part1](check-false.md) is false. |
| [checkInstance](check-instance.md) | [jvm]<br>fun [checkInstance](check-instance.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [IfExpressionHelper](index.md)<br>Checks if [part1](check-instance.md) is instanceof[type](check-instance.md). |
| [checkNotNull](check-not-null.md) | [jvm]<br>fun [checkNotNull](check-not-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Checks if [part1](check-not-null.md) is not null. |
| [checkNull](check-null.md) | [jvm]<br>fun [checkNull](check-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Checks if [part1](check-null.md) is null. |
| [checkObjectEqual](check-object-equal.md) | [jvm]<br>fun [checkObjectEqual](check-object-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Compares [part1](check-object-equal.md) and [part2](check-object-equal.md) using [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) method. |
| [checkRefEqual](check-ref-equal.md) | [jvm]<br>fun [checkRefEqual](check-ref-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Compares [part1](check-ref-equal.md) and [part2](check-ref-equal.md) by reference. |
| [checkTrue](check-true.md) | [jvm]<br>fun [checkTrue](check-true.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Checks if [part1](check-true.md) is true. |
| [or](or.md) | [jvm]<br>fun [or](or.md)(): [IfExpressionHelper](index.md)<br>Adds or expression.<br>[jvm]<br>fun [or](or.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.github.jonathanxd.kores.operator/-operator/-conditional/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or.md)[part2](or.md). |
| [orCheckInstance](or-check-instance.md) | [jvm]<br>fun [orCheckInstance](or-check-instance.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or-check-instance.md) is instanceof[type](or-check-instance.md). |
| [orFalse](or-false.md) | [jvm]<br>fun [orFalse](or-false.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or-false.md) is false. |
| [orNotNull](or-not-null.md) | [jvm]<br>fun [orNotNull](or-not-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or-not-null.md) is not null. |
| [orNull](or-null.md) | [jvm]<br>fun [orNull](or-null.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or-null.md) is null. |
| [orObjectEqual](or-object-equal.md) | [jvm]<br>fun [orObjectEqual](or-object-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or compares [part1](or-object-equal.md) and [part2](or-object-equal.md) using [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) method. |
| [orRefEqual](or-ref-equal.md) | [jvm]<br>fun [orRefEqual](or-ref-equal.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), part2: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or compares [part1](or-ref-equal.md) and [part2](or-ref-equal.md) by reference. |
| [orTrue](or-true.md) | [jvm]<br>fun [orTrue](or-true.md)(part1: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [IfExpressionHelper](index.md)<br>Or checks if [part1](or-true.md) is true. |
