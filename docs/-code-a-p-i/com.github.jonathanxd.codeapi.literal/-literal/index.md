[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.literal](../index.md) / [Literal](.)

# Literal

`abstract class Literal : `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, `[`Named`](../../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)

A JVM Literal.

Example of literals: Strings, Ints, Doubles, Longs, Types, etc.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Literal(name: String, type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`)``Literal(value: Any, name: String, type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`)`<br>A JVM Literal. |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `open val name: String`<br>Name |
| [type](type.md) | `open val type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Element type |
| [value](value.md) | `val value: Any` |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): Nothing`<br>This builder may or may not accept null values, it depends on implementation. |
| [toString](to-string.md) | `open fun toString(): String` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): Literal?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [BoolLiteral](../-literals/-bool-literal.md) | `class BoolLiteral : Literal` |
| [ByteLiteral](../-literals/-byte-literal.md) | `class ByteLiteral : Literal` |
| [CharLiteral](../-literals/-char-literal.md) | `class CharLiteral : Literal` |
| [ClassLiteral](../-literals/-class-literal.md) | `class ClassLiteral : Literal` |
| [DoubleLiteral](../-literals/-double-literal.md) | `class DoubleLiteral : Literal` |
| [FloatLiteral](../-literals/-float-literal.md) | `class FloatLiteral : Literal` |
| [IntLiteral](../-literals/-int-literal.md) | `class IntLiteral : Literal` |
| [LongLiteral](../-literals/-long-literal.md) | `class LongLiteral : Literal` |
| [ShortLiteral](../-literals/-short-literal.md) | `class ShortLiteral : Literal` |
| [Stack](../../com.github.jonathanxd.codeapi.util/-stack.md) | `object Stack : Literal`<br>Use JVM Stack value (is supported by `BytecodeGenerators`). |
| [StringLiteral](../-literals/-string-literal/index.md) | `class StringLiteral : Literal` |
