[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [GenericAnnotatedCodeType](index.md) / [identification](.)

# identification

`val identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Overrides [CodeType.identification](../../-code-type/identification.md)

Overrides [GenericType.identification](../../-generic-type/identification.md)

Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../../-code-type/index.md).

