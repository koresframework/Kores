[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [GenericType](../index.md) / [Bound](.)

# Bound

`abstract class Bound : Any`

Generic type bounds.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Bound(type: `[`CodeType`](../../-code-type/index.md)`)`<br>Generic type bounds. |

### Properties

| Name | Summary |
|---|---|
| [sign](sign.md) | `abstract val sign: String`<br>Symbol of this bound. |
| [type](type.md) | `val type: `[`CodeType`](../../-code-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `open fun hashCode(): Int` |

### Extension Functions

| Name | Summary |
|---|---|
| [toComponentString](../../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun Bound.toComponentString(): String`<br>Creates a string representation of components of GenericType.Bound. |

### Inheritors

| Name | Summary |
|---|---|
| [GenericBound](../-generic-bound/index.md) | `class GenericBound : Bound`<br>Bound to type. |
| [WildcardBound](../-wildcard-bound/index.md) | `abstract class WildcardBound : Bound`<br>Bound to wildcard. |
