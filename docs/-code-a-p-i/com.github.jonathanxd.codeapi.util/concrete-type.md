[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [concreteType](.)

# concreteType

`val `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.concreteType: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)

Gets the concrete type of [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md), if this is a [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../com.github.jonathanxd.codeapi.type/-generic-type/code-type.md).

Example: for `S extends List<String>`, it will return `List` (obs: the [GenericType.codeType](../com.github.jonathanxd.codeapi.type/-generic-type/code-type.md) of `S extends List<String>` is `List<String>`.

