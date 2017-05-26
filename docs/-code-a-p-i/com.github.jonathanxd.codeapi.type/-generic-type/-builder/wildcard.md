[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [GenericType](../index.md) / [Builder](index.md) / [wildcard](.)

# wildcard

`abstract fun wildcard(): `[`Builder`](index.md)`<T, S>`

See [T.isWildcard](../is-wildcard.md)

Defines as a wildcard type, this method is the same as calling `withName("*")`.

**Note:`withName("?")`is invalid because CodeAPI denotes wildcards with`*`instead of`?`**

This method will overwrite defined type and name.

