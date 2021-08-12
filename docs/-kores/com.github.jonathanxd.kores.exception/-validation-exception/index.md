//[Kores](../../../index.md)/[com.github.jonathanxd.kores.exception](../index.md)/[ValidationException](index.md)

# ValidationException

[jvm]\
class [ValidationException](index.md) : [RuntimeException](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html)

Occurs when validation fails.

## Constructors

| | |
|---|---|
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)() |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), enableSuppression: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), writableStackTrace: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ValidationMessage](../../com.github.jonathanxd.kores.processor/-validation-message/index.md)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ValidationMessage](../../com.github.jonathanxd.kores.processor/-validation-message/index.md), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ValidationMessage](../../com.github.jonathanxd.kores.processor/-validation-message/index.md), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), enableSuppression: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), writableStackTrace: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ContextedValidationMessage](../../com.github.jonathanxd.kores.processor/-contexted-validation-message/index.md)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ContextedValidationMessage](../../com.github.jonathanxd.kores.processor/-contexted-validation-message/index.md), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [ValidationException](-validation-exception.md) | [jvm]<br>fun [ValidationException](-validation-exception.md)(message: [ContextedValidationMessage](../../com.github.jonathanxd.kores.processor/-contexted-validation-message/index.md), cause: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), enableSuppression: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), writableStackTrace: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [addSuppressed](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#282858770%2FFunctions%2F-1216412040) | [jvm]<br>fun [addSuppressed](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#282858770%2FFunctions%2F-1216412040)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)) |
| [fillInStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-1102069925%2FFunctions%2F-1216412040) | [jvm]<br>open fun [fillInStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-1102069925%2FFunctions%2F-1216412040)(): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [getLocalizedMessage](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#1043865560%2FFunctions%2F-1216412040) | [jvm]<br>open fun [getLocalizedMessage](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#1043865560%2FFunctions%2F-1216412040)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#2050903719%2FFunctions%2F-1216412040) | [jvm]<br>open fun [getStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#2050903719%2FFunctions%2F-1216412040)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[StackTraceElement](https://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html)> |
| [getSuppressed](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#672492560%2FFunctions%2F-1216412040) | [jvm]<br>fun [getSuppressed](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#672492560%2FFunctions%2F-1216412040)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)> |
| [initCause](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-418225042%2FFunctions%2F-1216412040) | [jvm]<br>open fun [initCause](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-418225042%2FFunctions%2F-1216412040)(p0: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html) |
| [printStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-1769529168%2FFunctions%2F-1216412040) | [jvm]<br>open fun [printStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#-1769529168%2FFunctions%2F-1216412040)()<br>open fun [printStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#1841853697%2FFunctions%2F-1216412040)(p0: [PrintStream](https://docs.oracle.com/javase/8/docs/api/java/io/PrintStream.html))<br>open fun [printStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#1175535278%2FFunctions%2F-1216412040)(p0: [PrintWriter](https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html)) |
| [setStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#2135801318%2FFunctions%2F-1216412040) | [jvm]<br>open fun [setStackTrace](../../com.github.jonathanxd.kores.processor/-unexpected-inspection-context/index.md#2135801318%2FFunctions%2F-1216412040)(p0: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[StackTraceElement](https://docs.oracle.com/javase/8/docs/api/java/lang/StackTraceElement.html)>) |

## Properties

| Name | Summary |
|---|---|
| [cause](index.md#1197066410%2FProperties%2F-1216412040) | [jvm]<br>open val [cause](index.md#1197066410%2FProperties%2F-1216412040): [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)? |
| [message](index.md#-1700268724%2FProperties%2F-1216412040) | [jvm]<br>open val [message](index.md#-1700268724%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
