[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [Stack](.)

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

### Extension Functions

| Name | Summary |
|---|---|
| [asString](kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](get-part-type.md) | `fun `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](get-part-type-or-null.md) | `fun `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
