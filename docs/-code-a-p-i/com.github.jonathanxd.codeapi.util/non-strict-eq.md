[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [nonStrictEq](.)

# nonStrictEq

`fun `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Boolean`

Non-strict generic equality check, only works for generic types.

This method will not make strict bound checks, it means that `List<?>` is equal to `List`,
`List<? extends Person>` is equal to `List<Person>`, but `List<Number>` is not equal to `List<Integer>`.

`fun `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`.nonStrictEq(other: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Boolean`

Non-strict generic bound equality check, only works for generic types.

This method will not make strict bound checks, it means that `List<?>` is equal to `List`,
`List<? extends Person>` is equal to `List<Person>`, but `List<Number>` is not equal to `List<Integer>`.

