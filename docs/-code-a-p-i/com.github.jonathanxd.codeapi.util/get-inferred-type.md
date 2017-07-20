[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [getInferredType](.)

# getInferredType

`fun getInferredType(name: String, parameterizedType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, startingType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, codeTypeResolver: `[`CodeTypeResolver`](../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>, genericResolver: `[`GenericResolver`](-generic-resolver/index.md)`): List<`[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>`

See getInferredType below.

`fun getInferredType(name: String, parameterizedType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, startingType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, codeTypeResolver: `[`CodeTypeResolver`](../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>, genericResolver: `[`GenericResolver`](-generic-resolver/index.md)`, found: MutableList<`[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>): `[`State`](-state/index.md)

This function tries to find [name](get-inferred-type.md#com.github.jonathanxd.codeapi.util$getInferredType(kotlin.String, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.collections.MutableList((com.github.jonathanxd.codeapi.type.CodeType)))/name) in all possible types which inherits [parameterizedType](get-inferred-type.md#com.github.jonathanxd.codeapi.util$getInferredType(kotlin.String, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.collections.MutableList((com.github.jonathanxd.codeapi.type.CodeType)))/parameterizedType),
this function uses a defined [genericResolver](get-inferred-type.md#com.github.jonathanxd.codeapi.util$getInferredType(kotlin.String, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.collections.MutableList((com.github.jonathanxd.codeapi.type.CodeType)))/genericResolver) to resolve the [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) representation of a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html).

### Parameters

`name` - Type variable name.

`parameterizedType` - Target class which have the type variable [name](get-inferred-type.md#com.github.jonathanxd.codeapi.util$getInferredType(kotlin.String, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.collections.MutableList((com.github.jonathanxd.codeapi.type.CodeType)))/name).

`startingType` - Initial type of class hierarchy (in other words, the type which extends [parameterizedType](get-inferred-type.md#com.github.jonathanxd.codeapi.util$getInferredType(kotlin.String, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.collections.MutableList((com.github.jonathanxd.codeapi.type.CodeType)))/parameterizedType)
explicitly or implicitly).

`codeTypeResolver` - Resolver of super types. This resolver will be used also to resolve original types.

`genericResolver` - Resolver which will resolve generic types from [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html).

`found` - List which types should be added