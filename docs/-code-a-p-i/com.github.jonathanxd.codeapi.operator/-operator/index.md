[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.operator](../index.md) / [Operator](.)

# Operator

`sealed class Operator : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`Named`](../../com.github.jonathanxd.codeapi.base/-named/index.md)

Operator.

Example of operators: Increment, Decrement, Less_than, etc...

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-named/-builder/index.md)`<Operator, `[`Builder`](-builder/index.md)`>` |
| [Conditional](-conditional/index.md) | `class Conditional : Operator`<br>Conditional operator |
| [Math](-math/index.md) | `class Math : Operator`<br>Mathematical operator |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `open val name: String`<br>Name |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [toString](to-string.md) | `open fun toString(): String` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Conditional](-conditional/index.md) | `class Conditional : Operator`<br>Conditional operator |
| [Math](-math/index.md) | `class Math : Operator`<br>Mathematical operator |
