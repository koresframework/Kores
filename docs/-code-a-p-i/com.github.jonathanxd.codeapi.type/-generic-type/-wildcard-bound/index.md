[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [GenericType](../index.md) / [WildcardBound](.)

# WildcardBound

`abstract class WildcardBound : `[`Bound`](../-bound/index.md)

Bound to wildcard.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WildcardBound(type: `[`CodeType`](../../-code-type/index.md)`)`<br>Bound to wildcard. |

### Inherited Properties

| Name | Summary |
|---|---|
| [sign](../-bound/sign.md) | `abstract val sign: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Symbol of this bound. |
| [type](../-bound/type.md) | `val type: `[`CodeType`](../../-code-type/index.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [equals](../-bound/equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-bound/hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [Extends](../-extends/index.md) | `class Extends : WildcardBound`<br>Bound to extends. |
| [Super](../-super/index.md) | `class Super : WildcardBound`<br>Bound to super type. |
