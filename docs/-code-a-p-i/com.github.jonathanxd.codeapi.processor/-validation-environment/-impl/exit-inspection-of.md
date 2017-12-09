[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.processor](../../index.md) / [ValidationEnvironment](../index.md) / [Impl](index.md) / [exitInspectionOf](.)

# exitInspectionOf

`fun exitInspectionOf(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [ValidationEnvironment.exitInspectionOf](../exit-inspection-of.md)

Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part).

