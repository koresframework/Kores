//[Kores](../../index.md)/[com.koresframework.kores](index.md)/[insertBeforeOrStart](insert-before-or-start.md)

# insertBeforeOrStart

[jvm]\
fun [Instructions](-instructions/index.md).[insertBeforeOrStart](insert-before-or-start.md)(predicate: ([Instruction](-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](-instructions/index.md)): [MutableInstructions](-mutable-instructions/index.md)

Insert element toInsert in source before element determined by predicate or at start of source if not found.

#### Return

source

## Parameters

jvm

| | |
|---|---|
| predicate | Predicate to determine element |
| toInsert | Element to insert after element determined by predicate |
