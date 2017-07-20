[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [inferType](.)

# inferType

`fun inferType(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, parameterizedType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, startingType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, codeTypeResolver: `[`CodeTypeResolver`](../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>, genericResolver: `[`GenericResolver`](-generic-resolver/index.md)`, filter: (String) -> Boolean = {true}): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)

Infer generic types. This function will use [getInferredType](get-inferred-type.md) to replace `TypeVariables` in [type](infer-type.md#com.github.jonathanxd.codeapi.util$inferType(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.Function1((kotlin.String, kotlin.Boolean)))/type).

### Parameters

`type` - Type which have unresolved variable types. Example: `List<T>`

`parameterizedType` - Target class which have the type variables of [type](infer-type.md#com.github.jonathanxd.codeapi.util$inferType(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.Function1((kotlin.String, kotlin.Boolean)))/type).

`startingType` - Initial type of class hierarchy (in other words, the type which extends [parameterizedType](infer-type.md#com.github.jonathanxd.codeapi.util$inferType(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.Function1((kotlin.String, kotlin.Boolean)))/parameterizedType)
explicitly or implicitly).

`codeTypeResolver` - Type resolver which will get superclass and superinterfaces.

`genericResolver` - Resolver which will resolve generic types from [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html).

`filter` - Filter which determines type variables to be inferred. (True to infer, false to ignore).