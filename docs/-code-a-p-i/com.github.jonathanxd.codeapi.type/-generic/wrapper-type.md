[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [wrapperType](.)

# wrapperType

`val wrapperType: `[`CodeType`](../-code-type/index.md)`?`

Overrides [GenericType.wrapperType](../-generic-type/wrapper-type.md)

Only determine the Wrapper type if:

`isCodeType && bounds.isEmpty`

Because `int<T>` is invalid.

