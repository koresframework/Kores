//[Kores](../../index.md)/[com.github.jonathanxd.kores](index.md)/[find](find.md)

# find

[jvm]\
fun <[U](find.md)> [Instructions](-instructions/index.md).[find](find.md)(predicate: ([Instruction](-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), function: ([Instruction](-instruction/index.md)) -> [U](find.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[U](find.md)>

Find an element in a code source. (Highly recommended to use [InstructionsInspect](../com.github.jonathanxd.kores.inspect/-instructions-inspect/index.md) instead of this.

#### Return

List of mapped parts.

## Parameters

jvm

| | |
|---|---|
| predicate | Predicate. |
| function | Mapper. |
| U | Mapped return type. |
