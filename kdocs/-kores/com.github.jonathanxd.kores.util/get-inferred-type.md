//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[getInferredType](get-inferred-type.md)

# getInferredType

[jvm]\
fun [getInferredType](get-inferred-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)>

See [getInferredType](get-inferred-type.md) below.

[jvm]\
fun [getInferredType](get-inferred-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parameterizedType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), startingType: [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.github.jonathanxd.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md), found: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md)>): [State](-state/index.md)

This function tries to find [name](get-inferred-type.md) in all possible types which inherits [parameterizedType](get-inferred-type.md), this function uses a defined [genericResolver](get-inferred-type.md) to resolve the [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md) representation of a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).

## Parameters

jvm

| | |
|---|---|
| name | Type variable name. |
| parameterizedType | Target class which have the type variable [name](get-inferred-type.md). |
| startingType | Initial type of class hierarchy (in other words, the type which extends [parameterizedType](get-inferred-type.md) explicitly or implicitly). |
| koresTypeResolver | Resolver of super types. This resolver will be used also to resolve original types. |
| genericResolver | Resolver which will resolve generic types from [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). |
| found | List which types should be added |
