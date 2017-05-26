[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [primitiveType](.)

# primitiveType

`val primitiveType: `[`CodeType`](../-code-type/index.md)`?`

Overrides [GenericType.primitiveType](../-generic-type/primitive-type.md)

Only determine the Primitive type if:

`isCodeType && bounds.isEmpty`

Because

`Integer<T>` is invalid and `List<T>` has no primitive types because List is not a wrapper type.

