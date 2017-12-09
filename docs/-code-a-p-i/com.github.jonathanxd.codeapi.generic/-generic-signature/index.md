[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.generic](../index.md) / [GenericSignature](.)

# GenericSignature

`class GenericSignature`

Hold information about generic signatures.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericSignature(types_: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`>)`<br>Hold information about generic signatures. |

### Properties

| Name | Summary |
|---|---|
| [isEmpty](is-empty.md) | `val isEmpty: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this generic signature is empty (no types). |
| [isNotEmpty](is-not-empty.md) | `val isNotEmpty: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this generic signature is not empty. |
| [types](types.md) | `val types: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(vararg types: `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): GenericSignature`<br>Create generic signature. |
| [empty](empty.md) | `fun empty(): GenericSignature`<br>Empty generic signature. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [genericSignatureToDescriptor](../../com.github.jonathanxd.codeapi.util/generic-signature-to-descriptor.md) | `fun GenericSignature.genericSignatureToDescriptor(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a type descriptor from receiver signature |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toSourceString](../../com.github.jonathanxd.codeapi.util/to-source-string.md) | `fun GenericSignature.toSourceString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert generic signature to string. |
