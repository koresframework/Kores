//[Kores](../../../index.md)/[com.koresframework.kores.inspect](../index.md)/[InstructionsInspectBuilder](index.md)/[mapTo](map-to.md)

# mapTo

[jvm]\
fun <[V](map-to.md)> [mapTo](map-to.md)(mapper: ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [V](map-to.md)): [InstructionsInspectBuilder](index.md)<[V](map-to.md)>

Sets the mapper function. Mapper function convert elements before its get consumed by a function.

Obs: This function does not return a new [InstructionsInspectBuilder](index.md), it only "unsafe cast" the current.
