[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArrayStore](.)

# ArrayStore

`data class ArrayStore : `[`ArrayAccess`](../-array-access/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Stores [value](value-to-store.md) of type [valueType](value-type.md) in array [target](target.md) of type [arrayType](array-type.md) at [index](--index--.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-array-access/-builder/index.md)`<ArrayStore, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-value-holder/-builder/index.md)`<ArrayStore, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArrayStore(arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, index: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, valueToStore: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`)`<br>Stores [value](-init-.md#com.github.jonathanxd.codeapi.base.ArrayStore$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction)/valueToStore) of type [valueType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayStore$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction)/valueType) in array [target](-init-.md#com.github.jonathanxd.codeapi.base.ArrayStore$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction)/target) of type [arrayType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayStore$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction)/arrayType) at [index](-init-.md#com.github.jonathanxd.codeapi.base.ArrayStore$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction)/index). |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `val arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [index](--index--.md) | `val index: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Index to access |
| [target](target.md) | `val target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Target array to access |
| [value](value.md) | `val value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value |
| [valueToStore](value-to-store.md) | `val valueToStore: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value to store |
| [valueType](value-type.md) | `val valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Type of value to store |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

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
