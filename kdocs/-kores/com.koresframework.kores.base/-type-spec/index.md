//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[TypeSpec](index.md)

# TypeSpec

[jvm]\
data class [TypeSpec](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()constructor(**returnType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **parameterTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>) : [Typed](../-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[TypeSpec](index.md)> 

Type Signature representation.

## Constructors

| | |
|---|---|
| [TypeSpec](-type-spec.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()<br>fun [TypeSpec](-type-spec.md)(returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), parameterTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> = emptyList()) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[TypeSpec](index.md), [TypeSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [TypeSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [TypeSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isConreteEq](is-conrete-eq.md) | [jvm]<br>fun [isConreteEq](is-conrete-eq.md)(other: [TypeSpec](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if concrete types of this spec is same as concrete types of [other](is-conrete-eq.md) spec. |
| [toTypeString](to-type-string.md) | [jvm]<br>fun [toTypeString](to-type-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human readable type specification string. |

## Properties

| Name | Summary |
|---|---|
| [parameterTypes](parameter-types.md) | [jvm]<br>val [parameterTypes](parameter-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Type of parameters |
| [returnType](return-type.md) | [jvm]<br>val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of the return. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Extensions

| Name | Summary |
|---|---|
| [typeDesc](../type-desc.md) | [jvm]<br>val [TypeSpec](index.md).[typeDesc](../type-desc.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert [TypeSpec](index.md) string description |
