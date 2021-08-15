//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[KoresModifier](index.md)

# KoresModifier

[jvm]\
enum [KoresModifier](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[KoresModifier](index.md)> , [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Modifiers enum.

## Entries

| | |
|---|---|
| [STATIC_PHASE](-s-t-a-t-i-c_-p-h-a-s-e/index.md) | [jvm]<br>[STATIC_PHASE](-s-t-a-t-i-c_-p-h-a-s-e/index.md)(MODULE) |
| [TRANSITIVE](-t-r-a-n-s-i-t-i-v-e/index.md) | [jvm]<br>[TRANSITIVE](-t-r-a-n-s-i-t-i-v-e/index.md)(MODULE) |
| [OPEN](-o-p-e-n/index.md) | [jvm]<br>[OPEN](-o-p-e-n/index.md)(MODULE) |
| [MANDATED](-m-a-n-d-a-t-e-d/index.md) | [jvm]<br>[MANDATED](-m-a-n-d-a-t-e-d/index.md)(OTHER) |
| [ENUM](-e-n-u-m/index.md) | [jvm]<br>[ENUM](-e-n-u-m/index.md)(OTHER) |
| [ANNOTATION](-a-n-n-o-t-a-t-i-o-n/index.md) | [jvm]<br>[ANNOTATION](-a-n-n-o-t-a-t-i-o-n/index.md)(OTHER) |
| [SYNTHETIC](-s-y-n-t-h-e-t-i-c/index.md) | [jvm]<br>[SYNTHETIC](-s-y-n-t-h-e-t-i-c/index.md)(OTHER) |
| [VARARGS](-v-a-r-a-r-g-s/index.md) | [jvm]<br>[VARARGS](-v-a-r-a-r-g-s/index.md)(OTHER) |
| [BRIDGE](-b-r-i-d-g-e/index.md) | [jvm]<br>[BRIDGE](-b-r-i-d-g-e/index.md)(OTHER) |
| [STRICTFP](-s-t-r-i-c-t-f-p/index.md) | [jvm]<br>[STRICTFP](-s-t-r-i-c-t-f-p/index.md)(OTHER) |
| [NATIVE](-n-a-t-i-v-e/index.md) | [jvm]<br>[NATIVE](-n-a-t-i-v-e/index.md)(OTHER) |
| [SYNCHRONIZED](-s-y-n-c-h-r-o-n-i-z-e-d/index.md) | [jvm]<br>[SYNCHRONIZED](-s-y-n-c-h-r-o-n-i-z-e-d/index.md)(CONCURRENCY) |
| [VOLATILE](-v-o-l-a-t-i-l-e/index.md) | [jvm]<br>[VOLATILE](-v-o-l-a-t-i-l-e/index.md)(CONCURRENCY) |
| [TRANSIENT](-t-r-a-n-s-i-e-n-t/index.md) | [jvm]<br>[TRANSIENT](-t-r-a-n-s-i-e-n-t/index.md)(SERIALIZATION) |
| [FINAL](-f-i-n-a-l/index.md) | [jvm]<br>[FINAL](-f-i-n-a-l/index.md)(OTHER) |
| [STATIC](-s-t-a-t-i-c/index.md) | [jvm]<br>[STATIC](-s-t-a-t-i-c/index.md)(OTHER) |
| [DEFAULT](-d-e-f-a-u-l-t/index.md) | [jvm]<br>[DEFAULT](-d-e-f-a-u-l-t/index.md)(ABSTRACTION) |
| [ABSTRACT](-a-b-s-t-r-a-c-t/index.md) | [jvm]<br>[ABSTRACT](-a-b-s-t-r-a-c-t/index.md)(ABSTRACTION) |
| [PACKAGE_PRIVATE](-p-a-c-k-a-g-e_-p-r-i-v-a-t-e/index.md) | [jvm]<br>[PACKAGE_PRIVATE](-p-a-c-k-a-g-e_-p-r-i-v-a-t-e/index.md)(VISIBILITY, "") |
| [PRIVATE](-p-r-i-v-a-t-e/index.md) | [jvm]<br>[PRIVATE](-p-r-i-v-a-t-e/index.md)(VISIBILITY) |
| [PROTECTED](-p-r-o-t-e-c-t-e-d/index.md) | [jvm]<br>[PROTECTED](-p-r-o-t-e-c-t-e-d/index.md)(VISIBILITY) |
| [PUBLIC](-p-u-b-l-i-c/index.md) | [jvm]<br>[PUBLIC](-p-u-b-l-i-c/index.md)(VISIBILITY) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |
| [Internal](-internal/index.md) | [jvm]<br>object [Internal](-internal/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [expr](expr.md) | [jvm]<br>val [expr](expr.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Modifier name. |
| [modifierType](modifier-type.md) | [jvm]<br>val [modifierType](modifier-type.md): [ModifierType](../-modifier-type/index.md)<br>Type of modifier. |
| [name](index.md#1594373461%2FProperties%2F-1216412040) | [jvm]<br>val [name](index.md#1594373461%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](index.md#-589220407%2FProperties%2F-1216412040) | [jvm]<br>val [ordinal](index.md#-589220407%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
