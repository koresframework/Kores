[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [MethodInvokeSpec](.)

# MethodInvokeSpec

`data class MethodInvokeSpec : `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)`, Comparable<MethodInvokeSpec>`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<MethodInvokeSpec, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MethodInvokeSpec(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, methodTypeSpec: `[`MethodTypeSpec`](../-method-type-spec/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | `val invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | `val methodTypeSpec: `[`MethodTypeSpec`](../-method-type-spec/index.md) |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | `fun compareTo(other: MethodInvokeSpec): Int` |
| [toInvocationString](to-invocation-string.md) | `fun toInvocationString(): String`<br>Human readable method invocation string. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toInvocation](../../com.github.jonathanxd.codeapi.util.conversion/to-invocation.md) | `fun MethodInvokeSpec.toInvocation(target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Create [MethodInvocation](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md) from MethodInvokeSpec |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
