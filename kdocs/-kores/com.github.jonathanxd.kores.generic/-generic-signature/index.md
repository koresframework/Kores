//[Kores](../../../index.md)/[com.github.jonathanxd.kores.generic](../index.md)/[GenericSignature](index.md)

# GenericSignature

[jvm]\
class [GenericSignature](index.md)(**_types**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)>)

Hold information about generic signatures.

## Constructors

| | |
|---|---|
| [GenericSignature](-generic-signature.md) | [jvm]<br>fun [GenericSignature](-generic-signature.md)(_types: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [isEmpty](is-empty.md) | [jvm]<br>val [isEmpty](is-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this generic signature is empty (no types). |
| [isNotEmpty](is-not-empty.md) | [jvm]<br>val [isNotEmpty](is-not-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this generic signature is not empty. |
| [types](types.md) | [jvm]<br>val [types](types.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [GenericType](../../com.github.jonathanxd.kores.type/-generic-type/index.md)> |

## Extensions

| Name | Summary |
|---|---|
| [genericSignatureToDescriptor](../../com.github.jonathanxd.kores.util/generic-signature-to-descriptor.md) | [jvm]<br>fun [GenericSignature](index.md).[genericSignatureToDescriptor](../../com.github.jonathanxd.kores.util/generic-signature-to-descriptor.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a type descriptor from receiver signature |
| [toSourceString](../../com.github.jonathanxd.kores.util/to-source-string.md) | [jvm]<br>fun [GenericSignature](index.md).[toSourceString](../../com.github.jonathanxd.kores.util/to-source-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert generic signature to string. |
