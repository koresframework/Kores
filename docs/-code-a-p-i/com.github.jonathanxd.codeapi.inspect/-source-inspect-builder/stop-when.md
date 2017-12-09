[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspectBuilder](index.md) / [stopWhen](.)

# stopWhen

`fun stopWhen(predicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`SourceInspectBuilder`](index.md)`<R>`

Sets predicate to test when to stop inspection. If [predicate](stop-when.md#com.github.jonathanxd.codeapi.inspect.SourceInspectBuilder$stopWhen(kotlin.Function1((com.github.jonathanxd.codeapi.CodePart, kotlin.Boolean)))/predicate) returns `true`, the inspection stops,
if return `false`, the inspection continues.

