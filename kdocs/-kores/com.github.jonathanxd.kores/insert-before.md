//[Kores](../../index.md)/[com.github.jonathanxd.kores](index.md)/[insertBefore](insert-before.md)

# insertBefore

[jvm]\
fun [Instructions](-instructions/index.md).[insertBefore](insert-before.md)(predicate: ([Instruction](-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](-instructions/index.md)): [MutableInstructions](-mutable-instructions/index.md)

Insert element toInsert in source before element determined by predicate

#### Return

source

## Parameters

jvm

| | |
|---|---|
| predicate | Predicate to determine element |
| toInsert | Element to insert before element determined by predicate |
