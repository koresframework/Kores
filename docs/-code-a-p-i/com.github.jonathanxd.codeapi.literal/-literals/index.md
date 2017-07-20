[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.literal](../index.md) / [Literals](.)

# Literals

`object Literals : Any`

[Literals](../-literal/index.md) constants.

### Types

| Name | Summary |
|---|---|
| [BoolLiteral](-bool-literal.md) | `class BoolLiteral : `[`Literal`](../-literal/index.md) |
| [ByteLiteral](-byte-literal.md) | `class ByteLiteral : `[`Literal`](../-literal/index.md) |
| [CharLiteral](-char-literal.md) | `class CharLiteral : `[`Literal`](../-literal/index.md) |
| [ClassLiteral](-class-literal.md) | `class ClassLiteral : `[`Literal`](../-literal/index.md) |
| [DoubleLiteral](-double-literal.md) | `class DoubleLiteral : `[`Literal`](../-literal/index.md) |
| [FloatLiteral](-float-literal.md) | `class FloatLiteral : `[`Literal`](../-literal/index.md) |
| [IntLiteral](-int-literal.md) | `class IntLiteral : `[`Literal`](../-literal/index.md) |
| [LongLiteral](-long-literal.md) | `class LongLiteral : `[`Literal`](../-literal/index.md) |
| [ShortLiteral](-short-literal.md) | `class ShortLiteral : `[`Literal`](../-literal/index.md) |
| [StringLiteral](-string-literal/index.md) | `class StringLiteral : `[`Literal`](../-literal/index.md) |

### Properties

| Name | Summary |
|---|---|
| [FALSE](-f-a-l-s-e.md) | `val FALSE: `[`Literal`](../-literal/index.md) |
| [NULL](-n-u-l-l.md) | `val NULL: `[`Literal`](../-literal/index.md) |
| [TRUE](-t-r-u-e.md) | `val TRUE: `[`Literal`](../-literal/index.md) |

### Functions

| Name | Summary |
|---|---|
| [ARRAY](-a-r-r-a-y.md) | `fun ARRAY(other: `[`Literal`](../-literal/index.md)`, array: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`Literal`](../-literal/index.md) |
| [BOOLEAN](-b-o-o-l-e-a-n.md) | `fun BOOLEAN(b: Boolean): `[`Literal`](../-literal/index.md) |
| [BYTE](-b-y-t-e.md) | `fun BYTE(b: Byte): `[`Literal`](../-literal/index.md) |
| [CHAR](-c-h-a-r.md) | `fun CHAR(c: Char): `[`Literal`](../-literal/index.md) |
| [CLASS](-c-l-a-s-s.md) | `fun CLASS(aClass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): `[`Literal`](../-literal/index.md)<br>`fun CLASS(aClass: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`Literal`](../-literal/index.md) |
| [DOUBLE](-d-o-u-b-l-e.md) | `fun DOUBLE(d: Double): `[`Literal`](../-literal/index.md) |
| [FLOAT](-f-l-o-a-t.md) | `fun FLOAT(f: Float): `[`Literal`](../-literal/index.md) |
| [INT](-i-n-t.md) | `fun INT(i: Int): `[`Literal`](../-literal/index.md) |
| [LONG](-l-o-n-g.md) | `fun LONG(i: Long): `[`Literal`](../-literal/index.md) |
| [SHORT](-s-h-o-r-t.md) | `fun SHORT(s: Short): `[`Literal`](../-literal/index.md) |
| [STRING](-s-t-r-i-n-g.md) | `fun STRING(s: String): `[`Literal`](../-literal/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../-literal/index.md)`?`<br>Convert this value to a literal |
