[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [Internal](.)

# Internal

`object Internal : Any`

### Properties

| Name | Summary |
|---|---|
| [ANNOTATION](-a-n-n-o-t-a-t-i-o-n.md) | `val ANNOTATION: Int` |
| [BRIDGE](-b-r-i-d-g-e.md) | `val BRIDGE: Int` |
| [ENUM](-e-n-u-m.md) | `val ENUM: Int` |
| [MANDATED](-m-a-n-d-a-t-e-d.md) | `val MANDATED: Int` |
| [SYNTHETIC](-s-y-n-t-h-e-t-i-c.md) | `val SYNTHETIC: Int` |
| [VARARGS](-v-a-r-a-r-g-s.md) | `val VARARGS: Int` |

### Functions

| Name | Summary |
|---|---|
| [isAnnotation](is-annotation.md) | `fun isAnnotation(modifiers: Int): Boolean` |
| [isBridge](is-bridge.md) | `fun isBridge(modifiers: Int): Boolean` |
| [isEnum](is-enum.md) | `fun isEnum(modifiers: Int): Boolean` |
| [isMandated](is-mandated.md) | `fun isMandated(modifiers: Int): Boolean` |
| [isSynthetic](is-synthetic.md) | `fun isSynthetic(modifiers: Int): Boolean` |
| [isVarArgs](is-var-args.md) | `fun isVarArgs(modifiers: Int): Boolean` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
