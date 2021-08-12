//[Kores](../../../index.md)/[com.github.jonathanxd.kores.inspect](../index.md)/[InstructionsInspectBuilder](index.md)/[stopWhen](stop-when.md)

# stopWhen

[jvm]\
fun [stopWhen](stop-when.md)(predicate: ([KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)>

Sets predicate to test when to stop inspection. If [predicate](stop-when.md) returns true, the inspection stops, if return false, the inspection continues.
