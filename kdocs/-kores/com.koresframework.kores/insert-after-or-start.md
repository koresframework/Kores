//[Kores](../../index.md)/[com.koresframework.kores](index.md)/[insertAfterOrStart](insert-after-or-start.md)

# insertAfterOrStart

[jvm]\
fun [Instructions](-instructions/index.md).[insertAfterOrStart](insert-after-or-start.md)(predicate: ([Instruction](-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](-instructions/index.md)): [MutableInstructions](-mutable-instructions/index.md)

Insert element toInsert in source after element determined by predicate or at start of source if not found.

#### Return

source

## Parameters

jvm

| | |
|---|---|
| predicate | Predicate to determine element |
| toInsert | Element to insert after element determined by predicate |
