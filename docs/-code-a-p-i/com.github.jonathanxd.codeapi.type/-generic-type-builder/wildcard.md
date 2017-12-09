[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericTypeBuilder](index.md) / [wildcard](.)

# wildcard

`fun wildcard(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, `[`GenericTypeBuilder`](index.md)`>`

Overrides [Builder.wildcard](../-generic-type/-builder/wildcard.md)

See [T.isWildcard](#)

Defines as a wildcard type, this method is the same as calling `withName("*")`.

**Note: `withName("?")` is invalid because CodeAPI denotes wildcards with `*` instead of `?`**

This method will overwrite defined type and name.

