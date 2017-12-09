[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [CodeTypeResolverFunc](.)

# CodeTypeResolverFunc

`abstract class CodeTypeResolverFunc : (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, Function<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CodeTypeResolverFunc()` |

### Functions

| Name | Summary |
|---|---|
| [apply](apply.md) | `open fun apply(t: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [invoke](invoke.md) | `open fun invoke(p1: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [resolve](resolve.md) | `abstract fun resolve(t: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [fromJavaFunction](from-java-function.md) | `fun fromJavaFunction(func: Function<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>): CodeTypeResolverFunc` |
| [fromKtFunction](from-kt-function.md) | `fun fromKtFunction(func: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): CodeTypeResolverFunc` |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
