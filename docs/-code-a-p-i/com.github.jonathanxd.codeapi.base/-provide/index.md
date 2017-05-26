[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Provide](.)

# Provide

`data class Provide : Any`

Provides [with](with.md) to service [service](service.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Provide(service: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, with: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`)`<br>Provides [with](-init-.md#com.github.jonathanxd.codeapi.base.Provide$<init>(java.lang.reflect.Type, java.lang.reflect.Type)/with) to service [service](-init-.md#com.github.jonathanxd.codeapi.base.Provide$<init>(java.lang.reflect.Type, java.lang.reflect.Type)/service). |

### Properties

| Name | Summary |
|---|---|
| [service](service.md) | `val service: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Service to provide implementation. |
| [with](with.md) | `val with: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Service implementation/provider. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
