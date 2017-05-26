[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspectBuilder](index.md) / [mapTo](.)

# mapTo

`fun <V> mapTo(mapper: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> V): `[`SourceInspectBuilder`](index.md)`<V>`

Sets the mapper function. Mapper function convert elements before its get consumed by a function.

Obs: This function does not return a new [SourceInspectBuilder](index.md), it only "unsafe cast" the current.

