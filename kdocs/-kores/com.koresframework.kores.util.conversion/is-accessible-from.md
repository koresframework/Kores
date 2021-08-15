//[Kores](../../index.md)/[com.koresframework.kores.util.conversion](index.md)/[isAccessibleFrom](is-accessible-from.md)

# isAccessibleFrom

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html).[isAccessibleFrom](is-accessible-from.md)(typeDeclaration: [TypeDeclaration](../com.koresframework.kores.base/-type-declaration/index.md), override: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if receiver [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html) is accessible from [typeDeclaration](is-accessible-from.md) or accessible to be [overwritten](is-accessible-from.md) from [typeDeclaration](is-accessible-from.md).

## Parameters

jvm

| | |
|---|---|
| override | True to check if method is accessible to be overwritten by [typeDeclaration](is-accessible-from.md) method. |
