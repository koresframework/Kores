//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[createCasted](create-casted.md)

# createCasted

[jvm]\
fun [createCasted](create-casted.md)(expected: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, passed: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>

Create a casted argument list. This function casts [passed](create-casted.md) to types of [expected](create-casted.md).

#### Return

List with casted arguments.

## Parameters

jvm

| | |
|---|---|
| expected | Expected arguments. |
| passed | Provided arguments |
