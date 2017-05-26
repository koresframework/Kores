[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Model](.)

# Model

`class Model : `[`CommonResolver`](../-common-resolver/index.md)`<`[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`>`

Resolver that resolves [CodeType](../../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Model(elements: `[`Elements`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/util/Elements.html)`)`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html) |

### Properties

| Name | Summary |
|---|---|
| [elements](elements.md) | `val elements: `[`Elements`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/util/Elements.html) |

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(codeType: `[`CodeType`](../../-code-type/index.md)`): `[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)<br>Resolver [codeType](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.Model$resolve(com.github.jonathanxd.codeapi.type.CodeType)/codeType) to [T](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getInterfaces](../-common-resolver/get-interfaces.md) | `open fun getInterfaces(codeType: `[`CodeType`](../../-code-type/index.md)`): List<`[`CodeType`](../../-code-type/index.md)`>`<br>Gets super interfaces of [codeType](../-common-resolver/get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(com.github.jonathanxd.codeapi.type.CodeType)/codeType). |
| [getSuperclass](../-common-resolver/get-superclass.md) | `open fun getSuperclass(codeType: `[`CodeType`](../../-code-type/index.md)`): `[`CodeType`](../../-code-type/index.md)`?`<br>Gets super classes of [codeType](../-common-resolver/get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(com.github.jonathanxd.codeapi.type.CodeType)/codeType) |
| [isAssignableFrom](../-common-resolver/is-assignable-from.md) | `open fun isAssignableFrom(codeType: `[`CodeType`](../../-code-type/index.md)`, from: `[`CodeType`](../../-code-type/index.md)`, resolverProvider: (`[`CodeType`](../../-code-type/index.md)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Checks if [codeType](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/codeType) is assignable [from](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
