//[Kores](../../index.md)/[com.koresframework.kores.util](index.md)/[inferType](infer-type.md)

# inferType

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [inferType](infer-type.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), parameterizedType: [GenericType](../com.koresframework.kores.type/-generic-type/index.md), startingType: [GenericType](../com.koresframework.kores.type/-generic-type/index.md), koresTypeResolver: [KoresTypeResolver](../com.koresframework.kores.type/-kores-type-resolver/index.md)<*>, genericResolver: [GenericResolver](-generic-resolver/index.md), filter: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = { true }): [KoresType](../com.koresframework.kores.type/-kores-type/index.md)

Infer generic types. This function will use [getInferredType](get-inferred-type.md) to replace TypeVariables in [type](infer-type.md).

## Parameters

jvm

| | |
|---|---|
| type | Type which have unresolved variable types. Example: List<T> |
| parameterizedType | Target class which have the type variables of [type](infer-type.md). |
| startingType | Initial type of class hierarchy (in other words, the type which extends [parameterizedType](infer-type.md) explicitly or implicitly). |
| koresTypeResolver | Type resolver which will get superclass and superinterfaces. |
| genericResolver | Resolver which will resolve generic types from [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). |
| filter | Filter which determines type variables to be inferred. (True to infer, false to ignore). |

[jvm]\
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[inferType](infer-type.md)(variables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, classVariables: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [TypeVariable](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/TypeVariable.html)<*>>, genericType: [GenericType](../com.koresframework.kores.type/-generic-type/index.md)): [KoresType](../com.koresframework.kores.type/-kores-type/index.md)

Infers a type for receiver type variable.
