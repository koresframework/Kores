[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ArrayConstructor](.)

# ArrayConstructor

`data class ArrayConstructor : `[`ArgumentHolder`](../-argument-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Constructs an array of type [arrayType](array-type.md) with dimensions [dimensions](dimensions.md). Example:

`new ArrayConstructor(String.class, listOf(Literals.INT(5)), emptyList()) = new String[5]`
`new ArrayConstructor(String.class, listOf(Literals.INT(5), Literals.INT(9)), emptyList()) = new String[5][9]`

```
new ArrayConstructor(String.class, listOf(Literals.INT(3)), listOf(Literals.STRING("A"), Literals.STRING("B"), Literals.STRING("C"))) =
new String[] {"A", "B", "C"}
```

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-argument-holder/-builder/index.md)`<ArrayConstructor, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<ArrayConstructor, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArrayConstructor(arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, dimensions: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>, arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>)`<br>Constructs an array of type [arrayType](-init-.md#com.github.jonathanxd.codeapi.base.ArrayConstructor$<init>(java.lang.reflect.Type, kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)))/arrayType) with dimensions [dimensions](-init-.md#com.github.jonathanxd.codeapi.base.ArrayConstructor$<init>(java.lang.reflect.Type, kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)), kotlin.collections.List((com.github.jonathanxd.codeapi.CodePart)))/dimensions). Example: |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>Argument list |
| [array](array.md) | `val array: Boolean`<br>Array arguments |
| [arrayType](array-type.md) | `val arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [arrayValues](array-values.md) | `val arrayValues: List<`[`ArrayStore`](../-array-store/index.md)`>`<br>Array values |
| [dimensions](dimensions.md) | `val dimensions: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [types](types.md) | `val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

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
