[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Cast](.)

# Cast

`data class Cast : `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Value cast. Cast [castedPart](casted-part.md) of type [originalType](original-type.md) (null if unknown) to [targetType](target-type.md). Official
BytecodeGenerator uses the [originalType](original-type.md) to auto-box and auto-unbox the value.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-typed/-builder/index.md)`<Cast, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Cast(originalType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?, targetType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, castedPart: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`)`<br>Value cast. Cast [castedPart](-init-.md#com.github.jonathanxd.codeapi.base.Cast$<init>(java.lang.reflect.Type, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart)/castedPart) of type [originalType](-init-.md#com.github.jonathanxd.codeapi.base.Cast$<init>(java.lang.reflect.Type, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart)/originalType) (null if unknown) to [targetType](-init-.md#com.github.jonathanxd.codeapi.base.Cast$<init>(java.lang.reflect.Type, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart)/targetType). Official
BytecodeGenerator uses the [originalType](-init-.md#com.github.jonathanxd.codeapi.base.Cast$<init>(java.lang.reflect.Type, java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart)/originalType) to auto-box and auto-unbox the value. |

### Properties

| Name | Summary |
|---|---|
| [castedPart](casted-part.md) | `val castedPart: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Part to cast |
| [originalType](original-type.md) | `val originalType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Origin type |
| [targetType](target-type.md) | `val targetType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Target type |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

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
