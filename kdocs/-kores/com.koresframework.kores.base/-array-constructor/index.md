//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ArrayConstructor](index.md)

# ArrayConstructor

[jvm]\
data class [ArrayConstructor](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **dimensions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) : [ArgumentsHolder](../-arguments-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Constructs an array of type [arrayType](array-type.md) with dimensions [dimensions](dimensions.md). Example:

new ArrayConstructor(String[].class, listOf(Literals.INT(5)), emptyList()) = new String[5]new ArrayConstructor(String[].class, listOf(Literals.INT(5), Literals.INT(9)), emptyList()) = new String[5][9]

new ArrayConstructor(\
    String[].class,\
    listOf(Literals.INT(3)),\
    listOf(Literals.STRING("A"), Literals.STRING("B"), Literals.STRING("C"))\
) = new String[] {"A", "B", "C"}

## Constructors

| | |
|---|---|
| [ArrayConstructor](-array-constructor.md) | [jvm]<br>fun [ArrayConstructor](-array-constructor.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), dimensions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ArgumentsHolder.Builder](../-arguments-holder/-builder/index.md)<[ArrayConstructor](index.md), [ArrayConstructor.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[ArrayConstructor](index.md), [ArrayConstructor.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ArrayConstructor.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)><br>Argument list |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [arrayType](array-type.md) | [jvm]<br>val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [arrayValues](array-values.md) | [jvm]<br>val [arrayValues](array-values.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ArrayStore](../-array-store/index.md)><br>Array values |
| [dimensions](dimensions.md) | [jvm]<br>val [dimensions](dimensions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)> |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |
