[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InvokeDynamic](.)

# InvokeDynamic

`data class InvokeDynamic : InvokeDynamicBase`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : Builder<InvokeDynamic, `[`Builder`](-builder/index.md)`>` |
| [LambdaLocalCode](-lambda-local-code/index.md) | `data class LambdaLocalCode : LambdaLocalCodeBase` |
| [LambdaMethodRef](-lambda-method-ref/index.md) | `data class LambdaMethodRef : LambdaMethodRefBase` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `InvokeDynamic(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, bootstrap: `[`MethodInvokeSpec`](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`, invocation: `[`MethodInvocation`](../-method-invocation/index.md)`, args: List<Any>)` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `val args: List<Any>`<br>Bootstrap method Arguments, must be an [String](#), [Int](#),
[Long](#), [Float](#), [Double](#), [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [bootstrap](bootstrap.md) | `val bootstrap: `[`MethodInvokeSpec`](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [invocation](invocation.md) | `val invocation: `[`MethodInvocation`](../-method-invocation/index.md)<br>Invocation to handle dynamically. |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
