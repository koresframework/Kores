[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ForStatement](.)

# ForStatement

`data class ForStatement : `[`IfExpressionHolder`](../-if-expression-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

For statement.

for(forInit; forExpression; forUpdate)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-if-expression-holder/-builder/index.md)`<ForStatement, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-body-holder/-builder/index.md)`<ForStatement, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ForStatement(forInit: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?, forExpression: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>, forUpdate: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?, body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`)`<br>For statement. |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body of for statement (ex: `println(i)`). |
| [expressions](expressions.md) | `val expressions: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>If expressions and operations |
| [forExpression](for-expression.md) | `val forExpression: List<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>For expression. See [IfExpressionHolder.expressions](../-if-expression-holder/expressions.md). (ex: `i < 10`) |
| [forInit](for-init.md) | `val forInit: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`<br>For initialization (ex: `int i = 0`). |
| [forUpdate](for-update.md) | `val forUpdate: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`<br>For update. (ex: `i++`) |

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
