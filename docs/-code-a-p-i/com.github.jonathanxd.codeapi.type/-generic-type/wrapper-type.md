[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericType](index.md) / [wrapperType](.)

# wrapperType

`open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`

Overrides [CodeType.wrapperType](../-code-type/wrapper-type.md)

Only determine the Wrapper type if:

`isCodeType && bounds.isEmpty`

Because `int<T>` is invalid.

