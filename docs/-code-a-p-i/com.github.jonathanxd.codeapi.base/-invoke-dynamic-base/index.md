[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InvokeDynamicBase](.)

# InvokeDynamicBase

`interface InvokeDynamicBase : `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

A dynamic invocation of a method.

Note: this class does not extends [MethodInvocation](../-method-invocation/index.md) because it is not
a normal invocation.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : InvokeDynamicBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-typed/-builder/index.md)`<T, S>` |
| [LambdaLocalCodeBase](-lambda-local-code-base/index.md) | `interface LambdaLocalCodeBase : `[`LambdaMethodRefBase`](-lambda-method-ref-base/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)<br>Invocation of lambda function. |
| [LambdaMethodRefBase](-lambda-method-ref-base/index.md) | `interface LambdaMethodRefBase : InvokeDynamicBase`<br>Dynamic invocation of lambda method reference. |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `abstract val args: List<Any>`<br>Bootstrap method Arguments, must be an [String](#), [Int](#),
[Long](#), [Float](#), [Double](#), [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [bootstrap](bootstrap.md) | `abstract val bootstrap: `[`MethodInvokeSpec`](../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [invocation](invocation.md) | `abstract val invocation: `[`MethodInvocation`](../-method-invocation/index.md)<br>Invocation to handle dynamically. |
| [type](type.md) | `abstract val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<InvokeDynamicBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [safeForComparison](../../com.github.jonathanxd.codeapi.util/safe-for-comparison.md) | `val `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [invoke](../../com.github.jonathanxd.codeapi.factory/invoke.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invoke(invokeType: `[`InvokeType`](../-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [invokeIntToString](../../com.github.jonathanxd.codeapi.helper/invoke-int-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokeInterface](../../com.github.jonathanxd.codeapi.factory/invoke-interface.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeInterface(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [invokeToString](../../com.github.jonathanxd.codeapi.helper/invoke-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
| [invokeVirtual](../../com.github.jonathanxd.codeapi.factory/invoke-virtual.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeVirtual(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [unwrap](../../com.github.jonathanxd.codeapi.util/unwrap.md) | `tailrec fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Unwraps [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |

### Inheritors

| Name | Summary |
|---|---|
| [InvokeDynamic](../-invoke-dynamic/index.md) | `data class InvokeDynamic : InvokeDynamicBase` |
| [LambdaMethodRefBase](-lambda-method-ref-base/index.md) | `interface LambdaMethodRefBase : InvokeDynamicBase`<br>Dynamic invocation of lambda method reference. |
