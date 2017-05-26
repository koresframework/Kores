[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [CatchStatement](.)

# CatchStatement

`data class CatchStatement : `[`BodyHolder`](../-body-holder/index.md)`, `[`Typed`](../-typed/index.md)

Catch statement of a try block. Catch [exceptionTypes](exception-types.md) and store caught exception in [variable](variable.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-body-holder/-builder/index.md)`<CatchStatement, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<CatchStatement, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CatchStatement(exceptionTypes: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>, variable: `[`VariableDeclaration`](../-variable-declaration/index.md)`, body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`)`<br>Catch statement of a try block. Catch [exceptionTypes](-init-.md#com.github.jonathanxd.codeapi.base.CatchStatement$<init>(kotlin.collections.List((java.lang.reflect.Type)), com.github.jonathanxd.codeapi.base.VariableDeclaration, com.github.jonathanxd.codeapi.CodeSource)/exceptionTypes) and store caught exception in [variable](-init-.md#com.github.jonathanxd.codeapi.base.CatchStatement$<init>(kotlin.collections.List((java.lang.reflect.Type)), com.github.jonathanxd.codeapi.base.VariableDeclaration, com.github.jonathanxd.codeapi.CodeSource)/variable). |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body of exception handler. |
| [exceptionTypes](exception-types.md) | `val exceptionTypes: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Exception types to catch. |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variable](variable.md) | `val variable: `[`VariableDeclaration`](../-variable-declaration/index.md)<br>Variable to store exception. |

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
