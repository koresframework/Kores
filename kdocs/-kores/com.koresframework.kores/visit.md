//[Kores](../../index.md)/[com.koresframework.kores](index.md)/[visit](visit.md)

# visit

[jvm]\
fun [Instructions](-instructions/index.md).[visit](visit.md)(consumer: ([Instruction](-instruction/index.md), [Location](-location/index.md), [MutableInstructions](-mutable-instructions/index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [MutableInstructions](-mutable-instructions/index.md)

Visit Code Source elements.

This method create a new [Instructions](-instructions/index.md) and add all elements from codeSource before and after visits each [KoresPart](-kores-part/index.md) of codeSource.

When visiting process finish, it will clear codeSource and add all elements from new [Instructions](-instructions/index.md)

#### Return

Result source.

## Parameters

jvm

| | |
|---|---|
| consumer | Consumer |
