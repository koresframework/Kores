[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [MethodTypeSpec](.)

# MethodTypeSpec

`data class MethodTypeSpec : `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)`, Comparable<MethodTypeSpec>`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<MethodTypeSpec, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MethodTypeSpec(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, methodName: String, typeSpec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `val localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [methodName](method-name.md) | `val methodName: String` |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](type-spec.md) | `val typeSpec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | `operator fun compareTo(other: MethodTypeSpec): Int`<br>This method will not compare the method localization. |
| [toMethodString](to-method-string.md) | `fun toMethodString(): String`<br>Human readable method specification string. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toInvocation](../../com.github.jonathanxd.codeapi.util.conversion/to-invocation.md) | `fun MethodTypeSpec.toInvocation(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from MethodTypeSpec |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
