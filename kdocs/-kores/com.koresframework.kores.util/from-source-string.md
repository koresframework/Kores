//[Kores](../../index.md)/[com.koresframework.kores.util](index.md)/[fromSourceString](from-source-string.md)

# fromSourceString

[jvm]\
fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType](../com.koresframework.kores.type/-generic-type/index.md)

Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.koresframework.kores.type/-generic-type/index.md).

#### Return

Construct a [GenericType](../com.koresframework.kores.type/-generic-type/index.md) from generic source string;

## Parameters

jvm

| | |
|---|---|
| sourceString | Source string.<br><ul><li></li></ul> |

[jvm]\
fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeResolver: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [KoresType](../com.koresframework.kores.type/-kores-type/index.md)): [GenericType](../com.koresframework.kores.type/-generic-type/index.md)

fun [fromSourceString](from-source-string.md)(sourceString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeResolver: [KoresTypeResolverFunc](-kores-type-resolver-func/index.md)): [GenericType](../com.koresframework.kores.type/-generic-type/index.md)

Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.koresframework.kores.type/-generic-type/index.md).

#### Return

Construct a [GenericType](../com.koresframework.kores.type/-generic-type/index.md) from generic source string;

## Parameters

jvm

| | |
|---|---|
| sourceString | Source string. |
| typeResolver | Resolves [KoresType](../com.koresframework.kores.type/-kores-type/index.md) from [string type](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
