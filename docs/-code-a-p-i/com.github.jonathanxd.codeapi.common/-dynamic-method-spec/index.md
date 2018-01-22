[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [DynamicMethodSpec](.)

# DynamicMethodSpec

`data class DynamicMethodSpec : `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`Named`](../../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`ArgumentsHolder`](../../com.github.jonathanxd.codeapi.base/-arguments-holder/index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<DynamicMethodSpec, `[`Builder`](-builder/index.md)`>, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-named/-builder/index.md)`<DynamicMethodSpec, `[`Builder`](-builder/index.md)`>, `[`Builder`](../../com.github.jonathanxd.codeapi.base/-arguments-holder/-builder/index.md)`<DynamicMethodSpec, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DynamicMethodSpec(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, typeSpec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Arguments to pass to dynamic method. (may include the receiver). |
| [array](array.md) | `val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of dynamic method |
| [type](type.md) | `val type: Type`<br>Element type |
| [typeSpec](type-spec.md) | `val typeSpec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Signature of dynamic method. |
| [types](types.md) | `val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [invoke](invoke.md) | `operator fun invoke(bootstrap: `[`MethodInvokeSpec`](../-method-invoke-spec/index.md)`): `[`InvokeDynamic`](../../com.github.jonathanxd.codeapi.base/-invoke-dynamic/index.md)<br>Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses [bootstrap](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec)/bootstrap) to bind the invocation.`operator fun invoke(bootstrap: `[`MethodInvokeSpec`](../-method-invoke-spec/index.md)`, bootstrapArgs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): `[`InvokeDynamic`](../../com.github.jonathanxd.codeapi.base/-invoke-dynamic/index.md)<br>Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses [bootstrap](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec, kotlin.collections.List((kotlin.Any)))/bootstrap) (with [bootstrapArgs](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec, kotlin.collections.List((kotlin.Any)))/bootstrapArgs)) to bind the invocation. |
| [toMethodString](to-method-string.md) | `fun toMethodString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human readable method string. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
