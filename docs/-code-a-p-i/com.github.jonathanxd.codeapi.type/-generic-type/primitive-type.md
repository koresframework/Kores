[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericType](index.md) / [primitiveType](.)

# primitiveType

`open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`

Overrides [CodeType.primitiveType](../-code-type/primitive-type.md)

Only determine the Primitive type if:

`isCodeType && bounds.isEmpty`

Because

`Integer<T>` is invalid and `List<T>` has no primitive types because List is not a wrapper type.

