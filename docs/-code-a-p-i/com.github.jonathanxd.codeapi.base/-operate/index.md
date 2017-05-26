[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Operate](.)

# Operate

`data class Operate : `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Operate a value and return result of operation.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-value-holder/-builder/index.md)`<Operate, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<Operate, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Operate(target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, operation: `[`Math`](../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md)`, value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?)`<br>Operate a value and return result of operation. |

### Properties

| Name | Summary |
|---|---|
| [operation](operation.md) | `val operation: `[`Math`](../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md)<br>Operation. |
| [target](target.md) | `val target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Target part to operate. |
| [type](type.md) | `val type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Element type |
| [value](value.md) | `val value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`<br>Second argument of the operation. Some operations may not require a second argument, some can
behave different without them, example, if a second argument is provided for [Operators.SUBTRACT](../../com.github.jonathanxd.codeapi.operator/-operators/-s-u-b-t-r-a-c-t.md), the operation
will be `target-value`, otherwise the operation will be `-target` (or negative). |

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
