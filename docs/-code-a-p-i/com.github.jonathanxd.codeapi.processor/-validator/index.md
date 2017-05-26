[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [Validator](.)

# Validator

`interface Validator<in P> : Any`

Custom validator

### Functions

| Name | Summary |
|---|---|
| [validate](validate.md) | `abstract fun validate(part: P, data: TypedData, codeValidator: `[`CodeValidator`](../-code-validator/index.md)`, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`): Unit`<br>Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.Validator$validate(com.github.jonathanxd.codeapi.processor.Validator.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.CodeValidator, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) and return a list of messages. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
