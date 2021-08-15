//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[getType](get-type.md)

# getType

[jvm]\
fun [getType](get-type.md)(typeVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, variable: [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>, generic: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)?

Resolves the [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) of [variable](get-type.md) of [typeVariables](get-type.md) using types provided by [generic](get-type.md).

[jvm]\
fun [getType](get-type.md)(typeVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, variable: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), generic: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)): [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)?

Resolves the [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) of variable with name [variable](get-type.md) of [typeVariables](get-type.md) using types provided by [generic](get-type.md).

## Parameters

jvm

| | |
|---|---|
| typeVariables | Class Type variables |
| variable | Variable name to find type |
| generic | Generic type with types of [typeVariables](get-type.md) |
