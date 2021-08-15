//[Kores](../../../index.md)/[com.koresframework.kores.inspect](../index.md)/[InstructionsInspectBuilder](index.md)

# InstructionsInspectBuilder

[jvm]\
class [InstructionsInspectBuilder](index.md)<[R](index.md)>

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>fun [build](build.md)(): [InstructionsInspect](../-instructions-inspect/index.md)<[R](index.md)><br>Builds a [InstructionsInspect](../-instructions-inspect/index.md) with current properties. |
| [find](find.md) | [jvm]<br>fun [find](find.md)(codePartPredicate: ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)><br>Sets the matcher of elements to collect. |
| [include](include.md) | [jvm]<br>fun [include](include.md)(predicate: ([BodyHolder](../../com.koresframework.kores.base/-body-holder/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)><br>Sets to include elements inside [BodyHolders](../../com.koresframework.kores.base/-body-holder/index.md) that matches the [predicate](include.md) in the inspection. |
| [includeRoot](include-root.md) | [jvm]<br>fun [includeRoot](include-root.md)(inspectRootInstructions: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)><br>Sets to include elements inside [Instructions](../../com.koresframework.kores/-instructions/index.md) passed to [InstructionsInspect.inspect](../-instructions-inspect/inspect.md) in the inspection. |
| [inside](inside.md) | [jvm]<br>fun [inside](inside.md)(predicate: ([BodyHolder](../../com.koresframework.kores.base/-body-holder/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)><br>Sets to inspect **only** elements inside [BodyHolders](../../com.koresframework.kores.base/-body-holder/index.md) that matches the [predicate](inside.md). |
| [inspect](inspect.md) | [jvm]<br>fun [inspect](inspect.md)(codeSource: [Instructions](../../com.koresframework.kores/-instructions/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)><br>fun [inspect](inspect.md)(codeSource: [Instructions](../../com.koresframework.kores/-instructions/index.md), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)><br>Calls [InstructionsInspect.inspect](../-instructions-inspect/inspect.md) |
| [mapTo](map-to.md) | [jvm]<br>fun <[V](map-to.md)> [mapTo](map-to.md)(mapper: ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [V](map-to.md)): [InstructionsInspectBuilder](index.md)<[V](map-to.md)><br>Sets the mapper function. |
| [stopWhen](stop-when.md) | [jvm]<br>fun [stopWhen](stop-when.md)(predicate: ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InstructionsInspectBuilder](index.md)<[R](index.md)><br>Sets predicate to test when to stop inspection. |
