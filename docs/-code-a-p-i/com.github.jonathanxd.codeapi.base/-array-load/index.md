[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArrayLoad](.)

# ArrayLoad

`data class ArrayLoad : `[`ArrayAccess`](../-array-access/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Loads a value of type [valueType](value-type.md) at [index](--index--.md) from array [target](target.md) of type [arrayType](array-type.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-array-access/-builder/index.md)`<ArrayLoad, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<ArrayLoad, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArrayLoad(arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, index: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`)`<br>Loads a value of type [valueType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayLoad$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type)/valueType) at [index](-init-.md#com.github.jonathanxd.codeapi.base.ArrayLoad$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type)/index) from array [target](-init-.md#com.github.jonathanxd.codeapi.base.ArrayLoad$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type)/target) of type [arrayType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayLoad$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type)/arrayType). |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `val arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [index](--index--.md) | `val index: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Index to access |
| [target](target.md) | `val target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Target array to access |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [valueType](value-type.md) | `val valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Type of value |

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
