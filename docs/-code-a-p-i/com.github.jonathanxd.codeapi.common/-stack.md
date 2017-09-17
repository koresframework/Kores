[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.common](index.md) / [Stack](.)

# Stack

`object Stack : `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)

Use JVM Stack value (is supported by `BytecodeGenerators`).

### Inherited Properties

| Name | Summary |
|---|---|
| [name](../com.github.jonathanxd.codeapi.literal/-literal/name.md) | `open val name: String`<br>Name |
| [type](../com.github.jonathanxd.codeapi.literal/-literal/type.md) | `open val type: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Element type |
| [value](../com.github.jonathanxd.codeapi.literal/-literal/value.md) | `val value: Any` |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../com.github.jonathanxd.codeapi.literal/-literal/builder.md) | `open fun builder(): Nothing`<br>This builder may or may not accept null values, it depends on implementation. |
| [toString](../com.github.jonathanxd.codeapi.literal/-literal/to-string.md) | `open fun toString(): String` |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [safeForComparison](../com.github.jonathanxd.codeapi.util/safe-for-comparison.md) | `val `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [invoke](../com.github.jonathanxd.codeapi.factory/invoke.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invoke(invokeType: `[`InvokeType`](../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [invokeIntToString](../com.github.jonathanxd.codeapi.helper/invoke-int-to-string.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokeInterface](../com.github.jonathanxd.codeapi.factory/invoke-interface.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeInterface(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [invokeToString](../com.github.jonathanxd.codeapi.helper/invoke-to-string.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
| [invokeVirtual](../com.github.jonathanxd.codeapi.factory/invoke-virtual.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeVirtual(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [toLiteral](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [unwrap](../com.github.jonathanxd.codeapi.util/unwrap.md) | `tailrec fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Unwraps [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |