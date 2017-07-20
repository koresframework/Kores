[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [FieldAccess](.)

# FieldAccess

`data class FieldAccess : `[`Accessor`](../-accessor/index.md)`, `[`Typed`](../-typed/index.md)`, `[`Named`](../-named/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Access a field of type [type](type.md), name [name](name.md) in type [localization](localization.md) using [target](target.md) as instance (Use a [Access.Type.STATIC](#) to
static accesses).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-accessor/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-named/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FieldAccess(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String)`<br>Access a field of type [type](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, kotlin.String)/type), name [name](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, kotlin.String)/name) in type [localization](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, kotlin.String)/localization) using [target](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodeInstruction, java.lang.reflect.Type, kotlin.String)/target) as instance (Use a [Access.Type.STATIC](#) to
static accesses). |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `val localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [name](name.md) | `val name: String`<br>Name |
| [target](target.md) | `val target: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access target |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

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
