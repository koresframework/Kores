//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Access](index.md)

# Access

[jvm]\
enum [Access](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[Access](index.md)> , [Instruction](../../com.koresframework.kores/-instruction/index.md)

Access to a scope. Example, access to static scope of [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

## Entries

| | |
|---|---|
| [SUPER](-s-u-p-e-r/index.md) | [jvm]<br>[SUPER](-s-u-p-e-r/index.md)()<br>Access to super class scope. |
| [THIS](-t-h-i-s/index.md) | [jvm]<br>[THIS](-t-h-i-s/index.md)()<br>Access to this scope. |
| [STATIC](-s-t-a-t-i-c/index.md) | [jvm]<br>[STATIC](-s-t-a-t-i-c/index.md)()<br>Access to static scope. |
| [LOCAL](-l-o-c-a-l/index.md) | [jvm]<br>[LOCAL](-l-o-c-a-l/index.md)()<br>Access to local scope. |

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.koresframework.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.koresframework.kores/-kores-part/builder.md)(): [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[KoresPart](../../com.koresframework.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](index.md#-1414962444%2FProperties%2F-1216412040) | [jvm]<br>val [name](index.md#-1414962444%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](index.md#1432170442%2FProperties%2F-1216412040) | [jvm]<br>val [ordinal](index.md#1432170442%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
