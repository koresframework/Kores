[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [InheritanceProvider](.)

# InheritanceProvider

`interface InheritanceProvider : Any`

Mixin interface, marks the element as a provider of superclass and superinterfaces for [CodeTypeResolvers](../-code-type-resolver/index.md).

### Properties

| Name | Summary |
|---|---|
| [superclass](superclass.md) | `abstract val superclass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Super class |
| [superinterfaces](superinterfaces.md) | `abstract val superinterfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Super interfaces |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [PlainCodeType](../-plain-code-type/index.md) | `open class PlainCodeType : `[`CodeType`](../-code-type/index.md)`, InheritanceProvider`<br>Plain string code type. |
